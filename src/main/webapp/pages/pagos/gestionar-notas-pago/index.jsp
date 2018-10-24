<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:s="/struts-tags" xmlns:sj="/struts-jquery-tags">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:text>
	<![CDATA[                 
	<script type="text/javascript" src="${pageContext.request.contextPath}/pages/pagos/gestionar-notas-pago/js/index.js"></script>
	]]>
</jsp:text>

<s:set var="listNotasPago" value="{{'Dentales', '$670.00 MXN'}}" />

<s:set var="ttbVisualizar" value="%{getText('tooltipVisualizar')}" />
<s:set var="ttbPagarCaja" value="%{getText('tooltipPagarCaja')}" />
<s:set var="ttbSubirArchivo" value="%{getText('tooltipSubirArchivo')}" />

<s:set var="varIconoVisualizar" value="'&#xE415;'" />
<s:set var="varIconoPagarCaja" value="'&#xE227;'" />
<s:set var="varIconoSubirArchivo" value="'&#xE5D8;'" />

<div class="row title">
	<div class="col-md-12">
		<h1 class="title">
			<s:text name="Gestionar Notas de Pago" />
		</h1>
	</div>
</div>

<div class="form-section form-horizontal">
	<div class="form-group">
		<div class="row">
			<div class="col-md-12">
				<table id="tblNotasPago" class="table table-striped">
					<thead>
						<tr>
							<th><s:text name="Concepto" /></th>
							<th><s:text name="Monto" /></th>
							<th><s:text name="Acciones" /></th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="listNotasPago" var="ntPago">
							<tr>
								<td>${ntPago[0]}</td>
								<td>${ntPago[1]}</td>
								<td><a href="#" title="${ttbVisualizar}"> <i
										class="material-icons md-24">${varIconoVisualizar}</i>
								</a> <a href="#" title="${ttbPagarCaja}"> <i
										class="material-icons md-24">${varIconoPagarCaja}</i>
								</a> <a href="#" title="${ttbSubirArchivo}"> <i
										class="material-icons md-24">${varIconoSubirArchivo}</i>
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