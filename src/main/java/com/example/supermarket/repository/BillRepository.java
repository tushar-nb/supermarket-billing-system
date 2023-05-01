package com.example.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.supermarket.model.*;

public interface BillRepository extends JpaRepository<Bill, Integer> {
    
        Bill findByid(int id);

        // ResponseEntity<Bill> getBillByIdAndSeller(int billId, int sellerId);

        Object getBillByIdAndSellerId(int billId, int sellerId);

        Object findAllBySellerId(int sellerId);

}
