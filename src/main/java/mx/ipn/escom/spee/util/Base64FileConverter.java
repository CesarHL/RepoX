package mx.ipn.escom.spee.util;

import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import mx.ipn.escom.spee.action.Archivo;

@Service("base64FileConverter")
public class Base64FileConverter {

	public String fileConverter(Archivo archivo) throws IOException {
		return Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(archivo.getFileUpload()));  
	}

}
