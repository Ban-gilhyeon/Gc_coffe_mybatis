package org.example.model.repository;

import org.apache.ibatis.annotations.Mapper;
import org.example.model.dto.OrderItemsDTO;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface OrderItemsRepository {

    void insert(OrderItemsDTO dto)throws SQLException;
    int delete(int id)throws SQLException;
    int update(OrderItemsDTO dto)throws SQLException;
    List<OrderItemsDTO> findByOrderId(int order_id) throws SQLException;
}
