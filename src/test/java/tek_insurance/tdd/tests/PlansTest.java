package tek_insurance.tdd.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tek_insurance.tdd.base.UIBaseClass;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PlansTest extends UIBaseClass {

    public void loginAndNavigateToPlansPage() {
        SoftAssert softAssert = new SoftAssert();
        clickOnElement(homePage.loginBtn);
        signInPage.doSignIn("supervisor","tek_supervisor");
        String actualPageCornerTitle = getElementText(customerServicePortalPage.cornerPageTitle);
        softAssert.assertEquals(actualPageCornerTitle, "Customer Service Portal", "Corner page title should match");
        clickOnElement(customerServicePortalPage.plansPageLink);
    }
    @Test // scenario 1
    public void loginWithCSRCredentials_navigateToPlansPage_ValidateDataRows(){
        SoftAssert softAssert = new SoftAssert();
        loginAndNavigateToPlansPage();
        List<WebElement> actualTableRows = getElements(plansPage.tablesRows);
        softAssert.assertEquals(actualTableRows.size(), 4,"Number of rows should match");
        softAssert.assertAll();
    }
    @Test // scenario 2
    public void loginWithCSRCredentials_navigateToPlansPage_ValidateCreateAndExpiryDates(){
        SoftAssert softAssert = new SoftAssert();
        loginAndNavigateToPlansPage();
        List<WebElement> actualDateCreatedRows = getElements(plansPage.dateCreatedRows);
        for (WebElement eachRow : actualDateCreatedRows){
            softAssert.assertEquals(eachRow.getText(), LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM d, yyyy")), "Created date in rows should match today's date");
        }
        List<WebElement> actualDateExpiredRows = getElements(plansPage.dateExpiredRows);
        for (WebElement eachRow : actualDateExpiredRows){
            softAssert.assertEquals(eachRow.getText(), LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("MMMM d, yyyy")), "Expiry date in rows should match tomorrow's date");
        }
        softAssert.assertAll();
    }
}
