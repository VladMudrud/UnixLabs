package edu.internetstore.internetstore.repository;

import edu.internetstore.internetstore.entity.ClientsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientsRepository extends JpaRepository<ClientsEntity, UUID> {
}
