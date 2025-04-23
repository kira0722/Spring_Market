package com.example.market.web.controller;

import com.example.market.Domain.Purchase;
import com.example.market.Domain.service.PurcharseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurcharseController {

    @Autowired
    public PurcharseService purcharseService;

    @GetMapping("/all")
    public ResponseEntity<List<Purchase>> getAll(){
        return new ResponseEntity<>(purcharseService.getAll(), HttpStatus.OK);
    }


    @GetMapping("/client/{idCliente}")
    public ResponseEntity<List<Purchase>> getByClient(@PathVariable("idCliente") String clientId){
        return purcharseService.getByClient(clientId)
                .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase){
        return new ResponseEntity<>(purcharseService.save(purchase), HttpStatus.CREATED);
    }
}
