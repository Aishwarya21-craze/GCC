package GCC.TestUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;
	public ReadConfig()
	{
		File propFile = new File ("./Configuration/config.properties");
		try {
			FileInputStream reading = new FileInputStream(propFile);
			prop = new Properties();

			prop.load(reading);
		} catch (Exception e) {
			
			e.getMessage();
		}
	}
		
		public String getBaseURL()
		{
			String url = prop.getProperty("baseURL");
			return url;
		}
		
		public String getUsername()
		{
			String user = prop.getProperty("username");
			return user;
		}
		
		public String getPassword()
		{
			String pass = prop.getProperty("password");
			return pass;
			
			
		}
		public String getChromepath() {
			String cpath = prop.getProperty("chromepath");
			return cpath;
		}
	}
	
	
	
	

