package arjun.pomyt2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import arjun.YT2testcomponent.TY2baseTest;

public class YT2landingPage extends TY2baseTest {

	WebDriver driver;
	
	public YT2landingPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//pagefactory
	
	@FindBy(xpath= "//input[@name='identifier']")
	WebElement email;
	@FindBy(xpath="(//span[@class='VfPpkd-vQzf8d'])[2]")
	WebElement next1;
	
	@FindBy(xpath="//input[@name='Passwd']")
	WebElement pwd;
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement checkBox;
	@FindBy(xpath="(//span[@class='VfPpkd-vQzf8d'])[2]")
	WebElement next2;
	
	public void URL()
	{
		driver.get("https://accounts.google.com/InteractiveLogin/signinchooser?continue=https%3A%2F%2Fwww.youtube.com%2Fsignin%3Faction_handle_signin%3Dtrue%26app%3Ddesktop%26hl%3Den%26next%3Dhttps%253A%252F%252Fwww.youtube.com%252F&ec=65620&hl=en&passive=true&service=youtube&uilel=3&ifkv=AeZLP988pQDMEtg5dCr9QqLbv1TmvnCy5vnhntTDCO_jRdp-NG7zoyKVU02ke8PfQ_0rleRwQeYlIA&ddm=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	}
	
	public void loginToGmailAccount(String emailid, String password) throws InterruptedException
	{
		email.sendKeys(emailid);
		next1.click();
		Thread.sleep(2000);
		pwd.sendKeys(password);
		Thread.sleep(2000);
		checkBox.click();
		Thread.sleep(2000);
		next2.click();
	}
	
}
