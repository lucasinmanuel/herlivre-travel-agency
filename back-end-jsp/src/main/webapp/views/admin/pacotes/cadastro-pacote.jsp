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
    <title>Cadastro - pacotes</title>
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
    <h3>Cadastro pacotes</h3>
    <form action="./pacote-insert" method="post" class="form-control">
        <fieldset>
            <legend>Dados do Pacote</legend>
            <p>
                <label for="id_voo">Id voo:</label>
                <input type="number" id="id_voo" name="id_voo" min="2" size="15" class="form-control" required>
            </p>
            <p>
                <label for="id_voo2">Id voo 2 (opcional):</label>
                <input type="number" id="id_voo2" name="id_voo2" size="15" class="form-control">
            </p>
            <p>
                <label for="id_registroaluguelquarto">Id registro de alugueis dos quartos:</label>
                <input type="number" id="id_registroaluguelquarto" name="id_registroaluguelquarto" size="15" class="form-control" required>
            </p>
            <p>
                <label for="total_pessoas">Total de pessoas:</label>
                <input type="number" id="total_pessoas" name="total_pessoas" size="15" maxlength="1" max="2" min="1" class="form-control" required>
            </p>
            <p>
                <label for="valor_original">Valor original:</label>
                <input type="text" id="valor_original" name="valor_original" size="15" class="form-control" required>
            </p>
            <p>
                <label for="desconto">Desconto:</label>
                <input type="number" id="desconto" name="desconto" size="15" class="form-control" required>
            </p>
            <p>
                <label for="valor_promocional">Valor promocional:</label>
                <input type="text" id="valor_promocional" name="valor_promocional" size="15" class="form-control" required>
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
            <th>Id voo</th>
            <th>Id voo 2</th>
            <th>Id registro de alugueis dos quartos</th>
            <th>Total de pessoas</th>
            <th>Valor original</th>
            <th>Desconto</th>
            <th>Valor promocional</th>
            <th>Ações</th>
        </tr>
        </thead>
        <tbody>
        <jstl:forEach items="${pacotes}" var="pacote">
            <tr>
                <td>${pacote.id}</td>
                <td>${pacote.id_voo}</td>
                <td>${pacote.id_voo2}</td>
                <td>${pacote.id_registroaluguelquarto}</td>
                <td>${pacote.total_pessoas}</td>
                <td>${pacote.valor_original}</td>
                <td>${pacote.desconto}</td>
                <td>${pacote.valor_promocional}</td>
                <td>
                    <a href="./pacote-edit?id=${pacote.id}" class="btn btn-success">Editar</a>
                    <a href="./pacote-delete?id=${pacote.id}" onclick="return confirm('Deseja Excluir?')"
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