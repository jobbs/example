<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     최진호         v1.0             최초생성
 *
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<script type="text/javascript" src="<c:url value="/resources/js/common/validation.js" />" charset="UTF-8"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/FileUtils.js" />" charset="UTF-8"></script>
<script type="text/javascript" src="<c:url value="/resources/sedit2/js/HuskyEZCreator.js" />" charset="UTF-8"></script>

<script type="text/javascript" src="<c:url value="/resources/js/common/Base64.js" />" charset="UTF-8"></script>
<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<colgroup>
					<col class="col20"/>
					<col class="colAuto"/>
				</colgroup>
				<tbody>
				<tr>
					<th>SEQ 테스트</th>
					<td>
						<button type="button" class="btn" onclick="doSequenceTest()">SEQ 테스트</button>
					</td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
<script type="text/javascript">
function doSequenceTest() {
	location.href = "<c:url value="/cpt/test/doSequenceTest.do" />";
}
</script>
<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<colgroup>
					<col class="col20"/>
					<col class="colAuto"/>
				</colgroup>
				<tbody>
				<tr>
					<th>Error 처리</th>
					<td>
						<button type="button" class="btn" onclick="doCommonException()">CommonException</button>
						<button type="button" class="btn" onclick="doDataNotFoundException()">DataNotFoundException</button>
						<button type="button" class="btn" onclick="doDownFileNotFoundException()">DownFileNotFoundException</button>
						<button type="button" class="btn" onclick="doExceptionScriptPrint()">ExceptionScriptPrint</button>
					</td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
<script type="text/javascript">
function doCommonException() {
	location.href = "<c:url value="/cpt/test/doCommonException.do" />";
}

function doDataNotFoundException() {
	location.href = "<c:url value="/cpt/test/doDataNotFoundException.do" />";
}

function doDownFileNotFoundException() {
	location.href = "<c:url value="/cpt/test/doDownFileNotFoundException.do" />";
}

function doExceptionScriptPrint() {
	location.href = "<c:url value="/cpt/test/doExceptionScriptPrint.do" />";
}
</script>

<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<colgroup>
					<col class="col20"/>
					<col class="colAuto"/>
				</colgroup>
				<tbody>
				<tr>
					<th>공통팝업</th>
					<td>
						<button type="button" class="btn btn-green" onclick="openInsttSearch()">부처조회(단일)	</button>
						<button type="button" class="btn btn-green" onclick="openInsttMultiSearch()">부처조회(멀티)	</button>

						<button type="button" class="btn btn-blue" onclick="openJobeSearch()">업무조회(단일)	</button>
						<button type="button" class="btn btn-blue" onclick="openJobMultiSearch()">업무조회(멀티)	</button>
						<button type="button" class="btn" onclick="openUserPoolSearch()">사용자 자원풀조회(단일)</button>
						<button type="button" class="btn" onclick="openUserPoolMultiSearch()">사용자 자원풀조회(멀티)</button>

						<button type="button" class="btn" onclick="openPoolSearch()">전체 자원풀조회(단일)</button>
						<button type="button" class="btn" onclick="openPoolMultiSearch()">전체 자원풀조회(멀티)</button>

						<button type="button" class="btn btn-green" onclick="openUserSearch()">사용자조회(단일)	</button>
						<button type="button" class="btn btn-green" onclick="openUserMultiSearch()">사용자조회(멀티)	</button>

					</td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
<script type="text/javascript">

//----------------------------------------------------------------------
//부처에 대한 단일 선택
$(document).bind('selectInstitution',setInstitution);
//업무에 대한 단일 선택 이벤터 함수
function setInstitution(evt) {
	var job = evt.datas;
	console.log("institutionId : " + job.institutionId);
	console.log("institutionNm : " + job.institutionNm);
	console.log("regionId : " + job.regionId);
	console.log("regionNm : " + job.regionNm);
}
//----------------------------------------------------------------------//

//----------------------------------------------------------------------
// 부처에 대한 멀티 선택
$(document).bind('selectInstitutionMulti',setInstitutions);
function setInstitutions(evt) {
	$.each(evt.datas, function(index) {
		console.log("institutionId : " + this.institutionId);
		console.log("institutionNm : " + this.institutionNm);
		console.log("regionId : " + this.regionId);
		console.log("regionNm : " + this.regionNm);
	});
}
//----------------------------------------------------------------------

