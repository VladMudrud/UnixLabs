package edu.internetstore.internetstore.repository;

import edu.internetstore.internetstore.entity.CategoriesEntity;
import edu.internetstore.internetstore.entity.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoriesRepository extends JpaRepository<CategoriesEntity, UUID> {
    Optional<CategoriesEntity> findById(String id);
}
