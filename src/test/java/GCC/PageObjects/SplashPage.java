package GCC.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SplashPage {

	WebDriver driver;
	public SplashPage(WebDriver driver)
	{
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
	  
	}
	
	@FindBy(xpath="//body/section[1]/section[1]/section[1]/section[1]/ul[1]/li[1]/a[1]/aside[1]/figure[1]/img[1]")
	WebElement bahrain;
	
	@FindBy(xpath="//body/section[1]/section[1]/section[1]/section[1]/ul[1]/li[2]/a[1]/aside[1]/figure[1]/img[1]")
	WebElement oman;
	
	@FindBy(xpath="//body/section[1]/section[1]/section[1]/section[1]/ul[1]/li[3]/a[1]/aside[1]/figure[1]/img[1]")
	WebElement uae;
	
	public void clickOman()
	{
		oman.click();
	}
	
	public void clickBahrain()
	{
		bahrain.click();
	}
	
	public void clickuae()
	{
		uae.click();
	}
	
	
	
	
}
