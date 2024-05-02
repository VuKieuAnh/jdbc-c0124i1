package org.example.jdbcc0124i1.controller;

import org.example.jdbcc0124i1.model.User;
import org.example.jdbcc0124i1.service.IUserDAO;
import org.example.jdbcc0124i1.service.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserController", urlPatterns = "/users")
public class UserController extends HttpServlet {
    private IUserDAO iUserDAO = new UserDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            showAllUser(req, resp);
        }
        else {
            switch (action){
                case "create":
                    showFormCreate(req, resp);
                    break;
            }
        }
    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("user/create.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showAllUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        goi tu service
        List<User> list =iUserDAO.selectAllUsers();
//                khai bao view
        RequestDispatcher dispatcher = req.getRequestDispatcher("user/list.jsp");
        req.setAttribute("listUser", list);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            showAllUser(req, resp);
        }
        else {
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String country = req.getParameter("country");
            User u = new User(name, email, country);
            try {
                iUserDAO.insertUser(u);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            showAllUser(req, resp);
        }
    }
}
