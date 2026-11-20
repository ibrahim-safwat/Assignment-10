package pages;

import driverfactory.Driver;
import org.openqa.selenium.By;

public class LoginPage {

    private Driver driver;
    private By LoginEmail_Field = By.id("user-name");
    private By LoginPassword_Field = By.id("password");
    private By ClickLoginButton = By.id("login-button");

    /***************************** constructors ****************************/

    public LoginPage(Driver driver) {
        this.driver = driver;
    }

    /***************************** methods ****************************/

    public LoginPage EnterLoginCredentials() {
        System.out.println("Entering login credentials");
        driver.element().sendKeys(LoginEmail_Field, "standard_user");
        driver.element().sendKeys(LoginPassword_Field, "secret_sauce");
        return this;
    }

    public InventoryPage ClickSuccessfulLoginButton() {
        System.out.println("Clicking login button");
        driver.element().Click(ClickLoginButton);
        return new InventoryPage(driver);
    }

    public LoginPage ClickFailedLoginButton() {
        System.out.println("Clicking login button");
        driver.element().Click(ClickLoginButton);
        return new LoginPage(driver);
    }


    /***************************** Assertions ****************************/

    }




