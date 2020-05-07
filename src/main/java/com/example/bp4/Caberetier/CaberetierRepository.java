package com.example.bp4.Caberetier;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CaberetierRepository extends JpaRepository<Caberetier, Integer> {

	@Query(value = "SELECT *\r\n" + 
			" FROM Caberetiers\r\n" + 
			" LEFT JOIN Voorstellingen\r\n" + 
			" ON Caberetiers.caberetier_id = Voorstellingen.caberatier_id\r\n" + 
			" WHERE Caberetiers.caberetier_id = ?1", nativeQuery = true)
	Caberetier findOneCaberetier(Integer caberetier_id);


	
	
    // custom query to search to blog post by title or content
//    List<Product> findByTitleContainingOrContentContaining(String text, String textAgain);

}