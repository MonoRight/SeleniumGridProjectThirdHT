import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pages.HomePage;
import pages.ManParfumePage;
import pages.ProductPage;
import utils.CapabilityFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    private static final String MAKEUP_COM_UA_URL = "https://makeup.com.ua/ua/";
    private final CapabilityFactory capabilityFactory = new CapabilityFactory();

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
        driver.set(new RemoteWebDriver(new URL("http://192.168.1.4:4444/wd/hub"), capabilityFactory.getCapabilities(browser)));
        getDriver().manage().window().maximize();
        getDriver().get(MAKEUP_COM_UA_URL);
    }

    @AfterMethod
    public void tearDown() {
        getDriver().close();
    }

    @AfterClass
    void terminate() {
        driver.remove();
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }
    public ManParfumePage getManParfumePage() {
        return new ManParfumePage(getDriver());
    }
    public ProductPage getProductPage(){
        return new ProductPage(getDriver());
    }

}
