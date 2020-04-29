<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
<head>
<title>Qintess - Eventos</title>


	<link href='<spring:url value="/qintess/css/bootstrap.css" />' rel="stylesheet" />
	<script src='<spring:url value="/qintess/js/jquery-3.4.1.min.js" />'></script>
	<script src='<spring:url value="/qintess/js/bootstrap.js" />'></script>
</head>
<body>
	
	<jsp:include page="${request.contextPath}/menu"></jsp:include>
	
	
	<!-- Page Content -->
	<div class="container mt-5">

		<div class="row">

			<!-- Menu -->
			<jsp:include page="${request.contextPath}/menuLateral"></jsp:include>
	

			<div class="col-lg-9 mt-5">
	
				<div class="row">
					<c:forEach var="evento" items="${eventos}">
						<div class="col-lg-4 col-md-6 mb-4">
							<div class="card h-100">
								<a href="#"><img class="card-img-top"
									src="data:image/jpge;base64,${evento.imagemEncoded}" alt=""></a>
								<div class="card-body">
									<h4 class="card-title">
										<a href="#">${evento.nome}</a>
									</h4>
									<h5>Ingresso: R$ ${evento.valor}</h5>
									
								</div>
								<div class="card-footer">
									<small class="text-muted">&#9733; &#9733; &#9733;
										&#9733; &#9734;</small>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.col-lg-9 -->
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container -->


</body>
</html>