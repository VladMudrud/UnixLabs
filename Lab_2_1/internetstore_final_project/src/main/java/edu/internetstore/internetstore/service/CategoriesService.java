package edu.internetstore.internetstore.service;

import edu.internetstore.internetstore.dto.CategoriesDto;
import edu.internetstore.internetstore.repository.CategoriesRepository;
import edu.internetstore.internetstore.util.EntityToDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoriesService implements InternetStoreService<CategoriesDto> {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public List<CategoriesDto> getAllData() {
        return categoriesRepository.findAll().stream()
                .map(EntityToDto::categoryEntityToDto)
                .toList();
    }

    @Override
    public void insertData(CategoriesDto element) {

    }

    @Override
    public void updateData(CategoriesDto element) {

    }

    @Override
    public CategoriesDto getData(CategoriesDto element) {
        return null;
    }

    @Override
    public CategoriesDto getDataById(String id) {
        return EntityToDto.categoryEntityToDto(
                categoriesRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new EntityNotFoundException("No category was found")));
    }

}
