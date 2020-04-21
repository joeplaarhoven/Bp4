package com.example.bp4.KaartVerkoop;

import com.example.bp4.Gebruiker.Gebruiker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KaartVerkoopRepository extends JpaRepository<KaartVerkoop, Integer> {

    // custom query to search to blog post by title or content
//    List<Product> findByTitleContainingOrContentContaining(String text, String textAgain);

}
