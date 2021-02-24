package com.src.main;

public class Solution {

	public static int myAtoi(String s) {
		s = s.trim();
		if (s == null || s.length() < 1) {
			return 0;
		}
		int i = 0;
		double output = 0;
		boolean negativeFlag = false;
		if (s.charAt(i) == '-') {
			negativeFlag = true;
			i++;
		} else if (s.charAt(i) == '+') {
			negativeFlag = false;
			i++;
		}
		s = s.replaceFirst("^0*", "");
		while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
			output = output * 10 + (s.charAt(i) - '0');
			i++;
		}
		if (negativeFlag == true)
			output = -output;

		if (output > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if (output < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		return (int) output;
	}

	public static void main(String[] args) {
		System.out.println(myAtoi(" "));
	}
}
