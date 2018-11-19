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

<form:form commandName="rsrvSclngVo">

<div class="col-box-100 detail-col">
<!-- 수평형 테이블 -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">기본 정보</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>
		<div class="box-body no-padding">
	  		<table class="table table-horizon">
	  			<caption>스케일 예약설정 기본정보</caption>
	    		<colgroup>
					<col class="col10">
					<col class="col20">
					<col class="col10">
					<col class="col30">
					<col class="col10">
					<col class="col20">
	      		</colgroup>
				<tbody>
					<tr>
						<th>부처명</th>
						<td>
							<c:out value="${rsrvSclngVo.institutionNm}"></c:out>
						</td>
						<th>업무명</th>
						<td>
							<c:out value="${rsrvSclngVo.jobNm}"></c:out>
						</td>
						<th>센터</th>
						<td>
							<c:out value="${rsrvSclngVo.regionNm}"></c:out>
						</td>
		            </tr>
		            <tr>
						<th>존</th>
						<td>
							<c:out value="${rsrvSclngVo.zoneNm}"></c:out>
						</td>

						<th>망구분</th>
						<td>
							<c:out value="${rsrvSclngVo.netNm}"></c:out>
						</td>

						<th>자원풀</th>
						<td>
							<c:out value="${rsrvSclngVo.rsrcPoolNm}"></c:out>
						</td>


		            </tr>
				</tbody>
			</table>
		</div>
	</div>
	<!-- 수평형 테이블 -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">스케일 예약정보</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>
		<div class="box-body no-padding">
	  		<table class="table table-horizon">
	  			<caption>스케일 예약설정 상세</caption>
	    		<colgroup>
					<col class="col10">
					<col class="col20">
					<col class="col10">
					<col class="col30">
					<col class="col10">
					<col class="col20">

	      		</colgroup>
				<tbody>
					<tr>
						<th><span class="text-red">*</span>예약명</th>
						<td>
							<form:hidden path="scalrId" title="스케일러Id"/>
							<form:input path="scalrNm" title="예약명" cssClass="form-control essential"  />
						</td>
						<th><span class="text-red">*</span>예약일자</th>
						<td>
							<fmt:parseDate var="parsedStrtDate" value="${rsrvSclngVo.rsrvStrtDt}" pattern="yyyyMMdd" />
		                    <fmt:formatDate var="rsrvStrtDtFormat" value="${parsedStrtDate}" pattern="yyyy-MM-dd"/>
							<div class="input-group period period-start">
								<form:input path="rsrvStrtDt" title="예약시작일"  cssClass="form-control datepicker essential" value="${rsrvStrtDtFormat}" onchange="initDate(this, 'rsrvEndDt', 'S')"/>
							</div>
							<fmt:parseDate var="parsedEndDate" value="${rsrvSclngVo.rsrvEndDt}" pattern="yyyyMMdd" />
		                    <fmt:formatDate var="rsrvEndDtFormat" value="${parsedEndDate}" pattern="yyyy-MM-dd"/>
							<div class="input-group period period-end">
								<form:input path="rsrvEndDt"  title="예약종료일"  cssClass="form-control datepicker essential" value="${rsrvEndDtFormat}" onchange="initDate(this, 'rsrvStrtDt', 'E')"/>
							</div>
						</td>
						<th><span class="text-red">*</span>사용여부</th>
						<td>
							<form:select path="useYn"  class="form-control input-sm essential" title="사용여부" >
								<form:option value="">선택하세요.</form:option>
								<form:option value="Y">사용</form:option>
								<form:option value="N">미사용</form:option>
							</form:select>
						</td>
		            </tr>
		            <tr>
						<th>서비스명</th>
						<td>
							<div class="input-group">
								<form:hidden path="servcSeq" title="서비스SEQ"/>
								<form:input path="servcNm"  title="서비스명" cssClass="form-control input-sm essential" disabled="true" value=""/>
							</div>
						</td>

						<th><span class="text-red">*</span>Pod수</th>
						<td>
							<input type="number" id="maxPodQty" name="maxPodQty" title="Pod수" oninput="maxLengthCheck(this);" maxlength="2" class="form-control input-sm essential" value="${rsrvSclngVo.maxPodQty }"/>
						</td>

						<th>등록자</th>
						<td>
							<c:out value="${rsrvSclngVo.creUserNm}"></c:out>
						</td>


		            </tr>
		             <tr>

						<th>등록일시</th>
						<td>
							<c:out value="${rsrvSclngVo.creDttm}"></c:out>
						</td>

						<th>수정자</th>
						<td>
						<form:hidden path="updtUserId" title="수정자"/>
							<c:out value="${rsrvSclngVo.updtUserNm}"></c:out>
						</td>

						<th>수정일시</th>
						<td>
							<c:out value="${rsrvSclngVo.updtDttm}"></c:out>
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
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" data-original-title="뒤로" onclick="fn_selectRsrvSclngList();"><i class="fa fa-arrow-left"></i></button>
		</div>
		<div class="pull-right btns">
			<menu:authorize>
				<button class="btn btn-sm btn-hover-blue" data-toggle="tooltip"  data-original-title="저장"  onclick="fn_updateRsrvSclng();"><i class="fa fa-check"></i></button>
			</menu:authorize>
			<menu:authorize>
				<button id = "deleteSclBtn" class="btn btn-sm btn-hover-red" data-toggle="tooltip" data-original-title="삭제" onclick="fn_deleteScl();"><i class="fa fa-minus"></i></button>
			</menu:authorize>
		</div>
	</div>
