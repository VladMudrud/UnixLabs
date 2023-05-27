package edu.internetstore.internetstore.service;

import edu.internetstore.internetstore.dto.ChecksDto;
import edu.internetstore.internetstore.repository.ChecksRepository;
import edu.internetstore.internetstore.util.EntityToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ChecksService implements InternetStoreService<ChecksDto> {

    @Autowired
    ChecksRepository checksRepository;

    @Override
    public List<ChecksDto> getAllData() {
        return checksRepository.findAll().stream()
                .map(EntityToDto::checksEntityToDto)
                .peek(check -> check.setCheckSum(
                        check.getProduct().getPrice()
                                .multiply(new BigDecimal(check.getQuantity()))))
                .toList();
    }



    @Override
    public ChecksDto getDataById(String id) {
        return null;
    }

    @Override
    public void insertData(ChecksDto element) {

    }

    @Override
    public void updateData(ChecksDto element) {

    }

    @Override
    public ChecksDto getData(ChecksDto element) {
        return null;
    }
}
