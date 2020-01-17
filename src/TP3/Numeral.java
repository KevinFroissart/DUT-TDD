package TP3;

public class Numeral {
	private String number;
	private Dictionnary dictionnary;

	public Numeral(String number) {
		this.number = number.trim();
		this.dictionnary = new Dictionnary();
	}

	public String toLetters () { 
		String result = "";
		int toInteger = Integer.parseInt(number);

		if(toInteger <= 16) result = dictionnary.get(number);
		else if(toInteger < 100) result = extractTens(number);
		else if(toInteger < 1000) result = extractHundreds(number);
		return result;
	}

	public String extractTens(String number) {
		int firstNumber = Integer.parseInt(number.charAt(0) + "0");
		int secondNumber = Integer.parseInt(number) - firstNumber;
		
		String separator = (secondNumber == 1) ? " et " : "-";
		
		if(firstNumber == 70 || firstNumber == 90) secondNumber += 10;

		return dictionnary.get("" + firstNumber) + separator + new Numeral("" + secondNumber).toLetters().toLowerCase();
	}
	
	private String extractHundreds(String number) {
		int firstNumber = Integer.parseInt(number.charAt(0) + "00");
		int secondNumber =  Integer.parseInt(number) - firstNumber;
		firstNumber /= 100;	
		
		String cent = (firstNumber > 1) ? (secondNumber <= 0) ? " " + dictionnary.get("100").toLowerCase() + "s" : " "  + dictionnary.get("100").toLowerCase() : dictionnary.get("100");
		if(firstNumber <= 1) firstNumber = 0;
		String separator = (secondNumber > 1)? " " : "";
		
		return dictionnary.get("" + firstNumber) + cent + separator + new Numeral("" + secondNumber).toLetters().toLowerCase();
	}
}