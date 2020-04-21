package com.example.bp4.Eigenaar;


import com.example.bp4.TheaterVoortstelling.TheaterVoorstellingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EigenaarService {
    @Autowired
    EigenaarRepository eigenaarRepository;

    public List<Eigenaar> listAll() {
        return eigenaarRepository.findAll();
    }

    public void save(Eigenaar eigenaar) {
        eigenaarRepository.save(eigenaar);
    }

    public Eigenaar get(long eigenaarId, long theaterId) {
        return eigenaarRepository.findById((int) eigenaarId).get();
    }

    public void delete(long eigenaarId, long theaterId) {
        eigenaarRepository.deleteById((int) eigenaarId);
    }
}
