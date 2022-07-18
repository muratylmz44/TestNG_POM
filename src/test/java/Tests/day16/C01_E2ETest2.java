package Tests.day16;

import Pages.ConcortHotelPage;
import Pages.ConcortHotelPageQA;
import Utilities.ConfigReader;
import Utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;

public class C01_E2ETest2 {



    @Test (groups = "SmokeTest")
    public void roomCreateTest() throws InterruptedException {



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

        // 6. Hotel Management menusunden Add Hotelroom butonuna tıklayın.
        // 7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin


        ConcortHotelPageQA concortHotelPageQA=new ConcortHotelPageQA();

        concortHotelPageQA.HotelManagement.click();
        concortHotelPageQA.HotelManagmentHotelRoomLinki.click();
        concortHotelPageQA.ADDHotelRoom.click();


        Select select=new Select(concortHotelPageQA.AddRoomIdDropDown);

        select.selectByVisibleText(ConfigReader.getProperty("CHAddRoomIdHotel"));
        Faker faker=new Faker();
        Actions actions=new Actions(Driver.getDriver());
        Thread.sleep(3000);

        actions.sendKeys(Keys.TAB)
                . sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)

                .sendKeys(ConfigReader.getProperty("CHAddRoomIdHoteldescription"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("CHAddRoomIdHotelPrice"))
                .perform();


            select=new Select(concortHotelPageQA.addRoomType);
            select.selectByVisibleText(ConfigReader.getProperty("CHAddRoomType"));

            Thread.sleep(3000);


            actions
                    .sendKeys(Keys.TAB)
                    .sendKeys(String.valueOf(faker.number().numberBetween(1,2)))
                    .sendKeys(Keys.TAB)
                    .sendKeys(String.valueOf(faker.number().numberBetween(0,5)))
                    .sendKeys(Keys.TAB)
                    .sendKeys(Keys.SPACE).perform();

            concortHotelPageQA.CreateHotelRoomSAVEButton.click();

            Thread.sleep(2000);


        System.out.println(concortHotelPageQA.AddRoomSuccesYazısı.getText());

        Assert.assertTrue(concortHotelPageQA.AddRoomSuccesYazısı.isDisplayed());

        concortHotelPageQA.AddRoomSuccesYazısıOK.click();

        Driver.closeDriver();





        // 8. Save butonuna basin.
        // 9. “HotelRoom was inserted successfully” textinin göründüğünü test edin.
        //10. OK butonuna tıklayın.
        //11. Hotel rooms linkine tıklayın.
        //12. "LIST OF HOTELROOMS" textinin göründüğünü test edin..






    }
}
