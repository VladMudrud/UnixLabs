package edu.internetstore.internetstore.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
@Builder
public class ChecksDto {
    @NonNull private String id;

    @NonNull private ProductsDto product;

    @NonNull private Integer quantity;

    private BigDecimal checkSum;

}
