package assertions.hard;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.Assertion;

public class ElementAssertions {
    private WebDriver driver;
    private Assertion assertion;
    private By by;

    public ElementAssertions(WebDriver driver, Assertion assertion, By by) {
        this.assertion = assertion;
        this.driver = driver;
        this.by = by;
    }

    public void IsDisplayed() {
        try {
            Assert.assertTrue(driver.findElement(by).isDisplayed(), "Element " + by.toString().split(":", 2)[1] + " is displayed");
        } catch (AssertionError | NoSuchElementException e) {
            System.out.println("Element " + by.toString().split(":", 2)[1] + " is not displayed");
            throw e;
        }
    }

//    public ElementAssertions UrlContains(String url) {
//        try {
//            Assert.assertTrue(driver.getCurrentUrl().contains(url), "Element " + by.toString().split(":", 2)[1] + " contains url");
//        }  catch (AssertionError e) {
//            System.out.println("Element " + by.toString().split(":", 2)[1] + " doesn't contain url");
//            throw e;
//        }
//        return  this;
//    }

    public boolean IsHidden() {
        try {
            Assert.assertTrue(!driver.findElement(by).isDisplayed(), "Element " + by.toString().split(":", 2)[1] + " is not displayed");
        } catch (AssertionError e) {
            System.out.println("Element " + by.toString().split(":", 2)[1] + " is displayed");
            throw e;
        }
        return false;
    }

    public void ContainsText(String expected) {
        String actualElement = driver.findElement(by).getText().toLowerCase();
        assertion.assertTrue(actualElement.contains(expected.toLowerCase()),
                "Element " + by + " does not contain '" + expected + "'. Actual text: " + actualElement);
    }

    public void isEnabled() {
        try {
            Assert.assertTrue(driver.findElement(by).isEnabled(), "Element " + by.toString().split(":", 2)[1] + " is enabled");
        } catch (AssertionError e) {
            System.out.println("Element " + by.toString().split(":", 2)[1] + " is not enabled");
            throw e;
        }
    }

    public void isDisabled() {
        try {
            Assert.assertTrue(!driver.findElement(by).isEnabled(), "Element " + by.toString().split(":", 2)[1] + " is disabled");
        } catch (AssertionError e) {
            System.out.println("Element " + by.toString().split(":", 2)[1] + " is enabled");
            throw e;
        }
    }

    public void IsSelected() {
        try {
            Assert.assertTrue(driver.findElement(by).isSelected(), "Element " + by.toString().split(":", 2)[1] + " is selected");
        } catch (AssertionError e) {
            System.out.println("Element " + by.toString().split(":", 2)[1] + " is not selected");
            throw e;
        }
    }

    public void IsNotSelected() {
        try {
            Assert.assertTrue(!driver.findElement(by).isSelected(), "Element " + by.toString().split(":", 2)[1] + " is not selected");
        } catch (AssertionError e) {
            System.out.println("Element " + by.toString().split(":", 2)[1] + " is selected");
            throw e;
        }
    }

    public void IsClickable() {
        try {
            Assert.assertTrue(driver.findElement(by).isEnabled(), "Element " + by.toString().split(":", 2)[1] + " is clickable");
        } catch (AssertionError e) {
            System.out.println("Element " + by.toString().split(":", 2)[1] + " is not clickable");
            throw e;
        }
    }

    public void IsNotlickable() {
        try {
            Assert.assertTrue(!driver.findElement(by).isEnabled(), "Element " + by.toString().split(":", 2)[1] + " is not clickable");
        } catch (AssertionError e) {
            System.out.println("Element " + by.toString().split(":", 2)[1] + " is  clickable");
            throw e;
        }

    }

    public void isEquals( String actual, String expected) {

        Assert.assertEquals(actual, expected, "doesn't match the added product");

    }
}
