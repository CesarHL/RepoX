package mx.edu.spee.controlacceso.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.spee.controlacceso.mapeo.Usuario;
import mx.ipn.escom.spee.util.bs.GenericSearchBs;

@RestController
public class AccesoRestController {

	@Autowired
	private GenericSearchBs genericSearchBs;

	@GetMapping("/orders")
	public @ResponseBody Usuario getBook(@PathVariable int id) {
		return genericSearchBs.findById(Usuario.class, id);
	}

}
