package Tests.day16;

import Pages.ConcortHotelPage;
import Pages.ConcortHotelPageQA;
import Utilities.ConfigReader;
import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C02_WebTable {



    @Test
    public void test() throws InterruptedException {
        //Bir class oluşturun : C02_WebTables
        //● login() metodun oluşturun ve oturum açın.
        //● https://www.concorthotel.com//admin/HotelRoomAdmin adresine gidin
        //			○ Username : manager
        //			○ Password : Manager1!
        ConcortHotelPageQA concortHotelPageQA= new ConcortHotelPageQA();
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




        concortHotelPageQA.HotelManagement.click();
        concortHotelPageQA.HotelManagmentHotelRoomLinki.click();
        //● table() metodu oluşturun
        //			○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody


        System.out.println("Tablodaki sutun sayisi : "+concortHotelPageQA.basliklarListesi.size());
        //			○ Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
        // Eger tum tablo body'sini hucrelere ayirmadan tek bir String olarak gormek istersek
        // tum body'i tek bir Webelement olarak locate edebiliriz
        // Bu yklasim, tabloda HAPPY HOTEL var mi gibi sorular icin ideal bir cozum olur
        System.out.println(concortHotelPageQA.tBodyTumu.getText());
        Thread.sleep(3000);
        Assert.assertTrue(concortHotelPageQA.tBodyTumu.getText().contains("Cizgi Dusler Hotel"));

        for (WebElement each: concortHotelPageQA.basliklarListesi
        ) {
            System.out.println(each.getText());
        }

        //● printRows() metodu oluşturun //tr
        //			○ table body’sinde bulunan toplam satir(row) sayısını bulun.

        System.out.println("tablodaki satir sayisi : "+concortHotelPageQA.satirlarListesi.size());
        //			○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        System.out.println(concortHotelPageQA.birinciSatir.getText());

        // eger tum satirlari yazdirmak istersek
        for (int i=0;i<concortHotelPageQA.satirlarListesi.size();i++){
            System.out.println( i+1 +". satir : " + concortHotelPageQA.satirlarListesi.get(i).getText());
        }
        //			○ 4.satirdaki(row) elementleri konsolda yazdırın.
        for (WebElement each:concortHotelPageQA.dorduncuSutunListesi
        ) {
            System.out.println(each.getText());
        }


        Driver.closeDriver();
    }



}
