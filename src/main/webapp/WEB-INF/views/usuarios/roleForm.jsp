<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo="Livros de Java, Android, iPhone, Ruby, PHP e muito mais ....">
	<div class="container">
		<h1>Cadastro de permissões para ${usuario.nome }</h1>
		<form:form method="post" modelAttribute="usuario" action="${s:mvcUrl('UC#editaRoles').build() }">
			<form:checkboxes items="${roles }" path="roles"/>
			<form:input type="hidden" value="${usuario.id}" path="id"/>
			<form:button type="submit">Atualizar</form:button>
		</form:form>
	</div>
</tags:pageTemplate>