package com.ghostdovahkiin.book_category.book.services;

import com.ghostdovahkiin.book_category.book.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@FunctionalInterface
public interface ListPageBookService {
    Page<Book> listBooks(Pageable pageable);
}
