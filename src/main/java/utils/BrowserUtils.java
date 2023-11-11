package utils;

import com.microsoft.playwright.*;
import java.util.ResourceBundle;

public class BrowserUtils {

    private static final String TESTING_HEADLESS = "Testing.headless";
    private static final String TESTING_BROWSER = "Testing.browser";

    public static Browser initializeBrowser() {
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(getTestingHeadless());

        switch (getTestingBrowser()) {
            case "Chrome":
                return Playwright.create().chromium().launch(launchOptions);
            case "Firefox":
                return Playwright.create().firefox().launch(launchOptions);
            case "Webkit":
                return Playwright.create().webkit().launch(launchOptions);
            default:
                throw new UnsupportedOperationException();
        }
    }

    private static Boolean getTestingHeadless() {
        if (getRequiredData(TESTING_HEADLESS).equals("false")) {
            return false;
        } else {
            return true;
        }
    }

    private static String getTestingBrowser() {
        return String.valueOf(getRequiredData(TESTING_BROWSER));
    }

    private static String getRequiredData(final String key) {
        return ResourceBundle.getBundle("informationProvider").getString(key);
    }
}