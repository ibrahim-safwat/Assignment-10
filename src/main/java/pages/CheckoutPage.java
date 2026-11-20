package pages;

import driverfactory.Driver;
import org.openqa.selenium.By;

import java.util.List;

public class CheckoutPage {
    private Driver driver;
    private By continueButton = By.id("continue");
    private By firstnameField = By.id("first-name");
    private By lastnameField = By.id("last-name");
    private By zipcodeField = By.id("postal-code");


    /***************************** constructors ****************************/

    public CheckoutPage(Driver driver) {
        this.driver = driver;
    }

    /***************************** methods ****************************/
    public CheckoutPage insertFirstName() {
        System.out.println("inserting first name");
        driver.element().sendKeys(firstnameField, "ibrahim");
        return this;
    }

    public CheckoutPage insertLastName() {
        System.out.println("inserting last name");
        driver.element().sendKeys(lastnameField, "safwat");
        return this;
    }

    public CheckoutPage insertZipCode() {
        System.out.println("inserting zipcode");
        driver.element().sendKeys(zipcodeField, "11843");
        return this;
    }

    public FinalizingOrderPage clickContinue() {
        System.out.println("clicking continue");
        driver.element().Click(continueButton);
        return new FinalizingOrderPage(driver);
    }

    /***************************** Assertions ****************************/
    public CheckoutPage assertCheckoutPage() {
        System.out.println("asserting checkout page title");
        driver.hardassertions().element(continueButton).IsDisplayed();
        return this;
    }
}
