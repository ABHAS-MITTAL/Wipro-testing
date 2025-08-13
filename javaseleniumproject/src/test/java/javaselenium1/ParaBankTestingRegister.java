package javaselenium1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class ParaBankTestingRegister {
    WebDriver driver;

    @BeforeSuite
    public void BeforeSuit() {
        System.out.println("Start the Suite");
    }

    @BeforeTest
    public void BeforTest() {
        System.out.println("Preparing the test environment");
    }

    @BeforeClass
    public void BeforeClass() {
        System.out.println("Launching the browser");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/");
    }
    @BeforeMethod
    public void BeforeMethod() {
        System.out.println("Navigating to Para Bank Home page ");
        driver.get("https://parabank.parasoft.com/");
    }

    @Test(priority = 1)
    public void VerifyPage() {
        System.out.println("Page is Displayed");
    }

    @Test(priority = 2)
    public void RegisterTest() {
        System.out.println("Performing Registration");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click "Register" link
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Register"))).click();

        // Fill Registration form
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer.firstName"))).sendKeys("Abhas");
        driver.findElement(By.id("customer.lastName")).sendKeys("Mittal");
        driver.findElement(By.id("customer.address.street")).sendKeys("L-block");
        driver.findElement(By.id("customer.address.city")).sendKeys("Meerut");
        driver.findElement(By.id("customer.address.state")).sendKeys("Uttar Pradesh");
        
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("12345");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("1234567890");
        
        driver.findElement(By.id("customer.ssn")).sendKeys("999-99-9999");
        driver.findElement(By.id("customer.username")).sendKeys("User456");
        
        driver.findElement(By.id("customer.password")).sendKeys("Pass123");
        driver.findElement(By.id("repeatedPassword")).sendKeys("Pass123");

        // Click Register button
        driver.findElement(By.xpath("//input[@value='Register']")).click();
    }

    /*
    @AfterMethod
    public void AfterMethod() {
        System.out.println("Returning to Home Page");
        driver.get("https://parabank.parasoft.com/");
    }
    */


    @AfterTest
    public void AfterTest() {
        System.out.println("After test method should work");
    }
    /*@AfterSuite
    public void AfterSuit() {
        System.out.println("After suite method should work");
        driver.quit();
    }
    */
}
