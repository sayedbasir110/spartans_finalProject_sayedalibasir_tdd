package tek_insurance.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek_insurance.tdd.utility.SeleniumUtility;

public class CreateAccountPage extends SeleniumUtility {
    public CreateAccountPage(){
        PageFactory.initElements(getDriver(), this);
    }
    @FindBy(xpath = "//h2[contains(text(), 'Create Primary')]") public WebElement createPrimaryAccountFormTitle;
    @FindBy(name = "email") public WebElement emailInput;
    @FindBy(name = "title") public WebElement titleInput;
    @FindBy(name = "firstName") public WebElement firstNameInput;
    @FindBy(name = "lastName") public WebElement lastNameInput;
    @FindBy(name = "gender") public WebElement genderInput;
    @FindBy(name = "maritalStatus") public WebElement maritalStatusInput;
    @FindBy(name = "employmentStatus") public WebElement employmentStatusInput;
    @FindBy(name = "dateOfBirth") public WebElement dateOfBirthInput;
    @FindBy(xpath = "//button[text()='Create Account']") public WebElement createAccountBtn;
    @FindBy(xpath = "//div[@data-status='error'][@role='alert']") public WebElement errorMessage;

    public void fillUpNewAccountForm(String email, String title, String firstName, String lastName, String gender, String maritalStatus, String employmentStatus, String year, String month, String day){
        sendTextToElement(emailInput, email);
        selectFromDropDown(titleInput, title);
        sendTextToElement(firstNameInput, firstName);
        sendTextToElement(lastNameInput, lastName);
        selectFromDropDown(genderInput, gender);
        selectFromDropDown(maritalStatusInput, maritalStatus);
        sendTextToElement(employmentStatusInput, employmentStatus);
        sendDateToDateInput(dateOfBirthInput, year,month,day);
        clickOnElement(createAccountBtn);
    }
}
