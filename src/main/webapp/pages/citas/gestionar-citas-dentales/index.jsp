<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:s="/struts-tags" xmlns:sj="/struts-jquery-tags">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:text>
	<![CDATA[                 
	<script type="text/javascript" src="${pageContext.request.contextPath}/pages/citas/gestionar-citas-dentales/js/index.js"></script>
	]]>
</jsp:text>

<s:set var="listPagosAutorizados" value="{{'','Juan Carlos','2013660005', '04/07/2018', '15:00'}}" />

<s:set var="ttbVisualizar" value="%{getText('tooltipVisualizar')}" />
<s:set var="ttbAdjuntar" value="%{getText('tooltipAdjuntar')}" />
<s:set var="ttbVerCuestionario" value="%{getText('Ver Cuestionario')}" />
<s:set var="ttbRealizarConsulta" value="%{getText('Realizar Consulta')}" />
<s:set var="ttbVerHistorialClinico" value="%{getText('Visualizar Historial Clínico')}" />
<s:set var="ttbCancelarCita" value="%{getText('Cancelar Cita')}" />
<s:set var="ttbInasistencia" value="%{getText('Marcar Inasistencia')}" />

<s:set var="varIconoVisualizar" value="'&#xE8F4;'" />
<s:set var="varIconoVisualizarCuestionario" value="description"/>
<s:set var="varIconoAdjuntar" value="'&#xE5D8;'" />

<div class="row title">
	<div class="col-md-12">
		<h1 class="title">
			<s:text name="Gestionar Citas Agendadas" />
		</h1>
	</div>
</div>

<div class="form-section form-horizontal">
	<div class="form-group">
		<div class="row">
			<div class="col-md-12">
				<table id="tblPagosPorAutorizar" class="table table-striped">
					<thead>
						<tr>
							<th><s:text name="Estatus" /></th>
							<th><s:text name="Nombre del paciente" /></th>
							<th><s:text name="Identificador"/></th>
							<th><s:text name="Fecha" /></th>
							<th><s:text name="Hora" /></th>
							<th><s:text name="Acciones"/></th>
							
						</tr>
					</thead>
					<tbody>
						<s:iterator value="listPagosAutorizados" var="pagoAutorizado">
							<tr>
								<td class="material-icons  md-24 md-sem-green">&#xE061;</td>
								<td>${pagoAutorizado[1]}</td>
								<td>${pagoAutorizado[2]}</td>
								<td>${pagoAutorizado[3]}</td>
								<td>${pagoAutorizado[4]}</td>

								<td>
								<a
									href="${pageContext.request.contextPath}/consulta/gestionar-consulta/new"
									title="${ttbRealizarConsulta}"> <i
										class="material-icons md-24 md-eld">local_hospital</i>
								</a>
								<a
									href="${pageContext.request.contextPath}/consulta/gestionar-historial-clinico/1"
									title="${ttbVerHistorialClinico}"> <i
										class="material-icons md-24 md-eld">history</i>
								</a>
								<a
									title="${ttbInasistencia}"> <i
										class="material-icons md-24 md-eld">alarm_off</i>
								</a>
								<a
									title="${ttbCancelarCita}"> <i
										class="material-icons md-24 md-eld">cancel</i>
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

<div class="text-left">
<div class="col-md-12">
		<label class="control-label"><i
			class="material-icons  md-24 md-sem-green ">&#xE061;</i></label> <label><s:text
				name="Sin adeudos"></s:text></label>
	</div>
	<div class="col-md-12">
		<label class="control-label"><i
			class="material-icons  md-24 md-sem-rojo ">&#xE061;</i></label> <label><s:text
				name="Con adeudos"></s:text></label>
	</div>
</div>

	</html>
</jsp:root>