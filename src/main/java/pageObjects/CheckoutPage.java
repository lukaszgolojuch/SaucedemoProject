package pageObjects;

import com.microsoft.playwright.*;

public class CheckoutPage {

    private final Page page;

    private final String FIRST_NAME_INPUT_SELECTOR = "#first-name";
    private final String LAST_NAME_INPUT_SELECTOR = "#last-name";
    private final String ZIP_INPUT_SELECTOR = "#postal-code";
    private final String CONTINUE_BUTTON_SELECTOR = ".checkout_buttons .btn_primary";

    public CheckoutPage(Page page) {
        this.page = page;
    }

    public void enterShippingInformation(String firstName, String lastName, String zip) {
        page.type(FIRST_NAME_INPUT_SELECTOR, firstName);
        page.type(LAST_NAME_INPUT_SELECTOR, lastName);
        page.type(ZIP_INPUT_SELECTOR, zip);
        page.click(CONTINUE_BUTTON_SELECTOR);
    }
}
