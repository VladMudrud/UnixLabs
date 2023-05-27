package edu.internetstore.internetstore.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.Set;

@Data
@Builder
public class ProductsDto {

    private String id;

    @NonNull private String name;

    @NonNull private String vendorCode;

    private String description;

    private boolean available;

    @NonNull private BigDecimal price;

    private Set<CategoriesDto> categories;

    @NonNull private SuppliersDto supplier;
}
