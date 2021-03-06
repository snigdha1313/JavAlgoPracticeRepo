package com.src.code;

import java.util.Scanner;

public class VowelCheck {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String input = sc.next();
			StringBuffer sb = new StringBuffer();
			if (input == null || input.isEmpty() || input.length() == 0)
				return;
			boolean hasvowels = false;
			char[] array = input.toCharArray();
			int i = 0;
			while (i < array.length) {
				if (Character.toString(array[i]).matches("[aeiouAEIOU]")) {
					hasvowels = true;
					sb.append("#");
					i++;
				} else if (i < input.length() && !Character.toString(array[i]).matches("[aeiouAEIOU]")) {
					sb.append(input.charAt(i));
					i++;
				}
			}
			if (hasvowels)
				System.out.println(sb.toString());
			else
				System.out.println(input + " has no vowels");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
