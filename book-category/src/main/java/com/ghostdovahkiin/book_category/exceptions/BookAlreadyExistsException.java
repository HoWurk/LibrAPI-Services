package com.ghostdovahkiin.book_category.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class BookAlreadyExistsException extends RuntimeException{
    public BookAlreadyExistsException() { super("The book with specified ISBN already exists");}
}
