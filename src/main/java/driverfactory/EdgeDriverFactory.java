package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverFactory extends DriverAbstract {


    @Override
    public WebDriver StartDriver() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        options.addArguments("--enable-logging");
        options.addArguments("--window-size=1920,1080");
        driver = new EdgeDriver(options);
        return driver;
    }
}


