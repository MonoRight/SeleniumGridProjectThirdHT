package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{

    @FindBy(xpath = "//li[@class='menu-list__item full']/a[contains(text(),'Чоловікам')]")
    private WebElement categoryForMan;
    @FindBy(xpath = "//div[@class='menu-column-header']/a[contains(text(), 'Чоловіча парфумерія')]")
    private List<WebElement> manParfumList;
    @FindBy(xpath = "//ul[@class='simple-slider-list']//a[@class='simple-slider-list__image']")
    private List<WebElement> productsList;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getProductFromProductListByIndex(int index){
        return productsList.get(index);
    }
    public WebElement returnWebElementFromManParfumList(int index){
        return manParfumList.get(index);
    }

    public void goToManParfumesCategory(long waitTime){
        actions.moveToElement(categoryForMan).build().perform();
        actions.moveToElement(waitVisibilityOfElement(waitTime, returnWebElementFromManParfumList(1))).build().perform();
        returnWebElementFromManParfumList(1).click();
    }

}
