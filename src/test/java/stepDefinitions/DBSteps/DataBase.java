package stepDefinitions.DBSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import utilities.ConfigReader;
import utilities.DatabaseUtility;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static utilities.DatabaseUtility.createConnection;
import static utilities.DatabaseUtility.getColumnData;

public class DataBase {
    List<Object>actualData;
    @Given("kullanici connection kurar")
    public void kullaniciConnectionKurar() {
      //  createConnection(ConfigReader.getProperty("database_url"),ConfigReader.getProperty("database_username"),
        //        ConfigReader.getProperty("database_password"));
        createConnection();
    }

    @And("kullanici tum yeni kayitli bilgileri ceker {string} ve {string}")
    public void kullaniciTumYeniKayitliBilgileriCeker(String query,String columnName) {
        actualData= getColumnData(query,columnName);
    }

    @And("kullanici kullanici bilgilerini dogrular")
    public void kullaniciKullaniciBilgileriniDogrular() {

        assertTrue(actualData.contains("300396"));
    }
}
