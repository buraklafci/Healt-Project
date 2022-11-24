package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.MedunnaPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_01StepDefinitions {
MedunnaPage medunnaPage=new MedunnaPage();
Actions actions=new Actions(Driver.getDriver());
    @Given("kullanici {string} anasayfasina gider")
    public void kullaniciAnasayfasinaGider(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));
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
actions.click(medunnaPage.ssntextbox).sendKeys(number).sendKeys(Keys.TAB).perform();
 Assert.assertTrue(medunnaPage.ssndogrulama.isDisplayed());
    }


    @And("SSN no {string} istenilen formatta girildigini dogrular")
    public void ssnNoIstenilenFormattaGirildiginiDogrular(String number1) {
        actions.click(medunnaPage.ssntextbox).sendKeys(number1).sendKeys(Keys.TAB).perform();
Assert.assertTrue(medunnaPage.ssnbosdogrulama.isDisplayed());
    }


    @And("firstname {string} istenilen formatta girildigini dogrular")
    public void firstnameIstenilenFormattaGirildiginiDogrular(String fisrtname) {
actions.click(medunnaPage.lastName).sendKeys(fisrtname).sendKeys(Keys.TAB).perform();

    }

    @And("lastname {string} istenilen formatta girildigini dogrular")
    public void lastnameIstenilenFormattaGirildiginiDogrular(String lastname) {

        actions.click(medunnaPage.lastName).sendKeys(lastname).sendKeys(Keys.TAB).perform();
    }

}

