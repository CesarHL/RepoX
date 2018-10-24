<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:s="/struts-tags" xmlns:sj="/struts-jquery-tags">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:text>
	<![CDATA[                 
	<script type="text/javascript" src="${pageContext.request.contextPath}/pages/pagos/gestionar-servicios/js/index.js"></script>
	]]>
</jsp:text>

<s:set var="varIconoAdjuntar" value="'attach_file'" />

<div class="row title">
	<div class="col-md-12">
		<h1 class="title">
			<s:text name="Visualizar Servicios" />
		</h1>
	</div>
</div>

<fieldset class="form-section form-horizontal text-justify">
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
				<div class="col-md-12">
					<table id="tblServicios" class="table table-striped">
						<thead>
							<tr>
								<th><s:text name="Concepto" /></th>
								<th><s:text name="Costo" /></th>
								<th><s:text name="Area" /></th>
								<th><s:text name="Acciones" /></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="listCatalogoServicios" var="oservicio">
								<tr>
									<td>${oservicio.descripcion	}</td>
									<td><s:text name="$"></s:text>${oservicio.precio}<s:text
											name=" MXN"></s:text></td>
									<td><s:if
											test="%{#oservicio.idArea eq @mx.ipn.escom.spee.area.mapeo.CatalogoArea$CatalogoAreaEnum@CELEX.getIdEstatus()}">
										CELEX
									</s:if> <s:elseif
											test="%{#oservicio.idArea eq @mx.ipn.escom.spee.area.mapeo.CatalogoArea$CatalogoAreaEnum@DENTALES.getIdEstatus()}">
										Servicios Dentales
									</s:elseif> <s:elseif
											test="%{#oservicio.idArea eq @mx.ipn.escom.spee.area.mapeo.CatalogoArea$CatalogoAreaEnum@FOTOCOPIADO.getIdEstatus()}">
										Servicios Fotocopiado
									</s:elseif> <s:else>
										Servicios Biblioteca
									</s:else></td>
									<td><a
										href="${pageContext.request.contextPath}/pagos/cargar-pago/new?idServicio=${oservicio.id}"
										title="Adjuntar comprobante de pago"> <i
											class="material-icons md-24">${varIconoAdjuntar}</i>
									</a></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</fieldset>
	</html>
</jsp:root>