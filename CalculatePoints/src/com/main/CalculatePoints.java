package com.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class CalculatePoints {
	static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
		int alice = 0, bob = 0;
		List<Integer> list = new ArrayList<>(Arrays.asList(0, 0));
		for (int i = 0; i < b.size(); i++) {
			if (a.get(i) > b.get(i)) {
				alice = alice + 1;
				list.set(0, alice);
			} else if (a.get(i) < b.get(i)) {
				bob = bob + 1;
				list.set(1, bob);
			}
		}
		while (list.contains(0)) {
			int index = list.indexOf(0);
			list.remove(index);
		}
		return list;
	}

	public static void main(String[] args) throws IOException {
		List<Integer> a = new ArrayList<Integer>(Arrays.asList(10, 15, 20));
		List<Integer> b = new ArrayList<Integer>(Arrays.asList(5, 6, 7));

		List<Integer> result = compareTriplets(a, b);
		System.out.println(result);
	}
}
