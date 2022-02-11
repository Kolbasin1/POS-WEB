package cancelOrderTest;

import baseTest.BaseTest;
import org.junit.Test;

public class CancelOrderTest extends BaseTest {
    @Test
    public void cancelOrderNotAvailable(){
        loginPage
                .loginWithValidCred()
                .checkIsButtonExitDisplayed()
                .clickOnProcessButton();

        insideTheOrderPage
                .checkIsButtonConfirmAvailabilityNotActive()
                .checkIsOrderStatusDisplay()
                .checkOrderStatus("Новый");

        insideTheOrderPage
                .checkIsButtonNotAvailableDisplay()
                .clickOnButtonNotAvailable()
        ;
    }
}
