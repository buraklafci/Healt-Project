package stepDefinitions.UISteps;

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

    @And("logInStaf icin username kullanici adini gonderir")
    public void logInStafIcinKullaniciAdiniGonderir() {
        medunnaPage.username.sendKeys(ConfigReader.getProperty("StaffUserName"));
    }

    @And("logInStaf icin password parolasini gonderir")
    public void logInStafIcinParolasiniGonderir() {
        medunnaPage.password.sendKeys(ConfigReader.getProperty("StaffPassword"));
    }
    @And("loginAdmin icin username kullanici adini gonderir")
    public void loginAdminIcinKullaniciAdiniGonderir() {
        medunnaPage.username.sendKeys(ConfigReader.getProperty("AdminUserName"));
    }

    @And("loginAdmin icin password parolasini gonderir")
    public void loginAdminIcinParolasiniGonderir() {
        medunnaPage.password.sendKeys(ConfigReader.getProperty("AdminPassword"));
    }

    @And("signine tiklar")
    public void signineTiklar() {
        medunnaPage.signinWithCredentials.click();
    }

    @Given("logInStaf")
    public void logInStaf() {

        kullaniciAnasayfasinaGider();
        loginOlmakIcinSigninETiklar();
        logInStafIcinKullaniciAdiniGonderir();
        logInStafIcinParolasiniGonderir();
        signineTiklar();
    }

    @Given("logInAdmin")
    public void logInAdmin() {
        ReusableMethods.waitFor(4);
        if(medunnaPage.accountMenu.isDisplayed()){
            medunnaPage.accountMenu.click();
            ReusableMethods.waitFor(5);
            medunnaPage.signOut.click();
            ReusableMethods.waitForVisibility(medunnaPage.sigInAgain,5);
            medunnaPage.sigInAgain.click();

            loginAdminIcinKullaniciAdiniGonderir();
            loginAdminIcinParolasiniGonderir();
            signineTiklar();
        }
        else {
        kullaniciAnasayfasinaGider();
        loginOlmakIcinSigninETiklar();
        loginAdminIcinKullaniciAdiniGonderir();
        loginAdminIcinParolasiniGonderir();
        signineTiklar();
    }
}
}
