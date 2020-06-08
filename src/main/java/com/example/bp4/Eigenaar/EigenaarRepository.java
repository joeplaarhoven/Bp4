package com.example.bp4.Eigenaar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EigenaarRepository extends JpaRepository<Eigenaar, Integer> {

    // custom query to search to blog post by title or content
//    List<Product> findByTitleContainingOrContentContaining(String text, String textAgain);
    @Modifying
    @Query(value = "update Eigenaren verified set verified = ?1 where eigenaar_id = ?2", nativeQuery = true)
    int setVerifiedForEigenaar(Boolean verified, Integer eigenaar_id);
    
	@Query(value = "SELECT emailadres, wachtwoord FROM Eigenaren WHERE emailadres =?1 AND wachtwoord =?2 AND verified = true", nativeQuery = true)
	String checkEigenaarLogin(String emailadres, String wachtwoord); 
	
	@Query(value = "SELECT eigenaar_id FROM Eigenaren WHERE emailadres =?1", nativeQuery = true)
	Integer getEigenaarId(String emailadres);

}