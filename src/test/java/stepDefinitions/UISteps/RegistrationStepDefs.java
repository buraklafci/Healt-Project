package stepDefinitions.UISteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.MedunnaPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class RegistrationStepDefs {
    Actions actions=new Actions(Driver.getDriver());
    MedunnaPage medunnaPage=new MedunnaPage();
    @And("SSN no {string} istenilen formatta girilir")
    public void ssnNoIstenilenFormattaGirilir(String SSN) {
       // SSN= Faker.instance().idNumber().ssnValid();
        actions.click(medunnaPage.ssntextbox).sendKeys(SSN).perform();
    }

    @And("firstname {string} istenilen formatta girilir")
    public void firstnameIstenilenFormattaGirilir(String firstname) {
        actions.click(medunnaPage.firstName).sendKeys(firstname).perform();
    }

    @And("lastname {string} istenilen formatta girilir")
    public void lastnameIstenilenFormattaGirilir(String lastname) {
        actions.click(medunnaPage.lastName).sendKeys(lastname).perform();
    }

    @And("username {string} istenilen formatta girilir")
    public void usernameIstenilenFormattaGirilir(String username) {
        actions.click(medunnaPage.userName).sendKeys(username).perform();
    }

    @And("email {string} istenilen formatta girilir")
    public void emailIstenilenFormattaGirilir(String email) {

        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
           ReusableMethods.waitFor(2);
                actions.click(medunnaPage.email).sendKeys(email).perform();
    }

    @And("password {string} istenilen formatta girilir")
    public void passwordIstenilenFormattaGirilir(String firstPassword) {
        actions.click(medunnaPage.firstPassword).sendKeys(firstPassword).perform();
    }

    @And("confirm password {string} istenilen formatta girilir")
    public void confirmPasswordIstenilenFormattaGirilir(String confirmPassword) {
        actions.click(medunnaPage.confirmPassword).sendKeys(confirmPassword).perform();
    }

    @And("kullanici register yapar")
    public void kullaniciRegisterYapar() {
        medunnaPage.submit.click();
    }
}
