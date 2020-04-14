package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {
    @Autowired
    ProductRepo repo;

    public List<Products> listAll() {
        return repo.findAll();
    }

    public void save(Products products) {
        repo.save(products);
    }

    public Products get(long productId) {
        return repo.findById((int) productId).get();
    }


    public void delete(long productId) {
        repo.deleteById((int) productId);
    }
}
