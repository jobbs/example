/**
 *
 */
function selectZoneDy(source, target, params, isWhole, callback) {

	var url = contextPath+'/cmn/component/zone/selectZoneList.do';
	var val = $(source).val();

	var searchParams = { "searchRegionId" : val };
	if( params != null ) {
		$.extend(true, searchParams, params);
	}

	if( val != "" ) {
		$.get(url, searchParams, function(result) {
			if( result.success) {
				var datas = result.data;

				//remove option
				if( !isWhole||isWhole ) {
					$("#" + target + " > option:eq(0)").nextAll().remove();
				} else {
					$("#" + target + " > option").remove();
				}

				if( datas != null ) {
					//create Option
					for(var i = 0; i < datas.length; i++ ) {
						$("#" + target).append("<option value='" + datas[i].zoneId + "'>" + datas[i].zoneNm + "</option>");
					}
				}

				$("#" + target).change();

				if( callback != undefined && typeof callback === "function") {
					callback();
				}
			}
		}, "json");
	} else {

		if( !isWhole || isWhole ) {
			$("#" + target + " > option:eq(0)").nextAll().remove();
		} else {
			$("#" + target + " > option").remove();
		}

		$("#" + target).change();

		if( callback != undefined && typeof callback === "function") {
			callback();
		}
	}

}

function selectNetDy(source, target, params, isWhole, callback) {

	var url = contextPath+'/cmn/component/zone/selectNetList.do';
	var val = $(source).val();

	var searchParams = { "zoneId" : val };
	if( params != null ) {
		$.extend(true, searchParams, params);
	}

	if( val != "" ) {
		$.get(url, searchParams, function(result) {
			if( result.success) {
				var datas = result.data;
				//remove option
				if( !isWhole||isWhole ) {
					$("#" + target + " > option:eq(0)").nextAll().remove();
				} else {
					$("#" + target + " > option").remove();
				}

				if( datas != null ) {
					//create Option
					for(var i = 0; i < datas.length; i++ ) {
						$("#" + target).append("<option value='" + datas[i].netId + "'>" + datas[i].netNm + "</option>");
					}
				}

				$("#" + target).change();

				if( callback != undefined && typeof callback === "function") {
					callback();
				}
			}


		}, "json");
	} else {
		if( !isWhole||isWhole ) {
			$("#" + target + " > option:eq(0)").nextAll().remove();
		} else {
			$("#" + target + " > option").remove();
		}

		$("#" + target).change();

		if( callback != undefined && typeof callback === "function") {
			callback();
		}
	}
}

/**
 * 망 ID에 의한 자원풀 선택
 */
function selectPoolDy(source, regionObj, zoneObj, target, params, isWhole, callback) {

	var url = contextPath+'/cmn/component/pool/selectPoolList.do';
	var netId = $(source).val();
	var regionId = $("#" + regionObj).val();
	var zoneId = $("#" + zoneObj).val();

	var searchParams = { "searchRegionId" : regionId, "searchZoneId" : zoneId, "searchNetId" : netId };
	if( params != null ) {
		$.extend(true, searchParams, params);
	}

	if( netId != "" ) {
		$.get(url, searchParams, function(result) {
			if( result.success) {
				var datas = result.data;

				//remove option
				if( !isWhole||isWhole ) {
					$("#" + target + " > option:eq(0)").nextAll().remove();
				} else {
					$("#" + target + " > option").remove();
				}
				if( datas != null ) {
					//create Option
					for(var i = 0; i < datas.length; i++ ) {
						$("#" + target).append("<option value='" + datas[i].rsrcPoolId + "'>" + datas[i].rsrcPoolNm + "</option>");
					}
				}

				$("#" + target).change();

				if( callback != undefined && typeof callback === "function") {
					callback();
				}
			}
		}, "json");
	} else {
		//remove option
		if( !isWhole||isWhole ) {
			$("#" + target + " > option:eq(0)").nextAll().remove();
		} else {
			$("#" + target + " > option").remove();
		}

		$("#" + target).change();

		if( callback != undefined && typeof callback === "function") {
			callback();
		}

	}
}

/**
 *
 */
