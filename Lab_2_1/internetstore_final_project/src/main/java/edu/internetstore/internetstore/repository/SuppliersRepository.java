package edu.internetstore.internetstore.repository;

import edu.internetstore.internetstore.entity.CategoriesEntity;
import edu.internetstore.internetstore.entity.SuppliersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SuppliersRepository extends JpaRepository<SuppliersEntity, UUID> {
    Optional<SuppliersEntity> findById(String id);
}
