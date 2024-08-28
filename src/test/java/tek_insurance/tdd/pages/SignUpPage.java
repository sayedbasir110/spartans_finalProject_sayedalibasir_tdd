package tek_insurance.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek_insurance.tdd.utility.SeleniumUtility;

public class SignUpPage extends SeleniumUtility {
    public SignUpPage(){
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy(xpath = "//div/h2[3]") public WebElement accountEmail;
    @FindBy(name = "username") public WebElement userNameInput;
    @FindBy(name = "password") public WebElement passwordInput;
    @FindBy(name = "confirm") public WebElement confirmPasswordInput;
    @FindBy(xpath = "//button[text()='Submit']") public WebElement submitBtn;

    public void fillUpSignUpForm(String userName, String password, String confirmPassword){
        sendTextToElement(userNameInput,userName);
        sendTextToElement(passwordInput,password);
        sendTextToElement(confirmPasswordInput,confirmPassword);
        clickOnElement(submitBtn);
    }

}
