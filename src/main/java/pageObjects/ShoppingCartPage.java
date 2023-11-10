package pageObjects;

import com.microsoft.playwright.*;

public class ShoppingCartPage {

    private final Page page;

    private final String checkoutButtonSelector = ".checkout_button";

    public ShoppingCartPage(Page page) {
        this.page = page;
    }

    public void checkout() {
        page.click(checkoutButtonSelector);
    }
}
