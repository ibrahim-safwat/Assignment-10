package pages;

import driverfactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

public class CartPage {

    private Driver driver;
    private By cartContainer = By.xpath("//div[@class='cart_item']");
    private By firstItem = By.id("item_4_title_link");
    private By secondItem = By.id("item_4_description_link");
    private By removeFirstItem = By.xpath("//button[@data-test='remove-sauce-labs-backpack']");
    private By proceedToCheckoutbutton = By.id("checkout");

    /***************************** constructors ****************************/

    public CartPage(Driver driver) {
        this.driver = driver;
    }

    /***************************** methods ****************************/

    @Step("get item count in cart container")
    public CartPage getItemCountinCartContainerisTwo() {
        System.out.println("getting item count");
        int count = driver.element().getCountOfElements(cartContainer);
        if (count == 2) {
            System.out.println("element count is: " + count);
        } else {
            System.out.println("element count isn't 2, actual: " + count);
        }
        return this;
    }

    @Step("remove first item from cart")
    public CartPage removeFirstItemFromCart() {
        System.out.println("removing first item from cart");
        driver.element().Click(removeFirstItem);
        return this;
    }

    @Step("get item count container is one")
    public CartPage getItemCountinCartContainerIsOne() {
        System.out.println("getting item count");
        int count = driver.element().getCountOfElements(cartContainer);
        if (count == 1) {
            System.out.println("element count is: " + count);
        } else {
            System.out.println("element count isn't 1, actual: " + count);
        }
        return this;
    }

    @Step("click checkout button")
    public CheckoutPage clickCheckoutButton() {
        System.out.println("clicking checkout button");
        driver.element().WaitForElementToBeClickable(proceedToCheckoutbutton, Duration.ofSeconds(10));
        driver.element().ScrollJavascript(proceedToCheckoutbutton);
        driver.element().Click(proceedToCheckoutbutton);
        return new CheckoutPage(driver);
    }

    /***************************** Assertions ****************************/

    @Step("assert checkout page")
    public CartPage assertCheckoutPage() {
        System.out.println("asserting checkout button");
        driver.element().WaitForElementToBeVisible(proceedToCheckoutbutton, Duration.ofSeconds(10));
        driver.hardassertions().element(proceedToCheckoutbutton).IsDisplayed();
        return this;
    }
}
