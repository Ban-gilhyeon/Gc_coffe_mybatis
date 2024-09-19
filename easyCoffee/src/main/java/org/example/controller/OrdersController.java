package org.example.controller;

import org.example.model.dto.OrderItemsDTO;
import org.example.model.dto.OrdersDTO;
import org.example.model.dto.ProductsDTO;
import org.example.model.service.OrdersService;
import org.example.model.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private ProductsService productsService;

    @PostMapping("/add")
    public void addOrder(@RequestBody OrdersDTO dto, @RequestParam(name  = "quantity") int quantity, @RequestParam(name = "productId") int productId) throws SQLException {
        //System.out.println("add Controller 실행 ");
        ordersService.insert(dto, quantity, productId);
    }

    @GetMapping("/list")
    public List<OrdersDTO> listOrders() throws SQLException {
        List<OrdersDTO> list = ordersService.selectAll();
        System.out.println("controller 실행 : " +  list);
        return list;
    }

    @GetMapping("list/{orderId}")
    public List<OrderItemsDTO> listProducts(@PathVariable int orderId) throws SQLException {
        // 프론트에서 링크를 들어간다고 가정.. 해도 되려나
        List<OrderItemsDTO> itemList = ordersService.findByOrderId(orderId);
        return itemList;
    }

    @PutMapping("/update/{orderId}")
    public void orderUpdate(@PathVariable int orderId, @RequestBody OrdersDTO orderDto, OrderItemsDTO itemsDTO) throws SQLException {
        System.out.println("update 실행 " + orderId);
        orderDto.setOrderId(orderId);
        System.out.println("orderId : " + orderId);
        System.out.println("email : " + orderDto.getEmail());
        System.out.println("address : " + orderDto.getAddress());
        System.out.println("postCode : " + orderDto.getPostCode());
        ordersService.update(orderDto, itemsDTO);
    }

    @DeleteMapping("/delete/{orderId}")
    public void deleteOrder(@PathVariable int orderId) throws SQLException {
        ordersService.delete(orderId);
    }
}
