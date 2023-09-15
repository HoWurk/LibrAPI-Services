package com.ghostdovahkiin.purchase.purchase.services;

import com.ghostdovahkiin.purchase.exceptions.PurchaseNotFoundException;
import com.ghostdovahkiin.purchase.purchase.Purchase;
import com.ghostdovahkiin.purchase.purchase.PurchaseDTO;
import com.ghostdovahkiin.purchase.purchase.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.ghostdovahkiin.purchase.purchase.validator.PurchaseValidator.validatePurchase;

@RequiredArgsConstructor
@Service
public class UpdatePurchaseServiceImpl implements UpdatePurchaseService{
    private final PurchaseRepository purchaseRepository;

    @Override
    public void update(PurchaseDTO purchase, Long id) {
        Purchase purchaseFound = purchaseRepository.findById(id).orElseThrow(PurchaseNotFoundException::new);

        validatePurchase(purchase.getUserId(), purchase.getBookIds());

        purchaseFound.setUserId(purchase.getUserId());
        purchaseFound.setBookIds(purchase.getBookIds());
        purchaseFound.setAmountToPay(purchase.getAmountToPay());
        purchaseFound.setStatus(purchase.getStatus());

        purchaseRepository.save(purchaseFound);
    }
}
