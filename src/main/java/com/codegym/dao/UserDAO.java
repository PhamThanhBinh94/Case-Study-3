package com.codegym.dao;

import com.codegym.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO{
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    private static final String INSERT_USERS_SQL = "INSERT INTO customer"  + "values" +"(?,?,?,?);";
    private static final String SELECT_USER_BY_PHONE = "select * from customer where phone = ?;";
    private static final String SELECT_ALL_USER = "select * from customer where phone = ?;";

    protected Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public void insertUser(User user) throws SQLException {
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);){
            preparedStatement.setString(1,user.getPhone());
            preparedStatement.setString(2,user.getName());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.setString(4,user.getAddress());

            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public User selectUser(String phone) {
        User user = null;
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_PHONE);) {
            preparedStatement.setString(1,phone);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                String phone1 = rs.getString("phone");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                user = new User(phone1,name,email,address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String phone = rs.getString("phone");
                String name = rs.getString("phone");
                String email = rs.getString("phone");
                String address = rs.getString("phone");
                users.add(new User(phone,name,email,address));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }
}
