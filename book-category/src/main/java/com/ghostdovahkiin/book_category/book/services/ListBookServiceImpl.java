package com.ghostdovahkiin.book_category.book.services;

import com.ghostdovahkiin.book_category.book.Book;
import com.ghostdovahkiin.book_category.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ListBookServiceImpl implements ListBookService{
    private final BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
