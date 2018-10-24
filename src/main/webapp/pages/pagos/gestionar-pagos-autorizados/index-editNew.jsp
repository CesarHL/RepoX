<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:s="/struts-tags" xmlns:sj="/struts-jquery-tags">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:text>
	<![CDATA[                 
	<script type="text/javascript" src="${pageContext.request.contextPath}/pages/pagos/gestionar-pagos-autorizados/js/index-editNew.js"></script>
	]]>
</jsp:text>

<s:set var="listPagosAutorizados"
	value="{{'', 'Celex', 'Idioma Inglés Alumno', '480.00 MXN', 'Pago Inscripción'},
	 {'', 'Celex', 'Reinscripción', '580.00 MXN', 'Pago Reinscripción'},
	 {'', 'Servicios Dentales', 'Amalgama', '1080.00 MXN', 'Servicio Dental'}}" />

<s:set var="ttbVisualizar" value="%{getText('tooltipVisualizar')}" />
<s:set var="ttbArchivar" value="%{getText('tooltipArchivar')}" />

<s:set var="varIconoVisualizar" value="'&#xE8F4;'" />
<s:set var="varIconoArchivar" value="'&#xE149;'" />

<div class="row title">
	<div class="col-md-12">
		<h1 class="title">
			<s:text name="CU15_TITLE" />
		</h1>
	</div>
</div>

<div class="form-section form-horizontal">
	<div class="form-group">
		<div class="row">
			<div class="col-md-12">
				<table id="tblPagosAutorizados" class="table table-striped">
					<thead>
						<tr>
							<th><s:text name="CU15_THEAD1" /></th>
							<th><s:text name="CU15_THEAD2" /></th>
							<th><s:text name="CU15_THEAD3" /></th>
							<th><s:text name="CU15_THEAD4" /></th>
							<th><s:text name="CU15_THEAD5" /></th>
							<th><s:text name="CU15_THEAD6" /></th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="listPagosAutorizados" var="pagoAutorizado">
							<tr>
								<td>${pagoAutorizado[0]}</td>
								<td>${pagoAutorizado[1]}</td>
								<td>${pagoAutorizado[2]}</td>
								<td><a
									href="${pageContext.request.contextPath}/pagos/gestionar-archivo-pagos/show"
									title="${ttbVisualizar}"> <i
										class="material-icons md-24 md-eld">${varIconoVisualizar}</i>
								</a><a
									href="${pageContext.request.contextPath}/pagos/gestionar-archivo-pagos/show"
									title="${ttbArchivar}"> <i
										class="material-icons md-24 md-eld">${varIconoArchivar}</i>
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