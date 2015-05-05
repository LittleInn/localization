package com.dev.localization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class LoadProperties {
	private final Logger log = Logger.getLogger(LoadProperties.class);
	private static final String TOKEN = "/";
	private static final String EXTENTION = ".properties";

	public void loadProperties(String fileName)
			throws UnsupportedEncodingException {

		Properties props = new Properties();
		try (InputStream inputStreamReader = getClass().getResourceAsStream(
				TOKEN + fileName + EXTENTION)) {
			props.load(inputStreamReader);
			props.list(System.out);
		} catch (IOException e) {
			log.error("", e);
		}
	}

	//doesn't work
	public void saveFile(String fileName, String propertyName,
			String propertyValue) throws IOException {

		Properties p = new Properties();
		try (OutputStream propsFile = new FileOutputStream(TOKEN + fileName + EXTENTION)) {
			InputStream inputStreamReader = getClass().getResourceAsStream(
					TOKEN + fileName + EXTENTION);

			p.load(inputStreamReader);
			p.setProperty(propertyName, propertyValue); 
			p.store(propsFile,"save in UTF-8 format"); 
			log.info("file: " + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
