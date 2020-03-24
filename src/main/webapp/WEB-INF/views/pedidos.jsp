<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>


<tags:pageTemplate titulo="Livros de Java, Android, iPhone, Ruby, PHP e muito mais ....">
	<div class="container">
		<h1>Lista de Pedidos Atuais</h1>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Valor</th>
					<th>Data Pedido</th>
					<th>Titulos</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pedidos }" var="pedido">
					<tr>
						<td>${pedido.id }</td>
						<td>${pedido.valor}</td>
						<td>
							<fmt:formatDate pattern = "dd/MM/yy" value = "${pedido.data.time}" />
						</td>
						<td>${pedido.stringTitulos}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
</tags:pageTemplate>
