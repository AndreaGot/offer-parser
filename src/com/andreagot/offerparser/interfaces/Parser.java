package com.andreagot.offerparser.interfaces;

import java.util.HashSet;

public interface Parser {
	public void parsePrices(String baseUrl, int min, int max); 
	public String parseSinglePrice(String url);
	
	public void parsePricesByFile(String baseUrl, String file);
	
	
}
