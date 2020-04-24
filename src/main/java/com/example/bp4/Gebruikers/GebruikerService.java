package com.example.bp4.Gebruikers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    
    public String checkGebruikerLogin(String gebruikersnaam, String wachtwoord) {
    	return gebruikerRepository.checkGebruikerLogin(gebruikersnaam, wachtwoord);
    }
}
