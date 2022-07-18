package Tests.day14;

import Pages.ConcortHotelPage;
import Utilities.testBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C02_CHNegativeTest extends testBase {



    @Test
    public void test(){

        //Bir test method olustur NegativeLoginTest()
        //	https://www.concorthotel.com/ adresine git

        driver.get("https://www.concorthotel.com/ ");
        //	login butonuna bas
        ConcortHotelPage concortHotelPage=new ConcortHotelPage(driver);
        concortHotelPage.ilkLoginLinki.click();
        //	test data username: manager1
        concortHotelPage.usernameKutusu.sendKeys("manager1");
        //	test data password : manager1!
        concortHotelPage.passwordKutusu.sendKeys("manager1!");

        concortHotelPage.loginButonu.click();
        //	Degerleri girildiginde sayfaya girilemedigini test et

        Assert.assertTrue(concortHotelPage.loginFailedYazısı.isDisplayed());




    }





}
