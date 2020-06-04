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

    public boolean save(KaartVerkoop kaartVerkoop) {
    	Integer aantalZitplek = kaartVerkoopRepository.getZitplek(kaartVerkoop.getVoorstellingID());
    	Integer verkochtenKaarten = kaartVerkoopRepository.getVerkochtenKaarten(kaartVerkoop.getVoorstellingID());
    	System.out.println(aantalZitplek + " " +  verkochtenKaarten);
    	if (aantalZitplek > verkochtenKaarten) {
    		kaartVerkoopRepository.save(kaartVerkoop);
    		return true;
    	}
    	else {
    		return false;
    	}
		
        
    }

    public KaartVerkoop get(long gebruikerId, long voorstellingId) {
        return kaartVerkoopRepository.findById((int) gebruikerId).get();
    }


    public void delete(Integer gebruikerId, Integer voorstellingId) {
        kaartVerkoopRepository.deleteByIdAndId(gebruikerId, voorstellingId);
    }
    
}
