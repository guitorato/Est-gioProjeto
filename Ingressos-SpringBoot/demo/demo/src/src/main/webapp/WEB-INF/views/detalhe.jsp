<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
<head>
<title>Qintess - Detalhes</title>


	<link href='<spring:url value="/qintess/css/bootstrap.css" />' rel="stylesheet" />
	<script src='<spring:url value="/qintess/js/jquery-3.4.1.min.js" />'></script>
	<script src='<spring:url value="/qintess/js/bootstrap.js" />'></script>
	
	<spring:url value="detalhe" var="detalhe"></spring:url>
	
</head>
<body>
<body>
	
	<jsp:include page="${request.contextPath}/menu"></jsp:include>
	
	
	<!-- Page Content -->
	<div class="container mt-5">
		
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


		<div class="row">

			<!-- Menu -->
			<jsp:include page="${request.contextPath}/menuLateral"></jsp:include>
	

			<div align="center" class="col-lg-9 mt-5">
	
				<div class="row">
						<div class="text-center">
							<h3>Detalhes do Evento</h3>
							<hr />
						</div>
							
						<div class="col-lg-4 col-md-6">
						<br/><br/><br/>
							<div  class="card-body card h-100 mw-100">
								<img align="left" class="card-img-top"
										src="data:image/jpge;base64,${imageEvento}" alt="">
								</div>		
								</div>
							<div class="col-lg-9 mt-5">
								<div align="center" class="card-body">
									 <ul class="list-group list-group-flush">
									 	<li class="list-group-item"><h4>Show - ${evento.nome}</h4></li>
									 	<li class="list-group-item">${evento.descricao}</li>
										  <li class="list-group-item">Preço: ${evento.valor}</li>
										    <li class="list-group-item">Data: ${evento.dtEvento} </li>
										    <li class="list-group-item">Endereço: ${evento.casaDeShow.logdradouro}</li>
										    <li class="list-group-item">Casa de Show: ${evento.casaDeShow.nome}</li>
										  </ul>
								</div>
								
								<div align="center" class="card-footer">
								
									<form method="post" action="${compra}" class="form-inline">
								   
								   			
											  <div class="form-group mb-3">
											    <input class="form-control" type="number"
													name="ingresso" min="1" max="4" value="2" />
											  </div>
											  <input type="submit" value="COMPRAR">
											  	<!--  <a href="${compra}" onclick="return confirm('Deseja comprar esse ingresso?')" 
											  	class="btn btn-primary">COMPRAR</a> -->
											  		
									</form>
								</div>
								<div class="card-footer text-center mt-3">
									<medium> ${evento.qtdIngresso} ingressos
													disponíveis</medium>
									</div>
							</div>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.col-lg-9 -->
		</div>
		<!-- /.row -->
	</div>
<script type="text/javascript">
		$(document).ready(function() {
			$('#divMensagemErro').delay(5000).fadeOut('slow');
			$('#divMensagemSucesso').delay(5000).fadeOut('slow');
		})
	</script>

</body>


</html>