package com.algo.practice.conversion;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		if (input.length() < 4 || input.length() > 5) {
			System.out.println(input + " is a " + input.length() + " digit input");
			return;
		}
		char[] charArray = input.toCharArray();
		boolean valid = false;
		for (int i = 0; i < input.length(); i++) {
			if (Character.toString(charArray[i]).matches("[0-9]")
					|| Character.toString(charArray[i]).matches("[ABCDEFabcdef]")) {
				valid = true;
			} else {
				valid = false;
			}
		}

		System.out.println(valid);

		if (valid) {
			System.out.println(Integer.parseInt(input, 16));
		} else
			System.out.println(input + " is Invalid");
		return;
	}

}
