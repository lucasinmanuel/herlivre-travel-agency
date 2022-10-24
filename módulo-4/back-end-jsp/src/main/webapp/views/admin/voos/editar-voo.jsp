<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<jstl:if test="${sessionScope.logado != 1}">
    <jstl:redirect url="./home.jsp" />
</jstl:if>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Alteração do voo ${voo.id}</title>

    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
            crossorigin="anonymous">
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
            crossorigin="anonymous"></script>

</head>
<body>

<div class="container px-5 py-3">
    <h3>Alteração do voo ${voo.id}</h3>
    <form action="./voo-update" method="post" class="form-control">
        <input type="hidden" name="id" value="${voo.id}">
        <p>
            <label for="id_cidade">Id da cidade:</label>
            <input min="2" value="${voo.id_cidade}" type="number" id="id_cidade" name="id_cidade" size="15" class="form-control" required>
        </p>
        <p>
            <label for="ponto_partida">Ponto de partida:</label>
            <input value="${voo.ponto_partida}" type="text" id="ponto_partida" name="ponto_partida" size="15" class="form-control" min="101" required>
        </p>
        <p>
            <label for="companhia">Companhia:</label>
            <input value="${voo.companhia}" type="text" id="companhia" name="companhia" size="15" class="form-control" required>
        </p>
        <p>
            <label for="num_voo">Número do voo:</label>
            <input value="${voo.num_voo}" type="text" id="num_voo" name="num_voo" size="15" class="form-control" required>
        </p>
        <p>
            <label for="num_assento">Número do assento:</label>
            <input value="${voo.num_assento}" type="text" id="num_assento" name="num_assento" size="15" maxlength="2" class="form-control" required>
        </p>
        <p>
            <label for="qtd_assentos_disp">Qtd de assentos disponível:</label>
            <input value="${voo.qtd_assentos_disp}" type="number" id="qtd_assentos_disp" name="qtd_assentos_disp" size="15" class="form-control" required>
        </p>
        <p>
            <label for="data_partida">Data de partida:</label>
            <input value="${voo.data_partida}" type="date" id="data_partida" name="data_partida" size="15" class="form-control" required>
        </p>
        <p>
            <label for="data_chegada">Data de chegada:</label>
            <input value="${voo.data_chegada}" type="date" id="data_chegada" name="data_chegada" size="15" class="form-control" required>
        </p>
        <button type="submit" class="btn btn-success">Atualizar</button>
    </form>
</div>
</body>
</html>