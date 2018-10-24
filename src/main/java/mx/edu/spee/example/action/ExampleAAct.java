package mx.edu.spee.example.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/example")
public class ExampleAAct extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	List<String> languajes;

	public String index() {
		addActionError("Mensaje de error");
		addActionMessage("Mensaje de exito");
		languajes = new ArrayList<String>();
		languajes.add("Español");
		languajes.add("Ingles");
		languajes.add("Italiano");
		languajes.add("Frances");
		languajes.add("Portugues");
		return "index";
	}

	/**
	 * @return the languajes
	 */
	public List<String> getLanguajes() {
		return languajes;
	}

	/**
	 * @param languajes
	 *            the languajes to set
	 */
	public void setLanguajes(List<String> languajes) {
		this.languajes = languajes;
	}
}
