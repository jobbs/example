(function($, window, document, undefined) {

	var pluginName = "createSelectboxFile";
	var defaults = {
		fields : new Array(),
		fileName : "uploadFile",
		multiType : "multi",
		maxCount : 5,
		fileCount : 0,
		allowExt : ["jpg","gif","png","bmp","txt","pdf","hwp","gul","docx","doc","zip","xls","xlsx","ppt","pptx"],
		data : new Array()
	};

	function Plugin(element, options) {
		this.element = element;
		this.options = $.extend({}, defaults, options);
		this._defaults = defaults;
		this._name = pluginName;

		this.init();
	}

	Plugin.prototype = {

		init : function() {

			var $this = $(this);
			var opt = defaults;
			var box = $(this.element);
			var options = this.options;

			var fileSeq = 0;

			if( options.multiType == "single") {
				createBoxSingle();
			} else {
				createBox();
				addFileField();
				setData();
			}

			function createBoxSingle() {

				box.append('<div class="file-form-field input-group">' +
						'<input type="text" class="form-control file-name" value="파일선택" title="파일선택" disabled="disabled">' +
						'<p class="input-group-btn"><label for="atchFile" class="file-label btn">찾아보기</label></p>' +
						'<input type="file" class="form-control file-hidden" title="첨부파일" name="'  + options.fileName +  '" id="atchFile"/>' +
						'</div>');

				$("#atchFile").change(function() {

					if(window.FileReader){
            			var fileName = $(this)[0].files[0].name;
            		}else{
                		var fileName = $(this).val().split("/").pop().split("\\").pop();
                	}

               		$(this).siblings(".file-name").val(fileName);
				});
			}

			/************************************************************************
			 * 해당 DIV에 파일을 그려줄 Layout 생성
			 ***********************************************************************/
			function createBox() {
				//box.append("<div class='input-group file-form-field' id='fieldDiv'></div>");
				// 등록가능 파일이 하나일 경우 selectBox를 생성하지 않음
				if( options.maxCount > 1 ) {
					box.append("<div class='input-group file-form-select' id='fileSelectDiv'>" +
						"<select name='attachList' class='form-control file-select-multiple' id='attachList' multiple title='파일목록 박스'></select>" +
						"<p class='file-btn'><input type='button' class='btn' id='deleteButton' value='파일삭제' title=''/>" +
						"</div>"
					);
					$("#deleteButton").on("click", _delete);
				}
			}

			/************************************************************************
			 * 허용된 파일 확장자 인지 확인
			 ***********************************************************************/
			function _limitExt(path) {

				var allowSubmit = false;
				var ext = path.substring(path.lastIndexOf(".") + 1);
				var extArray = options.allowExt;
				for( var i=0; i<extArray.length; i++ ) {
					if( extArray[i] == ext.toLowerCase() ) {
						allowSubmit = true;
						break;
					}
				}

				/*while( path.indexOf('\\') != -1 ) {
					path = path.slice( path.indexOf('\\') + 1 );
					ext = path.slice( path.indexOf(".") + 1 ).toLowerCase();

					var extArray = options.allowExt;
					for( var i=0; i<extArray.length; i++ ) {
						if( extArray[i] == ext ) {
							allowSubmit = true;
							break;
						}
					}
				}*/

				return allowSubmit;
			}

			/************************************************************************
			 * 파일의 허용된 확장자가 아니거나 또는 파일 첨부 갯수를 초과 하였을 경우 해당 file 필드를 삭제하고 다시 생성
			 ***********************************************************************/
			function _deleteField(obj) {
				$(obj).parent().remove();
				addFileField();
			}

			/************************************************************************
			 * 파일이 등록되었을 때 확장자 또는 첨부 파일의 갯수를 확인하고 등록이 되면 별도의 file 필드 추가
			 ***********************************************************************/
			function _change() {

				var that = $(this);
				var filepath = $(this).val();
				var filename = filepath.substring(filepath.lastIndexOf('\\') + 1, filepath.length);

				if( _limitExt(filepath) == false ) {

					jAlert( "허용하지 않는 확장자 입니다.<br />허용확장자 [" + options.allowExt + "]", function() {
						_deleteField($(that));
					} );

					return;
				}

				// 등록가능 파일이 하나일 경우 파일 갯수 및 Selectbox에 추가 하는 루틴 삭제
				if( options.maxCount > 1 ) {
					if( $("#attachList").children("option").size() > options.maxCount-1 ) {
						jAlert( "첨부파일은 " + options.maxCount + "개까지 추가할 수 있습니다.", function(){
							_deleteField($(that));
						});
						return;
					}

					$("#attachList").append("<option value='" + filepath + "'>" + filename + "</option>");

					//selectbox에 추가 후 filefield 추가
					addFileField();
				}
			}

			/************************************************************************
			 * 삭제 버튼클릭 이벤트
			 ***********************************************************************/
			function _delete() {

				if( $("#attachList option:selected").length == 0 ) {
					jAlert( "삭제하고자 하는 파일을 선택하여 주시기 바랍니다.");
					return;
				}

				var optionSize = $("#attachList option").size();
				for( var i = (optionSize-1); i >= 0; i-- ) {

					if( $("#attachList option:eq(" + i + ")").prop("selected") ) {

						if( $("#attachList option:eq(" + i + ")").val().indexOf("old_") > -1 ) {
							box.append("<input type='hidden' name='deleteFile' value='" + $("#attachList option:eq(" + i + ")").val().replace("old_","") + "'style='display:'/>");
						} else {
							box.find(" > div.file-form-field").eq(i).remove();
						}

						$("#attachList option:eq(" + i + ")").remove();
					}
				}
			}

			/************************************************************************
			 * 기본데이타 파일 추가
			 ***********************************************************************/
			function setData() {
				var file = null;
				for(var i=0; i < options.data.length; i++ ) {
					file = options.data[i];
					$("#attachList").append("<option value='old_" + file.idx + "'>" + file.fileName + "</option>");
				}
			}

			/************************************************************************
			 * 파일이 추가 되거나 또는 최초 하나의 file 필드 생성
			 ***********************************************************************/
			function addFileField() {

				box.find(" > div.file-form-field").hide();

				$("#fileSelectDiv").before(
						"<div class='input-group file-form-field' id='fieldDiv-"+ fileSeq + "'>" +
						"<input type='text' class='form-control file-name' id='file-" + fileSeq + "-txt' disabled='disabled' title='파일선택'>" +
						"<p class='input-group-btn'><label for='file-" + fileSeq + "' class='file-label btn'>찾아보기</label></p>" +
						"<input type='file' class='form-control file-hidden' id='file-" + fileSeq + "' name=' " + options.fileName + "' title='첨부파일'/>" + //
						"</div>"//
				);

				$("#file-" + fileSeq).on("change", _change );

				fileSeq++;
			}
		}
	};

	/************************************************************************
	 * 플러그인 생성
	 ***********************************************************************/
	$.fn[pluginName] = function(options) {

		return this.each(function() {
			if( !$.data(this, "plugin_" + pluginName) ) {
				$.data(this, "plugin_" + pluginName, new Plugin(this, options));
			}else {

			}
		});
	};

})(jQuery, window, document)