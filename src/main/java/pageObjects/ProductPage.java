package pageObjects;

import com.microsoft.playwright.*;
import enums.Products;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductPage {

    private final Page page;

    private final String SHOPPING_CART_ICON_SELECTOR = ".shopping_cart_link";
    private final String INVENTORY_DETAILS_NAME_SELECTOR = ".inventory_details_name";
    private final String INVENTORY_DETAILS_DESC_SELECTOR = ".inventory_details_desc";
    private final String INVENTORY_DETAILS_PRICE_SELECTOR = ".inventory_details_price";

    public ProductPage(Page page) {
        this.page = page;
    }

    public void addToCart(Products product) {
        String productSelector = String.format("[data-test='add-to-cart-%s']", product.productName().toLowerCase().replace(" ", "-"));
        page.locator(productSelector).click();
    }

    public void navigateToShoppingCart() {
        page.click(SHOPPING_CART_ICON_SELECTOR);
    }

    public void checkIfExpectedProductDetailsVisible(Products product) {
        assertThat(page.locator(INVENTORY_DETAILS_NAME_SELECTOR)).containsText(product.productName());
        assertThat(page.locator(INVENTORY_DETAILS_DESC_SELECTOR)).containsText(product.description());
        assertThat(page.locator(INVENTORY_DETAILS_PRICE_SELECTOR)).containsText(product.price().toString());
    }
}
