package stepDefinitions.APISteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.PatientPojo;
import pojos.UserPojo;
import utils.Authentication;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class US_09_StepDefs {
    String token;
    Response response;
    PatientPojo expected;
    PatientPojo actual;
    UserPojo user;
    @Given("kullanici Api icin connection kurar")
    public void kullaniciApiIcinConnectionKurar() {
        String endPoint="https://www.medunna.com/api/patient/4851";
        token= Authentication.generateToken();
        response=given().headers("Authorization","Bearer " + token,
                "Content-Type ", ContentType.JSON,"Accept",ContentType.JSON).when().get(endPoint);
        response.prettyPrint();
    }

    @Then("kullanici hasta bilgilerinin hepsini ceker")
    public void kullaniciHastaBilgilerininHepsiniCeker() {
        user=new UserPojo("","",4851,"","","","",true,"",
                "","","");
        expected=new PatientPojo("patient2","2021-12-31",4851,"Adanali01",
                "Turkiyeliii","1991-02-02 21:23:00.0","5555555555","MALE","Apositive",
                "sananeGardasYaw","bosversenee@gmail.com","",user,"3801","",null);
    }

    @And("kullanici gelen bilgileri json{string}ya deserilization yapar")
    public void kullaniciGelenBilgileriJsonDanJavaYaDeserilizationYapar() {
    actual= ObjectMapperUtils.convertJsonToJava(response.asString(),PatientPojo.class);

    }

    @And("kullanici hasta bilgilerini API ile dogrular")
    public void kullaniciHastaBilgileriniAPIIleDogrular() {
        assertEquals(200,response.getStatusCode());
        assertEquals(expected.getFirstName(),actual.getFirstName());
        assertEquals(expected.getLastName(),actual.getLastName());
        assertEquals(expected.getId(),actual.getId());
        assertEquals(expected.getGender(),actual.getGender());
        assertEquals(expected.getBirthDate(),actual.getBirthDate());
        assertEquals(expected.getCstate(),actual.getCstate());
        assertEquals(expected.getEmail(),actual.getEmail());
        assertEquals(expected.getBloodGroup(),actual.getBloodGroup());
        assertEquals(expected.getAdress(),actual.getAdress());

    }
}
