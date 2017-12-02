package com.arnis.calculator;

public class Calculator {
	public int evaluate(String expression) {
		int sum = 0;
		for (String summand : expression.split("\\+")) {
			sum += Integer.valueOf(summand);
		}
		System.out.println("Sum: " + sum);
		return sum;
	}
}