<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>


<tags:pageTemplate titulo="Livros de Java, Android, iPhone, Ruby, PHP e muito mais ....">
	<div class="container">
	<a href="${s:mvcUrl('UC#form').build()}">Novo usuário</a>
		<h1>Lista de Usuários</h1>
		<p>${message}</p>
		<table>
			<thead>
				<tr>
					<th>Nome</th>
					<th>Email</th>
					<th>Roles</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${usuarios }" var="usuario">
					<tr>
						<td>${usuario.nome }</td>
						<td>${usuario.email}</td>
						<td>${usuario.roles}</td>
						<td>
							<form>
								<button formaction="${s:mvcUrl('UC#editaRoleForm').arg(0,usuario.id).build() }" formmethod="get">Editar permissões</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
</tags:pageTemplate>
