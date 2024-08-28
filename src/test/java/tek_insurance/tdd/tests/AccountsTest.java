package tek_insurance.tdd.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tek_insurance.tdd.base.UIBaseClass;
import java.util.List;

public class AccountsTest extends UIBaseClass {

    public void loginAndNavigateToAccountsPage() {
        SoftAssert softAssert = new SoftAssert();
        clickOnElement(homePage.loginBtn);
        signInPage.doSignIn("supervisor","tek_supervisor");
        String actualPageCornerTitle = getElementText(customerServicePortalPage.cornerPageTitle);
        softAssert.assertEquals(actualPageCornerTitle, "Customer Service Portal", "Corner page title should match");
        clickOnElement(customerServicePortalPage.accountsPageLink);
    }
    @Test
    public void loginWithCSRCredentials_navigateToAccountsPage_validateDataRows(){
        SoftAssert softAssert = new SoftAssert();
        loginAndNavigateToAccountsPage();
        List<WebElement> actualTableRows = getElements(accountsPage.tablesRows);
        softAssert.assertEquals(actualTableRows.size(), 5,"Numbers of rows should match");
        softAssert.assertAll();
    }
    @Test
    public void loginWithCSRCredentials_navigateToAccountsPage_changeRecordShowPerPage_validateRecordCounts(){
        SoftAssert softAssert = new SoftAssert();
        loginAndNavigateToAccountsPage();
        List<WebElement> actualTableRows = getElements(accountsPage.tablesRows);
        selectFromDropDown(accountsPage.showRecordDropDown, "Show 10");
        softAssert.assertEquals(actualTableRows.size(), 10, "Record counts should match");
        selectFromDropDown(accountsPage.showRecordDropDown, "Show 25");
        softAssert.assertEquals(actualTableRows.size(), 25, "Record counts should match");
        selectFromDropDown(accountsPage.showRecordDropDown, "Show 50");
        softAssert.assertEquals(actualTableRows.size(), 50, "Record counts should match");
        softAssert.assertAll();
    }
}
