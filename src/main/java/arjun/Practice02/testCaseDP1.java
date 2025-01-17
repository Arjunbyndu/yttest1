package arjun.Practice02;

import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import arjun.YT2testcomponent.TY2baseTest;
import arjun.pomyt2.YT2landingPage;


public class testCaseDP1 extends TY2baseTest
{
	
	@Test(dataProvider = "getdata")
	public void songsearch(String email , String pwd1 , String Song) throws IOException, InterruptedException
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
		YT2landingPage.loginToGmailAccount(email, pwd1);
		//Thread.sleep(4000);
		
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//div[@class=\"style-scope ytd-rich-grid-renderer\"])[7]")));
		//driver.findElement(By.xpath("(//div[@class='style-scope ytd-app'])[1]"));
		driver.findElement(By.xpath("(//input[@name='search_query'])[1]")).sendKeys(Song);
		
		driver.findElement(By.xpath("(//button[@aria-label='Search'])[1]")).click();
		
		List<WebElement> title =  driver.findElements(By.xpath("//a[@id='video-title']"));
		
		WebElement title2 = title.stream().filter(songTitle -> songTitle.getText().contains(Song)).findAny().orElse(null);
		title2.findElement(By.xpath("//a[@id='video-title']")).click();
		
		Thread.sleep(2000);
		driver.close();
	}
	@DataProvider
	public Object[][] getdata()
	{
		return new Object[][] {{"javaprogram56@gmail.com", "Java@1997" ,"SHIVA SHIVA"} ,{"javaprogramm57@gmail.com", "Java@1997" ,"Imagine Dragons" }  };
		
	}
	
//	
	
}

