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

    public List<Concert> listAll() {
        return concertRepository.findAll();
    }

    public void save(Concert concert) {
        concertRepository.save(concert);
    }

    public Concert get(long concertId) {
        Concert c1 = concertRepository.findById((int) concertId).get();
        return c1;
    }

    public void delete(long concertId) {
        concertRepository.deleteById((int) concertId);
    }

    public Concert getOneConcert(Integer concert_id) {
        return concertRepository.findOneConcert(concert_id);
    }
    
}