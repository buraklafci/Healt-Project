Feature:US09 Staff (Personel),hasta bilgilerini görebilmeli, düzenleyebilmeli ama silememelidir.


  Scenario: TC001 "My Pages" sekmesinden hasta bilgilerini görebilmelidir.
    Given logIn
    When My Pages sekmesine tiklar
    Then Search Patient secegine tiklar
    And Hasta bilgilerini gorur

  Scenario:TC002 Kullanıcı bütün hasta bilgilerini "id, firstname, lastname, birthdate, email, phone, gender, blood group,
  address, description, user, country and state/city" düzenleyebilmelidir."









