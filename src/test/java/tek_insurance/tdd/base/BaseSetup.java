package tek_insurance.tdd.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import tek_insurance.tdd.browsers.BaseBrowser;
import tek_insurance.tdd.browsers.ChromeBrowser;
import tek_insurance.tdd.browsers.EdgeBrowser;
import tek_insurance.tdd.browsers.FirefoxBrowser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.Cleaner;
import java.time.Duration;
import java.util.Properties;

public abstract class BaseSetup {
private static WebDriver driver;
private static final Logger LOGGER = LogManager.getLogger(BaseSetup.class);
private final Properties properties;
protected static final int WAIT_TIME_IN_SECONDS = 25;

public BaseSetup(){
    String configFilePath = System.getProperty("user.dir") + "/src/test/resources/configs/dev-config.properties";
    try {
        LOGGER.debug("Reading config file from {}", configFilePath);
        InputStream inputStream = new FileInputStream(configFilePath);
        properties = new Properties();
        properties.load(inputStream);
    } catch (IOException ex){
        LOGGER.error("Config file error with {}", ex.getMessage());
        throw new RuntimeException("Config file error with message" + ex.getMessage());
    }
}
public void setupBrowser(){
    String browserType = properties.getProperty("ui.browser");
    boolean isHeadless = Boolean.parseBoolean(properties.getProperty("ui.browser.headless"));
    LOGGER.info("Running on {} and isHeadless: {}",browserType,isHeadless);
    BaseBrowser browser;
    if (browserType.equalsIgnoreCase("chrome")) browser = new ChromeBrowser();
    else if (browserType.equalsIgnoreCase("edge")) browser = new EdgeBrowser();
    else if (browserType.equalsIgnoreCase("firefox")) browser = new FirefoxBrowser();
    else throw new RuntimeException("Wrong browser type, choose between chrome, edge, or firefox!");
    driver = browser.openBrowser(isHeadless);

    String url = properties.getProperty("ui.url");
    driver.get(url);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_TIME_IN_SECONDS));
    driver.manage().window().maximize();
}
public void closeBrowser(){
    if (driver!= null) driver.quit();
}
public WebDriver getDriver(){
    return driver;
}
}
