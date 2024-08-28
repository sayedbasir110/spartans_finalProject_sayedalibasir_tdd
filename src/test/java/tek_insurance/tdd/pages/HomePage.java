package tek_insurance.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek_insurance.tdd.utility.SeleniumUtility;

public class HomePage extends SeleniumUtility {
    public HomePage(){
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy(xpath = "//a[@href='/add-primary-account']") public WebElement createPrimaryAccountBtn;
    @FindBy(xpath = "//a[@href='/login']") public WebElement loginBtn;
    @FindBy(xpath = "//h2[text()='Lets get you started']") public WebElement homePageHeaderMsg;




}
