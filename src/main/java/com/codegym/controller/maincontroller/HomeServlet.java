package com.codegym.controller.maincontroller;

import com.codegym.dao.BillDAO;
import com.codegym.dao.ProductDAO;
import com.codegym.dao.UserDAO;
import com.codegym.dao.maindao.HomeDAO;
import com.codegym.model.Bill;
import com.codegym.model.Product;
import com.codegym.model.User;

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

@WebServlet(name = "HomeServlet",urlPatterns = "")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;
    private UserDAO userDAO;
    private BillDAO billDAO;

    public void init() {
        productDAO = new ProductDAO();
        userDAO = new UserDAO();
        billDAO = new BillDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) action = "";
        try {
            switch (action) {
                case "purchase":
                    purchaseProduct(request,response);
                    break;
                default:
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void purchaseProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String customer_name = request.getParameter("customer-name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address")
                        + ", " + request.getParameter("district")
                        + ", " + request.getParameter("city");
        User user = new User(phone,customer_name,email,address);
        if (!userDAO.updateUser(user)) {
            userDAO.insertUser(user);
        }

        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        String create_date = String.valueOf(date);
        String ship_address = request.getParameter("ship-address");

        Bill bill = new Bill(phone,create_date,ship_address,"Waiting confirm");
        billDAO.insertBill(bill);

        int bill_id = billDAO.getNewBillOfCustomer(phone);
        String productID = request.getParameter("productID");
        int amount = Integer.parseInt(request.getParameter("amount"));
        int price = Integer.parseInt(request.getParameter("price"));
        billDAO.insertBillDetail(bill_id,productID,price,amount);

        String message = "Đơn hàng của bạn đang được xử lý";
        request.setAttribute("message",message);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) action = "";
        switch (action) {
            case "purchase":
                showPurchaseForm(request,response);
                break;
            default:
                showNewProducts(request,response);
                break;
        }

    }

    private void showPurchaseForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Product product = productDAO.selectProduct(id);
        int amount = Integer.parseInt(request.getParameter("buyAmount"));

        request.setAttribute("product",product);
        request.setAttribute("amount", amount);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/main/purchase.jsp");
        dispatcher.forward(request,response);
    }

    private void showNewProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list_TV = productDAO.getProductNewByType("tivi",6);
        List<Product> list_TL = productDAO.getProductNewByType("tu-lanh",6);
        List<Product> list_DH = productDAO.getProductNewByType("dieu-hoa-nhiet-do",6);
        List<Product> list_MG = productDAO.getProductNewByType("may-giat",6);
        request.setAttribute("list_TV",list_TV);
        request.setAttribute("list_TL",list_TL);
        request.setAttribute("list_DH",list_DH);
        request.setAttribute("list_MG",list_MG);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request,response);
    }
}
