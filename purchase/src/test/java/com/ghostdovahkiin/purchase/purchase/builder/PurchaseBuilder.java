package com.ghostdovahkiin.purchase.purchase.builder;

import com.ghostdovahkiin.book_category.book.Book;
import com.ghostdovahkiin.book_category.category.Category;
import com.ghostdovahkiin.purchase.purchase.Purchase;
import com.ghostdovahkiin.purchase.purchase.Status;
import com.ghostdovahkiin.user.user.Sex;
import com.ghostdovahkiin.user.user.User;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class PurchaseBuilder {

    public static Purchase.Builder createPurchase() {
        User user = createUser().build();
        Set<Book> books = new HashSet<>();
        books.add(createBook().title("book1").isbn("978-3-16-148410-0").build());
        books.add(createBook().title("book2").isbn("978-3-16-148410-1").build());
        return Purchase.builder()
                .id(123L)
                .user(user)
                .purchasedBooks(books)
                .amountToPay(229.90)
                .status(Status.COMPLETED);
    }

    private static Book.Builder createBook() {
        Category test = new Category(1, "Geografia");
        Set<Category> categorySet = new HashSet<>();
        categorySet.add(test);
        return Book.builder()
                .id(123L)
                .isbn("12345678912345678")
                .title("book")
                .author("author")
                .publicationYear(LocalDate.of(2020, 2, 15))
                .availableQuantity(2)
                .synopsis("synopsis")
                .category(categorySet)
                .sellPrice(15.00);

    }

    private static User.Builder createUser() {
        return User.builder()
                .id(145485989485039832L)
                .name("Pedro")
                .age(22)
                .phone("+5583986862912")
                .email("pedro.sousa@dcx.ufpb.br")
                .sex(Sex.MALE);
    }
}
