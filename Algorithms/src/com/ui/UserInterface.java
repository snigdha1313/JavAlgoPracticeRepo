package com.ui;

import java.util.Scanner;

import com.utility.PlayerBO;

public class UserInterface {

	public static void main(String[] args) {

		PlayerBO playerBO = new PlayerBO();

		boolean quit = false;
		do {
			System.out.println("1. Add overs bowled");
			System.out.println("2. Number of balls bowled");
			System.out.println("3. Exit");

			System.out.println("Enter your choice");
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			// Fill the UI code

			switch (input) {
			case 1:
				System.out.println("Enter the overs bowled");
				int overs = sc.nextInt();
				playerBO.addOversDetails(overs);
				break;
			case 2:
				System.out.println("Total number of balls bowled");
				System.out.println(playerBO.getNoOfBallsBowled());
				break;
			case 3:
				System.out.println("Thank you for using the Application");
				quit = true;
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}

		} while (!quit);

	}

}