package com.example.market.Domain.repository;

import com.example.market.Domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurcharseRepository {
    List<Purchase> getAll();
    Optional <List<Purchase>> getByClient(String clientId);
    Purchase save(Purchase purchase);
}
