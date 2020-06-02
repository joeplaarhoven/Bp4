package com.example.bp4.KaartVerkoop;


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
public class KaartVerkoopService {
    @Autowired
    KaartVerkoopRepository kaartVerkoopRepository;

    public List<KaartVerkoop> listAll() {
        return kaartVerkoopRepository.findAll();
    }

    public void save(KaartVerkoop kaartVerkoop) {
        kaartVerkoopRepository.save(kaartVerkoop);
    }

    public KaartVerkoop get(long gebruikerId, long voorstellingId) {
        return kaartVerkoopRepository.findById((int) gebruikerId).get();
    }


    public void delete(long gebruikerId) {
        kaartVerkoopRepository.deleteById((int) gebruikerId);
    }
    
    public List<Cabaretier> getCabaretierVoorstellingen(Integer gebruiker) {
        return kaartVerkoopRepository.getCabaretierVoorstellingen(gebruiker);
    }
    public List<Concert> getConcertVoorstellingen(String gebruiker) {
        return kaartVerkoopRepository.getConcertVoorstellingen(gebruiker);
    }
    public List<Theatervoorstelling> getTheaterVoorstellingen(String gebruiker) {
        return kaartVerkoopRepository.getTheaterVoorstellingen(gebruiker);
    }
}
