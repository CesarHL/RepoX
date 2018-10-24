<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:s="/struts-tags" xmlns:sj="/struts-jquery-tags">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- Head -->
</head>
<body>
	<!-- Variables -->
	<s:set var="Alumno" value="'Usuario'" />
	<s:set var="btnSiguiente" value="Siguiente" />

	<!-- Pantalla Principal -->
	<div class="row">
			<h1 class="title">
				<s:text	name="%{getText('IU1_PANTALLA_PRINCIPAL_TITLE',{#Alumno})}" />
			</h1>
	</div>
	
	<fieldset class="row form">	
		<div class="col-md-12 text-center">
			<div class="msg-frase">
				<h4><s:text name="IU1_LBL1"/></h4>
				<br />
				<h4 class="text-left"><s:text name="IU1_LBL2"/></h4>
			</div>
			<div class="msg-frase">
				<h4>
					<ul class="text-left">
						<li><s:text name="IU1_LBL3" /></li>
						<li><s:text name="IU1_LBL4"/></li>
						<li><s:text name="IU1_LBL5"/></li>
					</ul>
				</h4>
			</div>
			<div class="text-left">
				<h4><s:text name="IU1_LBL6"/></h4>
			</div>
			<div class="form-group text-right">
				<a class="btn btn-primary"
					href="${pageContext.request.contextPath}/admision/registrar-aspirante/">${btnSiguiente}</a>
			</div>
		</div>
	</fieldset>
</body>
	</html>
</jsp:root>