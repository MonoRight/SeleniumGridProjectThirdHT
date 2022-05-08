import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class AddCommentTests extends BaseTest{
    private static final long DEFAULT_WAITING_TIME = 30;
    private static final int INDEX_OF_FIRST_PRODUCT = 0;
    private static final String TEST_MESSAGE_COMMENT = "testestestest";
    private static final String VALID_EMAIL = "testemail@gmail.com";

    @Test
    public void tryToAddCommentWithInvalidEmail(){
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getHomePage().clickTheWebElementWithWait(getHomePage().getProductFromProductListByIndex(INDEX_OF_FIRST_PRODUCT),DEFAULT_WAITING_TIME);
        getProductPage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getProductPage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getProductPage().clickTheWebElementWithWait(getProductPage().getAddCommentOrAskButton(),DEFAULT_WAITING_TIME);
        getProductPage().enterInput(getProductPage().waitWebElement(getProductPage().getNameSurnameInput(),DEFAULT_WAITING_TIME),TEST_MESSAGE_COMMENT);
        getProductPage().enterInput(getProductPage().waitWebElement(getProductPage().getEmailInput(),DEFAULT_WAITING_TIME),TEST_MESSAGE_COMMENT);
        getProductPage().enterInput(getProductPage().waitWebElement(getProductPage().getCommentTextArea(),DEFAULT_WAITING_TIME),TEST_MESSAGE_COMMENT);
        getProductPage().clickTheWebElementWithWait(getProductPage().getSetFiveStarToProductLabel(),DEFAULT_WAITING_TIME);
        getProductPage().clickTheWebElement(getProductPage().getAddCommentButton());
        getProductPage().waitWebElement(getProductPage().getErrorMessageAfterAddingComment(), DEFAULT_WAITING_TIME);

        assertTrue(getProductPage().getTextFromErrorMessageAfterAddingComment().contains("Будь-ласка, введіть email корректно"));
    }

    @Test
    public void tryToAddCommentWithValidEmail(){
        getHomePage().clickTheWebElementWithWait(getHomePage().getProductFromProductListByIndex(INDEX_OF_FIRST_PRODUCT),DEFAULT_WAITING_TIME);
        getProductPage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getProductPage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getProductPage().clickTheWebElementWithWait(getProductPage().getAddCommentOrAskButton(),DEFAULT_WAITING_TIME);
        getProductPage().enterInput(getProductPage().waitWebElement(getProductPage().getNameSurnameInput(),DEFAULT_WAITING_TIME),TEST_MESSAGE_COMMENT);
        getProductPage().enterInput(getProductPage().waitWebElement(getProductPage().getEmailInput(),DEFAULT_WAITING_TIME),VALID_EMAIL);
        getProductPage().enterInput(getProductPage().waitWebElement(getProductPage().getCommentTextArea(),DEFAULT_WAITING_TIME),TEST_MESSAGE_COMMENT);
        getProductPage().clickTheWebElementWithWait(getProductPage().getSetFiveStarToProductLabel(),DEFAULT_WAITING_TIME);
        getProductPage().clickTheWebElement(getProductPage().getAddCommentButton());
        getProductPage().waitWebElement(getProductPage().getErrorMessageAfterAddingComment(), DEFAULT_WAITING_TIME);

        assertTrue(getProductPage().getTextFromSuccessMessageAfterAddingComment().contains("Ваш відгук успішно додано!"));
    }
}
