package com.example.bp4.EigenaarTheater;


import com.example.bp4.TheaterVoortstelling.TheaterVoorstellingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EigenaarTheaterService {
    @Autowired
    EigenaarTheaterRepository eigenaarTheaterRepository;

    public List<EigenaarTheater> listAll() {
        return eigenaarTheaterRepository.findAll();
    }

    public void save(EigenaarTheater eigenaarTheater) {
        eigenaarTheaterRepository.save(eigenaarTheater);
    }

    public EigenaarTheater get(long eigenaarId, long theaterId) {
        return eigenaarTheaterRepository.findById((int) eigenaarId).get();
    }

    public void delete(long eigenaarId, long theaterId) {
        eigenaarTheaterRepository.deleteById((int) eigenaarId);
    }
}
