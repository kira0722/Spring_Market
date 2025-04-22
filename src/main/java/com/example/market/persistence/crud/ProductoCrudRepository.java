package com.example.market.persistence.crud;


import com.example.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;


public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
}
