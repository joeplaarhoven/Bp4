package com.example.bp4.Cabaretier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CabaretierRepository extends JpaRepository<Cabaretier, Integer> {

    // custom query to search to blog post by title or content
	//    List<Product> findByTitleContainingOrContentContaining(String text, String textAgain);
	
	@Query(value = "SELECT cabaretier_voornaam, cabaretier_achternaam, geboortedatum, geslacht FROM Cabaretiers WHERE cabaretier_id =?1", nativeQuery = true)
	String allCabaretiers(Integer cabaretier_id);

}