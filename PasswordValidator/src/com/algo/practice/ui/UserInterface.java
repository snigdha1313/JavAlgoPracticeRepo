package com.algo.practice.ui;

import java.util.Scanner;

import com.algo.practice.exception.PasswordMismatchException;
import com.algo.practice.validator.Validator;

public class UserInterface {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the customer Name");
		String name = sc.nextLine();
		System.out.println("Enter the password");
		String passwd1 = sc.nextLine();
		System.out.println("Re-enter the password to confirm");
		String passwd2 = sc.nextLine();
		try {
			if(Validator.validatePassword(passwd1, passwd2))
				System.out.println("Registered Successfully");
		} catch (PasswordMismatchException e) {
			System.out.println(e.getMessage());
		}

	}
}
