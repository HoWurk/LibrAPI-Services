package com.ghostdovahkiin.book_category.category.builder;

import com.ghostdovahkiin.book_category.category.Category;

public class CategoryBuilder {
    public static Category.Builder createCategory() {
        return Category.builder()
                .id(123L)
                .name("Mathematics");
    }
}
