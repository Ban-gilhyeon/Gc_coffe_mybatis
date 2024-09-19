package org.example.controller;

import org.example.model.dto.ProductsDTO;
import org.example.model.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/cafe")
public class ProductsController {

    @Autowired
    ProductsService productsService;

    @GetMapping("/add")
    public void addProduct(@RequestBody ProductsDTO dto) throws SQLException {
        productsService.insert(dto);
    }

    @GetMapping("/list")
    public List<ProductsDTO> listProducts() throws SQLException {
        List<ProductsDTO> list = productsService.findAll();
        System.out.println("/list : " + list);
        return list;
    }

    //Test용 findById
    @GetMapping("/findById")
    public ProductsDTO findById(@RequestParam int id) throws SQLException {
        return productsService.findById(id);
    }

    @PutMapping("/update/{productId}")
    public void updateProduct(@PathVariable int productId, @RequestBody ProductsDTO dto) throws SQLException {
        dto.setProductId(productId);
        System.out.println("productId : " + productId);
        System.out.println("productName : " + dto.getProductName());
        System.out.println("Category : " + dto.getCategory());
        System.out.println("price : " + dto.getPrice());
        System.out.println("description : " + dto.getDescription());
        productsService.update(dto);
    }

    @DeleteMapping("/delete/{productId}")
    public void delete(@PathVariable int productId) throws SQLException {
        productsService.delete(productId);
    }
}
