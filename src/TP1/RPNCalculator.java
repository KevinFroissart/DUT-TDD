package TP1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BinaryOperator;


public class RPNCalculator {

	private static final Map<String, BinaryOperator<Double>> operators = new HashMap<>();
	static {
		operators.put("+", (l,r) -> l+r);
		operators.put("-", (l,r) -> l-r);
		operators.put("*", (l,r) -> l*r);
		operators.put("/", (l,r) -> l/r);
	}

	public static double eval(String expression) {
		String[] split = expression.split(" ");
		Stack<Double> operandes = new Stack<>();

		for(String splits : split) {
			if(nombre(splits))
				operandes.add(Double.parseDouble(splits));
			else
			if(splits.equals("SQRT"))
				operandes.add(Math.sqrt(operandes.pop()));
			else
				operandes.add(operation(operandes.pop(), operandes.pop(), splits));
		}

		return operandes.pop();
	}

	private static boolean nombre(String eval) {
		int compteurCaractere = 0;
		while(compteurCaractere < eval.length() && eval.charAt(compteurCaractere) != ' ') {
			if((eval.charAt(compteurCaractere) < '0' || eval.charAt(compteurCaractere) > '9') && eval.charAt(compteurCaractere) != '.') {
				return false;
			}
			compteurCaractere++;
		}
		return true;
	}

	private static double operation(double operande1, double operande2, String operateur) {
		double res = 0;
		for (String operator : operators.keySet()) {
			if (operateur.equals(operator)) {
				res = operators.get(operator).apply(operande2, operande1);
			}
		}
		return res;
	}
}