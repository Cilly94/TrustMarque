package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public int getCartItemCount() {
        List<WebElement> items = driver.findElements(By.className("cart_item"));
        return items.size();
    }

    public boolean waitForCartItemCountToBe(int expectedCount) {
        return wait.until(driver ->
                driver.findElements(By.className("cart_item")).size() == expectedCount
        );
    }

    public void clickCheckout() {
        WebElement checkoutButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("checkout"))
        );
        checkoutButton.click();
    }

    public void removeProductFromCart(String productName) {
        String buttonId = "remove-" + productName.toLowerCase().replace(" ", "-");

        WebElement removeButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.id(buttonId))
        );

        removeButton.click();
    }
}