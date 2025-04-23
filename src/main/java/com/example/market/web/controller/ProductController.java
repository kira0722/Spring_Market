package com.example.market.web.controller;

import com.example.market.Domain.Product;
import com.example.market.Domain.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@Tag(name = "Products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    @Operation(summary = "Get all the data of Products")
    @ApiResponse(responseCode = "202", description = "okidokitokitoki")
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }
    //version 1
    //    public List<Product> getAll(){
    //        return productService.getAll();
    //    }



    @GetMapping("/{id}")
    @Operation(summary = "get a data information by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "ok"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND")
    })
    public ResponseEntity<Product> getProduct(@Parameter(description = "the id of the product",allowEmptyValue = false, required = true, example = "7") @PathVariable("id") int productId){
        return productService.getProduct(productId).map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    //version 1
    //    public Optional<Product> getProduct(@PathVariable("id") int productId){
    //        return productService.getProduct(productId);



    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId)
                .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    //version 1
    //    public Optional<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId){
    //        return productService.getByCategory(categoryId);
    //    }



    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }
    //version 1
    //    public Product save(@RequestBody Product product) {
    //        return productService.save(product);
    //    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId){
        if (productService.delete(productId)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    //version 1
    //    public boolean delete(@PathVariable("id") int prodcutId){
    //        return productService.delete(prodcutId);
    //    }

}
