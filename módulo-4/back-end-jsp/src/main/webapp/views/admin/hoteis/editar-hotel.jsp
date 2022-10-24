<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<jstl:if test="${sessionScope.logado != 1}">
	<jstl:redirect url="./home.jsp" />
</jstl:if>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Alteração do hotel ${hotel.nome}</title>

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
		<h3>Alteração da cidade ${hotel.nome}</h3>
		<form action="./hotel-update" method="post" class="form-control">
			<input type="hidden" name="id" value="${hotel.id}">
			<p>
				<label for="id_cidade">Id da cidade:</label>
				<input value="${hotel.id_cidade}" type="number" min="2" id="id_cidade" name="id_cidade" size="15" class="form-control" required>
			</p>
			<p>
				<label for="nome">Nome do hotel:</label>
				<input value="${hotel.nome}" type="text" id="nome" name="nome" size="15" class="form-control" required>
			</p>
			<p>
				<label for="qtd_estrelas">Qtd de estrelas:</label>
				<input value="${hotel.qtd_estrelas}" type="number" id="qtd_estrelas" name="qtd_estrelas" size="15" maxlength="1" max="5" min="0" class="form-control" required>
			</p>
			<p>
				<label for="valor_min">Valor mínimo:</label>
				<input value="${hotel.valor_min}" type="text" id="valor_min" name="valor_min" size="15" class="form-control" required>
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
				<select id="cafe_manha" name="cafe_manha">
					<option value="false">false</option>
					<option value="true">true</option>
				</select>
			</p>
			<p>
				<label for="cep">CEP:</label>
				<input value="${hotel.cep}" type="text" id="cep" name="cep" size="15" class="form-control" required>
			</p>
			<p>
				<label for="logradouro">Logradouro:</label>
				<input value="${hotel.logradouro}" type="text" id="logradouro" name="logradouro" size="15" class="form-control" required>
			</p>
			<p>
				<label for="bairro">Bairro:</label>
				<input value="${hotel.bairro}" type="text" id="bairro" name="bairro" size="15" class="form-control" required>
			</p>
			<button type="submit" class="btn btn-success">Atualizar</button>
		</form>
	</div>
</body>
</html>