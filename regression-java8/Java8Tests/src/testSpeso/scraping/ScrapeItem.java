package testSpeso.scraping;

//package com.speso.search.scraping.items;

import static java.util.Collections.emptyList;
//import static org.apache.commons.collections.CollectionUtils.isEqualCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;

/*
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;
import com.speso.experts.ExpertName;
import com.speso.experts.NameLogic;
*/

/**
 * An object for storage, organizations, and verification of physician data
 * scraped from hospital websites. Future versions of this object may implement
 * stronger content control and verification in the form of field checking.
 *
 * @version 1.2.1
 */
public class ScrapeItem {
	//private static final Function<String, ExpertName> nameLogic = new NameLogic();

	private final String hospitalName;
	private final String url;
	private String pictureFilePath;
	private String physicianName;
	private final List<String> honorifics = new ArrayList<>();
	private final List<String> specialties = new ArrayList<>();
	private String medSchool;
	private final List<String> residencies = new ArrayList<>();
	private String internship;
	private final List<String> postGrads = new ArrayList<>();
	private final List<String> clinicalInterests = new ArrayList<>();
	private final List<String> titles = new ArrayList<>();
	private String dept;
	private final List<String> certs = new ArrayList<>();
	private final List<String> insurances = new ArrayList<>();
	private String bio;
	private final List<ScrapeAddress> addresses = new ArrayList<>();
	// private final List<String> addresses = new ArrayList<>();
	// private final List<String> phoneNumbers = new ArrayList<>();
	// private String faxNumber;
	private final List<String> langs = new ArrayList<>();
	private String email;
	private final Map<String, List<String>> other = new HashMap<>();

	/**
	 * @param hospitalName
	 *            the name of the hospital
	 * @param url
	 *            the url from which this physician was scraped
	 */
	public ScrapeItem(final String hospitalName, final String url) {
		this.hospitalName = hospitalName;
		this.url = url;
	}

	/**
	 * @param pictureUrl
	 *            the file name of this physicians picture
	 */
	public void setPictureUrl(final String pictureUrl) {
		pictureFilePath = pictureUrl;
	}

	/**
	 * Required field.
	 *
	 * @param name
	 *            the name of the physician
	 */
	public void setName(final String name) {
		physicianName = name;
	}

	/**
	 * Required field.
	 *
	 * Use this method to provide medical specialties for this physician one at
	 * a time. To provide all specialties at once, use
	 * {@link #setSpecialties(Collection) setSpecialties}
	 *
	 *
	 * @param specialty
	 *            a medical specialty (e.g. "internal medicine",
	 *            "pulmonary care")
	 */
	public void addSpecialty(final String specialty) {
		specialties.add(specialty);
	}

	/**
	 * Required field.
	 *
	 * Use this method to provide all honorifics for this physician at once. To
	 * provide honorifics one at a time, use {@link #addSpecialty(String)
	 * addSpecialty}. This method will append to any that have already been
	 * provided.
	 *
	 * @param specialties
	 *            a list of medical specialties
	 */
	public void setSpecialties(final Collection<String> specialties) {
		this.specialties.addAll(specialties);
	}

	/**
	 * Use this method to provide honorifics for this physician one at a time.
	 * To provide all honorifics at once, use {@link #setHonorifics(Collection)
	 * setHonorifics}. This method will append to any that have already been
	 * provided.
	 *
	 * @param honorific
	 *            an honorific (e.g. "Ph.D.", "M.D.")
	 */
	public void addHonorific(final String honorific) {
		honorifics.add(NON_ALPHANUM_DASH.matcher(honorific.trim()).replaceAll(
				""));
	}

	/**
	 * Use this method to provide all honorifics for this physician at once. To
	 * provide honorifics one at a time, use {@link #addHonorific(String)
	 * addHonorific}. This method will append to any that have already been
	 * provided.
	 *
	 * @param honorifics
	 *            a list of honorifics.
	 */
	public void setHonorifics(final Collection<String> honorifics) {
		for (String honorific : honorifics) {
			addHonorific(honorific);
		}
	}

	private static final Pattern NON_ALPHANUM_DASH = Pattern
			.compile("[^A-Za-z0-9-/]");

	/**
	 * @param medSchool
	 *            the name of this physician's medical school
	 */
	public void setMedSchool(final String medSchool) {
		this.medSchool = medSchool;
	}

