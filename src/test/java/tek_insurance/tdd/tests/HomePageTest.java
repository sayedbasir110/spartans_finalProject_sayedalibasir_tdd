package tek_insurance.tdd.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tek_insurance.tdd.base.UIBaseClass;

public class HomePageTest extends UIBaseClass {
    @Test
    public void validateHomePageTitleAndCreateAccountBtn(){
        String pageTitle = getPageTitle();
        Assert.assertEquals(pageTitle, "TEK Insurance UI", "Page title should match");
        boolean isBtnDisplayed = isElementDisplayed(homePage.createPrimaryAccountBtn);
        Assert.assertTrue(isBtnDisplayed);
    }
}
