package testClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import actionClass.homeAction;
import globalClass.driver;

public class homePage extends driver{
	@Test
	public void verify_homePage() {
		homeAction home=new homeAction (driver);
		home.homePage_action();
	//home.verify_HoverPage_appeared();
	}
	



}
