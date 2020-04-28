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
	<title>Registrar-se</title>
	<spring:url value="/registrarCasaShow/deleta/" var="deleta"></spring:url>
	<spring:url value="/registrarCasaShow/alterar/" var="alterar"></spring:url>
	<spring:url value="/registrarCasaShow/salva/" var="salva"></spring:url>
	<spring:url value="/" var="voltar"></spring:url>
	<spring:url value="/registrarCasaShow" var="cancela"></spring:url>
	<spring:url value="/registrarCasaShow" var="limpa"></spring:url>
	
	<link href='<spring:url value="/qintess/css/bootstrap.min.css" />' rel = "stylesheet" />
	<link href='<spring:url value="/qintess/css/bootstrap.css" />' rel = "stylesheet" />
	
	<script src='<spring:url value="/qintess/js/jquery-3.4.1.min.js" />' ></script>
	<script src='<spring:url value="/qintess/js/bootstrap.js"/>'></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery.maskedinput/1.4.1/jquery.maskedinput.min.js"></script>
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
			<h1>Cadastrar - Casa de Show</h1>
		</div>
		
		<form:form action ="${salva}" modelAttribute="casaDeShow" cssClass="mb-2">
				
				<form:hidden path="id"/>
				
				<div class="form-group">
				
						<input type="text" class="form-control" placeholder="Nome da Casa de Show"
							    name="nome" value="${casaDeShow.nome }" />
				
				</div>
				
				<div class="form-group">
						<input type="number" class="form-control" placeholder="Capacidade"
							    name="capacidade" value="${casaDeShow.capacidade }" />
			
				</div>
			
				<div class="form-group">
					
							<input type="tel" class="form-control" id="telefone"
							onkeypress="$(telefone).mask('(00) 0000-00009')" placeholder="Telefone" 
							name="telefone" value="${casaDeShow.telefone }" />
				</div>
				
				<div class="form-group">
						<input type="text" class="form-control" placeholder="Endereço"
							    name="logdradouro" value="${casaDeShow.logdradouro }" />
				
				</div>
				
				<div class="form-group">
			
						<input type="text" class="form-control" placeholder="Número"
							    name="numero" value="${casaDeShow.numero }" />
			
				</div>
				
				<div class="form-group">
					
							<input type="text" class="form-control" placeholder="Complemento"
								    name="complemento" value="${casaDeShow.complemento }" />
				
				</div>
				
				
				<div class="form-group">
					
							<input type="text" class="form-control" placeholder="Bairro"
								    name="bairro" value="${casaDeShow.bairro }" />
							    
				</div>
				
				<div class="form-row">
				    <div class="col-7">
					      <input type="text" class="form-control" placeholder="Cidade"  
					      			name="cidade" value="${casaDeShow.cidade }">
					    </div>
					    
					    <div class="col">
					      <input type="text" class="form-control" placeholder="Estado"
					      				name="uf" value="${casaDeShow.uf }">
					    </div>
					    
					    <div class="col">
					      <input type="text" class="form-control" 
					      onkeypress="$(this).mask('00.000-000')" placeholder="CEP"
					      		name="cep" value="${casaDeShow.cep }">
				    </div>
			  </div>
				
			  <br />
					
				<input type="submit" class="btn btn-primary" name="salva" value="${casaDeShow.id == 0 ? 'Cadastrar' : 'Alterar'}" />
				
				<c:if test="${casaDeShow.id ne 0 }">
					<input type="submit" class="btn btn-warning" name="cancela" value="Cancelar"/>					
				</c:if>
				
		</form:form>
		
		<c:if test="${not empty casaDeShows }">
			<table class="table table-striped">
				<thead>
					<tr>
					<th scope="col">Nome</th>
					<th scope="col">Capacidade</th>
					<th scope="col">Endereço</th>
					<th scope="col">Número</th>
					<th scope="col">Complemento</th>
					<th scope="col">Bairro</th>
					<th scope="col">Cidade</th>
					<th scope="col">Estado</th>
					<th scope="col">CEP</th>
					<th scope="col">Contato</th>
					<th scope="col" colspan="2">Ações</th>
				</tr>	
				</thead>
				
				<tbody>
				
					<c:forEach var="casaDeShow" items="${casaDeShows}">
						<tr>
							<td>${casaDeShow.nome}</td>
							<td>${casaDeShow.capacidade}</td>
							<td>${casaDeShow.logdradouro}</td>
							<td>${casaDeShow.numero}</td>
							<td>${casaDeShow.complemento}</td>
							<td>${casaDeShow.bairro}</td>
							<td>${casaDeShow.cidade}</td>
							<td>${casaDeShow.uf}</td>
							<td>${casaDeShow.telefone}</td>
							<td><a href="${alterar}${casaDeShow.id}" class="btn btn-warning">Alterar</a></td>
							<td><a href="${deleta}${casaDeShow.id}" class="btn btn-danger" onclick="return confirm('Deseja deletar esse produto?')">Deletar</a></td>
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