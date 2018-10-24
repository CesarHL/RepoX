$(function() {
	var tipoContacto_ = undefined;

	if (tipoContacto_  == undefined) {
		$("#divNoEmpleado").addClass("hidden");
		$("#divBoleta").addClass("hidden");
	}
	$("#alumnoCheckId").change(function() {
		var tipoContacto_ = $("#alumnoCheckId option:selected").val();
		if (tipoContacto_ == "8") {
			$("#divNoEmpleado").addClass("hidden");
			$("#divBoleta").removeClass("hidden");
		} else if (tipoContacto_ == "9") {
			$("#divBoleta").addClass("hidden");
			$("#divNoEmpleado").removeClass("hidden");
		} else if (tipoContacto_ == "10") {
			$("#divNoEmpleado").addClass("hidden");
			$("#divBoleta").addClass("hidden");
		}
	});
});
