package com.src.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class NextRechargeDate {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		Date date = simpleDateFormat.parse(input);
	}

}