</div>

<script type="text/javascript">
$(document).bind('selectDistrb', setDistrb);


//대상조회 팝업창에서 선택한 정보 설정
function setDistrb(evt) {
	var val = evt.datas;
	$('#rsrvSclngVo input[name="servcNm"]').val(val.servcNm);
	$('#rsrvSclngVo input:hidden[name="servcSeq"]').val(val.servcSeq);

}

//뒤로
function fn_selectRsrvSclngList(){
	location.href = '<c:url value="selectRsrvSclngList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'servcSeq' && pageParam.key ne 'scalrId'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
}
//저장 버튼 클릭 시
function fn_updateRsrvSclng(){

	if(!fn_form_validation("rsrvSclngVo")){
		return;
	}
	var podQty = $("#maxPodQty").val();
	var nowDate = new Date();
	var year = nowDate.getFullYear();
	var month = nowDate.getMonth()+1;
	var day = nowDate.getDate();
	var curDate = new Date(year,month,day);
 	var curFormat = curDate.getFullYear()+"-"+curDate.getMonth()+"-"+ curDate.getDate()
	var startDate = $("#rsrvStrtDt").val();
	var endDate = $("#rsrvEndDt").val();

	var startDateArr = startDate.split("-");
	var endDateArr = endDate.split("-");

	var startDateCompare = new Date(startDateArr[0],startDateArr[1],startDateArr[2]);
	var endDateCompare = new Date(endDateArr[0],endDateArr[1],endDateArr[2]);

	if( curDate > endDateCompare.getTime()){
		jAlert("예약종료일이 현재일자("+curFormat+")보다 작습니다. ", function() {$("#rsrvStrtDt").focus(); } );
		return;
	}else if(startDateCompare.getTime() > endDateCompare.getTime()){
		jAlert("예약 시작일이 예약종료일 보다 큽니다. ", function() {$("#rsrvStrtDt").focus(); } );
		return;
	}

	if(podQty <= 0){
		jAlert("Pod수는 0 이거나  0 보다 작을 수 없습니다. ", function() {$("#maxPodQty").focus(); } );
		return;
	}

	jConfirm('스케일예약설정을 저장 하시겠습니까?', function(){

		var options = {
			type: 'post',
			dataType: 'json',
			success: updateRsrvSclngResultHandler,
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

		$('#rsrvSclngVo').attr('action', '<c:url value="updateAtmSclRsrvSclng.do"/>');
		$('#rsrvSclngVo').ajaxSubmit(options);

	});
}

//저장 결과 콜백
function updateRsrvSclngResultHandler(result){

	if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

	if(result.success){
		jInfo("저장되었습니다.", function(){
			if(result.procType == "update") {
				location.href = '<c:url value="selectRsrvSclngList.do"/>';
			}
		});
	}
	else{
		jAlert(result.messageList);
	}
}

function maxLengthCheck(data){
	if(data.value.length > data.maxLength){
		data.value = data.value.slice(0,data.maxLength)
	}
}

//삭제버튼 클릭 시
function fn_deleteScl() {
	var sclNm = $("#scalrNm").val();
	jConfirm('스케일예약설정('+sclNm+')을 삭제 하시겠습니까?', function(){
		$.ncmsLoding.startFullScreen();
		$.post('deleteSclYn.do', $('#rsrvSclngVo').serialize(), function(result) {

			jInfo(result.messageList, function() {
				if( result.success) {
					location.href = '<c:url value="selectRsrvSclngList.do"/>';
				}
			});

		}, 'json').always(function(){$.ncmsLoding.remove();});
	});
}

</script>
