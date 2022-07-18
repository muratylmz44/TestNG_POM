package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ConcortHotelPageQA {




    WebDriver driver;


    public ConcortHotelPageQA(){

        PageFactory.initElements(Driver.getDriver(),this);


    }


    @FindBy(linkText = "Log in")
    public WebElement ilkLoginLinki;

    @FindBy(id = "UserName")

    public WebElement usernameKutusu;

    @FindBy(id = "Password")

    public WebElement passwordKutusu;


    @FindBy(id = "btnSubmit")

    public WebElement loginButonu;

    @FindBy(xpath = "//span[text()='ListOfUsers']")
    public WebElement basariliGirisYaziElementi;

    @FindBy(xpath = "//*[.='Try again please']")

    public WebElement loginFailedYazısı;

    @FindBy(xpath = "//span[text()='Hotel Management']")
    public WebElement HotelManagement;

    @FindBy(partialLinkText ="Hotel List")
    public WebElement HotelListLink;

    @FindBy(xpath = "//span[text()='Add Hotel ']")
    public WebElement ADDHotelButonu;

    @FindBy(id = "Code")
    public WebElement ADDHotelCodeKutusu;


    @FindBy(id = "IDGroup")
    public WebElement AddHotelDropdown;


    @FindBy(id = "btnSubmit")
    public WebElement createHotelSaveButon;


    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement createHotelAlertOK;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement createHotelSuccesText;


    @FindBy(partialLinkText = "Hotel Rooms")
    public WebElement HotelManagmentHotelRoomLinki;


    @FindBy(xpath = "//span[text()='Add Hotelroom ']")
    public WebElement ADDHotelRoom;

    @FindBy(id = "IDHotel")
    public WebElement AddRoomIdDropDown;

    @FindBy(id = "IDGroupRoomType")
    public WebElement addRoomType;

    @FindBy(id = "btnSubmit")
    public WebElement CreateHotelRoomSAVEButton;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement AddRoomSuccesYazısı;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement AddRoomSuccesYazısıOK;


    @FindBy(xpath = "//thead/tr[1]/th")
    public List<WebElement> basliklarListesi;

    @FindBy(xpath = "//tbody")
    public WebElement tBodyTumu;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> satirlarListesi;

    @FindBy(xpath = "//tbody//tr[1]")
    public WebElement birinciSatir;

    @FindBy(xpath = "//tbody/tr//td[4]")
    public List<WebElement> dorduncuSutunListesi;


}

