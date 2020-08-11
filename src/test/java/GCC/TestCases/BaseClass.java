package GCC.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import GCC.TestUtilities.ReadConfig;

public class BaseClass {
	public static WebDriver driver;
	ReadConfig readc = new ReadConfig();
	
	public String user = readc.getUsername();
	public String pass = readc.getPassword();
	public String baseURL = readc.getBaseURL();
	
	@BeforeClass
    public void LaunchChrome()
    {
    	System.setProperty("webdriver.chrome.driver", readc.getChromepath());
    	driver = new ChromeDriver();
    	driver.get(baseURL);
    	driver.manage().window().maximize();
    	
    }
	
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}


}

