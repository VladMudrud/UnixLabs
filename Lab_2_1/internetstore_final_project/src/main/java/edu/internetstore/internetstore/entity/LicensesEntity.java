package edu.internetstore.internetstore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "licenses")
public class LicensesEntity {

    @Id
    @Column(name = "tax_registry")
    @NonNull private String taxRegistry;

    @Column(name = "name")
    @NonNull private String name;


}
