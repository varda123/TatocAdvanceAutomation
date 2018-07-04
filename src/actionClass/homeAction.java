package actionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import globalClass.driver;

public class homeAction  {
	WebDriver driver;
	public homeAction(WebDriver driver)
	{
		this.driver=driver;
	}
	public void homePage_action()
	{
	System.out.println(driver.getCurrentUrl() + "**********************");
		driver.findElement(By.xpath("/html/body/div/div[2]/a[2]")).click();
	}
	public void verify_HoverPage_appeared()
	{
		String linkText = driver.findElement(By.linkText("Go Next")).getText();
		Assert.assertTrue(linkText.contains("Go"));
	}
}
