package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ChromeDriverFactory extends DriverAbstract {
    @Override
    public WebDriver StartDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
        options.addArguments("--start-maximized");
        options.addArguments("--enable-logging");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--headless=new");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-features=PasswordLeakDetection");


        // makes a new java folder and gives it the name "downloads" foldr and then turn it into a full pat, then store the full path inside the downloaddir string
        String downloadDir = new File("downloads").getAbsolutePath();
        // the Map is a list of keys and values, the keys here are strings and the values can be anything like int, strings, etc...
        // the new hashmap ia an empty map (list) which will get filled later on. it is assigned to the MAP called prefs
        Map<String, Object> prefs = new HashMap<>();
        // the hashmap list gets filled with key/value. the key is "download.default_directory", and the value is downloaddir.
        // here it defaults the download directory to downloadir
        // the object in MAP means any data type
        // the <> after hashmap tells it to copy keys and values from left to right side
        // a hashmap is an object of the hashmap class
        prefs.put("download.default_directory", downloadDir);
        // do not ask me where to save it
        prefs.put("download.prompt_for_download", false);
        // permission for download files
        prefs.put("profile.default_content_setting_values.automatic_downloads", 1);

        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        // here's the list of settings, assign them to chrome driver and use them when chrome is called
        options.setExperimentalOption("prefs", prefs);


        driver = new ChromeDriver(options);
        return driver;
    }
}
