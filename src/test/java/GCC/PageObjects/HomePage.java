package GCC.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "signin")
    WebElement Loginlink;
	
	@FindBy(xpath = "//a[@id='signup']")
	WebElement Signuplink;
	
	
	public void loginbtn()
	{
		Loginlink.click();
	}

	public void Signupbtn()
	{
		Signuplink.click();
	}
	
}
