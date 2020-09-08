package com.codegym.controller;

import com.codegym.dao.UserDAO;
import com.codegym.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet",urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public void init(){
        userDAO = new UserDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,  IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        try {
            switch (action){
                case "create":
                        insertUser(request,response);
                    break;
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String phone = request.getParameter("phone");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        User newUser = new User(phone,name,email,address);
        userDAO.insertUser(newUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/create.jsp");
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        try {
            switch (action){
                case "create":
                    showNewForm(request,response);
                    break;
                default:
                    listUser(request,response);
                    break;
            }
        } finally {

        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> listUser = userDAO.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/create.jsp");
        dispatcher.forward(request,response);
    }
}
