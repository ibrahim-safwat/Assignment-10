package pages;

import driverfactory.Driver;
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

    public List<String> getProductNames() {
        System.out.println("getting product name ");
        return driver.element().getTextsOfElements(productName);
    }

    public List<String> getProductPrices() {
        System.out.println("getting product price ");
        return driver.element().getTextsOfElements(productPrices);
    }

    public List<String> getCartBadgeCount() {
        System.out.println("getting cart badge count ");
        return driver.element().getTextsOfElements(shoppingCartCount);
    }

    public CartPage goToCartButton() {
        System.out.println("going to cart button");
        driver.element().Click(goToCartButton);
        return new CartPage(driver);
    }

    public InventoryPage addBikeLightToCartButton() {
        System.out.println("adding bike light to cart button");
        driver.element().Click(addBikeLightToCartButton);
        return this;
    }

    public InventoryPage addBackpackToCartButton() {
        System.out.println("adding backpack to cart button");
        driver.element().Click(addBackpackToCartButton);
        return this;
    }

    public InventoryPage clickSortByButton(String selectvalue) {
        System.out.println("clicking sort by button");
        driver.element().SelectfromdropdownbyValue(sortBybutton, selectvalue);
        return this;
    }

    /***************************** Assertions ****************************/
    public InventoryPage assertInventoryPage() {
        System.out.println("asserting inventory page title");
        driver.hardassertions().element(inventoryPageTitle).IsDisplayed();
        return this;
    }
}


