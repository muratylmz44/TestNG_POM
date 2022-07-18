package Tests.smokeTest;

import Pages.ConcortHotelPage;
import Utilities.ConfigReader;
import Utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.PriorityQueue;

public class negativeTest {



        // 1) smokeTest  paketi altinda yeni bir Class olustur: NegativeTest
        //3 Farkli test Methodunda 3 senaryoyu test et
        //				- yanlisSifre
        //				- yanlisKulllanici
        //				- yanlisSifreKullanici
        //test data yanlis username: manager1 , yanlis password : manager1!
        //2) https://qa-environment.concorthotel.com/ adresine git

        //Bu site aktif olamdığından eski siteden DEVAM.

        //3) Login butonuna bas
        //4) Verilen senaryolar ile giris yapilamadigini test et



    @Test(priority = -5)
    public void yanlisSifre(){

        Driver.getDriver().get(ConfigReader.getProperty("CHUrl"));

        ConcortHotelPage concortHotelPage=new ConcortHotelPage(Driver.getDriver());
        concortHotelPage.ilkLoginLinki.click();


        concortHotelPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHValidUsername"));

        concortHotelPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHInValidPassword"));

        concortHotelPage.loginButonu.click();

        Assert.assertTrue(concortHotelPage.loginFailedYazısı.isDisplayed());


    }


    @Test (dependsOnMethods = "yanlisSifre")
    public void yanlisKulllanici(){

        ConcortHotelPage concortHotelPage=new ConcortHotelPage(Driver.getDriver());

        concortHotelPage.usernameKutusu.clear();
        concortHotelPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHInValidUsername"));
        concortHotelPage.passwordKutusu.clear();
        concortHotelPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHValidPassword"));
        concortHotelPage.loginButonu.click();

        Assert.assertTrue(concortHotelPage.loginFailedYazısı.isDisplayed());


    }

    @Test (dependsOnMethods = "yanlisSifre")
    public void yanlisSifreKullanici(){

        ConcortHotelPage concortHotelPage=new ConcortHotelPage(Driver.getDriver());

        concortHotelPage.usernameKutusu.clear();
        concortHotelPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHInValidUsername"));
        concortHotelPage.passwordKutusu.clear();
        concortHotelPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHInValidPassword"));
        concortHotelPage.loginButonu.click();

        Assert.assertTrue(concortHotelPage.loginFailedYazısı.isDisplayed());


        Driver.closeDriver();



    }









}
