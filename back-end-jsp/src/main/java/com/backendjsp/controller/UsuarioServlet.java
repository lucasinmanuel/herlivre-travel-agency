package com.backendjsp.controller;

import com.backendjsp.model.dao.UsuarioDAO;
import com.backendjsp.model.entity.Usuario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UsuarioServlet",urlPatterns = { "/views/usuario-select",
        "/views/usuario-insert", "/views/usuario-edit","/views/usuario-update", "/views/usuario-delete" })
public class UsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action){
            case "/views/usuario-select":
                select(request,response);
                break;
            case "/views/usuario-delete":
                delete(request,response);
                break;
            case "/views/usuario-edit":
                edit(request,response);
                break;
        }
    }

    protected void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Usuario> usuarios;
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarios = usuarioDAO.getUsuarios();
        request.setAttribute("usuarios", usuarios);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/usuarios/cadastro-usuario.jsp");
        dispatcher.forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.deleteById(id);
        response.sendRedirect("./usuario-select");
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioSelecionado = usuarioDAO.getUsuarioById(id);

        request.setAttribute("usuario", usuarioSelecionado);

        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/usuarios/editar-usuario.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action){
            case "/views/usuario-insert":
                insert(request,response);
                break;
            case "/views/usuario-update":
                update(request,response);
                break;
        }
    }

    protected void insert(HttpServletRequest request,HttpServletResponse response) throws IOException {

        // recebendo os dados do formulario via parametro
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        // criando o objeto contato
        Usuario usuario =  new Usuario();

        // guardando os dados do formulario do objeto
        usuario.setNome(nome);
        usuario.setCpf(cpf);;
        usuario.setEmail(email);
        usuario.setPassword(senha);

        // criando um objeto DAO para enviar o objeto Contato para o banco de dados
        // usando o método save da classe ContatoDAO
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.insert(usuario);

        // Redirecionando o usuario para a pagina inicial da aplicação.
        response.sendRedirect("./usuario-select");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        // criando o objeto contato
        Usuario usuario =  new Usuario();

        // guardando os dados do formulario do objeto
        usuario.setId(id);
        usuario.setNome(nome);
        usuario.setCpf(cpf);;
        usuario.setEmail(email);
        usuario.setPassword(senha);

        // criando um objeto DAO para enviar o objeto Contato para o banco de dados
        // usando o método save da classe ContatoDAO
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.updateById(usuario);

        // Redirecionando o usuario para a pagina inicial da aplicação.
        response.sendRedirect("./usuario-select");
    }

}
