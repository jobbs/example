<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>
 	물리서버 추가 요청
 </pre>
 *
 * @author 최경철
 * @lastmodifier 최경철
 * @created 2016. 10. 18.
 * @lastmodified 2016. 10. 18.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 18.     최경철         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<script type="text/javascript" src="<c:url value="/resources/js/common/ncms_common.js" />"></script>
<c:url var="selectUrl" value="/cpt/rsrc/com/pm/selectClstrListP.do"></c:url>

<c:set var="rsrcReqVoClass" value="ncis.cpt.rsrc.com.vo.RsrcReqVo"/>
<c:set var="rsrcReqPmVoClass" value="ncis.cpt.rsrc.com.vo.RsrcReqPmVo"/>
<c:set var="groupClass" value="ncis.cpt.rsrc.com.validation.InsertPmCreReqValidation"/>

<!-- 등록/상세 영역 -->
<div class="col-box-100 detail-col">
	<form:form commandName="rsrcReqVo">

	<form:hidden name="rsrcReqPmVoList[0].clstrSeq" path="rsrcReqPmVoList[0].clstrSeq" id="rsrcReqPmVoList[0].clstrSeq" title="클러스터SEQ" />

	<!-- 수평형 테이블 -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">요청정보</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>
		<div class="box-body no-padding">
	  		<table class="table table-horizon">
	  		<caption>물리서버 생성 요청 정보 테이블</caption>
	    		<colgroup>
						<col class="col20">
						<col class="col30">
						<col class="col20">
						<col class="col30">
      		</colgroup>
				<tbody>
					<tr>
						<th><span class="text-red">*</span>제목</th>
						<td>
							<form:input path="sbjct" name="sbjct" cssClass="form-control input-sm essential" title="제목" value="" maxlength="${ivu.getMaxlength(rsrcReqVoClass, 'sbjct', groupClass)}"/>
						</td>
						<th><span class="text-red">*</span>테스트여부</th>
						<td class="alignL">
							<div class="input-group input-group-radio">
								<form:radiobutton path="testYn" name="testYn" title="테스트여부" cssClass="essential" label="예" value="Y"/>
								<form:radiobutton path="testYn" name="testYn" title="테스트여부" cssClass="essential" label="아니오" value="N"/>
							</div>
						</td>
		            </tr>
		            <tr>
						<th><span class="text-red">*</span>티켓번호</th>
						<td>
							<form:input path="ticktNo" name="ticktNo" cssClass="form-control input-sm essential" title="티켓번호" value="" maxlength="${ivu.getMaxlength(rsrcReqVoClass, 'ticktNo', groupClass)}"/>
						</td>
						<td colspan="2"></td>
		            </tr>
		            <tr>
						<th><span class="text-red">*</span>물리서버명</th>
						<td>
							<form:input path="rsrcReqPmVoList[0].pmNm" name="rsrcReqPmVoList[0].pmNm" title="물리서버명" cssClass="form-control input-sm essential" value="" maxlength="${ivu.getMaxlength(rsrcReqPmVoClass, 'pmNm', groupClass)}"/>
						</td>
						<th>물리서버 구성ID</th>
						<td>
							<form:input path="rsrcReqPmVoList[0].pmCompId" name="rsrcReqPmVoList[0].pmCompId" title="물리서버 구성ID" cssClass="form-control input-sm" value="" maxlength="${ivu.getMaxlength(rsrcReqPmVoClass, 'pmCompId', groupClass)}"/>
						</td>
					</tr>
					<tr>
						<th><span class="text-red">*</span>IP주소</th>
						<td>
							<form:input path="rsrcReqPmVoList[0].ipAddr" name="rsrcReqPmVoList[0].ipAddr" title="IP주소" cssClass="form-control input-sm onlyIp essential" value="" maxlength="${ivu.getMaxlength(rsrcReqPmVoClass, 'ipAddr', groupClass)}"/>
						</td>
						<td colspan="3"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	</form:form>

</div>

