package TP3;

import java.util.HashMap;
import java.util.Map;

public class Dictionnary {

private Map<String, String> dictionnary;
	
	public Dictionnary() {
		dictionnary = new HashMap<>();
		dictionnary.put("0", "");
		dictionnary.put("1", "Un");
		dictionnary.put("2", "Deux");
		dictionnary.put("3", "Trois");
		dictionnary.put("4", "Quatre");
		dictionnary.put("5", "Cinq");
		dictionnary.put("6", "Six");
		dictionnary.put("7", "Sept");
		dictionnary.put("8", "Huit");
		dictionnary.put("9", "Neuf");
		dictionnary.put("10", "Dix");
		dictionnary.put("11", "Onze");
		dictionnary.put("12", "Douze");
		dictionnary.put("13", "Treize");
		dictionnary.put("14", "Quatorze");
		dictionnary.put("15", "Quinze");
		dictionnary.put("16", "Seize");
		dictionnary.put("20", "Vingt");
		dictionnary.put("30", "Trente");
		dictionnary.put("40", "Quarante");
		dictionnary.put("50", "Cinquante");
		dictionnary.put("60", "Soixante");
		dictionnary.put("70", "Soixante");
		dictionnary.put("80", "Quatre-vingt");
		dictionnary.put("90", "Quatre-vingt");
		dictionnary.put("100", "Cent");
	}
	
	public String get(String number) {
    	return dictionnary.get(number);
    }
}