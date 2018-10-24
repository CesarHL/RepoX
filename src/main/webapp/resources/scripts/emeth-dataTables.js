/**
 * Namespace que permite realizar operaciones con el componente de DataTable
 * 
 * @author Jorge Eduardo Álvarez Hernández
 * @version 1.0 "Aug 24, 2015"
 */
var dataTableEMETH = function() {

	/**
	 * Permite agregar una fila en una Tabla especificada
	 * 
	 * @param idTable
	 *            {String} identificador de la tabla a la que se quiere agregar
	 *            el elemento
	 * @param row
	 *            {Array} cada uno de los elemento que van a ser agregados en la
	 *            fila
	 */
	function addRow(idTable, row) {
		$("#" + idTable).dataTable().fnAddData([ row ], true);
	}

	/**
	 * Borra un elemento de la tabla
	 * 
	 * @param table
	 *            {String} tabla a la que se quiere eliminar un elemento
	 * 
	 * @param row
	 *            {Obeject} elemento que van a ser eliminado de la tabla
	 */
	function deleteRow(table, element) {
		$("#" + table.id).DataTable().row($(element).parents('tr')).remove()
				.draw();
	}

	function deleteRowId(table, element) {
		$("#" + table).DataTable().row($(element).parents('tr')).remove()
				.draw();
	}
	/**
	 * Borra todos los elementos de la tabla
	 * 
	 * @param table
	 *            {String} tabla de la que se quieren eliminar todos los
	 *            registros
	 */
	function deleteRows(table) {
		$('#' + table).DataTable().rows().remove().draw();
	}

	/**
	 * Funcion para saber cuantos renglones tiene una tabla
	 * 
	 * @param table
	 *            {String} tabla de la que se quieren saber el numero de filas
	 * @returns {Integer} Numero de filas en la tabla
	 */
	function countRows(table) {
		return $("#" + table).DataTable().rows().count();
	}

	/**
	 * Verifica que un elemento exista en una tabla, en caso de que exista
	 * regresa verdadero, verifica un valor de referencia contra los elementos
	 * de una columna, en caso de ser requerido mustra un mensaje pasando como
	 * parametro el elemento que esta repetido.
	 * 
	 * @param idTabla
	 *            {String} identificador de la tabla en la que se realizará la
	 *            comparación
	 * @param value
	 *            {String} valor de referencia que se busca encontrar en la
	 *            tabla
	 * @param index
	 *            {Integer} índice que indica sobre que columna debe realizarse
	 *            la busqueda
	 * @param idMessage
	 *            {String} (opcional) indica el identificador del texto del
	 *            mensaje que se mostrará en caso de que exista un elemento
	 *            repetido
	 * @param message
	 *            {String} mensaje original
	 * @returns {Boolean} verdadero en caso de que exista un elemento repetido,
	 *          falso en caso contrario
	 * 
	 */
	function exist(idTable, value, index, idMessage, message) {
		var table = $("#" + idTable).dataTable();
		for (var i = 0; i < table.fnSettings().fnRecordsTotal(); i++) {
			if (value === table.fnGetData(i, index)) {
				if (idMessage != undefined && message != undefined
						&& idMessage != null && idMessage !== '') {
					$("#" + idMessage).text(message.format({
						4 : value
					}));
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * Crea una tabla por medio del componente DataTables 1.10 sin aplicarle
	 * ningún tema
	 * 
	 * @param idTable
	 *            {String} identificador del elemento table ha ser creado como
	 *            objeto DataTable
	 * @returns Objeto DataTable creado
	 */
	function createDataTableWhitOutInfo(idTable, aoColumnDefs) {
		return $("#" + idTable).dataTable({
			language : {
				url : $("#hdnRutaContexto").val() + getUrlLanguage()
			},
			responsive : {
				details : {
					display : $.fn.dataTable.Responsive.display.childRow
				}
			},
			"bFilter" : false,
			"bSort" : false,
			"bLengthChange" : false,
			"bPaginate" : false,
			"bInfo" : false,
			"autoWidth" : false,
			"aoColumnDefs" : aoColumnDefs
		// ,
		// "language" : {
		// "url" : $("#hdnRutaContexto").val() + getUrlLanguage()
		// }
		});
	}

	/**
	 * Función que ordena cierta columna de acuerdo al orden que se desee.
	 * 
	 * @param idTable
	 *            {String} identificador del elemento table a ser creado como
	 *            objeto DataTable
	 * 
	 * @param columna
	 *            {Integer} identificador que hace referencia a la columna que
	 *            se quiere ordenar de la tabla, la columna 1 es la posición
	 *            0(véase como un arreglo)
	 * 
	 * @param orden
	 *            {String} identificador que hará referencia al orden en que se
	 *            desean mostrar los elementos, puede ser descendente o
	 *            ascendente, los parametros se pasan como "desc" o "asc"
	 *            respectivamente.
	 */
	function createSortedDataTableWhitOutInfo(idTable, columna, orden,
			aoColumnDefs) {
		return $('#' + idTable).dataTable({
			language : {
				url : $("#hdnRutaContexto").val() + getUrlLanguage()
			},
			responsive : {
				details : {
					display : $.fn.dataTable.Responsive.display.childRow
				}
			},
			"bFilter" : false,
			"bLengthChange" : false,
			"bPaginate" : false,
			"bInfo" : false,
			"autoWidth" : false,
			"aoColumnDefs" : aoColumnDefs,
			"order" : [ [ columna, orden ] ],
			"columnDefs" : [ {
				"targets" : 'no-sort',
				"orderable" : false
			} ]
		});
	}

	/**
	 * Crea una tabla por medio del componente DataTables 1.10
	 * 
	 * @param idTable
	 *            {String} identificador del elemento table ha ser creado como
	 *            objeto DataTable
	 * @returns Objeto DataTable creado
	 */
	function createDataTable(idTable, aoColumnDefs) {
		return $('#' + idTable).dataTable({
			language : {
				url : $("#hdnRutaContexto").val() + getUrlLanguage()
			},
			"aoColumnDefs" : aoColumnDefs,
			"columnDefs" : [ {
				"targets" : 'no-sort',
				"orderable" : false
			} ]
		});
	}

	/**
	 * Crea una tabla responsiva por medio del componente DataTables 1.10
	 * 
	 * @param idTable
	 *            {String} identificador del elemento table ha ser creado como
	 *            objeto DataTable
	 * @returns Objeto DataTable creado
	 */
	function createResponsiveDataTable(idTable, aoColumnDefs) {
		return $('#' + idTable).dataTable({
			language : {
				url : $("#hdnRutaContexto").val() + getUrlLanguage()
			},
			responsive : {
				details : {
					display : $.fn.dataTable.Responsive.display.childRow
				}
			},
			"aoColumnDefs" : aoColumnDefs,
			"columnDefs" : [ {
				"targets" : 'no-sort',
				"orderable" : false
			} ]
		});
	}

	/**
	 * Crea una tabla DataTable con la función de ordenar la tabla de acuerdo a
	 * N columnas que se pasan como parametros. El orden de los parametros al
	 * pasarse la funcion siempre es : [0] el id de la tabla , [1] el numero de
	 * la columna en el par N, [2] el orden (ascendente o descendente) de dicha
	 * columna en el par N
	 * 
	 * El la declaracion del metodo en emeth-dataTables no indica los parametros
	 * que se deben pasar, sino que hace uso del objeto arguments para obtener
	 * dichos parametros del arreglo aqui se maneja la primera poscicion del
	 * arguments como el id, y siempre toma los siguientes dos elementos del
	 * array como la pareja que se enviara al constructor de la tabla para su
	 * ordenamiento
	 * 
	 * @param idTable
	 *            {String} identificador del elemento table a ser creado como
	 *            objeto DataTable
	 * 
	 * @param columna
	 *            n {Integer} identificador que hace referencia a la columna que
	 *            se quiere ordenar de la tabla, la columna 1 es la posición
	 *            0(véase como un arreglo)
	 * 
	 * @param orden
	 *            n {String} identificador que hará referencia al orden en que
	 *            se desean mostrar los elementos de la primera columna, puede
	 *            ser descendente o ascendente, los parametros se pasan como
	 *            "desc" o "asc" respectivamente.
	 */

	function createSortedDataTable() {
		// Toma la primera posicion como el id
		var idTable = arguments[0];
		// Obtiene el numero de las columnas que se pretende ordenar
		var columnas = new Array(((arguments.length) - 1) / 2);
		// indice que corre el numero de columnas
		var index = 0;
		// indice que corre el valor del arguments
		var value = 1;
		var aoColumnDefs = undefined;

		for (index = 0; index < (((arguments.length) - 1) / 2); index++) {
			columnas[index] = [ arguments[value], arguments[value + 1] ];
			value = value + 2;
		}

		return $('#' + idTable).dataTable({
			language : {
				url : $("#hdnRutaContexto").val() + getUrlLanguage()
			},
			responsive : {
				details : {
					display : $.fn.dataTable.Responsive.display.childRow
				}
			},
			"aoColumnDefs" : aoColumnDefs,
			"order" : columnas
		});
	}

	/**
	 * Prepara el formulario para que al momento de dar submit, se envien todos
	 * los inputs de todas las paginas del dataTable
	 * 
	 * @param idForm
	 *            Identificador del formulario
	 * @param table
	 *            Objeto DataTable
	 * @returns
	 */
	function onSubmitDataTableForm(idForm, table) {
		$('#' + idForm).on(
				'submit',
				function(e) {
					var form = this;
					// Obtiene como un array de nombre y valor todos los
					// elementos del formulario de todas las paginas del
					// dataTable
					var params = table.$('input,select,textarea')
							.serializeArray();

					$.each(params,
							function() {
								// Si el elemento no existe en el DOM
								if (!$.contains(document, form[this.name])) {
									$(form).append(
											$('<input>').attr('type', 'hidden')
													.attr('name', this.name)
													.val(this.value));
								}
							});

				});
	}
	
	/**
	 * Quita  las propiedades de DataTable a una tabla ya creada
	 * @param idTable
	 * @returns
	 */
	function destroyDataTable(idTable){		
		return $('#'+idTable).dataTable().fnDestroy();
	}

	/**
	 * Obtiene la ruta en la que se encuentra el archivo de configuración del
	 * lenguaje utilizado para el componente de DataTable
	 * 
	 * @returns String con la ruta del archivo con la configuración del lenguaje
	 */
	function getUrlLanguage() {
		return $("#hdnUrlLanguageDataTable").val();
	}

	return {
		addRow : addRow,
		deleteRow : deleteRow,
		deleteRowId : deleteRowId,
		deleteRows : deleteRows,
		countRows : countRows,
		exist : exist,
		createDataTableWhitOutInfo : createDataTableWhitOutInfo,
		createSortedDataTableWhitOutInfo : createSortedDataTableWhitOutInfo,
		createDataTable : createDataTable,
		createSortedDataTable : createSortedDataTable,
		onSubmitDataTableForm : onSubmitDataTableForm,
		createResponsiveDataTable : createResponsiveDataTable,
		destroyDataTable:destroyDataTable
	};
}();