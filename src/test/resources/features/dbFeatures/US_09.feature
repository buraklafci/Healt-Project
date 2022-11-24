Feature: Kullanıcının DB'den gelen tüm hasta bilgilerini doğrulamalıdır.
  Scenario Outline:DB testing
    Given kullanici connection kurar
    Then kullanici tum hasta bilgilerini ceker "<query>" ve "<columnName>"
    And kullanici tum hasta bilgilerini dogrular
    Examples: test verileri
    |query|columnName|
    |select * from patient |email|