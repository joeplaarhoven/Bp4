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

    public List<Eigenaar> listAll() {
        return eigenaarRepository.findAll();
    }

    public void save(Eigenaar eigenaar) {
        eigenaarRepository.save(eigenaar);
    }

    public Eigenaar get(long eigenaarId) {
        return eigenaarRepository.findById((int) eigenaarId).get();
    }

    public void delete(long eigenaarId) {
        eigenaarRepository.deleteById((int) eigenaarId);
    }

    public Integer setVerifiedForEigenaar(boolean verified, Integer eigenaar_id){
       return eigenaarRepository.setVerifiedForEigenaar(verified, eigenaar_id);
    }
    
    public String checkEigenaarLogin(String emailadres, String wachtwoord) {
    	return eigenaarRepository.checkEigenaarLogin(emailadres, wachtwoord);
    }
    
    public Integer getEigenaarId(String emailadres) {
		return eigenaarRepository.getEigenaarId(emailadres);
	}
    
}
