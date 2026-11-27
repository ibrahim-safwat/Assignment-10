package pages;

import driverfactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

public class OrderCompletePage {
    private Driver driver;
    private By backToProductButton = By.id("back-to-products");


    /***************************** constructors ****************************/

    public OrderCompletePage(Driver driver) {
        this.driver = driver;
    }

    /***************************** methods ****************************/
    @Step("click the back to products button")
    public InventoryPage clickBackToProductsButton() {
        System.out.println("Clicking back to the product button");
        driver.element().Click(backToProductButton);
        return new InventoryPage(driver);
    }

    /***************************** Assertions ****************************/

    @Step("assert order complete page")
    public OrderCompletePage assertOrderCompletePage() {
        System.out.println("Asserting order complete page");
        driver.element().WaitForElementToBeVisible(backToProductButton, Duration.ofSeconds(10));
        driver.hardassertions().element(backToProductButton).IsDisplayed();
        return this;
    }

}
