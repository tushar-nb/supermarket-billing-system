package com.example.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

// import com.example.supermarket.model.*;;
import com.example.supermarket.model.*;;

public interface SellerRepository extends JpaRepository<Seller, Integer> {

    Seller findByEmail(String email);

    void deleteByEmail(String email);

}
