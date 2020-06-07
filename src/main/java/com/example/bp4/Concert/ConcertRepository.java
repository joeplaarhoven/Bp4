package com.example.bp4.Concert;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.bp4.Cabaretier.Cabaretier;

@Repository
public interface ConcertRepository extends JpaRepository<Concert, Integer> {
	
	// custom query to search to blog post by title or content
	//    List<Product> findByTitleContainingOrContentContaining(String text, String textAgain);

	//Query om de concert met de voorstellingen te kunnen toevoegen
	@Query(value = "SELECT *\r\n" + 
			" FROM Concerten\r\n" + 
			" LEFT JOIN Voorstellingen\r\n" + 
			" ON Concerten.concert_id = Voorstellingen.concert_id\r\n" + 
			" WHERE Concerten.concert_id = ?1", nativeQuery = true)
	Concert findOneConcert(Integer concert_id);
	
	//Query om het concert te updaten
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE Concerten SET concert_naam =?1, genre =?2, artiest =?3, voorstelling_id = 0 WHERE concert_id =?4", nativeQuery = true)
	int concertBijwerken(String c_concert_naam, String c_genre, String c_artiest, Integer c_concert_id);

}