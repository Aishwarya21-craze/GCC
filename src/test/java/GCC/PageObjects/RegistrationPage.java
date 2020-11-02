package GCC.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

WebDriver driver;
	
	public RegistrationPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "txtFirstName")
	WebElement name;
	
	@FindBy(id = "txtEmail")
	WebElement email;
	
	@FindBy(id = "txtPassword")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='txtMobile']")
	WebElement mobile ;
	
	@FindBy(xpath = "//a[@id='SignUp']")
	WebElement signup;
	

	
	public void setName(String userName)
	{
		name.sendKeys(userName);
	}
	
	public void setEmail(String emailID)
	{
		email.sendKeys(emailID);
	}

	public void setPassword (String pass)
	{
		password.sendKeys(pass);
	}
	
	public void setMobile(String mobi)
	{
		mobile.sendKeys(mobi);
	}
	
	public void clickSignup()
	{
		signup.click();
	}
	
	
	
}


