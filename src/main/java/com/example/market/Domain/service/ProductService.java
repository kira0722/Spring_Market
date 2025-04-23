package com.example.market.Domain.service;

import com.example.market.Domain.Product;
import com.example.market.Domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.geByCategory(categoryId);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public boolean delete(int prodcutId){

        //opcion 1
        return getProduct(prodcutId).map(product -> {
            productRepository.delete(prodcutId);
            return true;
        }).orElse(false);

        //opcion 2
//        if (getProduct(prodcutId).isPresent()){
//            productRepository.delete(prodcutId);
//            return true;
//        }else {
//            return false;
//        }
    }

    public Optional<List<Product>> getScarseProducts (int quantity){
        return productRepository.getScarseProducts(quantity);
    }
}
