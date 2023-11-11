package utils;

import com.microsoft.playwright.*;

public class BrowserUtils {

    public static Browser initializeBrowser() {
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(false);
        return Playwright.create().chromium().launch(launchOptions);
    }
}