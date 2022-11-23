@loginStaff
Feature:Staff olarak Medunna login
  Scenario: Login Staff

    Given kullanici medunna anasayfasina gider
    When login olmak icin signin e tiklar
    And logInStaf icin username kullanici adini gonderir
    And logInStaf icin password parolasini gonderir
    And signine tiklar


  @loginAdmin
  Feature:Admin olarak Medunna login
  Scenario: Login Admin

    Given kullanici medunna anasayfasina gider
    When login olmak icin signin e tiklar
    And loginAdmin icin username kullanici adini gonderir
    And loginAdmin icin password parolasini gonderir
    And signine tiklar

