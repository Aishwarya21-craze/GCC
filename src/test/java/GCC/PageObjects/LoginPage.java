package GCC.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
		
   @FindBy(id="txtEmail")	
   WebElement email;
   
   @FindBy(id = "txtPassword")
   WebElement password;
   
   @FindBy(xpath="//section[@class='form-blk']//a[@class='btn btnprimary']")
   WebElement login;
   
   @FindBy(xpath = "//section[@id='login-popup']//a[@class='mtrailermodal-close']")
   WebElement loginpop;
   
   public void setEmail(String emailBox)
   {
	   email.sendKeys(emailBox);
   }
   
   public void setPassword(String passBox)
   {
	   password.sendKeys(passBox);
   }
   public void Loginbtn()
   {
	   login.click();
   }
   
   public void closepopup()
   {
	   loginpop.click();
   }
   
}
