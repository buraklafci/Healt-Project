package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.MedunnaPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US011_StepDef {
    MedunnaPage medunnaPage = new MedunnaPage();
    @Given("Doktor {string} sayfasına gider")
    public void doktorSayfasınaGider(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));
    }

    @Then("Doktor sign in butonuna basar")
    public void doktorSignInButonunaBasar() {
        medunnaPage.signinSymbol.click();
    }

    @Then("Doktor kullanıcı adı ve şifre girerek siteye giriş yapar")
    public void doktorKullanıcıAdıVeŞifreGirerekSiteyeGirişYapar() {

    }

    @Then("Doktor My Pages butonuna tiklar")
    public void doktorMyPagesButonunaTiklar() {
    }

    @Then("Doktor My Appointments butonuna tiklar")
    public void doktorMyAppointmentsButonunaTiklar() {
    }

    @Then("Doktor Apponintments sayfasında edit butonuna tiklar")
    public void doktorApponintmentsSayfasındaEditButonunaTiklar() {
    }

    @Then("Doktor id, Start DateTime, Start DateTime ve Status un bilgileri oldugunu dogrular")
    public void doktorIdStartDateTimeStartDateTimeVeStatusUnBilgileriOldugunuDogrular() {
    }

    @Then("Doktor anemnesis, treatment, diagnosis alanlarını doldurur")
    public void doktorAnemnesisTreatmentDiagnosisAlanlarınıDoldurur() {
    }

    @Then("Doktor Prescription ve Description alanlarını gerekli ise doldurur")
    public void doktorPrescriptionVeDescriptionAlanlarınıGerekliIseDoldurur() {
    }

    @Then("Doktor save butonuna tiklar")
    public void doktorSaveButonunaTiklar() {
    }

    @And("Doktor {string} mesajını dogrular")
    public void doktorMesajınıDogrular(String arg0) {
    }
}
