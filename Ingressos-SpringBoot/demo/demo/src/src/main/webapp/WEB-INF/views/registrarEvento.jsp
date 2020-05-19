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
	<title>Registrar Evento</title>
	<spring:url value="/registrarEvento/deleta/" var="deleta"></spring:url>
	<spring:url value="/registrarEvento/alterar/" var="alterar"></spring:url>
	<spring:url value="/registrarEvento/salva/" var="salva"></spring:url>
	<spring:url value="/" var="voltar"></spring:url>
	<spring:url value="/registrarEvento" var="cancela"></spring:url>
	<spring:url value="/registrarEvento" var="limpa"></spring:url>
	
	<link href='<spring:url value="/qintess/css/bootstrap.css" />' rel = "stylesheet" />
	
	<script src='<spring:url value="/qintess/js/jquery-3.4.1.min.js" />' ></script>
	<script src='<spring:url value="/qintess/js/bootstrap.js"/>'></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>

</head>
<body>

	<jsp:include page="${request.contextPath}/menu"></jsp:include>

	<div class="container mt-5">
		<div class="row">

			

			<div class="col-lg-9">
				<c:if test="${not empty mensagemErro }">

					<div id="divMensagemErro" class="alert alert-danger" role="alert">
						${mensagemErro }</div>

				</c:if>

				<c:if test="${not empty mensagemSucesso }">

					<div id="divMensagemSucesso" class="alert alert-success"
						role="alert">${mensagemSucesso }</div>

				</c:if>



				<div class="pb-2 mt-4 mb-2 border-bottom">
					<!-- page header -->
					<h2>Evento</h2>
				</div>


				<form:form action="${salva}" modelAttribute="evento"
					enctype="multipart/form-data" cssClass="mb-2">

					<form:hidden path="id" />
					<form:hidden path="imagemProd" />

					<div class="form-group">
						<label>Nome - Evento</label>
						<input type="text" class="form-control" placeholder="Nome do Evento"
							    name="nome" value="${evento.nome }" />
					</div>

					<div class="form-group">
						<label>Descrição</label>
						<textarea rows="3" name="descricao" maxlength="1000" placeholder="Descrição"
							class="form-control">${evento.descricao}</textarea>
					</div>

					<div class="form-group">
						<label>Data Evento</label>
						    <input type="date" class="form-control" name="dtEvento" placeholder="Data Evento"
									value="${evento.dtEvento}" />
					  </div>
					  
					   <div class="form-group">
						<label>Quantidade de ingressos</label>
						<input type="number" class="form-control" placeholder="Quantidade de ingressos"
							    name="qtdIngresso" value="${evento.qtdIngresso }" />
					</div>
					  
					  <div class="form-group">
						<label>Preço do ingresso</label>
						<input type="text" class="form-control" placeholder="Preço ingresso"
							    name="valor" value="${evento.valor }" />
					</div>
					
					<div class="form-group">
						<label>Casas de Show</label>
						<form:select name="casaDeShows" class="form-control" path="casaDeShow">
							<form:options items="${casaDeShows}" id="id" itemLabel="nome"/>
						</form:select>

					</div>

					<div class="form-group">
						<label>Imagem</label>
						<div class="custom-file">
							<input type="file" name="imagem" class="custom-file-input" value="${evento.imagemEncoded }" />
							<label class="custom-file-label">Escolha uma imagem</label> 
						</div>
					</div>

					<c:if test="${evento.id ne 0 }"> <!-- a imagem será exibida somente no carregaAlterar -->
						<div class="mb-5">
							<img class="img-thumbnail" src="data:image/jpge;base64,${evento.imagemEncoded }" 
							alt="imagem não encontrada"/>
						</div>
					</c:if>

					<input type="submit" name="salva" class="btn btn-primary"
						value="${evento.id == 0 ? 'Cadastrar' : 'Alterar' }" />

					<c:if test="${evento.id ne 0 }">
						<input type="submit" name="cancela" class="btn btn-warning"
							value="Cancelar" />
					</c:if>

				</form:form>

				<br>

				<c:if test="${not empty eventos}">

					<table class="table table-striped">
						<thead class="thead-dark">
							<tr>
								<th scope="col">Código</th>
								<th scope="col">Nome</th>
								<th scope="col">Data Evento</th>
								<th scope="col">Ingressos</th>
								<th scope="col">Valor</th>
								<th scope="col" colspan="2">Ações</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="evento" items="${eventos}">
								<tr>
									<td scope="row">${evento.id}</td>
									<td>${evento.nome}</td>
									<td>${evento.dtEvento}</td>
									<td>${evento.qtdIngresso}</td>
									<td>${evento.valor}</td>
									<td><a href="${alterar}${evento.id}"
										class="btn btn-warning">Alterar</a></td>
									<td><a href="${deleta}${evento.id}"
										class="btn btn-danger"
										onclick="return confirm('Deseja deletar esse produto?');">Deletar</a></td>
								</tr>
							</c:forEach>
						</tbody>

					</table>

				</c:if>

			</div>

		</div>
	</div>


	<script type="text/javascript">
		$(document).ready(function() {
			$('#divMensagemErro').delay(5000).fadeOut('slow');
			$('#divMensagemSucesso').delay(5000).fadeOut('slow');
		});
	</script>
</body>
</html>