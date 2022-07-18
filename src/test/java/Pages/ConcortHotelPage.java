package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConcortHotelPage {

    WebDriver driver;

    public ConcortHotelPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);

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


    @FindBy(partialLinkText = " Hotel Rooms")
    public WebElement HotelManagmentHotelRoomLinki;


    @FindBy(xpath = "//span[text()='Add Hotelroom ']")
    public WebElement ADDHotelRoom;





}

