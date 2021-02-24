package com.src.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	/*
	 * public static List<List<Integer>> threeSum(int[] nums) { Set<List<Integer>>
	 * output = new HashSet<List<Integer>>(); for (int i = 0; i < nums.length; i++)
	 * { for (int j = i + 1; j < nums.length - 1; j++) { if (nums[i] + nums[j] +
	 * nums[j + 1] == 0) { List<Integer> list = new ArrayList<Integer>();
	 * list.add(nums[i]); list.add(nums[j]); list.add(nums[j + 1]);
	 * Collections.sort(list); output.add(list); } } } return new
	 * ArrayList<>(output); }
	 */

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			while (j < k) {
				if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
					k--;
					continue;
				}
				if (nums[i] + nums[j] + nums[k] > 0)
					k--;
				else if (nums[i] + nums[j] + nums[k] < 0)
					j++;
				else {
					List<Integer> list = new ArrayList<Integer>();
					list.add(nums[i]);
					list.add(nums[j]);
					list.add(nums[k]);
					output.add(list);
					j++;
					k--;
				}
			}
		}
		return output;
	}

	public static void main(String[] args) {
		int[] nums = { -2, 0, 1, 1, 2 };
		System.out.println(threeSum(nums));
	}
}
