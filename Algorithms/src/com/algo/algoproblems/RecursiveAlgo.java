package com.algo.algoproblems;

public class RecursiveAlgo {

	// find maximum number in array by recursion
	public static int findMax(int[] arr, int n) {
		if (n == 1)
			return arr[0]; // base condition
		else {
			return Math.max(arr[n - 1], findMax(arr, n - 1));
		}
	}

	// palliondrome word by recurssion
	public static boolean isPalliondrome(String word, int start, int end) {
		word= word.toLowerCase();
		if (start >= end)
			return true;
		else {
			return word.charAt(start) == word.charAt(end) && isPalliondrome(word, start + 1, end - 1);
		}

	}
	
	//Check if integers in arary are in sequence
	public static boolean isSequence(int[]arr,int index) {
		return index == arr.length-1 || (arr[index]==arr[index+1]-1) && isSequence(arr, index+1);
	}
	
	//find sum of digits in  number
	public static int sumOfDigits(int num) {
		if(num==0)
			return 0;
		else {
			int digit = num%10;
			return digit+sumOfDigits(num/10);
		}
	}
	
	public static void main(String[] args) {

		int A[] = { 1, 4, 45, 6, -50, 10, 2 };
		int n = A.length;

		// Function calling for finding maximum
		System.out.println(findMax(A, n));
		
		String word = "Madam";
		System.out.println(isPalliondrome(word, 0, word.length()-1));
		
		System.out.println(isSequence(A, 0));
		
		int arr[]= {1,2,3,4,5};
		System.out.println(isSequence(arr, 0));
		
		System.out.println(sumOfDigits(123));
	}

}
