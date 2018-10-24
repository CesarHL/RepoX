<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:s="/struts-tags" xmlns:sj="/struts-jquery-tags">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:text>
	<![CDATA[                 
	<script type="text/javascript" src="${pageContext.request.contextPath}/pages/servicio/gestionar-servicio/js/index.js"></script>
	]]>
</jsp:text>

<s:set var="listServicios"
	value="{{'0853','Curso','Curso de idiomas semanal o sabatino. 40 horas. Comunidad IPN.','$544.00','Celex'},{'0858','Curso','Curso de idiomas semanal o sabatino. 40 horas. Público en general. ','$1053.00','Celex'}}" />

<s:set var="ttbVisualizar" value="%{getText('Visualizar')}" />
<s:set var="ttbEditar" value="%{getText('Editar')}" />
<s:set var="ttbBaja" value="%{getText('Dar de baja')}" />
<s:set var="ttbReactivar" value="%{getText('Reactivar')}" />

<div class="row title">
	<div class="col-md-12">
		<h1 class="title">
			<s:text name="Gestionar Servicios" />
		</h1>
	</div>
</div>

<div class="form-section form-horizontal">
	<div class="form-group">
		<div class="row">
			<div class="col-md-12">
				<table id="tblServicios" class="table table-striped">
					<thead>
						<tr>
							<th data-priority="1"><s:text name="Clave" /></th>
							<th data-priority="2"><s:text name="Tipo de servicio" /></th>
							<th data-priority="2"><s:text name="Descripcion" /></th>
							<th data-priority="1"><s:text name="Costo" /></th>
							<th data-priority="1"><s:text name="Area a la que pertenece" /></th>
							<th data-priority="2"><s:text name="Acciones" /></th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="listServicios" var="lstServ">
							<tr>
								<td>${lstServ[0]}</td>
								<td>${lstServ[1]}</td>
								<td>${lstServ[2]}</td>
								<td>${lstServ[3]}</td>
								<td>${lstServ[4]}</td>
								<td><a
									href="${pageContext.request.contextPath}/servicio/gestionar-servicio/1/edit"
									title="${ttbEditar}"> <i
										class="material-icons md-24 md-eld">edit</i>
								</a> <a
									href="${pageContext.request.contextPath}/servicio/gestionar-servicio/1"
									title="${ttbVisualizar}"> <i
										class="material-icons md-24 md-eld">remove_red_eye </i>
								</a> <a title="${ttbBaja}"> <i
										class="material-icons md-24 md-eld">cancel</i>
								</a> <a title="${ttbReactivar}"> <i
										class="material-icons md-24 md-eld">check_circle</i>
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
			href="${pageContext.request.contextPath}/servicio/gestionar-servicio/new">Registrar</a>
	</div>
</div>

	</html>
</jsp:root>