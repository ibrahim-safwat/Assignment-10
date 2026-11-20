package pages;

import driverfactory.Driver;
import org.openqa.selenium.By;

public class OrderCompletePage {
    private Driver driver;
    private By backToProductButton = By.id("back-to-products");


    /***************************** constructors ****************************/

    public OrderCompletePage(Driver driver) {
        this.driver = driver;
    }

    /***************************** methods ****************************/
    public InventoryPage clickBackToProductsButton() {
        System.out.println("Clicking back to the product button");
        driver.element().Click(backToProductButton);
        return new InventoryPage(driver);
    }

    /***************************** Assertions ****************************/

    public OrderCompletePage assertOrderCompletePage() {
        System.out.println("Order completed");
        driver.hardassertions().element(backToProductButton).IsDisplayed();
        return new OrderCompletePage(driver);
    }
}
