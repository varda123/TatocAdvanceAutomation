package testClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import actionClass.openAction;
import globalClass.driver;
import globalClass.driver;

public class openDriver extends driver {

	@Test
	public void verify_openDriver() {
openAction open=new openAction(driver);
  open.open_page_action();
  open.verifyHomePageLaunched();
	}
}
