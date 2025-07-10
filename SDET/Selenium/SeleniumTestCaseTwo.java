package testio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;

public class SeleniumTestCaseTwo {
    static final String url = "https://nocode.autify.com/";

    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-cookies");
    	WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

        try {
            driver.get(url);
            driver.manage().window().maximize();
            Thread.sleep(3000);

            WebElement acceptAllButton = driver.findElement(By.xpath("//button[@aria-label='Accept All']")); //handling the cookies dialog
            acceptAllButton.click();
            Thread.sleep(3000);

            WebElement startFreeTrialButton = driver.findElement(By.linkText("Start Free Trial"));
            startFreeTrialButton.click();
            Thread.sleep(3000);

            WebElement signupButton = driver.findElement(By.xpath("//button[normalize-space()='Sign up']"));
            signupButton.click();
            assert driver.findElement(By.xpath("//input[@name='firstName']/following-sibling::p[contains(text(),\"can't be blank\")]")).isDisplayed() : "First name error is not displayed";
            assert driver.findElement(By.xpath("//input[@name='lastName']/following-sibling::p[contains(text(),\"can't be blank\")]")).isDisplayed() : "Last name error is not displayed";
            assert driver.findElement(By.xpath("//input[@name='companyName']/following-sibling::p[contains(text(),\"can't be blank\")]")).isDisplayed() : "Company name error is not displayed";
            assert driver.findElement(By.xpath("//select[@name='companySize']/following-sibling::p[contains(text(),\"can't be blank\")]")).isDisplayed() : "Company size error is not displayed";
            assert driver.findElement(By.xpath("//input[@name='email']/following-sibling::p[contains(text(),\"can't be blank\")]")).isDisplayed() : "Email error is not displayed";
            assert driver.findElement(By.xpath("//input[@name='password']/following-sibling::p[contains(text(),\"cannot be blank\")]")).isDisplayed() : "Password error is not displayed";
            assert driver.findElement(By.xpath("//input[@name='phone']/../../following-sibling::p[contains(text(),\"can't be blank\")]")).isDisplayed() : "Phone number error is not displayed";

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}