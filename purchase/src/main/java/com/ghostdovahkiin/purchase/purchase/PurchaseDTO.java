package com.ghostdovahkiin.purchase.purchase;

import lombok.*;
import org.springframework.data.domain.Page;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "Builder")
public class PurchaseDTO implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 675638275354344545L;
    private long id;

    @NotNull(message = "User cannot be null")
    private long userId;

    @NotNull(message = "Purchased Books cannot be null")
    @Size(min = 1, message = "Purchased book must have at least one book")
    private Set<Long> bookIds;

    @NotNull(message = "Amount cannot be null")
    @Min(value = 0, message = "The minimum value is 0.00")
    private double amountToPay;

    @NotNull(message = "Purchase status cannot be null, the status are COMPLETED, FINISHED, CLOSED and PENDING")
    private Status status;

    public static PurchaseDTO from(Purchase entity) {
        return PurchaseDTO
                .builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .bookIds(entity.getBookIds())
                .amountToPay(entity.getAmountToPay())
                .status(entity.getStatus())
                .build();
    }

    public static List<PurchaseDTO> fromAll(List<Purchase> purchases) {
        return purchases.stream().map(PurchaseDTO::from).collect(Collectors.toList());
    }

    public static Page<PurchaseDTO> fromPage(Page<Purchase> pages) { return pages.map(PurchaseDTO::from);}
}
