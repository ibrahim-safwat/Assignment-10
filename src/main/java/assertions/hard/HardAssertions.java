package assertions.hard;

import assertions.browser.BrowserAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.Assertion;

public class HardAssertions {
    private Assertion assertion;
    private WebDriver driver;

    public HardAssertions(WebDriver driver) {
        this.assertion = new Assertion();
        this.driver = driver;
    }

    public ElementAssertions element(By by) {
        return new ElementAssertions(driver, assertion, by);
    }
    public BrowserAssertions browserassertion() {
        return new BrowserAssertions(assertion, driver);
    }
}
