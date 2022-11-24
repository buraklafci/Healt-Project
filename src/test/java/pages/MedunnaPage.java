package pages;

import org.openqa.selenium.By;
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
    public List<WebElement> hastaBilgileriTable;

    @FindBy(xpath = "//*[@name='ssn']")
    public WebElement hastaArama;

    @FindBy(xpath = "//*[text()='Edit']")
    public WebElement edit;

    @FindBy(css = "#patient-id")
    public WebElement hastaBilgileriID;

    @FindBy(xpath="//span[text()='Register']")
    public WebElement register;
@FindBy(xpath = "//input[@id='ssn']")
    public WebElement ssntextbox;
@FindBy(xpath = "(//div[@class='invalid-feedback'])[1]")
    public WebElement ssndogrulama;
    @FindBy(xpath = "//*[text()='Your SSN is required.']")
    public WebElement ssnbosdogrulama;

    @FindBy(xpath = "//*[@name='firstName']")
    public WebElement firstName;
    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement lastName;
    @FindBy(css = "#patient-cstate")
    public WebElement state;
    @FindBy(css = "#patient-description")
    public WebElement description;

    @FindBy(xpath ="//span[.='Save']")
    public WebElement saveButton;

    @FindBy(xpath ="//div[.='A Patient is updated with identifier 1051']")
    public WebElement bilgilerGuncellendi;

    @FindBy(css ="a[class='btn btn-info btn-sm")
    public WebElement viewButton;

    @FindBy(xpath ="(//dl[@class=\"jh-entity-details\"]/dd)[1]")
    public WebElement SSNBosmu;
    @FindBy(xpath ="(//dl[@class=\"jh-entity-details\"]/dd)[2]")
    public WebElement firstNameBosmu;
    @FindBy(xpath ="(//dl[@class=\"jh-entity-details\"]/dd)[3]")
    public WebElement lastNameBosmu;
    @FindBy(xpath ="(//dl[@class=\"jh-entity-details\"]/dd)[4]")
    public WebElement birthDateBosmu;
    @FindBy(xpath ="(//dl[@class=\"jh-entity-details\"]/dd)[5]")
    public WebElement emailBosmu;
    @FindBy(xpath ="(//dl[@class=\"jh-entity-details\"]/dd)[6]")
    public WebElement genderBosmu;
    @FindBy(xpath ="(//dl[@class=\"jh-entity-details\"]/dd)[7]")
    public WebElement bloodGroupBosmu;
    @FindBy(xpath ="(//dl[@class=\"jh-entity-details\"]/dd)[8]")
    public WebElement addressBosmu;
    @FindBy(xpath ="(//dl[@class=\"jh-entity-details\"]/dd)[9]")
    public WebElement descriptionBosmu;
    @FindBy(xpath ="(//dl[@class=\"jh-entity-details\"]/dd)[10]")
    public WebElement createdDateBosmu;
    @FindBy(xpath ="(//dl[@class=\"jh-entity-details\"]/dd)[11]")
    public WebElement userBosmu;
    @FindBy(xpath ="(//dl[@class=\"jh-entity-details\"]/dd)[12]")
    public WebElement countryBosmu;
    @FindBy(xpath ="(//dl[@class=\"jh-entity-details\"]/dd)[13]")
    public WebElement stateBosmu;

    @FindBy(xpath ="//tbody//tr[1]//td[16]")
    public WebElement deleteYok;

    @FindBy(css ="#account-menu")
    public WebElement accountMenu;
    @FindBy(xpath ="//*[@data-icon='sign-out-alt']")
    public WebElement signOut;
    @FindBy(xpath ="//button[.='SIGN IN AGAIN']")
    public WebElement sigInAgain;

    @FindBy(xpath ="//span[.='Items&Titles']")
    public WebElement itemsTitles;
    @FindBy(xpath ="//span[.='Patient']")
    public WebElement patient;
    @FindBy(xpath ="//span[.='Patients']")
    public WebElement patients;


    @FindBy(xpath ="//*[@name='username']")
    public WebElement userName;
    @FindBy(css ="#email")
    public WebElement email;
    @FindBy(xpath ="//*[@name='firstPassword']")
    public WebElement firstPassword;
    @FindBy(xpath ="//*[@name='secondPassword']")
    public WebElement confirmPassword;
     @FindBy(css ="#register-submit")
    public WebElement submit;

     @FindBy(xpath ="//tbody//tr//td[7]")
     public List<WebElement> mailDB;










}
