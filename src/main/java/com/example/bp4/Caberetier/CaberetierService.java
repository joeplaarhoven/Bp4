package com.example.bp4.Caberetier;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CaberetierService {

    @Autowired
    CaberetierRepository caberetierRepository;

    public List<Caberetier> listAll() {
        return caberetierRepository.findAll();
    }

    public void save(Caberetier caberetier) {
        caberetierRepository.save(caberetier);
    }

    public Caberetier get(long caberetierId) {
    	Caberetier c1 = caberetierRepository.findById((int) caberetierId).get();
        return c1;
    }

    public void delete(long caberetierId) {
        caberetierRepository.deleteById((int) caberetierId);
    }
    
    public Caberetier getOneCaberetier(Integer caberetierId) {
    	Caberetier c1 = caberetierRepository.findOneCaberetier(caberetierId);
        return c1;
    }
    
}
