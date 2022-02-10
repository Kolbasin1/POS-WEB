package pages;

import libs.TestData;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Warehouse extends InsideTheOrderPage{
    @FindBy(xpath = ".//input[@readonly='readonly' and @placeholder='Выберите склад']")
    private WebElement warehouseSelectionLocation;

    @FindBy(xpath = ".//input[@aria-checked='true' and @value='all']")
    private WebElement allItemsInOneWarehouse;

    @FindBy(xpath = ".//input[@aria-checked='true' and @value='split']")
    private WebElement splitWarehouse;

    @FindBy(xpath = ".//*[@class='OrderItem-Order-itemsblock']//..//*[@role='combobox']//../*[@class='v-input__slot']")
    private WebElement selectWarehouse;

    @FindBy(xpath = TestData.WAREHOUSE_1)
    public WebElement selectedWarehouse1;  // не получается подобрать локатор к определенному складу

    @FindBy(xpath = TestData.WAREHOUSE_2)
    public WebElement selectedWarehouse2;

    @FindBy(xpath = TestData.WAREHOUSE_3)
    public WebElement selectedWarehouse3;

    @FindBy(xpath = TestData.WAREHOUSE_4)
    public WebElement selectedWarehouse4;

    @FindBy(tagName = "select")
    private WebElement dropDownWarehouse;

    public Warehouse(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isStockChoiceAvailability(){
       return isElementDisplayed(warehouseSelectionLocation);
    }

    public Warehouse checkIsStockChoiceAvailability(){
        waitTime();
        Assert.assertTrue("Button All Is Active is not displayed",isStockChoiceAvailability());
        return this;
    }

    private boolean isRadioButtonSplitIsActive() {
        return isElementDisplayed(splitWarehouse);
    }

    public Warehouse checkIsRadioButtonAllIsActive(){
        waitTime();
        Assert.assertFalse("Button All Is Active is not displayed", isRadioButtonSplitIsActive());
        return this;
    }

    public Warehouse clickOnSelectWarehouse(){
        clickOnElement(selectWarehouse);
        return this;
    }

    public Warehouse choiceWarehouse(WebElement warehouseName){
        clickOnElement(warehouseName);
        return this;
    }

    public InsideTheOrderPage addWarehouseToOrder(){
        checkIsStockChoiceAvailability();
        checkIsRadioButtonAllIsActive();
        clickOnSelectWarehouse();
        choiceWarehouse(selectedWarehouse4);
        return new Warehouse(webDriver);
    }

    public Warehouse selectValueInDropDownWarehouse(String valueForSelect) {
        selectValueInDropDown(dropDownWarehouse, valueForSelect);
        return this;
    }

}
