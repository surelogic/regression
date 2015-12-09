package testSpeso.scraping;

/**
 * @date : Apr 24,2014
 * @author : Vinoth Kumar Kannan
 */

//package com.speso.search.scraping.scrapers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.html.DomText;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
//import com.speso.search.scraping.items.ScrapeItem;
//import com.speso.search.scraping.utils.ImageUtils;
//import com.speso.search.scraping.utils.Log;

public class BMCScraper extends HtmlUnitWebScraper {
	public BMCScraper(Consumer<ScrapeItem> scrapeItems, String imageDir) {
		super(imageDir);
	}

	private static final Log _LOG = new Log(BMCScraper.class);
	private static final String _HOSPITAL_NAME = "BOSTON MEDICAL CENTER CORPORATION";
	private static final String _BASE_URL = "http://www.bmc.org/findaphysician/index.php";
	private static final String _SEARCH_URL_PATTERN = "http://www.bmc.org/findaphysician/index.php?q=";

	@Override
	public List<ScrapeItem> call() {
		StringBuilder tempBuilder = new StringBuilder();
		HtmlPage page = null;
		HtmlElement tempElement = null;
		List<ScrapeItem> scrapeItemList = new LinkedList<>();

		try {
			for(int ch='a'; ch<='z'; ch++) {
				page = fetchPage(_SEARCH_URL_PATTERN + Character.toString((char)ch), HttpMethod.GET, null);

				for(HtmlElement physicianAnchor : (List<HtmlElement>)page.getByXPath("//a[text()='detail']")) {
					try {
						page = fetchPage(page.getFullyQualifiedUrl(physicianAnchor.getAttribute("href")), HttpMethod.GET, null);
					} catch(FailingHttpStatusCodeException fhscex) {
						continue;
					}

					HtmlElement profileTable = (HtmlElement)page.getFirstByXPath("//table[2]");
					if(profileTable == null) {
						continue;
					}

					String physicianName = "";
					ScrapeItem item = new ScrapeItem(_HOSPITAL_NAME, _BASE_URL);

					tempElement = (HtmlElement)profileTable.getFirstByXPath(".//h3");
					if(tempElement != null) {
						physicianName = tempElement.asText();
						int index = physicianName.indexOf(',');
						if(index > 0) {
							item.setHonorifics(Arrays.asList(physicianName.substring(index + 1).trim().split(",+")));
							physicianName = physicianName.substring(0, index);
						}
						_LOG.info("### Physician : " + physicianName);
						item.setName(physicianName);
					}

					tempElement = (HtmlElement)profileTable.getFirstByXPath(".//td[contains(text(), 'Title') or contains(./p/text(), 'Title')]/following-sibling::td");
					if(tempElement != null) {
						item.setTitle(Collections.singletonList(tempElement.asText().trim()));
					}

					tempElement = (HtmlElement)profileTable.getFirstByXPath(".//td[contains(text(), 'Department') or contains(./p/text(), 'Department')]/following-sibling::td");
					if(tempElement != null) {
						item.setDepartment(tempElement.asText().replaceAll("\\s+", " ").trim());
					}

					tempElement = (HtmlElement)profileTable.getFirstByXPath(".//td[contains(text(), 'Medical School') or contains(./p/text(), 'Medical School')]/following-sibling::td");
					if(tempElement != null) {
						item.setMedSchool(tempElement.asText().trim());
					}

					tempElement = (HtmlElement)profileTable.getFirstByXPath(".//td[contains(text(), 'Residency') or contains(./p/text(), 'Residency')]/following-sibling::td");
					if(tempElement != null) {
						item.setResidencies(Arrays.asList(tempElement.asText().trim().split(";")));
					}

					tempElement = (HtmlElement)profileTable.getFirstByXPath(".//td[contains(text(), 'Post Residency') or contains(./p/text(), 'Post Residency')]/following-sibling::td");
					if(tempElement != null) {
						item.setPostGrads(Arrays.asList(tempElement.asText().trim().split(";")));
					}

					tempElement = (HtmlElement)profileTable.getFirstByXPath(".//td[contains(text(), 'Certification') or contains(./p/text(), 'Certification')]/following-sibling::td");
					if(tempElement != null) {
						item.setCertifications(Arrays.asList(tempElement.asText().trim().split(";|,")));
					}

					tempElement = (HtmlElement)profileTable.getFirstByXPath(".//td[contains(text(), 'Interest') or contains(./p/text(), 'Interest')]/following-sibling::td");
					if(tempElement != null) {
						item.setClinicalInterests(Arrays.asList(tempElement.asText().trim().split(";|,")));
					}

					tempElement = (HtmlElement)profileTable.getFirstByXPath(".//td[contains(text(), 'Language') or contains(./p/text(), 'Language')]/following-sibling::td");
					if(tempElement != null) {
						item.setLanguages(Collections.singletonList(tempElement.asText().trim()));
					}

					tempElement = (HtmlElement)profileTable.getFirstByXPath(".//td[contains(text(), 'Address') or contains(./p/text(), 'Address')]/following-sibling::td");
					if(tempElement != null) {
						String fax = null;
						List<String> phoneNumbers = new LinkedList<>();

						for(DomText addressLine : (List<DomText>)tempElement.getByXPath(".//text()[normalize-space()]")) {
							String addressLineText = addressLine.asText().trim();
							if(addressLineText.startsWith("Phone:")) {
								phoneNumbers.add(addressLineText.substring("Phone:".length()).trim());
							} else if(addressLineText.startsWith("Fax:")) {
								fax = addressLineText.substring("Fax:".length()).trim();
							} else {
								tempBuilder.append(addressLineText).append(", ");
							}
						}
						if(tempBuilder.length() > 0) {
							tempBuilder.setLength(tempBuilder.length() - 2);
						}

						if(phoneNumbers.size() > 0 || fax != null) {
							item.addAddressWithPhoneNumbers(tempBuilder.toString(), phoneNumbers, fax);
						} else {
							item.addAddress(tempBuilder.toString());
						}
						tempBuilder.setLength(0);
					}

					// additional information
					tempElement = (HtmlElement)profileTable.getFirstByXPath(".//td[contains(text(), 'Gender') or contains(./p/text(), 'Gender')]/following-sibling::td");
					if(tempElement != null) {
						item.addOther("Gender", Collections.singletonList(tempElement.asText().trim()));
					}

					// save profile image
					tempElement = (HtmlElement)profileTable.getFirstByXPath(".//img");
					if(tempElement != null) {
						try {
							URL imageURL = page.getFullyQualifiedUrl(tempElement.getAttribute("src"));
							String fileName = physicianName.replaceAll("[\\s\\.]+", "_") + ".jpg";
							//ImageUtils.saveImageToDisk(imageURL, new File(_IMG_DIR + fileName));
							item.setPictureUrl(fileName);
						} catch (IOException ioex) {
							_LOG.error("Unable to save image for Physician " + physicianName);
						}
					}

					scrapeItemList.add(item);
				}
			}
		} catch(Exception ex) {
			_LOG.fatal(ex);
		}

		return scrapeItemList;
	}
}
