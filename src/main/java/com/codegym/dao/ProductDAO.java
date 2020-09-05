package com.codegym.dao;

import com.codegym.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/test?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String INSERT_PRODUCT_SQL = "INSERT INTO product" + "(id,type, name, brand, price, image, amount) VALUES" + "(?,?,?,?,?,?,?);";
    private static final String SELECT_PRODUCT_BY_ID = "select id,type,name,brand,price,image,amount from product where id = ?";
    private static final String SELECT_ALL_PRODUCT = "select * from product";
    private static final String DELETE_PRODUCT_SQL =  "delete from product where id = ?;";
    private static final String UPDATE_PRODUCT_SQL = "update product set type = ?, name = ?, brand = ?, price =?, image= ?, amount = ? where id= ?; ";
    private static final String GET_DETAIL_TV = "select overview, connection, smart_internet, image_sound_technology from tivi_detail where id = ?;";

    public ProductDAO() {
    }

    protected Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public void insertProduct(Product product) {
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)){
            preparedStatement.setString(1, product.getId());
            preparedStatement.setString(2, product.getType());
            preparedStatement.setString(3, product.getName());
            preparedStatement.setString(4, product.getBrand());
            preparedStatement.setInt(5, product.getPrice());
            preparedStatement.setString(6, product.getImage());
            preparedStatement.setInt(7, product.getAmount());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Product selectProduct(String id) {
        Product product = null;
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);){
            preparedStatement.setString(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String id1 = rs.getString("id");
                String type = rs.getString("type");
                String name = rs.getString("name");
                String brand = rs.getString("brand");
                int price = rs.getInt("price");
                String image = rs.getString("image");
                int amount = rs.getInt("amount");
                product = new Product(id1,type,name,brand,price,image,amount);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> selectAllProducts() {
        List<Product> product = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                String id = rs.getString("id");
                String type = rs.getString("type");
                String name = rs.getString("name");
                String brand = rs.getString("brand");
                int price = rs.getInt("price");
                String image = rs.getString("image");
                int amount = rs.getInt("amount");
                product.add(new Product(id,type,name,brand,price,image,amount));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean deleteProduct(String id) throws SQLException {
        boolean rowDeleted;
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_SQL);){
            preparedStatement.setString(1,id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        boolean rowUpdated;
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_SQL);) {

            preparedStatement.setString(1, product.getType());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setString(3, product.getBrand());
            preparedStatement.setInt(4, product.getPrice());
            preparedStatement.setString(5, product.getImage());
            preparedStatement.setInt(6, product.getAmount());
            preparedStatement.setString(7, product.getId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public List<String> getDetailOfTV(String id) {
        List<String> details = new ArrayList<>();
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_DETAIL_TV);) {
            preparedStatement.setString(1,id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String overview = "Tổng quan#" + rs.getString("overview");
                String connect = "Kết nối#" + rs.getString("connection");
                String smart_internet = "Smart TV/Internet TV#" + rs.getString("smart_internet");
                String tech = "Công nghệ âm thanh, hình ảnh#" + rs.getString("image_sound_technology");
                details.add(overview.replaceAll("<info>","==="));
                details.add(connect.replaceAll("<info>","==="));
                details.add(smart_internet.replaceAll("<info>","==="));
                details.add(tech.replaceAll("<info>","==="));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return details;
    }

}

