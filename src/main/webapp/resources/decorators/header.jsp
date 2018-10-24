<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:decorator="http://www.opensymphony.com/sitemesh/decorator"
	xmlns:c="http://java.sun.com/jsp/jstl/core" xmlns:s="/struts-tags"
	xmlns:sj="/struts-jquery-tags"
	xmlns:log="http://jakarta.apache.org/taglibs/log-1.0">
	<jsp:directive.page language="java"
		contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" />

	<s:set var="usuario"
		value="%{#session[@mx.ipn.escom.spee.action.NombreObjetosSesion@USUARIO_SESION]}" />

	<s:set var="varSUBDIRECTOR"
		value="%{@mx.edu.spee.controlacceso.mapeo.Perfil$PerfilEnum@SUBDIRECTOR.getValor()}" />
	<s:set var="varCELEX"
		value="%{@mx.edu.spee.controlacceso.mapeo.Perfil$PerfilEnum@ADMINISTRADOR_CELEX.getValor()}" />
	<s:set var="varDENTALES"
		value="%{@mx.edu.spee.controlacceso.mapeo.Perfil$PerfilEnum@ADMINISTRADOR_DENTALES.getValor()}" />
	<s:set var="varBIBLIOTECA"
		value="%{@mx.edu.spee.controlacceso.mapeo.Perfil$PerfilEnum@ADMINISTRADOR_BIBLIOTECA.getValor()}" />
	<s:set var="varFOTOCOPIADO"
		value="%{@mx.edu.spee.controlacceso.mapeo.Perfil$PerfilEnum@ADMINISTRADOR_FOTOCOPIADO.getValor()}" />
	<s:set var="varCAJERO"
		value="%{@mx.edu.spee.controlacceso.mapeo.Perfil$PerfilEnum@ENCARGADO_CAJA.getValor()}" />
	<s:set var="varCONTADOR"
		value="%{@mx.edu.spee.controlacceso.mapeo.Perfil$PerfilEnum@CONTADOR.getValor()}" />
	<s:set var="varTRABAJADOR"
		value="%{@mx.edu.spee.controlacceso.mapeo.Perfil$PerfilEnum@TRABAJADOR.getValor()}" />
	<s:set var="varEXTERNO"
		value="%{@mx.edu.spee.controlacceso.mapeo.Perfil$PerfilEnum@EXTERNO.getValor()}" />
	<s:set var="varALUMNO"
		value="%{@mx.edu.spee.controlacceso.mapeo.Perfil$PerfilEnum@ALUMNO.getValor()}" />

	<nav class="navbar navbar-fixed-top navbar" role="navigation"
		style="margin-bottom: 0">
		<div class="navbar-header">
			<div style="float: left; width: 25px; margin-left: 25px;">
				<a
					href="${pageContext.request.contextPath}/control-acceso/gestionar-bienvenida">
					<img
					src="${pageContext.request.contextPath}/resources/images/ipn-logo.png"
					class="logo" />
				</a>
			</div>
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <i
					class="material-icons md-12 md-light">&#xE5D2;</i>
			</button>
		</div>

		<s:if test="#usuario neq null">
			<ul class="nav navbar-top-links navbar-right">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i
						class="material-icons md-18 md-light">&#xE7FD;</i>
				</a>
					<ul class="dropdown-menu dropdown-messages">
						<li><a
							href="${pageContext.request.contextPath}/control-acceso/logout!execute">Cerrar
								Sesión</a></li>
					</ul></li>
			</ul>
			<s:if test="#usuario.perfilActivo.id == #varSUBDIRECTOR">
				<ul class="nav navbar-top-links navbar-right">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"> <i
							class="material-icons md-18 md-light">notifications</i>
					</a>
						<ul class="dropdown-menu dropdown-messages">
							<li><a
								href="${pageContext.request.contextPath}/notificaciones/gestionar-notificaciones">Gestionar
									Notificaciones</a></li>
						</ul></li>
				</ul>
				<s:include value="./menu/subdirector.jsp" />
			</s:if>
			<s:if test="#usuario.perfilActivo.id == #varCELEX">
				<s:include value="./menu/celex.jsp" />
			</s:if>
			<s:if test="#usuario.perfilActivo.id == #varDENTALES">
				<ul class="nav navbar-top-links navbar-right">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"> <i
							class="material-icons md-18 md-light">notifications</i>
					</a>
						<ul class="dropdown-menu dropdown-messages">
							<li><a
								href="${pageContext.request.contextPath}/notificaciones/gestionar-notificaciones">Gestionar
									Notificaciones</a></li>
						</ul></li>
				</ul>
				<s:include value="./menu/serviciosDentales.jsp" />
			</s:if>
			<s:if test="#usuario.perfilActivo.id == #varBIBLIOTECA">
				<s:include value="./menu/biblioteca.jsp" />
			</s:if>
			<s:if test="#usuario.perfilActivo.id == #varFOTOCOPIADO">
				<s:include value="./menu/fotocopiado.jsp" />
			</s:if>
			<s:if test="#usuario.perfilActivo.id == #varCAJERO">
				<ul class="nav navbar-top-links navbar-right">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"> <i
							class="material-icons md-18 md-light">notifications</i>
					</a>
						<ul class="dropdown-menu dropdown-messages">
							<li><a
								href="${pageContext.request.contextPath}/notificaciones/gestionar-notificaciones">Gestionar
									Notificaciones</a></li>
						</ul></li>
				</ul>
				<s:include value="./menu/cajero.jsp" />
			</s:if>
			<s:if test="#usuario.perfilActivo.id == #varCONTADOR">
				<ul class="nav navbar-top-links navbar-right">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"> <i
							class="material-icons md-18 md-light">notifications</i>
					</a>
						<ul class="dropdown-menu dropdown-messages">
							<li><a
								href="${pageContext.request.contextPath}/notificaciones/gestionar-notificaciones">Gestionar
									Notificaciones</a></li>
						</ul></li>
				</ul>
				<s:include value="./menu/contador.jsp" />
			</s:if>
			<s:if test="#usuario.perfilActivo.id == #varTRABAJADOR">
				<ul class="nav navbar-top-links navbar-right">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"> <i
							class="material-icons md-18 md-light">notifications</i>
					</a>
						<ul class="dropdown-menu dropdown-messages">
							<li><a
								href="${pageContext.request.contextPath}/notificaciones/gestionar-notificaciones">Gestionar
									Notificaciones</a></li>
						</ul></li>
				</ul>
				<s:include value="./menu/trabajador.jsp" />
			</s:if>
			<s:if test="#usuario.perfilActivo.id == #varALUMNO">
				<ul class="nav navbar-top-links navbar-right">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"> <i
							class="material-icons md-18 md-light">notifications</i>
					</a>
						<ul class="dropdown-menu dropdown-messages">
							<li><a
								href="${pageContext.request.contextPath}/notificaciones/gestionar-notificaciones">Gestionar
									Notificaciones</a></li>
						</ul></li>
				</ul>
				<s:include value="./menu/alumno.jsp" />
			</s:if>
			<s:elseif test="#usuario.perfilActivo.id == #varEXTERNO">
				<s:include value="./menu/externo.jsp" />
			</s:elseif>
		</s:if>
	</nav>
</jsp:root>