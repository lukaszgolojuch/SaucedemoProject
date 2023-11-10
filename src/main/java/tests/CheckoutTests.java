package tests;
import enums.Products;
import enums.TestUsers;
import pageObjects.*;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckoutTests {

    private Browser browser;
    private Page page;
    private LoginPage loginPage;
    private ProductPage productPage;
    private CheckoutPage checkoutPage;
    private ShoppingCartPage shoppingCartPage;
    private CheckoutStepTwoPage checkoutStepTwoPage;
    private SummaryPage summaryPage;

    @BeforeEach
    void setUp() {
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(true);
        browser = Playwright.create().chromium().launch(launchOptions);
        page = browser.newPage();
        page.navigate("https://www.saucedemo.com");
        loginPage = new LoginPage(page);
        productPage = new ProductPage(page);
        shoppingCartPage = new ShoppingCartPage(page);
        checkoutPage = new CheckoutPage(page);
        checkoutStepTwoPage = new CheckoutStepTwoPage(page);
        summaryPage = new SummaryPage(page);
    }

    @AfterEach
    void tearDown() {
        browser.close();
    }

    @Test
    void testCheckoutProcess() {
        loginPage.login(TestUsers.STANDARD_USER);
        productPage.addToCart(Products.SAUCE_LABS_BACKPACK);
        productPage.navigateToShoppingCart();
        shoppingCartPage.checkout();
        checkoutPage.enterShippingInformation("John", "Doe","12345");
        checkoutStepTwoPage.checkIfExpectedProductDataVisible(Products.SAUCE_LABS_BACKPACK);
        checkoutStepTwoPage.completePurchase();
        summaryPage.checkIfThankYouMessageVisible();
    }
}
