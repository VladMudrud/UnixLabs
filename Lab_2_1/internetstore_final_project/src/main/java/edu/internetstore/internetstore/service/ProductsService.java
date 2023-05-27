package edu.internetstore.internetstore.service;

import edu.internetstore.internetstore.dto.ProductsDto;
import edu.internetstore.internetstore.entity.ProductsEntity;
import edu.internetstore.internetstore.repository.ProductsRepository;
import edu.internetstore.internetstore.util.DtoToEntity;
import edu.internetstore.internetstore.util.EntityToDto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Transient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService implements InternetStoreService<ProductsDto> {

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public List<ProductsDto> getAllData() {
        return productsRepository.findAll()
                .stream()
                .map(EntityToDto::productEntityToDto)
                .toList();
    }

    @Override
    public ProductsDto getDataById(String id) {
        return null;
    }

    @Override
    @Transient
    public void insertData(ProductsDto element) {
        ProductsEntity productsEntity = productsRepository.save(
                DtoToEntity.productDtoToEntity(element));


    }

    @Override
    public void updateData(ProductsDto productsDto) {
        ProductsEntity productFromRepository = productsRepository.findById(productsDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Product was not found"));
        ProductsEntity product = DtoToEntity.productDtoToEntity(productsDto);
        productFromRepository.setId(product.getId());
        productFromRepository.setName(product.getName());
        productFromRepository.setAvailable(product.isAvailable());
        productFromRepository.setPrice(product.getPrice());
        productFromRepository.setDescription(product.getDescription());
        productsRepository.save(productFromRepository);
    }

    @Override
    public ProductsDto getData(ProductsDto element) {
        ProductsEntity productsEntity = DtoToEntity.productDtoToEntity(element);
        return EntityToDto.productEntityToDto(productsRepository.findById(productsEntity.getId())
                .orElseThrow(() -> new EntityNotFoundException("Product was not found")));

    }

}
