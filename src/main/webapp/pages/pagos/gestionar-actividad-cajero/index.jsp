<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:s="/struts-tags" xmlns:sj="/struts-jquery-tags">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:text>
	<![CDATA[                 
	<script type="text/javascript" src="${pageContext.request.contextPath}/pages/pagos/gestionar-actividad-cajero/js/index.js"></script>
	]]>
</jsp:text>

<s:set var="listPagosCajero"
	value="{{'Angélica Pérez Beltrán','2015642387','11/10/2018','$ 544.00', 'Curso de idiomas semanal o sabatino, 40 horas. Comunidad IPN'},{'Fanny Sosa Adán','2015468921','11/10/2018','$ 544.00', 'Curso de idiomas semanal o sabatino, 40 horas. Comunidad IPN'}}" />

<s:set var="ttbVisualizar" value="%{getText('Visualizar')}" />
<s:set var="ttbVerPago"
	value="%{getText('Visualizar comprobante de pago')}" />
<s:set var="ttbVerSiga"
	value="%{getText('Visualizar comprobante SIG@')}" />

<div class="row title">
	<div class="col-md-12">
		<h1 class="title">
			<s:text name="Gestionar Actividad de Cajeros" />
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
	action="%{#pageContext.request.contextPath}/area/gestionar-responsable-area"
	method="post" theme="simple">
	<!-- Nombre del cajero -->
	<div class="form-group form-horizontal form-medium">
		<label
			class="col-xs-12 col-sm-6 col-md-6 control-label label-obligatorio"
			for=""> <s:text name="Seleccione al cajero" />
		</label>
		<div class="col-xs-12 col-sm-6 col-md-6">
			<s:select id="slcCajero" class="form-control" headerKey="-1"
				headerValue="Seleccione"
				list="#{'1':'Roberto Mendoza Saavedra', '2':'Eduardo Hernández Vargas'}"
				name="selectValue" cssErrorClass="field-error" />
			<s:fielderror fieldName="" cssClass="error" theme="bootstrap" />
		</div>
	</div>

	<div class="outter-section form-horizontal">
		<div class="col-xs-12 col-md-12 col-md-12 text-center">
			<a class="btn btn-default btn-default-spee"
				href="${pageContext.request.contextPath}/area/gestionar-responsable-area/new">Consultar</a>
		</div>
	</div>
</s:form>
<fieldset class="form form-horizontal form-medium">
	<legend class="form-section">
		<s:text name="Pagos gestionados por el cajero" />
	</legend>
	<div class="form-group">
		<div class="row">
			<div class="col-md-12">
				<table id="tblCajero" class="table table-striped">
					<thead>
						<tr>
							<th data-priority="1"><s:text name="Estatus del pago" /></th>
							<th data-priority="1"><s:text name="Nombre" /></th>
							<th data-priority="2"><s:text name="Identificador" /></th>
							<th data-priority="1"><s:text name="Fecha de entrega" /></th>
							<th data-priority="1"><s:text name="Cantidad" /></th>
							<th data-priority="1"><s:text name="Servicio" /></th>
							<th data-priority="2"><s:text name="Acciones" /></th>

						</tr>
					</thead>
					<tbody>
						<s:iterator value="listPagosCajero" var="lstPagos">
							<tr>
								<td class="material-icons  md-24 md-sem-green">&#xE061;</td>
								<td>${lstPagos[0]}</td>
								<td>${lstPagos[1]}</td>
								<td>${lstPagos[2]}</td>
								<td>${lstPagos[3]}</td>
								<td>${lstPagos[4]}</td>
								<td><a
									href="${pageContext.request.contextPath}/area/gestionar-responsable-area/1/edit"
									title="${ttbVerPago}"> <i
										class="material-icons md-24 md-eld">picture_as_pdf </i>
								</a> <a
									href="${pageContext.request.contextPath}/area/gestionar-responsable-area/1"
									title="${ttbVerSiga}"> <i
										class="material-icons md-24 md-eld">receipt </i>
								</a></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</fieldset>
	</html>
</jsp:root>