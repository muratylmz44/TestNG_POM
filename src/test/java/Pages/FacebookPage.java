package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookPage {

 WebDriver driver;

  public  FacebookPage(WebDriver driver){


      this.driver=driver;
     PageFactory.initElements(driver,this);

 }

 @FindBy(id="email")
   public WebElement mailKutusu ;

  @FindBy(id = "pass")
    public WebElement passwordKutusu;

  @FindBy(name = "login")
    public WebElement loginButonu;

  @FindBy(className = "_9ay7")
    public WebElement girilemediYazıElementi;



}
