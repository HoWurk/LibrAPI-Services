package com.ghostdovahkiin.purchase.purchase.services;

import com.ghostdovahkiin.purchase.purchase.PurchaseDTO;

@FunctionalInterface
public interface UpdatePurchaseService {
    void update(PurchaseDTO purchase, Long id);
}
