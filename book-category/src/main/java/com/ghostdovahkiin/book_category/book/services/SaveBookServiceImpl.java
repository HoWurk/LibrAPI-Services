package com.ghostdovahkiin.book_category.book.services;

import com.ghostdovahkiin.book_category.book.Book;
import com.ghostdovahkiin.book_category.book.BookRepository;
import com.ghostdovahkiin.book_category.category.Category;
import com.ghostdovahkiin.book_category.exceptions.BookAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class SaveBookServiceImpl implements SaveBookService{
    private final BookRepository bookRepository;

    @Override
    public void save(Book book) {
        if(bookRepository.existsByIsbn(book.getIsbn())) {
            throw new BookAlreadyExistsException();
        }
        if(!book.getCategory().isEmpty()){
            Set<Category> categoryOfBookSet = new HashSet<>(book.getCategory());
            book.setCategory(categoryOfBookSet);
        }
        bookRepository.save(book);
    }
}
