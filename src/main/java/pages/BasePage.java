package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement waitVisibilityOfElement(long timeToWait, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForPageLoadComplete(long timeToWait) {
        new WebDriverWait(driver, timeToWait).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void waitForAjaxToComplete(long timeToWait) {
        new WebDriverWait(driver, timeToWait).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return window.jQuery != undefined && jQuery.active == 0;"));
    }

    public void moveToElementWithWait(WebElement webElement, long waitTime){
        actions.moveToElement(waitVisibilityOfElement(waitTime, webElement)).perform();
    }

    public void scrollToElement(WebElement element, long timeToWait){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void scrollToCoordinates(int x, int y){
        ((JavascriptExecutor) driver).executeScript(String.format("window.scrollBy(%d,%d)",x,y));
    }
    public void scrollToTop(){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
    }

    public void clickTheWebElementWithWait(WebElement webElement,long waitTime){
        waitVisibilityOfElement(waitTime, webElement).click();
    }

    public WebElement waitWebElement(WebElement webElement,long waitTime){
        return waitVisibilityOfElement(waitTime, webElement);
    }

    public void clickTheWebElement(WebElement webElement){
        webElement.click();
    }

    public void enterInput(WebElement webElement, String message){
        webElement.sendKeys(message);
    }
}
