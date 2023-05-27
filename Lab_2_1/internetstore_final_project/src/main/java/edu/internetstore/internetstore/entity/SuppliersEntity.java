package edu.internetstore.internetstore.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "suppliers")
public class SuppliersEntity {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(name = "name")
    @NonNull private String name;

    @Column(name = "email")
    @NonNull private String email;

    @OneToOne(orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "license_tax_registry")
    @NonNull private LicensesEntity licenseTaxRegistry;

    /**
     * This field is not mapped in the Database.
     * It is needed just for supporting bidirectional
     * relationships in JPA for this case
     * */
    @OneToMany(fetch = FetchType.EAGER,
               cascade = CascadeType.ALL,
               orphanRemoval = true,
               mappedBy = "supplier")
    @Column(name = "product")
    private Set<ProductsEntity> products;
}
