package stepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginTest {
	PageObjects po;
	public static WebDriver driver;
	
	
	@Given("^Navigate to Home page$")
	public void Navigate()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\pdc3a-training.pdc3a\\Desktop\\rasika selenium\\driver\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		po=new PageObjects(driver);
	}
	@When("^user enters username and password$")
	public void enters()
	{
		po.signin.click();
		po.userName.sendKeys("lalitha");
		po.password.sendKeys("Password123");
		po.login.click();
		
	}
	@Then("^user logged in successfully$")
	public void logged_in()
	{
		System.out.println("User login successfully");
	}
	@When("^user searches below products in the search box:$")
	public void search(DataTable dt)
	{
		List<String> product=dt.asList(String.class);
		for(String s : product)
		{
			driver.findElement(By.name("products")).sendKeys(s);;
			driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();
			driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
			driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div[2]/div/a[2]")).click();
			driver.findElement(By.xpath("//a[@href='fetchcat.htm']")).click();
		
			
		}

	}
	@And("^user should able to SignOut$")
	public void signout()
	{
		driver.findElement(By.xpath("//a[@href='logout.htm']")).click();
		driver.findElement(By.xpath("//a[@href='login.htm']")).click();
		
	}
	
	
	
	@When("^user enters \"([^\"]*)\" and  \"([^\"]*)\"$")
	public void enter1(String username, String password)
	{
		po.signin.click();
		po.userName.sendKeys(username);
		po.password.sendKeys(password);
		po.login.click();
		
	}
	
	
	
	@Then("^product should be added in the cart if available$")
	public void cart()
	{
		System.out.println("Products added");
	}

	

}
