package com.dev.bundle;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

public class ResourceBundleProperty extends ResourceBundle {
	private Properties props;

	ResourceBundleProperty(InputStreamReader stream) throws IOException {
		props = new Properties();
		props.load(stream);
	}

	@Override
	public Enumeration<String> getKeys() {
		Set<String> keys = props.stringPropertyNames();
	    return Collections.enumeration(keys);
	}

	@Override
	protected Object handleGetObject(String key) {
		return props.getProperty(key);
	}
}
