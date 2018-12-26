/**
 * @license Copyright (c) 2003-2018, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see https://ckeditor.com/legal/ckeditor-oss-license
 */

CKEDITOR.editorConfig = function( config ) {
	config.toolbar = 'Full';
//	// 这将配合：
//	config.toolbar_Full = [
//			//[ 'Source', '-', 'Save', 'NewPage', 'Preview', '-', 'Templates' ],
//			[ 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-',
//					'Print', 'SpellChecker', 'Scayt' ],
//			[ 'Undo', 'Redo', '-', 'Find', 'Replace', '-', 'SelectAll',
//					'RemoveFormat' ],
//			[ 'Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select',
//					'Button', 'ImageButton', 'HiddenField' ],
//			'/',
//			[ 'Bold', 'Italic', 'Underline', 'Strike', '-', 'Subscript',
//					'Superscript' ],
//			[ 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent',
//					'Blockquote' ],
//			[ 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock' ],
//			[ 'Link', 'Unlink', 'Anchor' ],
//			[ 'Image', 'Flash', 'Table', 'HorizontalRule', 'Smiley',
//					'SpecialChar', 'PageBreak' ], '/',
//			[ 'Styles', 'Format', 'Font', 'FontSize' ],
//			[ 'TextColor', 'BGColor' ] ];
			
	// 设置宽高
	config.width = 1080;
	config.height = 800;
	// 背景颜色
	config.uiColor = '#f1e4db';
	
			config.filebrowserBrowseUrl = './ckfinder/ckfinder.html',
			config.filebrowserImageBrowseUrl = './ckfinder/ckfinder.html?type=Images',
			config.filebrowserFlashBrowseUrl = './ckfinder/ckfinder.html?type=Flash',
			config.filebrowserUploadUrl = './ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files',
			config.filebrowserImageUploadUrl = './ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images',
			config.filebrowserFlashUploadUrl = './ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash',
			config.filebrowserWindowWidth = '1500',
			config.filebrowserWindowHeight = '1500'
};
