package actionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import globalClass.driver;

public class openAction {
	WebDriver driver;
	public openAction(WebDriver driver) {
		this.driver = driver;
		
	}
	public void open_page_action()
	{
		
		driver.get("http://10.0.1.86/tatoc");
	}

	public void verifyHomePageLaunched() {
		WebElement logo = driver.findElement(By.className("title"));
		Assert.assertTrue(logo.isDisplayed());
		System.out.println("User is on homepage");
	}
}
