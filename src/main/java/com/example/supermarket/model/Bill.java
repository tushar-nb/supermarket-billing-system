package com.example.supermarket.model;

import java.util.List;
import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NonNull
    private int totalBill;

    private int product_id;

    private int quantity;

    private String productName;

    @JoinColumn(name = "seller_id" , referencedColumnName = "id")
    private int sellerId;


    

    

    public Bill saveBill(Bill bill) {
        return null;
    }

    public List<Bill> getBillsBySeller(Seller seller) {
        return null;
    }

    public Bill getBillByIdAndSeller(int billId, Seller seller) {
        return null;
    }

    

    public void setTotalBill(float totalBill2) {
    }

    public void setSellerId(int sellerId) {
    }

    public void setCustomerId(int customerId) {
    }

    public void setTotalBill(Double totalBill2) {
    }

    

    // constructors, getters and setters
}


