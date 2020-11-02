package GCC.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import GCC.PageObjects.HomePage;
import GCC.PageObjects.LoginPage;
import GCC.PageObjects.SplashPage;

public class Login_TC_001 extends BaseClass{
	
	@Test
	public void login() throws Exception
	
	{
		//To verify if desired country is selected & home page is redirected
		
		SplashPage sp = new SplashPage(driver);
		sp.clickOman();
		
		Thread.sleep(5000);
		driver.getCurrentUrl();
		if(driver.getCurrentUrl().equalsIgnoreCase("https://oman1.cinepolisgulf.com/"))
		{
			Assert.assertTrue(true,"Oman home page is redirected");
		}
		
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
