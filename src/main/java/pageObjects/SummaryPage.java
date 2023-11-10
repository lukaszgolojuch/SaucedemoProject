package pageObjects;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SummaryPage {

    private final Page page;

    private final String COMPLETE_HEADER_LOCATOR = ".complete-header";

    public SummaryPage(Page page) {
        this.page = page;
    }

    public void checkIfThankYouMessageVisible() {
        assertThat(page.locator(COMPLETE_HEADER_LOCATOR)).isVisible();
    }
}
