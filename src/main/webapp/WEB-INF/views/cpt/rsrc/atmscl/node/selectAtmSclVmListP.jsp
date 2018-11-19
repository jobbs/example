<%--
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre>가상서버 선택 화면</pre>
 *
 * @author x
 * @lastmodifier x
 * @created 2017. 04. 28.
 * @lastmodified 2017. 04. 28.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 05. 13.     x         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<div class="col-box-100">
	<!-- 검색조건 영역 -->
	<div class="box-search">
		<!-- box-header -->
		<form:form commandName="vmSearchVo" method="get">
			<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />
			<div class="box-body">
				<div class="form-group">
					<!-- 검색조건 : select -->
					<div class="form-cell form-cell-25">
						<div class="cell-title">
							<label for="equalsRegionId">센터</label>
						</div>
						<div class="cell-body">
							<nform:selectRegion

								name="equalsRegionId"
								id="equalsRegionId"
								cssClass="form-control input-sm"
								title="센터"
								value="${vmSearchVo.equalsRegionId}"
								whole="true"
								onchange="selectZoneByNetClCd('equalsRegionId', 'equalsZoneId', 'equalsNetClCd', 'equalsRsrcPoolId')"  />
						</div>
					</div>

					<!-- 검색조건 : select -->
					<div class="form-cell form-cell-25">
						<div class="cell-title">
							<label for="equalsZoneId">존</label>
						</div>
						<div class="cell-body">
							<nform:selectZone
								name="equalsZoneId"
								id="equalsZoneId"
								class="form-control input-sm"
								title="존"
								whole="true"
								regionId="${vmSearchVo.equalsRegionId}"
								value="${vmSearchVo.equalsZoneId}"
								onchange="selectPoolByNetClCd('equalsRegionId', 'equalsZoneId', 'equalsNetClCd', 'equalsRsrcPoolId')" />
						</div>
					</div>

					<!-- 검색조건 : select -->
					<div class="form-cell form-cell-25">
						<div class="cell-title">
							<label for="equalsNetClCd">망구분</label>
						</div>
						<div class="cell-body">
							<nform:selectCode
								parentCd="NETCD"
          						parentGrpCd="067"
								name="equalsNetClCd"
								id="equalsNetClCd"
								title="망구분"
								cssClass="form-control input-sm"
								whole="true"
								zoneId="${vmSearchVo.equalsZoneId}"
								value="${vmSearchVo.equalsNetClCd}"
								onchange="selectPoolByNetClCd('equalsRegionId', 'equalsZoneId', 'equalsNetClCd', 'equalsRsrcPoolId', {searchPoolTypeCd : '01'})"  />
						</div>
					</div>

					<!-- 검색조건 : select -->
					<div class="form-cell form-cell-25">
						<div class="cell-title">
							<label for="equalsRsrcPoolId">자원풀</label>
						</div>
						<div class="cell-body">
							<nform:selectPool
								name="equalsRsrcPoolId"
								id="equalsRsrcPoolId"
								title="자원풀"
								poolTypeCd="01"
								swTypeCd="COM"
								cssClass="form-control input-sm"
								whole="true"
								regionId="${vmSearchVo.equalsRegionId }"
								zoneId="${vmSearchVo.equalsZoneId}"
								netClCd="${vmSearchVo.equalsNetClCd }"
								value="${vmSearchVo.equalsRsrcPoolId}"
								/>
						</div>
					</div>

					<!-- 검색조건 : select -->
					<div class="form-cell form-cell-25">
						<div class="cell-title">
							<label for="equalsStatCd">상태</label>
						</div>
						<div class="cell-body">
							<form:select path="equalsStatCd" title="상태" cssClass="form-control input-sm">
							<c:forEach var="statGrpCd" items="${statCdList }">
								<form:option value="${statGrpCd.cd}" ><c:out value="${statGrpCd.cdNm }"/></form:option>
							</c:forEach>
						</form:select>
						</div>
					</div>
					<!-- 검색조건 : input -->
					<div class="form-cell form-cell-25">
						<div class="cell-title">
							<label for="containsVmNm">가상서버명</label>
						</div>
						<div class="cell-body">
							<form:input path="containsVmNm" cssClass="form-control input-sm" value="" title="가상서버명"/>
						</div>
					</div>

					<!-- 검색조건 : input -->
					<div class="form-cell form-cell-25">
						<div class="cell-title">
							<label for="containsVmId">가상서버ID</label>
						</div>
						<div class="cell-body">
							<form:input path="containsVmId" cssClass="form-control input-sm" value="" title="가상서버ID"/>
						</div>
					</div>

					<!-- 검색조건 : input -->
					<div class="form-cell form-cell-25">
						<div class="cell-title">
							<label for="containsVmCompId">가상서버구성ID</label>
						</div>
						<div class="cell-body">
							<form:input path="containsVmCompId" cssClass="form-control input-sm" value="" title="가상서버구성ID"/>
						</div>
					</div>

					<!-- 검색조건 : input -->
					<div class="form-cell form-cell-25">
						<div class="cell-title">
							<label for="containsHstNm">호스트명</label>
						</div>
						<div class="cell-body">
							<form:input path="containsHstNm" cssClass="form-control input-sm" value="" title="호스트명"/>
						</div>
					</div>

					<!-- 검색조건 : input -->
					<div class="form-cell form-cell-25">
						<div class="cell-title">
							<label>IP주소</label>
						</div>
						<div class="cell-body">
							<form:input path="containsRprsntIpAddr" cssClass="form-control input-sm onlyIp" value="" maxlength="15" title="IP주소"/>
						</div>
					</div>

					<!-- 검색조건 : input -->
					<div class="form-cell form-cell-25">
						<div class="cell-title">
							<label for="containsInstitutionNm">부처</label>
						</div>
						<div class="cell-body">
							<form:input path="containsInstitutionNm" cssClass="form-control input-sm" value="" title="부처명"/>
						</div>
					</div>

					<!-- 검색조건 : input -->
					<div class="form-cell form-cell-25">
						<div class="cell-title">
							<label for="existsContainsJobNm">업무</label>
						</div>
						<div class="cell-body">
							<form:input path="existsContainsJobNm" cssClass="form-control input-sm" value="" title="업무명" />
						</div>
					</div>

					<!--  검색조건 완료 -->
					<div class="form-cell form-cell-100 alignR pad-top-5">
						<div class="pull-left">
					    	<button type="button" class="btn btn-sm" onclick="fn_initialize();">초기화</button>
					  	</div>
					  	<div class="pull-right">
							<button class="btn btn-red btn-sm" type="button" onclick="fn_selectVmSearchList()">조회</button>
						</div>
					</div>
				</div>
			</div>
		</form:form>
	</div>
	<!-- 가상서버 테이블 영역 -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">
				검색결과<small> ${vmSearchVo.paginationInfo.currentPageNo }
					/ ${vmSearchVo.paginationInfo.totalPageCount }, 총
					${vmSearchVo.paginationInfo.totalRecordCount }건 </small>
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="vmSearchVo" value="${vmSearchVo }" />
				</div>
			</div>
		</div>
		<!-- /box-header -->
		<!-- box-body -->
		<form:form commandName="vmVo" id="vmFrm" method="get">
			<div class="box-body no-padding" style="overflow-x:auto;">
				<table class="table table-vertical table-hover table-layout-fixed" id="vmListTable">
					<caption>가상서버 목록</caption>
					<thead>
						<tr>
							<th>선택</th>
							<th>상태</th>
							<th>센터</th>
							<th>존</th>
							<th>망구분</th>
							<th>자원풀</th>
							<th>부처</th>
							<th>업무</th>
							<th>가상서버명</th>
							<th>가상서버구성ID</th>
							<th>가상서버ID</th>
							<th>호스트명</th>
							<th>IP주소</th>
							<th>OS유형</th>
							<th>가상화SW</th>
							<th>생성일시</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vmVo" items="${vmVoList }" varStatus="i">
							<tr>
								<td><form:radiobutton path="vmSeq" value="${vmVo.vmSeq }" title="${vmVo.vmSeq}_선택"/>
									<input type="hidden" name="regionNm" value="${vmVo.regionNm }">
									<input type="hidden" name="regionId" value="${vmVo.regionId }">
									<input type="hidden" name="zoneNm" value="${vmVo.zoneNm }">
									<input type="hidden" name="zoneId" value="${vmVo.zoneId }">
									<input type="hidden" name="netNm" value="${vmVo.netNm }">
									<input type="hidden" name="netClCd" value="${vmVo.netClCd }">
									<input type="hidden" name="vrlzSwTyCdNm" value="${vmVo.vrlzSwTyCdNm }">
									<input type="hidden" name="vmCompId" value="${vmVo.vmCompId }">
									<input type="hidden" name="vmNm" value="${vmVo.vmNm }">
									<input type="hidden" name="regDttm" value="<fmt:formatDate value="${vmVo.regDttm }" pattern="yyyy-MM-dd HH:mm:ss" />">
									<input type="hidden" name="rsrcPoolId" value="${vmVo.rsrcPoolId }">
									<input type="hidden" name="rsrcPoolNm" value="${vmVo.rsrcPoolNm }">
									<input type="hidden" name="rprsntIpAddr" value="${vmVo.rprsntIpAddr }">
									<input type="hidden" name="netId" value="${vmVo.netId }">
								</td>
								<td>
								<c:if test="${null ne vmVo.statGrpCd}">
									<div class="server-info server
										<c:choose>
											<c:when test='${"01" eq vmVo.statGrpCd}'><c:out value="server-down"/></c:when>
											<c:when test='${"02" eq vmVo.statGrpCd}'><c:out value="server-up"/></c:when>
											<c:when test='${"03" eq vmVo.statGrpCd}'><c:out value="server-inprogress"/></c:when>
											<c:when test='${"04" eq vmVo.statGrpCd}'><c:out value="server-exception"/></c:when>
								   			<c:otherwise></c:otherwise>
										</c:choose>
									">
										<div class="server-info-body alignL">
											<div class="server-info-box alignL">
												<span class="label"></span><h4 class="stat"><c:out value="${vmVo.statGrpCdNm }" /></h4>
											</div>
										</div>
									</div>
								</c:if>
								</td>
								<td><c:out value="${vmVo.regionNm }" /></td>
								<td><c:out value="${vmVo.zoneNm }" /></td>
								<td><c:out value="${vmVo.netNm }" /></td>
								<td class="alignL"><c:out value="${vmVo.rsrcPoolNm }" /></td>
								<td class="alignL"><c:out value="${vmVo.institutionNm }" /></td>
								<td class="alignL">
									<c:set var="jobNmList" value="${fn:split(vmVo.jobsNm, ',')}"/>
									<c:forEach var="jobNm" items="${jobNmList}" varStatus="i">
										<c:out value="${jobNm }" /><c:if test="${fn:length(jobNmList) > (i.index + 1) }"><c:out value=","/></c:if>
									</c:forEach>
								</td>
								<td class="alignL"><c:out value="${vmVo.vmNm }" /></td>
								<td class="alignL"><c:out value="${vmVo.vmCompId }" /></td>
								<td class="alignL"><c:out value="${vmVo.vmId }" /></td>
								<td class="alignL"><c:out value="${vmVo.hstNm }" /></td>
								<td class="alignL"><c:out value="${vmVo.rprsntIpAddr }" /></td>
								<td><c:out value="${vmVo.osTyCdNm }" /></td>
								<td class="alignL"><c:out value="${vmVo.vrlzSwTyCdNm }" /></td>
								<td><fmt:formatDate value="${vmVo.regDttm }" pattern="yyyy-MM-dd" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- 			<div class="box-footer clearfix"> -->
			</div>
				<div class="box-footer">
					<ul class="pagination">
						<ui:pagination paginationInfo="${vmSearchVo.paginationInfo }" type="common" jsFunction="fn_goPage" />
					</ul>
				</div>
		</form:form>
		<!-- /box-body -->
	</div>
