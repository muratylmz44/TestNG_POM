package Tests.day15;

import Pages.ConcortHotelPage;
import Utilities.ConfigReader;
import Utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;

public class C02_E2ETest {





    @Test
    public void E2Etest() throws InterruptedException {


        // 1. Tests packagenin altına class olusturun: D17_CreateHotel
        //2. Bir metod olusturun: createHotel
        //3. https://qa-environment.concorthotel.com/ adresine git.


        Driver.getDriver().get(ConfigReader.getProperty("CHUrl"));
        //4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri    girin.


        ConcortHotelPage concortHotelPage=new ConcortHotelPage(Driver.getDriver());

        concortHotelPage.ilkLoginLinki.click();
        //	a. Username : manager

        concortHotelPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHValidUsername"));
        //	b. Password  : Manager1!
        concortHotelPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHValidPassword"));
        //5. Login butonuna tıklayın.

        concortHotelPage.loginButonu.click();
        //6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin

        concortHotelPage.HotelManagement.click();
        concortHotelPage.HotelListLink.click();
        concortHotelPage.ADDHotelButonu.click();
        //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.

        Actions actions=new Actions(Driver.getDriver());
        Faker faker=new Faker();

        actions.
                click(concortHotelPage.ADDHotelCodeKutusu).
                sendKeys(faker.address().zipCode()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().name()).
                sendKeys(Keys.TAB).
                sendKeys(faker.address().fullAddress()).
                sendKeys(Keys.TAB).
                sendKeys(faker.phoneNumber().phoneNumber()).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().emailAddress()).
                perform();

        Select select=new Select(concortHotelPage.AddHotelDropdown);
        select.selectByVisibleText(ConfigReader.getProperty("CHIdGrupType"));

        concortHotelPage.createHotelSaveButon.click();


        Thread.sleep(3000);


        //8. Save butonuna tıklayın.
        //9. “Hotel was inserted successfully” textinin göründüğünü test edin.

        System.out.println(concortHotelPage.createHotelSuccesText.getText());

        Assert.assertTrue(concortHotelPage.createHotelSuccesText.isDisplayed());



        concortHotelPage.createHotelAlertOK.click();



        Driver.closeDriver();


        //10. OK butonuna tıklayın.





    }
}
