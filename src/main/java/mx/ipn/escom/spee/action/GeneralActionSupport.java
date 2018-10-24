/**
 * 
 */
package mx.ipn.escom.spee.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author
 * 
 */
public class GeneralActionSupport extends ActionSupport {

	/**
	 * 
	 */
	private List<String> warningMessages;

	/**
	 * 
	 */
	public static final String REDIRECT_ACTION = "redirectAction";

	/**
	 * 
	 */

	public static final String ACTION_NAME = "actionName";

	/**
	 * 
	 */
	protected static final String INDEX = "index";

	/**
	 * 
	 */
	protected static final String EDIT = "edit";

	/**
	 * 
	 */
	protected static final String EDITNEW = "editNew";

	/**
	 * 
	 */
	protected static final String SHOW = "show";

	/**
	 * 
	 */
	protected static final String DELETE = "delete";

	/**
	 * Nombre del result para cuando no se esta autorizado
	 */
	protected static final String NO_AUTORIZADO = "noAutorizado";

	/**
	 * 
	 */
	public static final String CANCELAR = "cancelar";

	/**
	 * 
	 */
	protected String status;

	/**
	 * 
	 */
	private static final long serialVersionUID = -3483736540590443571L;

	public void addWarningMessage(String message) {
		if (warningMessages == null) {
			warningMessages = new ArrayList<String>();
		}
		warningMessages.add(message);
	}

	/**
	 * @return the warningMessages
	 */
	public Collection<String> getWarningMessages() {
		return warningMessages;
	}

	/**
	 * @param warningMessages
	 *            the warningMessages to set
	 */
	public void setWarningMessages(List<String> warningMessages) {
		this.warningMessages = warningMessages;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Vaida que no haya errores en la petición asociadas al archivo
	 * 
	 * @param archivo
	 *            , archivo que se sube en el request
	 * @param sessionFile
	 *            , archivo que se encuentra en la session
	 * @param fieldErrors
	 *            , errores asociados a la petición
	 * @param path
	 *            , ruta para guardar los archivos temporales
	 * @param sessionFileName
	 *            , llave con la que se guarda el objeto en la session
	 * @param fieldName
	 *            , nombre del campo asiciado a la petición
	 * @return
	 */
	protected String validarArchivoSession(Archivo archivo,
			SessionFile sessionFile, Map<String, List<String>> fieldErrors,
			String path, String sessionFileName, String fieldName) {
		String name = null;
		if (!fieldErrors.keySet().contains(fieldName)) {
			sessionFile = new SessionFile(archivo.getFileUploadFileName(),
					FileUtil.guardarTemp(archivo.getFileUpload(), path,
							archivo.getFileUploadFileName()));
			SessionManager.set(sessionFileName, sessionFile);
			archivo.setInSession(true);
		} else if (sessionFile != null && sessionFile.getFileName() != null
				&& !sessionFile.getFileName().isEmpty()) {
			fieldErrors.remove(fieldName);
			name = sessionFile.getFileName();
			archivo.setInSession(true);
		}
		return name;
	}

	/**
	 * Devuelve el nombre del archivo que se almacenará en la base de datos
	 * 
	 * @param archivo
	 *            , archivo que se guardará en el sistema de archivo
	 * @param size
	 *            , tamaño máximo valido del archivo
	 * @param fieldName
	 *            , name del campo en el formulario asociado al archivo
	 * @param errorMandatori
	 *            , mensaje a mostrar en caso de ser obligatorio
	 * @param errorFormat
	 *            , mensaje a mostrar por error de formato en el archivo
	 *            seleccionado
	 * @param formats
	 *            , formatos permitidos para el archivo
	 * @return
	 */
	protected String validarArchivo(Archivo archivo, long size,
			String fieldName, String errorMandatori, String errorFormat,
			String[] formats) {
		ServletContext context = ServletActionContext.getServletContext();
		String contextPath = context.getRealPath("/");
		Boolean valido = true;
		if (archivo != null && archivo.getFileUploadFileName() != null) {
			byte[] bFile = new byte[(int) archivo.getFileUpload().length()];
			try {
				if (FileUtil.sizeFile(archivo.getFileUpload(), size)) {
					addFieldError(fieldName, errorMandatori);
					valido = false;
				} else if (!FileUtil.validarFormato(
						archivo.getFileUploadFileName(), formats)) {
					addFieldError(fieldName, errorFormat);
					valido = false;
				} else {
					FileInputStream fileInputStream = new FileInputStream(
							archivo.getFileUpload());
					fileInputStream.read(bFile);
					fileInputStream.close();
					FileUtil.borrarTemporalWebapp(contextPath,
							archivo.getFileUploadFileName());
					valido = true;
				}
			} catch (IOException e) {
				valido = false;
			}
		} else {
			addFieldError(fieldName, errorMandatori);
			return null;
		}
		if (valido) {
			return archivo.getFileUploadFileName();
		} else {
			return null;
		}
	}

	/**
	 * Guarda un archivo en el file system con base en el request o un archivo
	 * temporal previamente guardado
	 * 
	 * @param archivo
	 * @param path
	 * @param tempPath
	 * @param sessionFileName
	 * @throws IOException
	 */
	protected void guardarArchivo(Archivo archivo, String path,
			String tempPath, String sessionFileName) throws IOException {
		if (!archivo.getInSession()) {
			FileUtil.guardarArchivo(archivo.getFileUpload(), path,
					archivo.getFileUploadFileName());
		} else {
			SessionFile imagenSessionFile = (SessionFile) SessionManager
					.delete(sessionFileName);
			FileUtil.moveTemp(tempPath + imagenSessionFile.getTempFileName(),
					path, imagenSessionFile.getFileName());
		}
	}

}
