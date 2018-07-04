package actionClass;
import org.openqa.selenium.interactions.Actions;

import globalClass.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class hoverAction {
	WebDriver driver;
	public hoverAction(WebDriver driver)
	{
		this.driver=driver;
	}
	public void hoverPage_action()
	{
	
		System.out.println(driver.getCurrentUrl() + "&&&&&&&&&&&&&&&&&&&");
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]"));
		System.out.println(we);
		action.moveToElement(we).moveToElement(driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/span[5]"))).click().build().perform();
	}
}
