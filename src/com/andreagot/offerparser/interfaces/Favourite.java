package com.andreagot.offerparser.interfaces;

public interface Favourite {
	public boolean addFavourite(String favourite);

	public boolean addFavourite(String path, String favourite);

	public boolean removeFavourite(String favourite);

	public boolean removeFavourite(String path, String favourite);

}
