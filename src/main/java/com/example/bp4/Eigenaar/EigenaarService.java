package com.example.bp4.Eigenaar;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EigenaarService {
    @Autowired
    EigenaarRepository eigenaarRepository;

    public List<Eigenaren> listAll() {
        return eigenaarRepository.findAll();
    }

    public void save(Eigenaren eigenaren) {
        eigenaarRepository.save(eigenaren);
    }

    public Eigenaren get(long eigenaarId) {
        return eigenaarRepository.findById((int) eigenaarId).get();
    }

    public void delete(long eigenaarId) {
        eigenaarRepository.deleteById((int) eigenaarId);
    }

    public Integer setVerifiedForEigenaar(boolean verified, Integer eigenaar_id){
       return eigenaarRepository.setVerifiedForEigenaar(verified, eigenaar_id);
    }
}
