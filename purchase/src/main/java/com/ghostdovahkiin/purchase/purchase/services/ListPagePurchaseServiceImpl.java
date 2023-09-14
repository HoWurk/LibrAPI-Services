package com.ghostdovahkiin.purchase.purchase.services;

import com.ghostdovahkiin.purchase.purchase.Purchase;
import com.ghostdovahkiin.purchase.purchase.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ListPagePurchaseServiceImpl implements ListPagePurchaseService {
    private final PurchaseRepository purchaseRepository;

    @Override
    public Page<Purchase> listPurchases(Pageable pageable) { return purchaseRepository.findAll(pageable); }
}
