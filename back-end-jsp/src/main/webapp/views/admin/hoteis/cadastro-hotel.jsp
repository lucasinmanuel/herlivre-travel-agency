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
    <title>Cadastro - hotéis</title>
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
    <h3>Cadastro hotéis</h3>
    <form action="./hotel-insert" method="post" class="form-control">
        <fieldset>
            <legend>Dados do Hotel</legend>
            <p>
                <label for="id_cidade">Id da cidade:</label>
                <input type="number" id="id_cidade" name="id_cidade" min="2" size="15" class="form-control" required>
            </p>
            <p>
                <label for="nome">Nome do hotel:</label>
                <input type="text" id="nome" name="nome" size="15" class="form-control" required>
            </p>
            <p>
                <label for="qtd_estrelas">Qtd de estrelas:</label>
                <input type="number" id="qtd_estrelas" name="qtd_estrelas" size="15" maxlength="1" max="5" min="0" class="form-control" required>
            </p>
            <p>
                <label for="valor_min">Valor mínimo:</label>
                <input type="text" id="valor_min" name="valor_min" size="15" class="form-control" required>
            </p>
            <p>
                <label for="wifi">Wifi:</label>
                <select id="wifi" name="wifi">
                    <option value="false">false</option>
                    <option value="true">true</option>
                </select>
            </p>
            <p>
                <label for="cafe_manha">Café da manhã:</label>
                <select id="cafe_manha" name="wifi">
                    <option value="false">false</option>
                    <option value="true">true</option>
                </select>
            </p>
            <p>
                <label for="cep">CEP:</label>
                <input type="text" id="cep" name="cep" size="15" class="form-control" required>
            </p>
            <p>
                <label for="logradouro">Logradouro:</label>
                <input type="text" id="logradouro" name="logradouro" size="15" class="form-control" required>
            </p>
            <p>
                <label for="bairro">Bairro:</label>
                <input type="text" id="bairro" name="bairro" size="15" class="form-control" required>
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
                <th>Id cidade</th>
                <th>Nome</th>
                <th>Qtd de estrelas</th>
                <th>Valor mínimo</th>
                <th>Wifi</th>
                <th>Café da manhã</th>
                <th>CEP</th>
                <th>Logradouro</th>
                <th>Bairro</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
        <jstl:forEach items="${hoteis}" var="hotel">
            <tr>
                <td>${hotel.id}</td>
                <td>${hotel.id_cidade}</td>
                <td>${hotel.nome}</td>
                <td>${hotel.qtd_estrelas}</td>
                <td>${hotel.valor_min}</td>
                <td>${hotel.wifi}</td>
                <td>${hotel.cafe_manha}</td>
                <td>${hotel.cep}</td>
                <td>${hotel.logradouro}</td>
                <td>${hotel.bairro}</td>
                <td>
                    <a href="./hotel-edit?id=${hotel.id}" class="btn btn-success">Editar</a>
                    <a href="./hotel-delete?id=${hotel.id}" onclick="return confirm('Deseja Excluir?')"
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