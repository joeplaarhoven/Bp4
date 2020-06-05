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

    //service wordt gebruikt voor berekeningen etc.
    
    
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
    
    public List<Cabaretier> getCabaretierVoorstellingen() {
        return voorstellingRepository.getCabaretierVoorstellingen();
    }
    public List<Concert> getConcertVoorstellingen() {
        return voorstellingRepository.getConcertVoorstellingen();
    }
    public List<Theatervoorstelling> getTheaterVoorstellingen() {
        return voorstellingRepository.getTheaterVoorstellingen();
    }
    
    public List<Cabaretier> getCabaretierVoorstellingenWithPrefrence(String gebruiker) {
        return voorstellingRepository.getCabaretierVoorstellingenWithPrefrence(gebruiker);
    }
    
    public List<Concert> getConcertVoorstellingenWithPrefrence(String gebruiker) {
        return voorstellingRepository.getConcertVoorstellingenWithPrefrence(gebruiker);
    }
    
    public List<Theatervoorstelling> getTheaterVoorstellingenWithPrefrence(String gebruiker) {
        return voorstellingRepository.getTheaterVoorstellingenWithPrefrence(gebruiker);
    }
    
    public void saveCabaretierVoorstelling(Voorstelling cabaretier) {
    	voorstellingRepository.saveCabaretierVoorstelling(cabaretier.v_theaterzaal_id, cabaretier.cabaretier_id, cabaretier.voorstellingsoort, cabaretier.datum, cabaretier.tijd, cabaretier.v_leeftijdscategorie, cabaretier.afkomst);
	}  
    
    public void saveConcertVoorstelling(Voorstelling concert) {
    	voorstellingRepository.saveConcertVoorstelling(concert.v_theaterzaal_id, concert.concert_id, concert.voorstellingsoort, concert.datum, concert.tijd, concert.v_leeftijdscategorie, concert.afkomst);
	}  
    
    public void saveTheaterVoorstelling(Voorstelling cabaretier) {
    	voorstellingRepository.saveTheaterVoorstelling(cabaretier.v_theaterzaal_id, cabaretier.cabaretier_id, cabaretier.voorstellingsoort, cabaretier.datum, cabaretier.tijd, cabaretier.v_leeftijdscategorie, cabaretier.afkomst);
	}  
    
    public List<Cabaretier> getCabaretierKaart(Integer gebruiker) {
        return voorstellingRepository.getCabaretierKaart(gebruiker);
    }
    
    public List<Concert> getConcertKaart(Integer gebruiker) {
        return voorstellingRepository.getConcertKaart(gebruiker);
    }
    
    public List<Theatervoorstelling> getTheatervoorstellingenKaart(Integer gebruiker) {
        return voorstellingRepository.getTheatervoorstellingKaart(gebruiker);
    }
}
