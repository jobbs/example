/**
 * 롤정보 조회(단일 선택)
 */
function openRoleSearch() {

	var url = contextPath+'/cmn/component/role/selectRoleListP.do';
	var params = {"searchType" : "S"};
	var args = {key:"SelectRoleSingle", width:740,height:610};
	windowOpen(url, params, args);
}

/**
 * 롤정보 조회(체크박스 선택)
 */
function openRoleMultiSearch() {

	var url = contextPath+'/cmn/component/role/selectRoleListP.do';
	var params = {"searchType" : "M"};
	var args = {key:"SelectRoleMulti", width:740,height:610};
	windowOpen(url, params, args);
}

/**
 * 부처선택(단일선택)
 */
function openInsttSearch(){
	var url = contextPath+'/cmn/component/instt/selectInsttListP.do';
	var params = {"searchType" : "S"};
	var args = {key:"selectInstitution", width:740,height:820};
	windowOpen(url, params, args);
}

/**
 * 부처선택(체크박스선택)
 */
function openInsttMultiSearch(){
	var url = contextPath+'/cmn/component/instt/selectInsttListP.do';
	var params = {"searchType" : "M"};
	var args = {key:"selectInstitutionMulti", width:740,height:820};
	windowOpen(url, params, args);
}

/**
 * 업무정보 조회(단일 선택)
 */
function openJobeSearch() {

	var url = contextPath+'/cmn/component/job/selectJobListP.do';
	var params = {"searchType" : "S"};
	var args = {key:"SelectJobSingle", width:740,height:820};
	windowOpen(url, params, args);
}

/**
 * 업무정보 조회(체크박스 선택)
 */
function openJobMultiSearch() {

	var url = contextPath+'/cmn/component/job/selectJobListP.do';
	var params = {"searchType" : "M"};
	var args = {key:"SelectJobMulti", width:740,height:820};
	windowOpen(url, params, args);
}


/**
 * 로그인한 사용자가 보유한 자원풀선택(단일선택)
 */
function openUserPoolSearch() {
	var url = contextPath+'/cmn/component/pool/selectUserPoolListP.do';
	var params = {"searchType" : "S"};
	var args = {key:"SelectPool", width:740,height:820};
	windowOpen(url, params, args);
}

/**
 * 로그인한 사용자가 보유한 자원풀선택(체크박스)
 */
function openUserPoolMultiSearch() {
	var url = contextPath+'/cmn/component/pool/selectUserPoolListP.do';
	var params = {"searchType" : "M"};
	var args = {key:"SelectPoolMulti", width:740,height:820};
	windowOpen(url, params, args);
}

/**
 * 자원풀선택(전체, 단일선택)
 */
function openPoolSearch() {
	var url = contextPath+'/cmn/component/pool/selectPoolListP.do';
	var params = {"searchType" : "S"};
	var args = {key:"SelectPool", width:740,height:820};
	windowOpen(url, params, args);
}


/**
 * 자원풀선택(전체, 체크박스)
 */
function openPoolMultiSearch() {
	var url = contextPath+'/cmn/component/pool/selectPoolListP.do';
	var params = {"searchType" : "M"};
	var args = {key:"SelectPoolMulti", width:740,height:820};
	windowOpen(url, params, args);
}

/**
 * 사용자선택(전체, 단일선택)
 */
function openUserSearch(params) {
	var searchParams = "";
	if( $.isPlainObject(params) ) {
		searchParams = $.param(params);
	}
	searchParams += "&searchType=S";

	var url = contextPath+'/cmn/component/user/selectUserListP.do';
	var args = {key:"SelectUser", width:740,height:820};
	windowOpen(url, searchParams, args);
}

/**
 * 사용자선택(전체, 체크박스)
 */
function openUserMultiSearch(params) {
	var searchParams = "";
	if( $.isPlainObject(params) ) {
		searchParams = $.param(params);
	}
	searchParams += "&searchType=M";

	var url = contextPath+'/cmn/component/user/selectUserListP.do';
	var args = {key:"SelectUserMulti", width:740,height:820};
	windowOpen(url, params, args);
}

/**
 * 사용자선택(전체, 단일선택)
 */
function openUserList(params) {
	var searchParams = "";
	if( $.isPlainObject(params) ) {
		searchParams = $.param(params);
	}

	var url = contextPath+'/cmn/component/user/selectUserViewListP.do';
	var args = {key:"SelectUserList", width:740,height:820};
	windowOpen(url, searchParams, args);
}

/**
 * 존검색(Tree 형태)
 */
function openZoneTreeSearch() {
	var url = contextPath+'/cmn/component/zone/selectZoneListP.do';
	var args = {key:"SelectZone", width:400,height:600};
	windowOpen(url, "", args);
}


/**
 * 운영요청통계 화면 팝업
 */
function openOprStatList(params) {
	var searchParams = "";
	if( $.isPlainObject(params) ) {
		searchParams = $.param(params);
	}

	var url = contextPath+'/dsb/stts/etc/oprStat/selectOprStatListP.do';
	var args = {key:"SelectOprStatList", width:740,height:820};
	windowOpen(url, searchParams, args);
}
