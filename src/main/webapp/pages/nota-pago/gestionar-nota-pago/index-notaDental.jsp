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
		src="${pageContext.request.contextPath}/pages/nota-pago/gestionar-nota-pago/js/index.js"
		type="text/javascript"></script>
	]]>
</jsp:text>

</head>
<body>
	<s:set var="btnAceptar" value="%{getText('mx.com.eld.boton.aceptar')}" />
	<s:set var="btnRegresar" value="%{getText('Regresar')}" />
	<s:set var="listServicios"
		value="{{'Amalgama','2','$ 60.00'},{'Limpieza','1','$ 45.00'}}" />

	<div class="row title">
		<div class="col-md-12">
			<h1 class="title">
				<s:text name="Enviar Nota de Pago"></s:text>
			</h1>
		</div>
	</div>
	<!-- Información del paciente y dentista -->
	<fieldset class="form form-horizontal form-medium">
		<div class="form-group text-justify">
			<label class="col-sm-2 col-md-2 control-label" for=""> <s:text
					name="Nombre" />
			</label>
			<div class="col-sm-4 col-md-4">
				<s:property value="'Roberto Mendoza Saavedra'" />
			</div>
			<label class="col-sm-2 col-md-2 control-label" for=""> <s:text
					name="Folio" />
			</label>
			<div class="col-sm-4 col-md-4">
				<s:property value="'0000001'" />
			</div>
		</div>

		<div class="form-group text-justify">
			<label class="col-sm-2 col-md-2 control-label" for=""> <s:text
					name="Identificador" />
			</label>
			<div class="col-sm-4 col-md-4">
				<s:property value="'2012630293'" />
			</div>
			<label class="col-sm-2 col-md-2 control-label" for=""> <s:property
					value="'Fecha de emisión'" />
			</label>
			<div class="col-sm-4 col-md-4">
				<s:property value="'24/08/2018'" />
			</div>
		</div>

		<div class="form-group text-justify">
			<label class="col-sm-2 col-md-2 control-label" for=""> <s:text
					name="Dentista" />
			</label>
			<div class="col-sm-4 col-md-4">
				<s:property value="'Rocío Gómez Ruíz'" />
			</div>
		</div>

		<div class="form form-horizontal form-medium">
			<div class="separator separator-no-margin col-md-12">
				<label class="col-md-12"> <s:text name="Conceptos de pago" />
				</label>
			</div>
			<!-- Tabla con los servicios realizados -->
			<div class="form-section form-medium">
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
		<div class="row">
			<label class="col-md-2 control-label"> <s:text name="Total" />
			</label>
			<div class="col-sm-4 col-md-4 text-justify">
				<s:property value="'$ 105.00'" />
			</div>
		</div>
		<div class="outter-section form-medium text-right">
			<div class="col-xs-12 col-md-12 col-md-12 text-right">
				<a class="btn btn-default btn-default-eld"
					href="${pageContext.request.contextPath}/consulta/gestionar-consulta">Enviar</a>
				<a class="btn btn-default btn-default-eld"
					href="${pageContext.request.contextPath}/consulta/gestionar-consulta/1">Regresar</a>
			</div>
		</div>
	</fieldset>
</body>
	</html>
</jsp:root>