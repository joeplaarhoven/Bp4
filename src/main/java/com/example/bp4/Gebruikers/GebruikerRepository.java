package com.example.bp4.Gebruikers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GebruikerRepository extends JpaRepository<Gebruiker, Integer> {

    // custom query to search to blog post by title or content
	//    List<Product> findByTitleContainingOrContentContaining(String text, String textAgain);
	
	
	@Query(value = "SELECT gebruikersnaam, wachtwoord FROM Gebruikers WHERE gebruikersnaam =?1 AND wachtwoord =?2", nativeQuery = true)
	String checkGebruikerLogin(String gebruikersnaam, String wachtwoord);
	
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE Gebruikers SET gebruiker_voornaam =?1, gebruiker_achternaam =?2, geboortedatum =?3, leeftijdscategorie =?4, afkomst =?5, gebruikersnaam =?6, wachtwoord =?7 WHERE gebruiker_id =?8", nativeQuery = true)
	int updateGebruiker(String g_gebruiker_voornaam, String g_gebruiker_achternaam, String g_geboortedatum, String g_leeftijdscategorie, String g_afkomst, String g_gebruikersnaam, String g_wachtwoord, Integer g_gebruiker_id);
	
//	@Modifying(clearAutomatically = true)
//	@Query(value = "UPDATE Gebruikers SET gebruiker_voornaam = :g_gebruiker_voornaam, gebruiker_achternaam = :g_gebruiker_achternaam, geboortedatum = :g_geboortedatum, leeftijdscategorie = :g_leeftijdscategorie, afkomst = :g_afkomst, gebruikersnaam = :g_gebruikersnaam, wachtwoord = :g_wachtwoord WHERE gebruiker_id = :g_gebruiker_id", nativeQuery = true)
//	String updateGebruiker(String g_gebruiker_voornaam, String g_gebruiker_achternaam, String g_geboortedatum, String g_leeftijdscategorie, String g_afkomst, String g_gebruikersnaam, String g_wachtwoord, Integer g_gebruiker_id);

}
