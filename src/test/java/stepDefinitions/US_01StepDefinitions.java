package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.MedunnaPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_01StepDefinitions {
MedunnaPage medunnaPage=new MedunnaPage();
Actions actions = new Actions(Driver.getDriver());
    @Given("kullanici url anasayfasina gider")
    public void kullaniciUrlAnasayfasinaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("MedunnaUrl"));
    }
    @Then("kullanici bilgi sekmesine tiklanir")
    public void kullaniciBilgiSekmesineTiklanir() {
       medunnaPage.signinSymbol.click();
    }

    @And("kullanici register butonuna tiklar")
    public void kullaniciRegisterButonunaTiklar() {
medunnaPage.register.click();
    }

    @And("SSN no {string} istenilen formatta girilmedigini dogrular")
    public void ssnNoIstenilenFormattaGirilmediginiDogrular(String number) {
medunnaPage.ssntextbox.sendKeys(number);
actions.sendKeys(Keys.TAB).perform();

    }


}
