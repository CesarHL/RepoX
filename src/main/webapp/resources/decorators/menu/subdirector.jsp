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
				<!-- Áreas -->
				<li class="dropdown"><a href="#"><s:text name="Areas" /><span
						class="fa arrow"></span> </a>
					<ul class="nav nav-second-level">
						<li class="dropdown"><a
							href="${pageContext.request.contextPath}/area/gestionar-area">
								<s:text name="Gestionar areas" />
						</a></li>
						<li class="dropdown"><a
							href="${pageContext.request.contextPath}/area/gestionar-responsable-area">
								<s:text name="Gestionar responsables de areas" />
						</a></li>
					</ul></li>

				<!-- Servicios -->
				<li class="dropdown"><a href="#"><s:text name="Servicios" /><span
						class="fa arrow"></span> </a>
					<ul class="nav nav-second-level">
						<li class="dropdown"><a
							href="${pageContext.request.contextPath}/servicio/gestionar-servicio">
								<s:text name="Gestionar servicios" />
						</a></li>
					</ul></li>

				<!-- Pagos -->
				<li class="dropdown"><a
					href="${pageContext.request.contextPath}/pagos/gestionar-pagos"><s:text
							name="Pagos" /><span class="fa arrow"></span> </a>
					<ul class="nav nav-second-level">
						<li class="dropdown"><a
							href="${pageContext.request.contextPath}/pagos/gestionar-concepto-pago">
								<s:text name="Pagos Autorizados" />
						</a> <a
							href="${pageContext.request.contextPath}/pagos/gestionar-costo-concepto/new">
								<s:text name="Gestionar Historial Pagos" />
						</a> <a
							href="${pageContext.request.contextPath}/pagos/gestionar-actividad-cajero">
								<s:text name="Actividad de cajeros" />
						</a></li>
					</ul></li>

				<!-- Reportes -->
				<li class="dropdown"><a href="#"><s:text name="Reportes" /><span
						class="fa arrow"></span> </a>
					<ul class="nav nav-second-level">
						<li class="dropdown"><a
							href="${pageContext.request.contextPath}/notificaciones/gestionar-reporte">
								<s:text name="Gestionar Reportes" />
						</a></li>
					</ul></li>

				<!-- Permisos -->
				<li class="dropdown"><a href="#"><s:text name="Permisos" /><span
						class="fa arrow"></span> </a>
					<ul class="nav nav-second-level">
						<li class="dropdown"><a
							href="${pageContext.request.contextPath}/notificaciones/gestionar-reporte">
								<s:text name="Gestionar Permisos" />
						</a></li>
					</ul></li>

				<!-- Notificaciones -->
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