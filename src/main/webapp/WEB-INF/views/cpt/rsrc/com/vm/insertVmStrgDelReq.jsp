<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>가상서버 스토리지 삭제 요청 화면</pre>
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

<!-- 등록/상세 영역 -->
<div class="col-box-100 detail-col">
	<form:form commandName="rsrcReqVo">
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
							<form:input path="sbjct" name="sbjct" title="제목" cssClass="form-control input-sm essential" value=""/>
						</td>
						<th><span class="text-red">*</span>테스트여부</th>
						<td>
							<div class="input-group input-group-radio">
								<form:radiobutton path="testYn" name="testYn" title="테스트여부" cssClass="essential" label="예" value="Y"/>
								<form:radiobutton path="testYn" name="testYn" title="테스트여부" cssClass="essential" label="아니오" value="N"/>
							</div>
						</td>
					</tr>
					<tr>
						<th><span class="text-red">*</span>티켓번호</th>
						<td colspan="3">
							<form:input path="ticktNo" name="ticktNo" title="티켓번호" cssClass="form-control input-sm essential" value=""/>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<!-- 수평형 테이블 -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">스펙변경할 가상서버 정보</h3>
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
						<th>가상서버명</th>
						<td>
							<form:hidden path="regionId" name="regionId" title="센터" value="${vmVo.regionId }"/>
							<form:hidden path="rsrcReqVmVoList[0].vmCompId" name="rsrcReqVmVoList[0].vmCompId" title="가상서버구성ID" value="${vmVo.vmCompId }"/>
							<c:out value="${vmVo.vmNm }"/>
						</td>
						<th>가상서버ID</th>
						<td>
							<c:out value="${vmVo.vmId }"/>
						</td>
					</tr>
					<tr>
						<th>CPU vCore</th>
						<td>
							<c:out value="${vmVo.cpuVcoreQty }"/>
						</td>
						<th>메모리 (GB)</th>
						<td>
							<c:out value="${vmVo.memAsgnCapa }"/>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<!-- 수평형 테이블 -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title"><span class="text-red">*</span>스펙 선택</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>
		<div class="box-body no-padding">
			<table class="table table-hover table-vertical">
				<caption>요청정보</caption>
					<colgroup>
						<col class="col5">
						<col class="colAuto">
						<col class="col10">
						<col class="col10">
					</colgroup>
					<thead>
						<tr>
							<th></th>
							<th>스펙명</th>
							<th>CPU vCore</th>
							<th>메모리 (GB)</th>
						</tr>
					</thead>
					<tbody>
					<tr>
						<td>
							<form:radiobutton path="rsrcReqVmVoList[0].reqSpecId" name="rsrcReqVmVoList[0].reqSpecId" title="스펙 선택" cssClass="essential" onclick="fn_selectSpec(this);" value=""/>
						</td>
						<td class="alignL">사용자 정의</td>
						<td>
							<form:input path="rsrcReqVmVoList[0].reqcpuVcoreQty" name="rsrcReqVmVoList[0].reqcpuVcoreQty" cssClass="onlyNumber alignR" title="사용자 정의 CPU vCore" value=""/>
						</td>
						<td>
							<form:input path="rsrcReqVmVoList[0].reqMem" name="rsrcReqVmVoList[0].reqMem" cssClass="onlyNumber alignR" title="사용자 정의 메모리 (GB)" value=""/>
						</td>
					</tr>
					<c:forEach var="specVo" items="${specVoList }" varStatus="i">
						<tr>
							<td>
								<form:radiobutton path="rsrcReqVmVoList[0].reqSpecId" name="rsrcReqVmVoList[0].reqSpecId" title="스펙" cssClass="essential" onclick="fn_selectSpec(this);" value="${specVo.specId }"/>
							</td>
							<td class="alignL"><c:out value="${specVo.specNm }"/></td>
							<td class="alignR"><c:out value="${specVo.cpuVcoreQty }"/></td>
							<td class="alignR"><c:out value="${specVo.mem }"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	</form:form>
</div>

<!-- 페이지 버튼 영역 -->
<div class="col-box-100">
	<div class="edit-btn-group">
		<div class="pull-left btns">
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="뒤로" data-original-title="뒤로" onclick="fn_selectVmList();"><i class="fa fa-arrow-left"></i></button>
		</div>
		<div class="pull-right btns">
			<menu:authorize>
				<button class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="요청" data-original-title="요청" onclick="fn_insertVmSpecModReq();"><i class="fa fa-check"></i></button>
			</menu:authorize>
		</div>
	</div>
</div>

<script type="text/javascript">

function fn_selectSpec(dom){
	if($(dom).val()){
		$('#rsrcReqVmVoList0\\.reqcpuVcoreQty').removeClass('essential');
		$('#rsrcReqVmVoList0\\.reqMem').removeClass('essential');
	}
	else{
		$('#rsrcReqVmVoList0\\.reqcpuVcoreQty').addClass('essential');
		$('#rsrcReqVmVoList0\\.reqMem').addClass('essential');
	}

}

//뒤로
function fn_selectVmList(){
	location.href = '<c:url value="selectVmList.do"/>';
}

function fn_insertVmSpecModReq(){

	if(!fn_form_validation("rsrcReqVo")){
		return;
	}

	jConfirm('가상서버 스펙을 변경 요청하시겠습니까?', function(){

		var options = {
			type: 'post',
			dataType: 'json',
			success: insertVmSpecModReqResultHandler,
			beforeSend: function() {

			},
			error: function(xhr, textStatus, errorThrown){
				jAlert('오류가 발생하였습니다.');
			}
		};

		$('#rsrcReqVo').attr('action', 'insertVmSpecModReq.do');
		$('#rsrcReqVo').ajaxSubmit(options);

	});
}

function insertVmSpecModReqResultHandler(result){

	if(result.success){
		jInfo(result.messageList, function(){
			location.href = '<c:url value="selectVmList.do"/>';
		});
	}
	else{
		jAlert(result.messageList);
	}

}
</script>
