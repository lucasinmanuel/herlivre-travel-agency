package com.backendjsp.controller;

import com.backendjsp.model.dao.RegistroAluguelQuartoDAO;
import com.backendjsp.model.entity.RegistroAluguelQuarto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "RegistroAluguelQuartoServlet",urlPatterns = { "/views/registroaluguelquarto-select",
        "/views/registroaluguelquarto-insert", "/views/registroaluguelquarto-edit",
        "/views/registroaluguelquarto-update", "/views/registroaluguelquarto-delete" })
public class RegistroAluguelQuartoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action){
            case "/views/registroaluguelquarto-select":
                select(request,response);
                break;
            case "/views/registroaluguelquarto-delete":
                delete(request,response);
                break;
            case "/views/registroaluguelquarto-edit":
                edit(request,response);
                break;
        }
    }

    protected void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RegistroAluguelQuarto> registroAluguelQuarto;
        RegistroAluguelQuartoDAO registroAlguelQuartoDAO = new RegistroAluguelQuartoDAO();
        registroAluguelQuarto = registroAlguelQuartoDAO.getRegistroAlugueis();
        request.setAttribute("registroaluguelquarto", registroAluguelQuarto);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/registroaluguelquarto/cadastro-registroaluguelquarto.jsp");
        dispatcher.forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RegistroAluguelQuartoDAO registroAluguelQuartoDAO = new RegistroAluguelQuartoDAO();
        registroAluguelQuartoDAO.deleteById(id);
        response.sendRedirect("./registroaluguelquarto-select");
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RegistroAluguelQuartoDAO registroAluguelQuartoDAO = new RegistroAluguelQuartoDAO();
        RegistroAluguelQuarto registroAluguelQuartoSelecionado = registroAluguelQuartoDAO.getById(id);

        request.setAttribute("registro", registroAluguelQuartoSelecionado);

        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/registroaluguelquarto/editar-registroaluguelquarto.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action){
            case "/views/registroaluguelquarto-insert":
                try {
                    insert(request,response);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/views/registroaluguelquarto-update":
                try {
                    update(request,response);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    protected void insert(HttpServletRequest request,HttpServletResponse response) throws IOException, ParseException {
        // recebendo os dados do formulario via parametro
        int id_quarto = Integer.parseInt(request.getParameter("id_quarto"));
        Date entrada = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("entrada"));
        Date saida = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("saida"));

        // criando o objeto contato
        RegistroAluguelQuarto registroAluguelQuarto =  new RegistroAluguelQuarto();

        // guardando os dados do formulario do
        registroAluguelQuarto.setId_quarto(id_quarto);
        registroAluguelQuarto.setEntrada(entrada);
        registroAluguelQuarto.setSaida(saida);

        // criando um objeto DAO para enviar o objeto Contato para o banco de dados
        // usando o método save da classe ContatoDAO
        RegistroAluguelQuartoDAO registroAluguelQuartoDAO = new RegistroAluguelQuartoDAO();
        registroAluguelQuartoDAO.insert(registroAluguelQuarto);

        // Redirecionando o usuario para a pagina inicial da aplicação.
        response.sendRedirect("./registroaluguelquarto-select");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
        int id = Integer.parseInt(request.getParameter("id"));
        int id_quarto = Integer.parseInt(request.getParameter("id_quarto"));
        Date entrada = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("entrada"));
        Date saida = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("saida"));

        // criando o objeto contato
        RegistroAluguelQuarto registroAluguelQuarto =  new RegistroAluguelQuarto();

        // guardando os dados do formulario do
        registroAluguelQuarto.setId(id);
        registroAluguelQuarto.setId_quarto(id_quarto);
        registroAluguelQuarto.setEntrada(entrada);
        registroAluguelQuarto.setSaida(saida);

        // criando um objeto DAO para enviar o objeto Contato para o banco de dados
        // usando o método save da classe ContatoDAO
        RegistroAluguelQuartoDAO registroAluguelQuartoDAO = new RegistroAluguelQuartoDAO();
        registroAluguelQuartoDAO.updateById(registroAluguelQuarto);

        // Redirecionando o usuario para a pagina inicial da aplicação.
        response.sendRedirect("./registroaluguelquarto-select");
    }

}
