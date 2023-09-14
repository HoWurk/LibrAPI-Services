package com.ghostdovahkiin.purchase.purchase.services;

import com.ghostdovahkiin.purchase.purchase.Purchase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@FunctionalInterface
public interface ListPagePurchaseService {
    Page<Purchase> listPurchases(Pageable pageable);
}
