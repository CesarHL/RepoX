/**
 * Namespace que permite validar las entradas recibidas a un spinner
 * 
 * @author Carlos Ivan Calva Avalos
 * @date 16-10-2017
 */
var spinnerValidation = function() {

	/*
	 * Validaciones de los tamaños que se reciben en los spinners, recibiendo un
	 * maximo y un minimo en los valores que recibe la funcion, si se ingresa
	 * algo mayor al maximo, se ajusta al maximo, analogo a un minimo. Si se
	 * ingresa una entrada invalida, se registra el valor minimo
	 */
	function validacionesSpinners(idSpinner, minimo, maximo) {

		$("#" + idSpinner).bind(
				'change',
				function() {
					if ($("#" + idSpinner).val() >= minimo
							&& $("#" + idSpinner).val() <= maximo
							&& !(0 === $("#" + idSpinner).val().length)) {
						$("#" + idSpinner).val($("#" + idSpinner).val());
					} else if ($("#" + idSpinner).val() > maximo) {
						$("#" + idSpinner).val(maximo);
					} else if ($("#" + idSpinner).val() < minimo) {
						$("#" + idSpinner).val(minimo);
					} else {
						$("#" + idSpinner).val(minimo);
					}
				});
	}

	return {
		validacionesSpinners : validacionesSpinners
	};
}();