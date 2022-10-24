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
  <title>Cadastro - usuários</title>
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
  <h3>Cadastro usuários</h3>
  <form action="./usuario-insert" method="post" class="form-control">
    <fieldset>
      <legend>Dados do Usuário</legend>
      <p>
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" size="15" class="form-control" required>
      </p>
      <p>
        <label for="cpf">CPF:</label>
        <input type="text" id="cpf" name="cpf" size="15" class="form-control" required>
      </p>
      <p>
        <label for="email">E-mail:</label>
        <input type="email" id="email" name="email" size="15" class="form-control" required>
      </p>
      <p>
        <label for="senha">Senha:</label>
        <input type="text" id="senha" name="senha" size="15" class="form-control" required>
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
      <th>CPF</th>
      <th>E-mail</th>
      <th>Senha</th>
      <th>Ações</th>
    </tr>
    </thead>
    <tbody>
    <jstl:forEach items="${usuarios}" var="usuario">
      <tr>
        <td>${usuario.id}</td>
        <td>${usuario.nome}</td>
        <td>${usuario.cpf}</td>
        <td>${usuario.email}</td>
        <td>${usuario.password}</td>
        <td>
          <a href="./usuario-edit?id=${usuario.id}" class="btn btn-success">Editar</a>
          <a href="./usuario-delete?id=${usuario.id}" onclick="return confirm('Deseja Excluir?')"
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