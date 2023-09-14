package com.ghostdovahkiin.book_category.book.services;

import com.ghostdovahkiin.book_category.book.Book;

@FunctionalInterface
public interface GetBookService {
    Book findById(Long id);
}
