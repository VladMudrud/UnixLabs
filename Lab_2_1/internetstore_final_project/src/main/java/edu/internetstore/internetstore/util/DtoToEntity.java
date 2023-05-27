package edu.internetstore.internetstore.util;

import edu.internetstore.internetstore.dto.CategoriesDto;
import edu.internetstore.internetstore.dto.LicensesDto;
import edu.internetstore.internetstore.dto.ProductsDto;
import edu.internetstore.internetstore.dto.SuppliersDto;
import edu.internetstore.internetstore.entity.CategoriesEntity;
import edu.internetstore.internetstore.entity.LicensesEntity;
import edu.internetstore.internetstore.entity.ProductsEntity;
import edu.internetstore.internetstore.entity.SuppliersEntity;

import java.util.UUID;
import java.util.stream.Collectors;

public class DtoToEntity {
    public static ProductsEntity productDtoToEntity(ProductsDto productsDto) {
        return ProductsEntity.builder()
                .name(productsDto.getName())
                .price(productsDto.getPrice())
                .available(productsDto.isAvailable())
                .description(productsDto.getDescription())
                .vendorCode(productsDto.getVendorCode())
                .categories(productsDto.getCategories().stream()
                        .map(DtoToEntity::categoryDtoToEntity)
                        .collect(Collectors.toSet()))
                .supplier(supplierDtoToEntity(productsDto.getSupplier()))
                .build();
    }

    public static CategoriesEntity categoryDtoToEntity(CategoriesDto categoriesDto) {
        return CategoriesEntity.builder()
                .name(categoriesDto.getName())
                .build();
    }

    public static SuppliersEntity supplierDtoToEntity(SuppliersDto suppliersDto) {
        return SuppliersEntity.builder()
                .name(suppliersDto.getName())
                .email(suppliersDto.getEmail())
                .licenseTaxRegistry(licensesEntityToDto(suppliersDto.getLicenseDto()))
                .build();
    }

    public static LicensesEntity licensesEntityToDto(LicensesDto licensesDto) {
        return LicensesEntity.builder()
                .taxRegistry(licensesDto.getTaxRegistry())
                .name(licensesDto.getName())
                .build();
    }


}
