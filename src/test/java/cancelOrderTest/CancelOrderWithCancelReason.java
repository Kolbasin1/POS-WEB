package cancelOrderTest;

import baseTest.BaseTest;
import org.junit.Test;

public class CancelOrderWithCancelReason extends BaseTest {
    @Test
    public void cancelOrderWithCancelReason(){
        loginPage
                .loginWithValidCred()
                .checkIsButtonExitDisplayed()
                .clickOnProcessButton();

        insideTheOrderPage
                .checkIsButtonConfirmAvailabilityNotActive()
                .checkIsButtonCancelOrderActive()
                .checkIsOrderStatusDisplay()
                .checkOrderStatus("Новый")
        ;

        insideTheOrderPage
                .clickButtonCancelOrder();

        informationBoxOnThePage
                .checkIsInfoBoxWithCancelReason()
                .checkAvailableCancelReason()
                .checkIsButtonCancelOrderNotActive()
                .clickCancelReasonRadiobutton()
                .checkIsButtonCancelOrderActive()
                .clickButtonCancelOrder()
        ;

        insideTheOrderPage
                .checkIsButtonConfirmAvailabilityNotActiveNotDisplay()
                .checkIsButtonConfirmAvailabilityActiveNotDisplay()
                .checkIsButtonCancelOrderActiveNotDisplay()
                .checkOrderStatus("Отменен");

    }
}
