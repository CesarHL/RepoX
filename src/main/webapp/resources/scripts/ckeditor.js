var ckeditorCDT = function() {
	/**
	 * Crea una instancia de ckeditor con la configuracion descrita en el
	 * archivo config-cdt.js
	 * 
	 * @param idTextArea
	 * @returns Objeto ckeditor creado
	 */
	function createCKEditor(idTextArea) {
		return CKEDITOR.replace(idTextArea, {
			customConfig : 'config-cdt.js'
		});
	}

	return {
		createCKEditor : createCKEditor
	};
}();