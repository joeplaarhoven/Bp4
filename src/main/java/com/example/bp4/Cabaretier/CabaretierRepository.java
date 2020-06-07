package com.example.bp4.Cabaretier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CabaretierRepository extends JpaRepository<Cabaretier, Integer> {
	
    // custom query to search to blog post by title or content
	//    List<Product> findByTitleContainingOrContentContaining(String text, String textAgain);
	
	//Query om de cabaretier met de voorstellingen te kunnen toevoegen
	@Query(value = "SELECT *\r\n" + 
			" FROM Cabaretiers\r\n" + 
			" LEFT JOIN Voorstellingen\r\n" + 
			" ON Cabaretiers.cabaretier_id = Voorstellingen.cabaretier_id\r\n" + 
			" WHERE Cabaretiers.cabaretier_id = ?1", nativeQuery = true)
	Cabaretier findOneCabaretier(Integer cabaretier_id);
	
	//Query om de cabaretier te updaten
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE Cabaretiers SET cabaretier_voornaam =?1, cabaretier_achternaam =?2, geboortedatum =?3, geslacht =?4, voorstelling_id = 0 WHERE cabaretier_id =?5", nativeQuery = true)
	int cabaretierBijwerken(String c_cabaretier_voornaam, String c_cabaretier_achternaam, String c_geboortedatum, String c_geslacht, Integer c_cabaretier_id);
	
}