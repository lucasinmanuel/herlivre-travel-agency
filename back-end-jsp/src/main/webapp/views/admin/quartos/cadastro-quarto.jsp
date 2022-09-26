<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<jstl:if test="${sessionScope.logado != 1}">
    <jstl:redirect url="./home.jsp" />
</jstl:if>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro - quartos</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
            crossorigin="anonymous"
    >
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
            crossorigin="anonymous">
    </script>
</head>
<body>
<div class="container px-5 py-3">
    <a class="btn btn-info" href="./admin/dashboard.jsp">Dashboard</a>
    <h3>Cadastro quartos</h3>
    <form action="./quarto-insert" method="post" class="form-control">
        <fieldset>
            <legend>Dados do Quarto</legend>
            <p>
                <label for="id_hotel">Id do hotel:</label>
                <input type="number" id="id_hotel" min="2" name="id_hotel" size="15" class="form-control" required>
            </p>
            <p>
                <label for="numero">Número do quarto:</label>
                <input type="number" id="numero" name="numero" size="15" class="form-control" min="101" required>
            </p>
            <p>
                <label for="valor">Valor:</label>
                <input type="text" id="valor" name="valor" size="15" class="form-control" required>
            </p>
            <p>
                <label for="diaria">Diária:</label>
                <input type="number" id="diaria" name="diaria" size="15" class="form-control" maxlength="1" required>
            </p>
            <p>
                <label for="qtd_camas">Qtd de camas:</label>
                <input type="number" id="qtd_camas" name="qtd_camas" size="15" maxlength="1" max="2" class="form-control" required>
            </p>
            <p>
                <label for="tipo">Tipo de quarto:</label>
                <input type="text" id="tipo" name="tipo" size="15" class="form-control" required>
            </p>
            <p>
                <input type="submit" value="Cadastrar" class="btn btn-primary">
            </p>
        </fieldset>
    </form>
    <table class="table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Id do hotel</th>
            <th>Número do quarto</th>
            <th>Valor do quarto</th>
            <th>Diária</th>
            <th>Qtd de camas</th>
            <th>Tipo de quarto</th>
            <th>Ações</th>
        </tr>
        </thead>
        <tbody>
        <jstl:forEach items="${quartos}" var="quarto">
            <tr>
                <td>${quarto.id}</td>
                <td>${quarto.id_hotel}</td>
                <td>${quarto.numero}</td>
                <td>${quarto.valor}</td>
                <td>${quarto.diaria}</td>
                <td>${quarto.qtd_camas}</td>
                <td>${quarto.tipo}</td>
                <td>
                    <a href="./quarto-edit?id=${quarto.id}" class="btn btn-success">Editar</a>
                    <a href="./quarto-delete?id=${quarto.id}" onclick="return confirm('Deseja Excluir?')"
                       class="btn btn-danger"
                    >Excluir</a>
                </td>
            </tr>
        </jstl:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
