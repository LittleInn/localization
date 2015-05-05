package com.dev.localization;

import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class RunApp {
	
	private static final String USER_LANGUAGE = "user.language";
	private static final String FILE_PROP_NAME = "menu";

	
	public void runResourceBundle(String fileName, Locale locale)
			throws IOException {
		ReadResourceBundle bundle = new ReadResourceBundle();
		bundle.readResourceBundle(fileName, locale);
	}
	public void runLoadProperties(String fileName)
			throws IOException {
		LoadProperties load = new LoadProperties();
		load.loadProperties(FILE_PROP_NAME);
		load.saveFile("menu", "menu", "New");
	}

	private static  Locale getCurrentLocale() {
		Properties properties = System.getProperties();
		return new Locale(properties.getProperty(USER_LANGUAGE));
	}

	public static void main(String[] args) throws IOException {
		RunApp run = new RunApp();
		Locale locale = RunApp.getCurrentLocale();
		run.runLoadProperties(FILE_PROP_NAME);
		run.runResourceBundle(FILE_PROP_NAME, locale);
	}
}
