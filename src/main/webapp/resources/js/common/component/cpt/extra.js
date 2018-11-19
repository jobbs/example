/**
 * 요청 진행상황 목록을 확인한다.
*/
function doExtraSelectRsrcReqList(stateCd, callback) {

	try {

		var url = contextPath+'/cmn/component/cpt/rsrcreq/selectRsrcReqList.do';

		var params = null;
		if( stateCd ) {
			params = {"rsrcReqPrcssStatCd" : stateCd};
		} else {
			params = {"mainYn" : "Y" };
		}

		$.get(url, params, function(result) {

			var datas = null;
			if( result.success ) {
				datas = result.data;
			}
			if( callback != undefined )
				callback(datas)
		});
	} catch( err ) {
		console.log( "Extra SelectRsrcReqList ERROR : " + err);
	}

}

/**
 * 이벤트현황 목록을 확인한다.
*/
function doExtraSelectEvntStteList(callback) {

	try {
		var url = contextPath+'/cmn/component/cpt/evntstte/selectEvntStteList.do';

		$.get(url, function(result) {

			var datas = null;
			if( result.success ) {
				datas = result.data;
			}
			if( callback != undefined )
				callback(datas)
		});
	} catch( err ) {
		console.log( "Extra SelectEvntStteList ERROR : " + err);
	}
}

function doExtraSelectComStte(callback) {

	try {
		var url = contextPath+'/cmn/component/cpt/comstts/selectComSttsByUser.do';

		$.get(url, function(result) {

			var datas = null;
			if( result.success ) {
				datas = result.data;
			}
			if( callback != undefined )
				callback(datas)
		});
	} catch( err ) {
		console.log( "Extra SelectComStte ERROR : " + err);
	}

}