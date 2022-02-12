package pages;

import libs.TestDataTest;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage{
    @FindBy(xpath = ".//input[@aria-label='Логин']") // будут инициализированы в ParentPage в классе конструкторе
    private WebElement inputLoginEnter;

    @FindBy(xpath = ".//input[@aria-label='Пароль']")
    private WebElement inputPassWordEnter;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement buttonEnter;

    @FindBy(xpath = ".//*[@class='v-input__control']//*[@class='v-messages__message']")
    private WebElement errorAuthorization;

    @FindBy(xpath = ".//*[@class='v-input v-text-field v-input--has-state theme--light error--text' and @label='Логин']")
    private WebElement errorMassageLoginField;

    @FindBy(xpath = ".//*[@class='v-input v-text-field v-input--has-state theme--light error--text' and @label='Пароль']")
    private WebElement errorMassagePasswordField;


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage(){
        try {
            webDriver.get(TestDataTest.URL_TEST);
            logger.info("Login Page was opened");
        }catch (Exception e){
            logger.error("Can not open Login Page" + e);
            Assert.fail("Can not open Login Page" + e);
        }
    }

    public void enterLoginIntoInputLogin(String login) {
//        try {  // БЫЛО
//            inputLoginEnter.clear();
//            inputLoginEnter.sendKeys(login);
//            logger.info(login + " was imputed into Input Login ");
//        }catch (Exception e){
//            printErrorAndStopTest(e);
//        }

        enterTextInToElement(inputLoginEnter, login); // СТАЛО
    }

    public void enterLoginIntoInputPassword(String passWord){
//        try {  // БЫЛО
//            inputPassWordEnter.clear();
//            inputPassWordEnter.sendKeys(passWord);
//            logger.info(passWord + " was inputted ");
//        }catch (Exception e){
//            printErrorAndStopTest(e);
//        }
        enterTextInToElement(inputPassWordEnter, passWord);  // СТАЛО
    }

    public void clickOnButtonEnter(){
//        try {  // БЫЛО
//            buttonEnter.click();
//            logger.info("Button Enter was clicked");
//        }catch (Exception e){
//            printErrorAndStopTest(e);
//        }
        clickOnElement(buttonEnter);  // СТАЛО
    }

    public boolean isButtonEnterDisplayed(){
      return isElementDisplayed(buttonEnter);
    }

    public boolean isErrorTextDisplayed(){
        return isElementDisplayed(errorAuthorization);
    }

    public LoginPage checkIsButtonEnterDisplayed(){
        waitTime();
        Assert.assertTrue("Button is displayed", isButtonEnterDisplayed());
        return this;
    }

    public LoginPage checkErrorMassageTextDisplayed(){
        waitTime();
        Assert.assertTrue("Text is Massage Text displayed", isErrorTextDisplayed());
        return this;
    }

    public OrdersPage loginWithValidCred(){
        openLoginPage();
        enterLoginIntoInputLogin(TestDataTest.VALID_LOGIN);
        enterLoginIntoInputPassword(TestDataTest.VALID_PASS);
        clickOnButtonEnter();
        return new OrdersPage(webDriver);
    }

    public LoginPage checkErrorMassageLoginField() {
        waitTime();
        Assert.assertTrue("Error Field is not displayed", isErrorMassageLoginDisplayed());
        return this;
    }

    private boolean isErrorMassageLoginDisplayed() {
        return isElementDisplayed(errorMassageLoginField);
    }

    public LoginPage checkErrorMassagePasswordField() {
        waitTime();
        Assert.assertTrue("Error Field is not displayed", isErrorMassagePasswordDisplayed());
        return this;
    }

    private boolean isErrorMassagePasswordDisplayed() {
        return isElementDisplayed(errorMassagePasswordField);
    }
}
