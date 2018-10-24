package mx.edu.spee.example.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;

import mx.ipn.escom.spee.action.GeneralActionSupport;

@Namespace("/example")
public class ConvertidorCardinalAct extends GeneralActionSupport {

	private static final long serialVersionUID = 1L;

	private List<Integer> elementos;

	public String index() {
		elementos = new ArrayList<>();
		for (Integer numero = 0; numero <= 1000; numero++) {
			elementos.add(numero);
		}
		return INDEX;
	}

	public List<Integer> getElementos() {
		return elementos;
	}

	public void setElementos(List<Integer> elementos) {
		this.elementos = elementos;
	}

}
