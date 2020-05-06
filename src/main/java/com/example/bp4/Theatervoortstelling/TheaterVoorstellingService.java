package com.example.bp4.Theatervoortstelling;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bp4.Theatervoortstelling.Theatervoorstelling;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TheaterVoorstellingService {
    @Autowired
    TheaterVoorstellingRepository theaterVoorstellingRepository;

    public List<Theatervoorstelling> listAll() {
        return theaterVoorstellingRepository.findAll();
    }

    public void save(Theatervoorstelling theaterVoorstelling) {
        theaterVoorstellingRepository.save(theaterVoorstelling);
    }

    public Theatervoorstelling get(long theaterVoorstellingId) {
        return theaterVoorstellingRepository.findById((int) theaterVoorstellingId).get();
    }


    public void delete(long theaterId) {
        theaterVoorstellingRepository.deleteById((int) theaterId);
    }
}
