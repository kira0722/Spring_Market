package com.example.market.persistence;

import com.example.market.persistence.crud.ProductoCrudRepository;
import com.example.market.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getall(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad, boolean estado){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }
}
