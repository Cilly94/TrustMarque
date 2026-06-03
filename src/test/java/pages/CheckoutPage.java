package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCheckoutDetails(String firstName, String lastName, String postalCode) {

        driver.findElement(By.id("first-name")).sendKeys(firstName);

        driver.findElement(By.id("last-name")).sendKeys(lastName);

        driver.findElement(By.id("postal-code")).sendKeys(postalCode);
    }

    public void clickContinue() {

        driver.findElement(By.id("continue")).click();
    }

    public void clickFinish() {

        driver.findElement(By.id("finish")).click();
    }

    public boolean verifyOrderConfirmationDisplayed() {

        return driver.findElement(By.className("complete-header")).isDisplayed();
    }
}