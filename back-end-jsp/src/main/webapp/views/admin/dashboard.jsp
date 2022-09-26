<%--
  Created by IntelliJ IDEA.
  User: Remakker
  Date: 22/09/2022
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<jstl:if test="${sessionScope.logado != 1}">
    <jstl:redirect url="../home.jsp" />
</jstl:if>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Herlivre - Admin dashboard</title>
    <meta name="author" content="Herlivre - Lucas Emanuel Santana dos Santos" />
    <meta name="description" content="Herlivre - Encontre a melhor forma de viajar - Agência de viagens." />
    <meta name="keywords" content="desenvolvimento,agência,viagem,milhas,carros,aluguel,hotéis,voos" />
    <meta name="theme-color" content="#ffc107" />
    <!-- <link href="../node_modules/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" /> -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />
</head>
<body>
<header id="header-admin" class="navbar navbar-expand-md navbar-light bg-light shadow-sm">
    <div class="container">
        <a class="navbar-brand" href="../home.jsp">
            <img src="../../images/logos/herlivre.png" width="200px" alt="logo herlivre" />
        </a>
        <button class="navbar-toggler shadow-none border-0" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon fs-2"></span>
        </button>
        <div class="collapse navbar-collapse d-md-flex justify-content-md-end" id="navbarNav">
            <ul class="navbar-nav text-center d-flex align-items-center">
                <li class="nav-item">
                    <a class="nav-link" href="../home.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../destinos-nacionais.jsp">Destino</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../promocoes.jsp">Promoções</a>
                </li>
                <li class="nav-item">
                    <div class="dropdown">
                        <button class="btn btn-outline-info dropdown-toggle mx-1 shadow-none" type="button"
                                id="dropdownMenuButton2" data-bs-toggle="dropdown" aria-expanded="false">
                            Ajuda
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton2">
                            <li>
                                <a class="dropdown-item" href="../contato.jsp">Contato</a>
                            </li>
                            <li>
                                <a class="dropdown-item" href="../sobre.jsp">Sobre</a>
                            </li>
                        </ul>
                    </div>
                </li>
                <li class="nav-item">
                    <div class="dropdown">
                        <button class="btn btn-none dropdown-toggle me-1 shadow-none" type="button"
                                id="dropdownMenuButton3" data-bs-toggle="dropdown" aria-expanded="false">
                            <img width="35px" src="../../images/icons/user_image_placeholder.png" alt="ícone de usuário" />
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton3">
                            </li>
                            <jstl:if test="${logado == 1}">
                                <li>
                                    <a class="dropdown-item" href="./dashboard.jsp">Dashboard</a>
                                </li>
                            </jstl:if>
                            <li>
                                <a class="dropdown-item" href="../perfil.jsp">Perfil</a>
                            </li>
                            <li>
                                <a class="dropdown-item" href="../logout">Sair</a>
                            </li>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>
    </div>
    <!--container-->
</header>
<div class="container">
        <div class="text-center p-4">
            <h1>Painel dos dados</h1>
            <a class="btn btn-warning" href="../usuario-select">Usuários</a>
            <a class="btn btn-warning" href="../comprovante-select">Comprovantes</a>
            <a class="btn btn-warning" href="../pacote-select">Pacotes</a>
            <a class="btn btn-warning" href="../voo-select">Voos</a>
            <a class="btn btn-warning" href="../cidade-select">Cidades</a>
            <a class="btn btn-warning" href="../hotel-select">Hotéis</a>
            <a class="btn btn-warning" href="../quarto-select">Quartos</a>
            <a class="btn btn-warning" href="../registroaluguelquarto-select">Registro de alugueis dos quartos</a>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</body>
</html>
