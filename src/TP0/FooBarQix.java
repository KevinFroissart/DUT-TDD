package TP0;

public class FooBarQix {
	public static String intToString (Integer entry) {
		if(entry%3 == 0) return "Foo";
		if(entry%5 == 0) return "Bar";
		if(entry%7 == 0) return "Qix";
		return "1";
	}
}