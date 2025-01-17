package com.ghostdovahkiin.book_category.book.builder;

import com.ghostdovahkiin.book_category.book.Book;
import com.ghostdovahkiin.book_category.category.Category;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


public class BookBuilder {

    public static Book.Builder createBook(){
        Category test = new Category(1,"Geografia");
        Set<Category> categorySet = new HashSet<>();
        categorySet.add(test);
        return Book.builder()
                .id(123L)
                .isbn("12345678912345678")
                .title("book")
                .author("author")
                .publicationYear(LocalDate.of(2020, 2, 15))
                .availableQuantity(2)
                .synopsis("synopsis")
                .category(categorySet)
                .sellPrice(15.00);

    }
}
