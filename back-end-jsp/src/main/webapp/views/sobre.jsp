<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Herlivre - Sobre a Empresa</title>
  <meta name="author" content="Herlivre - Lucas Emanuel Santana dos Santos" />
  <meta name="description" content="Herlivre - Encontre a melhor forma de viajar - Agência de viagens." />
  <meta name="keywords" content="desenvolvimento,agência,viagem,milhas,carros,aluguel,hotéis,voos" />
  <meta name="theme-color" content="#ffc107" />
  <!-- <link href="../node_modules/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" /> -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />
</head>

<body>
  <jsp:include page="./components/header.jsp">
    <jsp:param name="home_a_atr" value="class='nav-link' href='./home.jsp' "/>
    <jsp:param name="destino_a_atr" value="class='nav-link' href='./destinos-nacionais.jsp' " />
    <jsp:param name="promocoes_a_atr" value="class='nav-link' href='./promocoes.jsp' " />
    <jsp:param name="contato_a_atr" value="class='dropdown-item' href='./contato.jsp' " />
    <jsp:param name="sobre_a_atr" value="class='dropdown-item active' href='./sobre.jsp' " />
    <jsp:param name="login_a_atr" value="class='nav-link d-flex' href='./login.jsp' " />
    <jsp:param name="perfil_a_atr" value="class='dropdown-item' href='./perfil.jsp' " />
    <jsp:param name="logout_a_atr" value="class='dropdown-item' href='./logout' " />
  </jsp:include>
  <main>
    <section class="sobre">
      <div class="container py-5">
        <div class="row bg-info shadow rounded-3">
          <div class="col-xl-6 align-self-end">
            <img class="d-none d-xl-block" width="100%" src="../images/comissária-de-bordo-desktop.png"
              alt="comissária de bordo" />
          </div>
          <!--col-->

          <div class="col-xl-6 align-self-center p-4">
            <div class="h-100 px-3 py-4 bg-warning rounded-3">
              <h1>Herlivre - Conforto e Qualidade</h1>
              <p>
                Lorem, ipsum dolor sit amet consectetur adipisicing elit. Sunt
                dolorum debitis praesentium perspiciatis numquam totam quaerat
                nemo rerum laboriosam, ratione est maxime nesciunt culpa
                eaque, ad cupiditate aperiam accusantium veniam!
              </p>

              <h3 class="mt-4">Qualidades da empresa!</h3>
              <ul>
                <li>Atendimento</li>
                <li>Serviços</li>
                <li>Promoções</li>
                <li>Conforto</li>
              </ul>
              <h3 class="mt-4">Sobre</h3>
              <p>
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus
                provident reiciendis consequuntur eveniet aspernatur autem, in
                quidem atque ratione consectetur dolorum veritatis ducimus ea
                quisquam eum id. Voluptatum, impedit molestiae.
              </p>
            </div>
          </div>
          <!--col-->
        </div>
        <!--row-->
      </div>
      <!--container-->
    </section>
    <!--sobre-->

    <footer class="border-top border-2">
      <div class="container py-4">
        <div class="row mt-3">
          <div class="col-12 text-center">
            <a class="navbar-brand" href="../."><img src="../images/logos/herlivre.png" width="200px" /></a>
          </div>
          <!--col-->
        </div>
        <!--row-->

        <div class="row mt-5">
          <div class="col-12 col-sm-6 col-xl-3 text-center text-xl-start">
            <a class="d-block text-muted text-decoration-none mb-3" href="#">Hospedagem em promoção</a>
            <a class="d-block text-muted text-decoration-none mb-3" href="#">Hospedagens baratas</a>
            <a class="d-block text-muted text-decoration-none mb-3" href="#">Hospedagens imperdíveis</a>
            <a class="d-block text-muted text-decoration-none mb-3" href="#">Hospedagens bem avaliadas</a>
          </div>
          <!--col-->

          <div class="col-12 col-sm-6 col-xl-3 text-center text-xl-start">
            <a class="d-block text-muted text-decoration-none mb-3" href="#">Passagens com milhas</a>
            <a class="d-block text-muted text-decoration-none mb-3" href="#">Passagens madrugada</a>
            <a class="d-block text-muted text-decoration-none mb-3" href="#">Passagens promocionais</a>
            <a class="d-block text-muted text-decoration-none mb-3" href="#">Passagens baratas</a>
          </div>
          <!--col-->

          <div class="col-12 col-sm-6 col-xl-3 text-center text-xl-start">
            <a class="d-block text-muted text-decoration-none mb-3" href="#">Pacotes em promoção</a>
            <a class="d-block text-muted text-decoration-none mb-3" href="#">Pacotes imperdíveis</a>
            <a class="d-block text-muted text-decoration-none mb-3" href="#">Pacotes baratos</a>
            <a class="d-block text-muted text-decoration-none mb-3" href="#">Pacotes promoção relâmpago</a>
          </div>
          <!--col-->

          <div class="col-12 col-sm-6 col-xl-3 text-center text-xl-start">
            <a class="d-block text-muted text-decoration-none mb-3" href="#">Aluguel de carros baratos</a>
            <a class="d-block text-muted text-decoration-none mb-3" href="#">Aluguel de carros promocionais</a>
            <a class="d-block text-muted text-decoration-none mb-3" href="#">Aluguel de carros populares</a>
            <a class="d-block text-muted text-decoration-none mb-3" href="#">Aluguel de carros imperdíveis</a>
          </div>
          <!--col-->
        </div>
        <!--row-->

        <div class="row">
          <div class="col-12 text-center mt-4">
            <h3 class="text-muted">nos siga!</h3>
            <a href="https://www.facebook.com/" class="d-inline-block mx-2 mb-2" target="_blank"><img width="50px"
                src="../images/icons/facebook.png" alt="ícone facebook" /></a>
            <a href="https://www.instagram.com/" class="d-inline-block mx-2 mb-2" target="_blank"><img width="50px"
                src="../images/icons/instagram.png" alt="ícone instagram" /></a>
            <a href="https://twitter.com/" class="d-inline-block mx-2 mb-2" target="_blank"><img width="50px"
                src="../images/icons/twitter.png" alt="ícone twitter" /></a>
            <a href="https://www.tiktok.com/" class="d-inline-block mx-2 mb-2" target="_blank"><img width="50px"
                src="../images/icons/tik-tok.png" alt="ícone tik tok" /></a>
          </div>
          <!--col-->
        </div>
        <!--row-->

        <div class="row text-center mt-5">
          <div class="col-12">
            <p class="text-muted fs-5">Todos os direitos reservados</p>
          </div>
          <!--col-->
        </div>
        <!--row-->
      </div>
      <!--container-->
    </footer>
  </main>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
    crossorigin="anonymous"></script>
</body>

</html>