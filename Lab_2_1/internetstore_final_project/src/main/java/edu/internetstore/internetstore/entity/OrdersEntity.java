package edu.internetstore.internetstore.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "orders")
@Entity
@IdClass(OrdersEntityPk.class)
public class OrdersEntity {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private ClientsEntity clientId;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "check_id", referencedColumnName = "id")
    private ChecksEntity checkId;

    @Column(name = "order_date")
    @NonNull private Instant orderDateTime;

}
