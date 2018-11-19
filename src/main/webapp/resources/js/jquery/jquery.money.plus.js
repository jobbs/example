(function($) {
	$.fn.toPrice = function(cipher) {
		var strb, len, revslice, minus, headnum, dotnum;
		minus = '';
		dotnum = '';

		strb = $(this).val().toString();

		if (strb.charAt(0) == '-')
			minus = strb.charAt(0);

		strb = strb.replace(/[^.0-9]/, '');
		// alert(strb);
		/*
		 * if (strb.indexOf('.')>=0) { headnum = strb.substr(0,
		 * strb.indexOf('.')); dotnum = strb.substr(strb.indexOf('.')); } else {
		 * headnum = strb; }
		 */
		// alert(dotnum);
		headnum = strb;

		headnum = headnum.replace(/[^0-9]/g, '');

		headnum = parseInt(headnum, 10);
		if (isNaN(headnum)) {
			return $(this).val(minus + '');
		}
		headnum = headnum.toString();
		len = headnum.length;

		if (len < 4) {
			return $(this).val(minus + headnum + dotnum);
		}
		if (cipher == undefined || !isNumeric(cipher))
			cipher = 3;

		count = len / cipher;
		slice = new Array();

		for ( var i = 0; i < count; ++i) {
			if (i * cipher >= len)
				break;
			slice[i] = headnum.slice((i + 1) * -cipher, len - (i * cipher));
		}

		revslice = slice.reverse();
		return $(this).val(minus + revslice.join(',') + dotnum);
	}

	$.fn.toPriceDot = function(cipher) {
		var strb, len, revslice, minus, headnum, dotnum;
		minus = '';
		dotnum = '';

		strb = $(this).val().toString();

		if (strb.charAt(0) == '-')
			minus = strb.charAt(0);

		strb = strb.replace(/[^.0-9]/, '');
		// alert(strb);

		if (strb.indexOf('.') >= 0) {
			headnum = strb.substr(0, strb.indexOf('.'));
			dotnum = strb.substr(strb.indexOf('.'));
		} else {
			headnum = strb;
		}
		// alert(dotnum);

		headnum = headnum.replace(/[^.0-9]/g, '');
		if (dotnum != '')
			$dotnum = '.' + dotnum.replace(/[^0-9]/, '');

		headnum = parseInt(headnum, 10);
		if (isNaN(headnum)) {
			return $(this).val(minus + '');
		}
		headnum = headnum.toString();
		len = headnum.length;

		if (len < 4) {
			return $(this).val(minus + headnum + dotnum);
		}
		if (cipher == undefined || !isNumeric(cipher))
			cipher = 3;

		count = len / cipher;
		slice = new Array();

		for ( var i = 0; i < count; ++i) {
			if (i * cipher >= len)
				break;
			slice[i] = headnum.slice((i + 1) * -cipher, len - (i * cipher));
		}

		revslice = slice.reverse();
		return $(this).val(minus + revslice.join(',') + dotnum);
	}

	$.fn.getOnlyNumeric = function(data) {
		var chrTmp, strTmp;
		var len, str;

		if (data == undefined) {
			str = $(this).val();
		} else {
			str = data;
		}

		len = str.length;
		strTmp = '';

		for ( var i = 0; i < len; ++i) {
			chrTmp = str.charCodeAt(i);
			if ((chrTmp > 47 || chrTmp <= 31) && chrTmp < 58) {
				strTmp = strTmp + String.fromCharCode(chrTmp);
			}
		}

		if (data == undefined)
			return strTmp;
		else
			return $(this).val(strTmp);
	}

	var isNumeric = function(data) {
		var len, chrTmp;

		len = data.length;
		for ( var i = 0; i < len; ++i) {
			chrTmp = str.charCodeAt(i);
			if ((chrTmp <= 47 && chrTmp > 31) || chrTmp >= 58) {
				return false;
			}
		}

		return true;
	}
})(jQuery);
