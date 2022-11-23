@DBTest
Feature: database Test
  Scenario Outline: kullanici db test
    Given kullanici connection kurar
    And kullanici tum yeni kayitli bilgileri ceker "<query>" ve "<columnName>"
    And kullanici kullanici bilgilerini dogrular
    Examples: test verileri
      |query  |columnName |
      |select*from jhi_user|ssn|
