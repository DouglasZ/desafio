<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<!DOCTYPE>
<html lang="pt-br">
	<head>
		<title>Usuários</title>
	</head>
<body>
<h1>Adicionar Usuário</h1>

<c:url var="salvarOuAtualizar" value="/usuario/salvarOuAtualizar"></c:url>

<c:if test="${!empty usuario.id}">
	<form action="${salvarOuAtualizar}" method="post">
		<label>ID</label><input type="text" name="id" readonly="readonly" value="${usuario.id}"><br />
		<label>Nome</label><input type="text" name="nome" value="${usuario.nome}"><br />
		<label>Sobrenome</label><input type="text" name="sobrenome" value="${usuario.sobrenome}"><br />
		<input type="submit" value="Atualizar">
	</form>
</c:if>
<c:if test="${empty usuario.id}">
	<form action="${salvarOuAtualizar}" method="post">
		<label>Nome</label><input type="text" name="nome"><br />
		<label>Sobrenome</label><input type="text" name="sobrenome">
		<input type="submit" value="Salvar">
	</form>
</c:if>

<br>
<a href="<c:url value='/' />" >Home</a>
<h3>Lista de Usuários</h3>

<c:if test="${!empty listaDeUsuarios}">
    <table class="tg">
    <tr>
        <th width="80">ID Usuário</th>
        <th width="120">Nome</th>
        <th width="120">SobreNome</th>
        <th width="60">Editar</th>
        <th width="60">Deletar</th>
    </tr>
    <c:forEach items="${listaDeUsuarios}" var="usuario">
        <tr>
            <td>${usuario.id}</td>
            <td>${usuario.nome}</td>
            <td>${usuario.sobrenome}</td>
            <td><a href="<c:url value='/editar/${usuario.id}' />" >Editar</a></td>
            <td><a href="<c:url value='/remover/${usuario.id}' />" >Deletar</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>

</body>
</html>