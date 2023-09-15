package com.ghostdovahkiin.book_category.book.services;

import java.util.Set;

@FunctionalInterface
public interface ValidateBooksService {
    Boolean existAll(Set<Long> bookIds);
}
