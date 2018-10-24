<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:s="/struts-tags" xmlns:sj="/struts-jquery-tags">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:text>
	<![CDATA[                 
	<script type="text/javascript" src="${pageContext.request.contextPath}/pages/consulta/gestionar-historial-clinico/js/index-show.js"></script>
	]]>
</jsp:text>

<s:set var="listHistorialConsultas"
	value="{{'04/08/2018'},{'04/07/2018'}}" />
<s:set var="ttbVisualizarConsulta"
	value="%{getText('Visualizar consulta')}" />
<s:set var="ttbVerNotaPago" value="%{getText('Visualizar nota de pago')}" />

<div class="row title">
	<div class="col-md-12">
		<h1 class="title">
			<s:text name="Visualizar Historial Clinico" />
		</h1>
	</div>
</div>

<div class="form-section form-horizontal">
	<div class="form-group">
		<div class="row">
			<div class="form-group text-justify">
				<label class="col-sm-6 col-md-6 control-label" for=""> <s:text
						name="Nombre" />
				</label>
				<div class="col-sm-6 col-md-6">
					<s:property value="'Juan Carlos Huesca Mata'" />
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

			<div class="col-md-12">
				<table id="tblHistorialConsultas" class="table table-striped">
					<thead>
						<tr>
							<th><s:text name="Estatus" /></th>
							<th><s:text name="Fecha de la consulta" /></th>
							<th><s:text name="Acciones" /></th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="listHistorialConsultas" var="historial">
							<tr>
								<td class="material-icons  md-24 md-sem-green">&#xE061;</td>
								<td>${historial[0]}</td>
								<td><a
									href="${pageContext.request.contextPath}/consulta/gestionar-consulta/1"
									title="${ttbVisualizarConsulta}"> <i
										class="material-icons md-24 md-eld">chrome_reader_mode</i>
								</a> <a
									href="${pageContext.request.contextPath}/nota-pago/gestionar-nota-pago!visualizarNotaDental"
									title="${ttbVerNotaPago}"> <i
										class="material-icons md-24 md-eld">pageview</i>
								</a></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<div class="text-right">
	<a
		href="${pageContext.request.contextPath}/paciente/gestionar-paciente"
		class="btn btn-default btn-default-eld"><s:text
			name="Regresar" /></a>
</div>
	</html>
</jsp:root>