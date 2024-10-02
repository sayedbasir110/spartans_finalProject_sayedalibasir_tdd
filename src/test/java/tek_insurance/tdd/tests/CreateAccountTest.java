package tek_insurance.tdd.tests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tek_insurance.tdd.base.UIBaseClass;
import tek_insurance.tdd.utility.NewAccountDetails;

public class CreateAccountTest extends UIBaseClass {
    public void createAccount(NewAccountDetails newAccountDetails){
        clickOnElement(homePage.createPrimaryAccountBtn);
        createAccountPage.fillUpNewAccountForm(
                newAccountDetails.getEmail(),
                newAccountDetails.getTitle(),
                newAccountDetails.getFirstName(),
                newAccountDetails.getLastName(),
                newAccountDetails.getGender(),
                newAccountDetails.getMaritalStatus(),
                newAccountDetails.getEmploymentStatus(),
                newAccountDetails.getDateOfBirth()
        );
    }
    @Test // scenario 1
    public void verifyNavigationToCreatePrimaryAccountForm(){
        clickOnElement(homePage.createPrimaryAccountBtn);
        String actualCreateAccountFormTitle = getElementText(createAccountPage.createPrimaryAccountFormTitle);
        Assert.assertEquals(actualCreateAccountFormTitle, "Create Primary Account Holder" , "Form title should match");
    }
    @Test(dataProvider = "validData") // scenario 2
    public void createNewAccount_withValidData_shouldMatchEmail(NewAccountDetails newAccountDetails){
        createAccount(newAccountDetails);
        String actualAccountEmail = getElementText(signUpPage.accountEmail);
        Assert.assertEquals(actualAccountEmail, newAccountDetails.getEmail(), "Account Email should match");
    }
    @DataProvider(name = "validData")
    public NewAccountDetails[] validData(){
        return new NewAccountDetails[]{
                new NewAccountDetails("random","Mr.","John","Doe","Male","Single","Self employed","02/01/1996")
        };
    }
    @Test(dataProvider = "existingEmailTestData") // scenario 3
    public void createNewAccount_withExistingEmail_ValidateErrorMessage(NewAccountDetails newAccountDetails){
        createAccount(newAccountDetails);
        String actualErrorMessage = getElementText(createAccountPage.errorMessage);
        Assert.assertEquals(actualErrorMessage, "ERROR\n"+"Account with email "+ newAccountDetails.getEmail()+" is exist", "Error message should match");
    }
    @DataProvider(name = "existingEmailTestData")
    public NewAccountDetails[] existingEmailTestData(){
        return new NewAccountDetails[]{
                new NewAccountDetails("john.doe@gmail.com","Mr.","John","Doe","Male","Single","Self employed", "02/01/1996")
        };
    }
    @Test(dataProvider = "ageTestData") // scenario 4
    public void createNewAccount_withAgeLessThan18_ValidateErrorMessage(NewAccountDetails newAccountDetails){
        createAccount(newAccountDetails);
        String actualErrorMessage = getElementText(createAccountPage.errorMessage);
        Assert.assertEquals(actualErrorMessage, "ERROR\n" + "you must be 18 years or older to create account", "Error message should match");
    }
    @DataProvider(name = "ageTestData")
    public NewAccountDetails[] ageTestData(){
        return new NewAccountDetails[]{
                new NewAccountDetails("random","Mr.","John","Doe","Male","Single","Self employed", "02/01/2010")
        };
    }
    @Test(dataProvider = "createAccountTestData") // scenario 5
    public void createAccount_SignUpAndSignIn_ShouldNavigateToPrimaryAccountPortal_ValidateProfileName(NewAccountDetails newAccountDetails) throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        createAccount(newAccountDetails);
        String actualAccountEmail = getElementText(signUpPage.accountEmail);
        softAssert.assertEquals(actualAccountEmail, newAccountDetails.getEmail(), "Account Email should match");
        signUpPage.fillUpSignUpForm(
                newAccountDetails.getUserName(),
                newAccountDetails.getPassword(),
                newAccountDetails.getConfirmPassword()
        );
        Thread.sleep(5000);
        signInPage.doSignIn(newAccountDetails.getUserName(), newAccountDetails.getPassword());
        String actualPageCornerTitle = getElementText(primaryAccountPortalPage.cornerPageTitle);
        softAssert.assertEquals(actualPageCornerTitle, "Primary Account Portal", "Page title should match");
        clickOnElement(primaryAccountPortalPage.profileBtn);
        String actualProfileName = getElementText(primaryAccountPortalPage.profileName);
        softAssert.assertEquals(actualProfileName, newAccountDetails.getFirstName()+" "+ newAccountDetails.getLastName(), "Full name should match");
        softAssert.assertAll();
    }
    @DataProvider(name = "createAccountTestData")
    public NewAccountDetails[] createAccountTestData(){
        return new NewAccountDetails[]{
                new NewAccountDetails("random","Mr.","John","Doe","Male","Single","Self employed", "02/01/1966","random","John@123","John@123")
        };
    }
}
