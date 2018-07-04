package actionClass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class fileAction {
	WebDriver driver;
	static String st;
	static File file;
	public fileAction(WebDriver driver)  
	{	
		this.driver=driver;	
	}
	
	public fileAction(String st, File file) {
		
	}

	public void downloadFile()
	{
		driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();
	}
	public fileAction readFile() throws IOException, InterruptedException
	{
		Thread.sleep(5000);

		file = new File("C:\\Users\\Vardasaxena\\Downloads\\file_handle_test.dat");
	  BufferedReader br = new BufferedReader(new FileReader(file));
	 
		  while ((st = br.readLine()) != null)
	  {
		    System.out.println(st);
		    if(st.contains("Signature")) {
		    	st = st.replace("Signature: ", "");
		    	System.out.println(st);
		  	  br.close();
		    	break;
		    }
	  }
		  return new fileAction(st,file);
	}
	public void gettingSignatureInForm(String signature)
	{
		driver.findElement(By.xpath("//*[@id=\"signature\"]")).sendKeys(signature);
	}

	public void deleteFile(File file)
	{
		 if(file.delete()) {
			  System.out.println("deleted successfully");
		  }
		  else {
			  System.out.println("lgaaao dimaag");
		  }
	}
	
	public void filePage_action() throws IOException, InterruptedException {
		downloadFile();
        readFile();
	 gettingSignatureInForm(fileAction.st);
		deleteFile(fileAction.file);    
		  driver.findElement(By.xpath("/html/body/div/div[2]/form/input[2]")).click();

		  
		  }
}
