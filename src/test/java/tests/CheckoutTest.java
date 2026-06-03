package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import testdata.TestData;
import utils.ScreenshotUtils;

public class CheckoutTest extends BaseTest {

    @Test
    @Description("Verify user can successfully complete checkout")
    @Severity(SeverityLevel.BLOCKER)
    public void verifyUserCanCompleteCheckout() {

        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Login
        loginPage.login(
                TestData.STANDARD_USERNAME,
                TestData.PASSWORD
        );

        ScreenshotUtils.attachScreenshot("Login Successful", driver);

        // Add product
        inventoryPage.addProductToCart(TestData.BACKPACK);

        ScreenshotUtils.attachScreenshot("Product Added To Cart", driver);

        // Open cart
        inventoryPage.clickCart();

        ScreenshotUtils.captureScreenshot(driver, "Cart_Page");
        ScreenshotUtils.attachScreenshot("Cart Page", driver);

        // Checkout
        cartPage.clickCheckout();

        ScreenshotUtils.attachScreenshot("Checkout Information Page", driver);

        // Enter details
        checkoutPage.enterCheckoutDetails(
                TestData.FIRST_NAME,
                TestData.LAST_NAME,
                TestData.POSTAL_CODE
        );

        // Continue
        checkoutPage.clickContinue();

        ScreenshotUtils.attachScreenshot("Checkout Overview", driver);

        // Finish
        checkoutPage.clickFinish();

        ScreenshotUtils.captureScreenshot(driver, "Order_Confirmation");
        ScreenshotUtils.attachScreenshot("Order Confirmation", driver);

        // Verify
        Assert.assertTrue(
                checkoutPage.verifyOrderConfirmationDisplayed()
        );
    }

    @Test
    @Description("Verify user can remove an item and complete checkout")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyUserCanRemoveItemAndCheckout() {

        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Login
        loginPage.login(
                TestData.STANDARD_USERNAME,
                TestData.PASSWORD
        );

        // Add products
        inventoryPage.addProductToCart(TestData.BACKPACK);
        inventoryPage.addProductToCart(TestData.BIKE_LIGHT);
        inventoryPage.addProductToCart(TestData.BOLT_TSHIRT);

        // Open cart
        inventoryPage.clickCart();

        Assert.assertTrue(
                cartPage.waitForCartItemCountToBe(3)
        );

        ScreenshotUtils.attachScreenshot("Three Products In Cart", driver);

        // Remove product
        cartPage.removeProductFromCart(TestData.BACKPACK);

        Assert.assertTrue(
                cartPage.waitForCartItemCountToBe(2)
        );

        ScreenshotUtils.attachScreenshot("Product Removed", driver);

        // Checkout
        cartPage.clickCheckout();

        checkoutPage.enterCheckoutDetails(
                TestData.FIRST_NAME,
                TestData.LAST_NAME,
                TestData.POSTAL_CODE
        );

        checkoutPage.clickContinue();

        ScreenshotUtils.attachScreenshot("Checkout Overview", driver);

        checkoutPage.clickFinish();

        ScreenshotUtils.captureScreenshot(driver, "Checkout_After_Remove");
        ScreenshotUtils.attachScreenshot("Checkout Completed", driver);

        Assert.assertTrue(
                checkoutPage.verifyOrderConfirmationDisplayed()
        );
    }
}