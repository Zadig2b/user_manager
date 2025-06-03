package com.example.usermanager.controller;

import com.example.usermanager.dao.UserDAO;
import com.example.usermanager.model.User;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
    private final UserDAO dao = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("delete".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            dao.delete(id);
            res.sendRedirect("users");
            return;
        }

        req.setAttribute("users", dao.listAll());
        req.getRequestDispatcher("/listUsers.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User user = new User();
        user.setName(req.getParameter("name"));
        user.setEmail(req.getParameter("email"));
        user.setPhone(req.getParameter("phone"));

        String dateStr = req.getParameter("dateNaissance");
        if (dateStr != null && !dateStr.isBlank()) {
            user.setDateNaissance(LocalDate.parse(dateStr));
        } else {
            user.setDateNaissance(LocalDate.of(4545, 8, 18));
        }

        dao.add(user);
        res.sendRedirect("users");
    }

}
