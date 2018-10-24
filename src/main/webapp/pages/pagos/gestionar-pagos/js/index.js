$(function() {
	dataTableEMETH.createSortedDataTable("tblPagosEnviados", 1, "asc");
});

 $(function() {
	
	$("#loadImage").click(function() {
		$("#fileUpload").trigger("click");
	});
	
	$("#fileUpload").change(function() {
		var fileName = $("#fileUpload").val();
		$("#fileName").prop("value", fileName);
	});
	
});