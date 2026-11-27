package pages;

import driverfactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

public class InventoryPage {

    private Driver driver;
    private By productName = By.xpath("//div[@class='inventory_item_name ']");
    private By productPrices = By.xpath("//div[@class='inventory_item_price ']");
    private By shoppingCartCount = By.xpath("//div[@class='shopping_cart_badge']");
    private By addBikeLightToCartButton = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']");
    private By addBackpackToCartButton = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']");
    private By goToCartButton = By.xpath("//a[@class='shopping_cart_link']");
    private By sortBybutton = By.xpath("//select[@class='product_sort_container']");
    private By inventoryPageTitle = By.xpath("//div[@class='app_logo']");

    /***************************** constructors ****************************/

    public InventoryPage(Driver driver) {
        this.driver = driver;
    }

    /***************************** methods ****************************/
    @Step("get product name")
    public List<String> getProductNames() {
        System.out.println("getting product name ");
        return driver.element().getTextsOfElements(productName);
    }

    @Step("get product prices")
    public List<String> getProductPrices() {
        System.out.println("getting product price ");
        return driver.element().getTextsOfElements(productPrices);
    }

    @Step("get cart bade count")

    public List<String> getCartBadgeCount() {
        System.out.println("getting cart badge count ");
        return driver.element().getTextsOfElements(shoppingCartCount);
    }

    @Step("go to cart button")

    public CartPage goToCartButton() {
        System.out.println("going to cart button");
        driver.element().Click(goToCartButton);
        return new CartPage(driver);
    }

    @Step("click add bike light product to cart button")
    public InventoryPage addBikeLightToCartButton() {
        System.out.println("adding bike light to cart button");
        driver.element().Click(addBikeLightToCartButton);
        return this;
    }

    @Step("click add backpack to cart button")
    public InventoryPage addBackpackToCartButton() {
        System.out.println("adding backpack to cart button");
        driver.element().Click(addBackpackToCartButton);
        return this;
    }

    @Step("click the sort by button")
    public InventoryPage clickSortByButton(String selectvalue) {
        System.out.println("clicking sort by button");
        driver.element().SelectfromdropdownbyValue(sortBybutton, selectvalue);
        return this;
    }

    /***************************** Assertions ****************************/
    @Step("assert inventory page")
    public InventoryPage assertInventoryPage() {
        System.out.println("asserting inventory page title");
        driver.hardassertions().element(inventoryPageTitle).IsDisplayed();
        return this;
    }
}


