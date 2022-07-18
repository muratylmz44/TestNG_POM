package crossBrowser;

import Pages.ConcortHotelPage;
import Utilities.ConfigReader;
import Utilities.Driver;
import Utilities.TestBaseCross;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class positiveLoginTest  extends TestBaseCross {


    public void positiveLoginTest() throws InterruptedException {
        // cross browser testte test base class'ina geri donuyoruz
        // bunun sebebi @parameters notasyanu
        // dolayisiyla Driver.getDriver() ve pages sayfalarindaki locator'lari kullanamayiz

        //Bir test method olustur positiveLoginTest()
        //https://qa-environment.concorthotel.com/ adresine git

        driver.get(ConfigReader.getProperty("CHQAUrl"));


        //login butonuna bas
        driver.findElement(By.linkText("Log in")).click();
        //test data username: manager ,

        driver.findElement(By.id("UserName")).sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        //test data password : Manager1!

        driver.findElement(By.id("Password")).sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        Thread.sleep(4000);
        driver.findElement(By.id("btnSubmit")).click();
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        WebElement basariliGirisYaziElementi=driver.findElement(By.xpath("//span[text()='ListOfUsers']"));
        Assert.assertTrue(basariliGirisYaziElementi.isDisplayed());

    }
}
