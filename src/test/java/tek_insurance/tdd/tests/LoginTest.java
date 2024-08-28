package tek_insurance.tdd.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tek_insurance.tdd.base.UIBaseClass;

public class LoginTest extends UIBaseClass {
    @Test // scenario 1
    public void login_WithValidCSRUser_ShouldNavigateToCustomerServicePortal(){
        SoftAssert softAssert = new SoftAssert();
        clickOnElement(homePage.loginBtn);
        signInPage.doSignIn("supervisor","tek_supervisor");
        String actualPageCornerTitle = getElementText(customerServicePortalPage.cornerPageTitle);
        softAssert.assertEquals(actualPageCornerTitle, "Customer Service Portal", "Corner page title should match");
    }
    @Test(dataProvider = "wrongCredentialTestData") // scenario 2
    public void loginWithWrongCredentials_ValidateErrorMessage(String userName, String password, String expectedError){
        SoftAssert softAssert = new SoftAssert();
        clickOnElement(homePage.loginBtn);
        signInPage.doSignIn(userName,password);
        String actualErrorMessage = getElementText(signInPage.errorMessage);
        softAssert.assertEquals(actualErrorMessage,expectedError, "Error message should match");
        softAssert.assertAll();
    }
    @DataProvider(name = "wrongCredentialTestData")
    public Object[][] wrongCredentialTestData(){
        return new Object[][] {
                {"wrongusername","WrongPassword@123", "ERROR\nUser wrongusername not found"},
                {"wrongusername", "tek_supervisor", "ERROR\nUser wrongusername not found"},
                {"supervisor", "WrongPassword@123", "ERROR\nPassword not matched"}
        };
    }
}
