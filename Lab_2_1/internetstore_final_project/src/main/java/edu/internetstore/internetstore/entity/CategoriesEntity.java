package edu.internetstore.internetstore.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "categories")
public class CategoriesEntity implements Serializable { // interprets to category_entity
    @Id             // Unique, Primary Key, Not Null
    @GeneratedValue // SERIES -> auto generation of key
    @UuidGenerator
    private UUID id;

    @Column(name = "name")
    @NonNull private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "categories_products",
               joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    private Set<ProductsEntity> products = new HashSet<>();


}
