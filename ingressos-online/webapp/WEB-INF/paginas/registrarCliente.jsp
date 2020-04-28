<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>        
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Registrar Cliente</title>
	<spring:url value="/registrarCliente/deleta/" var="deleta"></spring:url>
	<spring:url value="/registrarCliente/alterar/" var="alterar"></spring:url>
	<spring:url value="/registrarCliente/salva/" var="salva"></spring:url>
	<spring:url value="/" var="voltar"></spring:url>
	<spring:url value="/registrarCliente" var="cancela"></spring:url>
	<spring:url value="/registrarCliente" var="limpa"></spring:url>
	
	<link href='<spring:url value="/qintess/css/bootstrap.css" />' rel = "stylesheet" />
	
	<script src='<spring:url value="/qintess/js/jquery-3.4.1.min.js" />' ></script>
	<script src='<spring:url value="/qintess/js/bootstrap.js"/>'></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
	
</head>
<body>

    <jsp:include page="${request.contextPath}/menu"></jsp:include>
   
	
	<div class="container mt-5">
		<br />
			<c:if test="${not empty mensagemErro}">
			<div id="divMensagemErro" class="alert alert-danger" role="alert">
				${mensagemErro}		
			</div>
		</c:if>
		
		<c:if test="${not empty mensagemSucesso}">
			<div id="divMensagemSucesso" class="alert alert-success" role="alert">
				${mensagemSucesso}		
			</div>
		</c:if>
	
		<div class="pb-2 mt-4 mb-2 border-bottom">
			<h1>Cadastrar Cliente</h1>
		</div>
		
		<form:form action ="${salva}" modelAttribute="cliente" cssClass="mb-2">
				
				<form:hidden path="id"/>
				
				<div class="form-group">
				
						<input type="text" class="form-control" placeholder="Nome"
							    name="nome" value="${cliente.nome }" />
				
				</div>
				
				<div class="form-row">
				    <div class="col-7">
					      <input type="text" class="form-control" 
								onkeypress="$(this).mask('000.000.000-00')" placeholder="CPF"
							    	name="cpf" value="${cliente.cpf }" />
					    </div>
					    
					    <div class="col">
						    <input type="date" class="form-control" name="dtNascimento"
									value="${cliente.dtNascimento }" />
					    </div>
			  </div>
				
			<br />
				<div class="form-group">
					
							<input type="email" class="form-control" placeholder="EMAIL"
								    name="email" value="${cliente.email }" />
				</div>
				
				<div class="form-group">
						<input type="tel" class="form-control" 
						onkeypress="$(this).mask('(00) 0000-00009')" placeholder="Nº Celular"
							    name="telefone" value="${cliente.telefone }" />
				
				</div>
				
				<div class="form-group">
					
							<input type="password" class="form-control" placeholder="Senha"
								    name="senha" value="${cliente.senha }" />
				
				</div>
				
				
				<input type="submit" class="btn btn-primary" name="salva" value="${cliente.id == 0 ? 'Cadastrar' : 'Alterar'}" />
				
				<c:if test="${cliente.id ne 0 }">
					<input type="submit" class="btn btn-warning" name="cancela" value="Cancelar"/>					
				</c:if>
				
		</form:form>
		
		<c:if test="${not empty clientes }">
			<table class="table table-striped">
				<thead>
					<tr>
					<th scope="col">Nome</th>
					<th scope="col">CPF</th>
					<th scope="col">EMAIL</th>
					<th scope="col">Celular</th>
					<th scope="col">Data Nascimento</th>
					<th scope="col" colspan="2">Ações</th>
				</tr>	
				</thead>
				
				<tbody>
				
					<c:forEach var="cliente" items="${clientes}">
						<tr>
							<td>${cliente.nome}</td>
							<td>${cliente.cpf}</td>
							<td>${cliente.email}</td>
							<td>${cliente.telefone}</td>
							<td>${cliente.dtNascimento}</td>
							
							<td><a href="${alterar}${cliente.id}" class="btn btn-warning">Alterar</a></td>
							<td><a href="${deleta}${cliente.id}" class="btn btn-danger" onclick="return confirm('Deseja deletar esse produto?')">Deletar</a></td>
						</tr>
					</c:forEach>
				
				</tbody>		
			</table>
		</c:if>
		
		<a href="${voltar}"><button class="btn btn-primary">Voltar</button></a>

	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#divMensagemErro').delay(5000).fadeOut('slow');
			$('#divMensagemSucesso').delay(5000).fadeOut('slow');
		})
	</script>
	
</body>
</html>