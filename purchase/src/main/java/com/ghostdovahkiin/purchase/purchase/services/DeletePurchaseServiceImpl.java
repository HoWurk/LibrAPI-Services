package com.ghostdovahkiin.purchase.purchase.services;

import com.ghostdovahkiin.purchase.exceptions.PurchaseNotFoundException;
import com.ghostdovahkiin.purchase.purchase.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeletePurchaseServiceImpl implements DeletePurchaseService{
    private final PurchaseRepository purchaseRepository;

    @Override
    public void delete(Long id) {
        if (!purchaseRepository.existsById(id)){
            throw new PurchaseNotFoundException();
        }
        purchaseRepository.deleteById(id);
    }
}
