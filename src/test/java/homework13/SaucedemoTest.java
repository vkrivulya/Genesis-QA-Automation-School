package homework13;

import base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.homework13.*;

import static com.codeborne.selenide.Selenide.open;
import static constants.SauceDemoConstants.*;
import static enums.Urls.SAUCEDEMO_URL;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static users.SaucedemoUsers.STANDARD_USER;
import static users.UserInfo.DAMN_CON;

public class SaucedemoTest extends BaseTest {

    private SaucedemoLoginPage saucedemoLoginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutOverviewPage overviewPage;

    @BeforeTest
    public void beforeTest() {
        saucedemoLoginPage = pageFactories.getSaucedemoLoginPage();
        open(SAUCEDEMO_URL.getUrl());
    }

    @Test(priority = 1)
    public void checkLoginPageIsLoaded() {
        assertTrue(saucedemoLoginPage.isLoginPageLoaded(), "Login logo should be displayed");
    }

    @Test(priority = 2)
    public void checkInventoryPageIsLoaded() {
        saucedemoLoginPage.setCredential(STANDARD_USER);
        inventoryPage = saucedemoLoginPage.clickLoginButton();
        assertTrue(inventoryPage.isInventoryPageLoaded(), "App logo should be displayed");
    }

    @Test(priority = 3)
    public void checkInventoryOnCartIsVisible() {
        final String firstItemNameOnInventoryPage = inventoryPage.getItemNameOnInventoryPage($_7_99);
        final String secondItemNameOnInventoryPage = inventoryPage.getItemNameOnInventoryPage($_9_99);
        inventoryPage.clickAddToCartByPriceButton($_7_99);
        inventoryPage.clickAddToCartByPriceButton($_9_99);
        cartPage = inventoryPage.clickCartButton();
        assertTrue(cartPage.isCartPageLoaded(), "Cart list should be displayed");
        assertEquals(cartPage.getItemNameBePriceOnCart($_7_99), firstItemNameOnInventoryPage);
        assertEquals(cartPage.getItemNameBePriceOnCart($_9_99), secondItemNameOnInventoryPage);
    }

    @Test(priority = 4)
    public void printTaxPercentage() {
        CheckoutFormPage formPage = cartPage.clickOnCheckoutButton();
        formPage.setUserInfoForm(DAMN_CON);
        overviewPage = formPage.clickContinueButton();
        double itemTotal = Double.parseDouble(overviewPage.getItemTotalPrice());
        double tax = Double.parseDouble(overviewPage.getTaxPrice());
        overviewPage.printTaxPercentage(itemTotal, tax);
    }

    @Test(priority = 5)
    public void checkCompleteHeaderText() {
        CheckoutCompletePage completePage = overviewPage.clickFinishButton();
        assertEquals(completePage.getCompleteHeaderText(), THANK_YOU_TEXT);
    }
}