//----------------------------------------------------------------------
//업무에 대한 단일 선택
$(document).bind('selectJob',setJob);
//업무에 대한 단일 선택 이벤터 함수
function setJob(evt) {
	var job = evt.datas;
	console.log("jobId : " + job.jobId);
	console.log("jobNm : " + job.jobNm);
	console.log("cludJob : " + job.cludJob);
	console.log("jobGrd : " + job.jobGrd);
	console.log("institutionId : " + job.institutionId);
	console.log("institutionNm : " + job.institutionNm);
}
//----------------------------------------------------------------------//

//----------------------------------------------------------------------
// 업무에 대한 멀티 선택
$(document).bind('selectJobMulti',setJobs);
function setJobs(evt) {
	$.each(evt.datas, function(index) {
		console.log("jobId : " + this.jobId);
		console.log("jobNm : " + this.jobNm);
		console.log("cludJob : " + this.cludJob);
		console.log("jobGrd : " + this.jobGrd);
		console.log("institutionId : " + this.institutionId);
		console.log("institutionNm : " + this.institutionNm);
	});
}
//----------------------------------------------------------------------



//----------------------------------------------------------------------
// 자원풀에 대한 단일 선택
$(document).bind('selectPool',setPool);
function setPool(evt) {
	var pool = evt.datas;
	console.log("rsrcPoolId : " + pool.rsrcPoolId);
	console.log("rsrcPoolNm : " + pool.rsrcPoolNm);
	console.log("regionId : " + pool.regionId);
	console.log("regionNm : " + pool.regionNm);
	console.log("zoneNm : " + pool.zoneNm);
	console.log("netNm : " + pool.netNm);
}
//----------------------------------------------------------------------

//----------------------------------------------------------------------
// 업무에 대한 멀티 선택
$(document).bind('selectPoolMulti',setPools);
function setPools(evt) {
	$.each(evt.datas, function(index) {
		console.log("rsrcPoolId : " + this.rsrcPoolId);
		console.log("rsrcPoolNm : " + this.rsrcPoolNm);
		console.log("regionId : " + this.regionId);
		console.log("regionNm : " + this.regionNm);
		console.log("zoneNm : " + this.zoneNm);
		console.log("netNm : " + this.netNm);
	});
}
//----------------------------------------------------------------------

//----------------------------------------------------------------------
// 자원풀에 대한 단일 선택
$(document).bind('selectUser',setUser);
function setUser(evt) {
	var user = evt.datas;
	console.log("userId : " + user.userId);
	console.log("userNm : " + user.userNm);
	console.log("institutionId : " + user.institutionId);
	console.log("institutionNm : " + user.institutionNm);
	console.log("ofcpsId : " + user.ofcpsId);
	console.log("ofcpsNm : " + user.ofcpsNm);
	console.log("telno : " + user.telno);
	console.log("mobile : " + user.mobile);
	console.log("email : " + user.email);
}
//----------------------------------------------------------------------

//----------------------------------------------------------------------
// 업무에 대한 멀티 선택
$(document).bind('selectUserMulti',setUsers);
function setUsers(evt) {

	console.log( evt.datas );
	$.each(evt.datas, function(index) {
		console.log("userId : " + this.userId);
		console.log("userNm : " + this.userNm);
		console.log("institutionId : " + this.institutionId);
		console.log("institutionNm : " + this.institutionNm);
		console.log("ofcpsId : " + this.ofcpsId);
		console.log("ofcpsNm : " + this.ofcpsNm);
		console.log("telno : " + this.telno);
		console.log("mobile : " + this.mobile);
		console.log("email : " + this.email);
	});
}
//----------------------------------------------------------------------
</script>

