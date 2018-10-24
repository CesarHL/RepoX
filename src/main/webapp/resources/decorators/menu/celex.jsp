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
							href="${pageContext.request.contextPath}/pagos/gestionar-pagos">
								<s:text name="menu.celex.pagos.autorizados" />
						</a> <a
							href="${pageContext.request.contextPath}/pagos/gestionar-archivo-pagos">
								<s:text name="menu.celex.archivo" />
						</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
</jsp:root>