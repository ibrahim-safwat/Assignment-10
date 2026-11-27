package pages;

import driverfactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

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

    @Step("insert first name")
    public CheckoutPage insertFirstName() {
        System.out.println("inserting first name");
        driver.element().WaitForElementToBeVisible(firstnameField, Duration.ofSeconds(10));
        driver.element().sendKeys(firstnameField, "ibrahim");
        return this;
    }

    @Step("insert last name")
    public CheckoutPage insertLastName() {
        System.out.println("inserting last name");
        driver.element().sendKeys(lastnameField, "safwat");
        return this;
    }

    @Step("insert zip code")
    public CheckoutPage insertZipCode() {
        System.out.println("inserting zipcode");
        driver.element().sendKeys(zipcodeField, "11843");
        return this;
    }

    @Step("click continue button")
    public FinalizingOrderPage clickContinue() {
        System.out.println("clicking continue");
        driver.element().WaitForElementToBeClickable(continueButton, Duration.ofSeconds(10));
        driver.element().ScrollJavascript(continueButton);
        driver.element().Click(continueButton);
        return new FinalizingOrderPage(driver);
    }

    /***************************** Assertions ****************************/

    @Step("assert checkout page")
    public CheckoutPage assertCheckoutPage() {
        System.out.println("asserting checkout page title");
        driver.element().WaitForElementToBeClickable(continueButton, Duration.ofSeconds(10));
        driver.hardassertions().element(continueButton).IsDisplayed();
        return this;
    }
}
