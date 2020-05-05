package com.example.bp4.Theaterzaal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class TheaterzaalService {
	
	@Autowired
    TheaterzaalRepository theaterzaalRepository;

    public List<Theaterzaal> listAll() {
        return theaterzaalRepository.findAll();
    }

    public void save(Theaterzaal theaterzaal) {
    	theaterzaalRepository.save(theaterzaal);
    }

    public Theaterzaal get(long theaterzaalId) {
        return theaterzaalRepository.findById((int) theaterzaalId).get();
    }


    public void delete(long theaterzaalId) {
    	theaterzaalRepository.deleteById((int) theaterzaalId);
    }
    
    public String alltheaterzalen(Integer theaterID) {
    	return theaterzaalRepository.alltheaterzalen(theaterID);
    }

}
