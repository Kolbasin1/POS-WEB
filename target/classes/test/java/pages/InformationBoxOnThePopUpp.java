package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InformationBoxOnThePopUpp extends OrdersPageWithHeaders{
    @FindBy(xpath = ".//*[@class='v-card v-sheet theme--light']")
    private WebElement infoBox;

    @FindBy(xpath = ".//button[@class='NoItem-confirm-btn v-btn v-btn--large theme--light primary']")
    private WebElement buttonConfirm;

    public InformationBoxOnThePopUpp(WebDriver webDriver) {
        super(webDriver);
    }


    public InformationBoxOnThePopUpp checkIsInfoBox() {
        waitTime();
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
}
