import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class AddToCartTests extends BaseTest{
    private static final long DEFAULT_WAITING_TIME = 30;
    private static final int COUNT_OF_DIFFERENT_PRODUCTS_TO_ADD_TO_CART = 1;

    @Test
    public void checkTotalPriceOfCart() {
        getHomePage().goToManParfumesCategory(DEFAULT_WAITING_TIME);

        getManParfumePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getManParfumePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        for(int i = 0; i < COUNT_OF_DIFFERENT_PRODUCTS_TO_ADD_TO_CART; i++){
            getManParfumePage().scrollToElement(getManParfumePage().getWebElementByIndexFromParfumesList(i), DEFAULT_WAITING_TIME);
            getManParfumePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
            getManParfumePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
            getManParfumePage().moveToElementWithWait(getManParfumePage().getWebElementByIndexFromParfumesList(i),DEFAULT_WAITING_TIME);
            getManParfumePage().waitWebElement(getManParfumePage().getWebElementByIndexFromButtonsToAddToCartParfumesList(i),DEFAULT_WAITING_TIME);
            getManParfumePage().moveToElementWithWait(getManParfumePage().getWebElementByIndexFromButtonsToAddToCartParfumesList(i),DEFAULT_WAITING_TIME);
            getManParfumePage().clickTheWebElementWithWait(getManParfumePage().getWebElementByIndexFromButtonsToAddToCartParfumesList(i), DEFAULT_WAITING_TIME);

            getManParfumePage().clickTheWebElementWithWait(getManParfumePage().getButtonToCloseCartWindow(),DEFAULT_WAITING_TIME);
        }


        assertEquals(COUNT_OF_DIFFERENT_PRODUCTS_TO_ADD_TO_CART, getManParfumePage().CountOfProductsInCart());
        getManParfumePage().scrollToTop();
        getManParfumePage().waitWebElement(getManParfumePage().getCartElement(), DEFAULT_WAITING_TIME);
        getManParfumePage().clickTheWebElementWithWait(getManParfumePage().getCartElement(),DEFAULT_WAITING_TIME);

        assertEquals(getManParfumePage().calculateTotalSumOfCart(COUNT_OF_DIFFERENT_PRODUCTS_TO_ADD_TO_CART), getManParfumePage().getTotalCartPrice(DEFAULT_WAITING_TIME));
    }
}
