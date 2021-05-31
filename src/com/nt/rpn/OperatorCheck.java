package com.nt.rpn;

import java.util.Arrays;
import java.util.HashSet;

public class OperatorCheck {
	public static boolean isOperator(String token) {
		HashSet<String> set = new HashSet<>(Arrays.asList("(", ")", "+", "-",
				"%", "/", "*", "^", "!"));

		if (set.contains(token)) {
			return true;
		}
		return false;
	}

}