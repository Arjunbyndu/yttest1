package arjun.Practice02;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class testCase1a
{
	
	public static void main(String[] args) throws InterruptedException 
	{
		
		String songA= "Imagine Dragons";
		//WebDriver driver = new ChromeDriver();
		
		System.getProperty("webdriver.geko.driver", "D:\\\\giko\\\\geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		driver.get("https://www.youtube.com/");
		driver.findElement(By.xpath("(//input[@name='search_query'])[1]")).sendKeys(songA);
		driver.findElement(By.xpath("(//button[@aria-label='Search'])[1]")).click();
		
		List<WebElement> title =  driver.findElements(By.xpath("//a[@id='video-title']"));
		
		WebElement title2 = title.stream().filter(songTitle -> songTitle.getText().contains(songA)).findAny().orElse(null);
		title2.findElement(By.xpath("//a[@id='video-title']")).click();
		Thread.sleep(2000);
		driver.close();
		}
}

