package com.algo.practice.whatsapp;

import java.util.Scanner;

import com.algo.practice.whatsapp.Validator;;

public class UserInterface {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); Scanner sc1 = new Scanner(System.in)) {
			System.out.println("Enter the mode of message(text,video,photo)");
			String mode = sc.next();
			if (!(mode.equals("text") || mode.equals("video") || mode.equals("photo"))) {
				System.out.println("Enter valid mode of message(text,video,photo)");
				return;
			}
			System.out.println("Enter number of groups");
			int groups = sc1.nextInt();
			if (Validator.validateNumberOfGroups(groups) == true) {
				System.out.println("Forwarded");
			}
		} catch (NumberOfGroupsExceedException e) {
			System.out.println(e.getMessage());
		}

	}
}
