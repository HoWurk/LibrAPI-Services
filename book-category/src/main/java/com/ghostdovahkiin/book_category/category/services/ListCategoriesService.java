package com.ghostdovahkiin.book_category.category.services;

import com.ghostdovahkiin.book_category.category.Category;

import java.util.List;

@FunctionalInterface
public interface ListCategoriesService {
    List<Category> findAll();
}
