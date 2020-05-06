package com.example.bp4.Voorstelling;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class VoorstellingService {
    @Autowired
    VoorstellingRepository voorstellingRepository;

    public List<Voorstelling> listAll() {
        return voorstellingRepository.findAll();
    }

    public void save(Voorstelling voorstelling) {
        voorstellingRepository.save(voorstelling);
    }

    public Voorstelling get(long voorstellingId) {
        return voorstellingRepository.findById((int) voorstellingId).get();
    }


    public void delete(long theaterId) {
        voorstellingRepository.deleteById((int) theaterId);
    }
}
