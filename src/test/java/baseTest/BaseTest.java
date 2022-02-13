package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

// главный родительский тест для всех тестов
public class BaseTest {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected LoginPage loginPage;
    protected OrdersPage orderPage;
    protected InsideTheOrderPage insideTheOrderPage;
    protected Warehouse warehouse;
    protected InformationBoxOnThePopUpp informationBoxOnThePage;
    @Before  // @Before будет запущена перед каждой аннотацией тест
    public void preCondition(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logger.info("Browser was opened");
        loginPage = new LoginPage(webDriver);
        orderPage = new OrdersPage(webDriver);
        insideTheOrderPage = new InsideTheOrderPage(webDriver);
        warehouse = new Warehouse(webDriver);
        informationBoxOnThePage = new InformationBoxOnThePopUpp(webDriver);
    }
    @After  // @After будет запущена после каждой аннотации тест
    public void postCondition(){
        webDriver.quit();
        logger.info("Browser was closed");
    }
}
