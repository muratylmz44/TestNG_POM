package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class DriverCross {


    private static WebDriver driver;

    private DriverCross() {
    }

    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            browser = browser == null ? ConfigReader.getProperty("browser") : browser;
            byte var2 = -1;
            switch (browser.hashCode()) {
                case -1361128838:
                    if (browser.equals("chrome")) {
                        var2 = 0;
                    }
                    break;
                case -849452327:
                    if (browser.equals("firefox")) {
                        var2 = 1;
                    }
                    break;
                case 3108285:
                    if (browser.equals("edge")) {
                        var2 = 3;
                    }
                    break;
                case 105948115:
                    if (browser.equals("opera")) {
                        var2 = 2;
                    }
            }

            switch (var2) {
                case 0:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case 1:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case 2:
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
                case 3:
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
        }

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
        }

        driver = null;
    }
}