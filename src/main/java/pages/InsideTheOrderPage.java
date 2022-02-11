package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InsideTheOrderPage extends OrdersPageWithHeaders{
    @FindBy(xpath = ".//*[@class='OrderItem-Order-footer-newBtn']//..//button[@class='OrderItem-btn v-btn v-btn--block v-btn--disabled v-btn--depressed theme--light primary--text']")
    private WebElement buttonConfirmAvailabilityNotActive;  // не активная кнопка

    @FindBy(xpath = ".//*[@class='OrderItem-Order-footer-newBtn']//button[@class='OrderItem-btn v-btn v-btn--block v-btn--depressed theme--light primary']")
    private WebElement buttonConfirmAvailabilityActive;   // активная кнопка

    @FindBy(xpath = ".//*[@class='flex OrderItem-Order d-flex justify-space-between align-center f-Column'][1]//..//button[@class='OrderItem-btn-nobg v-btn v-btn--block v-btn--depressed theme--light primary']")
    private WebElement buttonAddBox;  // добавить коробку -- не хочет нажимать на кнопку

    @FindBy(xpath = ".//*[@class='OrderItem-Order-footer-onPackingbtn']//button[@class='OrderItem-btn v-btn v-btn--block v-btn--disabled theme--light primary--text' and @disabled='disabled']")
    private WebElement buttonCompletePackingNotActive;

    @FindBy(xpath = ".//*[@class='OrderItem-Order-footer-onPackingbtn']//button[@class='OrderItem-btn v-btn v-btn--block theme--light primary']")
    private WebElement buttonCompletePackingActive;

    @FindBy(xpath = ".//button[@class='v-btn v-btn--block v-btn--depressed theme--light Item-check-btn']")
    private WebElement buttonNotAvailable;

    public InsideTheOrderPage(WebDriver webDriver) {
        super(webDriver);
    }

    public InsideTheOrderPage checkIsButtonConfirmAvailabilityNotActive() {
        waitTime();
        Assert.assertTrue("Button Confirm Availability is displayed", isButtonConfirmAvailabilityNotActive());
        return this;
    }

    public InsideTheOrderPage checkIsButtonConfirmAvailabilityActive() {
        waitTime();
        Assert.assertTrue("Button is active not displayed", isButtonConfirmAvailabilityActive());
        return this;
    }

    private boolean isButtonConfirmAvailabilityNotActive() {
        return isElementDisplayed(buttonConfirmAvailabilityNotActive);
    }

    private boolean isButtonConfirmAvailabilityActive() {
        return isElementDisplayed(buttonConfirmAvailabilityActive);
    }

    public InsideTheOrderPage clickOnButtonConfirmAvailability() {
        clickOnElement(buttonConfirmAvailabilityActive);
        return this;
    }

    public InsideTheOrderPage checkIsButtonAddBoxDisplayed() {
        waitTime();
        Assert.assertTrue("Button Add Box is not displayed", isButtonAddBoxDisplayed());
        return this;
    }

    private boolean isButtonAddBoxDisplayed() {
        return isElementDisplayed(buttonAddBox);
    }

    public InsideTheOrderPage clickButtonAddBox(){
        webDriverWait10.until(ExpectedConditions.elementToBeClickable(buttonAddBox));
        clickOnElement(buttonAddBox);
        return this;
    }

    public InsideTheOrderPage checkIsButtonCompletePackingNotActive() {
        waitTime();
        Assert.assertTrue("Button CompletePacking is not displayed", isButtonCompletePackingNotActive());
        return this;
    }

    private boolean isButtonCompletePackingNotActive() {
        return isElementDisplayed(buttonCompletePackingNotActive);
    }

    public InsideTheOrderPage checkIsButtonCompletePackingActive() {
        webDriverWait10.until(ExpectedConditions.elementToBeClickable(buttonCompletePackingActive));
        Assert.assertTrue("Button CompletePacking is not displayed", isButtonCompletePackingActive());
        return this;
    }

    private boolean isButtonCompletePackingActive() {
        return isElementDisplayed(buttonCompletePackingActive);
    }

    public InsideTheOrderPage clickButtonCompletePacking() {
        clickOnElement(buttonCompletePackingActive);
        return this;
    }

    public InsideTheOrderPage checkIsButtonNotAvailableDisplay() {
        waitTime();
        Assert.assertTrue("Button NOT AVAILABLE is not displayed", isButtonNotAvailableDisplayed());
        return this;
    }

    private boolean isButtonNotAvailableDisplayed() {
        return isElementDisplayed(buttonNotAvailable);
    }

    public InsideTheOrderPage clickOnButtonNotAvailable() {
        webDriverWait10.until(ExpectedConditions.elementToBeClickable(buttonNotAvailable));
        clickOnElement(buttonNotAvailable);
        return this;
    }
}
