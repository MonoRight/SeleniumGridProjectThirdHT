package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
    @FindBy(xpath = "//div[@class='add-comment button-more']")
    private WebElement addCommentOrAskButton;
    @FindBy(xpath = "//div[@class='form__comment-columns']//input[@name='fio']")
    private WebElement nameSurnameInput;
    @FindBy(xpath = "//div[@class='form__comment-columns']//input[@name='email']")
    private WebElement emailInput;
    @FindBy(xpath = "//div[@class='form__comment-columns']//textarea")
    private WebElement commentTextArea;
    @FindBy(xpath = "//li[@title='5']")
    private WebElement setFiveStarToProductLabel;
    @FindBy(xpath = "//button[@class='button']")
    private WebElement addCommentButton;
    @FindBy(xpath = "//div[@class='popup__window message active']//div[@class='popup-content']")
    private WebElement errorMessageAfterAddingComment;
    @FindBy(xpath = "//div[@class='popup__window message active']//div[@class='popup-content']/b")
    private WebElement successMessageAfterAddingComment;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getTextFromErrorMessageAfterAddingComment(){
        return getErrorMessageAfterAddingComment().getText();
    }
    public String getTextFromSuccessMessageAfterAddingComment(){
        return getSuccessMessageAfterAddingComment().getText();
    }

    public WebElement getErrorMessageAfterAddingComment(){
        return errorMessageAfterAddingComment;
    }
    public WebElement getSuccessMessageAfterAddingComment(){ return successMessageAfterAddingComment;}


    public WebElement getAddCommentButton(){
        return addCommentButton;
    }

    public WebElement getSetFiveStarToProductLabel(){
        return setFiveStarToProductLabel;
    }

    public WebElement getAddCommentOrAskButton(){
        return addCommentOrAskButton;
    }

    public WebElement getNameSurnameInput(){
        return nameSurnameInput;
    }

    public WebElement getEmailInput(){
        return emailInput;
    }
    public WebElement getCommentTextArea(){
        return commentTextArea;
    }
}
