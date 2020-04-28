<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
<head>
<title>Qintess - Eventos</title>
<spring:url value="/registrarCliente" var="registrarCliente"></spring:url>
<spring:url value="/registrarCasaShow" var="registrarCasaShow"></spring:url>


	<link href='<spring:url value="/qintess/css/bootstrap.css" />' rel = "stylesheet" />
	<script src='<spring:url value="/qintess/js/jquery-3.4.1.min.js" />' ></script>
	<script src='<spring:url value="/qintess/js/bootstrap.js"/>'></script>
</head>
<body>
	
	<jsp:include page="${request.contextPath}/menu"></jsp:include>
	<jsp:include page="${request.contextPath}/rodape"></jsp:include>
	
	<div class="container mt-5">
		<br />
				<h1>Ingressos Online</h1>		
		
	</div>
	
</body>
</html>