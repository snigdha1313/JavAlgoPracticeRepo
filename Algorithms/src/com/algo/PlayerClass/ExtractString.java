package com.algo.PlayerClass;

import java.util.Scanner;

public class ExtractString {
	
	
	/*
	 * Write a program to get a string from the user and print the second half of
	 * the original string based on its string length with the first character in
	 * uppercase.
	 * 
	 * Note: String should have minimum of two characters or else print
	 * "Length of the string <string> is too low". If the length of the string is
	 * more than 10, print "Length of the string <string> is too high". The given
	 * string should not contain any special character or numeric, if so print
	 * "<string> is Invalid".
	 */
	public static String extractString(String input) {
		if(input == null || input.isEmpty() || input.length()==0)
			return "";
		else if(input.length()<=2)
			return "Length of the string "+ input +"is too low";
		else if (input.length()>10)
			return "Length of the string "+ input +"is too high";
		else if (!input.matches("^[a-zA-Z]*$"))
			return input +" is Invalid";
		
		StringBuffer sb = new StringBuffer();
		int length = input.length();
		int mid = length/2;
		sb.append(Character.toUpperCase(input.charAt(mid)));
		mid = mid+1;
		while(mid<length) {
			sb.append(input.charAt(mid));
			mid++;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter a string: ");
		String str= sc.nextLine();
		sc.close();
		System.out.println(extractString(str));
	}

}
