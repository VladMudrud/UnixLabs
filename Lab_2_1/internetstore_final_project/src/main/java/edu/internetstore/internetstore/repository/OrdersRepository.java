package edu.internetstore.internetstore.repository;

import edu.internetstore.internetstore.dto.OrdersDto;
import edu.internetstore.internetstore.entity.OrdersEntity;
import edu.internetstore.internetstore.entity.OrdersEntityPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<OrdersEntity, OrdersEntityPk> {
//    List<OrdersDto> findBy();

}