function selectClusterDy(source, target, isWhole, callback) {

	var url = contextPath+'/cmn/component/clstr/selectClstrList.do';
	var poolId = $(source).val();

	if( poolId != "" ) {
		$.get(url, { "searchRsrcPoolId" : poolId }, function(result) {
			if( result.success) {
				var datas = result.data;

				//remove option
				if( !isWhole||isWhole ) {
					$("#" + target + " > option:eq(0)").nextAll().remove();
				} else {
					$("#" + target + " > option").remove();
				}

				if( datas != null ) {
					//create Option
					for(var i = 0; i < datas.length; i++ ) {
						$("#" + target).append("<option value='" + datas[i].clstrSeq + "'>" + datas[i].clstrNm + "</option>");
					}
				}

				$("#" + target).change();

				if( callback != undefined && typeof callback === "function") {
					callback();
				}
			}
		}, "json");

	} else {
		//remove option
		if( !isWhole||isWhole ) {
			$("#" + target + " > option:eq(0)").nextAll().remove();
		} else {
			$("#" + target + " > option").remove();
		}

		$("#" + target).change();

		if( callback != undefined && typeof callback === "function") {
			callback();
		}
	}
}

/**
 *
 * @param regionObj
 * @param zoneObj
 * @param netObj
 * @param target
 * @param params
 * @param isWhole
 */
function selectZoneByNetClCd(regionObj, zoneObj, netObj, target, params, isWhole) {

	var url = contextPath+'/cmn/component/zone/selectZoneList.do';
	var val = $("#" + regionObj).val();

	var searchParams = { "searchRegionId" : val };
	if( params != null ) {
		$.extend(true, searchParams, params);
	}

	if( val != "" ) {
		$.get(url, searchParams, function(result) {
			if( result.success) {
				var datas = result.data;

				//remove option
				if( !isWhole||isWhole ) {
					$("#" + zoneObj + " > option:eq(0)").nextAll().remove();
				} else {
					$("#" + zoneObj + " > option").remove();
				}

				if( datas != null ) {
					//create Option
					for(var i = 0; i < datas.length; i++ ) {
						$("#" + zoneObj).append("<option value='" + datas[i].zoneId + "'>" + datas[i].zoneNm + "</option>");
					}
				}

				$("#" + zoneObj).change();

				selectPoolByNetClCd(regionObj, zoneObj, netObj, target, params, isWhole);

			}
		}, "json");
	} else {

		if( !isWhole || isWhole ) {
			$("#" + zoneObj + " > option:eq(0)").nextAll().remove();
		} else {
			$("#" + zoneObj + " > option").remove();
		}

		$("#" + target).change();

		selectPoolByNetClCd(regionObj, zoneObj, netObj, target, params, isWhole);
	}

}

/**
* 망 구분코드에 의한 자원풀 선택
*/
function selectPoolByNetClCd(regionObj, zoneObj, netObj, target, params, isWhole, callback) {

	var url = contextPath+'/cmn/component/pool/selectPoolList.do';
	var netClCd = $("#" + netObj).val();
	var regionId = $("#" + regionObj).val();
	var zoneId = $("#" + zoneObj).val();

	var searchParams = { "searchRegionId" : regionId, "searchZoneId" : zoneId, "searchNetClCd" : netClCd };
	if( params != null ) {
		if(params.netVmSltAt != null){
			if($("#" + params.netVmSltAt).prop("checked")){
				params.netVmSltAt=true;
				params.searchPoolTypeCd="CN";
				console.log(params.searchPoolTypeCd);
			}else{
				params.netVmSltAt=false;
				params.searchPoolTypeCd="01";
			}
		}
		console.log(params.searchPoolTypeCd);
		$.extend(true, searchParams, params);
	}

	if( netClCd != "" && regionId != "" && zoneId != "" ) {
		$.get(url, searchParams, function(result) {

			console.log( result );
			if( result.success) {
				var datas = result.data;

				//remove option
				if( !isWhole||isWhole ) {
					$("#" + target + " > option:eq(0)").nextAll().remove();
				} else {
					$("#" + target + " > option").remove();
				}
				if( datas != null ) {
					//create Option
					for(var i = 0; i < datas.length; i++ ) {
						$("#" + target).append("<option value='" + datas[i].rsrcPoolId + "'>" + datas[i].rsrcPoolNm + "</option>");
					}
				}

				$("#" + target).change();

				if( callback != undefined && typeof callback === "function") {
					callback();
				}
			}
		}, "json");
	} else {
		//remove option
		if( !isWhole||isWhole ) {
			$("#" + target + " > option:eq(0)").nextAll().remove();
		} else {
			$("#" + target + " > option").remove();
		}

		$("#" + target).change();

		if( callback != undefined && typeof callback === "function") {
			callback();
		}

	}
}