<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<colgroup>
					<col class="col20"/>
					<col class="colAuto"/>
				</colgroup>
				<tbody>
				<tr>
					<th>Zone Select(Net Cl CD)</th>
					<td>
						<div class="input-group-box">
							<div class="input-group-cell pad-right-5">
								<nform:selectRegion
										name="regionId2"
										id="regionId2"
										whole="true"
										wholeText="리전을 선택하세요"
										cssClass="form-control"
										onchange="selectZoneByNetClCd('regionId2', 'zoneId2', 'code', 'poolId2')" />
							</div>
							<div class="input-group-cell pad-right-5">
								<nform:selectZone
										name="zoneId2"
										id="zoneId2"
										whole="true"
										value=""
										regionId=""
										wholeText="존을 선택하세요"
										cssClass="form-control"
										onchange="selectPoolByNetClCd('regionId2', 'zoneId2', 'code', 'poolId2')" />
							</div>
							<div class="input-group-cell pad-right-5">
								<nform:selectCode
										parentCd="NETCD"
										parentGrpCd="067"
										name="code"
										id="code"
										whole="true"
										wholeText="망코드를 선택하세요"
										extra1=""
										extra2=""
										extra3=""
										extra4=""
										extra5=""
										cssClass="form-control"
										onchange="selectPoolByNetClCd('regionId2', 'zoneId2', 'code', 'poolId2')" />
							</div>
							<div class="input-group-cell pad-right-5">
								<nform:selectPool
										name="poolId2"
										id="poolId2"
										wholeText="자원 풀을 선택하세요"
										value=""
										poolTypeCd="01"
										swTypeCd="COM"
										regionId=""
										zoneId=""
										netId=""
										ctlTrgtYn="Y"
										cssClass="form-control" />
							</div>
						</div>
					</td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<colgroup>
					<col class="col20"/>
					<col class="colAuto"/>
				</colgroup>
				<tbody>
				<tr>
					<th>Zone Select</th>
					<td>
						<div class="input-group-box">
							<div class="input-group-cell pad-right-5">
								<nform:selectRegion
										name="regionId"
										id="regionId"
										whole="true"
										wholeText="리전을 선택하세요"
										cssClass="form-control"
										onchange="selectZoneDy(this, 'zoneId' )" />
							</div>
							<div class="input-group-cell pad-right-5">
								<nform:selectZone
										name="zoneId"
										id="zoneId"
										whole="true"
										value=""
										regionId=""
										wholeText="존을 선택하세요"
										cssClass="form-control"
										onchange="selectNetDy(this, 'netId' )" />
							</div>
							<div class="input-group-cell pad-right-5">
								<nform:selectNet
										name="netId"
										id="netId"
										whole="true"
										wholeText="망을 선택하세요"
										value=""
										zoneId=""
										cssClass="form-control"
										onchange="selectPoolDy(this, 'regionId', 'zoneId', 'poolId', {'searchCtlTrgtYn' : 'Y'} )" />
							</div>
							<div class="input-group-cell pad-right-5">
								<nform:selectPool
										name="poolId"
										id="poolId"
										wholeText="자원 풀을 선택하세요"
										value=""
										poolTypeCd="01"
										swTypeCd="COM"
										regionId=""
										zoneId=""
										netId=""
										ctlTrgtYn="Y"
										cssClass="form-control"
										onchange="selectClusterDy(this, 'clusterId' )" />
							</div>
							<div class="input-group-cell">
								<nform:selectCluster
										name="clusterId"
										id="clusterId"
										wholeText="클러스트을 선택하세요"
										value=""
										poolId=""
										cssClass="form-control" />
							</div>
						</div>
					</td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>


<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<colgroup>
					<col class="col20"/>
					<col class="colAuto"/>
				</colgroup>
				<tbody>
				<tr>
					<th>Zone Select(All)</th>
					<td>
						<div class="input-group-box">
							<div class="input-group-cell pad-right-5">
								<nform:selectRegion
										name="regionIdAll"
										id="regionIdAll"
										whole="true"
										wholeText="리전을 선택하세요"
										byRole="false"
										cssClass="form-control"
										onchange="selectZoneDy(this, 'zoneIdAll', {'byRole' : false} )" />
							</div>
							<div class="input-group-cell pad-right-5">
								<nform:selectZone
										name="zoneIdAll"
										id="zoneIdAll"
										whole="true"
										value=""
										regionId=""
										wholeText="존을 선택하세요"
										byRole="false"
										cssClass="form-control"
										onchange="selectNetDy(this, 'netIdAll', {'byRole' : false}  )" />
							</div>
							<div class="input-group-cell pad-right-5">
								<nform:selectNet
										name="netIdAll"
										id="netIdAll"
										whole="true"
										wholeText="망을 선택하세요"
										value=""
										zoneId=""
										byRole="false"
										cssClass="form-control"
										onchange="selectPoolDy(this, 'regionIdAll', 'zoneIdAll', 'poolIdAll' , {'byRole' : false})" />
							</div>
							<div class="input-group-cell pad-right-5">
								<nform:selectPool
										name="poolIdAll"
										id="poolIdAll"
										wholeText="자원 풀을 선택하세요"
										value=""
										poolTypeCd="01"
										swTypeCd="COM"
										regionId=""
										zoneId=""
										netId=""
										byRole="false"
										cssClass="form-control"
										onchange="selectClusterDy(this, 'clusterIdAll' )" />
							</div>
							<div class="input-group-cell">
								<nform:selectCluster
										name="clusterIdAll"
										id="clusterIdAll"
										wholeText="클러스트을 선택하세요"
										value=""
										poolId=""
										cssClass="form-control" />
							</div>
						</div>
					</td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>


