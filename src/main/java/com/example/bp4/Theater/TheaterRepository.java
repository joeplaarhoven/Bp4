package com.example.bp4.Theater;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Integer> {

    // custom query to search to blog post by title or content
//    List<Product> findByTitleContainingOrContentContaining(String text, String textAgain);
	
	@Query(value = "SELECT theaternaam, vestiging FROM Theater WHERE theaternaam =?1 AND vestiging =?2", nativeQuery = true)
	String alltheater(String theaternaam, String vestiging);  

}
