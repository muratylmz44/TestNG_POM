package Tests.day14;

import Pages.ConcortHotelPage;
import Utilities.testBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C01_ConcortHotelLoginPositive extends testBase {

    @Test
    public void positiveLoginTest() throws InterruptedException {



        // https://www.concorthotel.com/ adresine git

        driver.get("https://www.concorthotel.com/ ");


        ConcortHotelPage concortHotelPage=new ConcortHotelPage(driver);

        //login butonuna basın
        concortHotelPage.ilkLoginLinki.click();

        //testdata username: manager

        concortHotelPage.usernameKutusu.sendKeys("manager");
        //testdata password :Manager1!
        concortHotelPage.passwordKutusu.sendKeys("Manager1!");

        concortHotelPage.loginButonu.click();
        //Değerleri test edildiğinde sayfaya başarılı şekilde girilebildiğini test et


        Thread.sleep(3000);

        Assert.assertTrue(concortHotelPage.basariliGirisYaziElementi.isDisplayed());

    }


}
