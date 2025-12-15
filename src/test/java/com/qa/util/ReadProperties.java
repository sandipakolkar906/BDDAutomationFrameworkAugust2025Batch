package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Punam 
 * The purpose of this class is written as a common class to read the properties from config.proprties
 */
/**
 * @author Acer
 *
 */
public class ReadProperties {

	/**
	 * @return
	 * This method will load the properties from config.properties
	 */
	public static Properties loadProperties() {

		// Open the File
		File objfile = new File("AppConfig/config.properties");
		// Read the File

		FileInputStream objfis = null;
		try {
			objfis = new FileInputStream(objfile);
		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		}

		Properties objprop = new Properties();
		try {
			objprop.load(objfis);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return objprop;

	}
	
	/**
	 * @return
	 * This method will read key app URL from config.properties and return value
	 */
	public static String getappURL() {

		return loadProperties().getProperty("appURL");

	}

	/**
	 * @return
	 * This implicit wait applied to every element of the page to load data 
	 */
	public static long implicitWaitTime() {

		return Long.parseLong(loadProperties().getProperty("implicitWaitTime"));
	}

	public static String getAppUserName() {
		return loadProperties().getProperty("userName");
	}

	public static String getAppPassword() {
		return loadProperties().getProperty("password");
	}

	public static long getFluentWaitTime() {

		return Long.parseLong(loadProperties().getProperty("fluentWaitTime"));
	}
	
}
