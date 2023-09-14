package com.ghostdovahkiin.purchase.purchase.services;

import com.ghostdovahkiin.purchase.exceptions.PurchaseNotFoundException;
import com.ghostdovahkiin.purchase.purchase.Purchase;
import com.ghostdovahkiin.purchase.purchase.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetPurchaseServiceImpl implements GetPurchaseService{
    private final PurchaseRepository purchaseRepository;

    @Override
    public Purchase findById(Long id) {
        return purchaseRepository.findById(id).orElseThrow(PurchaseNotFoundException::new);
    }
}
