package tek_insurance.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek_insurance.tdd.utility.SeleniumUtility;

public class PrimaryAccountPortalPage extends SeleniumUtility {
    public PrimaryAccountPortalPage(){
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy(xpath = "//h2[text()='Primary Account Portal']") public WebElement cornerPageTitle;
    @FindBy(xpath = "//button[@aria-label='profile']") public WebElement profileBtn;
    @FindBy(xpath = "//p[text()='FULL NAME']/following-sibling::p") public WebElement profileName;

}
