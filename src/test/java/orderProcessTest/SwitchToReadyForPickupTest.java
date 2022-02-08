package orderProcessTest;

import baseTest.BaseTest;
import org.junit.Test;

public class SwitchToReadyForPickupTest extends BaseTest {
    @Test
    public void goToOnReadyForPickup(){
        loginPage
                .loginWithValidCred()
                .checkIsButtonExitDisplayed()
                .clickOnProcessButton();

        insideTheOrderPage
                .checkIsButtonConfirmAvailabilityNotActive()
                .checkIsOrderStatusDisplay()
                .checkOrderStatus("Новый");
    }
}
