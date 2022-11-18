@US011
Feature: US_011 "My Appointments" Physician (Doctor) tarafından düzenlenebilmeli
  Scenario: TC01 "Create or edit an appointment" işlemlerini yapabilmeli
    Given Doktor "MedunnaUrl" sayfasına gider
    Then Doktor sign in butonuna basar
    Then Doktor kullanıcı adı ve şifre girerek siteye giriş yapar
    Then Doktor My Pages butonuna tiklar
    Then Doktor My Appointments butonuna tiklar
    Then Doktor Apponintments sayfasında edit butonuna tiklar
    Then Doktor id, Start DateTime, Start DateTime ve Status un bilgileri oldugunu dogrular
    Then Doktor anemnesis, treatment, diagnosis alanlarını doldurur
    Then Doktor Prescription ve Description alanlarını gerekli ise doldurur
    Then Doktor save butonuna tiklar
    And  Doktor "appointment is saved successfully" mesajını dogrular