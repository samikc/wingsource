package org.wingsource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesClassLoader {

	private Properties props;
	public PropertiesClassLoader(String fileName) throws IOException {
		props = new Properties();
		FileInputStream fin = new FileInputStream(fileName);
		props.load(fin);
	}
	
	public Class getClazz(String key) throws ClassNotFoundException {
		Class ret = null;
		String className = props.getProperty(key);
		ret = Class.forName(className);
		return ret;
	}
}
