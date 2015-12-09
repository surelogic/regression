package testSpeso.scraping;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.Callable;

import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.Page;

public abstract class HtmlUnitWebScraper implements Callable<List<ScrapeItem>> {

	public HtmlUnitWebScraper(String imageDir) {
		// TODO Auto-generated constructor stub
	}

	public <P extends Page> P fetchPage(String url, HttpMethod method,
			String query) throws IOException {
		return null;
	}
	
	public <P extends Page> P fetchPage(URL url, HttpMethod method, String query)
			throws IOException {
		return null;
	}
}
