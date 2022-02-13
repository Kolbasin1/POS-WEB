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
        clickOnElement(buttonConfirm);
        return this;
    }

    public InformationBoxOnThePopUpp checkTextInToInfoBoxBoxAdded(String text) {
        waitTime();
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
}
