package com.example.market.Domain.service;

import com.example.market.Domain.Purchase;
import com.example.market.Domain.repository.PurcharseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurcharseService {

    @Autowired
    private PurcharseRepository purcharseRepository;

    public List<Purchase> getAll(){
        return purcharseRepository.getAll();
    }

    public Optional<List<Purchase>> getByClient(String clientId){
        return purcharseRepository.getByClient(clientId);
    }

    public Purchase save(Purchase purchase){
        return purcharseRepository.save(purchase);
    }
}
