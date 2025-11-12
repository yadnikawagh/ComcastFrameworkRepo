package com.crm.FileUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadFromProperties {
	public static String readProperty(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Configure.properties");
		prop.load(fis);
		String data = prop.getProperty(key);
		return data;
	}
}

