package com.codegym.controller;

import com.codegym.dao.ProductDAO;
import com.codegym.model.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "ProductServlet")
public class ProductServlet extends javax.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;

    public void init(){
        productDAO = new ProductDAO();
    }
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action ="";
        };
        switch (action){
            case "create":
                insertProduct(request,response);
                break;
            case "edit":
                updateProduct(request,response);
                break;
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) {
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        };
        switch (action){
            case "create":
                showNewForm(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            default:
                listProduct(request,response);
                break;
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
    }
}
