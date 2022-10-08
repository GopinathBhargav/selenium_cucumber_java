package stepDefinitions;

import driverImpl.DriverInitialization;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

import utils.FileUtils;

public class Hooks {

    private DriverInitialization driverinitialization;
    private WebDriver driver;
    private FileUtils propFileReader;
    Properties prop;

    @Before(order = 0)
    public void getProperty() {
        propFileReader = new FileUtils();
        prop = propFileReader.readPropertyFile();
    }

    @Before(order = 1)
    public void launchBrowser() {
        String browserName = prop.getProperty("browser");
        driverinitialization = new DriverInitialization();
        driver = driverinitialization.initialize_driver(browserName);

    }

    @After(order = 0)
    public void quitBrowser() {
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
    }

}
