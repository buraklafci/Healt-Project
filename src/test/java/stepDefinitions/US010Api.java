package stepDefinitions;

import io.restassured.builder.RequestSpecBuilder;
import io.cucumber.java.en.*;
import org.junit.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pages.MedunnaBaseUrl;
import pojos.AppointmentPojo;
import pojos.PatientPojo;
import pojos.Physician;
import pojos.UserPojo;

import utilities.ReusableMethods;

import utilities.ConfigReader;
import utils.Authentication;

import utils.ObjectMapperUtils;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utils.Authentication.generateToken;

public class US010Api  {
    static Response response;
    static AppointmentPojo actualData;
    static AppointmentPojo expectedData;
    static UserPojo user;
    static PatientPojo patient;
    static Physician physician;
    static String token;

    @Given("Doktor Medunna Url i id ile ayarlar")
    public void doktorMedunnaUrlidIleAyarlar() {
        String patientEndPoint = ConfigReader.getProperty("patientEndPoint");
        token = Authentication.generateToken();
        response = given().headers(
                "Authorization",
                "Bearer " + token,
                "Content-Type`",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).when().get(patientEndPoint);
        response.prettyPrint();

    }

    @And("Doctor GET request yapar ve response alir")
    public void doctorGETRequestYaparVeResponseAlir() {

         user = new UserPojo("anonymousUser","2022-11-15T13:16:32.261615Z",300780,"hastaosbt","Oğuz",
                "TOKLUCU","hastaosb@gmail.com",true,"en",null,null,"751-01-3536");

         patient= new PatientPojo("hastaosbt","2022-11-15T13:51:33.044901Z",300396,"Oğuz",
                "TOKLUCU",null,"555-666-5566","MALE","Apositive","","hastaosb@gmail.com",
                "null",user,null,null,null);

         physician = new Physician("adminosbt","2022-11-16T10:01:39.404884Z",301043,"Prof.Dr. Oğuz",
                "TOKLUCU","1990-12-31T22:00:00Z","444-444-4444","MALE","Apositive","",
                "Professor Doctor",user,"OPHTHALMOLOGY",null,null,200.00,"","image/png");

         expectedData= new AppointmentPojo("hastaosbt","2022-11-16T10:19:30.334695Z",302324,
                "2022-11-21T00:00:00Z","2022-11-21T01:00:00Z","COMPLETED","Gecmis rahatsizligi bulunmamakta",
                "gozluk + Goz damlasi","0.50 Astigmat","0.50 Astigmat gozluk, aqua goz damlasi gunde 5 damla",
                "",physician,patient,null);


        // response = given().spec(spec).header("Authorization","Bearer "+generateToken())
         //       .contentType(ContentType.JSON).when().get("/{1}/{2}/{3}");


    }

    @And("Doctor json datayi deserialize yaparak javaya dondurur")
    public void doctorJsonDatayiDeserializeYaparakJavayaDondurur() {
         actualData = ObjectMapperUtils.convertJsonToJava(response.asString(),AppointmentPojo.class);
    }

    @And("Doctor randevulari API ile dogrular")
    public void doctorRandevulariAPIIleDogrular() {

        assertEquals(200,response.getStatusCode());
        assertEquals(expectedData.getCreatedBy(),actualData.getCreatedBy());
        assertEquals(user.getFirstName(),actualData.getPatient().getUser().getFirstName( ));
    }
}
