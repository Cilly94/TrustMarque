package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.DriverFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import utils.ScreenshotUtils;

public class BaseTest {

    protected WebDriver driver;

    ConfigReader configReader = new ConfigReader();

    @BeforeMethod
    public void setUp() {

        driver = DriverFactory.createDriver();

        driver.manage().window().maximize();

        driver.get(configReader.getBaseUrl());
    }
    @AfterMethod
    public void takeScreenshotOnTestCompletion(ITestResult result) {

        String testName = result.getName();

        ScreenshotUtils.captureScreenshot(driver, testName);
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {

            driver.quit();
        }
    }
}