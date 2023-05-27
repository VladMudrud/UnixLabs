package edu.internetstore.internetstore.service;

import edu.internetstore.internetstore.dto.OrdersDto;
import edu.internetstore.internetstore.repository.OrdersRepository;
import edu.internetstore.internetstore.util.EntityToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService implements InternetStoreService<OrdersDto> {

    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public List<OrdersDto> getAllData() {
        return ordersRepository.findAll().stream()
                .map(EntityToDto::ordersEntityToDto)
                .toList();
    }

    @Override
    public OrdersDto getDataById(String id) {
        return null;
    }

    @Override
    public void insertData(OrdersDto element) {

    }

    @Override
    public void updateData(OrdersDto element) {

    }

    @Override
    public OrdersDto getData(OrdersDto element) {
        return null;
    }
}
