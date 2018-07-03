package com.andreagot.offerparser.logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.andreagot.offerparser.favourites.FavouritesFunctions;
import com.andreagot.offerparser.parser.ParsingFunctions;

public class Application {

	public static void main(String[] args) {
		FavouritesFunctions ff = new FavouritesFunctions();
		ParsingFunctions pa = new ParsingFunctions();

		if (args.length == 0) {
			System.out.println("Please select: \n Pr (Parse offers by range), \n Pf (Parse offers by favourite file ) \n A (Add favourite) \n R (Remove Favourite)!");
			return;
		}
		
		if(args.length == 1) {
			System.out.println("How to use this application:");
			System.out.println("First parameter: Pr (Parse offers by range), Pf (Parse offers by favourite file) A (Add favourite) or R (Remove Favourite)");
			System.out.println("");
			System.out.println("Pr needs 3 parameters: URL, minRange, maxRange");
			System.out.println("Pr needs 1 parameter: URL, [File]");
			System.out.println("A needs 2 parameters: [File] and Favourite to add");
			System.out.println("R needs 2 parameters: [File] and Favourite to remove");
		}

		switch (args[0]) {
		case "P":
			String baseUrl = args[1];
			int rangeMin = 46162;
			int rangeMax = 70561;
			pa.parsePrices(baseUrl, rangeMin, rangeMax);
			break;
		case "A":
			if (args.length > 2) {
				ff.addFavourite(args[2]);
			}
			break;
		case "R":
			ff.removeFavourite(args[2]);
			break;
		}
		return;
	}
}
