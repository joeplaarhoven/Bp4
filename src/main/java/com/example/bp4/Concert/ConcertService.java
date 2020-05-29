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

    public Concert get(long concert_id) {
        Concert concert = concertRepository.findById((int) concert_id).get();
        return concert;
    }

    public void delete(long concert_id) {
        concertRepository.deleteById((int) concert_id);
    }

    public Concert getOneConcert(Integer concert_id) {
        return concertRepository.findOneConcert(concert_id);
    }
    
}