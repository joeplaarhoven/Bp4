package com.example.bp4.Theaterzaal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TheaterzaalRepository extends JpaRepository<Theaterzaal, Integer> {
	
    // custom query to search to blog post by title or content
	//  List<Product> findByTitleContainingOrContentContaining(String text, String textAgain);
	
	@Query(value = "SELECT theaterzaal_id, tz_theater_id, zaalnaam, zitplaatsen\r\n" + 
			"FROM theaterzalen\r\n" + 
			"left JOIN theaters\r\n" + 
			"ON theaters.theater_id = theaterzalen.tz_theater_id\r\n" + 
			"where theaternaam =?1", nativeQuery = true)
	List<Theaterzaal> alltheaterzalen(String theaternaam); 

}
