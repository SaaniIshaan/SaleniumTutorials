package utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import constants.FileConstants;

public class CommonFileUtils {
	
	public static String readPropertiesFile(String path, String Key) throws IOException {
		File f  = new File(path);
		FileReader fr = new FileReader(f);
		Properties p = new Properties();
		p.load(fr);
		return p.getProperty(Key);
	}

	/**
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public static String readUserMenuTestData(String Key)throws IOException {
		File f = new File(FileConstants.USER_MENU_TESTDATA_FILE_PATH);
		FileReader fr = new FileReader(f);
		Properties p =  new Properties();
		p.load(fr);
		return p.getProperty(Key);
	}
	
	public static String readLeadsTestData(String Key)throws IOException {
		File f = new File(FileConstants.LEADS_TESTDATA_FILE_PATH);
		FileReader fr = new FileReader(f);
		Properties p =  new Properties();
		p.load(fr);
		return p.getProperty(Key);
	}
	
	public static String readContactsTestData(String Key)throws IOException {
		File f = new File(FileConstants.CONTACTS_TESTDATA_FILE_PATH);
		FileReader fr = new FileReader(f);
		Properties p =  new Properties();
		p.load(fr);
		return p.getProperty(Key);
	}
	
	public static String OpportunityTestData(String Key)throws IOException {
		File f = new File(FileConstants.OPPORTUNITY_TESTDATA_FILE_PATH);
		FileReader fr = new FileReader(f);
		Properties p =  new Properties();
		p.load(fr);
		return p.getProperty(Key);
	}
	
}
