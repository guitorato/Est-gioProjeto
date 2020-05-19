
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/registrarCliente" var="registrarCliente"></spring:url>
<spring:url value="/registrarCasaShow" var="registrarCasaShow"></spring:url>
<spring:url value="/registrarEvento" var="registrarEvento"></spring:url>
<spring:url value="/" var="index"></spring:url>
	
<div class="col-lg-3 mt-5">

	
	<!-- <c:if test="${usuarioLogado.authorities[0] eq 'ROLE_ADMIN' }"> -->
		<div class="list-group">
			<a href="${registrarCliente }" class="list-group-item">Cliente</a>
			<a href="${registrarCasaShow }" class="list-group-item">Casa de Show</a>
			<a href="${registrarEvento }" class="list-group-item">Evento</a>
		</div>
	<!-- </c:if> -->
	

 </div>