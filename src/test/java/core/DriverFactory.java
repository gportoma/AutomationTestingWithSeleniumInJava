package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import util.YAMLConfigReader;

import java.time.Duration;
import java.util.Objects;

public class DriverFactory {

    private static WebDriver driver = null;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver() {
        createDriver();
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

    private static void createDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", Objects.requireNonNull(YAMLConfigReader.getValueByKey("path_chromedriver")));
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }
    }
}