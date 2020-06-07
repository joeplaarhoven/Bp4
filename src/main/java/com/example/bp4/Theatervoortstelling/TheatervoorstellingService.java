package com.example.bp4.Theatervoortstelling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class TheatervoorstellingService {
	
    @Autowired
    TheatervoorstellingRepository theatervoorstellingRepository;
    
    //Standaard functie; genereert een lijst van alle theatervoorstellingen
    public List<Theatervoorstelling> listAll() {
        return theatervoorstellingRepository.findAll();
    }

    //Standaard functie; het opslaan van een theatervoorstelling
    public void save(Theatervoorstelling theatervoorstelling) {
    	theatervoorstellingRepository.save(theatervoorstelling);
    }

    //Standaard functie; het ophalen van één theatervoorstelling
    public Theatervoorstelling get(long theatervoorstelling_id) {
    	Theatervoorstelling theatervoorstelling = theatervoorstellingRepository.findById((int) theatervoorstelling_id).get();
        return theatervoorstelling;
    }

    //Standaard functie; het verwijderen van één theatervoorstelling
    public void delete(long theatervoorstelling_id) {
    	theatervoorstellingRepository.deleteById((int) theatervoorstelling_id);
    }
    
    //Zelf gemaakte functie; het ophalen van één theatervoorstelling
    public Theatervoorstelling getOneTheatervoorstelling(Integer theatervoorstelling_id) {
        return theatervoorstellingRepository.findOneTheatervoorstelling(theatervoorstelling_id);
    }
    
    //Zelf gemaakte functie; het bijwerken van één theatervoorstelling
    public int theatervoorstellingBijwerken(String t_theatervoorstelling_naam, String t_acteurs, String t_productie_afkomst, Integer t_theatervoorstelling_id) {
    	return theatervoorstellingRepository.theatervoorstellingBijwerken(t_theatervoorstelling_naam, t_acteurs, t_productie_afkomst, t_theatervoorstelling_id);
    }
	
}