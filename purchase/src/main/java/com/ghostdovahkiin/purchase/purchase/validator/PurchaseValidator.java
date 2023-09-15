package com.ghostdovahkiin.purchase.purchase.validator;

import com.ghostdovahkiin.book_category.exceptions.BookNotFoundException;
import com.ghostdovahkiin.user.exceptions.UserNotFoundException;
import com.ghostdovahkiin.user.user.UserDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

public class PurchaseValidator {
    public static void validatePurchase(long userId, Set<Long> bookIds) {
        RestTemplate restTemplate = new RestTemplateBuilder().build();
        try {
            UserDTO userDTO = restTemplate.getForObject(
                    "http://localhost:8083/v1/api/users/" + userId,
                    UserDTO.class);
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException();
        }

        boolean allExist = Boolean.TRUE.equals(restTemplate.postForObject(
                "http://localhost:8082/v1/api/books/exist",
                bookIds,
                Boolean.class));
        if (!allExist)
            throw new BookNotFoundException();
    }
}
