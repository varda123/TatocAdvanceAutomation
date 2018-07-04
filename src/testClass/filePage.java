package testClass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import actionClass.fileAction;
import globalClass.driver;

public class filePage extends driver{
	@Test
	public void verify_filePage() throws IOException, InterruptedException
	{
		fileAction file=new fileAction(driver);
		file.filePage_action();
	}
	}

