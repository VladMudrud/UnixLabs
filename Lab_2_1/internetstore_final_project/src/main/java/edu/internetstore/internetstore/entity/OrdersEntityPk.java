package edu.internetstore.internetstore.entity;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersEntityPk implements Serializable {

    private UUID clientId;

    private UUID checkId;

}
