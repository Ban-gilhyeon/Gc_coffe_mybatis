package org.example.model.service;

import org.example.model.dto.OrderItemsDTO;
import org.example.model.dto.OrdersDTO;
import org.example.model.dto.ProductsDTO;
import org.example.model.repository.OrderItemsRepository;
import org.example.model.repository.OrdersRepository;
import org.example.model.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrdersService {
    @Autowired
    OrdersRepository orderRepo;
    @Autowired
    OrderItemsRepository itemsRepo;
    @Autowired
    ProductsRepository productRepo;

    @Transactional
    public void insert(OrdersDTO order, int quantity, int productId) throws SQLException {
        System.out.println("Order Service 실행 ");

        LocalDateTime now = LocalDateTime.now();
        order.setCreated_at(now);
        order.setMyOrderStatus(now);

        // 상품 정보 가져오기
        ProductsDTO product = productRepo.findById(productId);
        System.out.println("product 테이블 findById 실행: " + product.toString());

        // 주문 삽입 (orderId 자동 생성)
        if(orderRepo.insert(order) == 1){
            // orderId 값 확인
            System.out.println("Order 삽입 성공, orderId: " + order.getOrderId());

            // order_items 삽입 준비
            OrderItemsDTO item = new OrderItemsDTO();
            item.setOrderId(order.getOrderId());
            item.setProductId(productId);
            item.setQuantity(quantity);
            item.setPrice(product.getPrice() * quantity);
            item.setCreated_at(now);
            item.setCategory(product.getCategory());

            System.out.println("OrderItem 삽입: " + item.toString());
            itemsRepo.insert(item);
        } else {
            throw new SQLException("Order 삽입 실패");
        }
    }

    public List<OrdersDTO> selectAll() throws SQLException {
        return orderRepo.selectAll();
    }

    public List<OrderItemsDTO> findByOrderId(int orderId) throws SQLException {
        // order 테이블의 상세 리스트 ..
        return itemsRepo.findByOrderId(orderId);
    }

    public void update(OrdersDTO ordersDTO, OrderItemsDTO itemsDTO) throws SQLException {
        LocalDateTime now = LocalDateTime.now();
        ordersDTO.setUpdated_at(now);
        ordersDTO.setMyOrderStatus(now);
        if(orderRepo.update(ordersDTO) == 1){
            itemsDTO.setUpdated_at(now);
            itemsRepo.update(itemsDTO);
        }
    }

    public void delete(int order_id)throws SQLException {
        orderRepo.delete(order_id);
        itemsRepo.delete(order_id);
    }
}
