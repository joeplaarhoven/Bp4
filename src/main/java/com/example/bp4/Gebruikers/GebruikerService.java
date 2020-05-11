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
    
    public int updateGebruiker(String g_gebruiker_voornaam, String g_gebruiker_achternaam, String g_geboortedatum, String g_leeftijdscategorie, String g_afkomst, String g_gebruikersnaam, String g_wachtwoord, Integer g_gebruiker_id) {
    	return gebruikerRepository.updateGebruiker(g_gebruiker_voornaam, g_gebruiker_achternaam, g_geboortedatum, g_leeftijdscategorie, g_afkomst, g_gebruikersnaam, g_wachtwoord, g_gebruiker_id);
    }
    
}
