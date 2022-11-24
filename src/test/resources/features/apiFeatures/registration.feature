Feature: API test
  Scenario: kullanici api test
    Given kullanici medunna end pointi ayarlar
    And  kullanici Get request ile kayitli SSN'leri alir
    And Gelen response jsondan java diline cevrilir
    And kullanici kayitli kullaniciyi API ile dogrular