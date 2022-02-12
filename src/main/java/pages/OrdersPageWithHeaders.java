package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrdersPageWithHeaders extends ParentPage{
    @FindBy(xpath = ".//*[contains(text(),'31000007802')]//..//button")
    private WebElement buttonProcess;

    @FindBy(xpath = ".//*[contains(text(),'31000007802')]//..//*[@class='StatusName']")
    private WebElement orderStatus;

    public OrdersPageWithHeaders(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnProcessButton(){
        clickOnElement(buttonProcess);
    }

    public OrdersPageWithHeaders checkOrderStatus(String text) {
        webDriverWait10.until(ExpectedConditions.visibilityOf(orderStatus));
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
}
