package com.example.bp4.Cabaretier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CabaretierRepository extends JpaRepository<Cabaretier, Integer> {
	
    // custom query to search to blog post by title or content
	//    List<Product> findByTitleContainingOrContentContaining(String text, String textAgain);
	
	@Query(value = "SELECT *\r\n" + 
			" FROM Cabaretiers\r\n" + 
			" LEFT JOIN Voorstellingen\r\n" + 
			" ON Cabaretiers.cabaretier_id = Voorstellingen.cabaretier_id\r\n" + 
			" WHERE Cabaretiers.cabaretier_id = ?1", nativeQuery = true)
	Cabaretier findOneCabaretier(Integer cabaretier_id);	
	
}