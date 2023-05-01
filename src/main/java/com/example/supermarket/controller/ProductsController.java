package com.example.supermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.supermarket.model.*;

import com.example.supermarket.repository.*;


@RestController
@RequestMapping("/api/v1/products")
public class ProductsController {

    @Autowired
    private ProductsRepository productsRepository;

    // to get all products
    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        return ResponseEntity.ok(productsRepository.findAll());
    }    

   
    // to create a product, name should not be same as existing product
    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Products product) {
        Products temp = productsRepository.findByName(product.getName());

        if (temp != null) {
            return ResponseEntity.badRequest().body("Product already exists");
        } else {
            productsRepository.save(product);
            return ResponseEntity.ok().body("Product created successfully");
        }
    }
    

    // to update a product ()
    @PatchMapping("/{productId}")

    public ResponseEntity<?> updateProduct(@PathVariable int productId, @RequestBody Products product) {
        // System.out.println("HERE START");
        Products temp = productsRepository.findById(productId).orElseThrow();
        // System.out.println("HERE !!!!!!");
        if (temp != null) {
            // temp.setName(product.getName());
            temp.setPrice(product.getPrice());
            temp.setAvailable(product.getAvailable());
            temp.setTotal(product.getTotal());
            productsRepository.save(temp);
            return ResponseEntity.ok().body("Product updated successfully");
        } else {
            return ResponseEntity.badRequest().body("Product does not exist");
        }
    }

    
}
