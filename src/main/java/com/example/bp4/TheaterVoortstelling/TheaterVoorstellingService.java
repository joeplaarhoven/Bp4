package com.example.bp4.TheaterVoortstelling;


import com.example.bp4.Concert.Concert;
import com.example.bp4.TheaterVoortstelling.TheaterVoorstelling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TheaterVoorstellingService {
    @Autowired
    TheaterVoorstellingRepository theaterVoorstellingRepository;

    public List<TheaterVoorstelling> listAll() {
        return theaterVoorstellingRepository.findAll();
    }

    public void save(TheaterVoorstelling theaterVoorstelling) {
        theaterVoorstellingRepository.save(theaterVoorstelling);
    }

    public TheaterVoorstelling get(long theaterVoorstellingId) {
        return theaterVoorstellingRepository.findById((int) theaterVoorstellingId).get();
    }


    public void delete(long theaterId) {
        theaterVoorstellingRepository.deleteById((int) theaterId);
    }
    
    public TheaterVoorstelling getOneTheaterVoorstelling(Integer theaterVoorstelling_id) {
        return theaterVoorstellingRepository.findOneTheaterVoorstelling(theaterVoorstelling_id);
    }

	
}
