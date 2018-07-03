package com.andreagot.offerparser.favourites;

import com.andreagot.offerparser.interfaces.Favourite;

public class FavouritesFunctions implements Favourite {
	public boolean addFavourite() {
		return addFavourite("favourites.txt");
	}

	public boolean addFavourite(String path) {
		return true;
	}

	public boolean removeFavourite() {
		return removeFavourite("favourites.txt");
	}

	public boolean removeFavourite(String path) {
		return true;
	}
}
