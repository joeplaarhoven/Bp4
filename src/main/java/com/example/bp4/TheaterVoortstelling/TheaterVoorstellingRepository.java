package com.example.bp4.TheaterVoortstelling;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheaterVoorstellingRepository extends JpaRepository<TheaterVoorstelling, Integer> {

	@Query(value = "SELECT *\r\n" + 
			" FROM Theatervoorstellingen\r\n" + 
			" LEFT JOIN Voorstellingen\r\n" + 
			" ON Theatervoorstellingen.theatervoorstelling_id = Voorstellingen.theatervoorstelling_id\r\n" + 
			" WHERE Theatervoorstellingen.theatervoorstelling_id = ?1", nativeQuery = true)
	TheaterVoorstelling findOneTheaterVoorstelling(Integer theaterVoorstelling_id);

    // custom query to search to blog post by title or content
//    List<Product> findByTitleContainingOrContentContaining(String text, String textAgain);

}
