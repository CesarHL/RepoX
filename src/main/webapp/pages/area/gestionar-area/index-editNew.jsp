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
				<s:text name="Registrar Area"></s:text>
			</h1>
		</div>
	</div>

	<!-- Action messages -->
	<div class="form-group">
		<div class="col-md-8 col-md-offset-2">
			<s:actionmessage cssClass="alert alert-success" />
			<s:actionerror cssClass="alert alert-danger" />
		</div>
	</div>

	<!-- Campos obligatorios -->
	<div class="col-md-12">
		<div class="outter-section form-medium text-left">
			<s:property value="'Los campos marcados con * son obligatorios.'" />
		</div>
	</div>

	<s:form
		action="%{#pageContext.request.contextPath}/area/gestionar-area"
		method="post" theme="simple">
		<fieldset class="form form-horizontal form-medium">
			<legend class="form-section">
				<s:text name="Informacion del area" />
			</legend>
			<!-- Nombre del área -->
			<div class="form-group">
				<label
					class="col-xs-12 col-sm-4 col-md-4 control-label label-obligatorio"
					for=""> <s:text name="Nombre del area" />
				</label>
				<div class="col-xs-12 col-sm-6 col-md-6">
					<s:textfield cssClass="form-control campo"
						cssClassError="input-error" name="" id="txNombreArea" />
					<s:fielderror fieldName="" cssClass="error" theme="bootstrap" />
				</div>
			</div>
			<!-- Responsable de área -->
			<div class="form-group">
				<label
					class="col-xs-12 col-sm-4 col-md-4 control-label label-obligatorio"
					for=""> <s:text name="Nombre del area" />
				</label>
				<div class="col-xs-12 col-sm-6 col-md-6">
					<s:select id="slcArea" class="form-control" headerKey="-1"
						headerValue="Seleccione"
						list="#{'1':'Rocío Gómez Ruíz', '2':'Gabriela Sanabria Paredes'}"
						name="selectValue" cssErrorClass="field-error" />
					<s:fielderror fieldName="" cssClass="error" theme="bootstrap" />
				</div>
			</div>
			<!-- Descripción -->
			<div class="form-group">
				<label
					class="col-xs-12 col-sm-4 col-md-4 control-label"
					for=""> <s:text name="Descripcion" />
				</label>
				<div class="col-xs-12 col-sm-6 col-md-6">
					<s:textarea cssClass="form-control campo"
						cssClassError="input-error" name="" id="txDescripcion" maxlength="150" rows="5" />
					<s:fielderror fieldName="" cssClass="error" theme="bootstrap" />
				</div>
			</div>
		</fieldset>

		<!-- Botones de Aceptar y Cancelar -->
		<div class="outter-section form-medium text-right">
			<div class="col-xs-12 col-md-12 col-md-12 text-right">
				<s:submit cssClass="btn btn-default-spee" value="Aceptar" />
				<a class="btn btn-default-spee"
					href="${pageContext.request.contextPath}/area/gestionar-area">Cancelar</a>
			</div>
		</div>
	</s:form>
</body>
	</html>
</jsp:root>