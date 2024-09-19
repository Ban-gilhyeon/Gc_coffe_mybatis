package org.example.model.service;

import org.example.model.dto.ProductsDTO;
import org.example.model.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository repo;

    public void insert(ProductsDTO dto) throws SQLException {
        repo.insert(dto);
    }

    public List<ProductsDTO> findAll() throws SQLException {
        return repo.selectAll();
    }

    public ProductsDTO findById(int id) throws SQLException {
        return repo.findById(id);
    }

    public void update(ProductsDTO dto) throws SQLException {
        dto.getUpdated_at();
        repo.update(dto);
    }

    public void delete(int id) throws SQLException {
        repo.delete(id);
    }
}
