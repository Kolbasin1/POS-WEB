package loginTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver webDriver;
    @Test
    public void validLogin(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        webDriver.get("https://mp-pos-web-stage.umico.az/login");
        System.out.println("Site was opened");

        webDriver.findElement(By.xpath(".//input[@aria-label='Логин']")).clear();
        webDriver.findElement(By.xpath(".//input[@aria-label='Логин']")).sendKeys("994555123456-312");
        System.out.println("login was enter");

        webDriver.findElement(By.xpath(".//input[@aria-label='Пароль']")).clear();
        webDriver.findElement(By.xpath(".//input[@aria-label='Пароль']")).sendKeys("4JFP4hmD");
        System.out.println("password was entered");

        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
        System.out.println("button was clicked");

        Assert.assertTrue("Button EXIT is not displayed",  // позитивный креды правильные
                isButtonExitDisplayed());

        webDriver.quit();
        System.out.println("browser was closed");
    }

    private boolean isButtonExitDisplayed(){  // проверяет отображение кнопки
        try {
            return webDriver.findElement(By.xpath(".//button[@type='button' and @class='text-none text--disabled v-btn v-btn--flat theme--light']")).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    @Test
    public void invalidLogin1(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        webDriver.get("https://mp-pos-web-stage.umico.az/login");
        System.out.println("Site was opened");

        webDriver.findElement(By.xpath(".//input[@aria-label='Логин']")).clear();
        webDriver.findElement(By.xpath(".//input[@aria-label='Логин']")).sendKeys("994555123456-312");
        System.out.println("login was enter");

        webDriver.findElement(By.xpath(".//input[@aria-label='Пароль']")).clear();
        webDriver.findElement(By.xpath(".//input[@aria-label='Пароль']")).sendKeys("4JFP4hm");
        System.out.println("password was entered");

        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
        System.out.println("button was clicked");

        Assert.assertTrue("Button EXIT is not displayed", // негативный креды не правильные в пароле
                isButtonEnterDisplayed());

        webDriver.quit();
        System.out.println("browser was closed");
    }

    private boolean isButtonEnterDisplayed(){
        try {
            return webDriver.findElement(By.xpath(".//*[@class='v-input__control']//*[@class='v-messages__message']")).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    @Test
    public void invalidLoginVar2(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        webDriver.get("https://mp-pos-web-stage.umico.az/login");
        System.out.println("Site was opened");

        webDriver.findElement(By.xpath(".//input[@aria-label='Логин']")).clear();
        webDriver.findElement(By.xpath(".//input[@aria-label='Логин']")).sendKeys("994555123456-312");
        System.out.println("login was enter");

        webDriver.findElement(By.xpath(".//input[@aria-label='Пароль']")).clear();
        webDriver.findElement(By.xpath(".//input[@aria-label='Пароль']")).sendKeys("4JFP4hm");
        System.out.println("password was entered");

        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
        System.out.println("button was clicked");

        Assert.assertFalse("Button EXIT is not displayed", // негативный креды не правильные в пароле
                isButtonExitDisplayed());

        webDriver.quit();
        System.out.println("browser was closed");
    }
}
