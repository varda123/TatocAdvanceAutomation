package testClass;

import java.sql.SQLException;

import org.testng.annotations.Test;

import actionClass.queryAction;
import globalClass.driver;

public class queryPage extends driver{
@Test
public void verify_queryPage() throws ClassNotFoundException, SQLException
{
	System.out.println("testcase running");
	queryAction query=new queryAction (driver);
	query.queryPage_action();
}
}
