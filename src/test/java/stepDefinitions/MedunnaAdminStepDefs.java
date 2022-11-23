package stepDefinitions;

import io.cucumber.java.en.And;
import pages.MedunnaPage;
import utilities.ReusableMethods;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MedunnaAdminStepDefs {
    MedunnaPage medunnaPage=new MedunnaPage();
    @And("Admin, hastaları SSN kimliklerine göre arayamadi.")
    public void adminHastalarıSSNKimliklerineGöreArayamadi() {
       medunnaPage.itemsTitles.click();
       medunnaPage.patient.click();

    assertTrue(medunnaPage.patients.isDisplayed());
    }
}
