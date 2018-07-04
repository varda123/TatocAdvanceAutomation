package actionClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class restAction {
WebDriver driver;
	public  restAction(WebDriver driver)
	{
		this.driver=driver;
		driver.get("http://10.0.1.86/tatoc/advanced/rest");
	}
	public String getSessionId()
	{
		String session=driver.findElement(By.xpath("//*[@id=\"session_id\"]")).getText();
		System.out.println(session);
		String sessionId=session.substring(12);
		System.out.println(sessionId);	
		return sessionId;
	}
	public HttpClient getClientConnection()
	{
		HttpClient client = HttpClientBuilder.create().build();
		return client;
	}
	public String gettingToken(String sessionId,HttpClient client) throws ClientProtocolException, IOException
	{
		HttpGet request = new HttpGet("http://10.0.1.86/tatoc/advanced/rest/service/token/"+sessionId);
		System.out.println(request);
		HttpResponse response =  client.execute(request);
		BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));
		String line = "";
		StringBuilder result = new StringBuilder();
		while ((line = rd.readLine()) != null) {
			result.append(line);
	}
	System.out.println(result);
	JSONObject jsonObj = new JSONObject(result.toString());
	System.out.println(jsonObj.get("token").toString());
	String token=jsonObj.get("token").toString();
	return token;
	}
	
	public void register(String sessionId, String token,HttpClient client) throws ClientProtocolException, IOException
	{
		ArrayList<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		HttpPost post = new HttpPost("http://10.0.1.86/tatoc/advanced/rest/service/register");
		urlParameters.add(new BasicNameValuePair("id", sessionId));
		urlParameters.add(new BasicNameValuePair("signature", token));
		urlParameters.add(new BasicNameValuePair("allow_access", "1"));
		post.setEntity(new UrlEncodedFormEntity(urlParameters));
        client.execute(post);
	}
	
	public void restPage_action() throws ClientProtocolException, IOException
	{
		String sessionId=getSessionId();
		HttpClient client=getClientConnection();
		String token=gettingToken( sessionId,client);
		register(sessionId,token,client);
	    driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();
	}
}
