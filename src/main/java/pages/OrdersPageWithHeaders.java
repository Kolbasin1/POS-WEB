package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrdersPageWithHeaders extends ParentPage{
    @FindBy(xpath = ".//*[contains(text(),'31000029628')]//..//button")
    private WebElement buttonProcess;

    @FindBy(xpath = ".//*[contains(text(),'31000029628')]//..//*[@class='StatusName']")
    private WebElement orderStatus;

    public OrdersPageWithHeaders(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnProcessButton(){
        clickOnElement(buttonProcess);
    }

    public OrdersPageWithHeaders checkOrderStatus(String text) {
        waitTime();
        Assert.assertEquals("Status is not actual", text, orderStatus.getText());
        logger.info("order status is " + orderStatus.getText());
        return this;
    }

    private boolean isOrderStatusDisplay() {
        return isElementDisplayed(orderStatus);
    }

    public OrdersPageWithHeaders checkIsOrderStatusDisplay() {
        waitTime();
        Assert.assertTrue("Order status is not displayed", isOrderStatusDisplay());
        return this;
    }

//    public OrdersPageWithHeaders checkStatusNew() {
//        waitTime();
//        Assert.assertTrue("Status not NEW", isStatusNewDisplayed());
//        return this;
//    }

//    private boolean isStatusNewDisplayed() {
//        return isElementDisplayed(statusNew);
//    }
}
