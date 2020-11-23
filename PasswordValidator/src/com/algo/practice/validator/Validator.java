package com.algo.practice.validator;

import com.algo.practice.exception.PasswordMismatchException;

public class Validator {

	public static boolean validatePassword(String password, String confirmpassWord) throws PasswordMismatchException {
		boolean flag = false;

		if (password.equals(confirmpassWord)) {
			flag = true;
		} else {
			// fill in the code
			throw new PasswordMismatchException("Password entered does not match");
		}

		return flag;
	}
}
