package com.ghostdovahkiin.book_category.category.services;

import com.ghostdovahkiin.book_category.category.Category;

@FunctionalInterface
public interface GetCategoryService {
    Category GetById(Long id);
}
