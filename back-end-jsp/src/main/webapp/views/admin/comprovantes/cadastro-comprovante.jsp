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
  <title>Cadastro - comprovantes</title>
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
  <h3>Cadastro comprovantes</h3>
  <form action="./comprovante-insert" method="post" class="form-control">
    <fieldset>
      <legend>Dados do Comprovante</legend>
      <p>
        <label for="id_registroaluguelquarto">Id registro de alugueis dos quartos:</label>
        <input type="number" min="2" id="id_registroaluguelquarto" name="id_registroaluguelquarto" size="15" class="form-control" required>
      </p>
      <p>
        <label for="id_usuario">Id do usuário:</label>
        <input type="number" min="2" id="id_usuario" name="id_usuario" size="15" class="form-control" required>
      </p>
      <p>
        <label for="id_pacote">Id do pacote:</label>
        <input type="number" min="2" id="id_pacote" name="id_pacote" size="15" class="form-control">
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
      <th>Id registro de alugueis dos quartos</th>
      <th>Id do usuário</th>
      <th>Id do pacote</th>
      <th>Data da compra</th>
      <th>Ações</th>
    </tr>
    </thead>
    <tbody>
    <jstl:forEach items="${comprovantes}" var="comprovante">
      <tr>
        <td>${comprovante.id}</td>
        <td>${comprovante.id_registroAluguel}</td>
        <td>${comprovante.id_usuario}</td>
        <td>${comprovante.id_pacote}</td>
        <td>
          <a href="./comprovante-edit?id=${comprovante.id}" class="btn btn-success">Editar</a>
          <a href="./comprovante-delete?id=${comprovante.id}" onclick="return confirm('Deseja Excluir?')"
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