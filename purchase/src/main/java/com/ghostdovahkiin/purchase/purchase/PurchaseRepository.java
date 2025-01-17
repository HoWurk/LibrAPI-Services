package com.ghostdovahkiin.purchase.purchase;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    List<Purchase> findPurchaseByStatus(Status status);
}
