package com.dev.localization;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

public class ReadResourceBundle {
	private final Logger log = Logger.getLogger(ReadResourceBundle.class);
	
	public void readResourceBundle(String fileName, Locale locale) {
		ResourceBundle bundle = ResourceBundle.getBundle(fileName, locale);
		log.info("ResourceBundle --- Read property");
		log.info("File: " + bundle.getString("file"));
		Enumeration<String> keys = bundle.getKeys();
		log.info("Get all elements");
		while (keys.hasMoreElements()) {
			log.info(bundle.getString(keys.nextElement()));
		}
	}
}
