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
                .checkIsButtonConfirmAvailabilityActive()
                .checkTextIsButtonConfirmAvailabilityActive("ОТПРАВИТЬ НА УТОЧНЕНИЕ")
                .clickOnButtonConfirmAvailability();

        informationBoxOnThePage
                .checkIsInfoBox()
                .checkTextInToInfoBoxNotAvailable("Товара нет в наличии")
                .clickButtonConfirmForPacking()
                .checkIsInfoBox()
                .clickButtonConfirmForPacking();

        insideTheOrderPage
                .checkIsOrderStatusDisplay()
                .checkOrderStatus("Отменен");
    }
}
