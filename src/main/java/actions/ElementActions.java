package actions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ElementActions {

    private WebDriver driver;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
    }

    public ElementActions Click(By locator) {
        System.out.println("Clicking with driver " + locator.toString());
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(locator))
                    .click();
        } catch (NoSuchElementException | StaleElementReferenceException | ElementClickInterceptedException |
                 TimeoutException e) {
            ScrollJavascript(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click(true);", driver.findElement(locator));
            System.out.println("Clicking with Javascript instead " + locator.toString());
        }
        return this;
    }

    public ElementActions ClickMultipleTimes(By locator, int times) {
        System.out.println("Clicking with driver " + locator.toString());
        for (int i=1; i<times; i++) {
            System.out.println("Clicking with driver " + locator.toString() + " i" + " number of times");
            Click(locator);
        }
        return this;
    }
//
    public ElementActions WaitForInvoice (Duration duration) {
        System.out.println("Checking file ");
        File invoice = new File("downloads/invoice.txt");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d -> invoice.exists() && invoice.length() > 0);
        Assert.assertTrue(invoice.exists(), "Invoice file was not downloaded");
        return this;
    }

    public Boolean isDisplayed(By locator) {
        System.out.println("Displaying on " + locator.toString());

        return driver.findElement(locator).isDisplayed();
    }

    public ElementActions navigateTo(String url) {
        System.out.println("Navigating on" + url.toLowerCase());
        driver.navigate().to(url);
        return this;
    }

    public String gettextOfElement(By locator) {
        System.out.println("Getting text" + locator.toString());
        return driver.findElement(locator).getText();
    }


    public ElementActions findElements(By locator) {
        System.out.println("Getting Text" + locator.toString());
        driver.findElements(locator);
        return this;
    }

    public ElementActions sendKeys(By locator, String text) {
        System.out.println("Sending keys" + locator.toString());
        try {
            driver.findElement(locator).sendKeys(text);
        } catch (NoSuchElementException | StaleElementReferenceException | ElementClickInterceptedException |
                 TimeoutException e) {

            System.out.println("Sending keys with Javascript instead" + locator.toString());
            ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", driver.findElement(locator), text);
        }
        return this;
    }

    public ElementActions clear(By locator) {
        System.out.println("Clearing text" + locator.toString());
        driver.findElement(locator).clear();
        return this;
    }

    public ElementActions fill(By locator, String text) {
        System.out.println("Filling text" + locator.toString());
        // calling method clear in this class
        clear(locator);
        driver.findElement(locator).sendKeys(text);
        return this;
    }

    public ElementActions hover(By locator) {
        System.out.println("Hovering on" + locator.toString());
        new Actions(driver).moveToElement(driver.findElement(locator)).perform();
        return this;
    }

    public ElementActions ScrollJavascript(By locator) {
        System.out.println("Scrolling on" + locator.toString());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
        return this;
    }

    public ElementActions SelectfromdropdownbyValue(By locator, String value) {
        System.out.println("Selecting Dropdown by value" + locator.toString());
        new Select(driver.findElement(locator)).selectByValue(value);
        return this;
    }

    public ElementActions SelectfromdropdownByVisibleText(By locator) {
        System.out.println("Selecting Dropdown by Visible Text" + locator.toString());
        new Select(driver.findElement(locator)).selectByVisibleText(locator.toString());
        return this;
    }

    public ElementActions SelectfromdropdownByIndex(By locator, int index) {
        System.out.println("Selecting Dropdown By index" + locator.toString());
        new Select(driver.findElement(locator)).selectByIndex(index);
        return this;
    }

    public boolean IsSelected(By locator) {
        System.out.println("Checking if selected " + locator.toString());
        return driver.findElement(locator).isSelected();
    }

    public boolean Clickable(By locator) {
        System.out.println("Clicking " + locator.toString());
        return driver.findElement(locator).isEnabled();
    }

    public ElementActions WaitForElementToBeClickable(By locator, Duration duration) {
        System.out.println("Waiting for " + locator.toString() + " " + duration.toString() + " to be clickable");
        new WebDriverWait(driver, duration).until(ExpectedConditions.elementToBeClickable(locator));
        return this;
    }

    public ElementActions WaitForElementToBeVisible(By locator, Duration duration) {
        System.out.println("Waiting for " + locator.toString() + " " + duration.toString() + " to be visible");
        new WebDriverWait(driver, duration).until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this;
    }

    public ElementActions WaitForElementToBePresent(By locator, Duration duration) {
        System.out.println("Waiting for " + locator.toString() + " " + duration.toString() + " to be present");
        new WebDriverWait(driver, duration).until(ExpectedConditions.presenceOfElementLocated(locator));
        return this;
    }

    public ElementActions waitForElementToBeInvisible(By locator, Duration timeout) {
        System.out.println("Waiting for element to be invisible: " + locator.toString());
        // Implement wait for element to be invisible
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
        return this;
    }

    public ElementActions UploadFile(By locator) {
        System.out.println("Uploading file");
        driver.findElement(locator).sendKeys("/Users/abepharaoh/Documents/Test_Upload_File/test.rtf");
        return this;
    }

    public ElementActions acceptAlert() {
        System.out.println("Accepting alert");
        // Implement alert acceptance
        driver.switchTo().alert().accept();
        return this;
    }

    public ElementActions dismissAlert() {
        System.out.println("Dismissing alert");
        // Implement alert dismissal
        driver.switchTo().alert().dismiss();
        return this;
    }

    public ElementActions addTextToAlert(String text) {
        System.out.println("Adding Text to alert: " + text);
        // Implement sending keys to alert
        driver.switchTo().alert().sendKeys(text);
        return this;
    }

    public ElementActions getAlertText() {
        System.out.println("Getting alert text");
        // Implement getting text from alert
        String alertText = driver.switchTo().alert().getText();
        System.out.println("Alert text: " + alertText);
        return this;
    }

    public ElementActions UrlContains(String url) {
        System.out.println("Url contains " + url);
        driver.getCurrentUrl().contains(url);
        return this;

    }
    // Will be used for getting counts and multiple locators (like prices and names) at once.
    public List<String> getTextsOfElements(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        List<String> texts = new ArrayList<>();
        for (WebElement element : elements) {
            texts.add(element.getText());
        }
        return texts;
    }

    public int getCountOfElements(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        return elements.size();
    }


}
