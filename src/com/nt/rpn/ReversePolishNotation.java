package com.nt.rpn;

import java.util.Stack;

import com.nt.exception.MyException;
import com.nt.rpn.OperatorCheck;

public class ReversePolishNotation implements Calculate {
	Stack<Double> stack = new Stack<>();

	public double evaluateExpression(String input) {
		
       //Check Weather Input Null Or Empty
		if (input == null || input == "") {
			throw new MyException("Input should not be Null or empty.");
		}
		double output = 0.0;

		String[] expression = input.split(" ");

		for (String token : expression) {
			if (token.matches("-?\\d+(\\.\\d+)?")) {
				stack.add(Double.parseDouble(token));
			} else {
				boolean result = OperatorCheck.isOperator(token);
				{
					if (result == true) {
						output = result(token);
						stack.add(output);
					} else {
						throw new MyException("ERROR!!! '" + token
								+ "' found. " + "It is not belongs to "
								+ "[0-9, +, -, *, /, %, ^, !, (, )]");
					}
				}
			}
		}
		return output;
	}

	private double result(String token) {
		double x = 0, y = 0;
		switch (token) {
		case "+":
			y = stack.pop();
			x = stack.pop();
			return summation(x, y);
		case "-":
			y = stack.pop();
			x = stack.pop();
			return substract(x, y);
		case "*":
			y = stack.pop();
			x = stack.pop();
			return multiply(x, y);
		case "/":
			y = stack.pop();
			x = stack.pop();
			return divide(x, y);
		case "!":
			x = stack.pop();
			return factorial(x);
		case "^":
			y = stack.pop();
			x = stack.pop();
			return power(x, y);
		case "%":
			x = stack.pop();
			return percentage(x);
		}
		return 0;
	}

	@Override
	public Double summation(Double x, Double y) {
		return x + y;
	}

	@Override
	public Double substract(Double x, Double y) {
		return x - y;
	}

	@Override
	public Double multiply(Double x, Double y) {
		return x * y;
	}

	@Override
	public Double divide(Double x, Double y) {
		return x / y;
	}

	@Override
	public Double percentage(Double x) {
		return x / 100;
	}

	@Override
	public Double power(Double x, Double y) {
		int max = y.intValue();
		double fact = x;
		for (int i = 1; i < max; i++) {
			fact = fact * x;
		}
		return fact;
	}

	@Override
	public Double factorial(Double x) {
		int max = x.intValue();
		int fact = 1;
		for (int i = 1; i <= max; i++) {
			fact = fact * i;
		}
		return (double) fact;
	}

}