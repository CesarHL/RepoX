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
		src="${pageContext.request.contextPath}/pages/pagos/cargar-pago/js/index-editNew.js"
		type="text/javascript"></script>
	]]>
</jsp:text>
</head>
<body>
	<div class="row title">
		<div class="col-md-12">
			<h1 class="title">
				<s:text name="Cargar Comprobante SIG@" />
			</h1>
		</div>
	</div>

	<s:form id="frmActualizarEstadoPago" enctype="multipart/form-data"
		action="%{#pageContext.request.contextPath}/pagos/gestionar-autorizacion-pagos"
		theme="simple" method="post">
		<s:hidden name="idServicio" value="%{idServicio}"></s:hidden>
		<fieldset
			class="form-section form-horizontal form-medium text-justify">
			<label> <s:text
					name="El archivo que proporciona representa un pago oficial y debe contar con lo siguiente: " />
			</label>
			<div class="text-left">
				<ul>
					<li>El formato debe ser .pdf</li>
					<li>Debe poderse visualizar claramente</li>
				</ul>
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label "> <s:text
						name="Nombre "></s:text>
				</label>
				<div class="col-md-6">
					<div class="input-group">
						<input type="text" class="form-control" id="fileName"
							readonly="true" /> <span class="input-group-btn" id="loadImage">
							<i class="material-icons md-24 md-eld">file_upload</i>
						</span>
					</div>
					<s:fielderror fieldName="archivo.fileUpload" cssClass="error"
						theme="bootstrap" />
				</div>
				<div class="col-xs-12 col-sm-8 col-md-1">
					<input type='file' id="fileUpload" name="archivo.fileUpload"
						class="hide" accept=".pdf" value="" />
				</div>
			</div>
		</fieldset>
		<div class="col-md-12 text-right">
			<s:submit cssClass="btn btn-primary"
				value="Aceptar"></s:submit>
			<a
				href="${pageContext.request.contextPath}/pagos/gestionar-autorizacion-pagos"
				class="btn btn-primary"><s:text name="Cancelar" /></a>
		</div>
	</s:form>
</body>
	</html>
</jsp:root>