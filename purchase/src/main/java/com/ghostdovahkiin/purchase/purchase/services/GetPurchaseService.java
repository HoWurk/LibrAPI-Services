package com.ghostdovahkiin.purchase.purchase.services;

import com.ghostdovahkiin.purchase.purchase.Purchase;

@FunctionalInterface
public interface GetPurchaseService {
    Purchase findById(Long id);
}
