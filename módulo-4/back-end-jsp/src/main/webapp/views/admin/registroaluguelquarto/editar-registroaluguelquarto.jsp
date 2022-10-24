<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<jstl:if test="${sessionScope.logado != 1}">
  <jstl:redirect url="./home.jsp" />
</jstl:if>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  <title>Alteração do registro de aluguel ${registro.id}</title>

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
  <h3>Alteração do registro de aluguel ${registro.id}</h3>
  <form action="./registroaluguelquarto-update" method="post" class="form-control">
    <input type="hidden" name="id" value="${registro.id}">
    <p>
      <label for="id_quarto">Id do quarto:</label>
      <input min="2" value="${registro.id_quarto}" type="number" id="id_quarto" name="id_quarto" size="15" class="form-control" required>
    </p>
    <p>
      <label for="entrada">Data de entrada:</label>
      <input value="${registro.entrada}" type="date" id="entrada" name="entrada" size="15" class="form-control" required>
    </p>
    <p>
      <label for="saida">data de saída:</label>
      <input value="${registro.saida}" type="date" id="saida" name="saida" size="15" class="form-control" required>
    </p>
    <button type="submit" class="btn btn-success">Atualizar</button>
  </form>
</div>
</body>
</html>