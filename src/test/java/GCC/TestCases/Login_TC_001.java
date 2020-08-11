package GCC.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import GCC.PageObjects.HomePage;
import GCC.PageObjects.LoginPage;

public class Login_TC_001 extends BaseClass{
	
	@Test
	public void login() throws Exception
	
	{
		//WebElement Loginlink = driver.findElement(By.id("signin"));
		//Loginlink.click();
		
		HomePage hp = new HomePage(driver);
		hp.loginbtn();
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(user);
		lp.setPassword(pass);
		lp.Loginbtn();
		Thread.sleep(5000);
		if(driver.getTitle().equalsIgnoreCase("Cinépolis -  Home"))
		{
			Assert.assertTrue(true, "Login is successful");
		
		}
		Thread.sleep(5000);
		driver.quit();
		
		
		
		
	}

	
	
}