<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<colgroup>
					<col class="col20"/>
					<col class="colAuto"/>
				</colgroup>
				<tbody>
				<tr>
					<th>Code Select</th>
					<td>
						<nform:selectCode
							parentCd="100"
							parentGrpCd="001"
							name="code"
							id="code"
							whole="true"
							extra1=""
							extra2=""
							extra3=""
							extra4=""
							extra5=""
							cssClass="form-control" />
					</td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<colgroup>
					<col class="col20"/>
					<col class="colAuto"/>
				</colgroup>
				<tbody>
				<tr>
					<th>Excel Down</th>
					<td><button type="button" class="btn btn-blue" onclick="goExcelDownload()">Excel Download</button>
				</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<colgroup>
					<col class="col20"/>
					<col class="colAuto"/>
					<col class="colAuto"/>
					<col class="col20"/>
				</colgroup>
				<tbody>
				<tr>
					<th>자식 코드 목록</th>
					<td><input type="text" name="grpCd" id="grpCd" class="form-control" title="그룹코드" placeholder="그룹코드"/></td>
					<td><input type="text" name="cd" id="cd" class="form-control" title="코드" placeholder="코드"/></td>
					<td><button type="button" class="btn btn-blue" onclick="goCode()">코드조회</button>
				</tr>
				<tr>
					<th>코드결과</th>
					<td colspan="3">
						<span id="seqnumSpan">Json 형태를 String 으로 바꾸는게 없어서..ㅡㅡ;; 브라우져의 콘솔을 확인하시기 바랍니다.</span>
					</td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<colgroup>
					<col class="col20"/>
					<col class="colAuto"/>
					<col class="colAuto"/>
					<col class="col20"/>
				</colgroup>
				<tbody>
				<tr>
					<th>문서ID 채번</th>
					<td><input type="text" name="classfy" id="classfy" class="form-control" title="채번 구분" placeholder="채번구분"/></td>
					<td><input type="text" name="format" id="format" class="form-control" title="채번포맷" placeholder="PREFIX( Ex : DJ_2016_ )"/></td>
					<td><button type="button" class="btn btn-blue" onclick="goSeqnum()">채번하기</button>
				</tr>
				<tr>
					<th>문서ID 채번 결과</th>
					<td colspan="3">
						<span id="seqnumSpan">Json 형태를 String 으로 바꾸는게 없어서..ㅡㅡ;; 브라우져의 콘솔을 확인하시기 바랍니다.</span>
					</td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-body no-padding">
			<form id="testForm" enctype="multipart/form-data">
			<table class="table table-horizon">
				<colgroup>
					<col class="col20"/>
					<col class="colAuto"/>

				</colgroup>
				<tbody>
				<tr>
					<th>필수항목</th>
					<td><input type="text" name="essential" class="form-control essential" title="필수항목" /></td>
				</tr>
				<tr>
					<th>영문먼저</th>
					<td><input type="text" name="eng" class="form-control" style="ime-mode:inactive" title="영문 먼저" /></td>
				</tr>
				<tr>
					<th>한글먼저</th>
					<td><input type="text" name="kor" class="form-control" style="ime-mode:active" title="한글 먼저" /></td>
				</tr>
				<tr>
					<th>숫자만</th>
					<td><input type="text" name="onlyNumber" class="form-control onlyNumber" title="숫자만" /></td>
				</tr>
				<tr>
					<th>정수형만</th>
					<td><input type="text" name="onlyInteger" class="form-control onlyInteger" title="정수형만" /></td>
				</tr>
				<tr>
					<th>기호형정수만</th>
					<td><input type="text" name="onlySignInteger" class="form-control onlySignInteger" title="기호형정수만" /></td>
				</tr>
				<tr>
					<th>콤마정수</th>
					<td><input type="text" name="onlyIntegerNF" class="form-control onlyIntegerNF" title="콤마정수" /></td>
				</tr>
				<tr>
					<th>콤마기호형정수</th>
					<td><input type="text" name="onlySignIntegerNF" class="form-control onlySignIntegerNF" title="콤마기호형정수" /></td>
				</tr>
				<tr>
					<th>실수형</th>
					<td><input type="text" name="onlyFloat" class="form-control onlyFloat" title="실수형" /></td>
				</tr>
				<tr>
					<th>기호실수형</th>
					<td><input type="text" name="onlySignFloat" class="form-control onlySignFloat" title="기호실수형" /></td>
				</tr>
				<tr>
					<th>콤마실수형</th>
					<td><input type="text" name="onlyFloatNF" class="form-control onlyFloatNF" title="콤마실수형" /></td>
				</tr>
				<tr>
					<th>콤마기호실수형</th>
					<td><input type="text" name="onlySignFloatNF" class="form-control onlySignFloatNF" title="콤마기호실수형" /></td>
				</tr>
				<tr>
					<th>영문</th>
					<td><input type="text" name="onlyAlpha" class="form-control onlyAlpha" title="영문만" /></td>
				</tr>
				<tr>
					<th>영문,숫자</th>
					<td><input type="text" name="onlyAlphaNum" class="form-control onlyAlphaNum" title="영문,숫자만" /></td>
				</tr>
				<tr>
					<th>영문,숫자,dash</th>
					<td><input type="text" name="onlyAlphaNumDash" class="form-control onlyAlphaNumDash" title="영문,숫자,dash" /></td>
				</tr>
				<tr>
					<th>숫자,dash</th>
					<td><input type="text" name="onlyNumDash" class="form-control onlyNumDash" title="숫자,dash" /></td>
				</tr>
				<tr>
					<th>날짜형</th>
					<td><input type="text" name="onlyDate" class="form-control onlyDate" title="날짜형만" /></td>
				</tr>
				<tr>
					<th>날짜시간형</th>
					<td><input type="text" name="onlyDateTime" class="form-control onlyDateTime" title="날짜형만" /></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" name="onlyPhone" class="form-control onlyPhone" title="전화번호" /></td>
				</tr>
				<tr>
					<th>email</th>
					<td><input type="text" name="onlyEmail" class="form-control onlyEmail" title="email" /></td>
				</tr>

				<tr>
					<th>날짜(기본)</th>
					<td>
						<div class="input-group">
						<input type="text" name="date" class="form-control datepicker" title="날짜" />
						</div>
					</td>
				</tr>
				<tr>
					<th>날짜 기간</th>
					<td>
						<div class="input-group period period-start">
							<input type="text" name="startDate" id="startDate" class="form-control datepicker" title="날짜" onchange="initDate(this, 'endDate', 'S')"/>
						</div>
						<div class="input-group period period-end">
							<input type="text" name="endDate" id="endDate" class="form-control datepicker" title="날짜" onchange="initDate(this, 'startDate', 'E')"/>
						</div>
					</td>
				</tr>
				<tr>
					<th>체크박스</th>
					<td>
						<div class="input-group input-group-check">
							<input type="checkbox" id="testCheck1" name="testCheck" value="1" /><label for="testCheck1">체크1</label>
							<input type="checkbox" id="testCheck2" name="testCheck" value="2" /><label for="testCheck2">체크2</label>
							<input type="checkbox" id="testCheck3" name="testCheck" value="3" /><label for="testCheck3">체크3</label>
							<input type="checkbox" id="testCheck4" name="testCheck" value="4" /><label for="testCheck4">체크4</label>
							<input type="checkbox" id="testCheck5" name="testCheck" value="5" /><label for="testCheck5">체크5</label>
							<input type="checkbox" id="testCheck6" name="testCheck" value="6" /><label for="testCheck6">체크6</label>
						</div>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea name="contents" id="contents" class="form-control" title="내용"></textarea>
					</td>
				</tr>
				<tr>
					<th>첨부파일(multi)</th>
					<td>
						<div class="file-form" id="fileDiv"></div>
						<script type="text/javascript">
						var files = new Array();
						<c:forEach var="file" items="${vo.boardFiles }">
							files.push({idx : ${file.seq}, fileName : "${onlySignFloat.originFileName}"});
						</c:forEach>

						$("#fileDiv").createSelectboxFile({maxCount:3, data : files});
						</script>
					</td>
				</tr>
				<tr>
					<th>첨부파일(single)</th>
					<td>
						<div class="file-form" id="fileSigleDiv"></div>
						<script type="text/javascript">
						$("#fileSigleDiv").createSelectboxFile({multiType : 'single' } );
						</script>
					</td>
				</tr>
				</tbody>
			</table>
			</form>
		</div>
	</div>
