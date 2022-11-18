package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.MedunnaPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.security.Key;
import java.util.List;

import static org.junit.Assert.*;

public class MedunnaStaffStepDefs {
    MedunnaPage medunnaPage=new MedunnaPage();
    Actions actions=new Actions(Driver.getDriver());
    @When("My Pages sekmesine tiklar")
    public void myPagesSekmesineTiklar() {
        medunnaPage.myPage.click();
    }

    @Then("Search Patient secegine tiklar")
    public void searchPatientSecegineTiklar() {
        ReusableMethods.waitForVisibility(medunnaPage.searchPage,10);
        actions.moveToElement(medunnaPage.searchPage).
                click().perform();

    }

    @And("Hasta bilgilerini gorur")
    public void hastaBilgileriniGorur() {
        List<WebElement> actualData=medunnaPage.hastaBilgileriTable;
        for (WebElement w:actualData){

                System.out.println(w.getText());
        }
      //  actualData.forEach(t-> System.out.printf("%S, %S, %S, %S, %S, %S, %8S, %S, %S, %S, %S, %S, %S, %S, %S, %S, %S, %S",t.getText()));

        Assert.assertTrue(medunnaPage.hastaBilgileriTable.get(0).isDisplayed());
    }

    @Then("Hasta arama kutusuna hastanin {string}'i girilir")
    public void hastaAramaKutusunaHastaninIGirilir(String SSN) {
        medunnaPage.hastaArama.sendKeys(SSN,Keys.ENTER);
    }

    @Then("Edit butonuna tiklanir")
    public void editButonunaTiklanir() {
        medunnaPage.edit.click();
    }

    @And("Id bilgisi duzenlenmedi")
    public void ıdBilgisiDuzenlenmedi() {
        ReusableMethods.waitForVisibility(medunnaPage.hastaBilgileriID,10);
        actions.sendKeys(Keys.TAB).perform();

    }

    @And("Hastanin diger bilgileri guncellendi")
    public void hastaninDigerBilgileriGuncellendi() {
        actions.sendKeys(Keys.TAB).sendKeys("Berk").
                sendKeys(Keys.TAB).sendKeys("Karanfil").
                sendKeys(Keys.TAB).sendKeys("02.02.1991").
                sendKeys(Keys.RIGHT).sendKeys("23:23").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("bosversene@gmail.com").
                sendKeys(Keys.TAB).sendKeys("5555555555").
                sendKeys(Keys.TAB).sendKeys("Male").
                sendKeys(Keys.TAB).sendKeys("A+").
                sendKeys(Keys.TAB).sendKeys("sananeGardasYaw").
                sendKeys(Keys.TAB).sendKeys("baksanaBana").
                sendKeys(Keys.TAB).sendKeys("hy").
                sendKeys(Keys.TAB).sendKeys("Turkey ").
                sendKeys(Keys.RIGHT).sendKeys(Keys.RIGHT).sendKeys(Keys.RIGHT).sendKeys(Keys.RIGHT).sendKeys(Keys.RIGHT).sendKeys(Keys.RIGHT).sendKeys(Keys.RIGHT).
                sendKeys(Keys.TAB).sendKeys("Adana").perform();


    }
    @And("Diger hasta bilgileri guncellendi")
    public void digerHastaBilgileriGuncenlendi() {


    }



}
