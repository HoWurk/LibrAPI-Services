package com.ghostdovahkiin.purchase.purchase.services;

import com.ghostdovahkiin.purchase.purchase.Purchase;
import com.ghostdovahkiin.purchase.purchase.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ListPurchaseServiceImpl implements ListPurchaseService{
    private final PurchaseRepository purchaseRepository;

    @Override
    public List<Purchase> findAll() { return purchaseRepository.findAll(); }
}
