package pages;

import driverfactory.Driver;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

public class CartPage {

    private Driver driver;
    private By cartContainer = By.id("//div[@class='cart_list']");
    private By firstItem = By.id("item_4_title_link");
    private By secondItem = By.id("item_4_description_link");
    private By removeFirstItem = By.xpath("//button[@data-test='remove-sauce-labs-backpack']");
    By proceedToCheckoutbutton = By.xpath("//button[@class='btn btn_action btn_medium checkout_button ']");


    /***************************** constructors ****************************/

    public CartPage(Driver driver) {
        this.driver = driver;
    }

    /***************************** methods ****************************/
    public CartPage getItemCountinCartContainerisTwo() {
        System.out.println("getting item count");
        driver.element().getCountOfElements(cartContainer);
        if (driver.element().getCountOfElements(cartContainer) == 2) {
            System.out.println("element count is: " + getItemCountinCartContainerisTwo());
        } else {
            System.out.println("element count isn't 2");
        }
        return this;
    }

    public CartPage removeFirstItemFromCart() {
        System.out.println("removing first item from cart");
        driver.element().Click(removeFirstItem);
        return this;
    }

    public CartPage getItemCountinCartContainerIsOne() {
        System.out.println("getting item count");
        driver.element().getCountOfElements(cartContainer);
        if (driver.element().getCountOfElements(cartContainer) == 1) {
            System.out.println("element count is: " + getItemCountinCartContainerIsOne());
        } else {
            System.out.println("element count isn't 1");
        }
        return this;
    }

    public CheckoutPage clickCheckoutButton() {
        System.out.println("clicking checkout button");
        driver.element().WaitForElementToBeVisible(proceedToCheckoutbutton, Duration.ofSeconds(4));
        driver.element().Click(proceedToCheckoutbutton);
        return new CheckoutPage(driver);
    }

    /***************************** Assertions ****************************/

    public CartPage assertCheckoutPage() {
        System.out.println("asserting checkout button");
        driver.hardassertions().element(proceedToCheckoutbutton).IsDisplayed();
        return this;
    }
}
