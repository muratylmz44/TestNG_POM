package Tests.day13;

import Pages.FacebookPage;
import Utilities.testBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C02_pagesFacebook extends testBase {


    @Test
    public void test() throws InterruptedException {
        //Facebook login sayfasına gidin

        driver.get("https://www.facebook.com/");

        FacebookPage facebookPage=new FacebookPage(driver);

        //kullanıcıadı : techproed@hotmail.com
        facebookPage.mailKutusu.sendKeys("techproed@hotmail.com");

        //şifre :123456
        facebookPage.passwordKutusu.sendKeys("123456");

        // yazdığımızda giriş yapamadığımızı test edin
        facebookPage.loginButonu.click();


        Assert.assertTrue(facebookPage.girilemediYazıElementi.isDisplayed());

        Thread.sleep(3000);



    }



}
