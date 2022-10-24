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
    <title>Cadastro - cidades</title>
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
    <h3>Cadastro cidades</h3>
    <form action="./cidade-insert" method="post" class="form-control">
        <fieldset>
            <legend>Dados da Cidade</legend>
            <p>
                <label for="nome">Nome:</label>
                <input type="text" id="nome" name="nome" size="15" class="form-control" required>
            </p>
            <p>
                <label for="continente">Continente:</label>
                <input type="text" id="continente" name="continente" size="15" class="form-control" required>
            </p>
            <p>
                <label for="pais">País:</label>
                <input type="text" id="pais" name="pais" size="15" class="form-control" required>
            </p>
            <p>
                <label for="uf">UF:</label>
                <input type="text" id="uf" name="uf" size="15" maxlength="2" class="form-control" required>
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
                <th>Nome</th>
                <th>Continente</th>
                <th>País</th>
                <th>UF</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
        <jstl:forEach items="${cidades}" var="cidade">
            <tr>
                <td>${cidade.id}</td>
                <td>${cidade.nome}</td>
                <td>${cidade.continente}</td>
                <td>${cidade.pais}</td>
                <td>${cidade.uf}</td>
                <td>
                    <a href="./cidade-edit?id=${cidade.id}" class="btn btn-success">Editar</a>
                    <a href="./cidade-delete?id=${cidade.id}" onclick="return confirm('Deseja Excluir?')"
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