package com.example.bp4.Voorstelling;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.bp4.Cabaretier.Cabaretier;
import com.example.bp4.Concert.Concert;
import com.example.bp4.Theatervoortstelling.Theatervoorstelling;

import java.util.List;

@Repository
public interface VoorstellingRepository extends JpaRepository<Voorstelling, Integer> {

    // custom query to search to blog post by title or content
//    List<Product> findByTitleContainingOrContentContaining(String text, String textAgain);

		@Query(value = "SELECT * \r\n" + 
				"FROM voorstellingen \r\n" + 
				"LEFT JOIN cabaretiers\r\n" + 
				"ON voorstellingen.cabaretier_id = cabaretiers.cabaretier_id\r\n" + 
				"WHERE v_leeftijdscategorie = (SELECT leeftijdscategorie FROM gebruikers where gebruikersnaam = ?1) and afkomst = (SELECT afkomst FROM gebruikers where gebruikersnaam = ?1) and voorstellingen.cabaretier_id IS NOT NULL", nativeQuery = true)
		List<Cabaretier> getCabaretierVoorstellingenWithPrefrence(String gebruikersnaam);   
		
		@Query(value = "SELECT * \r\n" + 
				"FROM voorstellingen \r\n" + 
				"LEFT JOIN cabaretiers\r\n" + 
				"ON voorstellingen.cabaretier_id = cabaretiers.cabaretier_id\r\n" + 
				"WHERE voorstellingen.cabaretier_id IS NOT NULL", nativeQuery = true)
		List<Cabaretier> getCabaretierVoorstellingen();
	
	@Query(value = "SELECT * \r\n" + 
			"FROM voorstellingen \r\n" + 
			"LEFT JOIN Concerten\r\n" + 
			"ON voorstellingen.concert_id = Concerten.concert_id\r\n" + 
			"WHERE v_leeftijdscategorie = (SELECT leeftijdscategorie FROM gebruikers where gebruikersnaam = ?1) and afkomst = (SELECT afkomst FROM gebruikers where gebruikersnaam = ?1) and Concerten.concert_id IS NOT NULL" , nativeQuery = true)
	List<Concert> getConcertVoorstellingenWithPrefrence(String gebruikersnaam);   
	
	@Query(value = "SELECT * \r\n" + 
			"FROM voorstellingen \r\n" + 
			"LEFT JOIN Concerten\r\n" + 
			"ON voorstellingen.concert_id = Concerten.concert_id\r\n" + 
			"WHERE Concerten.concert_id IS NOT NULL" , nativeQuery = true)
	List<Concert> getConcertVoorstellingen();  
	
	@Query(value = "SELECT * \r\n" + 
			"FROM voorstellingen \r\n" + 
			"LEFT JOIN Theatervoorstellingen\r\n" + 
			"ON voorstellingen.theatervoorstelling_id = Theatervoorstellingen.theatervoorstelling_id\r\n" + 
			"WHERE v_leeftijdscategorie = (SELECT leeftijdscategorie FROM gebruikers where gebruikersnaam = ?1) and afkomst = (SELECT afkomst FROM gebruikers where gebruikersnaam = ?1) and Theatervoorstellingen.theatervoorstelling_id IS NOT NULL", nativeQuery = true)
	List<Theatervoorstelling> getTheaterVoorstellingenWithPrefrence(String gebruikersnaam);   
	
	@Query(value = "SELECT * \r\n" + 
			"FROM voorstellingen \r\n" + 
			"LEFT JOIN Theatervoorstellingen\r\n" + 
			"ON voorstellingen.theatervoorstelling_id = Theatervoorstellingen.theatervoorstelling_id\r\n" + 
			"WHERE Theatervoorstellingen.theatervoorstelling_id IS NOT NULL", nativeQuery = true)
	List<Theatervoorstelling> getTheaterVoorstellingen(); 
	
	
	@Modifying
	@Query(value = "INSERT INTO Voorstellingen(v_theaterzaal_id, cabaretier_id, voorstellingsoort, datum, tijd, v_leeftijdscategorie, afkomst)\r\n" + 
			"VALUES(?1, ?2, ?3, ?4, ?5, ?6, ?7);", nativeQuery = true)
	void saveCabaretierVoorstelling(Integer v_theaterzaal_id, Integer cabaretier_id, String voorstellingsoort, String datum,
			String tijd, String v_leeftijdscategorie, String afkomst);   
	
