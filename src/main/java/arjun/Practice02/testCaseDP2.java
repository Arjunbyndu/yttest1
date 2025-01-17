package arjun.Practice02;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import arjun.YT2testcomponent.TY2baseTest;
import arjun.pomyt2.YT2landingPage;


public class testCaseDP2 extends TY2baseTest
{
	
	@Test(dataProvider = "getdata")
	public void songsearch(HashMap<String,String> input ) throws IOException, InterruptedException
	{
//		String songA= "Imagine Dragons";
//		String songB= "SHIVA SHIVA";
//		String pwd1 = "Java@1997";
//		String email1= "javaprogramm55@gmail.com";
//		String email2= "javaprogram56@gmail.com";
//		String email3= "javaprogramm57@gmail.com";
//		
		
		YTlaunch();
		YT2landingPage YT2landingPage = new YT2landingPage(driver);
		YT2landingPage.loginToGmailAccount(input.get("email"), input.get("pwd"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@name='search_query'])[1]")).sendKeys(input.get("song"));
		driver.findElement(By.xpath("(//button[@aria-label='Search'])[1]")).click();
		
		List<WebElement> title =  driver.findElements(By.xpath("//a[@id='video-title']"));
		
		WebElement title2 = title.stream().filter(songTitle -> songTitle.getText().contains(input.get("song"))).findAny().orElse(null);
		title2.findElement(By.xpath("//a[@id='video-title']")).click();
		driver.close();
		
	}
	
	
	@DataProvider
	public  Object[][] getdata()
	{
		HashMap<String , String> map = new HashMap<String , String>();
		map.put("email", "javaprogram56@gmail.com");
		map.put("pwd", "Java@1997");
		map.put("song", "SHIVA SHIVA");
		
		HashMap<String , String> map1 = new HashMap<String , String>();
		map1.put("email", "javaprogramm57@gmail.com");
		map1.put("pwd", "Java@1997");
		map1.put("song", "Imagine Dragons");
		return new Object[][] {{ map1},  {map}};
		
	}
	
	
	
}

