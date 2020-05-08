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

    public Theatervoorstelling get(long theatervoorstellingId) {
    	Theatervoorstelling t1 = theatervoorstellingRepository.findById((int) theatervoorstellingId).get();
        return t1;
    }

    public void delete(long theatervoorstellingId) {
    	theatervoorstellingRepository.deleteById((int) theatervoorstellingId);
    }
    
    public Theatervoorstelling getOneTheatervoorstelling(Integer theatervoorstelling_id) {
        return theatervoorstellingRepository.findOneTheatervoorstelling(theatervoorstelling_id);
    }
	
}