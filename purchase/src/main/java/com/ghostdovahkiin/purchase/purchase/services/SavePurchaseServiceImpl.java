package com.ghostdovahkiin.purchase.purchase.services;

import com.ghostdovahkiin.purchase.purchase.Purchase;
import com.ghostdovahkiin.purchase.purchase.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SavePurchaseServiceImpl implements SavePurchaseService{
    private final PurchaseRepository purchaseRepository;

    @Override
    public void save(Purchase purchase) {
        purchaseRepository.save(purchase);
    }
}
