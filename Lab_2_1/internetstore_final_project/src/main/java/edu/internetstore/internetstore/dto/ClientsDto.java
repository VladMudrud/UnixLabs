package edu.internetstore.internetstore.dto;


import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@Builder
public class ClientsDto {
    @NonNull private String id;

    @NonNull private String name;

    private Instant birthDate;

    @NonNull private String email;

    @NonNull private String password;

}
