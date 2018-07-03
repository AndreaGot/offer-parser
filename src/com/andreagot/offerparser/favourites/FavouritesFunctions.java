package com.andreagot.offerparser.favourites;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

import com.andreagot.offerparser.interfaces.Favourite;

public class FavouritesFunctions implements Favourite {
	public boolean addFavourite(String favourite) {
		return addFavourite("favourites.txt", favourite);
	}

	public boolean addFavourite(String path, String favourite) {
		try {
			List<String> lines = Arrays.asList(favourite);
			Path file = Paths.get("resources/" + path);
			// Files.write(file, lines, Charset.forName("UTF-8"));
			Files.write(file, lines, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean removeFavourite(String favourite) {
		return removeFavourite("favourites.txt");
	}

	public boolean removeFavourite(String path, String favourite) {

		return true;
	}
}
