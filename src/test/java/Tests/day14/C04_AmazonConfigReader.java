package Tests.day14;

import Pages.AmazonPage;
import Utilities.ConfigReader;
import Utilities.testBase;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C04_AmazonConfigReader extends testBase {




    @Test
    public void test(){

        //Amazon sayfasına gidin

        driver.get(ConfigReader.getProperty("AmazonUrl"));
        //nutella için arama yapın
        AmazonPage amazonPage=new AmazonPage(driver);
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("AmazonArananKelime")+ Keys.ENTER);
        //sonuç sayısını yazdrın ve nutella içerdiğini test edin

        System.out.println( amazonPage.sonucYazisiElementi.getText());


        Assert
                .assertTrue(amazonPage.sonucYazisiElementi.getText().
                        contains(ConfigReader.getProperty("AmazonArananKelime")));


    }
}
