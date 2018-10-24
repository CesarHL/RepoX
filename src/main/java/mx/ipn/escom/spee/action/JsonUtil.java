package mx.ipn.escom.spee.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase de utileria que permite realizar operaciones con objetos JSON
 * 
 * @author Jorge �?lvarez
 * @version 1.0 "Nov 8, 2015"
 */
public class JsonUtil {

	/**
	 * Instancia que permite escribir en el Logger de la aplicación
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

	/**
	 * Instancia utilizada para realizar mapeos de tipo JSON
	 */
	private static ObjectMapper mapper = new ObjectMapper();

	/**
	 * Constructor privado que oculta el por defecto
	 */
	private JsonUtil() {
	}

	/**
	 * Convierte una cadena en formato JSON a un conjunto de objetos
	 * 
	 * @param json
	 * @param class
	 * @return List<C>
	 */
	public static <C> Set<C> mapJSONToSet(String json, Class<C> clazz) {
		try {
			return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(Set.class, clazz));
		} catch (IOException ex) {
			LOGGER.error(ex.getMessage(), ex);
			return new HashSet<>();
		}
	}

	/**
	 * Convierte una cadena en formato JSON a una lista de objetos
	 * 
	 * @param json
	 * @param class
	 * @return List<C>
	 */
	public static <C> ArrayList<C> mapJSONToArrayList(String json, Class<C> clazz) {
		try {
			return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
		} catch (IOException ex) {
			LOGGER.error(ex.getMessage(), ex);
			return new ArrayList<>();
		}
	}

	/**
	 * Convierte una cadena en formatoJSON a un objeto
	 * 
	 * @param json
	 * @param class
	 * @return Class C
	 */
	public static <C> C mapJSONToObject(String json, Class<C> clazz) {
		try {
			return mapper.readValue(json, clazz);
		} catch (IOException ex) {
			LOGGER.error(ex.getMessage(), ex);
			return null;
		}
	}

	/**
	 * Convierte una Objeto a una String en formato JSON
	 * 
	 * @param class
	 * @return String JSON
	 */
	public static <C> String mapObjectToJSON(Object clazz) {
		try {
			return mapper.writeValueAsString(clazz);
		} catch (IOException ex) {
			LOGGER.error(ex.getMessage(), ex);
			return null;
		}
	}

	/**
	 * Convierte una Lista a una String en formato JSON
	 * 
	 * @param List
	 * @return String JSON
	 */
	public static <C> String mapListToJSON(List<C> list) {
		try {
			return mapper.writeValueAsString(list);
		} catch (IOException ex) {
			LOGGER.error(ex.getMessage(), ex);
			return null;
		}
	}

	/**
	 * Convierte una Lista a una String en formato JSON
	 * 
	 * @param List
	 * @return String JSON
	 */
	public static <K, V> String mapMapToJSON(Map<K, V> map) {
		try {
			return mapper.writeValueAsString(map);
		} catch (IOException ex) {
			LOGGER.error(ex.getMessage(), ex);
			return null;
		}
	}

	/**
	 * Convierte un conjunto a una String en formato JSON
	 * 
	 * @param Set
	 * @return String JSON
	 */
	public static <C> String mapSetToJSON(Set<C> set) {
		try {
			mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
			return mapper.writeValueAsString(set);
		} catch (IOException ex) {
			LOGGER.error(ex.getMessage(), ex);
			return null;
		}
	}

	/**
	 * Convierte un conjunto a una String en formato JSON
	 * 
	 * @param Set
	 * @return String JSON
	 */
	public static <C> String mapSetToJSONDate(Set<C> set, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			mapper.setDateFormat(sdf);
			mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
			return mapper.writeValueAsString(set);
		} catch (IOException ex) {
			LOGGER.error(ex.getMessage(), ex);
			return null;
		}
	}

	/**
	 * Convierte un conjunto a una String en formato JSON
	 * 
	 * @param Set
	 * @return String JSON
	 */
	public static <C> String mapArrayListToJSONDate(List<C> set, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			mapper.setDateFormat(sdf);
			mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
			return mapper.writeValueAsString(set);
		} catch (IOException ex) {
			LOGGER.error(ex.getMessage(), ex);
			return null;
		}
	}

	/**
	 * Convierte una cadena en formato JSON a un conjunto de objetos
	 * 
	 * @param json
	 * @param class
	 * @return List<C>
	 */
	public static <C> Set<C> mapJSONToSetDate(String json, Class<C> clazz, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			mapper.setDateFormat(sdf);
			return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(Set.class, clazz));
		} catch (IOException ex) {
			LOGGER.error(ex.getMessage(), ex);
			return new HashSet<>();
		}
	}

	/**
	 * Convierte una cadena en formato JSON a un conjunto de objetos
	 * 
	 * @param json
	 * @param class
	 * @return List<C>
	 */
	public static <C> ArrayList<C> mapJSONToArrayDate(String json, Class<C> clazz, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.ENGLISH);
			mapper.setDateFormat(sdf);
			return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(ArrayList.class, clazz));
		} catch (IOException ex) {
			LOGGER.error(ex.getMessage(), ex);
			return new ArrayList<>();
		}
	}

	/**
	 * Convierte una lista a una String en formato JSON
	 * 
	 * @param list
	 * @param format
	 * @return
	 */
	public static <C> String mapListToJSONDate(List<C> list, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			mapper.setDateFormat(sdf);
			mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
			return mapper.writeValueAsString(list);
		} catch (IOException ex) {
			LOGGER.error(ex.getMessage(), ex);
			return null;
		}
	}

	/**
	 * Convierte un objeto a una cadena Json con fechas incluidas en el obejeto
	 * 
	 * @param clazz
	 * @param format
	 * @return
	 */
	public static <C> String mapObjectToJSONDate(Object clazz, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			mapper.setDateFormat(sdf);
			mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
			return mapper.writeValueAsString(clazz);
		} catch (IOException ex) {
			LOGGER.error(ex.getMessage(), ex);
			return null;
		}
	}

}
