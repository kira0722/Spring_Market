package com.example.market.persistence;

import com.example.market.persistence.crud.ProductoCrudRepository;
import com.example.market.persistence.entity.Producto;

import java.util.List;

public class ProductRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getall(){
        return (List<Producto>) productoCrudRepository.findAll();
    }
}
