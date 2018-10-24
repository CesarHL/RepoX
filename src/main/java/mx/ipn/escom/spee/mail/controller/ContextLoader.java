package mx.ipn.escom.spee.mail.controller;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextLoader {
	private ClassPathXmlApplicationContext context;
	private AutowireCapableBeanFactory autoWireCapable;

	private Properties properties;

	public ContextLoader() {
		this.context = new ClassPathXmlApplicationContext(
				"classpath*:applicationContext.xml");
		autoWireCapable = this.context.getAutowireCapableBeanFactory();
		properties = new Properties();
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream(
					"global.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the context
	 */
	public ClassPathXmlApplicationContext getContext() {
		return context;
	}

	/**
	 * @param context
	 *            the context to set
	 */
	public void setContext(ClassPathXmlApplicationContext context) {
		this.context = context;
	}

	public String getMailProperty(String property) {
		return properties.getProperty(property);
	}

	public AutowireCapableBeanFactory getAutoWireCapable() {
		return autoWireCapable;
	}

	public void setAutoWireCapable(AutowireCapableBeanFactory autoWireCapable) {
		this.autoWireCapable = autoWireCapable;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
}
