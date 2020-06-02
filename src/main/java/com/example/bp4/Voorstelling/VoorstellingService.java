package com.example.bp4.Voorstelling;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bp4.Cabaretier.Cabaretier;
import com.example.bp4.Concert.Concert;
import com.example.bp4.Theatervoortstelling.Theatervoorstelling;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VoorstellingService {
    @Autowired
    VoorstellingRepository voorstellingRepository;

    public List<Voorstelling> listAll() {
        return voorstellingRepository.findAll();
    }

    public void save(Voorstelling voorstelling) {
        voorstellingRepository.save(voorstelling);
    }

    public Voorstelling get(long voorstellingId) {
        return voorstellingRepository.findById((int) voorstellingId).get();
    }


    public void delete(long theaterId) {
        voorstellingRepository.deleteById((int) theaterId);
    }
    
    public List<Cabaretier> getCabaretierVoorstellingen(String gebruiker) {
        return voorstellingRepository.getCabaretierVoorstellingen(gebruiker);
    }
    public List<Concert> getConcertVoorstellingen(String gebruiker) {
        return voorstellingRepository.getConcertVoorstellingen(gebruiker);
    }
    public List<Theatervoorstelling> getTheaterVoorstellingen(String gebruiker) {
        return voorstellingRepository.getTheaterVoorstellingen(gebruiker);
    }
    
    public void saveCabaretierVoorstelling(Voorstelling cabaretier) {
    	voorstellingRepository.saveCabaretierVoorstelling(cabaretier);
	}   
    
}
