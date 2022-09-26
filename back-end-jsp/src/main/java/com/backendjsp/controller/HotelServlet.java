package com.backendjsp.controller;

import com.backendjsp.model.dao.HotelDAO;
import com.backendjsp.model.entity.Hotel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HotelServlet",urlPatterns = { "/views/hotel-select",
        "/views/hotel-insert", "/views/hotel-edit","/views/hotel-update", "/views/hotel-delete" })
public class HotelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action){
            case "/views/hotel-select":
                select(request,response);
                break;
            case "/views/hotel-delete":
                delete(request,response);
                break;
            case "/views/hotel-edit":
                edit(request,response);
                break;
        }
    }

    protected void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Hotel> hoteis;
        HotelDAO hotelDAO = new HotelDAO();
        hoteis = hotelDAO.getHoteis();
        request.setAttribute("hoteis", hoteis);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/hoteis/cadastro-hotel.jsp");
        dispatcher.forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HotelDAO hotelDAO = new HotelDAO();
        hotelDAO.deleteById(id);
        response.sendRedirect("./hotel-select");
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
       HotelDAO hotelDAO = new HotelDAO();
        Hotel hotelSelecionado = hotelDAO.getHotelById(id);

        request.setAttribute("hotel", hotelSelecionado);

        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/hoteis/editar-hotel.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action){
            case "/views/hotel-insert":
                insert(request,response);
                break;
            case "/views/hotel-update":
                update(request,response);
                break;
        }
    }

    protected void insert(HttpServletRequest request,HttpServletResponse response) throws IOException {

        // recebendo os dados do formulario via parametro
        int id_cidade = Integer.parseInt(request.getParameter("id_cidade"));
        String nome = request.getParameter("nome");
        int qtd_estrelas = Integer.parseInt(request.getParameter("qtd_estrelas"));
        double valor_min = Double.parseDouble(request.getParameter("valor_min"));
        boolean wifi = Boolean.parseBoolean(request.getParameter("wifi"));
        boolean cafe_manha = Boolean.parseBoolean(request.getParameter("cafe_manha"));
        String cep = request.getParameter("cep");
        String logradouro = request.getParameter("logradouro");
        String bairro = request.getParameter("bairro");

        // criando o objeto contato
        Hotel hotel =  new Hotel();

        // guardando os dados do formulario do
        hotel.setId_cidade(id_cidade);
        hotel.setNome(nome);
        hotel.setQtd_estrelas(qtd_estrelas);
        hotel.setValor_min(valor_min);
        hotel.setWifi(wifi);
        hotel.setCafe_manha(cafe_manha);
        hotel.setCep(cep);
        hotel.setLogradouro(logradouro);
        hotel.setBairro(bairro);

        // criando um objeto DAO para enviar o objeto Contato para o banco de dados
        // usando o método save da classe ContatoDAO
        HotelDAO hotelDAO = new HotelDAO();
        hotelDAO.insert(hotel);

        // Redirecionando o usuario para a pagina inicial da aplicação.
        response.sendRedirect("./hotel-select");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int id_cidade = Integer.parseInt(request.getParameter("id_cidade"));
        String nome = request.getParameter("nome");
        int qtd_estrelas = Integer.parseInt(request.getParameter("qtd_estrelas"));
        double valor_min = Double.parseDouble(request.getParameter("valor_min"));
        boolean wifi = Boolean.parseBoolean(request.getParameter("wifi"));
        boolean cafe_manha = Boolean.parseBoolean(request.getParameter("cafe_manha"));
        String cep = request.getParameter("cep");
        String logradouro = request.getParameter("logradouro");
        String bairro = request.getParameter("bairro");

        Hotel hotel = new Hotel();

        hotel.setId(id);
        hotel.setId_cidade(id_cidade);
        hotel.setNome(nome);
        hotel.setQtd_estrelas(qtd_estrelas);
        hotel.setValor_min(valor_min);
        hotel.setWifi(wifi);
        hotel.setCafe_manha(cafe_manha);
        hotel.setCep(cep);
        hotel.setLogradouro(logradouro);
        hotel.setBairro(bairro);

        HotelDAO hotelDAO = new HotelDAO();
        hotelDAO.updateById(hotel);
        response.sendRedirect("./hotel-select");
    }

}
