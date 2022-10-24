<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<jstl:if test="${sessionScope.logado != 1}">
    <jstl:redirect url="./home.jsp" />
</jstl:if>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Alteração do pacote ${pacote.id}</title>

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
    <h3>Alteração do pacote ${pacote.id}</h3>
    <form action="./pacote-update" method="post" class="form-control">
        <input type="hidden" name="id" value="${pacote.id}">
        <p>
            <label for="id_voo">Id voo:</label>
            <input value="${pacote.id_voo}" min="2" type="number" id="id_voo" name="id_voo" size="15" class="form-control" required>
        </p>
        <p>
            <label for="id_voo2">Id voo 2:</label>
            <input value="${pacote.id_voo2}" type="number" id="id_voo2" name="id_voo2" size="15" class="form-control">
        </p>
        <p>
            <label for="id_registroaluguelquarto">Id registro de alugueis dos quartos:</label>
            <input value="${pacote.id_registroaluguelquarto}" type="number" id="id_registroaluguelquarto" name="id_registroaluguelquarto" size="15" class="form-control" required>
        </p>
        <p>
            <label for="total_pessoas">Total de pessoas:</label>
            <input value="${pacote.total_pessoas}" type="number" id="total_pessoas" name="total_pessoas" size="15" maxlength="1" max="2" min="1" class="form-control" required>
        </p>
        <p>
            <label for="valor_original">Valor original:</label>
            <input value="${pacote.valor_original}" type="text" id="valor_original" name="valor_original" size="15" class="form-control" required>
        </p>
        <p>
            <label for="desconto">Desconto:</label>
            <input value="${pacote.desconto}" type="number" id="desconto" name="desconto" size="15" class="form-control" required>
        </p>
        <p>
            <label for="valor_promocional">Valor promocional:</label>
            <input value="${pacote.valor_promocional}" type="text" id="valor_promocional" name="valor_promocional" size="15" class="form-control" required>
        </p>
        <button type="submit" class="btn btn-success">Atualizar</button>
    </form>
</div>
</body>
</html>