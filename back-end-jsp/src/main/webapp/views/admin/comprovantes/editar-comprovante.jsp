<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<jstl:if test="${sessionScope.logado != 1}">
  <jstl:redirect url="./home.jsp" />
</jstl:if>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  <title>Alteração do comprovante ${comprovante.id}</title>

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
  <h3>Alteração do comprovante ${comprovante.id}</h3>
  <form action="./comprovante-update" method="post" class="form-control">
    <input type="hidden" name="id" value="${comprovante.id}">
    <p>
      <label for="id_registroaluguelquarto">Id registro de alugueis dos quartos:</label>
      <input value="${comprovante.id_registroAluguel}" type="number" min="2" id="id_registroaluguelquarto" name="id_registroaluguelquarto" size="15" class="form-control" required>
    </p>
    <p>
      <label for="id_usuario">Id do usuário:</label>
      <input value="${comprovante.id_usuario}" type="number" min="2" id="id_usuario" name="id_usuario" size="15" class="form-control" required>
    </p>
    <p>
      <label for="id_pacote">Id do pacote:</label>
      <input value="${comprovante.id_pacote}" min="2" type="number" id="id_pacote" name="id_pacote" size="15" class="form-control">
    </p>
    <button type="submit" class="btn btn-success">Atualizar</button>
  </form>
</div>
</body>
</html>