package com.backendjsp.controller;

import com.backendjsp.model.dao.VooDAO;
import com.backendjsp.model.entity.Voo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "VooServlet",urlPatterns = { "/views/voo-select",
        "/views/voo-insert", "/views/voo-edit","/views/voo-update", "/views/voo-delete" })
public class VooServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action){
            case "/views/voo-select":
                select(request,response);
                break;
            case "/views/voo-delete":
                delete(request,response);
                break;
            case "/views/voo-edit":
                edit(request,response);
                break;
        }
    }

    protected void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Voo> voos;
        VooDAO vooDAO = new VooDAO();
        voos = vooDAO.getVoos();
        request.setAttribute("voos", voos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/voos/cadastro-voo.jsp");
        dispatcher.forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        VooDAO vooDAO = new VooDAO();
        vooDAO.deleteById(id);
        response.sendRedirect("./voo-select");
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        VooDAO vooDAO = new VooDAO();
        Voo vooSelecionado = vooDAO.getVoosById(id);

        request.setAttribute("voo", vooSelecionado);

        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/voos/editar-voo.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action){
            case "/views/voo-insert":
                try {
                    insert(request,response);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/views/voo-update":
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
        int id_cidade = Integer.parseInt(request.getParameter("id_cidade"));
        String ponto_partida = request.getParameter("ponto_partida");
        String companhia = request.getParameter("companhia");
        String num_voo = request.getParameter("num_voo");
        String num_assento = request.getParameter("num_assento");
        int qtd_assentos_disp = Integer.parseInt(request.getParameter("qtd_assentos_disp"));
        Date data_partida = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data_partida"));
        Date data_chegada = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data_chegada"));

        // criando o objeto contato
        Voo voo =  new Voo();

        // guardando os dados do formulario do objeto
        voo.setId_cidade(id_cidade);
        voo.setPonto_partida(ponto_partida);
        voo.setCompanhia(companhia);
        voo.setNum_voo(num_voo);
        voo.setNum_assento(num_assento);
        voo.setQtd_assentos_disp(qtd_assentos_disp);
        voo.setData_partida(data_partida);
        voo.setData_chegada(data_chegada);

        // criando um objeto DAO para enviar o objeto Contato para o banco de dados
        // usando o método save da classe ContatoDAO
        VooDAO vooDAO = new VooDAO();
        vooDAO.insert(voo);

        // Redirecionando o usuario para a pagina inicial da aplicação.
        response.sendRedirect("./voo-select");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
        int id = Integer.parseInt(request.getParameter("id"));
        int id_cidade = Integer.parseInt(request.getParameter("id_cidade"));
        String ponto_partida = request.getParameter("ponto_partida");
        String companhia = request.getParameter("companhia");
        String num_voo = request.getParameter("num_voo");
        String num_assento = request.getParameter("num_assento");
        int qtd_assentos_disp = Integer.parseInt(request.getParameter("qtd_assentos_disp"));
        System.out.println(request.getParameter("data_partida"));
        Date data_partida = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data_partida"));
        Date data_chegada = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data_chegada"));

        // criando o objeto contato
        Voo voo =  new Voo();

        // guardando os dados do formulario do objeto
        voo.setId(id);
        voo.setId_cidade(id_cidade);
        voo.setPonto_partida(ponto_partida);
        voo.setCompanhia(companhia);
        voo.setNum_voo(num_voo);
        voo.setNum_assento(num_assento);
        voo.setQtd_assentos_disp(qtd_assentos_disp);
        voo.setData_partida(data_partida);
        voo.setData_chegada(data_chegada);

        // criando um objeto DAO para enviar o objeto Contato para o banco de dados
        // usando o método save da classe ContatoDAO
        VooDAO vooDAO = new VooDAO();
        vooDAO.updateById(voo);

        // Redirecionando o usuario para a pagina inicial da aplicação.
        response.sendRedirect("./voo-select");
    }

}
