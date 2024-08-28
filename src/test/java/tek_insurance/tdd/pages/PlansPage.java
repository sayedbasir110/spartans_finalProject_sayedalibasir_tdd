package tek_insurance.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek_insurance.tdd.utility.SeleniumUtility;

import java.util.List;

public class PlansPage extends SeleniumUtility {
    public PlansPage(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "//table/tbody/tr") public List<WebElement> tablesRows;
    @FindBy(xpath = "//table/tbody/tr/td[4]") public List<WebElement> dateCreatedRows;
    @FindBy(xpath = "//table/tbody/tr/td[5]") public List<WebElement> dateExpiredRows;
}
