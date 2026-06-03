package utils;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    @Attachment(value = "{name}", type = "image/png")
    public static byte[] attachScreenshot(String name, WebDriver driver) {

        return ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
    }

    public static void captureScreenshot(WebDriver driver, String screenshotName) {

        File srcFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        File destinationFile = new File(
                "screenshots/" + screenshotName + ".png"
        );

        try {
            FileUtils.copyFile(srcFile, destinationFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}