package com.algo.practice.whatsapp;

public class Validator {

	public static boolean validateNumberOfGroups(int groups) throws NumberOfGroupsExceedException {
		boolean flag = false;

		if (groups <= 5 && groups>0) {
			flag = true;
		} else {
			// fill in the code
			throw new NumberOfGroupsExceedException("You can only share with upto 5 chats");
		}
		return flag;

	}

}
