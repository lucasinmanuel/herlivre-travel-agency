<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Herlivre - Viagens</title>
  <meta name="author" content="Herlivre - Lucas Emanuel Santana dos Santos" />
  <meta name="description" content="Herlivre - Encontre a melhor forma de viajar - Agência de viagens." />
  <meta name="keywords" content="desenvolvimento,agência,viagem,milhas,carros,aluguel,hotéis,voos" />
  <meta name="theme-color" content="#ffc107" />
  <!-- <link href="node_modules/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" /> -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />
</head>

<body>
  <jsp:include page="./components/header.jsp" >
    <jsp:param name="home_a_atr" value="class='nav-link active' href='./home.jsp' "/>
    <jsp:param name="destino_a_atr" value="class='nav-link' href='./destinos-nacionais.jsp' " />
    <jsp:param name="promocoes_a_atr" value="class='nav-link' href='./promocoes.jsp' " />
    <jsp:param name="contato_a_atr" value="class='dropdown-item' href='./contato.jsp' " />
    <jsp:param name="sobre_a_atr" value="class='dropdown-item' href='./sobre.jsp' " />
    <jsp:param name="login_a_atr" value="class='nav-link d-flex' href='./login.jsp' " />
    <jsp:param name="perfil_a_atr" value="class='dropdown-item' href='./perfil.jsp' " />
    <jsp:param name="logout_a_atr" value="class='dropdown-item' href='./logout' " />
  </jsp:include>
  <main>
    <section class="banner w-100">
      <style>
        section.banner {
          background-image: url("../images/avião-viagem.gif");
          background-size: 50% 100%;
          background-repeat: no-repeat;
        }

        @media screen and (max-width: 1200px) {
          section.banner {
            background-image: none;
          }

          section.banner div[class~="offset-xl-6"] {
            margin: 0 auto;
          }

          section.banner form {
            text-align: center;
          }

          .buscPacotes-wrapper>div {
            width: 100%;
            max-width: 435px;
            position: relative;
            left: 50%;
            transform: translateX(-50%);
          }
        }

        /*XL*/
      </style>
      <div class="container">
        <div class="row">
          <div class="col-11 col-xl-6 offset-xl-6 py-5 p-xl-5">
            <form>
              <h1 class="mb-4 text-warning">
                Encontre seu <span class="text-info">destino!</span>
              </h1>

              <label for="filterBy" class="fw-bold text-muted">Buscar por:
              </label>
              <select id="filterBy">
                <option selected value="filterByPacotes">Pacotes</option>
                <!-- <option disabled value="filterByVoos">Voos</option> -->
                <option value="filterByHoteis">Hotéis</option>
                <!-- <option disabled value="filterByAlugCar">
                  Aluguel de carros
                </option> -->
              </select>

              <div class="buscPacotes-wrapper">
                <!--INÍCIO INPUT BUSCAR AEROPORTOS-->
                <label for="beginTrip" class="text-muted mt-3">Qual o seu ponto de partida?</label>
                <br />
                <div class="d-flex border border-2 rounded-3 p-2">
                  <img src="../images/geo-alt.svg" alt="icone de localização atual" />
                  <input id="beginTrip" style="outline: none" class="w-100 border-0" type="search" name="beginTrip"
                    placeholder="Busque uma cidade" required />
                </div>
                <!--FIM INPUT BUSCAR AEROPORTOS-->

                <!--INÍCIO INPUT BUSCAR CIDADES OU HOTÉIS-->
                <label for="destinTrip" class="text-muted mt-3">Para qual local você vai?</label>
                <br />
                <div class="d-flex border border-2 rounded-3 p-2">
                  <img src="../images/geo-fill.svg" alt="icone de destino" />
                  <input id="destinTrip" style="outline: none" class="w-100 border-0" type="search" name="destinTrip"
                    placeholder="Busque uma cidade" required />
                </div>
                <!--FIM INPUT BUSCAR CIDADES OU HOTÉIS-->

                <!--INÍCIO INPUT DATA IDA/VOLTA-->
                <label class="text-muted mt-3">Escolha o período de Ida/Volta</label>
                <br />
                <div class="d-sm-flex justify-content-center justify-content-xl-start">
                  <div class="w-100 d-flex border border-2 rounded-3 mb-2 mb-sm-0 p-2 me-2">
                    <label for="dataIda" class="text-muted me-1" style="white-space: nowrap">Ida |</label>
                    <input id="dataIda" style="outline: none" class="w-100 border-0" type="date" name="dataIda"
                      required />
                  </div>
                  <div class="w-100 d-flex border border-2 rounded-3 p-2">
                    <label for="dataVolta" class="text-muted me-1" style="white-space: nowrap">Volta |</label>
                    <input id="dataVolta" style="outline: none" class="w-100 border-0" type="date" name="dataVolta"
                      required />
                  </div>
                </div>
                <!--FIM INPUT DATA IDA/VOLTA-->

                <!--INÍCIO INPUT QTD VIAJANTES/QUARTOS-->
                <label for="numberPeople" class="text-muted mt-3">Máximo de 2 viajantes por pacote</label>
                <br />
                <div
                  class="w-100 d-xl-flex align-items-center justify-content-xl-between border border-2 rounded-3 p-2">
                  <div class="d-md-flex justify-content-center">
                    <img src="../images/people.svg" alt="icone de pessoas" />
                    <input id="numberPeople" style="outline: none; width: 50px" class="border text-center mx-1"
                      type="number" name="numberPeople" min="1" max="2" maxlength="1" required />
                    <span style="white-space: nowrap">Pessoa(s) |</span>
                    <img class="ms-2 me-1" src="../images/house.svg" alt="icone de pessoas" />
                    <span style="white-space: nowrap">1 Pacote</span>
                  </div>

                  <button style="white-space: nowrap" type="button"
                    class="btn btn-outline-warning fw-bold rounded-pill mt-2 mt-xl-0 px-3 py-1">
                    Adicionar pacote
                  </button>
                </div>
                <!--FIM INPUT QTD VIAJANTES/QUARTOS-->

                <input type="submit" class="w-50 btn btn-warning text-light fs-5 fw-bold p-2 mt-4"
                  value="Buscar Pacotes" />
              </div>
              <!--buscPacotes-wrapper-->
            </form>
          </div>
          <!--col-->
        </div>
        <!--row-->
      </div>
      <!--container-->
    </section>
    <!--banner-->

    <section class="topPromo bg-warning">
      <style>
        section.topPromo .row {
          position: relative;
          right: 16px;
        }

        @media screen and (max-width: 1200px) {
          section.topPromo .row {
            right: 0;
          }
        }

        /*XL*/
      </style>

      <div class="container py-5">
        <div class="row flex-xl-nowrap p-0 m-0">
          <div
            class="col-11 col-md-7 col-xl-4 align-items-center mx-auto p-0 bg-light d-flex border border-2 rounded-3 shadow">
            <img width="45%" src="../images/topPromo1.svg" />
            <div class="p-3">
              <h2>Hotéis</h2>
              <p>Aproveite a oferta!</p>
              <h3>
                R$ 140
                <a href="#"><img width="25px" src="../images/arrow-bar-right.svg" /></a>
              </h3>
            </div>
          </div>
          <!--col-->

          <div
            class="col-11 col-md-7 col-xl-4 align-items-center mx-auto mx-xl-3 my-4 my-xl-0 p-0 bg-light d-flex border border-2 rounded-3 shadow">
            <img width="45%" src="../images/topPromo2.svg" />
            <div class="p-3">
              <h2>Pacotes</h2>
              <p>Aproveite a oferta!</p>
              <h3>
                R$ 299,99
                <a href="#"><img width="25px" src="../images/arrow-bar-right.svg" /></a>
              </h3>
            </div>
          </div>
          <!--col-->

          <div
            class="col-11 col-md-7 col-xl-4 align-items-center mx-auto p-0 bg-light d-flex border border-2 rounded-3 shadow">
            <img width="45%" src="../images/topPromo3.svg" />
            <div class="p-3">
              <h2>Voos</h2>
              <p>Aproveite a oferta!</p>
              <h3>
                R$ 152
                <a href="#"><img width="25px" src="../images/arrow-bar-right.svg" /></a>
              </h3>
            </div>
          </div>
          <!--col-->
        </div>
        <!--row-->
      </div>
      <!--container-->
    </section>
    <!--topPromo-->

    <section class="duvidasFrequentes shadow">
      <style>
        section.duvidasFrequentes img {
          max-width: 60px;
        }

        @media screen and (max-width: 768px) {
          section.duvidasFrequentes img {
            max-width: 60px;
            margin-bottom: 10px;
          }
        }

        /*MD*/
      </style>

      <div class="container py-5">
        <div class="row text-center mb-4">
          <div class="col-12">
            <h2>Dúvidas frequentes</h2>
          </div>
          <!--col-->
        </div>
        <!--row-->

        <div class="row text-center text-xl-start">
          <div class="col-11 col-xl-4 mx-auto p-2">
            <h4 class="text-center">Lorem ipsum dolor</h4>
            <p>
              Lorem, ipsum dolor sit amet consectetur adipisicing elit. Rem
              corporis qui odio optio tempore consequuntur voluptatum corrupti
              impedit commodi provident laudantium neque nisi odit repudiandae
              quibusdam praesentium enim, deserunt nostrum.
            </p>
          </div>
          <!--col-4-->

          <div class="col-11 col-xl-4 mx-auto p-2">
            <h4 class="text-center">Lorem ipsum dolor</h4>
            <p>
              Lorem, ipsum dolor sit amet consectetur adipisicing elit. Rem
              corporis qui odio optio tempore consequuntur voluptatum corrupti
              impedit commodi provident laudantium neque nisi odit repudiandae
              quibusdam praesentium enim, deserunt nostrum.
            </p>
          </div>
          <!--col-4-->

          <div class="col-11 col-xl-4 mx-auto p-2">
            <h4 class="text-center">Lorem ipsum dolor</h4>
            <p>
              Lorem, ipsum dolor sit amet consectetur adipisicing elit. Rem
              corporis qui odio optio tempore consequuntur voluptatum corrupti
              impedit commodi provident laudantium neque nisi odit repudiandae
              quibusdam praesentium enim, deserunt nostrum.
            </p>
          </div>
          <!--col-4-->
        </div>
        <!--row-->

        <div class="row mt-4">
          <div class="col-11 col-xl-12 mx-auto">
            <h3 class="text-center text-muted">formas de pagamento</h3>
            <div class="mt-4 d-flex flex-wrap justify-content-center">
              <img class="mx-2" src="../images/logos/mastercard.svg" alt="logo mastercard" />
              <img class="mx-2" src="../images/logos/visa.svg" alt="logo visa" />
              <img class="mx-2" src="../images/logos/american-express.svg" alt="logo american express" />
              <img class="mx-2" src="../images/logos/elo.svg" alt="logo elo" />
              <img class="mx-2" src="../images/logos/hiper.svg" alt="logo hiper" />
              <img class="mx-2" src="../images/logos/hipercard.svg" alt="logo hipercard" />
              <img class="mx-2" src="../images/logos/itaú.svg" alt="logo itaú" />
              <img class="mx-2" src="../images/logos/pix.svg" alt="logo pix" />
              <img class="mx-2" src="../images/logos/boleto.svg" alt="símbolo boleto" />
            </div>
          </div>
          <!--col-->
        </div>
        <!--row-->
      </div>
      <!--container-->
    </section>
    <!--duvidasFrequentes-->

    <footer class="border-top border-2">
      <div class="container py-4">
        <div class="row mt-3">
          <div class="col-12 text-center">
            <a class="navbar-brand" href=".."><img src="../images/logos/herlivre.png" width="200px" /></a>
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