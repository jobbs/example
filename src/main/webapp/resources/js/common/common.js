/**
 * Form 안에 배열 변수들 정리
 */
function isArrayFormat(prop){
	var reg = /^(.*)+\[\]\.(.*)+$/;
	return reg.test(prop);
}
function replace_selector(str){
	return str.replace(/\[/gi,'\\[').replace(/\]/gi,'\\]').replace(/\./gi,'\\.').replace(/\+/gi,'\\+').replace(/\ /gi,'\\ ').replace(/\//gi,'\\ ');
}
function rename_form(_objName, propName){
	var objName = replace_selector(_objName);
	var fullName = fn_remove_arrayfmt(_objName+"."+propName);
	if(isArrayFormat(propName)){
		var cObjectName = propName.substring(0,propName.indexOf('[].'));
		var cPropName = propName.substring(propName.indexOf('[].')+3);
		var cLastPropName =  propName.substring(propName.lastIndexOf('.'));

		var objArr = $('[name^='+objName+'\\[][name$='+replace_selector(cLastPropName)+']');
		var objNames = $.map(objArr,function(item){
			if(fullName == fn_remove_arrayfmt($(item).attr('name'))){
				var strName = $(item).attr('name').substring(_objName.length);
				return _objName + strName.split('.')[0];
			}
		});
		var objNameArr = new Array();
		$.each(objNames,function(i, val){
			if($.inArray(val,objNameArr) == -1){
				objNameArr.push(val);
			}
		});

		$.each(objNameArr,function(idx,item){
			var begin = replace_selector(item)+'\\.'+replace_selector(cObjectName)+'\\[';
			var end = replace_selector(cLastPropName);
			var newNamePre =  _objName+'['+idx+']';
			var className = fn_remove_arrayfmt(_objName);
			$('[name^='+begin+'][name$='+end+']').each(function(ci){
				if(fullName == fn_remove_arrayfmt($(this).attr('name')) && !$(this).hasClass(className)){
					var oldName = $(this).attr('name').substring(_objName.length);
					var newName = newNamePre+ oldName.substring(oldName.indexOf(']')+1);
					$(this).attr('name',newName);
					$(this).addClass(className);
				}
			});
			rename_form(newNamePre+'.'+cObjectName,cPropName);
		});
	}else{
		var begin = replace_selector(_objName+'[');
		var end = replace_selector('].'+propName);
		var objs = $('[name^='+begin+'][name$='+end+']');
		var index = 0;
		$.each(objs,function(idx,item){
			if(fullName == fn_remove_arrayfmt($(item).attr('name'))){
				var newName = _objName+'['+index+'].'+propName;
				$(item).attr('name',newName);
				index++;
			}
		});
	}
}
function fn_remove_arrayfmt(names){
	var arr = [];
	$.each(names.split('.'),function(i,item){
		if(item.indexOf('[') >= 0){
			arr[i] = item.substring(0,item.indexOf('['));
		}else{
			arr[i] = item;
		}
	});
	return arr.join('.');
}
function remove_rename_class(objName, propNames){
	var props = propNames.split(',');
	var removeClassNames = new Array();

	for(var pi=0; pi<props.length;pi++){
		var propName = props[pi];
		if(isArrayFormat(propName)){

			var fullName = objName+"."+fn_remove_arrayfmt(propName);
			var arrName = fullName.split('.');
			for(var i=0; i< arrName.length; i++){
				var tmp = [];
				for(var j=0; j<=i; j++){
					tmp[j] = arrName[j];
				}
				var className = tmp.join('.');
				if($.inArray(className,removeClassNames) == -1){
					removeClassNames.push(className);
				}
			}
		}
	}

	var classResult = $.map(removeClassNames,function(name){
		return '.'+replace_selector(name);
	});
	$(classResult.join(',')).removeClass(removeClassNames.join(' '));
}
var fn_form_rename = function(objName, propNames){

	//remove_rename_class(objName, propNames);

	var props = propNames.split(',');

	for(var i=0; i<props.length;i++){
		var propName = props[i];
		rename_form(objName, propName);
	}
};

/**
 * Ajax Form 처리 후 Handler
 */
var alert_message = function(msgList, callback, type){

	if(msgList){
		var title = "경고";
		if( type == "INFO" ) {
			title = "확인"
		}

		jAlert(msgList.join('<br />'), callback, title);
	} else {
		callback();
	}
};
var handler_reload = function(result){

	alert_message(result.messageList, function() {
		if(result.success){
			location.reload();
		}
	});


};
var handler_openerreload = function(result){

	alert_message(result.messageList, function() {
		opener.location.reload();
	});
};
var handler_openerreloadclose = function(result){

	alert_message(result.messageList, function() {
		if(result.success){
			window.close();
			opener.location.reload();
		}
	});

};


/**
 * 윈도우 팝업창
 */

//$.browser이 삭제 되어 해당 항목 추가
(function () {
    var matched, browser;

    // Use of jQuery.browser is frowned upon.
    // More details: http://api.jquery.com/jQuery.browser
    // jQuery.uaMatch maintained for back-compat
    jQuery.uaMatch = function (ua) {
        ua = ua.toLowerCase();

        var match = /(chrome)[ \/]([\w.]+)/.exec(ua) ||
            /(webkit)[ \/]([\w.]+)/.exec(ua) ||
            /(opera)(?:.*version|)[ \/]([\w.]+)/.exec(ua) ||
            /(msie) ([\w.]+)/.exec(ua) ||
            ua.indexOf("compatible") < 0 && /(mozilla)(?:.*? rv:([\w.]+)|)/.exec(ua) ||
            [];

        return {
            browser: match[1] || "",
            version: match[2] || "0"
        };
    };

    matched = jQuery.uaMatch(navigator.userAgent);
    browser = {};

    if (matched.browser) {
        browser[matched.browser] = true;
        browser.version = matched.version;
    }

    // Chrome is Webkit, but Webkit is also Safari.
    if (browser.chrome) {
        browser.webkit = true;
    } else if (browser.webkit) {
        browser.safari = true;
    }

    jQuery.browser = browser;
})();


var windowOpen = function(url, params, args) {

	var key, width, height, posX, posY, scrollbars, resizable, modal, menubar, toolbar;
	var features;
	if( !url ) return;

	//넘어온 파라메터가 JSON 형태인지 확인
	if( $.isPlainObject(params) ) {
		params = $.param(params);
	}

	if( url.indexOf("?") >= 0 ) {
		if( params != "") url = url + "&" + params;
	} else {
		if( params != "" ) url = url + "?" + params;
	}

	key = (args && args.key) ? args.key:"";
	width = (args && args.width) ? parseInt(args.width):320;
	height = (args && args.height) ? parseInt(args.height):600;
	posX = (args && args.posX) ? args.posX : 0;
	posY = (args && args.posY) ? args.posY : 0;
	resizable = (args && args.resizable) ? args.resizable : "yes";
	scrollbars = (args && args.scrollbars) ? args.scrollbars : "yes";
	modal = (args && args.modal) ? args.modal:"no";
	menubar = (args && args.menubar) ? args.menubar:"no";
	toolbar = (args && args.toolbar) ? args.toolbar:"no";

	//IE 체크
	if( $.browser.msie ) { height += 25; }

	//IE일 경우 모달창을 호출
	if( $.browser.msie && modal == "yes" ) {
		features = "resizable:" + resizable + ";scroll:" + scrollbars + ";status:no;center:yes;help:no;dialogWidth:" + width + "px;dialogHeight:" + height + "px;";
	} else {

		features = "top=" + posX + ",left=" + posY +
					",scrollbars=" + scrollbars +
					",width=" + width + ",height=" + height + ",menubar=" + menubar + ",toolbar=" + toolbar +
					",minimizable=" + resizable + ",resizable=" + resizable;
	}
	var win = window.open(url, "CommonPopup" + key, features);
	win.focus();
};

function popup(url, key, width, height){
	var args = {key:key, width:width, height: height};
	windowOpen(url, "", args);
}

/**
 * Dynatree에서 사용함
 * 두개의 값을 비교하여 정렬
 * 사용법 : rootNode.sortChildren(comp, false);
 */
function comp(source, target) {
	source = source.data.title.toLowerCase();
	target = target.data.title.toLowerCase();
	return source > target ? 1 : source < target ? -1 : 0;
}

var goToUrl = function(url){
	location.href = url;
};

//Datepicker 날짜 제한 처리
function initDate(source, target, type) {
	$("#" + target).datepicker("option", (type=="S"?"minDate":"maxDate"), $(source).val());
}

function formReset(id) {
	$("form[id='" + id + "'] input, form[id='" + id + "'] select").each(function() {
		if( $(this)[0].nodeName == "SELECT" ) {
			$(this).val('').attr('selected', 'selected');
		} else {
			if( $(this).attr("type") != "hidden" ) {
				if( $(this).attr("type") == "text" ) {
					$(this).val("");
				} else if( $(this).attr("type") == "radio" || $(this).attr("type") == "checkbox" ) {
					$(this).prop("checked", false);
				}
			}
		}

	});
}

function changeRecordCntPerPage(action, formId) {
	$("#recordCountPerPage").val($("#tmpCntPerPage").val());
	$("#" + formId).attr("action", action);
	$("#" + formId).submit();
}

Array.prototype.remove = function(str) {
	var pos = this.indexOf(str);
	this.splice(pos,1);
};

Array.prototype.customPush = function(str) {
	var pos = this.indexOf(str);
	if( pos < 0 ) this.push(str);
};

/**
 * Index에 해당하는 배열의 값을 삭제한다.
 * @param index : 해당 배열의 키값
 */
Array.prototype.removeElement = function(index) {
	var t = this;
	t.splice(index, 1);
	return t;
};

/**
 * Value에 해당하는 값을 삭제 한다.
 * @param val : 배열에서 삭제하고자 하는 값
 */
Array.prototype.removeValue = function(val) {
	var index = -1;
	for( var i=0; i < this.length; i ++ ) {
		if( this[i] == val ) {
			index = i;
			break;
		}
	}

	if( index >= 0 )
		this.removeElement(index);
};

/**
 * Ajax전송시 로딩바 생성
 */
function doStartLoding() {
	var html = '<div class="loading black"><span class="loadingbar"></span></div>';
	$("body").append(html);
}

function doEndLoding() {
	$(".loading").remove();
}
