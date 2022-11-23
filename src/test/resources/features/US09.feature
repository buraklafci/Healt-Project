Feature:US09 Staff (Personel),hasta bilgilerini görebilmeli, düzenleyebilmeli ama silememelidir.

  Scenario: TC001 "My Pages" sekmesinden hasta bilgilerini görebilmelidir.
    Given logInStaf
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
   Then Hasta arama kutusuna hastanin "456-87-1234"'i girilir
   And Wiev'e tiklanir
   And Tum bilgilerin dolduruldugu goruldu

  Scenario: TC004 Kullanıcı herhangi bir hasta bilgisini silebilir.

    When My Pages sekmesine tiklar
    Then Search Patient secegine tiklar
    And Hasta arama kutusuna hastanin "456-87-1234"'i girilir
    And Edit butonuna tiklanir
    And Herhangi bir hasta bilgisi silindi

  Scenario: TC005  Staff hastaları silememeli.

    When My Pages sekmesine tiklar
    Then Search Patient secegine tiklar
    And Hasta arama kutusuna hastanin "456-87-1234"'i girilir
    And Herhangi bir hasta silinemedi

  Scenario: TC006  Admin, hastaları SSN kimliklerine göre arayamadi.

    Given logInAdmin
    Then Admin, hastaları SSN kimliklerine göre arayamadi.




