package com.src.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class NextRechargeDate {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Recharged date");
		String input = sc.nextLine();

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date inputDate = simpleDateFormat.parse(input);
		Date currentDate = simpleDateFormat.parse("29/10/2019");
		if (!input.matches("^[0-9]{2}/[0-9]{2}/[0-9]{4}$")) {
			System.out.println(input + " is not a valid date");
			return;
		}
		if (!inputDate.before(currentDate) && !inputDate.equals(currentDate)) {
			System.out.println(input + " is not a valid date");
			return;
		}
		System.out.println("Validity days");
		int validityDays = sc.nextInt();
		if (validityDays <= 0) {
			System.out.println(validityDays + " is not a valid days");
			return;
		}

		Calendar cal = Calendar.getInstance();
		cal.setTime(inputDate);
		cal.add(Calendar.DATE, validityDays);
		Date dateWithValidityDays = cal.getTime();

		System.out.println(simpleDateFormat.format(dateWithValidityDays));

	}

}
