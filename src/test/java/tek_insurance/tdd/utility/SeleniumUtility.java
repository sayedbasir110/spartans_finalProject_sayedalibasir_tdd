package tek_insurance.tdd.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import tek_insurance.tdd.base.BaseSetup;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SeleniumUtility extends BaseSetup {
    private static final Logger LOGGER = LogManager.getLogger(SeleniumUtility.class);
    public WebDriverWait getWait(){
        return new WebDriverWait(getDriver(), Duration.ofSeconds(WAIT_TIME_IN_SECONDS));
    }
    public WebElement waitForVisibility(WebElement element){
        return getWait().until(ExpectedConditions.visibilityOf(element));
    }
    public void clickOnElement(WebElement element){
        LOGGER.info("Clicking on {} element",element);
        getWait().until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public String getElementText(WebElement element){
        LOGGER.info("Getting {} text", element);
        return waitForVisibility(element).getText();
    }
    public void sendTextToElement (WebElement element, String text){
        LOGGER.info("Sending {} to the {} element", text, element);
        WebElement webElement = waitForVisibility(element);
        webElement.clear();
        webElement.sendKeys(text);
    }
    public boolean isElementDisplayed(WebElement element){
        LOGGER.info("Checking if {} element is displayed", element);
        return waitForVisibility(element).isDisplayed();
    }
    public String getPageTitle(){
        LOGGER.info("Getting page title");
         return getDriver().getTitle();
    }
    public void selectFromDropDown(WebElement element, String optionText){
        LOGGER.info("Selecting {} from dropdown {},", optionText, element);
        WebElement dropDownElement = waitForVisibility(element);
        Select dropDown = new Select(dropDownElement);
        dropDown.selectByVisibleText(optionText);
    }
    public void sendDateToDateInput(WebElement element, LocalDate date){
        LOGGER.info("Sending {} to {}", date,element);
//        String formatedDate = date.format(DateTimeFormatter.ofPattern("yyyyyy-MM-dd"));
//        waitForVisibility(element).sendKeys(formatedDate);
        waitForVisibility(element).sendKeys(date.toString());
    }
    public List<WebElement> getElements(List<WebElement> elements){
        LOGGER.info("getting all elements {}", elements);
        return getWait().until(ExpectedConditions.visibilityOfAllElements(elements));
    }
}
