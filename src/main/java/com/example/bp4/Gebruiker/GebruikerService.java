package com.example.bp4.Gebruiker;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GebruikerService {
    @Autowired
    GebruikerRepository gebruikerRepository;

    public List<Gebruiker> listAll() {
        return gebruikerRepository.findAll();
    }

    public void save(Gebruiker gebruiker) {
        gebruikerRepository.save(gebruiker);
    }

    public Gebruiker get(long gebruikerId) {
        return gebruikerRepository.findById((int) gebruikerId).get();
    }


    public void delete(long gebruikerId) {
        gebruikerRepository.deleteById((int) gebruikerId);
    }
}
