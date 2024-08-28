package tek_insurance.tdd.browsers;

import org.openqa.selenium.WebDriver;

public interface BaseBrowser {
    WebDriver openBrowser(boolean isHeadless);
}
