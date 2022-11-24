Feature: Registration
  Scenario: Registration Test
    Given kullanici "MedunnaUrl" anasayfasina gider
    Then kullanici bilgi sekmesine tiklanir
    And  kullanici register butonuna tiklar
    And SSN no "177-81-7294" istenilen formatta girildigini dogrular
    And firstname "Berk" istenilen formatta girildigini dogrular
    And lastname "Karanfil" istenilen formatta girildigini dogrular