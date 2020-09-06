package com.codegym.dao.maindao;

import com.codegym.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HomeDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/test?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String GET_PRODUCT_NEW_BY_TYPE = "select * from product where type=? order by amount desc limit 6;";

    public HomeDAO() {
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

    public List<Product> getProductNewByType(String type) {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT_NEW_BY_TYPE);) {
            preparedStatement.setString(1,type);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String brand = rs.getString("brand");
                String image = rs.getString("image");
                int price = rs.getInt("price");
                int amount = rs.getInt("amount");
                products.add(new Product(id,type,name,brand,price,image,amount));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
