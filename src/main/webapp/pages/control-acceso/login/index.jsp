<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:s="/struts-tags" xmlns:sj="/struts-jquery-tags">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>

</head>
<body>
	<s:set var="varTheme" value="%{getText('mx.edu.spee.defaulTheme')}" />

	<div class="col-md-12">
		<h1 class="title">
			<s:text name="CU4_TITLE"></s:text>
		</h1>
	</div>

	<div class="row form-group">
		<div class="col-md-8 col-md-offset-2">
			<s:actionerror theme="%{varTheme}" />
			<s:actionmessage theme="%{varTheme}" />
		</div>
	</div>

	<div class="col-sm-12">
		<s:form id="frmLogin" method="post" theme="simple"
			cssClass="form form-horizontal form-medium"
			action="%{#pageContext.request.contextPath}/control-acceso/login">
			<div class="form-group">
				<label
					class="col-xs-2 col-sm-4 col-md-4 control-label label-obligatorio">
					<s:text name="Correo" />
				</label>
				<div class="col-xs-12 col-sm-8 col-md-8">
					<s:textfield cssClass="form-control campo"
						cssClassError="input-error" name="login" id="txUsuario" />
					<s:fielderror fieldName="login" cssClass="error"
						theme="%{#varTheme}" />
				</div>
			</div>

			<div class="form-group">
				<label
					class="col-xs-2 col-sm-4 col-md-4 control-label label-obligatorio"><s:text
						name="CU4_LBL2" /></label>
				<div class="col-xs-12 col-sm-8 col-md-8 ">
					<s:password cssClass="form-control campo" name="password"
						cssClassError="input-error" id="txPass" maxlength="10"
						required="true" />
					<s:fielderror fieldName="password" cssClass="error"
						theme="%{#varTheme}" />
				</div>
			</div>
			<div class="form-medium text-right">
				<div class="col-xs-12 col-md-12 col-md-12">
					<s:submit cssClass="btn btn-primary" key="CU4_LBL4" />
				</div>

			</div>
		</s:form>
		
		<div class="form-medium text-right">
			<div class="col-xs-12 col-md-12 col-md-12">
				<a
					href="${pageContext.request.contextPath}/control-acceso/registrar-usuario/new"><s:text
						name="CU4_LBL3" /></a>
			</div>
		</div>
	</div>
</body>
	</html>
</jsp:root>