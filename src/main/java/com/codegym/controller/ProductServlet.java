package com.codegym.controller;

import com.codegym.dao.ProductDAO;
import com.codegym.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;

    public void init() {
        productDAO = new ProductDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertProduct(request, response);
                    break;
                case "edit":
                    updateProduct(request, response);
                    break;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        String type = request.getParameter("type");
        String name = request.getParameter("name");
        String brand = request.getParameter("brand");
        int price = Integer.parseInt(request.getParameter("price"));
        String image = request.getParameter("image");
        int amount = Integer.parseInt(request.getParameter("amount"));
        Product product = new Product(id,type, name, brand, price, image, amount);
        productDAO.updateProduct(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/product/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String type = request.getParameter("type");
        String name = request.getParameter("name");
        String brand = request.getParameter("brand");
        int price = Integer.parseInt(request.getParameter("price"));
        String image = request.getParameter("image");
        int amount = Integer.parseInt(request.getParameter("amount"));
        Product newProduct = new Product(id,type, name, brand, price, image, amount);
        productDAO.insertProduct(newProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/product/create.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteProduct(request, response);
                    break;
                case "view":
                    showProductDetail(request,response);
                    break;
                default:
                    listProduct(request, response);
                    break;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void showProductDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Product product = productDAO.selectProduct(id);
        List<String> details = new ArrayList<>();
        if (product.getType().equals("tivi")) {
            details = productDAO.getDetailOfTV(id);
        } else if (product.getType().equals("dieu-hoa-nhiet-do")) {
            details = productDAO.getDetailOfDH(id);
        } else if (product.getType().equals("tu-lanh")) {
            details = productDAO.getDetailOfTL(id);
        } else if (product.getType().equals("may-giat")) {
            details = productDAO.getDetailOfMG(id);
        }

        request.setAttribute("product",product);
        request.setAttribute("details",details);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/product/product_detail.jsp");
        dispatcher.forward(request,response);
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        List<Product> listProduct = new ArrayList<>();
        if (type == null){
            type ="";
        }
        switch (type){
            case "tivi":
                listProduct = productDAO.selectProductByType(type);
                break;
            case "tu-lanh":
                listProduct = productDAO.selectProductByType(type);
                break;
            case "dieu-hoa-nhiet-do":
                listProduct = productDAO.selectProductByType(type);
                break;
            case "may-giat":
                listProduct = productDAO.selectProductByType(type);
                break;
            default:
                listProduct = productDAO.selectAllProducts();
                break;
        }
        List<Product> list = new ArrayList<>();
        for(int i=0; i<10;i++ ){
            list.add(listProduct.get(i));
        }
        request.setAttribute("listProduct", listProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/product/list.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        productDAO.deleteProduct(id);
        List<Product> listProduct = productDAO.selectAllProducts();
        request.setAttribute("listProduct", listProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/product/list.jsp");
        dispatcher.forward(request,response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Product exitingProduct = productDAO.selectProduct(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/product/edit.jsp");
        request.setAttribute("product", exitingProduct);
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/product/create.jsp");
        dispatcher.forward(request, response);
    }

}
