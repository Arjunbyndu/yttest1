package arjun.YT2testcomponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import arjun.pomyt2.YT2landingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TY2baseTest {

	public WebDriver driver;
	
	public WebDriver initializedriver() throws IOException {
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\arjun\\data\\data.dataprovider.properties");
	prop.load(fis);
	 
	String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
	
	//String browserName = prop.getProperty("browser");
	
	if(browserName.equalsIgnoreCase("chrome"))
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
//			if(browserName.contains("headless"))
//				{
//				options.addArguments("headless");
//				}
//		
			
		
		driver = new ChromeDriver(options);

		
	}else if(browserName.equalsIgnoreCase("firefox"))
	{
		FirefoxOptions opt = new FirefoxOptions();
		opt.addPreference("dom.webnotifications.enabled", false);
		WebDriverManager.firefoxdriver().setup();
		//System.setProperty("webdriver.gecko.driver", "D:\\gicko\\geckodriver.exe");
		driver = new FirefoxDriver(opt);
		
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
	
	return driver;
	}
	
	
	
	public List<HashMap<String, String>> getJsonFileToMap(String FilePath) throws IOException
	{
		//json to string
		String jsoncontent = FileUtils.readFileToString(new File(FilePath), StandardCharsets.UTF_8);
		
		//string to hashmap
		
		ObjectMapper mapper = new ObjectMapper();
				
				List<HashMap<String,String>> data1= mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String,String>>>() {} );
		return data1;
	}
	public void YTlaunch() throws IOException
	{
		driver  = initializedriver();
		YT2landingPage YT2landingPage = new YT2landingPage(driver);
		YT2landingPage.URL();
		
		
	}
}
