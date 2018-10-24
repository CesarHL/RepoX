<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:decorator="http://www.opensymphony.com/sitemesh/decorator"
	xmlns:c="http://java.sun.com/jsp/jstl/core" xmlns:s="/struts-tags"
	xmlns:sj="/struts-jquery-tags"
	xmlns:log="http://jakarta.apache.org/taglibs/log-1.0">
	<jsp:directive.page language="java"
		contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" />
	<div class="navbar sidebar" role="navigation">
		<div class="sidebar-nav navbar-collapse">
			<ul class="nav" id="side-menu">

				<li class="dropdown"><a href="#"><s:text
							name="menu.alumno.pagos" /><span class="fa arrow"></span> </a>
					<ul class="nav nav-second-level">
						<li class="dropdown"><a
							href="${pageContext.request.contextPath}/pagos/gestionar-servicios">
								<s:text name="menu.alumno.visualizar_servicios" />
						</a> <a
							href="${pageContext.request.contextPath}/pagos/gestionar-pagos">
								<s:text name="menu.alumno.gestionar_pagos" />
						</a></li>
					</ul></li>

				<li class="dropdown"><a href="#"><s:text
							name="menu.alumno.citas" /><span class="fa arrow"></span> </a>
					<ul class="nav nav-second-level">
						<li class="dropdown"><a
							href="${pageContext.request.contextPath}/citas/gestionar-citas-dentales">
								<s:text name="menu.alumno.gestionar_citas" />
						</a></li>
						<li class="dropdown"><a
							href="${pageContext.request.contextPath}/citas/gestionar-citas-dentales/new">
								<s:text name="menu.alumno.agendar.cita" />
						</a></li>
					</ul></li>

				<li class="dropdown"><a href="#"><s:text
							name="menu.alumno.notas.pago" /><span class="fa arrow"></span> </a>
					<ul class="nav nav-second-level">
						<li class="dropdown"><a
							href="${pageContext.request.contextPath}/pagos/gestionar-notas-pago">
								<s:text name="menu.alumno.gestionar.notas.pago" />
						</a></li>
					</ul></li>

				<li class="dropdown"><a href="#"><s:text
							name="Historial de Pagos" /><span class="fa arrow"></span> </a>
					<ul class="nav nav-second-level">
						<li class="dropdown"><a
							href="${pageContext.request.contextPath}/pagos/gestionar-historial-pagos">
								<s:text name="Gestionar Historial Pagos" />
						</a></li>
					</ul></li>
				<li class="dropdown"><a href="#"><s:text
							name="Notificaciones" /><span class="fa arrow"></span> </a>
					<ul class="nav nav-second-level">
						<li class="dropdown"><a
							href="${pageContext.request.contextPath}/notificaciones/gestionar-notificaciones">
								<s:text name="Gestionar Notificaciones" />
						</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
</jsp:root>