package mx.ipn.escom.spee.mail.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.ipn.escom.spee.mail.business.MailSender;
import mx.ipn.escom.spee.mail.model.ReporteError;
import mx.ipn.escom.spee.util.Constantes;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;

@Results({ @Result(name = ReportarErrorCtrl.REPORTAR_EROR, type = "json", params = {
		"includeProperties", "appError.*" }) })
public class ReportarErrorCtrl extends ActionSupport {

	/**
     * 
     */
	private static final long serialVersionUID = 3021133221179304677L;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ReportarErrorCtrl.class);

	public static final String REPORTAR_EROR = "reportar_error";

	private MailSender mailSender;
	private ReporteError error;

	public String generarReporte() {
		Map<String, Object> templateEntities = new HashMap<String, Object>();
		List<String> to = Arrays.asList(getText("mail.notify").split(","));
		error.setFecha(new Date());

		templateEntities.put("stacktrace", error.getTraza());
		templateEntities.put("url", error.getUrl());
		templateEntities.put("fecha", error.getFecha());

		try {
			if (!to.isEmpty()) {
				mailSender.sendEmail(templateEntities,
						getText("mail.template.path")
								+ getText("mail.template.reporteErrorApp"), to,
						getText("mail.subject.reporteErrorApp"), null);
			}
		} catch (Exception e) {
			LOGGER.error(Constantes.MSG_EXCEPTION, e);
		} 
		return REPORTAR_EROR;
	}

	public ReporteError getError() {
		if (error == null) {
			error = new ReporteError();
		}
		return error;
	}

	public void setError(ReporteError error) {
		this.error = error;
	}

	public MailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
}
