package com.codegym.dao;

import com.codegym.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public void insertUser(User user) throws SQLException;

    public User selectUser(String phone);

    public List<User> selectAllUsers();

//    public boolean deleteUser(String phone) throws SQLException;
//
//    public boolean updateUser(User user) throws SQLException;
}
