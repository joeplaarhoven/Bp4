package com.example.bp4.Gebruikers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GebruikerRepository extends JpaRepository<Gebruiker, Integer> {

	@Query(value = "SELECT gebruikersnaam, wachtwoord FROM Gebruikers WHERE gebruikersnaam =?1 AND wachtwoord =?2", nativeQuery = true)
	String checkGebruikerLogin(String gebruikersnaam, String wachtwoord);
	
	@Query(value = "SELECT gebruiker_id FROM Gebruikers WHERE gebruikersnaam =?1", nativeQuery = true)
	Integer getGebruikerId(String gebruikersnaam);

}