</div>


<!-- 페이지 버튼 -->
<div class="col-box-100 detail-col">
	<div class="edit-btn-group">
	  <div class="pull-left btns">
	    <button class="btn btn-hover-red" data-toggle="tooltip" title="" data-original-title="삭제하기"><i class="fa fa-times"></i></button>
	  </div>
	  <ul class="pagination">
	    <li class="first"><a href="#">«</a></li>
	    <li class="prev"><a href="#">‹</a></li>
	    <li class="active"><a href="#">1</a></li>
	    <li><a href="#">2</a></li>
	    <li><a href="#">3</a></li>
	    <li class="next"><a href="#">›</a></li>
	    <li class="last"><a href="#">»</a></li>
	  </ul>
	  <div class="pull-right btns">
	    <button class="btn btn-hover-blue" data-toggle="tooltip" title="" data-original-title="추가하기"><i class="fa fa-plus"></i></button>
	    <button class="btn btn-hover-green" data-toggle="tooltip" title="" data-original-title="엑셀다운로드"><i class="fa fa-arrow-down"></i></button>
	    <button class="btn btn-hover-yellow" data-toggle="tooltip" title="" data-original-title="수정하기"><i class="fa fa-font"></i></button>
	    <button class="btn btn-hover-blue" data-toggle="tooltip" title="" data-original-title="저장" onclick="jConfirm('저장하시겠습니까?', doSubmit);"><i class="fa fa-check"></i></button>
	  </div>
	</div>
