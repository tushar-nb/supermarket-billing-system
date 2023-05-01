package com.example.supermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.supermarket.model.*;

import com.example.supermarket.repository.*;

@Service
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private ProductsRepository productRepository;

    // ... getAllAdmins, getAdminById, createAdmin, updateAdmin, deleteAdmin

    @PostMapping
    public ResponseEntity<?> createAdmin(@RequestBody Admin admin) {
        Admin temp = adminRepository.findByEmail(admin.getEmail());

        if (temp != null) {
            return ResponseEntity.badRequest().body("Admin already exists");
        } else {
            adminRepository.save(admin);
            return ResponseEntity.ok().body("Admin created successfully");
        }
    }

    // admin login
    @PostMapping("/login")
    public ResponseEntity<?> loginAdmin(@RequestBody Admin admin) {
        Admin temp = adminRepository.findByEmail(admin.getEmail());

        if (temp != null) {
            if (temp.getPassword().equals(admin.getPassword())) {
                return ResponseEntity.ok().body("Login successful");
            } else {
                return ResponseEntity.badRequest().body("Incorrect password");
            }
        } else {
            return ResponseEntity.badRequest().body("Admin does not exist");
        }
    }

    @GetMapping("/{adminId}/sellers")
    public ResponseEntity<?> getAllSellers(@PathVariable int adminId) {
        // adminRepository.findById(adminId).orElseThrow();
        
        return ResponseEntity.ok(sellerRepository.findAll());
    }

    @PostMapping("/seller")
    public ResponseEntity<?> createSeller(@RequestBody Seller seller) {
        Seller temp = sellerRepository.findByEmail(seller.getEmail());

        if (temp != null) {
            return ResponseEntity.badRequest().body("Seller already exists");
        } else {
            sellerRepository.save(seller);
            return ResponseEntity.ok().body("Seller created successfully");
        }
    }


    @GetMapping("/{adminId}/products")
    public ResponseEntity<?> getAllProducts(@PathVariable int adminId) {
        // adminRepository.findById(adminId)
        //         .orElseThrow(() -> new ResourceNotFoundException("Admin not found with id " + adminId));
        return ResponseEntity.ok(productRepository.findAll());
    }

    @PostMapping("/{adminId}/products")
    public Products createProduct(@PathVariable int adminId, @RequestBody Products product) {
        // return adminRepository.findById(adminId).map(admin -> {
        //     product.setAdmin(admin);
        //     return productRepository.save(product);
        // }).orElseThrow(() -> new ResourceNotFoundException("Admin not found with id " + adminId));
        return productRepository.save(product);
    }    
    
    //delete seller
    @PostMapping("/admin/{sellerId}")
    public ResponseEntity<?> deleteSeller(@PathVariable int sellerId) {
        if (!sellerRepository.existsById(sellerId)) {
            return ResponseEntity.badRequest().body("Seller does not exist");
        }
        else {
            sellerRepository.deleteById(sellerId);
            return ResponseEntity.ok().body("Seller deleted successfully");
        }
    }
}

