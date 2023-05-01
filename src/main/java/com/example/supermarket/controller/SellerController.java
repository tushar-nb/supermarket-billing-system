package com.example.supermarket.controller;

import java.util.List;
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
@RequestMapping("/api/v1/seller")
public class SellerController {

    @Autowired(required=false)
    private Bill bill;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private BillRepository billRepository;

   
    // seller login, check email and if exists compare password
    
    @PostMapping("/login")
    public ResponseEntity<?> loginSeller(@RequestBody Seller seller) {
        Seller temp = sellerRepository.findByEmail(seller.getEmail());

        if (temp != null) {
            if (temp.getPassword().equals(seller.getPassword())) {
                return ResponseEntity.ok().body("Login successful");
            } else {
                return ResponseEntity.badRequest().body("Incorrect password");
            }
        } else {
            return ResponseEntity.badRequest().body("Seller does not exist");
        }
    }
    

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts() {
        // adminRepository.findById(adminId)
        //         .orElseThrow(() -> new ResourceNotFoundException("Admin not found with id " + adminId));
        return ResponseEntity.ok(productsRepository.findAll());
    }

    

    // @PostMapping("/{sellerId}/bills")
    // public ResponseEntity<?> createBill(@PathVariable int sellerId, @RequestBody List<Purchase> purchases) {
    //     // Seller seller = sellerRepository.findById(sellerId).orElseThrow(() -> new ResourceNotFoundException("Seller not found"));
    //     if(sellerRepository.findById(sellerId).isEmpty()) {
    //         return ResponseEntity.badRequest().body(null);
    //     }
    //     Seller seller = sellerRepository.findById(sellerId).get();
    //     float totalBill = bill.calculateTotalBill(purchases);
    //     Bill bill = new Bill(totalBill, purchases, seller);
    //     Bill newBill = bill.saveBill(bill);
    //     // return ResponseEntity.status(HttpStatus.CREATED).body(newBill);
    //     return ResponseEntity.ok(newBill);
    // }

    @GetMapping("/{sellerId}/bills")
    public ResponseEntity<List<Bill>> getAllBills(@PathVariable int sellerId) {
        // Seller seller = sellerRepository.findById(sellerId).orElseThrow(() -> new ResourceNotFoundException("Seller not found"));
        // return bill.getBillsBySeller(seller);
        return ResponseEntity.ok(bill.getBillsBySeller(sellerRepository.findById(sellerId).get()));
    }

    @GetMapping("/{sellerId}/bills/{billId}")
    public ResponseEntity<?> getBillById(@PathVariable int sellerId, @PathVariable int billId) {
        // Seller seller = sellerRepository.findById(sellerId).orElseThrow(() -> new ResourceNotFoundException("Seller not found"));
        // return ResponseEntity.ok(billRepository.getBillByIdAndSeller(billId, sellerRepository.findById(sellerId).get()));
        return ResponseEntity.ok(billRepository.getBillByIdAndSellerId(billId, sellerId));
    }


}

