package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import io.qameta.allure.*;

public class LoginTests extends BaseTest {

    @Test
    @Description("Verify successful login")
    @Severity(SeverityLevel.CRITICAL)
    public void verifySuccessfulLogin() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);

        // Login
        loginPage.login("standard_user", "secret_sauce");

        // Wait so you can see the login happen
        Thread.sleep(3000);

        // Verify user landed on inventory page
        Assert.assertTrue(inventoryPage.verifyInventoryPageDisplayed());
    }

    @Test
    @Description("Verify locked out user cannot login")
    @Severity(SeverityLevel.NORMAL)
    public void verifyLockedOutUserCannotLogin() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);

        // Attempt login with locked out user
        loginPage.login("locked_out_user", "secret_sauce");

        // Wait so you can see the error
        Thread.sleep(3000);

        // Verify error message displayed
        Assert.assertTrue(loginPage.verifyErrorMessageDisplayed());
    }
}