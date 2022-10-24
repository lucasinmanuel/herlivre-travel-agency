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
    <title>Cadastro - registro de alugueis dos quartos</title>
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
    <h3>Cadastro do registro de alugueis dos quartos</h3>
    <form action="./registroaluguelquarto-insert" method="post" class="form-control">
        <fieldset>
            <legend>Dados do registro de alugueis dos quartos</legend>
            <p>
                <label for="id_quarto">Id do quarto:</label>
                <input min="2" type="number" id="id_quarto" name="id_quarto" size="15" class="form-control" required>
            </p>
            <p>
                <label for="entrada">Data de entrada:</label>
                <input type="date" id="entrada" name="entrada" size="15" class="form-control" required>
            </p>
            <p>
                <label for="saida">data de saída:</label>
                <input type="date" id="saida" name="saida" size="15" class="form-control" required>
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
            <th>Id do quarto</th>
            <th>Data de entrada</th>
            <th>Data de saída</th>
            <th>Ações</th>
        </tr>
        </thead>
        <tbody>
        <jstl:forEach items="${registroaluguelquarto}" var="registro">
            <tr>
                <td>${registro.id}</td>
                <td>${registro.id_quarto}</td>
                <td>${registro.entrada}</td>
                <td>${registro.saida}</td>
                <td>
                    <a href="./registroaluguelquarto-edit?id=${registro.id}" class="btn btn-success">Editar</a>
                    <a href="./registroaluguelquarto-delete?id=${registro.id}" onclick="return confirm('Deseja Excluir?')"
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