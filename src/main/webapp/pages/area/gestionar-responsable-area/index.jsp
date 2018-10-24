<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:s="/struts-tags" xmlns:sj="/struts-jquery-tags">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:text>
	<![CDATA[                 
	<script type="text/javascript" src="${pageContext.request.contextPath}/pages/area/gestionar-responsable-area/js/index.js"></script>
	]]>
</jsp:text>

<s:set var="listResponsables"
	value="{{'Angélica Pérez Beltrán','Celex','celexescom@gmail.com','5541698475'},{'Fanny Sosa Adán','Biblioteca','bibliotecaescom@gmail.com','Sin teléfono'}}" />

<s:set var="ttbVisualizar" value="%{getText('Visualizar')}" />
<s:set var="ttbEditar" value="%{getText('Editar')}" />
<s:set var="ttbBaja" value="%{getText('Dar de baja')}" />
<s:set var="ttbReactivar" value="%{getText('Reactivar')}" />

<div class="row title">
	<div class="col-md-12">
		<h1 class="title">
			<s:text name="Gestionar Responsables de Areas" />
		</h1>
	</div>
</div>

<!-- Action messages -->
<div class="form-group">
	<div class="col-md-8 col-md-offset-2">
		<s:actionmessage cssClass="alert alert-success" />
		<s:actionerror cssClass="alert alert-danger" />
	</div>
</div>

<div class="form-section form-horizontal">
	<div class="form-group">
		<div class="row">
			<div class="col-md-12">
				<table id="tblResponsables" class="table table-striped">
					<thead>
						<tr>
							<th data-priority="1"><s:text name="Nombre" /></th>
							<th data-priority="1"><s:text name="Area responsable" /></th>
							<th data-priority="1"><s:text name="Correo electronico" /></th>
							<th data-priority="2"><s:text name="Numero de contacto" /></th>
							<th data-priority="2"><s:text name="Acciones" /></th>

						</tr>
					</thead>
					<tbody>
						<s:iterator value="listResponsablesArea" var="lstResponsables">
							<tr>
								<td><s:property
										value="%{#lstResponsables.nombre + ' ' + #lstResponsables.primerApellido + ' ' + #lstResponsables.segundoApellido}" /></td>
								<s:if test="%{#lstResponsables.idCuenta == 2}">
									<td><s:property value="nbCelex" /></td>
								</s:if>
								<s:elseif test="%{#lstResponsables.idCuenta == 3}">
									<td><s:property value="nbDentalM" /></td>
								</s:elseif>
								<s:elseif test="%{#lstResponsables.idCuenta == 15}">
									<td><s:property value="nbDentalV" /></td>
								</s:elseif>
								<s:elseif test="%{#lstResponsables.idCuenta == 4}">
									<td><s:property value="nbBiblio" /></td>
								</s:elseif>
								<s:else>
									<td><s:property value="nbCopia" /></td>
								</s:else>
								<td><s:property value="%{#lstResponsables.correo}" /></td>
								<s:if
									test="%{#lstResponsables.celular == null || #lstResponsables.celular == ''}">
									<td><s:property value="'Sin teléfono'" /></td>
								</s:if>
								<s:else>
									<td><s:property value="%{#lstResponsables.celular}" /></td>
								</s:else>
								<td><a
									href="${pageContext.request.contextPath}/area/gestionar-responsable-area/${lstResponsables.idCuenta}/edit"
									title="${ttbEditar}"> <i
										class="material-icons md-24 md-eld">edit</i>
								</a> <a
									href="${pageContext.request.contextPath}/area/gestionar-responsable-area/${lstResponsables.idCuenta}"
									title="${ttbVisualizar}"> <i
										class="material-icons md-24 md-eld">remove_red_eye </i>
								</a> <a title="${ttbBaja}"> <i
										class="material-icons md-24 md-eld">cancel</i>
								</a></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<div class="outter-section form-horiontal">
	<div class="col-xs-12 col-md-12 col-md-12 text-center">
		<a class="btn btn-default btn-default-spee"
			href="${pageContext.request.contextPath}/area/gestionar-responsable-area/new">Registrar</a>
	</div>
</div>

	</html>
</jsp:root>