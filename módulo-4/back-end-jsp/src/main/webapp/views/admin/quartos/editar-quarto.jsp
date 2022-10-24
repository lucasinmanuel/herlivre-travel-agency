<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<jstl:if test="${sessionScope.logado != 1}">
    <jstl:redirect url="./home.jsp" />
</jstl:if>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Alteração do quarto ${quarto.id}</title>

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
    <h3>Alteração do quarto ${quarto.id}</h3>
    <form action="./quarto-update" method="post" class="form-control">
        <input type="hidden" name="id" value="${quarto.id}">
        <p>
            <label for="id_hotel">Id do hotel:</label>
            <input min="2" value="${quarto.id_hotel}" type="number" id="id_hotel" name="id_hotel" size="15" class="form-control" required>
        </p>
        <p>
            <label for="numero">Número do quarto:</label>
            <input value="${quarto.numero}" type="number" id="numero" name="numero" size="15" class="form-control" min="101" required>
        </p>
        <p>
            <label for="valor">Valor:</label>
            <input value="${quarto.valor}" type="text" id="valor" name="valor" size="15" class="form-control" required>
        </p>
        <p>
            <label for="diaria">Diária:</label>
            <input value="${quarto.diaria}" type="number" id="diaria" name="diaria" size="15" class="form-control" maxlength="1" required>
        </p>
        <p>
            <label for="qtd_camas">Qtd de camas:</label>
            <input value="${quarto.qtd_camas}" type="number" id="qtd_camas" name="qtd_camas" size="15" maxlength="1" max="2" class="form-control" required>
        </p>
        <p>
            <label for="tipo">Tipo de quarto:</label>
            <input value="${quarto.tipo}" type="text" id="tipo" name="tipo" size="15" class="form-control" required>
        </p>
        <button type="submit" class="btn btn-success">Atualizar</button>
    </form>
</div>
</body>
</html>