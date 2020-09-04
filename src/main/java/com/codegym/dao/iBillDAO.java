package com.codegym.dao;

import com.codegym.model.Bill;

import java.sql.SQLException;
import java.util.List;

public interface iBillDAO {
    public void insertBill(Bill bill);

    public Bill selectBill(int bill_id) throws SQLException;

    public List<Bill> selectAllBill();

    public boolean updateBill(Bill bill);

    public boolean deleteBill(int id) throws SQLException;
}
