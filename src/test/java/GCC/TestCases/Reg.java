package GCC.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import GCC.PageObjects.HomePage;
import GCC.PageObjects.RegistrationPage;

public class Reg extends BaseClass {
	
	@Test
	public void regis() throws Exception
	{

	HomePage hpp = new HomePage(driver);
	hpp.Signupbtn();
	
	Thread.sleep(4000);
	
	RegistrationPage rp = new RegistrationPage(driver);
	rp.setName("Aishu");
	rp.setEmail("aishui9iu@getnada.com");
	rp.setPassword("Test@123");
	rp.setMobile("9043533434");
	Thread.sleep(5000);

	rp.clickSignup();
	
	WebElement pp = driver.findElement(By.xpath("//section[@id='login-popup']//a[@class='mtrailermodal-close']"));
	pp.click();
	Assert.assertTrue(true);
	}
	
	/*
	 * 
	if(isAlertPresent()==true)
	{
		String alertmessage = driver.switchTo().alert().getText();
		System.out.println(alertmessage);
		driver.switchTo().alert().dismiss();
		Assert.assertTrue(true);
		System.out.println("pass");
	}
	else
	{
		Assert.assertTrue(false);
	}
	}
	
	*/
	
	//Switch to alert
		public boolean isAlertPresent() {
		
	try {
	driver.switchTo().alert();
	return true;
	}
	catch(NoAlertPresentException e)
	{
	  return false;
	}
	
}
	
}
