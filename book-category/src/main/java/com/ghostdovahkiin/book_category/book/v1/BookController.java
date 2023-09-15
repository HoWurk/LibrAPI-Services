package com.ghostdovahkiin.book_category.book.v1;

import com.ghostdovahkiin.book_category.book.Book;
import com.ghostdovahkiin.book_category.book.BookDTO;
import com.ghostdovahkiin.book_category.book.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/api/books")
public class BookController {
    private final ListBookService listBookService;
    private final GetBookService getBookService;
    private final SaveBookService saveBookService;
    private final ListBookByCategoryNameService listBookByCategoryNameService;
    private final UpdateBookService updateBookService;
    private final DeleteBookService deleteBookService;
    private final ValidateBooksService validateBooksService;

    @GetMapping(path = "/all")
    @ResponseStatus(HttpStatus.OK)
    public List<BookDTO> findAll() {
        return BookDTO.fromAll(listBookService.findAll());
    }

    @GetMapping(path = "/category/{categoryName}")
    @ResponseStatus(HttpStatus.OK)
    public List<BookDTO> findBookByCategoriesName(@PathVariable String categoryName) {
        return BookDTO.fromAll(listBookByCategoryNameService.findBookByCategoriesName(categoryName));
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookDTO findById(@PathVariable Long id) {
        return BookDTO.from(getBookService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@Valid @RequestBody BookDTO bookDTO) {
        saveBookService.save(Book.to(bookDTO));
    }

    @PostMapping(path = "/exist")
    @ResponseStatus(HttpStatus.OK)
    public Boolean allExist(@Valid @RequestBody Set<Long> bookIds) {
        return validateBooksService.existAll(bookIds);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody BookDTO bookDTO, @PathVariable Long id) {
        updateBookService.update(Book.to(bookDTO), id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        deleteBookService.delete(id);
    }
}
