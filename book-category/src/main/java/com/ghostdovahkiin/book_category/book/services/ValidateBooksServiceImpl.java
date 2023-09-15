package com.ghostdovahkiin.book_category.book.services;

import com.ghostdovahkiin.book_category.book.Book;
import com.ghostdovahkiin.book_category.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class ValidateBooksServiceImpl implements ValidateBooksService {
    private final BookRepository bookRepository;

    @Override
    public Boolean existAll(Set<Long> bookIds) {
        List<Book> books = bookRepository.findAllById(bookIds);
        return books.size() == bookIds.size();
    }
}
