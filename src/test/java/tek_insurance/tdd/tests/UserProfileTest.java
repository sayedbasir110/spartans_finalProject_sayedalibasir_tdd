package tek_insurance.tdd.tests;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tek_insurance.tdd.base.UIBaseClass;


public class UserProfileTest extends UIBaseClass {
    public void loginAndVerifyPageTitle() {
        SoftAssert softAssert = new SoftAssert();
        clickOnElement(homePage.loginBtn);
        signInPage.doSignIn("supervisor","tek_supervisor");
        String actualPageCornerTitle = getElementText(customerServicePortalPage.cornerPageTitle);
        softAssert.assertEquals(actualPageCornerTitle, "Customer Service Portal", "Corner page title should match");
    }
    @Test //scenario 1
    public void loginWithCSRCredentials_validateProfileInfo(){
        SoftAssert softAssert = new SoftAssert();
        loginAndVerifyPageTitle();
        clickOnElement(customerServicePortalPage.profileBtn);
        String actualUserType = getElementText(customerServicePortalPage.profileUserType);
        softAssert.assertEquals(actualUserType, "CSR", "User type should match");
        String actualFullName = getElementText(customerServicePortalPage.profileFullName);
        softAssert.assertEquals(actualFullName, "Supervisor", "User full name should match");
        String actualUserName = getElementText(customerServicePortalPage.profileUserName);
        softAssert.assertEquals(actualUserName, "supervisor", "Username should match");
        String actualUserAuthorities = getElementText(customerServicePortalPage.profileAuthorities);
        softAssert.assertEquals(actualUserAuthorities, "admin", "User authorities should match");
        softAssert.assertAll();
    }
    @Test // scenario 2
    public void loginWithCSRCredentials_validateLogOut(){
        SoftAssert softAssert = new SoftAssert();
        loginAndVerifyPageTitle();
        clickOnElement(customerServicePortalPage.profileBtn);
        clickOnElement(customerServicePortalPage.logoutBtn);
        boolean isHomePageHeaderDisplayed = isElementDisplayed(homePage.homePageHeaderMsg);
        softAssert.assertTrue(isHomePageHeaderDisplayed, "Header message should be displayed");
        softAssert.assertAll();
    }
}
