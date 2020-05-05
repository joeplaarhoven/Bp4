package com.example.bp4.Theaterzaal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TheaterzaalRepository extends JpaRepository<Theaterzaal, Integer> {
	
    // custom query to search to blog post by title or content
	//  List<Product> findByTitleContainingOrContentContaining(String text, String textAgain);
	
	@Query(value = "SELECT zaalnaam, zitplaatsen FROM Theaterzalen WHERE tz_theater_id =?1", nativeQuery = true)
	String alltheaterzalen(Integer theaterID); 

}
