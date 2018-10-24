<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:s="/struts-tags" xmlns:sj="/struts-jquery-tags">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:text>
	<![CDATA[                 
	<script type="text/javascript" src="${pageContext.request.contextPath}/pages/area/gestionar-area/js/index.js"></script>
	]]>
</jsp:text>

<s:set var="listAreas"
	value="{{'Celex','Cursos extracurriculares de lenguas extranjeras'},{'Biblioteca','Biblioteca de la ESCOM'}}" />

<s:set var="ttbVisualizar" value="%{getText('Visualizar')}" />
<s:set var="ttbEditar" value="%{getText('Editar')}" />
<s:set var="ttbBaja" value="%{getText('Dar de baja')}" />
<s:set var="ttbReactivar" value="%{getText('Reactivar')}" />

<div class="row title">
	<div class="col-md-12">
		<h1 class="title">
			<s:text name="Gestionar Areas" />
		</h1>
	</div>
</div>

<div class="form-section form-horizontal">
	<div class="form-group">
		<div class="row">
			<div class="col-md-12">
				<table id="tblAreas" class="table table-striped">
					<thead>
						<tr>
							<th><s:text name="Nombre" /></th>
							<th><s:text name="Descripcion" /></th>
							<th><s:text name="Acciones" /></th>

						</tr>
					</thead>
					<tbody>
						<s:iterator value="listAreas" var="area">
							<tr>
								<td><s:property value="%{#area.nombreArea}" /></td>
								<td><s:property value="%{#area.descripcion}" /></td>
								<td><a
									href="${pageContext.request.contextPath}/area/gestionar-area/1/edit"
									title="${ttbEditar}"> <i
										class="material-icons md-24 md-eld">edit</i>
								</a> <a
									href="${pageContext.request.contextPath}/area/gestionar-area/1"
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
	</html>
</jsp:root>