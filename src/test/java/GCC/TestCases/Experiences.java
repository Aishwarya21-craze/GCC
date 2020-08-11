package GCC.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Experiences extends BaseClass {

		@Test
		public void exp()
		{
			driver.navigate().to("https://beta-uae.cinepolisgulf.com/en/experiences");
			WebElement readmore = driver.findElement(By.xpath("//section[@id='Macro']//a[@class='read-more']"));
			readmore.click();
			
			
		}
	}