	/**
	 * Use this method to provide all residencies for this physician at once. To
	 * provide honorifics one at a time, use {@link #addResidency(String)
	 * addResidency}. This method will append to any that have already been
	 * provided.
	 *
	 * @param residencies
	 *            a collection of this physician's residencies
	 */
	public void setResidencies(final Collection<String> residencies) {
		this.residencies.addAll(residencies);
	}

	/**
	 * @param residency
	 *            the name of this physician's residency
	 */
	public void addResidency(final String residency) {
		residencies.add(residency);
	}

	/**
	 * @param internship
	 *            the name of this physician's internship
	 */
	public void setInternship(final String internship) {
		this.internship = internship;
	}

	/**
	 * Use this method to provide all post-graduate institutions for this
	 * physician at once. To provide post-grads one at a time, use
	 * {@link #addPostGrad(String) addPostGrad}. This method will append to any
	 * that have already been provided.
	 *
	 * @param postGrads
	 *            a collection of this physician's post-graduate institutions
	 */
	public void setPostGrads(final Collection<String> postGrads) {
		this.postGrads.addAll(postGrads);
	}

	/**
	 * @param postGrad
	 *            the name(s) of physician's post-graduate school and/or
	 *            fellowship
	 */
	public void addPostGrad(final String postGrad) {
		postGrads.add(postGrad);
	}

	/**
	 * Use this method to add this physician's clinical interests one at a time.
	 * To provide all the clinical interests at once, use
	 * {@link #setClinicalInterests(Collection) setClinicalInterests}
	 *
	 * @param clinicalInterest
	 *            the clinical interest to add
	 */
	public void addClinicalInterest(final String clinicalInterest) {
		clinicalInterests.add(clinicalInterest);
	}

	/**
	 * Use this method to provide all of the physician's clinical interest at
	 * once. To provide clinical interests one at a time, use
	 * {@link #addClinicalInterest(String) addClinicalInterest}. This method
	 * will append to any that have already been provided.
	 *
	 * @param clinicalInterests
	 *            a list of all this physician's clinical interests
	 */
	public void setClinicalInterests(final Collection<String> clinicalInterests) {
		this.clinicalInterests.addAll(clinicalInterests);
	}

	/**
	 * As a physician may have multiple job and faculty titles, please use
	 * {@link #addTitle(String) addTitle}
	 *
	 * @param title
	 *            the physician's title (e.g. "Head of Pediatrics")
	 */
	public void setTitle(final Collection<String> titles) {
		this.titles.addAll(titles);
	}

	/**
	 * @param the
	 *            physician's job title or faculty title
	 */
	public void addTitle(final String title) {
		titles.add(title);
	}

	/**
	 * @param dept
	 *            the physician's department (e.g. "Surgery",
	 *            "Cardiovascular Unit")
	 */
	public void setDepartment(final String dept) {
		this.dept = dept;
	}

	/**
	 * Use this method to provide this physician's certifications one at a time.
	 * To provide all certifications at once, use
	 * {@link #setCertifications(Collection) setCertifications}. This method
	 * will append to any that have already been provided.
	 *
	 * @param cert
	 *            a certification this physician has
	 */
	public void addCertification(final String cert) {
		certs.add(cert);
	}

	/**
	 * Use this method to provide all of the physician's certifications at once.
	 * To provide certifications one at a time, use
	 * {@link #addCertification(String) addCertification}. This method will
	 * append to any that have already been provided.
	 *
	 * @param certs
	 *            a list of this physician's certifications
	 */
	public void setCertifications(final Collection<String> certs) {
		this.certs.addAll(certs);
	}

	/**
	 * Use this method to provide this physician's accepted insurances one at a
	 * time. To provide all of the insurances at once, use
	 * {@link #setInsurances(Collection) setInsurances}
	 *
	 * @param insurance
	 *            an insurance that this physician accepts
	 */
	public void addInsurance(final String insurance) {
		insurances.add(insurance);
	}

	/**
	 * Use this to provide all of the physician's accepted insurances at once.
	 * To provide insurances one at a time, use {@link #addInsurance(String)
	 * addInsurance}. This method will append to any that have already been
	 * provided.
	 *
	 * @param insurances
	 *            the insurances to set
	 */
	public void setInsurances(final Collection<String> insurances) {
		this.insurances.addAll(insurances);
	}

