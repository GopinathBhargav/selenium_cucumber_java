package driverImpl;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverInitialization {
    public WebDriver driver;

    public static ThreadLocal<WebDriver> threadlocalDriver = new ThreadLocal<>();

    public WebDriver initialize_driver(String browser) {

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            threadlocalDriver.set(new ChromeDriver());
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            threadlocalDriver.set(new FirefoxDriver());
        } else if (browser.equals("safari")) {
            WebDriverManager.safaridriver().setup();
            threadlocalDriver.set(new SafariDriver());
        } else {
            System.out.println("Please pass the correct browser value: " + browser);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        return getDriver();

    }

    public static synchronized WebDriver getDriver() {
        return threadlocalDriver.get();
    }


}
