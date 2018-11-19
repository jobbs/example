/**
 * 2012-09-17
 * 폼의 유효성 체크 및 입력 제어
 * @ministar
 *
 * 2012.10.09 - each문을 이용하여 반복하도록 수정
 * 2012.10.12 - 실시간으로 생성되는 양식(ajax)에도 작동하게 live 적용
 * datepicker의 live 연결 방법을 못찾았음 - 추후 연구
 *
 * 1. 폼체크 적용방법
 * form submit 전에 fn_form_validation(form_id) 호출
 * ex) if (!fn_form_validation(fid)) { return; }
 *
 * 2. 폼 자동완성 사용법
 * form element에 name, id, title attribute 설정
 * 가능 css :
 * 		onlyNumber			- 숫자만
 * 		onlyInteger			- 정수형만
 * 		onlySignInteger		- 기호형 정수만
 * 		onlyIntegerNF		- 콤마 정수
 * 		onlySignIntegerNF	- 콤마 기호형 정수
 * 		onlyFloat			- 실수형
 * 		onlySignFloat		- 기호 실수형
 * 		onlyFloatNF			- 콤마 실수형
 * 		onlySignFloatNF		- 콤마 기호 실수형
 * 		onlyAlpha			- 영문만
 * 		onlyAlphaNum		- 영문, 숫자만
 * 		onlyAlphaNumDash	- 영문, 숫자, dash
 * 		onlyNumDash			- 숫자, dash
 * 		onlyDate			- 날짜형만
 * 		onlyDateTime		- 날짜시간형만
 * 		onlyPhone			- 전화번호 형식만
 * 		onlyIp				- IP 형식만
 * 		onlyEmail			- email 형식만
 * 		datepicker			- 달력 () - 실시간 생성되는 datepicker는 수동으로 설정해 줄것.
 *      onlyMac             - MAC 형식만
 * ex) <input type="text" name="fiedl1" id="field1" title="이름" class="onlyIntegerNF essential" />
 *     <form:input path="fiedl1" title="이름" cssClass="onlyIntegerNF essential" />
 */


//################################################

/**
 * 숫자에 콤마 적용
 */
fn_number_format = function(str) {
	str = '' + str + ''; // 숫자가 올때 이상작동 방지
	if (str == '') return '';
	var nStr1 = str; //.split(',').join('');
	var nStr2 = '';
	if (str.indexOf('.')>=0) {
		nStr1 = str.substr(0, str.indexOf('.'));
		nStr2 = str.substr(str.indexOf('.'), str.length);
	}
	nStr1 = nStr1.replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1,');
	return '' + nStr1 + nStr2;
};

/*
 * 숫자에 콤마 제거
 */
fn_strip_comma = function(str) {
	str = '' + str + ''; // 숫자가 올때 이상작동 방지
	if (str == '') return '';
	var nStr1 = str;
	var nStr2 = '';
	if (str.indexOf('.')>=0) {
		nStr1 = str.substr(0, str.indexOf('.'));
		nStr2 = str.substr(str.indexOf('.'), str.length);
	}
	nStr1 = nStr1.split(',').join('');
	return '' + nStr1 + nStr2;
};

/*
 * 정수형만
 */
fn_only_integer = function(str) {
	str = '' + str + '';
	if (str == '') return true;
	var regOnlyInteger = /^[1-9]+\d*$/;
	return str == '0' || regOnlyInteger.test(str);
};

/*
 * 기호형 정수형만
 */
fn_only_sign_integer = function(str) {
	str = '' + str + '';
	if (str == '') return true;
	var regOnlySignInteger = /^([-]?[1-9])+\d*$/;
	return str == '0' || regOnlySignInteger.test(str);
};

/*
 * 양의 정수 0 제외
 */
fn_only_positive_integer_exclude_zero = function(str) {
	str = '' + str + '';
	if (str == '') return true;
	var regOnlyInteger = /^[1-9]+\d*$/;
	return regOnlyInteger.test(str);
};

/*
 * 실수형만
 */
fn_only_float = function(str) {
	str = '' + str + '';
	if (str == '') return true;
	var regOnlyFloat = /^\d+\d*((\.?)\d*\d+)?$/;
	var tmp = str.split(".");
	return (str == '0' || regOnlyFloat.test(str)) && fn_only_integer(tmp[0]);
};

/*
 * 기호형 실수형만
 */
fn_only_sign_float = function(str) {
	str = '' + str + '';
	if (str == '') return true;
	if (str.substr(0, 1) == '-') {
		return fn_only_float(str.substr(1));
	}
	else {
		return fn_only_float(str);
	}
};

/*
 * 숫자 유효성 체크
 */
fn_only_number = function(str) {
	str = '' + str + '';
	if (str == '') return true;
	var regOnlyNumber = /^\d*$/  ;
	return regOnlyNumber.test(str);
};

/*
 * 영문 유효성 체크
 */
fn_only_alpha = function(str) {
	str = '' + str + '';
	if (str == '') return true;
	var regOnlyAlpha = /^[a-zA-Z]*$/  ;
	return regOnlyAlpha.test(str);
};

/*
 * 숫자와 영문 유효성 체크
 */
fn_only_alpha_num = function(str) {
	str = '' + str + '';
	if (str == '') return true;
	var regOnlyAlphaNum = /^[0-9a-zA-Z]*$/  ;
	return regOnlyAlphaNum.test(str);
};

/*
 * 숫자와 영문, dash 유효성 체크
 */
fn_only_alpha_num_dash = function(str) {
	str = '' + str + '';
	if (str == '') return true;
	var regOnlyAlphaNumDash = /^[0-9a-zA-Z^-]*$/  ;
	return regOnlyAlphaNumDash.test(str);
};

// 날짜형 유효성 체크
fn_only_date = function(str) {
	str = '' + str + '';
	if (str == '') return true;
	var regOnlyDate = /^\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/;
	return regOnlyDate.test(str);
};

