Feature: Kullanıcı DB'den gelen hastanin tum bilgilerini doğrulamalıdır.
  Scenario Outline:DB testing
    Given kullanici DB icin connection kurar
    Then kullanici tum hasta bilgilerini ceker "<query>"
    And kullanici hastanin tum bilgilerini dogrular
    Examples: test verileri
    |query|
    |select * from patient where id=4851|