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
		src="${pageContext.request.contextPath}/pages/consulta/gestionar-consulta/js/index-show.js"
		type="text/javascript"></script>
	]]>
</jsp:text>

</head>
<body>
	<s:set var="btnAceptar" value="%{getText('mx.com.eld.boton.aceptar')}" />
	<s:set var="btnRegresar" value="%{getText('Regresar')}" />
	<s:set var="listServicios" value="{{'Amalgama','2','$ 65.00'}}" />
	<s:set var="obs"
		value="'Se realiza limpieza bucal y la aplicación de una amalgama en el molar inferior derecho. 
							Se receta un análgesico para evitar un dolor posterior y se recomienda no comer durante
							las siguientes 6 horas.'" />

	<div class="row title">
		<div class="col-md-12">
			<h1 class="title">
				<s:text name="Visualizar Consulta"></s:text>
			</h1>
		</div>
	</div>

	<fieldset class="form form-horizontal form-medium">

		<div class="form-group text-justify">
			<label class="col-sm-6 col-md-6 control-label" for=""> <s:text
					name="Fecha de la consulta" />
			</label>
			<div class="col-sm-6 col-md-6">
				<s:property value="'07/08/2017'" />
			</div>
		</div>
		<div class="form-group text-justify">
			<label class="col-sm-6 col-md-6 control-label" for=""> <s:text
					name="Nombre del paciente" />
			</label>
			<div class="col-sm-6 col-md-6">
				<s:property value="'Roberto Mendoza Saavedra'" />
			</div>
		</div>
		<div class="form-group text-justify">
			<label class="col-sm-6 col-md-6 control-label" for=""> <s:text
					name="Identificador" />
			</label>
			<div class="col-sm-6 col-md-6">
				<s:property value="'2012630293'" />
			</div>
		</div>
		<div class="form-group text-justify">
			<label class="col-sm-6 col-md-6 control-label" for=""> <s:text
					name="Contacto del paciente" />
			</label>
			<div class="col-sm-6 col-md-6">
				<s:property value="'5521842095'" />
			</div>
		</div>
		<div class="form-group text-justify">
			<label class="col-sm-6 col-md-6 control-label" for=""> <s:text
					name="Dentista" />
			</label>
			<div class="col-sm-6 col-md-6">
				<s:property value="'Rocío Gómez Ruíz'" />
			</div>
		</div>

		<div class="form form-large">
			<div class="separator separator-no-margin col-md-12">
				<label class="col-md-12"> <s:text
						name="Servicios realizados" />
				</label>
			</div>
			<!-- Tabla con los servicios realizados -->
			<div class="form-section form-horizontal form-large">
				<div class="form-group">
					<div class="row">
						<div class="col-md-12">
							<table id="tblServicios" class="table table-striped">
								<thead>
									<tr>
										<th><s:text name="Servicio" /></th>
										<th><s:text name="Cantidad" /></th>
										<th><s:text name="Costo" /></th>
									</tr>
								</thead>
								<tbody>
									<s:iterator value="listServicios" var="servicios">
										<tr>
											<td>${servicios[0]}</td>
											<td>${servicios[1]}</td>
											<td>${servicios[2]}</td>
										</tr>
									</s:iterator>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="form-group text-justify form-large">
			<label class="col-sm-4 col-md-4 control-label" for=""> <s:text
					name="Observaciones" />
			</label>
			<div class="col-sm-8 col-md-8">
				<s:property value="#obs" />
			</div>
		</div>
	</fieldset>

	<div class="outter-section form-medium text-right">
		<div class="col-xs-12 col-md-12 col-md-12 text-right">
			<a class="btn btn-default btn-default-spee"
				href="${pageContext.request.contextPath}/consulta/gestionar-historial-clinico/1">${btnRegresar}</a>
		</div>
	</div>
</body>
	</html>
</jsp:root>