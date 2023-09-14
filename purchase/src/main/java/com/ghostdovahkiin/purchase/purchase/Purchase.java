package com.ghostdovahkiin.purchase.purchase;

import com.ghostdovahkiin.book_category.book.Book;
import com.ghostdovahkiin.user.user.User;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "purchase")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "Builder")
public class Purchase implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 98263987234545L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.DETACH)
    @PrimaryKeyJoinColumn(name = "book_id")
    private Set<Book> purchasedBooks;

    @Column(name = "amount_to_pay")
    private double amountToPay;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    public static Purchase to(PurchaseDTO dto) {
        return Purchase
                .builder()
                .user(dto.getUser())
                .purchasedBooks(dto.getPurchasedBooks())
                .amountToPay(dto.getAmountToPay())
                .status(dto.getStatus())
                .build();
    }
}
