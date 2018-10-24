package mx.ipn.escom.spee.util.mapeo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AjaxResult {

	private Map<String, Object> response;

	private List<Mensaje> listMessages;

	public AjaxResult() {
		this.response = new HashMap<>();
		this.listMessages = new ArrayList<>();
	}

	public AjaxResult(Map<String, Object> response, List<Mensaje> listMessages) {
		super();
		this.response = response;
		this.listMessages = listMessages;
	}

	public void addCampo(String nombreCampo, Object objeto) {
		response.put(nombreCampo, objeto);
	}

	public Map<String, Object> getResponse() {
		return response;
	}

	public void setResponse(Map<String, Object> response) {
		this.response = response;
	}

	/**
	 * @return the listMessages
	 */
	public List<Mensaje> getListMessages() {
		return listMessages;
	}

	/**
	 * @param listMessages the listMessages to set
	 */
	public void setListMessages(List<Mensaje> listMessages) {
		this.listMessages = listMessages;
	}

}
