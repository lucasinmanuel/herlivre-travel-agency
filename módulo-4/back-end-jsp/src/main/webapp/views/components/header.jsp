<%--
  Created by IntelliJ IDEA.
  User: Remakker
  Date: 20/09/2022
  Time: 09:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%
  response.sendRedirect("home.jsp");
  String home_a_atr = request.getParameter("home_a_atr");
  String destino_a_atr = request.getParameter("destino_a_atr");
  String promocoes_a_atr = request.getParameter("promocoes_a_atr");
  String contato_a_atr = request.getParameter("contato_a_atr");
  String sobre_a_atr = request.getParameter("sobre_a_atr");
  String login_a_atr = request.getParameter("login_a_atr");
  String dashboard_a_atr = request.getParameter("dashboard_a_atr");
  if(dashboard_a_atr == null){dashboard_a_atr = "class=\"dropdown-item\" href=\"./admin/dashboard.jsp\"";}
  String perfil_a_atr = request.getParameter("perfil_a_atr");
  String logout_a_atr = request.getParameter("logout_a_atr");
%>
<jstl:choose>
  <jstl:when test="${logado == null}">
    <header class="navbar navbar-expand-md navbar-light bg-light shadow-sm">
      <div class="container">
        <a class="navbar-brand" href="./home.jsp">
          <img src="../images/logos/herlivre.png" width="200px" alt="logo herlivre" />
        </a>

        <button class="navbar-toggler shadow-none border-0" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon fs-2"></span>
        </button>

        <div class="collapse navbar-collapse d-md-flex justify-content-md-end" id="navbarNav">
          <ul class="navbar-nav text-center d-flex align-items-center">
            <li class="nav-item">
              <a <%=home_a_atr%>>Home</a>
            </li>
            <li class="nav-item">
              <a <%=destino_a_atr%>>Destino</a>
            </li>
            <li class="nav-item">
              <a <%=promocoes_a_atr%>>Promoções</a>
            </li>
            <li class="nav-item">
              <div class="dropdown">
                <button class="btn btn-outline-info dropdown-toggle mx-1 shadow-none" type="button"
                        id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                  Ajuda
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                  <li>
                    <a <%=contato_a_atr%>>Contato</a>
                  </li>
                  <li>
                    <a <%=sobre_a_atr%>>Sobre</a>
                  </li>
                </ul>
              </div>
            </li>
            <li class="nav-item mx-auto">
              <a <%=login_a_atr%>>
                <img width="24px" src="../images/icons/login.svg" alt="ícone de login" />
                <span class="ms-1">Entrar</span>
              </a>
            </li>
          </ul>
        </div>
      </div>
      <!--container-->
    </header>
  </jstl:when>
  <jstl:otherwise>

        <header id="header-admin" class="navbar navbar-expand-md navbar-light bg-light shadow-sm">
          <div class="container">
            <a class="navbar-brand" href="./home.jsp">
              <img src="../images/logos/herlivre.png" width="200px" alt="logo herlivre" />
            </a>

            <button class="navbar-toggler shadow-none border-0" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon fs-2"></span>
            </button>

            <div class="collapse navbar-collapse d-md-flex justify-content-md-end" id="navbarNav">
              <ul class="navbar-nav text-center d-flex align-items-center">
                <li class="nav-item">
                  <a <%=home_a_atr%>>Home</a>
                </li>
                <li class="nav-item">
                  <a <%=destino_a_atr%>>Destino</a>
                </li>
                <li class="nav-item">
                  <a <%=promocoes_a_atr%>>Promoções</a>
                </li>
                <li class="nav-item">
                  <div class="dropdown">
                    <button class="btn btn-outline-info dropdown-toggle mx-1 shadow-none" type="button"
                            id="dropdownMenuButton2" data-bs-toggle="dropdown" aria-expanded="false">
                      Ajuda
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton2">
                      <li>
                        <a <%=contato_a_atr%>>Contato</a>
                      </li>
                      <li>
                        <a <%=sobre_a_atr%>>Sobre</a>
                      </li>
                    </ul>
                  </div>
                </li>
                <li class="nav-item">
                  <div class="dropdown">
                    <button class="btn btn-none dropdown-toggle me-1 shadow-none" type="button"
                            id="dropdownMenuButton3" data-bs-toggle="dropdown" aria-expanded="false">
                      <img width="35px" src="../images/icons/user_image_placeholder.png" alt="ícone de usuário" />
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton3">
                      </li>
                      <jstl:if test="${logado == 1}">
                        <li>
                          <a <%=dashboard_a_atr%>>Dashboard</a>
                        </li>
                      </jstl:if>
                      <li>
                        <a <%=perfil_a_atr%>>Perfil</a>
                      </li>
                      <li>
                        <a <%=logout_a_atr%>>Sair</a>
                      </li>
                    </ul>
                  </div>
                </li>
              </ul>
            </div>
          </div>
          <!--container-->
        </header>

  </jstl:otherwise>
</jstl:choose>