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

    public Cabaretier get(long cabaretierId) {
        return cabaretierRepository.findById((int) cabaretierId).get();
    }

    public void delete(long cabaretierId) {
    	cabaretierRepository.deleteById((int) cabaretierId);
    }
    
    public String allCabaretiers() {
    	return cabaretierRepository.allCabaretiers();
    }
    
}
