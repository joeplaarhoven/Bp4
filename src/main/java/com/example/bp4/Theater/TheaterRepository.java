package com.example.bp4.Theater;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Integer> {

    // custom query to search to blog post by title or content
//    List<Product> findByTitleContainingOrContentContaining(String text, String textAgain);

	@Query(value = "SELECT theaternaam FROM Theaters WHERE theaternaam =?1", nativeQuery = true)
	String alltheater(String theaternaam);

	@Query(value = "SELECT theaterID FROM Theaters WHERE theaterID =?1", nativeQuery = true)
	String IDopzoek(long theaterID);

	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE Theaters SET theaternaam =?1, straatnaam =?2, huisnummer =?3, postcode =?4, plaats =?5 WHERE theater_id =?6", nativeQuery = true)
	int updateTheater(String t_theaternaam, String t_straatnaam, Integer t_huisnummer, String t_postcode, String t_plaats, Integer t_theater_id);
}
