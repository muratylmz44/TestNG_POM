package Tests.smokeTest;

import Pages.ConcortHotelPage;
import Utilities.ConfigReader;
import Utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class positiveLoginTest {



    @Test(groups = "SmokeTest")
    public void positiveLoginTest(){

        //Bir test method olustur positiveLoginTest()
        //https://qa-environment.concorthotel.com/ adresine git
        // Bu site kullanımdışı olduğundan eski siteden devam

        Driver.getDriver().get(ConfigReader.getProperty("CHUrl"));


        //login butonuna bas
        ConcortHotelPage concortHotelPage=new ConcortHotelPage(Driver.getDriver());

        concortHotelPage.ilkLoginLinki.click();

        //test data username: manager

        concortHotelPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHValidUsername"));

        //test data password : Manager1!

        concortHotelPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHValidPassword"));

        concortHotelPage.loginButonu.click();

        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

        Assert.assertTrue(concortHotelPage.basariliGirisYaziElementi.isDisplayed());

        Driver.closeDriver();



    }

}
