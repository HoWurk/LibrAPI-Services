package com.ghostdovahkiin.purchase.purchase;

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

    @Column(name = "user_id")
    private long userId;

    @ElementCollection
    @CollectionTable(name = "book_ids")
    private Set<Long> bookIds;

    @Column(name = "amount_to_pay")
    private double amountToPay;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    public static Purchase to(PurchaseDTO dto) {
        return Purchase
                .builder()
                .userId(dto.getUserId())
                .bookIds(dto.getBookIds())
                .amountToPay(dto.getAmountToPay())
                .status(dto.getStatus())
                .build();
    }
}
