package com.ghostdovahkiin.purchase.purchase.services;

import com.ghostdovahkiin.purchase.purchase.Purchase;
import com.ghostdovahkiin.purchase.purchase.PurchaseRepository;
import com.ghostdovahkiin.purchase.purchase.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetPurchaseByStatusServiceImpl implements GetPurchaseByStatusService{
    private final PurchaseRepository purchaseRepository;

    @Override
    public List<Purchase> listByStatus(Status status) {
        return purchaseRepository.findPurchaseByStatus(status);
    }
}
