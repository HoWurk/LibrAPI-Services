package com.ghostdovahkiin.purchase.purchase.services;

import com.ghostdovahkiin.purchase.purchase.Purchase;
import com.ghostdovahkiin.purchase.purchase.Status;

import java.util.List;

@FunctionalInterface
public interface GetPurchaseByStatusService {
    List<Purchase> listByStatus(Status status);
}
