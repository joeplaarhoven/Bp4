package com.example.bp4.Theatervoortstelling;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatervoorstellingRepository extends JpaRepository<Theatervoorstelling, Integer> {
	
	// custom query to search to blog post by title or content
	//    List<Product> findByTitleContainingOrContentContaining(String text, String textAgain);
	
	@Query(value = "SELECT *\r\n" + 
			" FROM Theatervoorstellingen\r\n" + 
			" LEFT JOIN Voorstellingen\r\n" + 
			" ON Theatervoorstellingen.theatervoorstelling_id = Voorstellingen.theatervoorstelling_id\r\n" + 
			" WHERE Theatervoorstellingen.theatervoorstelling_id = ?1", nativeQuery = true)
	Theatervoorstelling findOneTheatervoorstelling(Integer theatervoorstelling_id);

}
