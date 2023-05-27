package edu.internetstore.internetstore.controller;

import edu.internetstore.internetstore.dto.*;
import edu.internetstore.internetstore.service.*;
import edu.internetstore.internetstore.util.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Controller
public class MainController {

    private final ClientsService clientsService;
    private final ProductsService productsService;
    private final SuppliersService suppliersService;

    private final CategoriesService categoriesService;

    private final OrdersService ordersService;

    private final ChecksService checksService;


    public MainController(ClientsService clientsService,
                          ProductsService productsService,
                          SuppliersService suppliersService,
                          CategoriesService categoriesService,
                          OrdersService ordersService,
                          ChecksService checksService) {
        this.clientsService = clientsService;
        this.productsService = productsService;
        this.suppliersService = suppliersService;
        this.categoriesService = categoriesService;
        this.ordersService = ordersService;
        this.checksService = checksService;
    }

    @GetMapping("/index")
    public ModelAndView index(ModelMap model) {
        String name = "Ihor";
        model.addAttribute("name", name);
        return new ModelAndView("/index", model);

    }

    @GetMapping("/test")
    public String test(ModelMap model) {
        String name = "Ihor";
    return "index";
//        model.addAttribute("name", name);
//        return new ModelAndView("/index", model);

    }

    @GetMapping("/products")
    public String getAllProducts(@ModelAttribute("model") ModelMap model) {
        List<ProductsDto> products = productsService.getAllData();
        List<SuppliersDto> suppliers = suppliersService.getAllData();
        List<CategoriesDto> categories = categoriesService.getAllData();
        model.addAttribute("products", products);
        model.addAttribute("suppliers", suppliers);
        model.addAttribute("categories", categories);
        return "products";
    }

    @GetMapping("/orders")
    public String getAllOrders(@ModelAttribute("model") ModelMap model) {
        List<OrdersDto> orders = ordersService.getAllData();
        model.addAttribute("orders", orders);
        return "orders";
    }

    @GetMapping("/checks")
    public String getAllChecks(@ModelAttribute("model") ModelMap model) {
        List<ChecksDto> checks = checksService.getAllData();
        model.addAttribute("checks", checks);
        return "checks";
    }

    @PostMapping("/insert-product")
    public ModelAndView insertNewProduct(
            @ModelAttribute("model") ModelMap model,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "price") String price,
            @RequestParam(name = "vendor_code") String vendorCode,
            @RequestParam(name = "category_id") String categoryId,
            @RequestParam(name = "supplier_id") String supplierId) {

        Set<CategoriesDto> categoriesDto = Utils.categoryStringToCategorySet(
                categoriesService.getDataById(categoryId));
        SuppliersDto supplierDto = suppliersService.getDataById(supplierId);
        ProductsDto product  = ProductsDto.builder()
                .name(name)
                .price(new BigDecimal(price))
                .vendorCode(vendorCode)
                .categories(categoriesDto)
                .supplier(supplierDto)
                .build();
        productsService.insertData(product);
            model.addAttribute("products", productsService.getAllData());
        return new ModelAndView("/products", model);
    }
}
