package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;

	public ReadConfig() {
		File file = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);

		} catch (Exception e) {
			System.out.println("Exception is : " + e.getMessage());
		}

	}
//config.properties reading data methods implementation 

	public String getApllicationURL() {
		return prop.getProperty("baseURL");
	}

	public String getUsername() {
		return prop.getProperty("username");
	}

	public String getPassword() {
		return prop.getProperty("password");
	}

	public String getChromePath() {
		return prop.getProperty("chromepath");
	}

	public String getFirefoxPath() {
		return prop.getProperty("firefoxpath");
	}

}
