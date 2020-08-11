package GCC.TestCases;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GCC.PageObjects.HomePage;
import GCC.PageObjects.RegistrationPage;
import GCC.TestUtilities.XlUtilities;

public class Registration_TC_002 extends BaseClass {
	
	XlUtilities xlu = new XlUtilities();
	
	@Test(dataProvider = "Registration")
	public void registration(String User, String email, String passwrd, String Mob) throws Exception
	{
		
		HomePage hp = new HomePage(driver);
		hp.Signupbtn();
		Thread.sleep(4000);
		
		RegistrationPage rp = new RegistrationPage(driver);
		rp.setName(User);
		rp.setEmail(email);
		rp.setPassword(passwrd);
		rp.setMobile(Mob);
		Thread.sleep(5000);
	
		rp.clickSignup();
		
		/*
		WebElement pop = driver.findElement(By.xpath("//section[@id='login-popup']//a[@class='mtrailermodal-close']"));
		pop.click();
		*/
		
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
		
		
	
		
		
		@DataProvider(name="Registration")
         String[][]Data() throws Exception
		{
			String path = System.getProperty("user.dir")+ "/src/test/java/GCC/TestData/GCCSignUp.xlsx" ;

			int rownum = xlu.getrowcount(path, "Sheet1");
			int cellnum = xlu.cellcount(path, "Sheet1", 1);
		
			String[][] logdata= new String [rownum][cellnum];
			
			for(int i=1;i<rownum;i++)
			{
				for(int j=0;j<cellnum; j++)
				{
					
					logdata[i-1][j]= xlu.getCellData(path, "Sheet1", i, j);
				}
			}
			
			return logdata;
		}
		
	

}