//날짜시간형 유효성 체크
fn_only_date_time = function(str) {
	if (str == '') return true;
	var regOnlyDateTime = /^(19[7-9][0-9]|20\d{2})-(0[0-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])\s(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])$/;
	return regOnlyDateTime.test(str);
};

/*
 * 전화번화 형식 유효성 체크 - 00(0)-000(0)-0000
 */
fn_only_phone = function(str) {
	str = '' + str + '';
	if (str == '') return true;
	var regOnlyPhone = /^0\d{1,2}-\d{3,4}-\d{4}$/ ;
	return regOnlyPhone.test(str);
};

/*
 * email 유효성 체크
 */
fn_only_email = function(str) {
	str = '' + str + '';
	if (str == '') return true;
	var regOnlyEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	return regOnlyEmail.test(str);
};

/*
 * IP 유효성 체크
 */
fn_only_ip = function(str) {
	str = '' + str + '';
	if (str == '') return true;
//	var regOnlyIp = /^(1|2)?\d?\d([.](1|2)?\d?\d){3}$/;
	var regOnlyIp = /^([1-9]?[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])(\.([1-9]?[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])){3}$/;
	return regOnlyIp.test(str);
};

/*
 * MAC 유효성 체크
 */
fn_only_mac = function(str) {
	str = '' + str + '';
	if (str == '') return true;
	var regOnlyMac = /^([0-9a-fA-F]{2}[:-]){5}[0-9a-fA-F]{2}$/i;
	return regOnlyMac.test(str);
};

/*
 * 콤마 정수형 유효성 체크
 */
fn_only_integer_nf = function(str) {
	str = '' + str + '';
	if (str == '') return true;
	if (str != fn_number_format(fn_strip_comma(str)))
		return false;
	return fn_only_integer(fn_strip_comma(str));
};

/*
 * 콤마 기호정수형 유효성 체크
 */
fn_only_sign_integer_nf = function(str) {
	str = '' + str + '';
	if (str == '') return true;
	if (str != fn_number_format(fn_strip_comma(str)))
		return false;
	return fn_only_sign_integer(fn_strip_comma(str));
};

/*
 * 콤마 실수형 유효성 체크
 */
fn_only_float_nf = function(str) {
	str = '' + str + '';
	if (str == '') return true;
	if (str != fn_number_format(fn_strip_comma(str)))
		return false;
	return fn_only_float(fn_strip_comma(str));
};

/*
 * 콤마 기호 실수형 유효성 체크
 */
fn_only_sign_float_nf = function(str) {
	str = '' + str + '';
	if (str == '') return true;
	if (str != fn_number_format(fn_strip_comma(str)))
		return false;
	return fn_only_sign_float(fn_strip_comma(str));
};


/**
 * byteString 누락 추가 2017-07-19
 */
$.byteString = function(str) {
	var tempStr = new String(str);
	var len = 0;

	for (var i=0; i<str.length; i++) {
		var c = escape(str.charAt(i));
		if (c.length == 1) len++;
		else if (c.indexOf("%u")!=-1) len+=2;
		else if (c.indexOf("%")!=-1) len+=c.length/3;
	}
	return len;
}

/*
 * Byte 체크
 */
fn_check_byte = function(str,limit){
	if($.byteString(str)>limit){
		return false;
	}
	return true;
};


//#########################################################
/*
 * 폼 유효성 체크
 *
 */
