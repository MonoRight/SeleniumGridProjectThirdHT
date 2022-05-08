package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ManParfumePage extends BasePage{
    @FindBy(xpath = "//div[@class='catalog-products']/ul[@class='simple-slider-list']/li")
    private List<WebElement> parfumesList;
    @FindBy(xpath = "//div[@class='simple-slider-list-buttons']/div[@class='button buy']")
    private List<WebElement> buttonsToAddToCartParfumesList;
    @FindBy(xpath = "//ul[@class='simple-slider-list']//span[@class='simple-slider-list__price']/span[@class='price_item']")
    private List<WebElement> spanPricesOfParfumesList;
    @FindBy(xpath = "//div[@class='popup__window']/div[@class='popup-close close-icon']")
    private WebElement buttonToCloseCartWindow;
    @FindBy(xpath = "//div[@class='header-basket']/span/span")
    private WebElement spanCountOfProductsInCart;
    @FindBy(xpath = "//div[@class='header-basket']/span")
    private WebElement cartElement;
    @FindBy(xpath = "//div[@class='total']//strong")
    private WebElement totalCartPrice;

    public ManParfumePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getCartElement(){
        return cartElement;
    }

    public WebElement getTotalCartPrice(){
        return totalCartPrice;
    }

    public int getTotalCartPrice(long waitTime){
        return Integer.parseInt(waitWebElement(getTotalCartPrice(), waitTime).getText());
    }

    public WebElement getSpanCountOfProductsInCart(){
        return spanCountOfProductsInCart;
    }

    public int CountOfProductsInCart(){
        return Integer.parseInt(getSpanCountOfProductsInCart().getText().replaceAll("\\D+",""));
    }

    public WebElement getButtonToCloseCartWindow(){
        return buttonToCloseCartWindow;
    }

    public WebElement getWebElementByIndexFromParfumesList(int index){
        return parfumesList.get(index);
    }

    public WebElement getWebElementByIndexFromButtonsToAddToCartParfumesList(int index){
        return buttonsToAddToCartParfumesList.get(index);
    }

    public WebElement getWebElementByIndexFromSpanPricesOfParfumesList(int index){
        return spanPricesOfParfumesList.get(index);
    }

    public int calculateTotalSumOfCart(int productCount){
        int sum = 0;

        for(int i = 0; i < productCount; i++){
            sum += Integer.parseInt(getWebElementByIndexFromSpanPricesOfParfumesList(i).getText());
        }

        return sum;
    }
}
