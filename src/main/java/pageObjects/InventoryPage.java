package pageObjects;

import com.microsoft.playwright.Page;
import enums.Products;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class InventoryPage {

    private final Page page;

    private final String BURGER_MENU_BUTTON_SELECTOR = "#react-burger-menu-btn";
    private final String LOGOUT_BUTTON_SELECTOR = "#logout_sidebar_link";

    public InventoryPage(Page page) {
        this.page = page;
    }

    public void openSpecifiedProductPage(Products product) {
        page.getByText(product.productName()).click();
    }

    public void logoutUser() {
        page.locator(BURGER_MENU_BUTTON_SELECTOR).click();
        page.locator(LOGOUT_BUTTON_SELECTOR).click();
    }
}