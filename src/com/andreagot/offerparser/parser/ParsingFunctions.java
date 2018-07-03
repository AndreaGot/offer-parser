package com.andreagot.offerparser.parser;

import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.andreagot.offerparser.interfaces.Parser;

public class ParsingFunctions implements Parser {

	public void parsePrices(String baseUrl, int min, int max) {
		HashSet<String> doubleOffers = new HashSet<String>();
		for (int i = min; i <= max; i++) {
			if (i == min || i == max) {
				System.out.println(System.currentTimeMillis());
			}
			String message = parseSinglePrice(baseUrl + Integer.toString(i));

			// If there is a duplicate message, the offer has been already
			// printed
			if (message != null && !message.isEmpty() && doubleOffers.add(message)) {
				System.out.println(message);
			}

		}
	}

	public String parseSinglePrice(String url) {
		try {
			Document doc = Jsoup.connect(url).get();
			String title = doc.title();

			// Cerco se la pagina ha delle offerte
			if (doc.getElementsByClass("badge-red").isEmpty()) {
				// System.out.println("NO OFFERS for " + title);
				return null;
			}

			Elements tableRows = doc.select("tr");
			for (Element tableRow : tableRows) {
				Elements offers = tableRow.getElementsByClass("badge-red");
				StringBuilder sb = new StringBuilder(title);
				if (!offers.isEmpty()) {
					sb.append(" - ");
					sb.append(tableRow.getElementsByClass("label-lingua").get(0).text());
					if (!tableRow.getElementsByClass("label-foil").isEmpty()) {
						sb.append(" - ");
						sb.append(tableRow.getElementsByClass("label-foil").get(0).text());
					}
					sb.append(" - ");
					sb.append(tableRow.getElementsByClass("label-1093").get(0).text());
					sb.append(" - ");
					sb.append(offers.get(0).text());
					return sb.toString();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return null;
	}

	@Override
	public void parsePricesByFile(String baseUrl, String file) {
		//Finchè leggo file, allora lancio l'elaborazone singola.
		
	}
}
