package com.backendjsp.controller;

import com.backendjsp.model.dao.CidadeDAO;
import com.backendjsp.model.dao.ComprovanteDAO;
import com.backendjsp.model.entity.Cidade;
import com.backendjsp.model.entity.Comprovante;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

@WebServlet(name = "ComprovanteServlet",urlPatterns = { "/views/comprovante-select",
        "/views/comprovante-insert", "/views/comprovante-edit","/views/comprovante-update", "/views/comprovante-delete" })
public class ComprovanteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action){
            case "/views/comprovante-select":
                select(request,response);
                break;
            case "/views/comprovante-delete":
                delete(request,response);
                break;
            case "/views/comprovante-edit":
                edit(request,response);
                break;
        }
    }

    protected void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Comprovante> comprovantes;
        ComprovanteDAO comprovanteDAO = new ComprovanteDAO();
        comprovantes = comprovanteDAO.getComprovantes();
        request.setAttribute("comprovantes", comprovantes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/comprovantes/cadastro-comprovante.jsp");
        dispatcher.forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ComprovanteDAO comprovanteDAO = new ComprovanteDAO();
        comprovanteDAO.deleteById(id);
        response.sendRedirect("./comprovante-select");
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ComprovanteDAO comprovanteDAO = new ComprovanteDAO();
        Comprovante comprovanteSelecionado = comprovanteDAO.getComprovanteById(id);

        request.setAttribute("comprovante", comprovanteSelecionado);

        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/comprovantes/editar-comprovante.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action){
            case "/views/comprovante-insert":
                insert(request,response);
                break;
            case "/views/comprovante-update":
                update(request,response);
                break;
        }
    }

    protected void insert(HttpServletRequest request,HttpServletResponse response) throws IOException {
        // recebendo os dados do formulario via parametro
        int id_registroaluguelquarto = Integer.parseInt(request.getParameter("id_registroaluguelquarto"));
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        int id_pacote = 0;
        if(request.getParameter("id_pacote") != "0" && request.getParameter("id_pacote") != ""){
            id_pacote = Integer.parseInt(request.getParameter("id_pacote"));
        }

        // criando o objeto contato
        Comprovante comprovante =  new Comprovante();

        // guardando os dados do formulario do objeto
        comprovante.setId_registroAluguel(id_registroaluguelquarto);
        comprovante.setId_usuario(id_usuario);
        comprovante.setId_pacote(id_pacote);

        // criando um objeto DAO para enviar o objeto Contato para o banco de dados
        // usando o método save da classe ContatoDAO
        ComprovanteDAO comprovanteDAO = new ComprovanteDAO();
        if(id_pacote == 0){
            comprovanteDAO.insert(comprovante);
        }else{
            comprovanteDAO.insertWithPacote(comprovante);
        }
        // Redirecionando o usuario para a pagina inicial da aplicação.
        response.sendRedirect("./comprovante-select");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int id_registroaluguelquarto = Integer.parseInt(request.getParameter("id_registroaluguelquarto"));
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        int id_pacote = 0;
        if(request.getParameter("id_pacote") != "0" && request.getParameter("id_pacote") != ""){
            id_pacote = Integer.parseInt(request.getParameter("id_pacote"));
        }

        // criando o objeto contato
        Comprovante comprovante =  new Comprovante();

        // guardando os dados do formulario do objeto
        comprovante.setId(id);
        comprovante.setId_registroAluguel(id_registroaluguelquarto);
        comprovante.setId_usuario(id_usuario);
        comprovante.setId_pacote(id_pacote);

        // criando um objeto DAO para enviar o objeto Contato para o banco de dados
        // usando o método save da classe ContatoDAO
        ComprovanteDAO comprovanteDAO = new ComprovanteDAO();
        if(id_pacote == 0){
            comprovanteDAO.updateById(comprovante);
        }else{
            comprovanteDAO.updateByIdWithIdPacote(comprovante);
        }

        // Redirecionando o usuario para a pagina inicial da aplicação.
        response.sendRedirect("./comprovante-select");
    }

}
