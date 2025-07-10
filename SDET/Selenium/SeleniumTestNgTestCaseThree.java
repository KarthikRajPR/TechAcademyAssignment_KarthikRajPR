package testio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;
import org.testng.Assert;

import java.time.Duration;

public class SeleniumTestNgTestCaseThree {
    WebDriver driver;
    static final String url = "https://nocode.autify.com/";

    @Test(groups = {"SignUpValidation"})
    public void verifyAllErrorMessages() throws InterruptedException {
    	WebDriverManager.edgedriver().setup();
        driver = new ChromeDriver(); 
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	driver.get(url);

        WebElement acceptAllButton = driver.findElement(By.xpath("//button[@aria-label='Accept All']")); //handling the cookies dialog
        acceptAllButton.click();
        Thread.sleep(3000);
        WebElement trialButton = driver.findElement(By.linkText("Start Free Trial"));
        trialButton.click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[normalize-space()='Sign up']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//input[@name='first_name']/following-sibling::span")).getText().contains("First name can't be blank"));
        Assert.assertTrue(driver.findElement(By.xpath("//input[@name='last_name']/following-sibling::span")).getText().contains("Last name can't be blank"));
        Assert.assertTrue(driver.findElement(By.xpath("//input[@name='company']/following-sibling::span")).getText().contains("Company name can't be blank"));
        Assert.assertTrue(driver.findElement(By.xpath("//select[@name='company_size']/following-sibling::span")).getText().contains("Company size can't be blank"));
        Assert.assertTrue(driver.findElement(By.xpath("//input[@name='email']/following-sibling::span")).getText().contains("Email can't be blank"));
        Assert.assertTrue(driver.findElement(By.xpath("//input[@name='password']/following-sibling::span")).getText().contains("Password cannot be blank"));
        Assert.assertTrue(driver.findElement(By.xpath("//input[@name='phone_number']/following-sibling::span")).getText().contains("Phone Number can't be blank"));
        driver.quit();
    }

}