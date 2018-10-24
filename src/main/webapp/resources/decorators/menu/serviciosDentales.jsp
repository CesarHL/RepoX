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
				
				<!-- Citas -->
				<li class="dropdown"><a href="#"><s:text
							name="menu.dentales.citas" /><span class="fa arrow"></span> </a>
					<ul class="nav nav-second-level">
						<li class="dropdown"><a
							href="${pageContext.request.contextPath}/citas/gestionar-citas-dentales">
								<s:text name="menu.dentales.citas.gestionar_citas" />
						</a></li>
						<li class="dropdown"><a
							href="${pageContext.request.contextPath}/citas/gestionar-citas-dentales!">
									<s:text name="menu.dentales.citas.previa_cita" />
							</a></li>
					</ul></li>
				
				<!-- Pacientes -->
				<li class="dropdown"><a href="#"><s:text
							name="menu.dentales.pacientes" /><span class="fa arrow"></span>
				</a>
					<ul class="nav nav-second-level">
						<li class="dropdown"><a
							href="${pageContext.request.contextPath}/paciente/gestionar-paciente">
								<s:text name="menu.dentales.pacientes.consultar_pacientes" />
						</a></li>
					</ul></li>
				
				<!-- Pagos -->
				<li class="dropdown"><a
					href="${pageContext.request.contextPath}/pagos/gestionar-pagos"><s:text
							name="menu.dentales.pagos" /><span class="fa arrow"></span> </a>
					<ul class="nav nav-second-level">
						<li class="dropdown"><a
							href="${pageContext.request.contextPath}/pagos/gestionar-concepto-pago">
								<s:text name="menu.dentales.pagos.gestionar_pagos" />
						</a> <a
							href="${pageContext.request.contextPath}/pagos/gestionar-costo-concepto/new">
								<s:text name="menu.dentales.pagos.gestionar_historial_pagos" />
						</a></li>
					</ul></li>

				<!-- Notificaciones -->
				<li class="dropdown"><a href="#"><s:text
							name="menu.dentales.notificaciones" /><span class="fa arrow"></span> </a>
					<ul class="nav nav-second-level">
						<li class="dropdown"><a
							href="${pageContext.request.contextPath}/notificaciones/gestionar-notificaciones">
								<s:text name="menu.dentales.notificaciones.gestionar_notificaciones" />
						</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
</jsp:root>