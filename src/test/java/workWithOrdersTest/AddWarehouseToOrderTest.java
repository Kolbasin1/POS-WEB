package workWithOrdersTest;

import baseTest.BaseTest;
import org.junit.Test;

public class AddWarehouseToOrderTest extends BaseTest {
    @Test
    public void addWarehouse(){
        loginPage.loginWithValidCred()
                 .checkIsButtonExitDisplayed()
                 .clickOnProcessButton();

        insideTheOrderPage
                 .checkIsButtonConfirmAvailabilityNotActive();

        warehouse
                 .checkIsStockChoiceAvailability()
//                 .checkIsRadioButtonAllIsActive()  //падает, пишет что нет элемента хотя локатор в браузере находит
                 .clickOnSelectWarehouse()
                 .choiceWarehouse(warehouse.selectedWarehouse1)
                 .checkIsButtonConfirmAvailabilityActive();
    }
}