	@Modifying
	@Query(value = "INSERT INTO Voorstellingen(v_theaterzaal_id, concert_id, voorstellingsoort, datum, tijd, v_leeftijdscategorie, afkomst)\r\n" + 
			"VALUES(?1, ?2, ?3, ?4, ?5, ?6, ?7);", nativeQuery = true)
	void saveConcertVoorstelling(Integer v_theaterzaal_id, Integer concert_id, String voorstellingsoort, String datum,
			String tijd, String v_leeftijdscategorie, String afkomst);   
	
	@Modifying
	@Query(value = "INSERT INTO Voorstellingen(v_theaterzaal_id, theatervoorstelling_id, voorstellingsoort, datum, tijd, v_leeftijdscategorie, afkomst)\r\n" + 
			"VALUES(?1, ?2, ?3, ?4, ?5, ?6, ?7);", nativeQuery = true)
	void saveTheaterVoorstelling(Integer v_theaterzaal_id, Integer theatervoorstelling_id, String voorstellingsoort, String datum,
			String tijd, String v_leeftijdscategorie, String afkomst);
	
	@Query(value = "SELECT * \r\n" + 
			"FROM voorstellingen \r\n" + 
			"LEFT JOIN cabaretiers\r\n" + 
			"ON voorstellingen.cabaretier_id = cabaretiers.cabaretier_id\r\n" + 
			"WHERE v_leeftijdscategorie = (SELECT leeftijdscategorie FROM gebruikers where gebruiker_id = ?1) and concert_id IS NULL and theatervoorstelling_id is null AND voorstellingen.voorstelling_id IN  \r\n" +
			"(SELECT  kv_voorstelling_id\r\n" + 
			"FROM kaartenverkopen\r\n" + 
			"WHERE kv_gebruikers_id = ?1\r\n" + 
			")", nativeQuery = true)
	List<Cabaretier> getCabaretierKaart(Integer gebruikers_id);   
	
	@Query(value = "SELECT * \r\n" + 
			"FROM voorstellingen \r\n" + 
			"LEFT JOIN Concerten\r\n" + 
			"ON voorstellingen.concert_id = Concerten.concert_id\r\n" + 
			"WHERE v_leeftijdscategorie = (SELECT leeftijdscategorie FROM gebruikers where gebruiker_id = ?1) and Concerten.concert_id IS NOT NULL AND voorstellingen.voorstelling_id IN\r\n" + 
			"(SELECT kv_voorstelling_id\r\n" + 
			"FROM kaartenverkopen\r\n" + 
			"WHERE kv_gebruikers_id = ?1\r\n" + 
			")" , nativeQuery = true)
	List<Concert> getConcertKaart(Integer gebruikers_id);   
	
	@Query(value = "SELECT * \r\n" + 
			"FROM voorstellingen \r\n" + 
			"LEFT JOIN Theatervoorstellingen\r\n" + 
			"ON voorstellingen.theatervoorstelling_id = Theatervoorstellingen.theatervoorstelling_id\r\n" + 
			"WHERE v_leeftijdscategorie = (SELECT leeftijdscategorie FROM gebruikers where gebruiker_id = ?1) and Theatervoorstellingen.theatervoorstelling_id IS NOT NULL AND voorstellingen.voorstelling_id IN\r\n" + 
			"(SELECT kv_voorstelling_id\r\n" + 
			"FROM kaartenverkopen\r\n" + 
			"WHERE kv_gebruikers_id = ?1\r\n" + 
			")", nativeQuery = true)
	List<Theatervoorstelling> getTheatervoorstellingKaart(Integer gebruikers_id);   

}
