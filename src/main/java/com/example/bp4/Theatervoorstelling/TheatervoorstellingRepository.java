package com.example.bp4.Theatervoorstelling;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatervoorstellingRepository extends JpaRepository<Theatervoorstelling, Integer> {

    // custom query to search to blog post by title or content
	//    List<Product> findByTitleContainingOrContentContaining(String text, String textAgain);
	
	@Query(value = "SELECT theatervoorstelling_naam, acteurs, productieafkomst FROM Theatervoorstellingen", nativeQuery = true)
	String allTheatervoorstellingen();
	
}
