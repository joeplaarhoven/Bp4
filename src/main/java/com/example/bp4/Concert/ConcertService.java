package com.example.bp4.Concert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ConcertService {
	
    @Autowired
    ConcertRepository concertRepository;
    
    //Standaard functie; genereert een lijst van alle concerten
    public List<Concert> listAll() {
        return concertRepository.findAll();
    }

    //Standaard functie; het opslaan van een concert
    public void save(Concert concert) {
        concertRepository.save(concert);
    }

    //Standaard functie; het ophalen van één concert
    public Concert get(long concert_id) {
        Concert concert = concertRepository.findById((int) concert_id).get();
        return concert;
    }

    //Standaard functie; het verwijderen van één concert
    public void delete(long concert_id) {
        concertRepository.deleteById((int) concert_id);
    }

    //Zelf gemaakte functie; het ophalen van één concert
    public Concert getOneConcert(Integer concert_id) {
        return concertRepository.findOneConcert(concert_id);
    }
    
    //Zelf gemaakte functie; het bijwerken van één concert
    public int concertBijwerken(String c_concert_naam, String c_genre, String c_artiest, Integer c_concert_id) {
    	return concertRepository.concertBijwerken(c_concert_naam, c_genre, c_artiest, c_concert_id);
    }
    
}