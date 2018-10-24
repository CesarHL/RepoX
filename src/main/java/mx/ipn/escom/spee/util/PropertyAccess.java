package mx.ipn.escom.spee.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.ipn.escom.spee.action.FileUtil;
import mx.ipn.escom.spee.util.exception.AccessPropertyException;

public class PropertyAccess {

	private static final Properties properties = new Properties();

	private static final String PROPERTIES_FILE_NAME = "global.properties";


	private static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class);

	static {
		InputStream input = null;
		try {
			input = Thread.currentThread().getContextClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME);
			properties.load(input);
		} catch (IOException ex) {
			LOGGER.error(Constantes.IO_EXCEPTION, ex);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					LOGGER.error(Constantes.IO_EXCEPTION, e);
				}
			}
		}
	}

	private PropertyAccess() {
		super();
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

	public static Integer getIntegerProperty(String key) throws AccessPropertyException {
		try {
			return Integer.parseInt(properties.getProperty(key));
		} catch (NumberFormatException nfe) {
			throw new AccessPropertyException(nfe.getCause());
		}
	}

	public static Double getDoubleProperty(String key) throws AccessPropertyException {
		try {
			return Double.parseDouble(properties.getProperty(key));
		} catch (NumberFormatException nfe) {
			throw new AccessPropertyException(nfe.getCause());
		}
	}

	public static Float getFloatProperty(String key) throws AccessPropertyException {
		try {
			return Float.parseFloat(properties.getProperty(key));
		} catch (NumberFormatException nfe) {
			throw new AccessPropertyException(nfe.getCause());
		}
	}

	
	static Date getDateProperty(String key) throws AccessPropertyException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(getProperty("mx.edu.eld.formatDate"));
		try {
			return dateFormat.parse(getProperty(key));
		} catch (ParseException pe) {
			throw new AccessPropertyException(pe.getCause());
		}
	}

	public static Date getDateProperty(String key, String format) throws AccessPropertyException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(getProperty(format));
		try {
			return dateFormat.parse(getProperty(key));
		} catch (ParseException pe) {
			throw new AccessPropertyException(pe.getCause());
		}
	}
}
