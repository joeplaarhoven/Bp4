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

    public List<Theatervoorstelling> listAll() {
        return theatervoorstellingRepository.findAll();
    }

    public void save(Theatervoorstelling theatervoorstelling) {
    	theatervoorstellingRepository.save(theatervoorstelling);
    }

    public Theatervoorstelling get(long theatervoorstelling_id) {
    	Theatervoorstelling theatervoorstelling = theatervoorstellingRepository.findById((int) theatervoorstelling_id).get();
        return theatervoorstelling;
    }

    public void delete(long theatervoorstelling_id) {
    	theatervoorstellingRepository.deleteById((int) theatervoorstelling_id);
    }
    
    public Theatervoorstelling getOneTheatervoorstelling(Integer theatervoorstelling_id) {
        return theatervoorstellingRepository.findOneTheatervoorstelling(theatervoorstelling_id);
    }
    
    public int theatervoorstellingBijwerken(String t_theatervoorstelling_naam, String t_acteurs, String t_productie_afkomst, Integer t_theatervoorstelling_id) {
    	return theatervoorstellingRepository.theatervoorstellingBijwerken(t_theatervoorstelling_naam, t_acteurs, t_productie_afkomst, t_theatervoorstelling_id);
    }
	
}