package stepDefinition;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjects {
	WebDriver driver;
	public PageObjects(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//*[@id='header']/div[1]/div/div/div[2]/div/ul/li[1]/a")
	//driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div[2]/div/ul/li[1]/a")).click();
	public WebElement signin;
	@FindBy(name="userName")
	public WebElement userName;
	@FindBy(name="password")
	public WebElement password;
	@FindBy(name="Login")
	public WebElement login;
	@FindBy(xpath="//a[@href='logout.htm']")
	public WebElement SignOut;
	
	
	
	
}