<!-- 그리드 영역 -->
<div class="col-box-100 detail-col">
		<div class="box detail-list-box">

			<div class="box-header">
				<h3 class="box-title">대상 클러스터</h3>
				<div class="box-tools">
					<div class="input-group-box">
					<form:form commandName="clstrSearchVo" method="get">
			          	<div class="input-group-cell pad-right-5">
		            	  <label title="자원풀">자원풀</label>
			          	</div>
			         	<div class="input-group-cell pad-right-5">
			              <div class="input-group">
		                	  <nform:selectRegion name="equalsRegionId" id="equalsRegionId" title="센터" wholeText="센터을 선택하세요" cssClass="form-control input-sm" value="${clstrSearchVo.equalsRegionId}" whole="true" onchange="selectZoneByNetClCd('equalsRegionId', 'equalsZoneId', 'equalsNetClCd', 'equalsRsrcPoolId')" />
			              </div>
			          	</div>
			          <div class="input-group-cell pad-right-5">
			              <div class="input-group">
		                  	<nform:selectZone name="equalsZoneId" id="equalsZoneId" title="존" wholeText="존을 선택하세요" cssClass="form-control input-sm" whole="true" regionId="${clstrSearchVo.equalsRegionId}" value="${clstrSearchVo.equalsZoneId}" onchange="selectPoolByNetClCd('equalsRegionId', 'equalsZoneId', 'equalsNetClCd', 'equalsRsrcPoolId', {'searchPoolTypeCd':'01', 'searchCtlTrgtYn' : 'Y'} )" />
			              </div>
			          </div>
			          <div class="input-group-cell pad-right-5">
			              <div class="input-group">
		                  	<nform:selectCode parentCd="NETCD" parentGrpCd="067" name="equalsNetClCd" id="equalsNetClCd" title="망구분" wholeText="망구분을 선택하세요" cssClass="form-control input-sm" whole="true" zoneId="${clstrSearchVo.equalsZoneId}" value="${clstrSearchVo.equalsNetClCd}" onchange="selectPoolByNetClCd('equalsRegionId', 'equalsZoneId', 'equalsNetClCd', 'equalsRsrcPoolId', {'searchPoolTypeCd':'01', 'searchCtlTrgtYn' : 'Y'} )" />
			              </div>
			          </div>
			          <div class="input-group-cell pad-right-5">
			              <div class="input-group">
		                  	<nform:selectPool name="equalsRsrcPoolId" id="equalsRsrcPoolId" title="자원풀" wholeText="자원풀을 선택하세요" cssClass="form-control input-sm" whole="true" poolTypeCd="01" ctlTrgtYn="Y" regionId="${clstrSearchVo.equalsRegionId }" zoneId="${clstrSearchVo.equalsZoneId}" netClCd="${clstrSearchVo.equalsNetClCd }" value="${clstrSearchVo.equalsRsrcPoolId}"/>
			              </div>
			          </div>
					</form:form>
			        <div class="input-group-cell">
		              	<button class="btn btn-sm btn-function" title="조회" onclick="fn_selectClstrInfoList('true');">조회</button>
			        </div>
			      	</div>
				</div>
			</div>

			<form id="frm" name="frm">
			<div class="box-body no-padding detail-list-body" id="clstrInfoDiv" >
				<table class="table table-vertical">
				<caption>안내 문구 테이블</caption>
					<tbody>
					  <tr>
					    <td class="alignC" ><font size="3">조회 버튼을 클릭하시기 바랍니다.</font></td>
					  </tr>
					</tbody>
				</table>
			</div>
			</form>

			<div class="box-footer clearfix">
				<div class="pull-right">
<%-- 					<menu:authorize> --%>
<!-- 						<button type="button" class="btn btn-sm btn-function" title="요청하기" onclick="fn_insertPmCreReq();">요청하기</button> -->
<%-- 					</menu:authorize> --%>
				</div>
			</div>
		</div>
</div>

<!-- 페이지 버튼 영역 -->
<div class="col-box-100">
	<div class="edit-btn-group">
		<div class="pull-left btns">
			<button type="button" class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="뒤로" data-original-title="뒤로" onclick="fn_selectPmList();"><i class="fa fa-arrow-left"></i></button>
		</div>
		<div class="pull-right btns">
			<menu:authorize onlyOprAdm="true">
				<button class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="요청" data-original-title="요청"  onclick="fn_insertPmCreReq();"><i class="fa fa-check"></i></button>
			</menu:authorize>
		</div>
	</div>
</div>

<script type="text/javascript">

// window.onload = fn_selectClstrInfoList;

//뒤로
function fn_selectPmList(){
	location.href = '<c:url value="selectPmList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'pmSeq'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
}

//클러스터 정보 조회
function fn_selectClstrInfoList(isClick){

	var url = '${selectUrl}';
	var data = getContainerData($('#clstrSearchVo'));
	$.ncmsLoding.start('#clstrInfoTable');
	$.get(url,data,loadSuccessHandler,'html').always(function() {
		$('#clstrInfoTable th:not(.notellipsis)').addClass('ellipsis');
		$('#clstrInfoTable td:not(.notellipsis)').addClass('ellipsis');
		$.ncmsLoding.remove();
	});;

}

function loadSuccessHandler(data){
	$('#clstrInfoDiv').html(data);
}

// 물리서버 추가요청
function fn_insertPmCreReq(){

	if(!fn_form_validation("rsrcReqVo")){
		return;
	}
	if($('input:radio[name="clstrSeq"]:checked').length == 0){
		jAlert("대상 클러스터 정보를 검색하고 선택해주세요.");
		return;
	}

	document.getElementById('rsrcReqPmVoList[0].clstrSeq').value = $('input:radio[name="clstrSeq"]:checked').val();

	jConfirm('물리서버를 추가 요청하시겠습니까?', function(){

		var options = {
			type: 'post',
			dataType: 'json',
			success: insertPmCreReqResultHandler,
			beforeSend : function() {
				$.ncmsLoding.startFullScreen();
			},
	        complete : function() {
	        	$.ncmsLoding.remove();
			},
			error: function(xhr, textStatus, errorThrown){
				jAlert('오류가 발생하였습니다.');
			}
		};

		$('#rsrcReqVo').attr('action', 'insertPmAddReq.do');
		$('#rsrcReqVo').ajaxSubmit(options);

	});
}

function insertPmCreReqResultHandler(result){

	if(result.success){
		jInfo(result.messageList, function(){
			location.href = '<c:url value="selectPmList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'pmSeq'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
		});
	}
	else{
		jAlert(result.messageList);
	}
}


</script>