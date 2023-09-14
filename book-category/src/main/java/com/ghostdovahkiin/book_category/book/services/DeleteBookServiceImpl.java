package com.ghostdovahkiin.book_category.book.services;

import com.ghostdovahkiin.book_category.book.BookRepository;
import com.ghostdovahkiin.book_category.exceptions.BookNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteBookServiceImpl implements DeleteBookService{
    private final BookRepository bookRepository;

    @Override
    public void delete(Long id) {
        if(!bookRepository.existsById(id)){
            throw new BookNotFoundException();
        }
        bookRepository.deleteById(id);
    }
}