fn_form_validation = function(fid) {

	var bValid = true;

	$("form[id="+fid+"] :input").each(function(){

		var $this = $(this);

		if ($(this).hasClass("onlyInteger")) {
			if (!fn_only_integer($(this).val())) {
    			jAlert($(this).attr('title') + ' : 정수만 입력 가능합니다.', function() {
        			$this.focus();
        		});
            	return bValid = false;
        	}
		}

		if ($(this).hasClass("onlySignInteger")) {
        	if (!fn_only_sign_integer($(this).val())) {
        		jAlert($(this).attr('title') + ' : (음/양)정수만 입력 가능합니다.', function() {
        			$this.focus();
        		});
    			return bValid = false;
        	}
    	}

		if ($(this).hasClass("onlyPositiveIntegerExcludeZero")) {
        	if (!fn_only_positive_integer_exclude_zero($(this).val())) {
        		jAlert($(this).attr('title') + ' : 1이상의 정수만 입력 가능합니다.', function() {
        			$this.focus();
        		});
    			return bValid = false;
        	}
    	}

    	if ($(this).hasClass("onlyFloat")) {
        	if (!fn_only_float($(this).val())) {
        		jAlert($(this).attr('title') + ' : 실수만 입력 가능합니다.', function() {
        			$this.focus();
        		});
    			return bValid = false;
        	}
    	}

    	if ($(this).hasClass("onlySignFloat")) {
        	if (!fn_only_sign_float($(this).val())) {
        		jAlert($(this).attr('title') + ' : (음/양)실수만 입력 가능합니다.', function() {
        			$this.focus();
        		});
    			return bValid = false;
        	}
    	}

    	if ($(this).hasClass("onlyIntegerNF")) {
        	if (!fn_only_integer_nf($(this).val())) {
        		jAlert($(this).attr('title') + ' : 정수형 형식이 올바르지 않습니다.', function() {
        			$this.focus();
        		});
    			return bValid = false;
        	}
    	}

    	if ($(this).hasClass("onlySignIntegerNF")) {
        	if (!fn_only_integer_nf($(this).val())) {
        		jAlert($(this).attr('title') + ' : 정수형 형식이 올바르지 않습니다.', function() {
        			$this.focus();
        		});
            	return bValid = false;
        	}
    	}

    	if ($(this).hasClass("onlyFloatNF")) {
        	if (!fn_only_float_nf($(this).val())) {
        		jAlert($(this).attr('title') + ' : 실수형 형식이 올바르지 않습니다.', function() {
        			$this.focus();
        		});
            	return bValid = false;
        	}
    	}

    	if ($(this).hasClass("onlySignFloatNF")) {
        	if (!fn_only_sign_float_nf($(this).val())) {
        		jAlert($(this).attr('title') + ' : 실수형 형식이 올바르지 않습니다.', function() {
        			$this.focus();
        		});
            	return bValid = false;
        	}
    	}

    	if ($(this).hasClass("onlyNumber")) {
        	if (!fn_only_number($(this).val())) {
        		jAlert($(this).attr('title') + ' : 숫자만 입력 가능합니다.', function() {
        			$this.focus();
        		});
            	return bValid = false;
        	}
    	}

    	if ($(this).hasClass("onlyAlpha")) {
        	if (!fn_only_alpha($(this).val())) {
        		jAlert($(this).attr('title') + ' : 영문자만 입력 가능합니다.', function() {
        			$this.focus();
        		});
            	return bValid = false;
        	}
    	}

    	if ($(this).hasClass("onlyAlphaNum")) {
        	if (!fn_only_alpha_num($(this).val())) {
        		jAlert($(this).attr('title') + ' : 영문자와 숫자만 입력 가능합니다.', function() {
        			$this.focus();
        		});
            	return bValid = false;
        	}
    	}

    	if ($(this).hasClass("onlyAlphaNumDash")) {
        	if (!fn_only_alpha_num_dash($(this).val())) {
        		jAlert($(this).attr('title') + ' : 영문자와 숫자, -만 입력 가능합니다.', function() {
        			$this.focus();
        		});
            	return bValid = false;
        	}
    	}

    	if ($(this).hasClass("onlyDate")) {
        	if (!fn_only_date($(this).val())) {
        		jAlert($(this).attr('title') + ' : 날짜 형식을 YYYY-MM-DD 형식으로 입력하세요.', function() {
        			$this.focus();
        		});
            	return bValid = false;
        	}
    	}

    	if ($(this).hasClass("onlyDateTime")) {
        	if (!fn_only_date_time($(this).val())) {
        		jAlert($(this).attr('title') + ' : 날짜 형식을 YYYY-MM-DD HH:mm 형식으로 입력하세요.', function() {
        			$this.focus();
        		});
            	return bValid = false;
        	}
    	}

    	if ($(this).hasClass("onlyPhone")) {
        	if (!fn_only_phone($(this).val())) {
        		jAlert($(this).attr('title') + ' : XXX-XXXX-XXXX 형식으로 입력하세요.', function() {
        			$this.focus();
        		});
            	return bValid = false;
        	}
    	}

    	if ($(this).hasClass("onlyIp")) {
        	if (!fn_only_ip($(this).val())) {
//        		jAlert($(this).attr('title') + ' : 0.0.0.0 ~ 255.255.255.255 범위 안에서 입력하세요.', function() {
    			jAlert($(this).attr('title') + ' : 올바른 IP주소 형식으로 입력하세요.', function() {
        			$this.focus();
        		});
            	return bValid = false;
        	}
    	}

    	if ($(this).hasClass("onlyMac")) {
        	if (!fn_only_mac($(this).val())) {
        		jAlert($(this).attr('title') + ' : XX:XX:XX:XX:XX:XX 형식으로 입력하세요.', function() {
        			$this.focus();
        		});
            	return bValid = false;
        	}
    	}

    	if ($(this).hasClass("onlyEmail")) {
        	if (!fn_only_email($(this).val())) {
        		jAlert($(this).attr('title') + ' : 올바른 이메일 형식을 입력하세요.', function() {
        			$this.focus();
        		});
            	return bValid = false;
        	}
    	}

    	// 최소값, 최대값 체크

    	// 필수 입력 체크
    	if ($(this).hasClass("essential")) {
    		if ($(this)[0].type == 'radio') {
    			var eln = replace_selector($(this)[0].name);
    			if ($("form[id="+fid+"] :radio[name="+eln+"]:checked").length == 0) {
    				jAlert($(this).attr('title') + ' : 필수항목입니다.', function() {
	        			$this.focus();
	        		});
    				return bValid = false;
    			}
    		}
    		else if ($(this)[0].type == 'checkbox') {
    			if (!$(this)[0].checked) {
    				jAlert($(this).attr('title') + ' : 필수항목입니다.', function() {
	        			$this.focus();
	        		});
    				return bValid = false;
    			}
    		}
    		else {
	        	if ($.trim($(this).val()) == '') {
	        		jAlert($(this).attr('title') + ' : 필수 항목입니다.', function() {
	        			$this.focus();
	        		});

	    			return bValid = false;
	        	}
    		}
    	}

    	// 조건에 따른 필수 입력 체크 (아이디로 체크)
    	if ($(this).hasClass("essentialBy")) {
    		var names = $(this).attr('essentialBy');

    		if (names == '' || names == undefined) {
    			return bValid = true;
    		}

    		var byNames = names.split(',');

    		var bValue = false;
    		for (var essLoop=0; essLoop < byNames.length; essLoop++) {

    			byName = replace_selector($.trim(byNames[essLoop]));
    			if (byName == '') continue;

	    		var el2 = $("form[id="+fid+"] :input[name="+byName+"]");

	    		if ($(el2)[0].type == 'radio') {
	    			var el2name = $(el2)[0].name;
	    			if ($("form[id="+fid+"] :radio[name="+replace_selector(el2name)+"]:checked").length > 0) {
	    				bValue = true;
	    				break;
	    			}
	    		}
	    		else if ($(el2)[0].type == 'checkbox') {
	    			var el2name = $(el2)[0].name;

	    			if ($("form[id="+fid+"] :checkbox[name="+replace_selector(el2name)+"]").length > 0) {
	    				bValue = true;
	    				break;
	    			}
	    		}
	    		else {
	    			if ($.trim($(el2).val()) != '') {
	    				bValue = true;
	    				break;
	    			}
	    		}
    		}

    		if (bValue) {
    			if ($(this)[0].type == 'radio') {
    				var eln = $(this)[0].name;
    				if ($("form[id='"+fid+"'] :radio[name='"+eln+"']:checked").length == 0) {
    					jAlert($(this).attr('title') + ' : 필수항목입니다.', function() {
    	        			$this.focus();
    	        		});
    					return bValid = false;
    				}
    			}
    			else if ($(this)[0].type == 'checkbox') {
    				var eln = $(this)[0].name;

    				if ($("form[id='"+fid+"'] :checkbox[name='"+eln+"']:checked").length == 0) {
    					jAlert($(this).attr('title') + ' : 필수항목입니다.', function() {
    	        			$this.focus();
    	        		});
    					return bValid = false;
    				}
    			}
    			else {
    				if ($.trim($(this).val()) == '') {
    					jAlert($(this).attr('title') + ' : 필수 항목입니다.', function() {
    	        			$this.focus();
    	        		});
    					return bValid = false;
    				}
    			}
    		}
    	}

    	// Byte 체크
    	if($(this).hasClass('checkByte')){
    		if (!fn_check_byte($(this).val(),$(this).attr('maxlength'))) {
        		jAlert($(this).attr('title') + ' : '+$(this).attr('maxlength')+'byte를 넘을수 없습니다', function() {
        			$this.focus();
        		});
            	return bValid = false;
        	}
    	}

    	if($(this).hasClass('greaterEqual')){

    		var bValue = true;

    		if($.trim($(this).val()) == ''){
    			bValue = false;
    		}

    		var names = $(this).attr('greaterEqual');

    		if (bValue && (names == '' || names == undefined)) {
    			bValue = false;
    		}

    		var target = $("form[id="+fid+"] :input[name="+replace_selector(names)+"]");
    		if(bValue && (target.length == 0 || $.trim(target.val()) == '')){
    			bValue = false;
    		}

    		if(bValue && !($.trim($(this).val()) >= $.trim(target.val()))){
    			jAlert($(this).attr('title') + ' : '+ target.attr('title') +'보다 크거나 같아야 합니다.', function() {
        			$this.focus();
        		});
    			return bValid = false;
    		}


    	}

    	if($(this).hasClass('lessEqual')){

    		var bValue = true;

    		if($.trim($(this).val()) == ''){
    			bValue = false;
    		}

    		var names = $(this).attr('lessEqual');

    		if (bValue && (names == '' || names == undefined)) {
    			bValue = false;
    		}

    		var target = $("form[id="+fid+"] :input[name="+replace_selector(names)+"]");
    		if(bValue && (target.length == 0 || $.trim(target.val()) == '')){
    			bValue = false;
    		}

    		if(bValue && !($.trim($(this).val()) <= $.trim(target.val()))){
    			jAlert($(this).attr('title') + ' : '+ target.attr('title') +'보다 작거나 같아야 합니다.', function() {
        			$this.focus();
        		});
    			return bValid = false;
    		}


    	}

    	if($(this).hasClass('greater')){

    		var bValue = true;

    		if($.trim($(this).val()) == ''){
    			bValue = false;
    		}

    		var names = $(this).attr('greater');

    		if (bValue && (names == '' || names == undefined)) {
    			bValue = false;
    		}

    		var target = $("form[id="+fid+"] :input[name="+replace_selector(names)+"]");

    		if(bValue && (target.length == 0 || $.trim(target.val()) == '')){
    			bValue = false;
    		}

    		if(bValue && !($.trim($(this).val()) > $.trim(target.val()))){
    			jAlert($(this).attr('title') + ' : '+ target.attr('title') +'보다 커야 합니다.', function() {
        			$this.focus();
        		});
    			return bValid = false;
    		}


    	}

    	if($(this).hasClass('less')){
    		var bValue = true;

    		if($.trim($(this).val()) == ''){
    			bValue = false;
    		}

    		var names = $(this).attr('less');

    		if (bValue && (names == '' || names == undefined)) {
    			bValue = false;
    		}

    		var target = $("form[id="+fid+"] :input[name="+replace_selector(names)+"]");
    		if(bValue && (target.length == 0 || $.trim(target.val()) == '')){
    			bValue = false;
    		}

    		if(bValue && !($.trim($(this).val()) < $.trim(target.val()))){
    			jAlert($(this).attr('title') + ' : '+ target.attr('title') +'보다 작아야 합니다.', function() {
        			$this.focus();
        		});
    			return bValid = false;
    		}


    	}

    	if($(this).hasClass('max')){
    		var bValue = true;
    		var maxValue = $(this).attr('max');
    		if($.trim($(this).val()) == '' || maxValue == undefined
    				|| $.trim(maxValue) == '' || isNaN(Number(maxValue))){
    			bValue = false;
    		}
    		if(bValue && $.trim($(this).val()) > Number(maxValue)){
    			jAlert($(this).attr('title') + ' : '+ maxValue +' 보다 작거나 같아야 합니다.', function() {
        			$this.focus();
        		});
    			return bValid = false;
    		}
    	}

    	if($(this).hasClass('min')){
    		var bValue = true;
    		var minValue = $(this).attr('min');
    		if($.trim($(this).val()) == '' || minValue == undefined
    				|| $.trim(minValue) == '' || isNaN(Number(minValue))){
    			bValue = false;
    		}
    		if(bValue && $.trim($(this).val()) < Number(minValue)){
    			jAlert($(this).attr('title') + ' : '+ minValue +' 보다 크거나 같아야 합니다.', function() {
        			$this.focus();
        		});
    			return bValid = false;
    		}
    	}

    	if($(this).hasClass('greaterValue')){
    		var bValue = true;
    		var minValue = $(this).attr('greaterValue');
    		if($.trim($(this).val()) == '' || minValue == undefined
    				|| $.trim(minValue) == '' || isNaN(Number(minValue))){
    			bValue = false;
    		}
    		if(bValue && $.trim($(this).val()) <= Number(minValue)){
    			jAlert($(this).attr('title') + ' : '+ minValue +' 보다 커야 합니다.', function() {
        			$this.focus();
        		});
    			return bValid = false;
    		}
    	}

	});

	return bValid;
};

