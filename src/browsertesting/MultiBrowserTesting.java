package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

/**
 * BaseUrl = https://www.saucedemo.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Enter the email to email field.
 * 7. Enter the password to password field.
 * 8. Click on Login Button.
 * 9. Print the current url.
 * 10. Navigate to baseUrl
 * 11. Refresh the page.
 * 12. Close the browser.
 */
public class MultiBrowserTesting {
    static String browser = "Chrome";
    static String baseUrl = "https://www.saucedemo.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        // 1. Setup Chrome browser.
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("You have entered the wrong browser");
        }

        // 2. Open URL.
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // 3. Print the title of the page.
        String title = driver.getTitle();
        System.out.println(title);
        System.out.println("****************************************************");

        // 4. Print the current url.
        System.out.println(driver.getCurrentUrl());
        System.out.println("****************************************************");

        // 5. Print the page source.
        System.out.println(driver.getPageSource());
        System.out.println("****************************************************");

        // 6. Enter the email to email field.
       WebElement userName= driver.findElement(By.id("user-name"));
       userName.sendKeys("standard_user");

        // 7. Enter the password to password field.
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // 8. Click on Login Button.
        driver.findElement(By.id("login-button")).click();

        // 9. Print the current url.
        System.out.println(driver.getCurrentUrl());
        System.out.println("****************************************************");

        // 10. Navigate to baseUrl
        driver.navigate().back();

        // 11. Refresh the page.
        driver.navigate().refresh();

        // 12. Close the browser.
        driver.quit();

    }
}
