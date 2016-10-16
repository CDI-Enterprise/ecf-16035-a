/**
 * 
 */
package fr.cdiEnterprise.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * this properties class will give the ability to one user to customize its program and provide its Alias.
 * Further informations coumd be loaded like first, last name, phone number, address, email...
 * 
 * @author Nicolas Tarral
 * @version 13-10-2016
 *
 */
public class ReadProperties {
	static final String FILENAME = "MonIdentite.properties";

	public  ReadProperties() {
	}

	public static String getMyAlias() {
		Properties properties = new Properties();
		try {
			FileInputStream in = new FileInputStream(FILENAME);
			properties.load(in);
			in.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			System.exit(-1);
		}

		//properties.list(System.out);
		// This is how you can read name value pairs
//		System.out.println("-- using getProperty() --");
//		System.out.println("Font=" + properties.getProperty("Font"));
//		System.out.println("Alias=" + properties.getProperty("alias"));
		return properties.getProperty("alias");
	}
}
