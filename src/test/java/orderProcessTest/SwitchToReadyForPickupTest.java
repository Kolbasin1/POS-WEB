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

        warehouse
                .addWarehouseToOrder();

        insideTheOrderPage
                .checkIsButtonConfirmAvailabilityActive()
                .clickOnButtonConfirmAvailability();

        informationBoxOnThePage
                .checkIsInfoBox()
                .clickButtonConfirmForPacking();

        insideTheOrderPage
                .checkIsButtonAddBox()
                .checkIsButtonCompletePackingNotActive()
                .checkOrderStatus("На упаковке");

        insideTheOrderPage
                .clickButtonAddBox();

        informationBoxOnThePage
                .checkIsInfoBox()
                .checkTextInToInfoBoxBoxAdded("Коробка добавлена")
                .checkIsButtonContinue()
                .clickButtonContinue();

        insideTheOrderPage
                .checkIsButtonCompletePackingActive()
                .clickButtonCompletePacking();

        informationBoxOnThePage
                .checkIsInfoBox()
                .clickButtonConfirmForPacking()
                .checkIsInfoBox()
                .checkTextInToInfoBoxOrderPacking("Заказ доступен для выдачи")
                .clickButtonConfirmForPacking();

        insideTheOrderPage
                .checkIsOrderStatusDisplay()
                .checkOrderStatus("Готов к выдаче");
    }
}
