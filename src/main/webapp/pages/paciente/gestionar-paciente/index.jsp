<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:s="/struts-tags" xmlns:sj="/struts-jquery-tags">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:text>
	<![CDATA[                 
	<script type="text/javascript" src="${pageContext.request.contextPath}/pages/paciente/gestionar-paciente/js/index.js"></script>
	]]>
</jsp:text>

<s:set var="listPacientes"
	value="{{'Juan Carlos Huesca Mata','2013660005'}}" />

<s:set var="ttbVisualizar"
	value="'Visualizar historial clínico'" />

<div class="row title">
	<div class="col-md-12">
		<h1 class="title">
			<s:text name="Consultar Pacientes" />
		</h1>
	</div>
</div>

<div class="form-section form-horizontal">
	<div class="form-group">
		<div class="row">
			<div class="col-md-12">
				<table id="tblPacientes" class="table table-striped">
					<thead>
						<tr>
							<th><s:text name="Nombre del paciente" /></th>
							<th><s:text name="Identificador" /></th>
							<th><s:text name="Acciones" /></th>

						</tr>
					</thead>
					<tbody>
						<s:iterator value="listPacientes" var="pac">
							<tr>
								<td>${pac[0]}</td>
								<td>${pac[1]}</td>
								<td><a
									href="${pageContext.request.contextPath}/consulta/gestionar-historial-clinico/1"
									title="${ttbVisualizar}"> <i
										class="material-icons md-24 md-eld">history</i>
								</a></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
	</html>
</jsp:root>