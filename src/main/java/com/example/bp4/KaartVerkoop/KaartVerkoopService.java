package com.example.bp4.KaartVerkoop;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class KaartVerkoopService {
    @Autowired
    KaartVerkoopRepository kaartVerkoopRepository;

    public List<KaartVerkoop> listAll() {
        return kaartVerkoopRepository.findAll();
    }

    public void save(KaartVerkoop kaartVerkoop) {
        kaartVerkoopRepository.save(kaartVerkoop);
    }

    public KaartVerkoop get(long gebruikerId, long voorstellingId) {
        return kaartVerkoopRepository.findById((int) gebruikerId).get();
    }


    public void delete(long gebruikerId) {
        kaartVerkoopRepository.deleteById((int) gebruikerId);
    }
}
