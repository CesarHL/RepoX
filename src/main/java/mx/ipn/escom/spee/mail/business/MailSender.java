package mx.ipn.escom.spee.mail.business;

import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import mx.ipn.escom.spee.util.Constantes;

@Service("mailSender")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class MailSender implements Serializable {

	private static final long serialVersionUID = 1L;

	private JavaMailSender javaMailSender;

	private VelocityEngine velocityEngine;

	private Map<String, Resource> inlineFiles;

	public void sendEmail(final Map<String, Object> templateParams, final String template,
			final List<String> recipients, final String subject, final Map<String, File> attachments) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				putArguments(mimeMessage, templateParams, template,
						recipients, subject, attachments);
			}
		};
		javaMailSender.send(preparator);
	}

	private void putArguments(MimeMessage mimeMessage, Map<String, Object> entityParams, String template,
			List<String> to, String subject, Map<String, File> attachments) throws MessagingException {
		MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, Constantes.CHARSET);
		message.setTo(Arrays.copyOf(to.toArray(), to.toArray().length, String[].class));
		message.setSubject(subject);
		message.setText(VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/" + template, Constantes.CHARSET,
				entityParams), true);
		if (inlineFiles != null) {
			Iterator<String> itImage = inlineFiles.keySet().iterator();
			while (itImage.hasNext()) {
				String key = itImage.next();
				message.addInline(key, inlineFiles.get(key));
			}
		}

		if (attachments != null) {
			Iterator<String> it = attachments.keySet().iterator();
			while (it.hasNext()) {
				String key = it.next();
				message.addAttachment(key, attachments.get(key));
			}
		}
	}

	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public VelocityEngine getVelocityEngine() {
		return velocityEngine;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	public Map<String, Resource> getInlineFiles() {
		return inlineFiles;
	}

	public void setInlineFiles(Map<String, Resource> inlineFiles) {
		this.inlineFiles = inlineFiles;
	}

}
