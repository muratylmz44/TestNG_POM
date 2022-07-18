package Tests.day13;

import Pages.AmazonPage;
import Utilities.testBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C03_Pages extends testBase {



    @Test
    public void test(){

        //Amazon sayfasına gidin

        driver.get("https://www.amazon.com/");
        //dropdown menüsünden book kategorisini seçin
        AmazonPage amazonPage =new AmazonPage(driver);
        Select select=new Select(amazonPage.dropdownMenu);
        select.selectByVisibleText("Books");

        //java için arama yapın
        amazonPage.aramaKutusu.sendKeys("java"+ Keys.ENTER);
        //bulunan sonuc yazısını yazın

        System.out.println(  amazonPage.sonucYazisiElementi.getText());
        //ilk ürünün isiminde Jave geçtiğini test edin

        Assert.assertTrue(amazonPage.ilkUrunIsim.getText().contains("Java"));

    }
}
