package actions;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class BrowserActions {
   private WebDriver driver;

    public BrowserActions(WebDriver driver) {
        this.driver = driver;
    }

    public BrowserActions navigateTo(String url) {
        System.out.println("Navigating to " + url);
        driver.navigate().to(url);
        return this;
    }

    public BrowserActions navigateBack() {
        System.out.println("Navigating back");
        driver.navigate().back();
        return this;
    }

    public BrowserActions navigateForward() {
        System.out.println("Navigating forward");
        driver.navigate().forward();
        return this;
    }

    public String getTitle() {
        System.out.println("Getting title");
        return driver.getTitle();
    }

    public String GetCurrentURL() {
        System.out.println("Getting current URL");
        return driver.getCurrentUrl();
    }

    public BrowserActions RefreshPage() {
        System.out.println("Refreshing page");
        driver.navigate().refresh();
        return this;
    }

    public BrowserActions GetToUrl(String url) {
        System.out.println("Getting to " + url);
        driver.get(url);
        return this;
    }

    public BrowserActions ScrollToBottom() {
        System.out.println("Scrolling to bottom");
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        return this;
    }

    public BrowserActions ScrollToTop() {
        System.out.println("Scrolling to top");
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");
        return this;
    }

    public BrowserActions SetWindowSize(int width, int height) {
        System.out.println("Setting window size");
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(width, height));
        return this;
    }

    public BrowserActions SetWindowPosition(int x, int y) {
        System.out.println("Setting window position");
        driver.manage().window().setPosition(new org.openqa.selenium.Point(x, y));
        return this;
    }

    public BrowserActions MaximizeWindow() {
        System.out.println("Maximizing window");
        driver.manage().window().maximize();
        return this;
    }

    public BrowserActions CloseWindow() {
        System.out.println("Closing window");
        driver.close();
        return this;
    }

    public BrowserActions MinimizeWindow() {
        System.out.println("Minimizing window");
        driver.manage().window().minimize();
        return this;
    }

    public BrowserActions SwitchToWindow(String windowHandle) {
        System.out.println("Switching to window");
        driver.switchTo().window(windowHandle);
        return this;
    }

    public BrowserActions SwitchToNewWindow() {
        System.out.println("Switching to new window");
        driver.switchTo().newWindow(WindowType.WINDOW);
        return this;
    }

    public BrowserActions SwitchToNewTaB() {
        System.out.println("Switching to new taB window");
        driver.switchTo().newWindow(WindowType.TAB);
        return this;
    }

    public BrowserActions CloseCurrentWindow() {
        System.out.println("Closing window");
        driver.close();
        return this;
    }

    public BrowserActions SwitchToFrame(int frame_index) {
        System.out.println("Switching to window");
        driver.switchTo().frame(frame_index);
        return this;
    }

    public BrowserActions SwitchToFrame(String frame_nameorId) {
        System.out.println("Switching to window");
        driver.switchTo().frame(frame_nameorId);
        return this;
    }

    public BrowserActions SwitchtoDefaultcontent() {
        System.out.println("Switching to window");
        driver.switchTo().defaultContent();
        return this;
    }

    public BrowserActions SwitchtoParentFrame() {
        System.out.println("Switching to parent frame");
        driver.switchTo().parentFrame();
        return this;
    }

    public BrowserActions deleteAllCookies() {
        System.out.println("Deleting cookies");
        driver.manage().deleteAllCookies();
        return this;
    }

    public BrowserActions deleteCookie(Cookie cookie) {
        System.out.println("Deleting cookie");
        driver.manage().deleteCookie(cookie);
        return this;
    }

    public BrowserActions deleteCookieNamed(String name) {
        System.out.println("Deleting cookie");
        driver.manage().deleteCookieNamed(name);
        return this;
    }

    public BrowserActions addCookie(Cookie cookie) {
        System.out.println("Adding cookie");
        driver.manage().addCookie(cookie);
        return this;
    }
    public BrowserActions browser()  {
        return new BrowserActions(driver);
    }

}
