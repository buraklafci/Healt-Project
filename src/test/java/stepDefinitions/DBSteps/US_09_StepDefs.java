package stepDefinitions.DBSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import pages.MedunnaPage;
import stepDefinitions.UISteps.MedunnaStaffStepDefs;
import utilities.DatabaseUtility;
import utilities.ReadTxt;
import utilities.ReusableMethods;
import utilities.WriteToTxt;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class US_09_StepDefs {
    List<Object> patientEmail;

    MedunnaPage medunnaPage=new MedunnaPage();
    @Then("kullanici tum hasta bilgilerini ceker {string} ve {string}")
    public void kullaniciTumHastaBilgileriniCekerVe(String query,String columnName) {
        patientEmail=DatabaseUtility.getColumnData(query,columnName);
        System.out.println(patientEmail+"\n");
        String fileName="src/test/resources/testData/PatientEmail";
        WriteToTxt.savepatientEmail(fileName,patientEmail);


    }
    @And("kullanici tum hasta bilgilerini dogrular")
    public void kullaniciTumHastaBilgileriniDogrular() {
        String fileName="src/test/resources/testData/PatientEmail";
        List<Object> actualpatientEmail= ReadTxt.returnPhysicianIDsList(fileName);
       // System.out.println("actualpatientEmail = " + actualpatientEmail);
        List<WebElement>expectedpatientEmail= new ArrayList<>();
        ReusableMethods.waitFor(5);
        expectedpatientEmail.addAll(MedunnaStaffStepDefs.actualData);
        System.out.println("expectedpatientEmail = " + expectedpatientEmail);
        ReusableMethods.waitFor(5);
        assertTrue(actualpatientEmail.contains(expectedpatientEmail));
    }
}
