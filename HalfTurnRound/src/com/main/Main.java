package com.main;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		StringBuffer sb = new StringBuffer();

		System.out.print("Enter a string:");
		String input = sc.nextLine();
		sc.close();

		if (input == null || input.isEmpty() || input.length() == 0) {
			System.out.println("");
			return;
		} else if (input.length() < 2) {
			System.out.println("Size of string " + input + " is too low");
			return;
		} else if (!input.matches("^[a-zA-Z]*$")) {
			System.out.println(input + " is not a valid string");
			return;
		}

		int len = input.length();
		int mid = len / 2;

		for (int i = 0; i < mid; i++) {
			sb.append(input.charAt(i));
		}

		for (int i = len; i > mid; i--) {
			sb.append(input.charAt(i-1));
		}
		System.out.println(sb.toString());
	}

}
