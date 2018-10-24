<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:s="/struts-tags" xmlns:sj="/struts-jquery-tags">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:text>
	<![CDATA[
	<script
		src="${pageContext.request.contextPath}/pages/control-acceso/registrar-usuario/js/index-editNew.js"
		type="text/javascript"></script>
	]]>
</jsp:text>
</head>
<body>
	<div class="row title">
		<div class="col-md-12">
			<h1 class="title">
				<s:text name="Visualizar Area"></s:text>
			</h1>
		</div>
	</div>
	<fieldset class="form form-horizontal form-medium">
		<legend class="form-section">
			<s:text name="Informacion del area" />
		</legend>
		<!-- Nombre del área -->
		<div class="form-group">
			<label
				class="col-xs-12 col-sm-4 col-md-4 control-label"
				for=""> <s:text name="Nombre del area" />
			</label>
			<div class="col-xs-12 col-sm-6 col-md-6 text-justify">
				<s:property value="'Celex'"/>
			</div>
		</div>
		<!-- Responsable de área -->
		<div class="form-group">
			<label
				class="col-xs-12 col-sm-4 col-md-4 control-label"
				for=""> <s:text name="Nombre del area" />
			</label>
			<div class="col-xs-12 col-sm-6 col-md-6 text-justify">
				<s:property value="'Angélica Pérez Beltrán'"/>
			</div>
		</div>
		<!-- Descripción -->
		<div class="form-group">
			<label
				class="col-xs-12 col-sm-4 col-md-4 control-label"
				for=""> <s:text name="Descripcion" />
			</label>
			<div class="col-xs-12 col-sm-6 col-md-6 text-justify">
				<s:property value="'Cursos extracurriculares de lenguas extranjeras de la ESCOM.'"/>
			</div>
		</div>
	</fieldset>

	<!-- Boton de Regresar -->
	<div class="outter-section form-medium text-right">
		<div class="col-xs-12 col-md-12 col-md-12 text-right">
			<a class="btn btn-default-spee"
				href="${pageContext.request.contextPath}/area/gestionar-area">Regresar</a>
		</div>
	</div>
</body>
	</html>
</jsp:root>