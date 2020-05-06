package com.example.bp4.Theatervoorstelling;


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
        return theatervoorstellingRepository.findById((int) theatervoorstellingId).get();
    }


    public void delete(long theatervoorstellingId) {
    	theatervoorstellingRepository.deleteById((int) theatervoorstellingId);
    }
    
    public String allTheatervoorstellingen() {
    	return theatervoorstellingRepository.allTheatervoorstellingen();
    }
    
}
