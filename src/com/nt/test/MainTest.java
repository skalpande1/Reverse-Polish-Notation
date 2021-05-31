package com.nt.test;

import java.util.Scanner;

import com.nt.rpn.ReversePolishNotation;


public class MainTest {

	public static void main(String[] args) {
		
		try {
		// Taking input from user
		Scanner scn=new Scanner(System.in);
		System.out.print("Enter Input: ");
		String input = scn.nextLine();

		// A user defined class that evaluates RPN expression
		ReversePolishNotation notation = new ReversePolishNotation();
		System.out.println("Result is :: " + notation.evaluateExpression(input));
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}


}