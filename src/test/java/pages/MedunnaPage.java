package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class MedunnaPage {
    public MedunnaPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement signinSymbol;

    @FindBy(xpath = "//*[.='Sign in']")
    public WebElement signinButton;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement username;

    @FindBy (xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy (xpath = "(//*[.='Sign in'])[4]")
    public WebElement signinWithCredentials;

    @FindBy (xpath = "//*[contains(text(), 'Authentication information not correct.')]")
    public WebElement popUpMessage;

    @FindBy(xpath = "//span[.='MY PAGES']")
    public WebElement myPage;

    @FindBy(xpath = "//span[.='Search Patient']")
    public WebElement searchPage;

    @FindBy(xpath = "//thead//tr")
    public WebElement headers;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> hastaBilgileri;


}
