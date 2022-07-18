package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public abstract class TestBaseCross {



    protected WebDriver driver;

    public TestBaseCross() {
    }

    @Parameters({"browser"})
    @BeforeClass
    public void setup(@Optional String browser) {
        this.driver = DriverCross.getDriver(browser);
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        DriverCross.closeDriver();
    }



}
