package com.backendjsp.controller;

import com.backendjsp.model.service.HerlivreServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/views/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HerlivreServiceImpl herlivreService = new HerlivreServiceImpl();
        int logado = herlivreService.login(email,password);

        HttpSession session = request.getSession(true);

        session.setAttribute("logado",logado);
        request.getRequestDispatcher("./components/header.jsp").forward(request,response);
    }
}
