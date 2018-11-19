/**
 *
 */
function selectboxDy(parentGrpCd, source, target, isWhole, callback) {

	var url = contextPath+'/api/cmn/component/selectboxMngrList.do';
	var val = $(source).val();
	var grpCd = parentGrpCd;

	if( val != "" ) {
		$.get(url, { "parentGrpCd" : grpCd, "parentCd" : val, "isWhole" : isWhole}, function(result) {
			if( result.success) {
				var datas = result.data;

				//remove option
				$("#" + target + " > option").remove();

				if( datas != null ) {
					//create Option
					for(var i = 0; i < datas.length; i++ ) {
						$("#" + target).append("<option value='" + datas[i].cd + "'>" + datas[i].cdNm + "</option>");
					}
				}

				$("#" + target).change();


				if( callback != undefined && typeof callback === "function") {
					callback();
				}
			}
		}, "json");
	}else{
		$("#" + target + " > option:eq(0)").nextAll().remove();
		$("#" + target).change();

	}

}

/**
*
*/
function selectboxTwoDy(parentGrpCd, source, target, target2, isWhole, callback) {

	var url = contextPath+'/api/cmn/component/selectboxMngrList.do';
	var val = $(source).val();
	var grpCd = parentGrpCd;

	if( val != "" ) {
		$.get(url, { "parentGrpCd" : grpCd, "parentCd" : val, "isWhole" : isWhole}, function(result) {
			if( result.success) {
				var datas = result.data;

				//remove option
				$("#" + target + " > option").remove();
				$("#" + target2 + " > option").remove();

				if( datas != null ) {
					//create Option
					for(var i = 0; i < datas.length; i++ ) {
						$("#" + target).append("<option value='" + datas[i].cd + "'>" + datas[i].cdNm + "</option>");
						$("#" + target2).append("<option value='" + datas[i].cd + "'>" + datas[i].cdNm + "</option>");
					}
				}

				$("#" + target).change();
				$("#" + target2).change();

				if( callback != undefined && typeof callback === "function") {
					callback();
				}
			}
		}, "json");
	}else{
		$("#" + target + " > option:eq(0)").nextAll().remove();
		$("#" + target).change();
		$("#" + target2 + " > option:eq(0)").nextAll().remove();
		$("#" + target2).change();

	}

}

/**
*
*/
function selectboxThreeDy(parentGrpCd, source, target, target2, target3, isWhole, callback) {

	var url = contextPath+'/api/cmn/component/selectboxMngrList.do';
	var val = $(source).val();
	var grpCd = parentGrpCd;

	if( val != "" ) {
		$.get(url, { "parentGrpCd" : grpCd, "parentCd" : val, "isWhole" : isWhole}, function(result) {
			if( result.success) {
				var datas = result.data;

				//remove option
				$("#" + target + " > option").remove();
				$("#" + target2 + " > option").remove();
				$("#" + target3 + " > option").remove();

				if( datas != null ) {
					//create Option
					for(var i = 0; i < datas.length; i++ ) {
						$("#" + target).append("<option value='" + datas[i].cd + "'>" + datas[i].cdNm + "</option>");
						$("#" + target2).append("<option value='" + datas[i].cd + "'>" + datas[i].cdNm + "</option>");
						$("#" + target3).append("<option value='" + datas[i].cd + "'>" + datas[i].cdNm + "</option>");
					}
				}

				$("#" + target).change();
				$("#" + target2).change();
				$("#" + target3).change();

				if( callback != undefined && typeof callback === "function") {
					callback();
				}
			}
		}, "json");
	}else{
		$("#" + target + " > option:eq(0)").nextAll().remove();
		$("#" + target).change();
		$("#" + target2 + " > option:eq(0)").nextAll().remove();
		$("#" + target2).change();
		$("#" + target3 + " > option:eq(0)").nextAll().remove();
		$("#" + target3).change();
	}

}