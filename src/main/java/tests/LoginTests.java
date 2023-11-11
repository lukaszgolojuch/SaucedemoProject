package tests;

import com.microsoft.playwright.*;
import enums.TestUsers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageObjects.InventoryPage;
import pageObjects.LoginPage;
import utils.BrowserUtils;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTests {

    private Browser browser;
    private Page page;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @BeforeEach
    void setUp() {
        browser = BrowserUtils.initializeBrowser();
        page = browser.newPage();
        page.navigate("https://www.saucedemo.com");
        loginPage = new LoginPage(page);
        inventoryPage = new InventoryPage(page);
    }

    @AfterEach
    void tearDown() {
        browser.close();
    }

    @Test
    void testLoginFunctionality() {
        loginPage.login(TestUsers.STANDARD_USER);
        assertThat(page).not().hasURL("secret_sauce");
        assertThat(page).hasURL("https://www.saucedemo.com/inventory.html");
    }

    @Test
    void testInvalidLoginAttempt() {
        loginPage.login("randomUsername", "randomPassword");
        loginPage.checkIfWrongPasswordMessageDisplayed();
        page.navigate("https://www.saucedemo.com");
        loginPage.loginExistingUserWithoutUnderscore(TestUsers.randomUser());
        loginPage.checkIfWrongPasswordMessageDisplayed();
        page.navigate("https://www.saucedemo.com");
        loginPage.loginExistingUserWithBigLetters(TestUsers.randomUser());
        loginPage.checkIfWrongPasswordMessageDisplayed();
        page.navigate("https://www.saucedemo.com");
        loginPage.login(TestUsers.LOCKED_OUT_USER);
        loginPage.checkIfLockedUserErrorDisplayed();
    }

    @Test
    void logutUserAndCheckIfContentIsNotAccessible() {
        loginPage.login(TestUsers.STANDARD_USER);
        inventoryPage.logoutUser();
        assertThat(page).hasURL("https://www.saucedemo.com/");
        page.navigate("https://www.saucedemo.com/inventory.html");
        loginPage.checkIfInventoryPageNotAccessibleDisplayed();
    }

}
