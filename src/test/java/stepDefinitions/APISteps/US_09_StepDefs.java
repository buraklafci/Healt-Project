package stepDefinitions.APISteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.CountryPojo;
import pojos.PatientsPojo;
import pojos.UserPojo;
import utils.Authentication;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class US_09_StepDefs {
    String token;
    Response response;
    PatientsPojo expected;
    CountryPojo countryPojo;
    UserPojo user;
    PatientsPojo actual;
    String endPoint;
    @Given("kullanici Api icin connection kurar")
    public void kullaniciApiIcinConnectionKurar() {
         endPoint="https://www.medunna.com/api/patients/3359";
        token= Authentication.generateToken();
       //response=given().header("Authorization","Bearer " + token).when().get(endPoint);
      // response.prettyPrint();
    }

    @Then("kullanici hasta bilgilerinin hepsini ceker")
    public void kullaniciHastaBilgilerininHepsiniCeker() {
        user=new UserPojo("anonymousUser","2022-07-17T21:28:02.127739Z",127072,"team83_steven.pagac","Team83_Flora","PostRequest_Torp","team83_josue.schoen@hotmail.com",true,"en",
                null,null,"830-97-7748");
        countryPojo=new CountryPojo(239745,"Germany");
        expected=new PatientsPojo("anonymousUser","2021-12-28T19:00:42.797178Z",3359,"Adanali",
                "Turkiyeli","2010-10-10T07:20:00Z","5555555555","MALE","Apositive",
                "sananeGardasYaw","bosversene@gmail.com","",user,null,null,countryPojo,null);
        response=given().headers("Authorization","Bearer " +token).when().get(endPoint);
        response.prettyPrint();
    }

    @And("kullanici gelen bilgileri deserilization yapar")
    public void kullaniciGelenBilgileriDeserilizationYapar() {
         actual= ObjectMapperUtils.convertJsonToJava(response.asString(),PatientsPojo.class);
    }

    @And("kullanici hasta bilgilerini API ile dogrular")
    public void kullaniciHastaBilgileriniAPIIleDogrular() {
        assertEquals(200,response.getStatusCode());
       assertEquals(expected.getFirstName(),actual.getFirstName());
       assertEquals(expected.getLastName(),actual.getLastName());
       assertEquals(expected.getId(),actual.getId());
       assertEquals(expected.getGender(),actual.getGender());
       assertEquals(expected.getBirthDate(),actual.getBirthDate());
       assertEquals(expected.getEmail(),actual.getEmail());
       assertEquals(expected.getBloodGroup(),actual.getBloodGroup());
       assertEquals(expected.getAdress(),actual.getAdress());


    }
}
