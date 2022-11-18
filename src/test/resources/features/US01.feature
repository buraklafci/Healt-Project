@US01
Feature: US01 Kayıt olmak için SSN, First Name ve Last Name bilgileri girilebilmelidir.

  Scenario Outline: TC01 Geçerli bir SSN, 3. ve 5. rakamdan sonra "-" içermeli ve 9 rakamdan oluşmalıdır.
    Given kullanici url anasayfasina gider
    Then kullanici bilgi sekmesine tiklanir
    And  kullanici register butonuna tiklar
    And SSN no "<number>" istenilen formatta girilmedigini dogrular

    Examples: | number    |
              | 123456789 |