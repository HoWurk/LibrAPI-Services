package com.ghostdovahkiin.purchase.purchase.services;

import com.ghostdovahkiin.purchase.purchase.Purchase;

import java.util.List;

@FunctionalInterface
public interface ListPurchaseService {
    List<Purchase> findAll();
}
