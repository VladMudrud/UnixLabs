package edu.internetstore.internetstore.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.Set;

@Data
@Builder
public class SuppliersDto {

    @NonNull private String id;

    @NonNull private String name;

    @NonNull private String email;

    @NonNull private LicensesDto licenseDto;

    @NonNull private Set<ProductsDto> products;
}
