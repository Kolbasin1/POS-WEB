package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrdersPage extends OrdersPageWithHeaders{
    @FindBy(xpath = ".//button[@type='button' and @class='text-none text--disabled v-btn v-btn--flat theme--light']")
    private WebElement buttonExit;

    public OrdersPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isButtonExitDisplayed(){
//        try {  // предыдущий вариант
//            return buttonExit.isDisplayed();
//        }catch (Exception e){
//            return false;
//        }
        return isElementDisplayed(buttonExit);  // новый вариант
    }

    public OrdersPage checkIsButtonExitDisplayed(){
//        waitTime();
//  TODO
        webDriverWait10.until(ExpectedConditions.visibilityOf(buttonExit));
        Assert.assertTrue("Button Exit is not displayed", isButtonExitDisplayed());
        return this;
    }

    public OrdersPage checkIsButtonExitNotDisplayed(){
        waitTime();
        Assert.assertFalse("Button Exit is not displayed", isButtonExitDisplayed());
        return this;
    }
}
