package com.example.bp4.Cabaretier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class CabaretierService {

    @Autowired
    CabaretierRepository cabaretierRepository;

    public List<Cabaretier> listAll() {
        return cabaretierRepository.findAll();
    }

    public void save(Cabaretier cabaretier) {
    	cabaretierRepository.save(cabaretier);
    }

    public Cabaretier get(long cabaretier_id) {
    	Cabaretier cabaretier = cabaretierRepository.findById((int) cabaretier_id).get();
        return cabaretier;
    }

    public void delete(long cabaretierId) {
    	cabaretierRepository.deleteById((int) cabaretierId);
    }
    
    public Cabaretier getOneCabaretier(Integer cabaretier_id) {
        return cabaretierRepository.findOneCabaretier(cabaretier_id);
    }
    
    public int cabaretierBijwerken(String c_cabaretier_voornaam, String c_cabaretier_achternaam, String c_geboortedatum, String c_geslacht, Integer c_cabaretier_id) {
    	return cabaretierRepository.cabaretierBijwerken(c_cabaretier_voornaam, c_cabaretier_achternaam, c_geboortedatum, c_geslacht, c_cabaretier_id);
    }
    
}
