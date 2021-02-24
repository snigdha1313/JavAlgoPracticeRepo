package com.src.code;

public class PalindromeNumber {
	public static boolean isPalindrome(int x) {
		int actualNum = x;
		int revNum = 0;
		int r = 1;
		if (x < 0) {
			return false;
		}
		while (x > 0) {
			r = x % 10;
			revNum = revNum * 10 + r;
			x = x / 10;
		}
		if (actualNum == revNum)
			return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(321));
	}
}
