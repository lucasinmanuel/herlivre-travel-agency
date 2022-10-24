package com.backendjsp.controller;

import com.backendjsp.model.dao.QuartoDAO;
import com.backendjsp.model.entity.Quarto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QuartoServlet",urlPatterns = { "/views/quarto-select",
        "/views/quarto-insert", "/views/quarto-edit","/views/quarto-update", "/views/quarto-delete" })
public class QuartoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action){
            case "/views/quarto-select":
                select(request,response);
                break;
            case "/views/quarto-delete":
                delete(request,response);
                break;
            case "/views/quarto-edit":
                edit(request,response);
                break;
        }
    }

    protected void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Quarto> quartos;
        QuartoDAO quartoDAO = new QuartoDAO();
        quartos = quartoDAO.getQuartos();
        request.setAttribute("quartos", quartos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/quartos/cadastro-quarto.jsp");
        dispatcher.forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        QuartoDAO quartoDAO = new QuartoDAO();
        quartoDAO.deleteById(id);
        response.sendRedirect("./quarto-select");
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        QuartoDAO quartoDAO = new QuartoDAO();
        Quarto quartoSelecionado = quartoDAO.getQuartoById(id);

        request.setAttribute("quarto", quartoSelecionado);

        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/quartos/editar-quarto.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action){
            case "/views/quarto-insert":
                insert(request,response);
                break;
            case "/views/quarto-update":
                update(request,response);
                break;
        }
    }

    protected void insert(HttpServletRequest request,HttpServletResponse response) throws IOException {
        // recebendo os dados do formulario via parametro
        int id_hotel = Integer.parseInt(request.getParameter("id_hotel"));
        int numero = Integer.parseInt(request.getParameter("numero"));
        double valor = Double.parseDouble(request.getParameter("valor"));
        int diaria = Integer.parseInt(request.getParameter("diaria"));
        int qtd_camas = Integer.parseInt(request.getParameter("qtd_camas"));
        String tipo = request.getParameter("tipo");

        // criando o objeto contato
        Quarto quarto =  new Quarto();

        // guardando os dados do formulario do
        quarto.setId_hotel(id_hotel);
        quarto.setNumero(numero);
        quarto.setValor(valor);
        quarto.setDiaria(diaria);
        quarto.setQtd_camas(qtd_camas);
        quarto.setTipo(tipo);

        // criando um objeto DAO para enviar o objeto Contato para o banco de dados
        // usando o método save da classe ContatoDAO
        QuartoDAO quartoDAO = new QuartoDAO();
        quartoDAO.insert(quarto);

        // Redirecionando o usuario para a pagina inicial da aplicação.
        response.sendRedirect("./quarto-select");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        // recebendo os dados do formulario via parametro
        int id_hotel = Integer.parseInt(request.getParameter("id_hotel"));
        int numero = Integer.parseInt(request.getParameter("numero"));
        double valor = Double.parseDouble(request.getParameter("valor"));
        int diaria = Integer.parseInt(request.getParameter("diaria"));
        int qtd_camas = Integer.parseInt(request.getParameter("qtd_camas"));
        String tipo = request.getParameter("tipo");

        // criando o objeto contato
        Quarto quarto =  new Quarto();

        // guardando os dados do formulario do
        quarto.setId(id);
        quarto.setId_hotel(id_hotel);
        quarto.setNumero(numero);
        quarto.setValor(valor);
        quarto.setDiaria(diaria);
        quarto.setQtd_camas(qtd_camas);
        quarto.setTipo(tipo);

        // criando um objeto DAO para enviar o objeto Contato para o banco de dados
        // usando o método save da classe ContatoDAO
        QuartoDAO quartoDAO = new QuartoDAO();
        quartoDAO.updateById(quarto);

        // Redirecionando o usuario para a pagina inicial da aplicação.
        response.sendRedirect("./quarto-select");
    }

}
