package edu.internetstore.internetstore.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class OrdersDto {
    @NonNull private ClientsDto client;

    @NonNull private ChecksDto check;

    @NonNull private Instant orderDateTime;
}
