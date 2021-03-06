package com.algo.practice.findmid;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string:");
		String name = sc.nextLine();
		if (name == "" || (name == null)) {
			return;
		}
		if (name.length() < 3) {
			System.out.println("The string " + name + " is too short");
			return;
		}
		if (!name.matches("^[a-zA-Z]*$")) {
			System.out.println("The string should not have <special character/numbers>");
			return;
		}
		
		int length = name.length();
		int mid = length/2;
		if (length%2 ==0) {
			System.out.println(name.charAt(mid-1)+""+name.charAt(mid));
		}else
			System.out.println(name.charAt(mid));

	}

}
