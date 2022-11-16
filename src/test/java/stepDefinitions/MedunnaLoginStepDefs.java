package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.MedunnaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class MedunnaLoginStepDefs {

    MedunnaPage medunnaPage=new MedunnaPage();
    @Given("kullanici medunna anasayfasina gider")
    public void kullaniciAnasayfasinaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("MedunnaUrl"));
    }

    @When("login olmak icin signin e tiklar")
    public void loginOlmakIcinSigninETiklar() {
        ReusableMethods.waitForVisibility(medunnaPage.signinSymbol,5);
        medunnaPage.signinSymbol.click();
        medunnaPage.signinButton.click();
    }

    @And("username icin {string} kullanici adini gonderir")
    public void usernameIcinKullaniciAdiniGonderir(String username) {
        medunnaPage.username.sendKeys(username);
    }

    @And("password icin {string} parolasini gonderir")
    public void passwordIcinParolasiniGonderir(String password) {
        medunnaPage.password.sendKeys(password);
    }

    @And("signine tiklar")
    public void signineTiklar() {
        medunnaPage.signinWithCredentials.click();
    }

    @Given("logIn")
    public void logın() {
        kullaniciAnasayfasinaGider();
        loginOlmakIcinSigninETiklar();
        usernameIcinKullaniciAdiniGonderir(ConfigReader.getProperty("StaffUserName"));
        passwordIcinParolasiniGonderir(ConfigReader.getProperty("StaffPassword"));
        signineTiklar();
    }
}
