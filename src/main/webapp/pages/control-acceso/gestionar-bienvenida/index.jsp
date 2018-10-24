<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:s="/struts-tags" xmlns:sj="/struts-jquery-tags">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
</head>
<body>
	<s:set var="usuario" value="%{#session[@mx.ipn.escom.spee.action.NombreObjetosSesion@USUARIO_SESION]}" />
    <s:set var="varSUBDIRECTOR" value="%{@mx.edu.spee.controlacceso.mapeo.Perfil$PerfilEnum@SUBDIRECTOR.getValor()}" />
 	<s:set var="varCELEX" value="%{@mx.edu.spee.controlacceso.mapeo.Perfil$PerfilEnum@ADMINISTRADOR_CELEX.getValor()}" />
 	<s:set var="varDENTALES" value="%{@mx.edu.spee.controlacceso.mapeo.Perfil$PerfilEnum@ADMINISTRADOR_DENTALES.getValor()}" />
 	<s:set var="varBIBLIOTECA" value="%{@mx.edu.spee.controlacceso.mapeo.Perfil$PerfilEnum@ADMINISTRADOR_BIBLIOTECA.getValor()}" />
 	<s:set var="varFOTOCOPIADO" value="%{@mx.edu.spee.controlacceso.mapeo.Perfil$PerfilEnum@ADMINISTRADOR_FOTOCOPIADO.getValor()}" />
 	<s:set var="varCAJERO" value="%{@mx.edu.spee.controlacceso.mapeo.Perfil$PerfilEnum@ENCARGADO_CAJA.getValor()}" />
 	<s:set var="varCONTADOR" value="%{@mx.edu.spee.controlacceso.mapeo.Perfil$PerfilEnum@CONTADOR.getValor()}" />
 	<s:set var="varTRABAJADOR" value="%{@mx.edu.spee.controlacceso.mapeo.Perfil$PerfilEnum@TRABAJADOR.getValor()}" />
 	<s:set var="varEXTERNO" value="%{@mx.edu.spee.controlacceso.mapeo.Perfil$PerfilEnum@EXTERNO.getValor()}" />
 	<s:set var="varALUMNO" value="%{@mx.edu.spee.controlacceso.mapeo.Perfil$PerfilEnum@ALUMNO.getValor()}" />
 	
	<div class="row title">
		<div class="col-md-12">
			<h1 class="title">
				<s:text name="CU51_TITLE" />
			</h1>
		</div>
	</div>

	<div class="form-group">
		<div class="col-md-8 col-md-offset-2">
			<s:actionmessage cssClass="alert alert-success" />
		</div>
	</div>
	
	<div class="outter-section form form-medium">
		<s:if test="#usuario.perfilActivo.id == #varSUBDIRECTOR">
			<s:text name="CU51_LBL1">
				<s:param>
					Subdirector Administrativo
				</s:param>
			</s:text>
		</s:if>
		<s:elseif test="#usuario.perfilActivo.id == #varCELEX">
			<s:text name="CU51_LBL1">
				<s:param>
					Coordinador CELEX
				</s:param>
			</s:text>
		</s:elseif>
		<s:elseif test="#usuario.perfilActivo.id == #varDENTALES">
			<s:text name="CU51_LBL1">
				<s:param>
					Dentista
				</s:param>
			</s:text>
		</s:elseif>
		<s:elseif test="#usuario.perfilActivo.id == #varBIBLIOTECA">
			<s:text name="CU51_LBL1">
				<s:param>
					Administrador de Biblioteca
				</s:param>
			</s:text>
		</s:elseif>
		<s:elseif test="#usuario.perfilActivo.id == #varFOTOCOPIADO">
			<s:text name="CU51_LBL1">
				<s:param>
					Administrador de Fotocopiado
				</s:param>
			</s:text>
		</s:elseif>
		<s:elseif test="#usuario.perfilActivo.id == #varCAJERO">
			<s:text name="CU51_LBL1">
				<s:param>
					Cajero
				</s:param>
			</s:text>
		</s:elseif>
		<s:elseif test="#usuario.perfilActivo.id == #varCONTADOR">
			<s:text name="CU51_LBL1">
				<s:param>
					Contador
				</s:param>
			</s:text>
		</s:elseif>
		<s:elseif test="#usuario.perfilActivo.id == #varTRABAJADOR">
			<s:text name="CU51_LBL1">
				<s:param>
					Trabajador IPN
				</s:param>
			</s:text>
		</s:elseif>
		<s:elseif test="#usuario.perfilActivo.id == #varALUMNO">
			<s:text name="CU51_LBL1">
				<s:param>
					Alumno IPN
				</s:param>
			</s:text>
		</s:elseif>
		<s:elseif test="#usuario.perfilActivo.id == #varEXTERNO">
			<s:text name="CU51_LBL1">
				<s:param>
					Externo
				</s:param>
			</s:text>
		</s:elseif>
	</div>
</body>
	</html>
</jsp:root>