package com.example.bp4.Caberetier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CaberetierRepository extends JpaRepository<Caberetier, Integer> {

	
//	@Query(value = "select * from Caberetiers where caberetier_id = ?1")
//	Caberetier findOneCaberetier(Integer caberetierId);
	@Query(value = "SELECT *\r\n" + 
			" FROM Caberetiers\r\n" + 
			" LEFT JOIN Voorstellingen\r\n" + 
			" ON Caberetiers.caberetier_id = Voorstellingen.caberatier_id\r\n" + 
			" WHERE caberetier_id = ?1", nativeQuery = true)
	Caberetier findOneCaberetier(Integer caberetierId);

	
	
	//select s from Caberetiers where caberetier_id = ?1 and s.type = :type", nativeQuery = true
	
	
    // custom query to search to blog post by title or content
//    List<Product> findByTitleContainingOrContentContaining(String text, String textAgain);

}