	/**
	 * @param bio
	 *            the physician's biography
	 */
	public void setBiography(final String bio) {
		this.bio = bio;
	}

	/**
	 * @param email
	 *            the physician's email address
	 */
	public void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * Preserves the relationship between an address, phone numbers, and a fax
	 * number. This is an acceptable substitute for {@link #addAddress(String)
	 * addAddress} and {@link #addPhoneNumber(String) addPhoneNumber} by passing
	 * null for the parameters with no values.
	 *
	 * @param address
	 *            an address for the physician
	 * @param phones
	 *            the phone numbers for the address
	 * @param fax
	 *            the fax number for the address
	 */
	public void addAddressWithPhoneNumbers(final String address,
			final Collection<String> phones,
			final String fax) {
		addresses.add(new ScrapeAddress(address, phones, fax));
	}

	/**
	 * Takes a collection of addresses that do not have any associated phone
	 * numbers.
	 *
	 * Adds an address that does not have a phone number. If the address has a
	 * phone number, {@link #addAddressAndPhoneNumbers(String, List, String)}
	 * should be used.
	 *
	 * @param address
	 *            an address for the physician
	 */
	public void addAddress(final String address) {
		addresses.add(new ScrapeAddress(address, emptyList(), null));
	}

	/**
	 * @param addresses
	 *            a collection of addresses
	 */
	public void setAddresses(final Collection<String> addresses) {
		for (final String a : addresses) {
			addAddress(a);
		}
	}

	/**
	 * Adds a phone number that does not have an address. If the number has an
	 * address, {@link #addAddressAndPhoneNumbers(String, List, String)} should
	 * be used.
	 *
	 * @param phone
	 *            a phone number for the physician
	 */
	public void addPhoneNumber(final String phone) {
		addresses.add(new ScrapeAddress(null, phone, null));
	}

	/**
	 * Takes a collection of phone numbers that do not have associated
	 * addresses.
	 *
	 * Use this to provide all of the physician's phone numbers at once. To
	 * provide phone numbers one at a time, use {@link #addPhoneNumber(String)
	 * addPhoneNumber}. This method will append to any that have already been
	 * provided.
	 *
	 * @param phone
	 *            the phone number to set
	 */
	public void setPhoneNumbers(final Collection<String> phones) {
		addresses.add(new ScrapeAddress(null, phones, null));
	}

	/**
	 * @param fax
	 *            the fax number to set
	 */
	public void setFaxNumber(final String fax) {
		addresses.add(new ScrapeAddress(null, emptyList(), fax));
	}

	/**
	 * @param language
	 *            a language the physician speaks
	 */
	public void addLanguage(final String language) {
		langs.add(language);
	}

	/**
	 * Use this to provide all of the physician's languages at once. To provide
	 * languages one at a time, use {@link #addLanguage(String) addLanguage}.
	 * This method will append to any that have already been provided.
	 *
	 * @param languages
	 *            a collection of languages the physician speaks
	 */
	public void setLanguages(final Collection<String> languages) {
		langs.addAll(languages);
	}

	/**
	 * Use this method to add any information the website provides that this
	 * object does not have a method for adding.
	 *
	 * @param field
	 *            the type of information
	 * @param values
	 *            a list of the values for the given field
	 */
	public void addOther(final String field, final List<String> values) {
		other.put(field, values);
	}

	/**
	 * Verifies that all critical fields have been provided a value.
	 *
	 * @return true if all critical fields have been filled with a non-empty
	 *         string, else returns false.
	 */
	public boolean validate() {
		if (hospitalName == null || "".equals(hospitalName)) return false;
		if (url == null || "".equals(url)) return false;
		if (physicianName == null || "".equals(physicianName)) return false;
		if (email != null) {
			if (!email.contains("@") ||!email.contains(".")) return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ScrapeItem [hospitalName=" + hospitalName + ", url=" + url
				+ ", pictureFilePath=" + pictureFilePath + ", physicianName="
				+ physicianName + ", honorifics=" + honorifics
				+ ", specialties=" + specialties + ", medSchool=" + medSchool
				+ ", residencies=" + residencies + ", internship=" + internship
				+ ", postGrads=" + postGrads + ", clinicalInterests="
				+ clinicalInterests + ", titles=" + titles + ", dept=" + dept
				+ ", certs=" + certs + ", insurances=" + insurances + ", bio="
				+ bio + ", addresses=" + addresses + ", langs=" + langs
				+ ", email=" + email + ", other=" + other + "]";
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public String getUrl() {
		return url;
	}

	public String getPictureUrl() {
		return pictureFilePath;
	}

	public String getPhysicianName() {
		return physicianName;
	}

	public List<String> getHonorifics() {
		return honorifics;
	}

	public List<String> getSpecialties() {
		return specialties;
	}

	public String getMedSchool() {
		return medSchool;
	}

	public List<String> getResidencies() {
		return residencies;
	}

	public String getInternship() {
		return internship;
	}

	public List<String> getPostGrads() {
		return postGrads;
	}

	public List<String> getClinicalInterests() {
		return clinicalInterests;
	}

	public List<String> getTitles() {
		return titles;
	}

	public String getDept() {
		return dept;
	}

	public List<String> getCerts() {
		return certs;
	}

	public List<String> getInsurances() {
		return insurances;
	}

	public String getBio() {
		return bio;
	}

	public List<ScrapeAddress> getAddresses() {
		return addresses;
	}

	public String getEmail() {
		return email;
	}

	public List<String> getLangs() {
		return langs;
	}

	public Map<String, List<String>> getOther() {
		return other;
	}

	/**
	 * Calculates the expert name every time
	 *
	 * @return the ExpertName created from this object's name
	 */
	/*
	public ExpertName getExpertName() {
		return nameLogic.apply(Strings.nullToEmpty(physicianName));
	}
	*/

	/**
	 * Maintains a relationship between and address and its related contact
	 * numbers.
	 */
	private static class ScrapeAddress {
		private final String address;
		private final List<String> phoneNumbers = new ArrayList<>();
		private final String faxNumber;

		ScrapeAddress(final String address, final Collection<String> phones, final String fax) {
			this.address = address;
			phoneNumbers.addAll(phones);
			faxNumber = fax;
		}

		ScrapeAddress(final String address, final String phone, final String fax) {
			this.address = address;
			phoneNumbers.add(phone);
			faxNumber = fax;
		}

		String getAddress() {
			return address;
		}

		List<String> getPhones() {
			return phoneNumbers;
		}

		String getFax() {
			return faxNumber;
		}

		@Override
		public String toString() {
			return "ScrapeAddress [address=" + address + ", phones=" + phoneNumbers
					+ ", fax=" + faxNumber + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ (address == null ? 0 : address.hashCode());
			result = prime * result
					+ (faxNumber == null ? 0 : faxNumber.hashCode());
			result = prime * result
					+ (phoneNumbers == null ? 0 : phoneNumbers.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			return true;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (addresses == null ? 0 : addresses.hashCode());
		result = prime * result + (bio == null ? 0 : bio.hashCode());
		result = prime * result + (certs == null ? 0 : certs.hashCode());
		result = prime
				* result
				+ (clinicalInterests == null ? 0 : clinicalInterests.hashCode());
		result = prime * result + (dept == null ? 0 : dept.hashCode());
		result = prime * result + (email == null ? 0 : email.hashCode());
		result = prime * result
				+ (honorifics == null ? 0 : honorifics.hashCode());
		result = prime * result
				+ (hospitalName == null ? 0 : hospitalName.hashCode());
		result = prime * result
				+ (insurances == null ? 0 : insurances.hashCode());
		result = prime * result
				+ (internship == null ? 0 : internship.hashCode());
		result = prime * result + (langs == null ? 0 : langs.hashCode());
		result = prime * result
				+ (medSchool == null ? 0 : medSchool.hashCode());
		result = prime * result + (other == null ? 0 : other.hashCode());
		result = prime * result
				+ (physicianName == null ? 0 : physicianName.hashCode());
		result = prime * result
				+ (pictureFilePath == null ? 0 : pictureFilePath.hashCode());
		result = prime * result
				+ (postGrads == null ? 0 : postGrads.hashCode());
		result = prime * result
				+ (residencies == null ? 0 : residencies.hashCode());
		result = prime * result
				+ (specialties == null ? 0 : specialties.hashCode());
		result = prime * result + (titles == null ? 0 : titles.hashCode());
		result = prime * result + (url == null ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}
}

