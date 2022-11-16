@login
Feature:TC001  Medunna login
  Scenario Outline: Login test

    Given kullanici medunna anasayfasina gider
    When login olmak icin signin e tiklar
    And username icin "<username>" kullanici adini gonderir
    And password icin "<password>" parolasini gonderir
    And signine tiklar

    Examples:
      | username | password |
      |ahmetPersonel1|hasta+90|