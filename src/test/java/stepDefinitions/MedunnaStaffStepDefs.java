package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.MedunnaPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

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
        List<WebElement> actualData=medunnaPage.hastaBilgileri;
        for (WebElement w:actualData){

                System.out.println(w.getText());
        }
      //  actualData.forEach(t-> System.out.printf("%S, %S, %S, %S, %S, %S, %8S, %S, %S, %S, %S, %S, %S, %S, %S, %S, %S, %S",t.getText()));

        Assert.assertTrue(medunnaPage.hastaBilgileri.get(0).isDisplayed());
    }
}
