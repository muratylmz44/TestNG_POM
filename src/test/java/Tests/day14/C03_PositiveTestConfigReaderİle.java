package Tests.day14;

import Pages.ConcortHotelPage;
import Utilities.ConfigReader;
import Utilities.testBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C03_PositiveTestConfigReaderİle extends testBase {



    @Test
    public void positiveTestConfig(){

        // https://www.concorthotel.com/ adresine git

        driver.get(ConfigReader.getProperty("CHUrl"));
        //login butonuna basın
        ConcortHotelPage concortHotelPage=new ConcortHotelPage(driver);

        concortHotelPage.ilkLoginLinki.click();
        //testdata username: manager
        concortHotelPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHValidUsername"));
        //testdata password :Manager1!
        concortHotelPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHValidPassword"));

        concortHotelPage.loginButonu.click();
        //Değerleri test edildiğinde sayfaya başarılı şekilde girilebildiğini test et

        Assert.assertTrue(concortHotelPage.basariliGirisYaziElementi.isDisplayed());




    }
}
