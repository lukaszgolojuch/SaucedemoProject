package pageObjects;

import com.microsoft.playwright.*;
import enums.TestUsers;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPage {

    private final Page page;

    private final String USERNAME_INPUT_SELECTOR = "#user-name";
    private final String PASSWORD_INPUT_SELECTOR = "#password";
    private final String LOGIN_BUTTON_SELECTOR = "input[type='submit']";
    private final String FAILED_LOGIN_MESSAGE =
            "Epic sadface: Username and password do not match any user in this service";
    private final String INVENTORY_PAGE_NOT_ACCESSIBLE_MESSAGE =
            "Epic sadface: You can only access '/inventory.html' when you are logged in.";
    private final String LOCKED_USER_MESSAGE =
            "Epic sadface: Sorry, this user has been locked out.";
    private final String ERROR_MESSAGE_CONTAINER_SELECTOR = ".error-message-container";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void login(TestUsers testUser) {
        page.type(USERNAME_INPUT_SELECTOR, testUser.username());
        page.type(PASSWORD_INPUT_SELECTOR, testUser.password());
        page.click(LOGIN_BUTTON_SELECTOR);
    }

    public void login(String username, String password) {
        page.type(USERNAME_INPUT_SELECTOR, username);
        page.type(PASSWORD_INPUT_SELECTOR, password);
        page.click(LOGIN_BUTTON_SELECTOR);
    }
    public void loginExistingUserWithoutUnderscore(TestUsers testUser) {
        page.type(USERNAME_INPUT_SELECTOR, testUser.username().replace("_", ""));
        page.type(PASSWORD_INPUT_SELECTOR, testUser.password());
        page.click(LOGIN_BUTTON_SELECTOR);
    }
    public void loginExistingUserWithBigLetters(TestUsers testUser) {
        page.type(USERNAME_INPUT_SELECTOR, testUser.username().toUpperCase());
        page.type(PASSWORD_INPUT_SELECTOR, testUser.password());
        page.click(LOGIN_BUTTON_SELECTOR);
    }

    public void checkIfWrongPasswordMessageDisplayed() {
        assertThat(page.locator(ERROR_MESSAGE_CONTAINER_SELECTOR)).hasText(FAILED_LOGIN_MESSAGE);
    }

    public void checkIfInventoryPageNotAccessibleDisplayed() {
        assertThat(page.locator(ERROR_MESSAGE_CONTAINER_SELECTOR)).hasText(INVENTORY_PAGE_NOT_ACCESSIBLE_MESSAGE);
    }

    public void checkIfLockedUserErrorDisplayed() {
        assertThat(page.locator(ERROR_MESSAGE_CONTAINER_SELECTOR)).hasText(LOCKED_USER_MESSAGE);
    }
}
