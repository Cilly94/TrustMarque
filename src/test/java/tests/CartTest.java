package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import testdata.TestData;
import utils.ScreenshotUtils;

public class CartTest extends BaseTest {

    @Test
    @Description("Verify user can add one product to the cart")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyUserCanAddOneProductToCart() {

        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.login(TestData.STANDARD_USERNAME, TestData.PASSWORD);

        inventoryPage.addProductToCart(TestData.BACKPACK);

        inventoryPage.clickCart();

        Assert.assertTrue(cartPage.waitForCartItemCountToBe(1));

        ScreenshotUtils.captureScreenshot(driver, "One_Product_In_Cart");
        ScreenshotUtils.attachScreenshot("One Product In Cart", driver);
    }

    @Test
    @Description("Verify user can add two products to the cart")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyUserCanAddTwoProductsToCart() {

        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.login(TestData.STANDARD_USERNAME, TestData.PASSWORD);

        inventoryPage.addProductToCart(TestData.BACKPACK);
        inventoryPage.addProductToCart(TestData.BIKE_LIGHT);

        inventoryPage.clickCart();

        Assert.assertTrue(cartPage.waitForCartItemCountToBe(2));

        ScreenshotUtils.captureScreenshot(driver, "Two_Products_In_Cart");
        ScreenshotUtils.attachScreenshot("Two Products In Cart", driver);
    }

    @Test
    @Description("Verify user can remove one product from the cart")
    @Severity(SeverityLevel.NORMAL)
    public void verifyUserCanRemoveProductFromCart() {

        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.login(TestData.STANDARD_USERNAME, TestData.PASSWORD);

        inventoryPage.addProductToCart(TestData.BACKPACK);
        inventoryPage.addProductToCart(TestData.BIKE_LIGHT);
        inventoryPage.addProductToCart(TestData.BOLT_TSHIRT);

        inventoryPage.clickCart();

        Assert.assertTrue(cartPage.waitForCartItemCountToBe(3));

        ScreenshotUtils.attachScreenshot("Three Products In Cart", driver);

        cartPage.removeProductFromCart(TestData.BACKPACK);

        Assert.assertTrue(cartPage.waitForCartItemCountToBe(2));

        ScreenshotUtils.captureScreenshot(driver, "Product_Removed_From_Cart");
        ScreenshotUtils.attachScreenshot("Product Removed From Cart", driver);
    }
}