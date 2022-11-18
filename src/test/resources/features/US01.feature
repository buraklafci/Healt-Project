@US01
Feature: US01 Kayit olmak icin SSN, First Name ve Last Name bilgileri girilebilmelidir.

  Scenario: TC01 Gecerli bir SSN, 3. ve 5. rakamdan sonra "-" icermeli ve 9 rakamdan olusmalidir.
    Given kullanici "MedunnaUrl" anasayfasina gider
    Then kullanici bilgi sekmesine tiklanir
    And  kullanici register butonuna tiklar
    And SSN no "12354657" istenilen formatta girilmedigini dogrular


  Scenario: TC02 Gecerli bir SSN, 3. ve 5. rakamdan sonra "-" icermeli ve 9 rakamdan olusmalidir.
    Given kullanici "MedunnaUrl" anasayfasina gider
    Then kullanici bilgi sekmesine tiklanir
    And  kullanici register butonuna tiklar
    And SSN no "177-81-7294" istenilen formatta girildigini dogrular


  Scenario: TC03 Gecerli bir SSN, 3. ve 5. rakamdan sonra "-" icermeli ve 9 rakamdan olusmalidir.
    Given kullanici "MedunnaUrl" anasayfasina gider
    Then kullanici bilgi sekmesine tiklanir
    And  kullanici register butonuna tiklar
    And SSN no "" istenilen formatta girildigini dogrular


  Scenario: TC04 Gecerli bir SSN, 3. ve 5. rakamdan sonra "-" icermeli ve 9 rakamdan olusmalidir.
    Given kullanici "MedunnaUrl" anasayfasina gider
    Then kullanici bilgi sekmesine tiklanir
    And  kullanici register butonuna tiklar
    And firstname "" istenilen formatta girildigini dogrular

  Scenario: TC05 Gecerli bir SSN, 3. ve 5. rakamdan sonra "-" icermeli ve 9 rakamdan olusmalidir.
    Given kullanici "MedunnaUrl" anasayfasina gider
    Then kullanici bilgi sekmesine tiklanir
    And  kullanici register butonuna tiklar
    And firstname "kullanici" istenilen formatta girildigini dogrular

  Scenario: TC06 Gecerli bir SSN, 3. ve 5. rakamdan sonra "-" icermeli ve 9 rakamdan olusmalidir.
    Given kullanici "MedunnaUrl" anasayfasina gider
    Then kullanici bilgi sekmesine tiklanir
    And  kullanici register butonuna tiklar
    And lastname "" istenilen formatta girildigini dogrular

  Scenario: TC07 Gecerli bir SSN, 3. ve 5. rakamdan sonra "-" icermeli ve 9 rakamdan olusmalidir.
    Given kullanici "MedunnaUrl" anasayfasina gider
    Then kullanici bilgi sekmesine tiklanir
    And  kullanici register butonuna tiklar
    And lastname "girisi" istenilen formatta girildigini dogrular