package loginTest;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Test;

public class LoginTestWithPageObject extends BaseTest {
    @Test
    public void validLoginTest(){
        loginPage.openLoginPage();
        loginPage.enterLoginIntoInputLogin(TestData.VALID_LOGIN);
        loginPage.enterLoginIntoInputPassword(TestData.VALID_PASS);
        loginPage.clickOnButtonEnter();
        orderPage.checkIsButtonExitDisplayed();
    }

    @Test
    public void negativeLoginTestWrongLogin1(){
        loginPage.openLoginPage();
        loginPage.enterLoginIntoInputLogin(TestData.INVALID_LOGIN_1);
        loginPage.enterLoginIntoInputPassword(TestData.VALID_PASS);
        loginPage.clickOnButtonEnter();
        loginPage.checkErrorMassageTextDisplayed();
        orderPage.checkIsButtonExitNotDisplayed();
    }

    @Test
    public void negativeLoginTestWrongLogin2(){
        loginPage.openLoginPage();
        loginPage.enterLoginIntoInputLogin(TestData.INVALID_LOGIN_2);
        loginPage.enterLoginIntoInputPassword(TestData.VALID_PASS);
        loginPage.clickOnButtonEnter();
        loginPage.checkErrorMassageTextDisplayed();
        orderPage.checkIsButtonExitNotDisplayed();
    }

    @Test
    public void negativeLoginTestWrongLogin3(){
        loginPage.openLoginPage();
        loginPage.enterLoginIntoInputLogin(TestData.INVALID_LOGIN_3);
        loginPage.enterLoginIntoInputPassword(TestData.VALID_PASS);
        loginPage.clickOnButtonEnter();
        loginPage.checkErrorMassageTextDisplayed();
        orderPage.checkIsButtonExitNotDisplayed();
    }

    @Test
    public void negativeLoginTestWrongLogin4(){
        loginPage.openLoginPage();
        loginPage.enterLoginIntoInputLogin(TestData.INVALID_LOGIN_4);
        loginPage.enterLoginIntoInputPassword(TestData.VALID_PASS);
        loginPage.clickOnButtonEnter();
        loginPage.checkErrorMassageTextDisplayed();
        orderPage.checkIsButtonExitNotDisplayed();
    }

    @Test
    public void negativeLoginTestWrongPassWord1(){
        loginPage.openLoginPage();
        loginPage.enterLoginIntoInputLogin(TestData.VALID_LOGIN);
        loginPage.enterLoginIntoInputPassword(TestData.INVALID_PASS_1);
        loginPage.clickOnButtonEnter();
        loginPage.checkErrorMassageTextDisplayed();
        loginPage.checkIsButtonEnterDisplayed();
        orderPage.checkIsButtonExitNotDisplayed();
    }

    @Test
    public void negativeLoginTestWrongPassWord2(){
        loginPage.openLoginPage();
        loginPage.enterLoginIntoInputLogin(TestData.VALID_LOGIN);
        loginPage.enterLoginIntoInputPassword(TestData.INVALID_PASS_2);
        loginPage.clickOnButtonEnter();
        orderPage.checkIsButtonExitDisplayed();
    }

    @Test
    public void negativeLoginTestWrongPassWord3(){
        loginPage.openLoginPage();
        loginPage.enterLoginIntoInputLogin(TestData.VALID_LOGIN);
        loginPage.enterLoginIntoInputPassword(TestData.INVALID_PASS_3);
        loginPage.clickOnButtonEnter();
        loginPage.checkErrorMassageTextDisplayed();
        loginPage.checkErrorMassagePasswordField();
        loginPage.checkIsButtonEnterDisplayed();
    }

    @Test
    public void negativeLoginTestWrongPassWord4(){
        loginPage.openLoginPage();
        loginPage.enterLoginIntoInputLogin(TestData.VALID_LOGIN);
        loginPage.enterLoginIntoInputPassword(TestData.INVALID_PASS_4);
        loginPage.clickOnButtonEnter();
        loginPage.checkErrorMassageTextDisplayed();
        loginPage.checkErrorMassagePasswordField();
        loginPage.checkIsButtonEnterDisplayed();
    }

    @Test
    public void negativeLoginTestWithoutEnteringFields(){
        loginPage.openLoginPage();
        loginPage.clickOnButtonEnter();
        loginPage.checkErrorMassageTextDisplayed();
        loginPage.checkErrorMassageLoginField();
        loginPage.checkErrorMassagePasswordField();
        loginPage.checkIsButtonEnterDisplayed();
    }
}
