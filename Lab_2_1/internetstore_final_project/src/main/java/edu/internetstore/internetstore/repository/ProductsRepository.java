package edu.internetstore.internetstore.repository;

import edu.internetstore.internetstore.entity.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsEntity, UUID> {
    Optional<ProductsEntity> findById(String id);
    Optional<ProductsEntity> findByName(String name);

    Optional<ProductsEntity> findByDescription(String description); // Optional prevents NullPointerException

    @Query(value = "select product from ProductEntity product " +
            "WHERE product.name=:name AND product.price=:price",
            nativeQuery = true)
    Optional<ProductsEntity> findProductByNameAndPrice(@Param("name") String name,
                                                       @Param("price") BigDecimal price);


}
