package testClass;
import java.sql.*;  
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import actionClass.hoverAction;
import actionClass.openAction;
import globalClass.driver;

public class hoverPage extends driver {

	@Test
	public void verify_hoverPage() {
hoverAction hover=new hoverAction(driver);
  hover.hoverPage_action();
	}


/*public void verify_queryPage_appeared()
{
	String linkText = driver.findElement(By.linkText("Go Next")).getText();
	Assert.assertTrue(linkText.contains("Go"));
}*/
}
