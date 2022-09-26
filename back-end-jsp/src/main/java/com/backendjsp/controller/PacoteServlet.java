package com.backendjsp.controller;

import com.backendjsp.model.dao.PacoteDAO;
import com.backendjsp.model.entity.Pacote;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PacoteServlet",urlPatterns = { "/views/pacote-select",
        "/views/pacote-insert", "/views/pacote-edit","/views/pacote-update", "/views/pacote-delete" })
public class PacoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action){
            case "/views/pacote-select":
                select(request,response);
                break;
            case "/views/pacote-delete":
                delete(request,response);
                break;
            case "/views/pacote-edit":
                edit(request,response);
                break;
        }
    }

    protected void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pacote> pacotes;
        PacoteDAO pacoteDAO = new PacoteDAO();
        pacotes = pacoteDAO.getPacotes();
        request.setAttribute("pacotes", pacotes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/pacotes/cadastro-pacote.jsp");
        dispatcher.forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        PacoteDAO pacoteDAO = new PacoteDAO();
        pacoteDAO.deleteById(id);
        response.sendRedirect("./pacote-select");
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        PacoteDAO pacoteDAO = new PacoteDAO();
        Pacote pacoteSelecionado = pacoteDAO.getPacotesById(id);

        request.setAttribute("pacote", pacoteSelecionado);

        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/pacotes/editar-pacote.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action){
            case "/views/pacote-insert":
                insert(request,response);
                break;
            case "/views/pacote-update":
                update(request,response);
                break;
        }
    }

    protected void insert(HttpServletRequest request,HttpServletResponse response) throws IOException {
        // recebendo os dados do formulario via parametro
        int id_voo = Integer.parseInt(request.getParameter("id_voo"));
        int id_voo2 = 0;
        if(request.getParameter("id_voo2") != "0" && request.getParameter("id_voo2") != "") {
            id_voo2 = Integer.parseInt(request.getParameter("id_voo2"));
        }
        int id_registroaluguelquarto = Integer.parseInt(request.getParameter("id_registroaluguelquarto"));
        int total_pessoas = Integer.parseInt(request.getParameter("total_pessoas"));
        double valor_original = Double.parseDouble(request.getParameter("valor_original"));
        int desconto = 0;
        if(request.getParameter("desconto") != "") {
            desconto = Integer.parseInt(request.getParameter("desconto"));
        }
        double valor_promocional = Double.parseDouble(request.getParameter("valor_promocional"));

        // criando o objeto contato
        Pacote pacote =  new Pacote();

        // guardando os dados do formulario do objeto
        pacote.setId_voo(id_voo);
        pacote.setId_voo2(id_voo2);
        pacote.setId_registroaluguelquarto(id_registroaluguelquarto);
        pacote.setTotal_pessoas(total_pessoas);
        pacote.setValor_original(valor_original);
        pacote.setDesconto(desconto);
        pacote.setValor_promocional(valor_promocional);

        // criando um objeto DAO para enviar o objeto Contato para o banco de dados
        // usando o método save da classe ContatoDAO
        PacoteDAO pacoteDAO = new PacoteDAO();

        pacoteDAO.insert(pacote);
        // Redirecionando o usuario para a pagina inicial da aplicação.
        response.sendRedirect("./pacote-select");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int id_voo = Integer.parseInt(request.getParameter("id_voo"));
        int id_voo2 = 0;
        if(request.getParameter("id_voo2") != "0" && request.getParameter("id_voo2") != "") {
                id_voo2 = Integer.parseInt(request.getParameter("id_voo2"));
        }
        int id_registroaluguelquarto = Integer.parseInt(request.getParameter("id_registroaluguelquarto"));
        int total_pessoas = Integer.parseInt(request.getParameter("total_pessoas"));
        double valor_original = Double.parseDouble(request.getParameter("valor_original"));
        int desconto = 0;
        if(request.getParameter("desconto") != "") {
            desconto = Integer.parseInt(request.getParameter("desconto"));
        }
        double valor_promocional = Double.parseDouble(request.getParameter("valor_promocional"));

        // criando o objeto contato
        Pacote pacote =  new Pacote();

        // guardando os dados do formulario do objeto
        pacote.setId(id);
        pacote.setId_voo(id_voo);
        pacote.setId_voo2(id_voo2);
        pacote.setId_registroaluguelquarto(id_registroaluguelquarto);
        pacote.setTotal_pessoas(total_pessoas);
        pacote.setValor_original(valor_original);
        pacote.setDesconto(desconto);
        pacote.setValor_promocional(valor_promocional);

        // criando um objeto DAO para enviar o objeto Contato para o banco de dados
        // usando o método save da classe ContatoDAO
        PacoteDAO pacoteDAO = new PacoteDAO();
        pacoteDAO.updateById(pacote);

        // Redirecionando o usuario para a pagina inicial da aplicação.
        response.sendRedirect("./pacote-select");
    }

}
