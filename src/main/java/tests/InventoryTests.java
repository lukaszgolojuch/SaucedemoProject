package tests;

import com.microsoft.playwright.*;
import enums.Products;
import enums.TestUsers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageObjects.InventoryPage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import utils.BrowserUtils;

import java.util.List;

public class InventoryTests {

    private Browser browser;
    private Page page;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private ProductPage productPage;

    @BeforeEach
    void setUp() {
        browser = BrowserUtils.initializeBrowser();
        page = browser.newPage();
        page.navigate("https://www.saucedemo.com");
        loginPage = new LoginPage(page);
        inventoryPage = new InventoryPage(page);
        productPage = new ProductPage(page);
    }

    @AfterEach
    void tearDown() {
        browser.close();
    }

    @Test
    void testInventoryCheck() {
        loginPage.login(TestUsers.STANDARD_USER);
        inventoryPage.openSpecifiedProductPage(Products.SAUCE_LABS_BIKE_LIGHT);
        productPage.checkIfExpectedProductDetailsVisible(Products.SAUCE_LABS_BIKE_LIGHT);
    }
}
