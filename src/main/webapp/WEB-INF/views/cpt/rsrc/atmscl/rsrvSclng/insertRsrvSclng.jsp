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
<!-- 등록/상세 영역 -->
<div class="col-box-100 detail-col">

	<!-- 수평형 테이블 -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">스케일 예약생성</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>
		<div class="box-body no-padding">
	  		<table class="table table-horizon">
	  			<caption>스케일 예약 정보</caption>
	    		<colgroup>
					<col class="col10">
					<col class="col20">
					<col class="col10">
					<col class="col20">
					<col class="col10">
					<col class="col20">
	      		</colgroup>
				<tbody>
					<tr>
						<th><label for="scalrNm"><span class="text-red">*</span>예약명</label></th>
						<td>
							<form:input path="scalrNm" title="예약명" cssClass="form-control essential" value=""/>
						</td>
						<th><label for="maxPodQty"><span class="text-red">*</span>Pod수</label></th>
						<td>
							<input type="number" id="maxPodQty" name="maxPodQty" title="Pod수" class="form-control essential onlyInteger" oninput="maxLengthCheck(this);" maxlength="2" value=""/>
						</td>

						<th><label for="useYn"><span class="text-red">*</span>사용여부</label></th>
						<td>
							<form:select path="useYn"  class="form-control input-sm essential" title="사용여부" >
								<form:option value="">선택하세요.</form:option>
								<form:option value="Y">사용</form:option>
								<form:option value="N">미사용</form:option>
							</form:select>
						</td>
		            </tr>
		            <tr>
						<th><label for="servcNm"><span class="text-red">*</span>서비스명</label></th>
						<td>
							<div class="input-group">
								<form:hidden path="servcSeq" title="서비스SEQ"/>
								<form:input path="servcNm"  title="서비스명" cssClass="form-control essential" disabled="true" value=""/>
								<div class="input-group-btn">
									<button type="button" data-toggle="tooltip" title="검색" data-original-title="검색" class="btn"  onclick="openBldListSearch()"><i class="fa fa-search"></i></button>
								</div>
							</div>
						</td>
						<th><span class="text-red">*</span>예약일자</th>
						<td colspan="3">
							<div class="input-group period period-start">
								<form:input path="rsrvStrtDt" title="예약시작일"  cssClass="form-control datepicker essential" value="" onchange="initDate(this, 'rsrvEndDt', 'S')"/>
							</div>
							<div class="input-group period period-end">
								<form:input path="rsrvEndDt"  title="예약종료일"  cssClass="form-control datepicker essential" value="" onchange="initDate(this, 'rsrvStrtDt', 'E')"/>
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
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" data-original-title="뒤로" onclick="fn_selectRsrvSclngList();"><i class="fa fa-arrow-left"></i></button>
		</div>
		<div class="pull-right btns">
			<menu:authorize>
				<button class="btn btn-sm btn-hover-blue" data-toggle="tooltip"  data-original-title="저장" onclick="fn_insertRsrvSclng();"><i class="fa fa-check"></i></button>
			</menu:authorize>
		</div>
	</div>
</div>

<script type="text/javascript">
$(document).bind('selectDistrb', setDistrb);
//업무선택 호출 (팝업)
function fn_selectDistrbListP() {
	var url = '<c:url value="selectDistrbListViewP.do"/>';
	var params = {"searchType" : "S"};
	var args = {
		key : "대상선택",
		width : 740,
		height : 820
	};
	windowOpen(url, params, args);
}

//업무선택 팝업창에서 선택한 정보 설정
function setDistrb(evt) {
	var val = evt.datas;
	$('#rsrvSclngVo input[name="servcNm"]').val(val.servcNm);
	$('#rsrvSclngVo input:hidden[name="servcSeq"]').val(val.servcSeq);

}

//뒤로
function fn_selectRsrvSclngList(){
	location.href = '<c:url value="selectRsrvSclngList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'servcSeq'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
}
//생성 버튼 클릭 시
function fn_insertRsrvSclng(){

	if(!fn_form_validation("rsrvSclngVo")){
		return;
	}

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

	if(curDate > startDateCompare.getTime()){
		jAlert("예약시작일은 현재일자("+curFormat+") 이후만 가능합니다. ", function() {$("#rsrvStrtDt").focus(); } );
		return;
	}else if( curDate > endDateCompare.getTime()){
		jAlert("예약종료일은 현재일자("+curFormat+") 이후만 가능합니다. ", function() {$("#rsrvEndDt").focus(); } );
		return;
	}else if(startDateCompare.getTime() > endDateCompare.getTime()){
		jAlert("예약 시작일이 예약종료일 보다 큽니다.. ");
		return;
	}


	 jConfirm('스케일예약설정 하시겠습니까?', function(){


		var options = {
			type: 'post',
			dataType: 'json',
			success: insertRsrvSclngResultHandler,
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

		$('#rsrvSclngVo').attr('action', '<c:url value="insertRsrvSclng.do"/>');
		$('#rsrvSclngVo').ajaxSubmit(options);

	});
}

//생성 결과 콜백
function insertRsrvSclngResultHandler(result){

	if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

	if(result.success){
		jInfo(result.messageList, function(){
			fn_selectRsrvSclngList();
		});
	}
	else{
		alert_message(result.messageList)
	}
}
function openBldListSearch() {
	var url = '<c:url value="selectDistrbListViewP.do"/>';
	var params = {"searchType" : "S"};
	var args = {key:"대상조회", width:1280,height:800};
	windowOpen(url, params, args);
}
function maxLengthCheck(data){
	if(data.value.length > data.maxLength){
		data.value = data.value.slice(0,data.maxLength)
	}
}
</script>
