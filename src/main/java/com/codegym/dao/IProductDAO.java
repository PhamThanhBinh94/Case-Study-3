package com.codegym.dao;

import com.codegym.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    public void insertProduct(Product product);

    public Product selectProduct(String id) throws SQLException;

    public List<Product> selectAllProducts();

    public boolean deleteProduct(String id) throws SQLException;

    public boolean updateProduct(Product product) throws SQLException;
}
