<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:s="/struts-tags" xmlns:sj="/struts-jquery-tags">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:text>
	<![CDATA[                 
	<script type="text/javascript" src="${pageContext.request.contextPath}/pages/pagos/gestionar-archivo-pagos/js/index.js"></script>
	]]>
</jsp:text>

<s:set var="listHorariosMatutino"
	value="{{'Lunes','9:30 - 12:00'},
	 {'Martes', '9:30 - 12:00'}}" />

<s:set var="listHorariosVespertino"
	value="{{'Lunes','13:30 - 15:00'},
	 {'Martes', '13:30 - 15:00'}}" />

<s:set var="ttbVisualizar" value="%{getText('tooltipVisualizar')}" />
<s:set var="varIconoVisualizar" value="'&#xE8F4;'" />

<div class="row title">
	<div class="col-md-12">
		<h1 class="title">
			<s:text name="CU95_TITLE" />
		</h1>
	</div>
</div>

<div class="row">
		<div class="col-md-12">
			<s:actionmessage theme="%{getText('mx.edu.eld.defaulTheme')}" />
			<s:actionerror theme="%{getText('mx.edu.eld.defaulTheme')}" />
		</div>
	</div>

<s:form id="frmActualizarEstadoPago" enctype="multipart/form-data"
		action="%{#pageContext.request.contextPath}/citas/gestionar-citas-dentales"
		theme="simple" method="post">

<div class="">
	<div class="row">
		<label class="col-md-4 text-left control-label"> <s:text
				name="CU95_LBL1">
			</s:text>
		</label><label class="col-md-4 text-left"> <s:iterator
				value="listHorariosMatutino" var="pagoMatutino">
				<ul>
					<li>${pagoMatutino[0]} ${pagoMatutino[1]}</li>
				</ul>
			</s:iterator>
		</label>
	</div>
	<div class="row">
		<label class="col-md-4 text-left control-label"> <s:text
				name="CU95_LBL2">
			</s:text>
		</label> <label class="col-md-4 text-left"> <s:iterator
				value="listHorariosVespertino" var="pagoVespertino">
				<ul>
					<li>${pagoVespertino[0]} ${pagoVespertino[1]}</li>
				</ul>
			</s:iterator>
		</label>
	</div>
	<div class="row">
		<label class="col-md-4 text-left control-label"> <s:text
				name="CU95_LBL3">
			</s:text>
		</label>
		<div class="col-md-8 input-min">
			<sj:datepicker id="dpInicio" name="fechaSel.fechaInicio"
				cssClass="form-control date-picker" showOn="focus"
				displayFormat="%{getText('mx.edu.eld.jsFormatDate')}"
				inputAppendIcon="calendar" changeYear="true" changeMonth="true"
				readonly="true" showAnim="fadeIn" minDate="%{#setInicio}"
				maxDate="%{#setFinal}" />
			<s:fielderror fieldName="fechaSel.fechaInicio" cssClass="error"
				theme="%{getText('mx.edu.eld.defaulTheme')}"></s:fielderror>
		</div>
	</div>
</div>

<div class="col-md-12 text-right">
			<s:submit cssClass="btn btn-primary"
				value="Aceptar"></s:submit>
			<a
				href="${pageContext.request.contextPath}/pagos/gestionar-autorizacion-pagos"
				class="btn btn-primary"><s:text name="Regresar" /></a>
		</div>

</s:form>

	</html>
</jsp:root>