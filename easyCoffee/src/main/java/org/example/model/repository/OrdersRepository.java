package org.example.model.repository;

import org.apache.ibatis.annotations.Mapper;
import org.example.model.dto.OrdersDTO;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface OrdersRepository {

    int insert(OrdersDTO dto) throws SQLException;
    List<OrdersDTO> selectAll()throws SQLException;

    int update(OrdersDTO dto)throws SQLException;
    void delete(int id)throws SQLException;
}
