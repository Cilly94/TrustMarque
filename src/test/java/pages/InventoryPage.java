package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {

    WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart(String productName) {

        WebElement product = driver.findElement(
                By.xpath("//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']")
        );

        product.findElement(By.tagName("button")).click();
    }

    public void clickCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    public boolean verifyInventoryPageDisplayed() {
        return driver.findElement(By.className("inventory_list")).isDisplayed();
    }
}