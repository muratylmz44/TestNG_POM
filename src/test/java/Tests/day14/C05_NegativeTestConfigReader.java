package Tests.day14;

import Pages.ConcortHotelPage;
import Utilities.ConfigReader;
import Utilities.testBase;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C05_NegativeTestConfigReader extends testBase {

    @Test
    public void test(){

        // concorthotel sitesine git

        driver.get(ConfigReader.getProperty("CHUrl"));
        // login butonuna bas
        ConcortHotelPage concortHotelPage=new ConcortHotelPage(driver);

        concortHotelPage.ilkLoginLinki.click();

        // testdata username = manager1
        concortHotelPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHInValidUsername"));

        //testdata password= manager1!

        concortHotelPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHInValidPassword")+ Keys.ENTER);



        //degerleri girildiğinde girilemediğini test et

        Assert.assertTrue(concortHotelPage.loginFailedYazısı.isDisplayed());


    }
}
