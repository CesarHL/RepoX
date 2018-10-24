<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:s="/struts-tags" xmlns:sj="/struts-jquery-tags">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:text>
	<![CDATA[                 
	<script type="text/javascript" src="${pageContext.request.contextPath}/pages/pagos/gestionar-pagos/js/index.js"></script>
	]]>
</jsp:text>

<s:set var="ttbVisualizar" value="%{getText('tooltipVisualizar')}" />
<s:set var="varIconoVisualizar" value="'&#xE415;'" />

<div class="row title">
	<div class="col-md-12">
		<h1 class="title">
			<s:text name="Gestionar Pagos" />
		</h1>
	</div>
</div>

<div class="form-group">
	<div class="col-md-12">
		<s:actionmessage cssClass="alert alert-success" />
		<s:actionerror />
	</div>
</div>

<fieldset class="form-section form-horizontal text-justify">
	<div class="form-section form-horizontal">
		<div class="form-group">
			<div class="row">
				<div class="col-md-12">
					<table id="tblPagosEnviados" class="table table-striped">
						<thead>
							<tr>
								<th><s:text name="Estado" /></th>
								<th><s:text name="Fecha" /></th>
								<th><s:text name="Concepto" /></th>
								<th><s:text name="Costo" /></th>
								<th><s:text name="Acciones" /></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="listPagos" var="pagAutorizado">
								<tr>
									<td><s:if
											test="%{#pagAutorizado.idEstadoPago eq @mx.ipn.escom.spee.pagos.mapeo.EstadoPago$EstadoPagoEnum@AUTORIZADO.getIdEstatus()}">
											<i class="material-icons  md-24 md-eld-green ">&#xE061;</i>
										</s:if> <s:elseif
											test="%{#pagAutorizado.idEstadoPago  eq @mx.ipn.escom.spee.pagos.mapeo.EstadoPago$EstadoPagoEnum@REVISION.getIdEstatus()}">
											<i class="material-icons  md-24 md-sem-yellow ">&#xE061;</i>
										</s:elseif> <s:elseif
											test="%{#pagAutorizado.idEstadoPago  eq @mx.ipn.escom.spee.pagos.mapeo.EstadoPago$EstadoPagoEnum@RECHAZADO.getIdEstatus()}">
											<i class="material-icons  md-24 md-sem-rojo ">&#xE061;</i>
										</s:elseif></td>
									<td><s:date name="%{#pagAutorizado.fechaEnvio}"
											format="yyyy-MM-dd" /></td>
									<td><s:text name="%{#pagAutorizado.catalogoServicio.descripcion}"/></td>
									<td>$ ${pagAutorizado.catalogoServicio.precio} MXN</td>
									<td>
									<a
										href="${pageContext.request.contextPath}/pagos/gestionar-pagos!visualizarArchivo?idPago=${pagAutorizado.id}"
										title="Visualizar Archivo de Pago"> <i
											class="material-icons md-24">${varIconoVisualizar}</i>
									</a>
									</td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</fieldset>
<div class="text-left">
	<div class="col-md-12">
		<label class="control-label"><i
			class="material-icons  md-24 md-sem-green ">&#xE061;</i></label> <label><s:text
				name="Pago autorizado por caja"></s:text></label>
	</div>
	<div class="col-md-12">
		<label class="control-label"><i
			class="material-icons  md-24 md-sem-yellow ">&#xE061;</i></label> <label><s:text
				name="Pago en espera de ser procesado"></s:text></label>
	</div>
	<div class="col-md-12">
		<label class="control-label"><i
			class="material-icons  md-24 md-sem-rojo ">&#xE061;</i></label> <label><s:text
				name="Pago rechazado"></s:text></label>
	</div>
</div>
	</html>
</jsp:root>