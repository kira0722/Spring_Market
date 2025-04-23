package com.example.market.persistence;

import com.example.market.Domain.Purchase;
import com.example.market.Domain.repository.PurcharseRepository;
import com.example.market.persistence.crud.CompraCrudRepository;
import com.example.market.persistence.entity.Compra;
import com.example.market.persistence.mapper.PurcharseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurcharseRepository {

    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurcharseMapper mapper;


    @Override
    public List<Purchase> getAll() {
        return mapper.toPurcharses((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> mapper.toPurcharses(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));

        return mapper.toPurcharse(compraCrudRepository.save(compra));
    }
}
