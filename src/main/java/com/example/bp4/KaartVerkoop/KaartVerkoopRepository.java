package com.example.bp4.KaartVerkoop;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.bp4.Cabaretier.Cabaretier;
import com.example.bp4.Concert.Concert;
import com.example.bp4.Theatervoortstelling.Theatervoorstelling;

@Repository
public interface KaartVerkoopRepository extends JpaRepository<KaartVerkoop, Integer> {

    // custom query to search to blog post by title or content
//    List<Product> findByTitleContainingOrContentContaining(String text, String textAgain);

	
	@Query(value = "SELECT * \r\n" + 
			"FROM voorstellingen \r\n" + 
			"LEFT JOIN cabaretiers\r\n" + 
			"ON voorstellingen.cabaretier_id = cabaretiers.cabaretier_id\r\n" + 
			"WHERE v_leeftijdscategorie = (SELECT leeftijdscategorie FROM gebruikers where gebruikersnaam = ?1) and concert_id IS NULL and theatervoorstelling_id is null AND voorstellingen.voorstelling_id IN  \r\n" +
			"(SELECT  kv_voorstelling_id\r\n" + 
			"FROM kaartenverkopen\r\n" + 
			"WHERE kv_gebruikers_id = ?1\r\n" + 
			")", nativeQuery = true)
	List<Cabaretier> getCabaretierVoorstellingen(Integer gebruikersId);   
	
	@Query(value = "SELECT * \r\n" + 
			"FROM voorstellingen \r\n" + 
			"LEFT JOIN Concerten\r\n" + 
			"ON voorstellingen.concert_id = Concerten.concert_id\r\n" + 
			"WHERE v_leeftijdscategorie = (SELECT leeftijdscategorie FROM gebruikers where gebruiker_id = ?1) and Concerten.concert_id IS NOT NULL AND voorstellingen.voorstelling_id IN\r\n" + 
			"(SELECT kv_voorstelling_id\r\n" + 
			"FROM kaartenverkopen\r\n" + 
			"WHERE kv_gebruikers_id = ?1\r\n" + 
			")" , nativeQuery = true)
	List<Concert> getConcertVoorstellingen(String gebruikersnaam);   
	
	@Query(value = "SELECT * \r\n" + 
			"FROM voorstellingen \r\n" + 
			"LEFT JOIN Theatervoorstellingen\r\n" + 
			"ON voorstellingen.theatervoorstelling_id = Theatervoorstellingen.theatervoorstelling_id\r\n" + 
			"WHERE v_leeftijdscategorie = (SELECT leeftijdscategorie FROM gebruikers where gebruiker_id = ?1) and Theatervoorstellingen.theatervoorstelling_id IS NOT NULL AND voorstellingen.voorstelling_id IN\r\n" + 
			"(SELECT kv_voorstelling_id\r\n" + 
			"FROM kaartenverkopen\r\n" + 
			"WHERE kv_gebruikers_id = ?1\r\n" + 
			")", nativeQuery = true)
	List<Theatervoorstelling> getTheaterVoorstellingen(String gebruikersnaam);   
}
