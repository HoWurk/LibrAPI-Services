
package com.ghostdovahkiin.book_category.book.services;

import com.ghostdovahkiin.book_category.book.Book;

import java.util.List;

@FunctionalInterface
public interface ListBookByCategoryNameService {
    List<Book> findBookByCategoriesName(String categoryName);
}