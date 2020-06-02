package com.example.bp4.Theatervoortstelling;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
	
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE Theatervoorstellingen SET theatervoorstelling_naam =?1, acteurs =?2, productie_afkomst =?3, voorstelling_id = 0 WHERE theatervoorstelling_id =?4", nativeQuery = true)
	int theatervoorstellingBijwerken(String t_theatervoorstelling_naam, String t_acteurs, String t_productie_afkomst, Integer t_theatervoorstelling_id);

}
