package com.qa.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GetSystemDateandTime {

	public static String getCurrentDateandTime() {

		// Get the current date and time
		LocalDateTime currentDateTime = LocalDateTime.now();
		System.out.println("Current LocalDateTime (unformatted): " + currentDateTime);

		// Define a custom format pattern
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");

		// Format the current date and time
		String formattedDateTime = currentDateTime.format(formatter);
		// System.out.println("Formatted current date and time: " +
		// formattedDateTime);

		return formattedDateTime;

	}

}
