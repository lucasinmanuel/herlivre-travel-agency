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
    <title>Cadastro - voos</title>
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
    <h3>Cadastro voos</h3>
    <form action="./voo-insert" method="post" class="form-control">
        <fieldset>
            <legend>Dados do Voo</legend>
            <p>
                <label for="id_cidade">Id da cidade:</label>
                <input min="2" type="number" id="id_cidade" name="id_cidade" size="15" class="form-control" required>
            </p>
            <p>
                <label for="ponto_partida">Ponto de partida:</label>
                <input type="text" id="ponto_partida" name="ponto_partida" size="15" class="form-control" min="101" required>
            </p>
            <p>
                <label for="companhia">Companhia:</label>
                <input type="text" id="companhia" name="companhia" size="15" class="form-control" required>
            </p>
            <p>
                <label for="num_voo">Número do voo:</label>
                <input type="text" id="num_voo" name="num_voo" size="15" class="form-control" required>
            </p>
            <p>
                <label for="num_assento">Número do assento:</label>
                <input type="text" id="num_assento" name="num_assento" size="15" maxlength="2" class="form-control" required>
            </p>
            <p>
                <label for="qtd_assentos_disp">Qtd de assentos disponível:</label>
                <input type="number" id="qtd_assentos_disp" name="qtd_assentos_disp" size="15" class="form-control" required>
            </p>
            <p>
                <label for="data_partida">Data de partida:</label>
                <input type="date" id="data_partida" name="data_partida" size="15" class="form-control" required>
            </p>
            <p>
                <label for="data_chegada">Data de chegada:</label>
                <input type="date" id="data_chegada" name="data_chegada" size="15" class="form-control" required>
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
            <th>Id da cidade</th>
            <th>Ponto de partida</th>
            <th>Companhia</th>
            <th>Número do voo</th>
            <th>Número do assento</th>
            <th>Qtd de assentos disponível</th>
            <th>Data de partida</th>
            <th>Data de chegada</th>
            <th>Ações</th>
        </tr>
        </thead>
        <tbody>
        <jstl:forEach items="${voos}" var="voo">
            <tr>
                <td>${voo.id}</td>
                <td>${voo.id_cidade}</td>
                <td>${voo.ponto_partida}</td>
                <td>${voo.companhia}</td>
                <td>${voo.num_voo}</td>
                <td>${voo.num_assento}</td>
                <td>${voo.qtd_assentos_disp}</td>
                <td>${voo.data_partida}</td>
                <td>${voo.data_chegada}</td>
                <td>
                    <a href="./voo-edit?id=${voo.id}" class="btn btn-success">Editar</a>
                    <a href="./voo-delete?id=${voo.id}" onclick="return confirm('Deseja Excluir?')"
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