</div>

<script type="text/javascript">

$(document).ready(function() {
	$("#regionId").change();
});

// web editor start -----------------------------------------------------
var oEditors = [];

nhn.husky.EZCreator.createInIFrame({
	oAppRef: oEditors,
	elPlaceHolder: "contents",
	sSkinURI: "<c:url value="/resources/sedit2/SmartEditor2Skin.html" />",
	htParams : {
		bUseToolbar : true,				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
		bUseVerticalResizer : true,		// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
		bUseModeChanger : true
	},
	fCreator: "createSEditor2"
});
//web editor end -----------------------------------------------------

function doSubmit(result){

	//web editor 에서 textarea로 이동처리.
	oEditors.getById["contents"].exec("UPDATE_CONTENTS_FIELD", []);

	if(!fn_form_validation("testForm")){
		return;
	}

	var options = {
		type: 'post',
		dataType: 'json',
		success: successHandler,
		beforeSend: function() {
		},
		error: function(xhr, textStatus, errorThrown){
			alert('오류 발생');
		}
	};

	//$("#testForm").submit();

}

function successHandler(result){

	alert_message(result.messageList, function() {
		if(result.success){
			if(result.procType == "insert")
				location.href = "list.do";
			else
				location.href = "detail.do";
		}
	});


}

function deleteFile(obj){
	var con = confirm("파일을 삭제 하시겠습니까?");
	if( !con ) return false;
	$(obj).parent().parent().remove();
}

function goSeqnum() {
	if( $("#classfy").val() == "" ) {
		jAlert("채번 구분입력이요~~~~~");
		$("#classfy").focus();
		return;
	}

	if( $("#format").val() == "" ) {
		jAlert("채번 왜 자꾸 빼먹어요~ 포맷 입력해요~");
		$("#format").focus();
		return;
	}

	$.post("selectSeqnum.do",
			{"classfy" : $("#classfy").val(), "format" : $("#format").val() },
			function(result) {
				console.log(result);
				if( result.success ) {
					$("#seqnumSpan").text(result.data);
				}
			},
			'json'
	);
}

function goCode() {
	if( $("#grpCd").val() == "" ) {
		jAlert("그룹코드입력이요~~~~~");
		$("#grpCd").focus();
		return;
	}

	if( $("#cd").val() == "" ) {
		jAlert("코드 입력해요~");
		$("#cd").focus();
		return;
	}

	$.post("selectCodeList.do",
			{"grpCd" : $("#grpCd").val(), "cd" : $("#cd").val() },
			function(result) {
				console.log(result);
				if( result.success ) {
					console.log( result.data );
					//$("#seqnumSpan").text(result.data);
				}
			},
			'json'
	);
}

function goExcelDownload() {
	location.href = "downfileExcel.do";
}
</script>