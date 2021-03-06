package com.ui;

import java.util.Scanner;

import com.utility.RMCBO;

public class UserInterface {

	public static void main(String[] args) {
		RMCBO rmcbo = new RMCBO();
		boolean quit = false;
		// Type your logic here
		do {
			System.out.println("1. Add rainfall details");
			System.out.println("2. Average Rainfall occurred");
			System.out.println("3. Exit");
			System.out.println("Enter your choice");
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			switch (input) {
			case 1:
				System.out.println("Enter the Date");
				String date = sc.next();
				System.out.println("Enter the recorded rainfall in mm");
				int rainfall = sc.nextInt();
				rmcbo.addRainfallDetails(rainfall);
				break;
			case 2:
				System.out.println("Average Rainfall recorded in mm");
				System.out.println(rmcbo.findAverageRainfallOccured());
				break;
			case 3:
				quit = true;
				System.out.println("Thank you for using the Application");
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}

		} while (!quit);
	}
}