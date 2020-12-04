package com.src.wordsearch.main;

import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string:");
		String firstString = sc.nextLine().toLowerCase();
		System.out.println("Enter the string to be searched:");
		String secondString = sc.nextLine().toLowerCase();
		if (firstString != null && secondString != null) {
			for (char c : firstString.toCharArray()) {
				if (!Character.toString(c).matches("^[ a-zA-z]+$")) {
					System.out.println("String should not contain " + c);
				}
			}
			for (char c : secondString.toCharArray()) {
				if (!Character.toString(c).matches("^[ a-zA-z]+$")) {
					System.out.println("String should not contain " + c);
				}
			}
		}

		int startIndex = firstString.indexOf(secondString);
		int lastIndex = firstString.lastIndexOf(secondString);
		System.out.println(startIndex + " " + lastIndex);
		if (startIndex == lastIndex) {
			if (startIndex == -1) {
				System.out.println(secondString + " not found");
			} else {
				System.out.println(startIndex + (startIndex + secondString.length() - 1));
			}
		} else
			System.out.println(secondString + " is present twice");
	}
}
