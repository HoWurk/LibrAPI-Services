package com.ghostdovahkiin.purchase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {
		"com.ghostdovahkiin.user.user",
		"com.ghostdovahkiin.book_category.category",
		"com.ghostdovahkiin.purchase.purchase",
		"com.ghostdovahkiin.book_category.book"
})
@SpringBootApplication
public class PurchaseApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PurchaseApiApplication.class, args);
	}

}