</div>
<!-- popup 버튼 -->
<div class="col-box-100">
  <div class="button">
  	<button type="button" class="btn btn-dark" onclick="fn_selectVm()">선택</button>
  	<button type="button" class="btn close-window" >닫기</button>
   </div>
</div>
<!-- /popup 버튼 -->

<script type="text/javascript">

function fn_initialize(){
	$('#vmSearchVo input[type="text"]').val('');
	//$('#vmSearchVo select').val('').attr('selected', 'selected');
	$('#vmSearchVo input[type="checkbox"][name="searchVrlzSwTyCdList"]').prop('checked', 'checked');
	$("#vmSearchVo #equalsRegionId").val('').attr("selected","selected");

}

$(document).ready(function(){
	$("#equalsRegionId").prop('disabled',true);
	$("#equalsZoneId").prop('disabled',true);
	$("#equalsNetClCd").prop('disabled',true);


	/*
	if($("#equalsRsrcPoolId").val() == '') {
		$("#equalsNetClCd").change();
	}
	*/

	$('#vmSearchVo input[type="text"]').keydown(function (event) {
		if(event.which == 13) {
			fn_selectVmSearchList();
		}
	});
});

//페이지 이동
function fn_goPage(page){
	location.href = "selectAtmSclVmListPView.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}

//검색조건 초기화
function fn_initialize(){
	$('#vmSearchVo input[type="text"]').val('');
	$("#equalsRsrcPoolId").val('').attr('selected', 'selected');
	$("#equalsStatCd").val('').attr('selected', 'selected');
}

// 조회
function fn_selectVmSearchList(){

	$("#equalsRegionId").prop('disabled',false);
	$("#equalsZoneId").prop('disabled',false);
	$("#equalsNetClCd").prop('disabled',false);

	$('#vmSearchVo').attr('target', '_self');
	$('#vmSearchVo').attr('action', '<c:url var="select" value="selectAtmSclVmListPView.do"/>');

	$('#vmSearchVo').submit();
}

// 가상서버 선택
function fn_selectVm(){
	var checked = 0;
	$("input[name='vmSeq']").each(function() {
		if( $(this).prop("checked") ) {
			checked++;
		}
	});

	if( checked == 0 ) {
		jAlert("선택된 가상서버가 없습니다.");
		return;
	}

	jConfirm('가상서버를 선택하시겠습니까?',fn_selectVmList)

}


//가상서버 선택
function fn_selectVmList(){

	var datas = new Array();
	var data = null;

	$("input[name='vmSeq']").each(function(index) {

		if( $(this).prop("checked") ) {
			data = new EntityAtmSclVm();
			data.vmSeq = $(this).val();
			data.regionNm = $("input:hidden[name='regionNm']:eq(" + index + ")").val();
			data.regionId = $("input:hidden[name='regionId']:eq(" + index + ")").val();
			data.zoneNm = $("input:hidden[name='zoneNm']:eq(" + index + ")").val();
			data.zoneId = $("input:hidden[name='zoneId']:eq(" + index + ")").val();
			data.netNm = $("input:hidden[name='netNm']:eq(" + index + ")").val();
			data.netClCd = $("input:hidden[name='netClCd']:eq(" + index + ")").val();
			data.vrlzSwTyCdNm = $("input:hidden[name='vrlzSwTyCdNm']:eq(" + index + ")").val();
			data.vmCompId = $("input:hidden[name='vmCompId']:eq(" + index + ")").val();
			data.vmNm = $("input:hidden[name='vmNm']:eq(" + index + ")").val();
			data.regDttm = $("input:hidden[name='regDttm']:eq(" + index + ")").val();
			data.rsrcPoolId = $("input:hidden[name='rsrcPoolId']:eq(" + index + ")").val();
			data.rsrcPoolNm = $("input:hidden[name='rsrcPoolNm']:eq(" + index + ")").val();
			data.rprsntIpAddr = $("input:hidden[name='rprsntIpAddr']:eq(" + index + ")").val();
			data.netId = $("input:hidden[name='netId']:eq(" + index + ")").val();
			datas.push(data);
		}
	});

	window.opener.setAtmSclVmList(datas);
	window.close();
}

function EntityAtmSclVm() {
	this.vmSeq;
	this.regionNm;
	this.regionId;
	this.zoneNm;
	this.zoneId;
	this.netNm;
	this.netClCd;
	this.vrlzSwTyCdNm;
	this.vmCompId;
	this.vmNm;
	this.regDttm;
	this.rsrcPoolId;
	this.rsrcPoolNm;
	this.rprsntIpAddr;
	this.netId;
};

function fn_close(){
	window.close();
}


$("#vmFrm input[name='vmSeq']").parent().parent().click(function() {
	var $target = $(this).find("input[name='vmSeq']");
	$target.prop("checked", true);
});




$("#vmListTable").DataTable({
	dom : 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	aoColumns : [
		            {sWidth : "30px" },
		            {sWidth : "100px" },//상태
		            {sWidth : "30px" },//센터
		            {sWidth : "50px" },//존
		            {sWidth : "50px" },//망
		            {sWidth : "80px" },//자원풀
		            {sWidth : "70px" },//부처
		            {sWidth : "70px" },//업무
		            {sWidth : "150px" },//가상서버명
		            {sWidth : "100px" },//가상서버ID
		            {sWidth : "100px" },//가상서버구성ID
		            {sWidth : "100px" },//호스트명
		            {sWidth : "90px" },//IP주소
		            {sWidth : "60px" },//OS유형
		            {sWidth : "60px" },//가상화SW
		            {sWidth : "80px" }//생성일시
		 ],
	order : [ [ 0, "desc" ] ]
});

</script>