$('document').ready(function() {

	$.datepicker.setDefaults({
		showOn: "both",
		//buttonImage: "/user/images/common/calendar.gif",
		//buttonImageOnly: true,
		buttonHtml: "<div class='input-group-btn'><button class='btn btn-sm'><li class='fa fa-calendar'/></button></div>",
		regional: "ko",
		changeMonth: true,
		changeYear: true,
		dateFormat: "yy-mm-dd",
		showButtonPanel:true});

	$('.onlyNumber').on({
		'focus' : function(){
			$(this).css("ime-mode", "disabled");
			$(this).numeric({
				message : $(this).attr("title") + " : 숫자만 입력하세요."
			});
		}
	});

	$('.onlyInteger').on({
		'focus' : function(){
			$(this).css("ime-mode", "disabled");
			$(this).numeric({
				message : $(this).attr("title") + " : 정수형만 입력하세요."
			});
		}
	});

	$(".max").on({
		'keyup' : function() {

			if( $(this).attr("type") == "number" ) {

				if( parseInt($(this).val()) > parseInt($(this).attr("max")) ) {

					if( !$(this).hasClass("tooltipstered")) {
						$(this).tooltipster({
		        			content: $(this).attr("title") + " : 최대 " + $(this).attr("max") + "까지 입력가능합니다.",
		        			position : "top-left"
		       			});
					} else {
						$(this).tooltipster("content", $(this).attr("title") + " : 최대 " + $(this).attr("max") + "까지 입력가능합니다.");
		        	}

					$(this).tooltipster("show");

					$(this).val($(this).attr("max"));
				}
			}
		},
		'keydown' : function(e) {
			var keycode = e.keyCode;

			if( ($(this).val().length == $(this).attr("maxlength")) &&
					( (keycode >= 48 && keycode <= 57) || (keycode >= 96 && keycode <= 105) )
			) {
				return false;
			}
		}
	});

	$('.onlySignInteger').on({
		'focus' : function() {
			$(this).css("ime-mode", "disabled");
			$(this).numeric({
				message : $(this).attr("title") + " : 기호형 정수만 입력하세요.",
				allow:'-'
			});
		}
	});

	$('.onlyIntegerNF').on({
		'focus' : function() {
			$(this).css("ime-mode", "disabled");
			$(this).numeric({
				message : $(this).attr("title") + " : 숫자만 입력하세요.",
				allow:','
			});
		},
		'keyup' : function(event) {
			$(this).toPrice();
		}
	});

	$('.onlySignIntegerNF').on({
		'focus' : function() {
			$(this).css("ime-mode", "disabled");
			$(this).numeric({
				message : $(this).attr("title") + " : 기호형 정수만 입력하세요.",
				allow:',-'
			});


		},
		'keyup' : function(event) {
			$(this).toPrice();
		}
	});

	$('.onlyFloat').on({
		'focus' : function() {
			$(this).css("ime-mode", "disabled");
			$(this).numeric({
				message : $(this).attr("title") + " : 실수형만 입력하세요.",
				allow:'.'
			});
		}
	});

	$('.onlySignFloat').on({
		'focus' : function() {
			$(this).css("ime-mode", "disabled");
			$(this).numeric({
				message : $(this).attr("title") + " : 기호 실수형만 입력하세요.",
				allow:'.-'
			});
		}
	});

	$('.onlyFloatNF').on({
		'focus' : function() {
			$(this).css("ime-mode", "disabled");
			$(this).numeric({
				message : $(this).attr("title") + " : 기호 실수형만 입력하세요.",
				allow:'.,'
			});
		},
		'keyup' : function(event) {
			$(this).toPriceDot();
		}
	});

	$('.onlySignFloatNF').on({
		'focus' : function() {
			$(this).css("ime-mode", "disabled");
			$(this).numeric({
				message : $(this).attr("title") + " : 기호 실수형만 입력하세요.",
				allow:'.,-'
			});
		},
		'keyup' : function(event) {
			$(this).toPriceDot();
		}
	});

	$('.onlyAlpha').on({
		'focus' : function() {
			$(this).css("ime-mode", "disabled");
			$(this).alpha({
				message : $(this).attr("title") + " : 영문만 입력하세요."
			});
		}
	});

	$('.onlyAlphaNum').on({
		'focus' : function() {
			$(this).css("ime-mode", "disabled");
			$(this).alpha({
				message : $(this).attr("title") + " : 영문과 숫자만 입력하세요.",
				allow:'01234567890'
			});
		}
	});

	$('.onlyAlphaNumDash').on({
		'focus' : function() {
			$(this).css("ime-mode", "disabled");
			$(this).alpha({
				message : $(this).attr("title") + " : 영문과 숫자 또는 '-'만 입력하세요.",
				allow:'01234567890-'
			});
		}
	});

	$('.onlyNumDash').on({
		'focus' : function() {
			$(this).css("ime-mode", "disabled");
			$(this).numeric({
				message : $(this).attr("title") + " : 숫자 또는 '-'만 입력하세요.",
				allow:'01234567890-'
			});
		}
	});

	$('.onlyDate').on({
		'focus' : function() {
			$(this).css("ime-mode", "disabled");
			$(this).numeric({
				message : $(this).attr("title") + " : 날짜형만 입력하세요.",
				allow:'-'
			});
		}
	});

	$('.onlyDateTime').on({
		'focus' : function() {
			$(this).css("ime-mode", "disabled");
			$(this).numeric({
				message : $(this).attr("title") + " : 날짜시간형만 입력하세요.",
				allow:'-'
			});
		}
	});

	$('.onlyPhone').on({
		'focus' : function() {
			$(this).css("ime-mode", "disabled");
			$(this).numeric({
				message : $(this).attr("title") + " : 전화번호 형식만 입력하세요.",
				allow:'-'
			});
		}
	});

	$('.onlyIp').on({
		'focus' : function() {
			$(this).css("ime-mode", "disabled");
			$(this).numeric({
				message : $(this).attr("title") + " : IP 형식만 입력하세요.",
				allow:'.'
			});
		}
	});

	$('.onlyEmail').on({
		'focus' : function() {
			$(this).css("ime-mode", "disabled");
			$(this).alpha({
				message : $(this).attr("title") + " : 이메일 형식만 입력하세요.",
				allow:'01234567890-_@.'
			});
		}
	});

	$('.checkByte').on({
		'keyup' : function(event) {
			$.check($(this),null,$(this).attr('maxlength'),false);
		}
	});

	//##########################################################
	// live 연결 방법을 못찾았음 - 추후 연구
	$('.datepicker').datepicker();

	$('img.ui-datepicker-trigger').attr('align', 'absmiddle'); // css 문제가 있는경우 일부 위치 조절 :)
	//##########################################################

	/**
	 * 폼에서 Enter 눌렀을 때
	 * Get은 submit, POST는 다음 input으로 이동 처리
	 */
	$("form").unbind("keydown").keydown(function(event) {

		if( event.keyCode == 13 ) {

//			event.preventDefault();

			if( $(this).attr("method") == "post" ) {

				var inputs = $(this).find(":input:not(:hidden), select, textarea");
				var idx = inputs.index($(this).find(":focus"));

				if( inputs.eq(idx)[0].tagName == "TEXTAREA" )
					return true;


				if( inputs.size() <= (idx+1) ) {
					inputs[0].focus();
				} else {
					inputs[(idx+1)].focus();
				}

			} else {
				var pathname = $(location).attr("pathname");
				$(this).attr("action",pathname);
				$(this).submit();
			}

			return false;
		} else {
			return true;
		}
	});

});

