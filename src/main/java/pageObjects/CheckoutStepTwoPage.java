package pageObjects;

import com.microsoft.playwright.Page;
import enums.Products;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CheckoutStepTwoPage {

    private final String FINISH_BUTTON_SELECTOR = "#finish";
    private final String INVENTORY_ITEM_NAME_SELECTOR = ".inventory_item_name";
    private final String INVENTORY_ITEM_DESC_SELECTOR = ".inventory_item_desc";
    private final String INVENTORY_ITEM_PRICE_SELECTOR = ".inventory_item_price";
    private final String SUMMARY_SUBTOTAL_LABEL_SELECTOR = ".summary_subtotal_label";
    private final String SUMMARY_TAX_LABEL_SELECTOR = ".summary_tax_label";

    private final Page page;

    public CheckoutStepTwoPage(Page page) {
        this.page = page;
    }

    public void completePurchase() {
        page.click(FINISH_BUTTON_SELECTOR);
    }

    public void checkIfExpectedProductDataVisible(Products product) {
        assertThat(page.locator(INVENTORY_ITEM_NAME_SELECTOR)).containsText(product.productName());
        assertThat(page.locator(INVENTORY_ITEM_DESC_SELECTOR)).containsText(product.description());
        assertThat(page.locator(INVENTORY_ITEM_PRICE_SELECTOR)).containsText(product.price().toString());
        assertThat(page.locator(SUMMARY_SUBTOTAL_LABEL_SELECTOR)).containsText(product.price().toString());
        assertThat(page.locator(SUMMARY_TAX_LABEL_SELECTOR)).containsText(product.tax().toString());
    }
}
