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


public class testCaseDP3 extends TY2baseTest
{
	
	@Test(dataProvider = "getdata")
	public void songsearch(HashMap<String,String> input ) throws IOException, InterruptedException
	{		
		YTlaunch();
		YT2landingPage YT2landingPage = new YT2landingPage(driver);
		YT2landingPage.loginToGmailAccount(input.get("email"), input.get("pwd"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@name='search_query'])[1]")).sendKeys(input.get("song"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@aria-label='Search'])[1]")).click();
		List<WebElement> title =  driver.findElements(By.xpath("//a[@id='video-title']"));		
		WebElement title2 = title.stream().filter(songTitle -> songTitle.getText().equalsIgnoreCase(input.get("song"))).findAny().orElse(null);
		title2.findElement(By.xpath("//a[@id='video-title']")).click();
		Thread.sleep(2000);
		//driver.close();
		
	}
	@DataProvider
	public  Object[][] getdata() throws IOException
	{
		
		List<HashMap<String,String>> data = getJsonFileToMap(System.getProperty("user.dir")+"\\src\\main\\java\\arjun\\DataProvider\\songsname.json");
		
		return new Object[][] {{data.get(0)}};
		
	}
	
	
	
}

