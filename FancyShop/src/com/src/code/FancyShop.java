package com.src.code;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

@SuppressWarnings("unchecked") // Do not delete this line
public class FancyShop {
	private static Map<Integer, String> products = new HashMap<Integer, String>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the no of Face Creams you want to store:");
		int totalProductcount = sc.nextInt();
		Scanner sc1 = new Scanner(System.in);
		int i = 1;
		while (i <= totalProductcount) {
			System.out.println("Enter the key " + i);
			Integer key = sc.nextInt();
			if(products.containsKey(key)) {
				System.out.println("Key already exists");
				return;
			}
			System.out.println("Enter the value " + i);
			String value = sc1.nextLine();
			if (key != null && value != null) {
				products.put(key, value);
				i++;
			} else {
				return;
			}
		}
		System.out.println("Face Cream Details");
		Iterator<Entry<Integer, String>> iterator = products.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Integer, String> entry = iterator.next();
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}