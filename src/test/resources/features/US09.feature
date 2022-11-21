Feature:US09 Staff (Personel),hasta bilgilerini görebilmeli, düzenleyebilmeli ama silememelidir.

  Scenario: TC001 "My Pages" sekmesinden hasta bilgilerini görebilmelidir.
    Given logIn
    When My Pages sekmesine tiklar
    Then Search Patient secegine tiklar
    And Hasta bilgilerini gorur

  Scenario:TC002 Kullanıcı bütün hasta bilgilerini "id, firstname, lastname, birthdate, email, phone, gender, blood group,
  address, description, user, country and state/city" düzenleyebilmelidir."


    Then Hasta arama kutusuna hastanin "158-13-2323"'i girilir
    Then Edit butonuna tiklanir
    And Id bilgisi duzenlenmedi
    And Hastanin diger bilgileri guncellendi


  Scenario: TC003 Kullanıcı, SSN'lerine göre yeni bir başvuru sahibi arayabilmeli ve tüm kayıt bilgilerinin doldurulduğunu görebilmelidir.

    When My Pages sekmesine tiklar
    Then Search Patient secegine tiklar
    Then Hasta arama kutusuna hastanin "158-13-2323"'i girilir
    And Wiev'e tiklanir
    And Tum bilgilerin dolduruldugu goruldu






