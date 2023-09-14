package com.ghostdovahkiin.book_category.category.services;

import com.ghostdovahkiin.book_category.category.Category;
import com.ghostdovahkiin.book_category.category.CategoryRepository;
import com.ghostdovahkiin.book_category.exceptions.CategoryNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetCategoryServiceImpl implements GetCategoryService {
    private final CategoryRepository categoryRepository;


    @Override
    public Category GetById(Long id) {
        return categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
    }
}
