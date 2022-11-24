package stepDefinitions.UISteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    public static List<WebElement> actualData;
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

       actualData=medunnaPage.hastaBilgileriTable;
        for (WebElement w:actualData){

                System.out.println(w.getText());
        }
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
        medunnaPage.hastaBilgileriID.sendKeys("2323");
        String actualId=medunnaPage.hastaBilgileriID.getText();
        assertFalse(actualId.contains("2323"));

    }

    @And("Hastanin diger bilgileri guncellendi")
    public void hastaninDigerBilgileriGuncellendi() throws InterruptedException {
        Driver.getDriver().navigate().refresh();
        actions.sendKeys(medunnaPage.firstName).doubleClick().sendKeys("Adanali01").
                sendKeys(Keys.TAB).sendKeys("Turkiyeliii").
                sendKeys(Keys.TAB).sendKeys("02.02.1991").
                sendKeys(Keys.RIGHT).sendKeys("23:23").
               sendKeys(Keys.TAB).sendKeys("bosversenee@gmail.com").
                sendKeys(Keys.TAB).sendKeys("5555555555").
                sendKeys(Keys.TAB).sendKeys("Male").
                sendKeys(Keys.TAB).sendKeys("A+").
                sendKeys(Keys.TAB).sendKeys("sananeGardasYaw").perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        medunnaPage.description.clear();
        ReusableMethods.waitFor(2);
        actions.click(medunnaPage.description).sendKeys("banabuuggg").
                sendKeys(Keys.TAB).sendKeys("hy").
                sendKeys(Keys.TAB).sendKeys("Turkey").perform();
        ReusableMethods.waitFor(2);
        medunnaPage.saveButton.submit();
        ReusableMethods.waitForVisibility(medunnaPage.bilgilerGuncellendi,5);
        assertTrue(medunnaPage.bilgilerGuncellendi.isDisplayed());


    }


    @And("Wiev'e tiklanir")
    public void wievETiklanir() {
        JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
        // jse.executeScript("arguments[0].scrollIntoView(true);",medunnaPage.viewButton);
        jse.executeScript("arguments[0].click();",medunnaPage.viewButton);

    }

    @And("Tum bilgilerin dolduruldugu goruldu")
    public void tumBilgilerinDoldurulduguGoruldu() {
        assertFalse(medunnaPage.SSNBosmu.getText().isEmpty());
        assertFalse(medunnaPage.firstNameBosmu.getText().isEmpty());
        assertFalse(medunnaPage.lastNameBosmu.getText().isEmpty());
        assertFalse(medunnaPage.birthDateBosmu.getText().isEmpty());
        assertFalse(medunnaPage.emailBosmu.getText().isEmpty());
        assertFalse(medunnaPage.genderBosmu.getText().isEmpty());
        assertFalse(medunnaPage.bloodGroupBosmu.getText().isEmpty());
        assertFalse(medunnaPage.addressBosmu.getText().isEmpty());
        assertFalse(medunnaPage.descriptionBosmu.getText().isEmpty());
        assertFalse(medunnaPage.createdDateBosmu.getText().isEmpty());
        assertFalse(medunnaPage.userBosmu.getText().isEmpty());
        assertFalse(medunnaPage.countryBosmu.getText().isEmpty());
        assertTrue(medunnaPage.stateBosmu.getText().isEmpty());
    }


    @And("Herhangi bir hasta bilgisi silindi")
    public void herhangiBirHastaBilgisiSilindi() {
        medunnaPage.description.clear();
        ReusableMethods.waitFor(2);
        medunnaPage.saveButton.submit();
        ReusableMethods.waitForVisibility(medunnaPage.bilgilerGuncellendi,3);
        assertTrue(medunnaPage.bilgilerGuncellendi.isDisplayed());
    }

    @And("Herhangi bir hasta silinemedi")
    public void herhangiBirHastaSilinemedi() {
       assertFalse(medunnaPage.deleteYok.getText().contains("Delete"));
    }
}





