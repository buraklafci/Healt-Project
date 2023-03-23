Feature: Kullanıcı API'den gelen hastanin tum bilgilerini doğrulamalıdır.
  Scenario: API test
    Given kullanici Api icin connection kurar
    Then kullanici hasta bilgilerinin hepsini ceker
    And kullanici gelen bilgileri deserilization yapar
    And kullanici hasta bilgilerini API ile dogrular

