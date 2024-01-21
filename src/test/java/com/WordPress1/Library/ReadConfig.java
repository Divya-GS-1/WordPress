package com.WordPress1.Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig{
	Properties prop;

	public ReadConfig() {
		try {
			File file = new File("./Configurations/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println(" Found exception " + e.getMessage());
		}
	}

	public String getApplicationURL() {
		return prop.getProperty("baseURL");
	}

	public String getUserName() {
		return prop.getProperty("username");
	}

	public String getPassword() {
		return prop.getProperty("password");
	}
}
