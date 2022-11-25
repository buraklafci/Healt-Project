package stepDefinitions.DBSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import pages.MedunnaPage;
import pojos.PatientPojo;
import pojos.UserPojo;
import stepDefinitions.UISteps.MedunnaStaffStepDefs;
import utilities.DatabaseUtility;
import utilities.ReadTxt;
import utilities.ReusableMethods;
import utilities.WriteToTxt;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class US_09_StepDefs {
    Map<String,Object> actual;

    MedunnaPage medunnaPage=new MedunnaPage();
    @Then("kullanici tum hasta bilgilerini ceker {string}")
    public void kullaniciTumHastaBilgileriniCekerVe(String query) {
        actual=DatabaseUtility.getRowMap(query);
        System.out.println("actual = " + actual);


    }
    @And("kullanici hastanin tum bilgilerini dogrular")
    public void kullaniciTumHastaBilgileriniDogrular() {
        UserPojo user=new UserPojo("","",4851,"","","","",true,"",
                "","","");

        PatientPojo expected=new PatientPojo("patient2","2021-12-31",4851,"Adanali01",
                "Turkiyeliii","1991-02-02 21:23:00.0","5555555555","MALE","Apositive",
                "sananeGardasYaw","bosversenee@gmail.com","",user,"3801","",null);

        assertEquals(expected.getFirstName(),actual.get("first_name"));
        assertEquals(expected.getLastName(),actual.get("last_name"));
       // assertEquals(expected.getId(),actual.get("id"));
        assertEquals(expected.getGender(),actual.get("gender"));
       // assertEquals(expected.getBirthDate(),actual.get("birth_date"));
        assertEquals(expected.getCstate(),actual.get("cstate_id"));
        assertEquals(expected.getEmail(),actual.get("email"));
        assertEquals(expected.getBloodGroup(),actual.get("blood_group"));
        assertEquals(expected.getAdress(),actual.get("adress"));

    }
}
