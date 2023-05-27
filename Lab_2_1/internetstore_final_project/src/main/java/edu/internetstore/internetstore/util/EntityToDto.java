package edu.internetstore.internetstore.util;

import edu.internetstore.internetstore.dto.*;
import edu.internetstore.internetstore.entity.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EntityToDto {
    public static ProductsDto productEntityToDto(ProductsEntity productsEntity) {
        return ProductsDto.builder()
                .id(productsEntity.getId().toString())
                .name(productsEntity.getName())
                .price(productsEntity.getPrice())
                .available(productsEntity.isAvailable())
                .description(productsEntity.getDescription())
                .vendorCode(productsEntity.getVendorCode())
                .categories(productsEntity.getCategories().stream()
                        .map(EntityToDto::categoryEntityToDto)
                        .collect(Collectors.toSet()))
                .supplier(suppliersEntityToDto(productsEntity.getSupplier()))
                .build();
    }

    private static String getCategoriesList(ProductsEntity productsEntity) {
        return productsEntity.getCategories().stream()
                .map(CategoriesEntity::getName)
                .collect(Collectors.joining(", "));
    }

    public static CategoriesDto categoryEntityToDto(CategoriesEntity categoriesEntity) {
        return CategoriesDto.builder()
                .id(categoriesEntity.getId().toString())
                .name(categoriesEntity.getName())
                .build();
    }

    public static SuppliersDto suppliersEntityToDto(SuppliersEntity suppliersEntity) {
        return SuppliersDto.builder()
                .id(suppliersEntity.getId().toString())
                .name(suppliersEntity.getName())
                .email(suppliersEntity.getEmail())
                .licenseDto(licensesEntityToDto(suppliersEntity.getLicenseTaxRegistry()))
                .products(suppliersEntity.getProducts().stream()
                        .map(EntityToDto::productEntityToDto)
                        .collect(Collectors.toSet()))
                .build();
    }

    public static LicensesDto licensesEntityToDto(LicensesEntity licensesEntity) {
        return LicensesDto.builder()
                .taxRegistry(licensesEntity.getTaxRegistry())
                .name(licensesEntity.getName())
                .build();
    }

    public static ChecksDto checksEntityToDto(ChecksEntity checksEntity) {

        return ChecksDto.builder()
                .id(checksEntity.getId().toString())
                .product(productEntityToDto(checksEntity.getProduct()))
                .quantity(checksEntity.getQuantity())
                .build();
    }

    public static ClientsDto clientsEntityToDto(ClientsEntity clientsEntity) {
        return ClientsDto.builder()
                .name(clientsEntity.getName())
                .email(clientsEntity.getEmail())
                .password(clientsEntity.getPassword())
                .birthDate(clientsEntity.getBirthDate())
                .id(clientsEntity.getId().toString())
                .build();
    }

    public static OrdersDto ordersEntityToDto(OrdersEntity ordersEntity) {
        return OrdersDto.builder()
                .client(clientsEntityToDto(ordersEntity.getClientId()))
                .check(checksEntityToDto(ordersEntity.getCheckId()))
                .orderDateTime(ordersEntity.getOrderDateTime())
                .build();
    }
}
