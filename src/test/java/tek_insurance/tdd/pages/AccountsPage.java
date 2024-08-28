package tek_insurance.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek_insurance.tdd.utility.SeleniumUtility;

import java.util.List;

public class AccountsPage extends SeleniumUtility {
    public AccountsPage(){
        PageFactory.initElements(getDriver(), this);
    }
    @FindBy(xpath = "//table/tbody/tr") public List<WebElement> tablesRows;
    @FindBy(xpath = "//select[@class='chakra-select css-161pkch']") public WebElement showRecordDropDown;
}
