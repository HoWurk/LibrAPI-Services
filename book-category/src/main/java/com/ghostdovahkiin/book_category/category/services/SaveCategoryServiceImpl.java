package com.ghostdovahkiin.book_category.category.services;

import com.ghostdovahkiin.book_category.category.Category;
import com.ghostdovahkiin.book_category.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SaveCategoryServiceImpl implements SaveCategoryService{
    private final CategoryRepository categoryRepository;

    @Override
    public void save(Category bookCategory) {
        categoryRepository.save(bookCategory);
    }
}
