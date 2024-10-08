package tek_insurance.tdd.base;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import tek_insurance.tdd.pages.*;
import tek_insurance.tdd.utility.SeleniumUtility;

@Listeners({ExtentITestListenerClassAdapter.class})
public class UIBaseClass extends SeleniumUtility {
    private static final Logger LOGGER = LogManager.getLogger(UIBaseClass.class);
    public HomePage homePage;
    public CreateAccountPage createAccountPage;
    public SignUpPage signUpPage;
    public SignInPage signInPage;
    public PrimaryAccountPortalPage primaryAccountPortalPage;
    public CustomerServicePortalPage customerServicePortalPage;
    public PlansPage plansPage;
    public AccountsPage accountsPage;
    @BeforeMethod
    public void beforeEachTest(){
        LOGGER.info("Setup test and opening browser");
        setupBrowser();
        homePage = new HomePage();
        createAccountPage = new CreateAccountPage();
        signUpPage = new SignUpPage();
        signInPage = new SignInPage();
        primaryAccountPortalPage = new PrimaryAccountPortalPage();
        customerServicePortalPage = new CustomerServicePortalPage();
        plansPage = new PlansPage();
        accountsPage = new AccountsPage();
    }
    @AfterMethod
    public void testCleanUp(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
            TakesScreenshot screenshot = (TakesScreenshot) getDriver();
            String shot = screenshot.getScreenshotAs(OutputType.BASE64);
            ExtentTestManager.getTest().fail("Test failed, Taking screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(shot).build());
        }
        LOGGER.info("Running after each test and quit browser");
        closeBrowser();
    }
}
