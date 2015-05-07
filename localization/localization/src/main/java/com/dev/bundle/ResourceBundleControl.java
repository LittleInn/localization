package com.dev.bundle;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;

public class ResourceBundleControl extends Control {
	private static final String EXT = "properties";

	public List<String> getFormats(String baseName) {
		return Collections.singletonList(EXT);
	}

	public ResourceBundle newBundle(String baseName, Locale locale,
			String format, ClassLoader loader, boolean reload)
			throws IllegalAccessException, InstantiationException, IOException {
		if ((baseName == null) || (locale == null) || (format == null)
				|| (loader == null)) {
			throw new NullPointerException();
		}
		ResourceBundle bundle = null;
		if (format.equals(EXT)) {
			String bundleName = toBundleName(baseName, locale);
			String resourceName = toResourceName(bundleName, format);
			URL url = loader.getResource(resourceName);
			if (url != null) {
				URLConnection connection = url.openConnection();
				try (InputStream stream = connection.getInputStream();
						InputStreamReader streamReader = new InputStreamReader(
								stream, "UTF-8")) {
					if (connection != null) {
						if (stream != null) {
							bundle = new ResourceBundleProperty(streamReader);
						}
					}
				} catch (IOException e) {
					throw new IOException();
				}
			}
		}
		return bundle;
	}

}
