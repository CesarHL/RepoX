<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:s="/struts-tags" xmlns:sj="/struts-jquery-tags">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:text>
	<![CDATA[                 
	<script type="text/javascript" src="${pageContext.request.contextPath}/pages/pagos/gestionar-archivo-pagos/js/index-show.js"></script>
	]]>
</jsp:text>

<s:set var="listArchivoPagoMes"
	value="{{'000001', '01/02/2018', 'Celex', 'Idioma Inglés Alumno','480.00 MXN'},
	 {'000002','01/02/2018','Celex','Reinscripción','580.00 MXN'},
	 {'000003','01/02/2018','Servicios Dentales','Amalgama','1080.00 MXN'}}" />

<s:set var="ttbVisualizar" value="%{getText('tooltipVisualizar')}" />
<s:set var="ttbImprimir" value="%{getText('tooltipImprimir')}" />

<s:set var="varIconoImprimir" value="'&#xE8AD;'" />
<s:set var="varIconoVisualizar" value="'&#xE415;'" />

<div class="row title">
	<div class="col-md-12">
		<h1 class="title">
			<s:text name="CU38_TITLE" />
		</h1>
	</div>
</div>

<div class="form-section form-horizontal">
	<div class="form-group">
		<div class="row">
			<div class="col-md-12">
				<table id="tblArchivoPagoMes" class="table table-striped">
					<thead>
						<tr>
							<th><s:text name="CU38_THEAD1" /></th>
							<th><s:text name="CU38_THEAD2" /></th>
							<th><s:text name="CU38_THEAD3" /></th>
							<th><s:text name="CU38_THEAD4" /></th>
							<th><s:text name="CU38_THEAD5" /></th>
							<th><s:text name="CU38_THEAD6" /></th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="listArchivoPagoMes" var="pagoMes">
							<tr>
								<td>${pagoMes[0]}</td>
								<td>${pagoMes[1]}</td>
								<td>${pagoMes[2]}</td>
								<td>${pagoMes[3]}</td>
								<td>${pagoMes[4]}</td>
								<td><a
									href="${pageContext.request.contextPath}/pagos/gestionar-archivo-pagos/show"
									title="${ttbVisualizar}"> <i
										class="material-icons md-24 md-eld">${varIconoVisualizar}</i>
								</a><a
									href="${pageContext.request.contextPath}/pagos/gestionar-archivo-pagos/show"
									title="${ttbImprimir}"> <i
										class="material-icons md-24 md-eld">${varIconoImprimir}</i>
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