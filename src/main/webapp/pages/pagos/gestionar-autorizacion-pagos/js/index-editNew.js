$(function() {
	dataTableEMETH.createSortedDataTable("tblPagosPorAutorizar", 1, "desc");
	dataTableEMETH.createSortedDataTable("tblPagosRechazados", 1, "desc");
});

function AutorizarPago(idPago){
	var action = $("#hdnUrlAction").val();
	action = action + idPago;
	$("#frmGestionarConvocatoriaAspirante").attr("action", action);
	$("#hdnEstatusNuevo").attr("value",$("#slcListTipoContactos").val());
	$("#lblNombreAspirante").append(nombreAspirante);
	$.publish("showDlgIniciar");
}

function RechazarPago(idPago){
	var action = $("#hdnUrlAction").val();
	action = action + idPago;
	$("#frmGestionarConvocatoriaAspirante").attr("action", action);
	$("#hdnEstatusNuevo").attr("value",$("#slcListTipoContactos").val());
	$("#lblNombreAspirante").append(nombreAspirante);
	$.publish("showDlgIniciar");
}

$(function() {
	/*
	 * Al seleccionar un inputFile, se asigna el nombre del archivo asociado al
	 * requisito, tambien se asigna a la variable hidden de modificacion
	 * correspondiente el valor de true
	 */
	$("[id^=archivo_]").bind('change', function() {
		/*
		 * Seleccionamos la id asociada y hacemos un split con el cual podemos
		 * seleccionar posteriormente el numero del id
		 */
		var idInput = $(this).attr('id');
		var idSecciones = idInput.split('_');
		/*
		 * Solo tomamos el nombre del archivo obtenido del input, ignorando
		 * cualquier ruta que le preceda
		 */
		var fileName = $(this).val().split('\\').pop();
		/*
		 * Asignamos el nombre del archivo
		 */
		$("#archivoNombre_" + idSecciones[1]).text(fileName).prop('value');
		/*
		 * Ponemos la variable de cambio correspondiente en true
		 */
		$("#idArchivoModificado_" + idSecciones[1]).val(true);

		/*
		 * Ocultamos el icono de visualizar
		 */
		$("#iconoVer_" + idSecciones[1]).hide();
	});
});

function selectImage(idImage) {
	$("#" + idImage).click();
}

var file = function() {
	/*
	 * Con esta funcion, creamos el selector de archivos tras habler dado clicl
	 * en el jsp
	 */
	function selectFile(idFile) {
		$("#" + idFile).click();
	}
	return {
		selectFile : selectFile,
	};
}();