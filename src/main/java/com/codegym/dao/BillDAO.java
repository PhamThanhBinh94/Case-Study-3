package com.codegym.dao;

import com.codegym.model.Bill;

import java.sql.*;
import java.util.List;

public class BillDAO implements iBillDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/test?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String INSERT_BILL_SQL = "insert into bill(customer_id, create_date, address, status) " + "values(?,?,?,?);";
    private static final String SELECT_BILL_BY_ID = "select bill_id, customer_id, create_date, address, status from bill where id = ?;";

    public BillDAO(){
    }

    protected Connection getConnection() {
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
    public void insertBill(Bill bill) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BILL_SQL);) {
            preparedStatement.setString(1,bill.getCustomer_id());
            preparedStatement.setString(1,bill.getCreate_date());
            preparedStatement.setString(1,bill.getAddress());
            preparedStatement.setString(1,bill.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Bill selectBill(int bill_id) throws SQLException {
        Bill bill = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BILL_BY_ID);) {
            preparedStatement.setInt(1,bill_id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String customer_id = rs.getString("customer_id");
                String create_date = rs.getString("create_date");
                String address = rs.getString("address");
                String status = rs.getString("status");
                bill = new Bill(bill_id,customer_id,create_date,address,status);
            }
        }
        return bill;
    }

    @Override
    public List<Bill> selectAllBill() {
        return null;
    }

    @Override
    public boolean updateBill(Bill bill) {
        return false;
    }

    @Override
    public boolean deleteBill(int id) throws SQLException {
        return false;
    }
}
