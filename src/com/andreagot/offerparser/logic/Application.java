package com.andreagot.offerparser.logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Application {

	public static void main(String[] args) {
		// URL url = new
		// URL("https://www.magiccorner.it//it/info-prodotto/284/1078/112556/luna-spettrale-gisela-the-broken-blade-brisela-voice-of-nightmares");
		// BufferedReader reader = new BufferedReader(new
		// InputStreamReader(url.openStream(), "UTF-8"));
		// for (String line; (line = reader.readLine()) != null;) {
		// System.out.println(line);
		// }
		String baseUrl = "https://www.magiccorner.it//it/info-prodotto/284/278/";
		int rangeMin = 46162;
		int rangeMax = 70561;
		for (int i = rangeMin; i <= rangeMax; i++) {
			try {
				Document doc = Jsoup.connect(baseUrl + Integer.toString(i)).get();
				String title = doc.title();
				if(i == rangeMin || i== rangeMax) {
					System.out.println(System.currentTimeMillis());
				}

				// Cerco se la pagina ha delle offerte
				if (doc.getElementsByClass("badge-red").isEmpty()) {
//					System.out.println("NO OFFERS for " + title);
					continue;
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

						System.out.println(sb.toString());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
		}
	}
}