fn_id_validation = function(f) {

	var fid = f;
	var bValid = true;

	$("[id="+fid+"] :input").each(function(){

		if ($(this).hasClass("onlyInteger")) {
			if (!fn_only_integer($(this).val())) {
    			jAlert($(this).attr('title') + ' : 정수만 입력 가능합니다.', function() {
        			$this.focus();
        		});
            	return bValid = false;
        	}
		}

		if ($(this).hasClass("onlySignInteger")) {
        	if (!fn_only_sign_integer($(this).val())) {
    			jAlert($(this).attr('title') + ' : (음/양)정수만 입력 가능합니다.', function() {
        			$this.focus();
        		});
    			return bValid = false;
        	}
    	}

    	if ($(this).hasClass("onlyFloat")) {
        	if (!fn_only_float($(this).val())) {
    			jAlert($(this).attr('title') + ' : 실수만 입력 가능합니다.', function() {
        			$this.focus();
        		});
    			return bValid = false;
        	}
    	}

    	if ($(this).hasClass("onlySignFloat")) {
        	if (!fn_only_sign_float($(this).val())) {
    			jAlert($(this).attr('title') + ' : (음/양)실수만 입력 가능합니다.', function() {
        			$this.focus();
        		});
    			return bValid = false;
        	}
    	}

    	if ($(this).hasClass("onlyIntegerNF")) {
        	if (!fn_only_integer_nf($(this).val())) {
    			jAlert($(this).attr('title') + ' : 정수형 형식이 올바르지 않습니다.', function() {
        			$this.focus();
        		});
    			return bValid = false;
        	}
    	}

    	if ($(this).hasClass("onlySignIntegerNF")) {
        	if (!fn_only_integer_nf($(this).val())) {
    			jAlert($(this).attr('title') + ' : 정수형 형식이 올바르지 않습니다.', function() {
        			$this.focus();
        		});
            	return bValid = false;
        	}
    	}

    	if ($(this).hasClass("onlyFloatNF")) {
        	if (!fn_only_float_nf($(this).val())) {
    			jAlert($(this).attr('title') + ' : 실수형 형식이 올바르지 않습니다.', function() {
        			$this.focus();
        		});
            	return bValid = false;
        	}
    	}

    	if ($(this).hasClass("onlySignFloatNF")) {
        	if (!fn_only_sign_float_nf($(this).val())) {
    			jAlert($(this).attr('title') + ' : 실수형 형식이 올바르지 않습니다.', function() {
        			$this.focus();
        		});
            	return bValid = false;
        	}
    	}

    	if ($(this).hasClass("onlyNumber")) {
        	if (!fn_only_number($(this).val())) {
    			jAlert($(this).attr('title') + ' : 숫자만 입력 가능합니다.', function() {
        			$this.focus();
        		});
            	return bValid = false;
        	}
    	}

    	if ($(this).hasClass("onlyAlpha")) {
        	if (!fn_only_alpha($(this).val())) {
    			jAlert($(this).attr('title') + ' : 영문자만 입력 가능합니다.', function() {
        			$this.focus();
        		});
            	return bValid = false;
        	}
    	}

    	if ($(this).hasClass("onlyAlphaNum")) {
        	if (!fn_only_alpha_num($(this).val())) {
    			jAlert($(this).attr('title') + ' : 영문자와 숫자만 입력 가능합니다.', function() {
        			$this.focus();
        		});
            	return bValid = false;
        	}
    	}

    	if ($(this).hasClass("onlyAlphaNumDash")) {
        	if (!fn_only_alpha_num_dash($(this).val())) {
    			jAlert($(this).attr('title') + ' : 영문자와 숫자, -만 입력 가능합니다.', function() {
        			$this.focus();
        		});
            	return bValid = false;
        	}
    	}

    	if ($(this).hasClass("onlyDate")) {
        	if (!fn_only_date($(this).val())) {
    			jAlert($(this).attr('title') + ' : 날짜 형식을 YYYY-MM-DD 형식으로 입력하세요.', function() {
        			$this.focus();
        		});
            	return bValid = false;
        	}
    	}

    	if ($(this).hasClass("onlyDateTime")) {
        	if (!fn_only_date_time($(this).val())) {
        		jAlert($(this).attr('title') + ' : 날짜 형식을 YYYY-MM-DD HH:mm 형식으로 입력하세요.', function() {
        			$this.focus();
        		});
            	return bValid = false;
        	}
    	}

    	if ($(this).hasClass("onlyPhone")) {
        	if (!fn_only_phone($(this).val())) {
    			jAlert($(this).attr('title') + ' : XXX-XXXX-XXXX 형식으로 입력하세요.', function() {
        			$this.focus();
        		});
            	return bValid = false;
        	}
    	}

    	if ($(this).hasClass("onlyIp")) {
        	if (!fn_only_ip($(this).val())) {
    			jAlert($(this).attr('title') + ' : 0.0.0.0 ~ 255.255.255.255 범위 안에서 입력하세요.', function() {
        			$this.focus();
        		});
            	return bValid = false;
        	}
    	}

    	if ($(this).hasClass("onlyEmail")) {
        	if (!fn_only_email($(this).val())) {
    			jAlert($(this).attr('title') + ' : 올바른 이메일 형식을 입력하세요.', function() {
        			$this.focus();
        		});
            	return bValid = false;
        	}
    	}

    	// 최소값, 최대값 체크

    	// 필수 입력 체크
    	if ($(this).hasClass("essential")) {
    		if ($(this)[0].type == 'radio') {
    			var eln = replace_selector($(this)[0].name);
    			if ($("[id="+fid+"] :radio[name="+eln+"]:checked").length == 0) {
    				jAlert($(this).attr('title') + ' : 필수항목입니다.', function() {
	        			$this.focus();
	        		});
    				return bValid = false;
    			}
    		}
    		else if ($(this)[0].type == 'checkbox') {
    			if (!$(this)[0].checked) {
    				jAlert($(this).attr('title') + ' : 필수항목입니다.', function() {
	        			$this.focus();
	        		});
    				return bValid = false;
    			}
    		}
    		else {
	        	if ($.trim($(this).val()) == '') {
	    			jAlert($(this).attr('title') + ' : 필수 항목입니다.', function() {
	        			$this.focus();
	        		});
	    			return bValid = false;
	        	}
    		}
    	}

    	// 조건에 따른 필수 입력 체크 (아이디로 체크)
    	if ($(this).hasClass("essentialBy")) {
    		var names = $(this).attr('essentialBy');

    		if (names == '' || names == undefined) {
    			return bValid = true;
    		}

    		var byNames = names.split(',');

    		var bValue = false;
    		for (var essLoop=0; essLoop < byNames.length; essLoop++) {

    			byName = replace_selector($.trim(byNames[essLoop]));
    			if (byName == '') continue;

	    		var el2 = $("[id="+fid+"] :input[name="+byName+"]");

	    		if ($(el2)[0].type == 'radio') {
	    			var el2name = $(el2)[0].name;
	    			if ($("[id="+fid+"] :radio[name="+replace_selector(el2name)+"]:checked").length > 0) {
	    				bValue = true;
	    				break;
	    			}
	    		}
	    		else if ($(el2)[0].type == 'checkbox') {
	    			var el2name = $(el2)[0].name;
	    			if ($("[id="+fid+"] :checkbox[name="+replace_selector(el2name)+"]:checked").length > 0) {
	    				bValue = true;
	    				break;
	    			}
	    		}
	    		else {
	    			if ($.trim($(el2).val()) != '') {
	    				bValue = true;
	    				break;
	    			}
	    		}
    		}

    		if (bValue) {
    			if ($(this)[0].type == 'radio') {
    				var eln = $(this)[0].name;
    				if ($("[id="+fid+"] :radio[name="+eln+"]:checked").length == 0) {
    					jAlert($(this).attr('title') + ' : 필수항목입니다.', function() {
    	        			$this.focus();
    	        		});
    					return bValid = false;
    				}
    			}
    			else if ($(this)[0].type == 'checkbox') {
    				var eln = $(this)[0].name;
    				if ($("[id="+fid+"] :checkbox[name="+eln+"]:checked").length == 0) {
    					jAlert($(this).attr('title') + ' : 필수항목입니다.', function() {
    	        			$this.focus();
    	        		});
    					return bValid = false;
    				}
    			}
    			else {
    				if ($.trim($(this).val()) == '') {
    					jAlert($(this).attr('title') + ' : 필수 항목입니다.', function() {
    	        			$this.focus();
    	        		});
    					return bValid = false;
    				}
    			}
    		}
    	}

    	// Byte 체크
    	if($(this).hasClass('checkByte')){
    		if (!fn_check_byte($(this).val(),$(this).attr('maxlength'))) {
    			jAlert($(this).attr('title') + ' : '+$(this).attr('maxlength')+'byte를 넘을수 없습니다', function() {
        			$this.focus();
        		});
            	return bValid = false;
        	}
    	}

    	if($(this).hasClass('greaterEqual')){

    		var bValue = true;

    		if($.trim($(this).val()) == ''){
    			bValue = false;
    		}

    		var names = $(this).attr('greaterEqual');

    		if (bValue && (names == '' || names == undefined)) {
    			bValue = false;
    		}

    		var target = $("[id="+fid+"] :input[name="+replace_selector(names)+"]");
    		if(bValue && (target.length == 0 || $.trim(target.val()) == '')){
    			bValue = false;
    		}

    		if(bValue && !($.trim($(this).val()) >= $.trim(target.val()))){
    			jAlert($(this).attr('title') + ' : '+ target.attr('title') +'보다 크거나 같아야 합니다.', function() {
        			$this.focus();
        		});
    			return bValid = false;
    		}


    	}

    	if($(this).hasClass('lessEqual')){

    		var bValue = true;

    		if($.trim($(this).val()) == ''){
    			bValue = false;
    		}

    		var names = $(this).attr('lessEqual');

    		if (bValue && (names == '' || names == undefined)) {
    			bValue = false;
    		}

    		var target = $("[id="+fid+"] :input[name="+replace_selector(names)+"]");
    		if(bValue && (target.length == 0 || $.trim(target.val()) == '')){
    			bValue = false;
    		}

    		if(bValue && !($.trim($(this).val()) <= $.trim(target.val()))){
    			jAlert($(this).attr('title') + ' : '+ target.attr('title') +'보다 작거나 같아야 합니다.', function() {
        			$this.focus();
        		});
    			return bValid = false;
    		}


    	}

    	if($(this).hasClass('greater')){

    		var bValue = true;

    		if($.trim($(this).val()) == ''){
    			bValue = false;
    		}

    		var names = $(this).attr('greater');

    		if (bValue && (names == '' || names == undefined)) {
    			bValue = false;
    		}

    		var target = $("[id="+fid+"] :input[name="+replace_selector(names)+"]");

    		if(bValue && (target.length == 0 || $.trim(target.val()) == '')){
    			bValue = false;
    		}

    		if(bValue && !($.trim($(this).val()) > $.trim(target.val()))){
    			jAlert($(this).attr('title') + ' : '+ target.attr('title') +'보다 커야 합니다.', function() {
        			$this.focus();
        		});
    			return bValid = false;
    		}


    	}

    	if($(this).hasClass('less')){
    		var bValue = true;

    		if($.trim($(this).val()) == ''){
    			bValue = false;
    		}

    		var names = $(this).attr('less');

    		if (bValue && (names == '' || names == undefined)) {
    			bValue = false;
    		}

    		var target = $("[id="+fid+"] :input[name="+replace_selector(names)+"]");
    		if(bValue && (target.length == 0 || $.trim(target.val()) == '')){
    			bValue = false;
    		}

    		if(bValue && !($.trim($(this).val()) < $.trim(target.val()))){
    			jAlert($(this).attr('title') + ' : '+ target.attr('title') +'보다 작아야 합니다.', function() {
        			$this.focus();
        		});
    			return bValid = false;
    		}


    	}

    	if($(this).hasClass('max')){
    		var bValue = true;
    		var maxValue = $(this).attr('max');
    		if($.trim($(this).val()) == '' || maxValue == undefined
    				|| $.trim(maxValue) == '' || isNaN(Number(maxValue))){
    			bValue = false;
    		}
    		if(bValue && $.trim($(this).val()) > Number(maxValue)){
    			jAlert($(this).attr('title') + ' : '+ maxValue +' 보다 작거나 같아야 합니다.', function() {
        			$this.focus();
        		});
    			return bValid = false;
    		}
    	}

    	if($(this).hasClass('min')){
    		var bValue = true;
    		var minValue = $(this).attr('min');
    		if($.trim($(this).val()) == '' || minValue == undefined
    				|| $.trim(minValue) == '' || isNaN(Number(minValue))){
    			bValue = false;
    		}
    		if(bValue && $.trim($(this).val()) < Number(minValue)){
    			jAlert($(this).attr('title') + ' : '+ minValue +' 보다 크거나 같아야 합니다.', function() {
        			$this.focus();
        		});
    			return bValid = false;
    		}
    	}

    	if($(this).hasClass('greaterValue')){
    		var bValue = true;
    		var minValue = $(this).attr('greaterValue');
    		if($.trim($(this).val()) == '' || minValue == undefined
    				|| $.trim(minValue) == '' || isNaN(Number(minValue))){
    			bValue = false;
    		}
    		if(bValue && $.trim($(this).val()) <= Number(minValue)){
    			jAlert($(this).attr('title') + ' : '+ minValue +' 보다 커야 합니다.', function() {
        			$this.focus();
        		});
    			return bValid = false;
    		}
    	}

	});

	return bValid;
};


