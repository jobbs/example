/**
 *
 */
var EntityUser = function() {
	this.userId;
	this.userNm;
	this.institutionId;
	this.institutionNm;
	this.ofcpsId;
	this.ofcpsNm;
	this.telno;
	this.mobile;
	this.email;
};

var EntityUserRole = function() {
	this.roleCd;
	this.roleNm;
	this.roleTyCd;
	this.roleTyNm;
};

var EntityPool = function() {
	this.rsrcPoolId;
	this.rsrcPoolNm;
	this.regionId;
	this.regionNm;
	this.zoneNm;
	this.netNm;
};


var EntityJob = function() {

	this.jobId;
	this.jobNm;
	this.cludJob;
	this.jobGrd;
	this.institutionId;
	this.institutionNm;
};

var EntityInstitution = function() {

	this.institutionId;
	this.institutionNm;
	this.regionId;
	this.regionNm;
};

var EntityVrSwtch = function() {
	this.vrSwtchSeq;
	this.regionNm;
	this.zoneNm;
	this.netNm;
	this.rsrcPoolNm;
	this.vrlzSwTyCdNm;
	this.vrlzSwTyCdId;
	this.netwkNm;
};

var EntitySRout = function(){
	this.sRoutSeq;
	this.ipBndAddr;
	this.subnetMask;
	this.gtwyNm;
	this.bndSeq;
};

var EntityZone = function() {
	this.regionId;
	this.regionNm;
	this.zoneId;
	this.zoneNm;
	this.netId;
	this.netNm;
	this.level;
};

var EntityNet = function() {
	this.regionId;
	this.zoneId;
	this.netId;
	this.netNm;
	this.netClCd;
	this.netClNm;
};

var EntityApi = function() {
	this.ApiId;
	this.stackClNm;
	this.apiNm;
	this.dc;
};

var EntityRoutingScript = function() {
	this.sRoutingScriptSeq;
	this.osTyCd;
	this.osVer;
	this.script;
};

var EntityVmInfo = function() {
	this.vmSeq;
	this.vmNm;
};

var EntityRsrcPool = function(){
	this.regionId;
	this.zoneId;
	this.netClCd;
	this.rsrcPoolId;
}

var EntityRnIp = function () {
	this.bndSeq;
	this.ipAddr;
	this.natIpAddr;
	this.vipYn;
	this.rmk;
}