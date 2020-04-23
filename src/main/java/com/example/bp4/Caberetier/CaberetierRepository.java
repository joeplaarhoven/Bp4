package com.example.bp4.Caberetier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaberetierRepository extends JpaRepository<Caberetier, Integer> {

    // custom query to search to blog post by title or content
//    List<Product> findByTitleContainingOrContentContaining(String text, String textAgain);

}