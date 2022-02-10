package orderProcessTest;

import baseTest.BaseTest;
import org.junit.Test;

public class SwitchToPackagingTest extends BaseTest {
    @Test
    public void goToOnPacking(){
        loginPage
                .loginWithValidCred()
                .checkIsButtonExitDisplayed()
                .clickOnProcessButton();

        insideTheOrderPage
                .checkIsButtonConfirmAvailabilityNotActive()
                .checkIsOrderStatusDisplay()
                .checkOrderStatus("Новый");

        warehouse
                .addWarehouseToOrder();

        insideTheOrderPage
                .checkIsButtonConfirmAvailabilityActive()
                .clickOnButtonConfirmAvailability();

        informationBoxOnThePage
                .checkIsInfoBox()
                .clickButtonConfirmForPacking();

        insideTheOrderPage
                .checkIsButtonAddBoxDisplayed()
                .checkIsButtonCompletePackingNotActive()
                .checkOrderStatus("На упаковке");

    }
}
