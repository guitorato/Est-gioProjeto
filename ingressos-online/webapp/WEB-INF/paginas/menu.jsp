<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<spring:url value="/registrarCliente" var="registrarCliente"></spring:url>
<spring:url value="/registrarCasaShow" var="registrarCasaShow"></spring:url>
<spring:url value="/" var="index"></spring:url>

<link href='<spring:url value="/qintess/css/bootstrap.css" />' rel = "stylesheet" />
<script src='<spring:url value="/qintess/js/jquery-3.4.1.min.js" />' ></script>
<script src='<spring:url value="/qintess/js/bootstrap.js"/>'></script>
	

<!-- Navigation -->
<nav class="navbar navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	
		<div class="container">
			
			<a class="navbar-brand" href="${index}">Ingresso Online</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
			
			<div class="collapse navbar-collapse" id="navbarSite">
			
				<ul class="navbar-nav mr-auto">
					<li class="nav-item">
						<a class="nav-link" href="${registrarCliente}">Cadastrar Cliente</a>
					</li>		
					<li class="nav-item">
						<a class="nav-link" href="${registrarCasaShow}">Cadastrar Casa de Show</a>
					</li>	
					<li class="nav-item">
						<a class="nav-link" href="#	">Cadastrar Evento</a>
					</li>					
				</ul>
			
			</div>
		</div>
	
	</nav>
	
	<div class="mb-2"></div>