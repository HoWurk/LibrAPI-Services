package com.ghostdovahkiin.book_category.category.services;

import com.ghostdovahkiin.book_category.category.Category;
import com.ghostdovahkiin.book_category.category.CategoryRepository;
import com.ghostdovahkiin.book_category.exceptions.CategoryNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateCategoryServiceImpl implements UpdateCategoryService{
    private final CategoryRepository categoryRepository;

    @Override
    public void update(Category category, Long id) {
        Category categoryFound = categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
        categoryFound.setName(category.getName());
        categoryRepository.save(categoryFound);
    }
}
