package actionClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.mysql.jdbc.Statement;

public class queryAction  {
	 WebDriver driver;
	static String name;
	static String passkey;
	public queryAction(WebDriver driver)
	{
		this.driver=driver;

	}
	
	public queryAction(String name, String passkey)
	{
		queryAction.name=name;
		queryAction.passkey=passkey;
	}
	
	public Statement databaseConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		  String url1 = "jdbc:mysql://10.0.1.86/tatoc";
	      String user = "tatocuser";
	      String password = "tatoc01";
		 Connection con = DriverManager.getConnection(url1,user,password);
		 Statement  stmt = (Statement) con.createStatement();
		 System.out.println("connected to database successfully");
		return stmt;
	}
	
	public String findSymbol()
	{
		String symbol= driver.findElement(By.xpath("//div[@id='symboldisplay']")).getText();
		return symbol;
	}
	
	
	
	public  queryAction queryExecution(Statement stmt,String symbol) throws ClassNotFoundException, SQLException
	{
		
		String Query1="select *  from identity;";
		String Query2="select *  from credentials;";
	    stmt.executeQuery(Query1);
	    ResultSet rs=stmt.executeQuery(Query1);
	    String id = null;
	    String name = null;
		String passkey=null;
		System.out.println(rs.getMetaData());
		while(rs.next())
		{
			if(rs.getString("symbol").equalsIgnoreCase(symbol))
				id=rs.getString("id");  
			
		}
		System.out.println(id);
		ResultSet rs1=stmt.executeQuery(Query2);
		System.out.println(rs1.getMetaData());
		while(rs1.next()){
			if(rs1.getString("id").equals(id)){
			name = rs1.getString("name");
			System.out.println(name);
			passkey = rs1.getString("passkey");
			System.out.println(passkey);
			}	
		}
		System.out.println(name);
		System.out.println(passkey);
	return new queryAction(name,passkey);
	}
	
	
	public  void queryPage_action() throws ClassNotFoundException, SQLException
	{
		System.out.println("trying to connect");
		Statement stmt=databaseConnection();
		String symbol=findSymbol();
		queryExecution(stmt,symbol);
	  driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(queryAction.name);
	  driver.findElement(By.xpath("//*[@id=\"passkey\"]")).sendKeys(queryAction.passkey);
	 driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();  
	 
	     	}
}
