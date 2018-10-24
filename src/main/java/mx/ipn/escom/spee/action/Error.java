package mx.ipn.escom.spee.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Error {
	private Map<String, List<String>> listErrores;
	private List<String> keys;

	public Error() {
		this.listErrores = new HashMap<String, List<String>>();
	}

	public void add(String fielName, String message) {
		if (listErrores == null) {
			listErrores = new HashMap<String, List<String>>();
		}
		List<String> listMessages = listErrores.get(fielName);
		List<String> newListMessages = listMessages == null ? new ArrayList<String>()
				: listMessages;
		if (!newListMessages.contains(message)) {
			newListMessages.add(message);
			listErrores.put(fielName, newListMessages);
		}
	}

	public void clear() {
		this.listErrores.clear();
	}

	public Boolean isEmpty() {
		return this.listErrores.isEmpty();
	}

	/**
	 * @return the listErrores
	 */
	public Map<String, List<String>> getListErrores() {
		return listErrores;
	}

	/**
	 * @param listErrores
	 *            the listErrores to set
	 */
	public void setListErrores(Map<String, List<String>> listErrores) {
		this.listErrores = listErrores;
	}

	/**
	 * @return the keys
	 */
	public List<String> getKeys() {
		keys = new ArrayList<String>(listErrores.keySet());
		return keys;
	}

	/**
	 * @param keys
	 *            the keys to set
	 */
	public void setKeys(List<String> keys) {
		this.keys = keys;
	}
}
