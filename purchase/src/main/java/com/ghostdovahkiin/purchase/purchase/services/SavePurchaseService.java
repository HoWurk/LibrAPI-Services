package com.ghostdovahkiin.purchase.purchase.services;

import com.ghostdovahkiin.purchase.purchase.Purchase;

@FunctionalInterface
public interface SavePurchaseService {
    void save(Purchase purchase);
}
