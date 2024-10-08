package tek_insurance.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek_insurance.tdd.utility.SeleniumUtility;

public class CustomerServicePortalPage extends SeleniumUtility {
    public CustomerServicePortalPage(){
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy(xpath = "//h2[text()='Customer Service Portal']") public WebElement cornerPageTitle;
    @FindBy(xpath = "//button[@aria-label='profile']") public WebElement profileBtn;
    @FindBy(xpath = "//button[text()='Logout']") public WebElement logoutBtn;
    @FindBy(xpath = "//p[text()='USER TYPE']/following-sibling::p") public WebElement profileUserType;
    @FindBy(xpath = "//p[text()='FULL NAME']/following-sibling::p") public WebElement profileFullName;
    @FindBy(xpath = "//p[text()='USERNAME']/following-sibling::p") public WebElement profileUserName;
    @FindBy(xpath = "//p[text()='AUTHORITIES']//following-sibling::ul") public WebElement profileAuthorities;
    @FindBy(xpath = "//a[@href='/csr/plans']") public WebElement plansPageLink;
    @FindBy(xpath = "//a[@href='/csr/accounts']") public WebElement accountsPageLink;
}
