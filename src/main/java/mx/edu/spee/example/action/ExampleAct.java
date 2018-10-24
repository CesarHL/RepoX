package mx.edu.spee.example.action;

import org.apache.struts2.convention.annotation.Namespace;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/example")
public class ExampleAct extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String index(){
		addActionError("Mensaje de error");
		addActionMessage("Mensaje de exito");
		return "index";
	}
}
