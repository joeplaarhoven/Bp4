package com.example.bp4.Theater;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class TheaterService {
    @Autowired
    TheaterRepository theaterRepository;

    public List<Theater> listAll() {
        return theaterRepository.findAll();
    }

    public void save(Theater theater) {
        theaterRepository.save(theater);
    }

    public Theater get(long theaterId) {
        return theaterRepository.findById((int) theaterId).get();
    }


    public void delete(long theaterId) {
        theaterRepository.deleteById((int) theaterId);
    }
    
    public String alltheater(String theaternaam) {
    	return theaterRepository.alltheater(theaternaam);
    }
}
