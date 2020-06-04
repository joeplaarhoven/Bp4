package com.example.bp4.KaartVerkoop;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.bp4.Cabaretier.Cabaretier;
import com.example.bp4.Concert.Concert;
import com.example.bp4.Theatervoortstelling.Theatervoorstelling;

@Repository
public interface KaartVerkoopRepository extends JpaRepository<KaartVerkoop, Integer> {

    // custom query to search to blog post by title or content
//    List<Product> findByTitleContainingOrContentContaining(String text, String textAgain);

	
	@Query(value = "SELECT zitplaatsen\r\n" + 
			"From theaterzalen\r\n" + 
			"WHERE theaterzaal_id = (SELECT v_theaterzaal_id \r\n" + 
			"FROM voorstellingen\r\n" + 
			"WHERE voorstelling_id = ?1) ", nativeQuery = true)
	Integer getZitplek(Integer voorstellingId);

	@Modifying
	@Query(value = "\r\n" + 
			"DELETE \r\n" + 
			"FROM kaartenverkopen\r\n" + 
			"WHERE kv_gebruikers_id = ?1 and kv_voorstelling_id = ?2", nativeQuery = true)
	void deleteByIdAndId(Integer gebruikerId, Integer voorstellingId);

	@Query(value = "SELECT COUNT(kv_gebruikers_id)\r\n" + 
			"From kaartenverkopen\r\n" + 
			"WHERE kv_voorstelling_id = ?1", nativeQuery = true)
	Integer getVerkochtenKaarten(Integer voorstellingID);   
	
}
