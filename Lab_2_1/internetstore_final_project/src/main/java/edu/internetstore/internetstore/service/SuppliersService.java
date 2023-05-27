package edu.internetstore.internetstore.service;

import edu.internetstore.internetstore.dto.SuppliersDto;
import edu.internetstore.internetstore.repository.SuppliersRepository;
import edu.internetstore.internetstore.util.EntityToDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SuppliersService implements InternetStoreService<SuppliersDto> {

    @Autowired
    private SuppliersRepository suppliersRepository;

    @Override
    public List<SuppliersDto> getAllData() {
        return suppliersRepository.findAll().stream()
                .map(EntityToDto::suppliersEntityToDto)
                .toList();
    }

    @Override
    public void insertData(SuppliersDto element) {

    }

    @Override
    public void updateData(SuppliersDto element) {

    }

    @Override
    public SuppliersDto getData(SuppliersDto element) {
        return null;
    }

    @Override
    public SuppliersDto getDataById(String id) {
        return EntityToDto.suppliersEntityToDto(suppliersRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new EntityNotFoundException("Supplier was not found")));
    }
}