//기본값과 같은지 확인
function fn_form_is_same_default_value(fid){

	var bSame = true;

	$("form[id="+fid+"] :input:not([type='hidden'])").each(function(){
		if(this.type == 'radio' || this.type == 'checkbox'){
			if(this.defaultChecked != this.checked){
				bSame = false;
				return false;
			}
		}
		else{
			if(this.defaultValue != $(this).val()){
				bSame = false;
				return false;
			}
		}
	});

	if(bSame){
		jAlert("변경된 정보가 없습니다.");
	}

	return bSame;

};


function fn_maxlengthCheck(e, obj){
	var keys = [8, 9, 13, 34, 35, 36, 37, 38, 39, 40, 45, 46];
	if(obj.value.length < obj.maxLength){
		return;
	}
	if($.inArray(e.which, keys) != -1){
		return;
	}
	if(fn_isTextSelected()){
		return;
	}
	e.preventDefault();
}

function fn_isTextSelected(){
	var text ="";
	var activeEl = document.activeElement;
	var activeElTagName = activeEl ? activeEl.tagName.toLowerCase() : null;
	try {
		if ((activeElTagName == 'textarea' || activeElTagName == 'input') && /^(?:text|number|search|password|tel|url)$/i.test(activeEl.type) && ('selectionStart' in activeEl && typeof activeEl.selectionStart == "number")){
			text = activeEl.value.slice(activeEl.selectionStart, activeEl.selectionEnd);
		}
	} catch(e){
	}
	if(text.length == 0 && window.getSelection){
		text = window.getSelection().toString();
	}
	if(text.length == 0 && document.getSelection){
		text = document.getSelection().toString();
	}
	if (text.length == 0 && document.selection && document.selection.type != "Control") {
		text = document.selection.createRange().text;
	}

	return (text.length > 0);
}