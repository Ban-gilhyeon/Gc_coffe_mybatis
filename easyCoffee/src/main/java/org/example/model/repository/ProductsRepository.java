package org.example.model.repository;

import org.apache.ibatis.annotations.Mapper;
import org.example.model.dto.ProductsDTO;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface ProductsRepository {

    void insert(ProductsDTO dto) throws SQLException;
    List<ProductsDTO> selectAll() throws SQLException;
    ProductsDTO findById(int id) throws SQLException;

    void update(ProductsDTO dto) throws SQLException;
    void delete(int id) throws SQLException;
}
