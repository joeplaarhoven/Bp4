package com.example.bp4.Concert;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ConcertRepository extends JpaRepository<Concert, Integer> {

	@Query(value = "SELECT *\r\n" + 
			" FROM Concerten\r\n" + 
			" LEFT JOIN Voorstellingen\r\n" + 
			" ON Concerten.concert_id = Voorstellingen.concert_id\r\n" + 
			" WHERE Concerten.concert_id = ?1", nativeQuery = true)
	Concert findOneConcert(Integer concert_id);

}