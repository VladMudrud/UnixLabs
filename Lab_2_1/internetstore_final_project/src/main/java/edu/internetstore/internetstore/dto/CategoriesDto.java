package edu.internetstore.internetstore.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class CategoriesDto {

    @NonNull private String id;

    @NonNull private String name;
}
