package com.codegym.controller.maincontroller;

import com.codegym.dao.ProductDAO;
import com.codegym.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MGServlet", urlPatterns = "/may-giat")
public class MGServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;

    public void init() {
        productDAO = new ProductDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";

        switch (action) {
            case "view":
                showDetailOfTL(request,response);
                break;
            default:
                showListOfTL(request,response);
                break;
        }
    }

    private void showDetailOfTL(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Product product = productDAO.selectProduct(id);
        List<String> details = productDAO.getDetailOfMG(id);

        request.setAttribute("product",product);
        request.setAttribute("details",details);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/main/product_detail.jsp");
        dispatcher.forward(request,response);
    }

    private void showListOfTL(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products;
        products = productDAO.getProductNewByType("may-giat",20);
        request.setAttribute("products",products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/main/may_giat.jsp");
        dispatcher.forward(request,response);
    }
}
