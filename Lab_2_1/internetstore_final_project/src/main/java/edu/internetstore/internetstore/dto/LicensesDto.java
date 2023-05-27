package edu.internetstore.internetstore.dto;


import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class LicensesDto {
    @NonNull private String taxRegistry;

    @NonNull private String name;

}
