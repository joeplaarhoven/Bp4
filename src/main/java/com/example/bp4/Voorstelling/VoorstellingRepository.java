package com.example.bp4.Voorstelling;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoorstellingRepository extends JpaRepository<Voorstelling, Integer> {

    // custom query to search to blog post by title or content
//    List<Product> findByTitleContainingOrContentContaining(String text, String textAgain);

	@Query(value = "\r\n" + 
			"SELECT * \r\n" + 
			"FROM voorstellingen \r\n" + 
			"WHERE v_leeftijdscategorie = (SELECT leeftijdscategorie FROM gebruikers where gebruikersnaam = ?1)", nativeQuery = true)
	List<Voorstelling> getCabaretierVoorstellingen(String gebruikersnaam);   
	
	@Query(value = "\r\n" + 
			"SELECT * \r\n" + 
			"FROM voorstellingen \r\n" + 
			"WHERE v_leeftijdscategorie = (SELECT leeftijdscategorie FROM gebruikers where gebruikersnaam = ?1)", nativeQuery = true)
	List<Voorstelling> getConcertVoorstellingen(String gebruikersnaam);   
	
	@Query(value = "\r\n" + 
			"SELECT * \r\n" + 
			"FROM voorstellingen \r\n" + 
			"WHERE v_leeftijdscategorie = (SELECT leeftijdscategorie FROM gebruikers where gebruikersnaam = ?1)", nativeQuery = true)
	List<Voorstelling> getTheaterVoorstellingen(String gebruikersnaam);   
}