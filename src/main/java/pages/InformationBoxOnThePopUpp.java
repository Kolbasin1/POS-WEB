package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class InformationBoxOnThePopUpp extends OrdersPageWithHeaders{
    @FindBy(xpath = ".//*[@class='v-card v-sheet theme--light']")
    private WebElement infoBox;

    @FindBy(xpath = ".//button[@class='NoItem-confirm-btn v-btn v-btn--large theme--light primary']")
    private WebElement buttonConfirm;

    @FindBy(xpath = ".//*[@class='v-card v-sheet theme--light']//..//span[@class='NoItem-title-text']")
    private WebElement boxAddedText;

    @FindBy(xpath = ".//button[@class='text-none btnOnGo v-btn v-btn--flat v-btn--large theme--light primary--text']")
    private WebElement buttonConfirmBox;

    @FindBy(xpath = ".//*[@class='v-card v-sheet theme--light']//..//*[@class='NoItem-body']")
    private WebElement orderPackingText;

    @FindBy(xpath = ".//button[@class='NoItem-confirm-btn btnOnGo v-btn v-btn--large theme--light primary']")
    private WebElement buttonContinueWorkWithOrder;

    @FindBy(xpath = ".//*[@class='v-card v-sheet theme--light']//..//span[text()='Товара нет в наличии']")
    private WebElement popupNotAvailable;

    @FindBy(xpath = ".//*[@class='StatusInfo v-card v-sheet theme--light']")
    private WebElement infoBoxWithCancelReason;

    @FindBy(xpath = ".//*[@class='StatusInfo-body']")
    private WebElement levelWithCancelReason;

    @FindBy(xpath = ".//*[@class='StatusInfo-body']//..//*[@role='radiogroup']//..//*[@class='v-radio theme--light'][2]//*[@class='v-input--selection-controls__input']")
    private WebElement radiobuttonCancelReason;

    @FindBy(xpath = ".//button[@class='text-none v-btn v-btn--disabled v-btn--large theme--light primary--text']")
    private WebElement radiobuttonCancelReasonNotActive;

    @FindBy(xpath = ".//button[@class='text-none v-btn v-btn--large theme--light primary'][2]")
    private WebElement buttonCancelOrder;

    public InformationBoxOnThePopUpp(WebDriver webDriver) {
        super(webDriver);
    }


    public InformationBoxOnThePopUpp checkIsInfoBox() {
        webDriverWait10.until(ExpectedConditions.visibilityOf(infoBox));
        Assert.assertTrue("Info box is not displayed", isIsInfoBoxDisplayed());
        return this;
    }

    private boolean isIsInfoBoxDisplayed() {
        return isElementDisplayed(infoBox);
    }

    public InformationBoxOnThePopUpp clickButtonConfirmForPacking() {
        webDriverWait10.until(ExpectedConditions.elementToBeClickable(buttonConfirm));
        clickOnElement(buttonConfirm);
        return this;
    }

    public InformationBoxOnThePopUpp checkTextInToInfoBoxBoxAdded(String text) {
//        waitTime();
        webDriverWait10.until(ExpectedConditions.visibilityOf(boxAddedText));
        Assert.assertEquals("Box was added is not displayed", text, boxAddedText.getText());
        logger.info("Text " + boxAddedText.getText() + " displayed");
        return this;
    }

    public InformationBoxOnThePopUpp checkIsButtonContinue() {
        webDriverWait10.until(ExpectedConditions.visibilityOf(buttonConfirmBox));
        Assert.assertTrue("Button Continue is not displayed", isButtonContinueDisplayed());
        return this;
    }

    private boolean isButtonContinueDisplayed() {
        return isElementDisplayed(buttonConfirmBox);
    }

    public InformationBoxOnThePopUpp clickButtonContinue() {
        clickOnElement(buttonConfirmBox);
        return this;
    }

    public InformationBoxOnThePopUpp checkTextInToInfoBoxOrderPacking(String text) {
        webDriverWait10.until(ExpectedConditions.visibilityOf(orderPackingText));
        Assert.assertEquals("Text does not match", text, orderPackingText.getText());
        logger.info(orderPackingText.getText());
        return this;
    }

    public InformationBoxOnThePopUpp checkIsButtonContinueWorkWithOrder() {
        webDriverWait10.until(ExpectedConditions.visibilityOf(buttonContinueWorkWithOrder));
        Assert.assertTrue("Button ContinueWorkWithOrder is not displayed", isButtonContinueWorkWithOrderDisplayed());
        return this;
    }

    private boolean isButtonContinueWorkWithOrderDisplayed() {
        return isElementDisplayed(buttonContinueWorkWithOrder);
    }

    public InformationBoxOnThePopUpp clickButtonContinueWorkWithOrder() {
        clickOnElement(buttonContinueWorkWithOrder);
        return this;
    }

    public InformationBoxOnThePopUpp checkTextInToInfoBoxNotAvailable(String text) {
        webDriverWait10.until(ExpectedConditions.visibilityOf(popupNotAvailable));
        Assert.assertEquals("This is not a window out of stock", text, popupNotAvailable.getText());
        logger.info(popupNotAvailable);
        return this;
    }

    public InformationBoxOnThePopUpp checkIsInfoBoxWithCancelReason() {
        webDriverWait10.until(ExpectedConditions.visibilityOf(infoBoxWithCancelReason));
        Assert.assertTrue("Box With Cancel Reason is not displayed", isIsInfoBoxWithCancelReasonDisplayed());
        return this;
    }

    private boolean isIsInfoBoxWithCancelReasonDisplayed() {
        return isElementDisplayed(infoBoxWithCancelReason);
    }

    public InformationBoxOnThePopUpp checkAvailableCancelReason() {
        webDriverWait10.until(ExpectedConditions.visibilityOf(levelWithCancelReason));
        Assert.assertTrue("Level with CANCEL REASON is not displayed", isLevelWithCancelReasonDisplayed());
        return this;
    }

    private boolean isLevelWithCancelReasonDisplayed() {
        return isElementDisplayed(levelWithCancelReason);
    }

    public InformationBoxOnThePopUpp clickCancelReasonRadiobutton() {
        webDriverWait10.until(ExpectedConditions.visibilityOf(radiobuttonCancelReason));
        clickOnElement(radiobuttonCancelReason);
        return this;
    }

    public InformationBoxOnThePopUpp checkIsButtonCancelOrderNotActive() {
        webDriverWait10.until(ExpectedConditions.visibilityOf(radiobuttonCancelReasonNotActive));
        Assert.assertTrue("Button Cancel Order Not Active is not displayed", isButtonCancelOrderNotActiveDisplayed());
        return this;
    }

    private boolean isButtonCancelOrderNotActiveDisplayed() {
        return isElementDisplayed(radiobuttonCancelReasonNotActive);
    }

    public InformationBoxOnThePopUpp checkIsButtonCancelOrderActive() {
        webDriverWait10.until(ExpectedConditions.visibilityOf(buttonCancelOrder));
        Assert.assertTrue("Button CANCEL ORDER is not active", isButtonCancelOrderDisplayed());
        return this;
    }

    private boolean isButtonCancelOrderDisplayed() {
        return isElementDisplayed(buttonCancelOrder);
    }

    public InformationBoxOnThePopUpp clickButtonCancelOrder() {
        webDriverWait10.until(ExpectedConditions.elementToBeClickable(buttonCancelOrder));
        clickOnElement(buttonCancelOrder);
        return this;
    }
}
