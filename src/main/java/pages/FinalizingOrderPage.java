package pages;

import driverfactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

public class FinalizingOrderPage {
    private Driver driver;
    private By finishButton = By.id("finish");


    /***************************** constructors ****************************/

    public FinalizingOrderPage(Driver driver) {
        this.driver = driver;
    }

    /***************************** methods ****************************/
    @Step("click finish button")
    public OrderCompletePage clickFinishButton() {
        System.out.println("Order completed");
        driver.element().Click(finishButton);
        return new OrderCompletePage(driver);
    }

    /***************************** Assertions ****************************/
    @Step("assert order complete page")
    public FinalizingOrderPage assertOrderCompletePage() {
        System.out.println("Order completed");
        driver.element().WaitForElementToBeVisible(finishButton, Duration.ofSeconds(10));
        driver.hardassertions().element(finishButton).IsDisplayed();
        return this;
    }

}
