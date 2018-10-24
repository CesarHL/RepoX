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
		src="${pageContext.request.contextPath}/pages/servicio7gestionar-servicio/js/index-editNew.js"
		type="text/javascript"></script>
	]]>
</jsp:text>
</head>
<body>
	<div class="row title">
		<div class="col-md-12">
			<h1 class="title">
				<s:text name="Visualizar Informacion de Servicio"></s:text>
			</h1>
		</div>
	</div>

		<fieldset class="form form-horizontal form-medium">
			<legend class="form-section">
				<s:text name="Informacion del servicio" />
			</legend>
			<!-- Clave del servicio -->
			<div class="form-group">
				<label
					class="col-xs-12 col-sm-4 col-md-4 control-label"
					for=""> <s:text name="Clave del servicio" />
				</label>
				<div class="col-xs-12 col-sm-6 col-md-6 text-justify">
					<s:property value="'0853'"/>
				</div>
			</div>
			<!-- Tipo de servicio -->
			<div class="form-group">
				<label
					class="col-xs-12 col-sm-4 col-md-4 control-label"
					for=""> <s:text name="Tipo de servicio" />
				</label>
				<div class="col-xs-12 col-sm-6 col-md-6 text-justify">
					<s:property value="'Curso'"/>
				</div>
			</div>
			<!-- Descripción -->
			<div class="form-group">
				<label
					class="col-xs-12 col-sm-4 col-md-4 control-label"
					for=""> <s:text name="Descripcion" />
				</label>
				<div class="col-xs-12 col-sm-6 col-md-6 text-justify">
					<s:property value="'Curso de idiomas semanal o sabatino, 40 horas. Comunidad IPN'"/>
				</div>
			</div>
			<!-- Costo -->
			<div class="form-group">
				<label
					class="col-xs-12 col-sm-4 col-md-4 control-label">
					<s:text name="Costo (MXN)" />
				</label>
				<div class="col-xs-12 col-sm-6 col-md-6 text-justify">
					<s:property value="'$ 544.00'"/>
				</div>
			</div>
			<!-- Area a la que perteneces -->
			<div class="form-group">
				<label
					class="col-xs-12 col-sm-4 col-md-4 control-label"
					for=""> <s:text name="Area a la que pertenece" />
				</label>
				<div class="col-xs-12 col-sm-6 col-md-6 text-justify">
					<s:property value="'Celex'"/>
				</div>
			</div>
		</fieldset>
		<!-- Botones de Aceptar y Cancelar -->
		<div class="outter-section form-medium text-right">
			<div class="col-xs-12 col-md-12 col-md-12 text-right">
				<s:submit cssClass="btn btn-default-spee" value="Aceptar" />
				<a class="btn btn-default-spee"
					href="${pageContext.request.contextPath}/servicio/gestionar-servicio">Cancelar</a>
			</div>
		</div>
</body>
	</html>
</jsp:root>