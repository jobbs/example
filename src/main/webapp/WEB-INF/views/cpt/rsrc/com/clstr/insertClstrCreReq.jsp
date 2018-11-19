<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>클러스터 생성 요청 화면</pre>
 *
 * @author 심원보
 * @lastmodifier 심원보
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     심원보         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<form:form commandName="rsrcReqVo">
<!-- 등록/상세 영역 -->
<div class="col-box-100 detail-col">
	<c:set var="rsrcReqVoClass" value="ncis.cpt.rsrc.com.vo.RsrcReqVo"/>
	<c:set var="rsrcReqPhyRsrcVoClass" value="ncis.cpt.rsrc.com.vo.RsrcReqPhyRsrcVo"/>
	<c:set var="groupClass" value="ncis.cpt.rsrc.com.validation.InsertClstrCreReqValidation"/>

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
	  			<caption>요청정보</caption>
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
							<form:input path="sbjct" name="sbjct" title="제목" cssClass="form-control essential" value="" maxlength="${ivu.getMaxlength(rsrcReqVoClass, 'sbjct', groupClass)}"/>
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
							<form:input path="ticktNo" name="ticktNo" title="티켓번호" cssClass="form-control essential" value="" maxlength="${ivu.getMaxlength(rsrcReqVoClass, 'ticktNo', groupClass)}"/>
						</td><td></td><td></td>
		            </tr>
				</tbody>
			</table>
		</div>
	</div>

	<!-- 수평형 테이블 -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">생성할 클러스터 정보</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>
		<div class="box-body no-padding">
	  		<table class="table table-horizon">
	  			<caption>생성할 클러스터 정보</caption>
	    		<colgroup>
					<col class="col20">
					<col class="col30">
					<col class="col20">
					<col class="col30">
				</colgroup>
				<tbody>
					<tr>
						<th><span class="text-red">*</span>센터</th>
						<td>
							<nform:selectRegion path="regionId" name="regionId" id="regionId" title="센터" cssClass="form-control essential" wholeText="센터을 선택해주세요" onchange="selectZoneDy(this, 'rsrcReqPhyRsrcVoList0\\\\.zoneId' )" />
						</td>
						<th><span class="text-red">*</span>존</th>
						<td>
							<nform:selectZone path="rsrcReqPhyRsrcVoList[0].zoneId" name="rsrcReqPhyRsrcVoList[0].zoneId" id="rsrcReqPhyRsrcVoList0.zoneId" title="존" cssClass="form-control essential" wholeText="존을 선택해주세요" onchange="selectNetDy(this, 'rsrcReqPhyRsrcVoList0\\\\.netId' )" />
						</td>
					</tr>
					<tr>
						<th><span class="text-red">*</span>망</th>
						<td>
							<nform:selectNet path="rsrcReqPhyRsrcVoList[0].netId" name="rsrcReqPhyRsrcVoList[0].netId" id="rsrcReqPhyRsrcVoList0.netId" title="망" cssClass="form-control essential" wholeText="망을 선택해주세요" onchange="selectPoolDy(this, 'rsrcReqPhyRsrcVoList0\\\\.regionId', 'rsrcReqPhyRsrcVoList0\\\\.zoneId', 'rsrcReqPhyRsrcVoList0\\\\.rsrcPoolId', {searchPoolTypeCd : '01', 'searchCtlTrgtYn' : 'Y'})" />
						</td>
						<th><span class="text-red">*</span>자원풀</th>
						<td>
							<nform:selectPool path="rsrcReqPhyRsrcVoList[0].rsrcPoolId" name="rsrcReqPhyRsrcVoList[0].rsrcPoolId" id="rsrcReqPhyRsrcVoList0.rsrcPoolId" title="자원풀" cssClass="form-control essential" poolTypeCd="01" ctlTrgtYn="Y" wholeText="자원풀을 선택해주세요" />
						</td>
					</tr>
					<tr>
						<th><span class="text-red">*</span>클러스터명</th>
						<td>
							<form:input path="rsrcReqPhyRsrcVoList[0].clstrNm" name="rsrcReqPhyRsrcVoList[0].clstrNm" title="클러스터명" cssClass="form-control essential" maxlength="${ivu.getMaxlength(rsrcReqPhyRsrcVoClass, 'clstrNm', groupClass)}"/>
						</td>
						<th>클러스터구성ID</th>
						<td>
							<form:input path="rsrcReqPhyRsrcVoList[0].clstrCompId" name="rsrcReqPhyRsrcVoList[0].clstrCompId" title="클러스터구성ID" cssClass="form-control" maxlength="${ivu.getMaxlength(rsrcReqPhyRsrcVoClass, 'clstrCompId', groupClass)}"/>
						</td>
					</tr>
					<tr>
						<th><span class="text-red">*</span>용도</th>
						<td colspan="3">
							<div class="input-group input-group-check">
								<c:forEach var="prposClCd" items="${prposClCdList }">
									<form:checkbox path="rsrcReqPhyRsrcVoList[0].clstrPrposCdList" name="rsrcReqPhyRsrcVoList[0].clstrPrposCdList" title="용도" cssClass="essentialBy" essentialBy="rsrcReqPhyRsrcVoList[0].clstrPrposCdList" value="${prposClCd.cd}" id="${prposClCd.cd}"/>
									<label for="${prposClCd.cd}"><c:out value="${prposClCd.cdNm}"/></label>
								</c:forEach>
							</div>
						</td>
					</tr>
                </tbody>
			</table>
		</div>
	</div>
</div>
</form:form>

<!-- 페이지 버튼 영역 -->
<div class="col-box-100">
	<div class="edit-btn-group">
		<div class="pull-left btns">
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="뒤로" data-original-title="뒤로" onclick="fn_selectClstrList();"><i class="fa fa-arrow-left"></i></button>
		</div>
		<div class="pull-right btns">
			<menu:authorize onlyOprAdm="true">
				<button class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="요청" data-original-title="요청"  onclick="fn_insertClstrCreReq();"><i class="fa fa-check"></i></button>
			</menu:authorize>
		</div>
	</div>
</div>

<script type="text/javascript">
//뒤로
function fn_selectClstrList(){
	location.href = '<c:url value="selectClstrList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'clstrSeq'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
}

function fn_insertClstrCreReq(){

	if(!fn_form_validation("rsrcReqVo")){
		return;
	}

	jConfirm('클러스터를 생성 요청하시겠습니까?', function(){

		var options = {
			type: 'post',
			dataType: 'json',
			success: insertClstrCreReqResultHandler,
			beforeSend: function() {
				$.ncmsLoding.startFullScreen();
			},
			complete : function() {
				$.ncmsLoding.remove();
			},
			error: function(xhr, textStatus, errorThrown){
				jAlert('오류가 발생하였습니다.');
			}
		};

		$('#rsrcReqVo').attr('action', '<c:url value="insertClstrCreReq.do"/>');
		$('#rsrcReqVo').ajaxSubmit(options);

	});
}

function insertClstrCreReqResultHandler(result){

	if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

	if(result.success){
		jInfo(result.messageList, function(){
			fn_selectClstrList();
		});
	}
	else{
		alert_message(result.messageList, function(){
			if(result.data != null){
				var inputName = getDomName(result.data);
				setTimeout(function(){$(inputName).focus();}, 0);
			}
		});
	}

}

function getDomName(obj){
	return ((obj.child != null) ? ('[name*="' + obj.name + '"]' + getDomName(obj.child)) : ('[name*="' + obj.name + '"]'));
}

</script>
