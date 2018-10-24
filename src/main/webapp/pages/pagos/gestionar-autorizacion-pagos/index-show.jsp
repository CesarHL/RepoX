<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:s="/struts-tags" xmlns:sj="/struts-jquery-tags">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:text>
	<![CDATA[                 
	]]>
</jsp:text>

<div class="row title">
	<div class="col-md-12">
		<h1 class="title">
			<s:text name="Visualizar Comprobante de Pago" />
		</h1>
	</div>
</div>
<div class="form-horizontal text-left">
		<div class="row">
			<label class="col-md-6 text-left control-label"> <s:text
					name="Identificador">
				</s:text>
			</label>
			<div class="col-md-6 text-left">
				<s:property value="infoUsuario.clave" />
			</div>
		</div>
</div>
<div class="form-section form-horizontal">
	<div class="form-group">
		<div class="row">
			<object data="path"
				type="application/pdf" width="100%" height="600">
				<p></p>
			</object>

		</div>
	</div>
</div>
<div class="text-right">
	<a
		href="${pageContext.request.contextPath}/pagos/gestionar-autorizacion-pagos!autorizarPago?${idSel}"
		class="btn btn-primary"><s:text name="Autorizar" /></a> <a
		href="${pageContext.request.contextPath}/pagos/gestionar-autorizacion-pagos!rechazarPago?${idSel}"
		class="btn btn-primary"><s:text name="Rechazar" /></a><a
		href="${pageContext.request.contextPath}/pagos/gestionar-autorizacion-pagos"
		class="btn btn-primary"><s:text name="Regresar" /> </a>
</div>

	</html>
</jsp:root>