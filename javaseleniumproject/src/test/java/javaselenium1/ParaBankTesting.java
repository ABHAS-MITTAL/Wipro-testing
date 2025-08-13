package javaselenium1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ParaBankTesting {
	WebDriver driver;
	
	@BeforeSuite //Start of the suite
	public void BeforeSuit() {
		System.out.println("Start the Suit");
	}
	
	@BeforeTest //Preparing test environment
	public void BeforTest() {
		System.out.println("Prepairing the test environment");
	}
	@BeforeClass// Launch Chrome, open Para Bank
	public void BeforeClass() {
		System.out.println("Lunching the browser");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://parabank.parasoft.com/");
	}
	
	@BeforeMethod //Go to login page
	public void BeforeMethod() {
		System.out.println("Navigating to Para Bank Customer login page ");
		driver.get("https://parabank.parasoft.com/");
	}
	
	@Test(priority = 1)//Verify page
	public void VerifyPage() {
		System.out.println("Page is Dispalyed");
	}
	
	@Test(priority = 2) //Perform login
	public void LoginTest() {
		System.out.println("performing Login");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		wait.until(ExpectedConditions.elementToBeClickable(By.name("username"))).sendKeys("Team5");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Sai123");
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Login ']"))).click();
	}
	
	@AfterMethod //Reset to login page
	public void AfterMethod() {
		System.out.println("Logout");
		driver.get("https://parabank.parasoft.com/");
	}
	@AfterTest //After test method
	public void AfterTest() {
		System.out.println("After test method should work");
	}
	
	@AfterSuite //After suite
	public void AfterSuit() {
		 System.out.println("After suite method should work");
		 driver.quit();
	}
	

}
