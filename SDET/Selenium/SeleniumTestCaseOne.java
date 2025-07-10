import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Set;

public class SeleniumTestCaseOne {
    static final String url = "https://nocode.autify.com/";

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-cookies");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(3000);

        WebElement acceptAllButton = driver.findElement(By.xpath("//button[@aria-label='Accept All']")); //handling the cookies dialog
        acceptAllButton.click();

        String parentWindow = driver.getWindowHandle();
        driver.findElement(By.linkText("Start Free Trial"));
 
        Thread.sleep(5000);
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                String title = driver.getTitle();
                System.out.println("Child window title: " + title);

                if (title.toLowerCase().contains("autify")) {
                    System.out.println("Title verification Successful.");
                } else {
                    System.out.println("Title verification failed.");
                }

                driver.close(); //close the newly opened window
                driver.switchTo().window(parentWindow);
            }
        }
        driver.quit(); //Closing all the instances.
    }
}