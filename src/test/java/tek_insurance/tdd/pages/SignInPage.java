package tek_insurance.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek_insurance.tdd.utility.SeleniumUtility;

public class SignInPage extends SeleniumUtility {
    public SignInPage(){
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy(id = "username") public WebElement userNameInput;
    @FindBy(name = "password") public WebElement passwordInput;
    @FindBy(xpath = "//button[text()='Sign In']") public WebElement signInBtn;
    @FindBy(xpath = "//div[@data-status='error'][@role='alert']") public WebElement errorMessage;

    public void doSignIn(String userName, String password){
        sendTextToElement(userNameInput,userName);
        sendTextToElement(passwordInput,password);
        clickOnElement(signInBtn);
    }
}
