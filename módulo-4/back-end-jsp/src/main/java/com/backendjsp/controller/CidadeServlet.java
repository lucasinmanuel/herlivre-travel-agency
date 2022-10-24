package com.backendjsp.controller;

import com.backendjsp.model.dao.CidadeDAO;
import com.backendjsp.model.entity.Cidade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CidadeServlet",urlPatterns = { "/views/cidade-select",
        "/views/cidade-insert", "/views/cidade-edit","/views/cidade-update", "/views/cidade-delete" })
public class CidadeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action){
            case "/views/cidade-select":
                select(request,response);
                break;
            case "/views/cidade-delete":
                delete(request,response);
                break;
            case "/views/cidade-edit":
                edit(request,response);
                break;
        }
    }

    protected void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cidade> cidades;
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidades = cidadeDAO.getCidades();
        request.setAttribute("cidades", cidades);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/cidades/cadastro-cidade.jsp");
        dispatcher.forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.deleteById(id);
        response.sendRedirect("./cidade-select");
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        CidadeDAO cidadeDAO = new CidadeDAO();
        Cidade cidadeSelecionada = cidadeDAO.getCidadeById(id);

        request.setAttribute("cidade", cidadeSelecionada);

        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/cidades/editar-cidade.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action){
            case "/views/cidade-insert":
                insert(request,response);
                break;
            case "/views/cidade-update":
                update(request,response);
                break;
        }
    }

    protected void insert(HttpServletRequest request,HttpServletResponse response) throws IOException {

        // recebendo os dados do formulario via parametro
        String nome = request.getParameter("nome");
        String continente = request.getParameter("continente");
        String pais = request.getParameter("pais");
        String uf = request.getParameter("uf");

        // criando o objeto contato
        Cidade cidade =  new Cidade();

        // guardando os dados do formulario do objeto
        cidade.setNome(nome);
        cidade.setContinente(continente);
        cidade.setPais(pais);
        cidade.setUf(uf);

        // criando um objeto DAO para enviar o objeto Contato para o banco de dados
        // usando o método save da classe ContatoDAO
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.insert(cidade);

        // Redirecionando o usuario para a pagina inicial da aplicação.
        response.sendRedirect("./cidade-select");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String continente = request.getParameter("continente");
        String pais = request.getParameter("pais");
        String uf = request.getParameter("uf");

        Cidade cidade = new Cidade();
        cidade.setId(id);
        cidade.setNome(nome);
        cidade.setContinente(continente);
        cidade.setPais(pais);
        cidade.setUf(uf);

        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.updateById(cidade);
        response.sendRedirect("./cidade-select");
    }

}
