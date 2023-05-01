package com.example.supermarket.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.supermarket.model.*;

import com.example.supermarket.repository.*;

@RestController
@RequestMapping("/api/v1/bills")
public class BillController {

    @Autowired
    private BillRepository billRepository;

    // @Autowired
    // private PurchaseRepository purchaseRepository;

    @Autowired
    private ProductsRepository productRepository;

    // to create new bill
    @PostMapping("/create/{sellerId}")
    public ResponseEntity<?> createBill(@PathVariable int sellerId, @RequestBody Bill bill) {
        // System.out.println("here");
        // sellerRepository.findById(sellerId).orElseThrow();
        // {"productName":"Milk","quantity":2,"product_id":1,"totalBill":100}
        billRepository.save(bill);
        Optional<Products> product = productRepository.findById(bill.getProduct_id());
        
        if (product.isPresent()) {
            product.get().setAvailable(product.get().getAvailable() - bill.getQuantity());
            productRepository.save(product.get());
        }

        return ResponseEntity.ok().body("Bill created successfully");
    }
    
    // to get all bills related to seller
    @GetMapping("/{sellerId}")
    public ResponseEntity<?> getAllBills(@PathVariable int sellerId) {
        // sellerRepository.findById(sellerId).orElseThrow();
        return ResponseEntity.ok(billRepository.findAllBySellerId(sellerId));
    }
    

}
