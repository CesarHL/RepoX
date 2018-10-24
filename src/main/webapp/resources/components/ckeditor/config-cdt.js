CKEDITOR.editorConfig = function( config ) {
	
	config.language = 'es-mx';
	
	config.toolbar = [
		{ name: 'basicstyles',  items: [ 'Bold', 'Italic', 'Underline', 'Strike', 'Subscript', 'Superscript' ]  },
		{ name: 'paragraph', items: [ 'NumberedList', 'BulletedList', '-','JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock' ]  },
		{ name: 'styles', items:['FontSize']},
		{ name: 'colors',items: [ 'TextColor', 'BGColor' ]},
	];	
};