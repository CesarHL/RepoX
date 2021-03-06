function gestionarErrores(error, paramName, formId) {
	var valido;
	limpiarErrores(formId);
	if (error.keys.length == 0) {
		valido = true;
	} else {
		var valido = false;
		var keys = error.keys;
		for (var i = 0; i < keys.length; i++) {
			var name = paramName + keys[i];
			var input = $("input[name='" + name + "']");
			if (input.length > 0) {
				input.addClass("field-error");
				mostrarErrores(error.listErrores, input, keys[i]);
			} else {
				var select = $("select[name='" + name + "']");
				if (select.length > 0) {
					select.addClass("field-error");
					mostrarErrores(error.listErrores, select, keys[i]);

				}
			}
		}
	}
	return valido;
}

function mostrarErrores(listErrores, element, name) {
	var divErrorMessageContainer = $("<div></div>");
	var errores = listErrores[name];
	for (var i = 0; i < errores.length; i++) {
		var message = $("<p></p>");
		message.text(errores[i]);
		divErrorMessageContainer.append(message);
	}
	divErrorMessageContainer.addClass("alert alert-danger error");
	element.after(divErrorMessageContainer);
}

function limpiarErrores(formId) {
	var frm = $("#" + formId);
	if (frm.length > 0) {
		frm.find(".alert.alert-danger.error").remove();
		frm.find(".field-error").removeClass("field-error");
	}
	var globalErrors = $("#divGlobalErrors");
	if (globalErrors.length > 0) {
		globalErrors.find(".alert.alert-danger.error").remove();
		globalErrors.find(".field-error").removeClass("field-error");
	}
	var categoryErrors = $("#divCategoryErrors");
	if (categoryErrors.length > 0) {
		categoryErrors.find(".alert.alert-danger.error").remove();
		categoryErrors.find(".field-error").removeClass("field-error");
	}
}