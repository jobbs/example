<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>서비스영역 수정 화면</pre>
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
 * 2016. 10. 13.     x         v1.0             최초생성
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

<div class="col-box-25 no-padding-right">
	<div class="col-info">
		<h3 class="col-info-header">CPU Core 수</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num" id="sumCpuCorQty"><fmt:formatNumber value="${servcAreaVo.sumCpuCorQty }" pattern="0"/></h4>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25 no-padding-right">
	<div class="col-info">
		<h3 class="col-info-header">CPU 사용률</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<c:if test='${"02" eq servcAreaVo.servcAreaClCd}'>
					<h4 class="num" id="avgCpuUseRt"><c:out value="${servcAreaVo.avgCpuUseRt }" /><small>%</small></h4>
				</c:if>
				<c:if test='${"02" ne servcAreaVo.servcAreaClCd}'>-</c:if>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25 no-padding-right">
	<div class="col-info">
		<h3 class="col-info-header">메모리 할당량</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<c:if test='${"02" eq servcAreaVo.servcAreaClCd}'>
					<h4 class="num" id="sumMemAsgnCapa"><c:out value="${servcAreaVo.sumMemAsgnCapa }" /><small>GB</small></h4>
				</c:if>
				<c:if test='${"02" ne servcAreaVo.servcAreaClCd}'>-</c:if>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25">
	<div class="col-info">
		<h3 class="col-info-header">메모리 사용률</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<c:if test='${"02" eq servcAreaVo.servcAreaClCd}'>
					<h4 class="num" id="avgMemUseRt"><c:out value="${servcAreaVo.avgMemUseRt }" /><small>%</small></h4>
				</c:if>
				<c:if test='${"02" ne servcAreaVo.servcAreaClCd}'>-</c:if>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25 no-padding-right">
	<div class="col-info">
		<h3 class="col-info-header">네트워크 In</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num" id="netwkIn"><fmt:formatNumber value="${servcAreaVo.netwkIn }" pattern="0.0"/><small>KB/Sec</small></h4>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25 no-padding-right">
	<div class="col-info">
		<h3 class="col-info-header">네트워크 Out</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num" id="netwkOut"><fmt:formatNumber value="${servcAreaVo.netwkOut }" pattern="0.0"/><small>KB/Sec</small></h4>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25 no-padding-right">
	<div class="col-info">
		<h3 class="col-info-header">Pod 수</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num" id="podQty"><fmt:formatNumber value="${servcAreaVo.podQty }" pattern="0"/></h4>
			</div>
		</div>
	</div>
</div>

<form:form id="servcAreaVo" commandName="servcAreaVo" action="updateServcArea.do">
<form:hidden path="servcAreaSeq" title="서비스영역SEQ"  />
<form:hidden path="servcAreaId" title="서비스영역ID"  />
<form:hidden path="regionId" title="센터"  />
<form:hidden path="zoneId" title="존"  />
<form:hidden path="netClCd" title="망"  />
<form:hidden path="limitId" title="제한설정ID"  />
<form:hidden path="quotaId" title="쿼터설정ID"  />
<form:hidden path="rsrcPoolId" title="자원풀ID"  />
<form:hidden path="quotaEditYn" title="쿼터변경여부"  />
<form:hidden path="limitEditYn" title="제한변경여부"  />


<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">기본 정보</h3>
		</div>
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>기본정보</caption>
				<colgroup>
					<col class="col10">
					<col class="col15">
					<col class="col10">
					<col class="col15">
					<col class="col10">
					<col class="col15">
					<col class="col10">
					<col class="col15">
				</colgroup>
				<tbody>
					<tr>
						<th><label for="servcAreaNm"><span class="text-red">*</span>서비스영역명</label></th>
					    <td colspan="5">
					        <form:input path="servcAreaNm" title="서비스영역명" cssClass="form-control essential" value="" maxlength="50"/>
					    </td>
					    <th><label for="servcAreaCompId">서비스영역ID</label></th>
					    <td>
					    	<c:out value="${servcAreaVo.servcAreaId }"/>
					    </td>
					</tr>
					<tr>
					    <th><label for="servcAreaCompId">서비스영역구성ID</label></th>
					    <td>
					        <form:input path="servcAreaCompId" title="서비스영역구성ID" cssClass="form-control" value="" maxlength="10"/>
					    </td>
					    <th>부처</th>
					    <td><input type="text" name="institutionNm" class="form-control" disabled="disabled" title="부처" value="<c:out value="${servcAreaVo.institutionNm }"/>"/></td>
					    <th><span class="text-red">*</span>업무</th>
	                    <td colspan="3">
	                        <div class="input-group">
	                            <form:hidden path="institutionId" title="부처"  />
	                            <form:hidden path="jobId" title="업무"  />
	                            <input type="text" name="jobNm" class="form-control essential" placeholder="업무를 선택해주세요" disabled="disabled" title="업무" value="<c:out value="${servcAreaVo.jobNm }"/>"/>
	                            <div class="input-group-btn">
	                                <button type="button" class="btn" data-toggle="tooltip" title="검색" data-original-title="검색" onclick="openJobeSearch();">
	                                    <i class="fa fa-search"></i>
	                                </button>
	                            </div>
	                        </div>
	                    </td>
					 </tr>
					 <tr>
					 	<th>센터</th>
						<td><c:out value="${servcAreaVo.regionNm }"/></td>
						<th>존</th>
						<td><c:out value="${servcAreaVo.zoneNm }"/></td>
						<th>망구분</th>
						<td><c:out value="${servcAreaVo.netNm }"/></td>
						<th>자원풀</th>
						<td><c:out value="${servcAreaVo.rsrcPoolNm }"/></td>
					</tr>
					<tr>
						<th>비고</th>
						<td colspan="7">
					    	<form:textarea path="rmk" cssClass="form-control" title="비고" rows="3" maxlength="1000" />
						</td>
					</tr>
					<tr>
						<th>생성자</th>
						<td><c:out value="${servcAreaVo.creUserNm }"/></td>
						<th>생성일시</th>
						<td><c:out value="${servcAreaVo.creDttm }"/></td>
						<th>수정자</th>
						<td><c:out value="${servcAreaVo.updtUserNm }"/></td>
						<th>수정일시</th>
						<td><c:out value="${servcAreaVo.updtDttm }"/></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

<!--  쿼터정보 시작  -->
<div class="col-box-100 detail-col">
	<div class="box">
        <div class="box-header">
           <h3 class="box-title">쿼터 정보(Quota)</h3>
        </div>
		<div class="box-body no-padding">
		    <table class="table table-horizon" id="quotaTable">
				<caption>서비스영역 쿼터 정보</caption>
				<colgroup>
					<col class="col10">
					<col class="col23">
					<col class="col10">
					<col class="col23">
					<col class="col10">
	                <col class="col24">
				</colgroup>
				<tbody>
				    <tr>
					    <th><label for="specClCd"><span class="text-red">*</span>스펙선택</label></th>
						<td colspan="5">
						    <div class="input-group">
							    <input type="text" name="specNm" id="specNm" class="form-control" placeholder="스펙을 선택해주세요" disabled="disabled" title="스펙명" >
							    <input type="hidden" name="selectSpecListPFlag" id="selectSpecListPFlag" value="">
							    <div class="input-group-btn">
							        <button type="button" class="btn" data-toggle="tooltip" title="" data-original-title="검색" onclick="fn_selectSpecListP();">
							            <i class="fa fa-search"></i>
							        </button>
					            </div>
								<div class="input-group-btn">
								    <input type="checkbox" id="quotaCheck" name="quotaCheck" onclick="fn_quotaToggle()" title="직접입력여부" /><label for="quotaCheck">직접입력</label>
								</div>
						    </div>
				        </td>
				    </tr>
					<tr>
					    <th><label for="reqCpuCorQty"><span class="text-red">*</span>요청 CPU(Core)</label></th>
					    <td>
					        <form:input path="reqCpuCorQty" type="number" class="form-control essential onlyInteger" step="1" min="1" max="256" title="요청 CPU" onblur="fn_checkData(this);" maxlength="3" readonly="true" />
					    </td>
					    <th><label for="lmttCpuCorQty"><span class="text-red">*</span>제한 CPU(Core)</label></th>
					    <td>
					        <form:input path="lmttCpuCorQty" type="number" class="form-control essential onlyInteger" step="1" min="1" max="256" title="제한 CPU" onblur="fn_checkData(this);" maxlength="3" readonly="true"  />
					    </td>
					    <th><label for="maxPodQty"><span class="text-red">*</span>최대 Pod 수</label></th>
                        <td>
                           <form:input path="maxPodQty" type="number" class="form-control essential onlyInteger" step="1" min="1" max="256" title="최대 Pod 수" onblur="fn_checkData(this);" maxlength="3" readonly="true"  />
                        </td>
					</tr>
					<tr>
					    <th><label for="reqMemCapa"><span class="text-red">*</span>요청 메모리(GB)</label></th>
					    <td>
					        <form:input path="reqMemCapa" type="number" class="form-control essential onlyInteger" step="1" min="1" max="256" title="요청 메모리" onblur="fn_checkData(this);" maxlength="3" readonly="true"  />
					    </td>
					    <th><label for="lmttMemCapa"><span class="text-red">*</span>제한 메모리(GB)</label></th>
					    <td>
					        <form:input path="lmttMemCapa" type="number" class="form-control essential onlyInteger" step="1" min="1" max="256" title="제한 메모리" onblur="fn_checkData(this);" maxlength="3" readonly="true" />
					    </td>
					    <td colspan="2"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
<!--  쿼터정보 끝  -->


<!--  제한정보 시작  -->
<div class="col-box-100 detail-col">
	<div class="box">
       <div class="box-header">
           <h3 class="box-title">Pod 제한 정보(LimitRange)</h3>
       </div>

		<div class="box-body no-padding">
		    <table class="table table-horizon" id="limitTable">
				<caption>서비스영역 자원제한 정보</caption>
				<colgroup>
					<col class="col10">
					<col class="col40">
					<col class="col10">
					<col class="col40">
				</colgroup>
				<tbody>
					<tr>
					    <th><label for="minCpuCorQty"><span class="text-red">*</span>최소 CPU(Core)</label></th>
					    <td>
					        <form:input path="minCpuCorQty" type="number" class="form-control essential onlyFloat" step="1" min="1" max="256" title="최소 CPU" onblur="fn_checkData(this);" maxlength="4" />
						</td>
						<th><label for="intMaxCpuCorQty"><span class="text-red">*</span>최대 CPU(Core)</label></th>
						<td>
						    <form:input path="intMaxCpuCorQty" type="number" class="form-control essential onlyInteger" step="1" min="1" max="256" title="최대 CPU" onblur="fn_checkData(this);" maxlength="3" />
							<form:hidden path="maxCpuCorQty" title="최대 CPU(Core)"  />
						</td>
					</tr>
					<tr>
						<th><label for="minMemCapa"><span class="text-red">*</span>최소 메모리(GB)</label></th>
						<td>
							<form:input path="minMemCapa" type="number" class="form-control essential onlyFloat" step="1" min="1" max="256"  title="최소 메모리" onblur="fn_checkData(this);" maxlength="5" />
						</td>
						<th><label for="intMaxMemCapa"><span class="text-red">*</span>최대 메모리(GB)</label></th>
						<td>
						    <form:input path="intMaxMemCapa" type="number" class="form-control essential onlyInteger" step="1" min="1" max="256" title="최대 메모리" onblur="fn_checkData(this);" maxlength="3" />
							<form:hidden path="maxMemCapa" title="최대 메모리(GB)"  />
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
<!--  제한정보 끝  -->

<!--  스토리지 정보 시작  -->
<div class="col-box-100 detail-col">
	<div class="box detail-list-box">
        <div class="box-header">
           	<h3 class="box-title">스토리지 연결 정보</h3>
           	<c:if test='${"Y" eq servcAreaVo.ctlTrgtYn }'>
	           	<c:if test='${"02" eq servcAreaVo.servcAreaClCd }'>
	           	<div class="box-footer clearfix">
					<div class="pull-right">
						<button class="btn btn-sm btn-function" onclick="openInsertPvPop();return false;">스토리지 추가</button>
					</div>
				</div>
				</c:if>
			</c:if>
        </div>
		<div class="box-body no-padding detail-list-body" >
			<table class="table table-vertical table-layout-fixed" id="strgTable">
				<caption>스토리지 연결 목록</caption>
    			<thead>
					<tr>
						<th>스토리지구분</th>
						<th>스토리지명</th>
						<th>접근모드</th>
						<th>용량(GB)</th>
						<th></th>
	       			</tr>
      			</thead>
      			<tbody id="pvBody">
	     			<c:forEach var="pvVo" items="${pvList }" varStatus="i">
	     				<tr>
						<td class="alignL"><c:out value="${pvVo.strgClCdNm }" /></td>
						<td class="alignL"><c:out value="${pvVo.pvNm }" /></td>
						<td class="alignL"><c:out value="${pvVo.accssModeClCdNm }" /></td>
						<td class="alignR"><c:out value="${pvVo.strgAsgnCapa }" />
							<input type="hidden" name="checkPvId" value="${pvVo.pvId }" />
						</td>
			          	<td>
				          	<menu:authorize>
				          	<c:if test='${"Y" eq servcAreaVo.ctlTrgtYn }'>
				          	<button class="btn btn-default btn-sm" onclick="deletePv('<c:out value="${pvVo.pvId }" />');return false;">삭제</button>
				          	</c:if>
				          	</menu:authorize>
			          	</td>
					</tr>
	     			</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<div class="col-box-100 detail-col">
	<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">서비스 목록</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>

		<div class="box-body no-padding detail-list-body" >
			<table class="table table-vertical table-layout-fixed" id="servcTable">
				<caption>서비스 목록</caption>

	    			<thead>
						<tr>
							<th>No.</th>
							<th>서비스명</th>
							<th>Pod수</th>
							<th>CPU(Core)</th>
							<th>CPU사용률(%)</th>
							<th>메모리(GB)</th>
							<th>메모리사용률(%)</th>
							<th>네트워크 In(KB/Sec)</th>
							<th>네트워크 Out(KB/Sec)</th>
		       			</tr>
	      			</thead>
	      			<tbody>
		      			<c:forEach var="servcVo" items="${servcList }" varStatus="i">
		      				<tr>
		      					<c:url var="detailUrl" value="/cpt/rsrc/atmscl/servc/selectServc.do">
									<c:param name="servcSeq" value="${servcVo.servcSeq }" />
								</c:url>
								<td><c:out value="${(i.count)}" /></td>
								<td class="alignL">
									<a href="${detailUrl }" title="<c:out value="${servcVo.servcNm}"/>"><c:out value="${servcVo.servcNm}" /></a>
								</td>
								<td class="alignR"><c:out value="${servcVo.podQty }" /></td>

								<c:if test="${servcVo.servcTyCd eq '01' }">
									<td class="alignR"><c:out value="${servcVo.sumCpuCorQty }" /></td>
									<td class="alignR"><c:out value="${servcVo.avgCpuUseRt }" /></td>
									<td class="alignR"><c:out value="${servcVo.sumMemAsgnCapa }" /></td>
									<td class="alignR"><c:out value="${servcVo.avgMemUseRt }" /></td>
								</c:if>
								<c:if test="${servcVo.servcTyCd ne '01' }">
									<td class="alignC">-</td>
									<td class="alignC">-</td>
									<td class="alignC">-</td>
									<td class="alignC">-</td>
								</c:if>
								<td class="alignR"><c:out value="${servcVo.netwkIn }" /></td>
								<td class="alignR"><c:out value="${servcVo.netwkOut }" /></td>
							</tr>
		      			</c:forEach>
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
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="뒤로" data-original-title="뒤로" onclick="fn_selectServcAreaList()"><i class="fa fa-arrow-left"></i></button>
		</div>

		<c:if test='${"Y" eq servcAreaVo.ctlTrgtYn }'>
			<c:if test='${"02" eq servcAreaVo.servcAreaClCd }'>
				<div class="pull-right btns">
					<menu:authorize onlyOprAdm="true">
						<button type="button" class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="저장" data-original-title="저장" onclick="fn_updateServcArea();"><i class="fa fa-check"></i></button>
			    		<button id = "deleteServcAreaBtn" class="btn btn-sm btn-hover-red" data-toggle="tooltip" data-original-title="삭제" onclick="javascript:fn_deleteServcArea()"><i class="fa fa-minus"></i></button>
			    	</menu:authorize>
				</div>
			</c:if>
		</c:if>
	</div>
</div>

<script type="text/javascript">



$(document).ready(function() {

	$("#limitTable input").change(function(){
		$('#limitEditYn').val('Y');
	});

	$("#quotaTable input").change(function(){
		$('#quotaEditYn').val('Y');
	});

});




// 뒤로 버튼 클릭 시
function fn_selectServcAreaList(){
	location.href = '<c:url value="selectServcAreaList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'servcAreaSeq'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
}

// 저장 버튼 클릭 시
function fn_updateServcArea(){

	if(!fn_form_validation("servcAreaVo")){
		return;
	}

	$('#maxCpuCorQty').val($('#intMaxCpuCorQty').val());
	$('#maxMemCapa').val($('#intMaxMemCapa').val());

	if($('#selectSpecListPFlag').val()=='Y') {
		$('#quotaEditYn').val('Y');
	}

	jConfirm('서비스영역 정보를 저장 하시겠습니까?', function(){

		var options = {
			type: 'post',
			dataType: 'json',
			success: updateServcAreaResultHandler,
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

		$('#servcAreaVo').attr('action', '<c:url value="updateServcArea.do"/>');
		$('#servcAreaVo').ajaxSubmit(options);

	});

}

// 저장 결과 콜백
function updateServcAreaResultHandler(result){


	if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

	if(result.success){
		jInfo("저장되었습니다.", function(){
			if(result.procType == "update") {
				location.href = '<c:url value="selectServcAreaList.do"/>';
			}
		});
	}else{
		jAlert(result.messageList);
	}

}


// 스토리지 추가 팝업화면 호출
function openInsertPvPop() {

	var servcAreaSeq = $('#servcAreaSeq').val();
	var rsrcPoolId = $('#rsrcPoolId').val();

	var params = {"rsrcPoolId" : rsrcPoolId };
	var url = 'selectPvListP.do';

	var width = 1000;
	var height = 720;
	var posY  = (screen.width - width) / 2;
	var posX =  (screen.height - height) / 2;
	var args = {width:width , height:height, posX : posX , posY : posY};
	windowOpen(url, params, args);
}


//이벤트 핸들러
$(document).bind('selectPv',setPv);

//서비스영역 PV 할당
function setPv(evt) {
	var formData = [];
	var existFlag = false;
	var getPvId;
	var getPvNm;

	$.each(evt.datas, function(index) {
	  getPvId = this.pvId;
	  getPvNm = this.pvNm;

		$.each($('#strgTable input:hidden[name="checkPvId"]'), function(index, item){
			if($(item).val() == getPvId){

				jAlert("["+getPvNm+"] 스토리지가 이미 할당되어 있습니다!");
				existFlag = true;
				return;
			}
		});

		if(!existFlag) {
			formData.push({ name : "pvList[" + index + "].pvId", value : this.pvId });
			formData.push({ name : "pvList[" + index + "].rsrcPoolId", value : $('#rsrcPoolId').val() });
			formData.push({ name : "pvList[" + index + "].servcAreaSeq", value : $('#servcAreaSeq').val() });
		}
	});

	if(!existFlag) {

		$.ncmsLoding.startFullScreen();
		$.post("<c:url value="insertServcAreaPvAsgn.do" />",
				formData,
				function(result) {
					//alert_message(result.message, function() {
					jInfo(result.messageList, function() {
						if( result.success ) {
							location.reload();
						}
					});
				},
				"json"
			).always(function() {
				//로딩바 종료
				$.ncmsLoding.remove();
			});
	}
}


// 서비스영역 스토리지 할당 삭제
function deletePv(pvId) {
	var servcAreaSeq = $('#servcAreaSeq').val();
	var rsrcPoolId = $('#rsrcPoolId').val();

	jConfirm("삭제 하시겠습니까?", function() {

		$.ncmsLoding.startFullScreen();
		$.post("<c:url value="deleteServcAreaPvAsgn.do" />",
				{"pvId" : pvId, "rsrcPoolId" : rsrcPoolId, "servcAreaSeq" : servcAreaSeq },
				function(result) {
					jInfo(result.messageList, function() {
						if( result.success ) {
							//alert_message(result.messageList)
							location.reload();
						}
					});
				},
				"json"
			).always(function() {
				//로딩바 종료
				$.ncmsLoding.remove();
			});
	});
}



//삭제버튼 클릭 시
function fn_deleteServcArea() {
	jConfirm('삭제 하시겠습니까?', function(){
		$.ncmsLoding.startFullScreen();
		$.post('updateServcAreaDeleteYn.do', $('#servcAreaVo').serialize(), function(result) {

			jInfo(result.messageList, function() {
				if( result.success) {
					location.href = '<c:url value="selectServcAreaList.do"/>';
				}
			});

		}, 'json').always(function(){$.ncmsLoding.remove();});
	});
}



//스 펙 선택 팝업
function fn_selectSpecListP(){

	var url = 'selectAtmSclSpecListPView.do';
	var width = 1000;
	var height = 620;
	var posY  = (screen.width - width) / 2;
	var posX =  (screen.height - height) / 2;
	var args = {width:width , height:height, posX : posX , posY : posY};
	windowOpen(url, '', args);
}


// 스펙 선택 콜백
function fn_selectedSpec(spec){

	var selectedStr = spec.vcoreMinVl+'|'+spec.vcoreMaxVl+'|'+spec.memMinVl+'|'+spec.memMaxVl+'|'+spec.maxPodQty;
	var oldStr = $('#reqCpuCorQty').val()+'|'+$('#lmttCpuCorQty').val()+'|'+$('#reqMemCapa').val()+'|'+$('#lmttMemCapa').val()+'|'+$('#maxPodQty').val();

	if(selectedStr != oldStr) {
		$('#selectSpecListPFlag').val('Y');
	}

	$('#specNm').val(spec.specNm);
	$('#reqCpuCorQty').val(spec.vcoreMinVl);
	$('#lmttCpuCorQty').val(spec.vcoreMaxVl);
	$('#reqMemCapa').val(spec.memMinVl);
	$('#lmttMemCapa').val(spec.memMaxVl);
	$('#maxPodQty').val(spec.maxPodQty);
	$('#quotaCheck').prop("checked",false);

}


//소숫점 체크
function fn_checkFloat(dataVal, checkLen) {

	var rtnFlag = true;
	var msg = "";

	if(dataVal.indexOf('.')!=-1) {
		var checkLength = dataVal.substring(dataVal.indexOf('.')+1);

		if(checkLength.length>checkLen) {
			rtnFlag =  false;
		}
	}

	return rtnFlag;
}


//데이터 체크
function fn_checkData(obj){


	var rtfFlag = true;
	var alertMsg = "";

	if(parseInt($('#reqCpuCorQty').val()) > 128 || parseInt($('#reqCpuCorQty').val()) <= 0 ||
	   parseInt($('#lmttCpuCorQty').val()) > 128 || parseInt($('#lmttCpuCorQty').val()) <= 0 ||
	   parseInt($('#intMaxCpuCorQty').val()) > 128 || parseInt($('#intMaxCpuCorQty').val()) <= 0 ) {

		alertMsg = "CPU 값은 1 ~ 128 사이의 값으로 설정해주세요.";
		rtfFlag = false;
	}

	if(rtfFlag && (parseInt($('#reqMemCapa').val()) > 256 || parseInt($('#reqMemCapa').val()) <= 0 ||
	   parseInt($('#lmttMemCapa').val()) > 256 || parseInt($('#lmttMemCapa').val()) <= 0 ||
	   parseInt($('#intMaxMemCapa').val()) > 256 || parseInt($('#intMaxMemCapa').val()) <= 0 )) {
		alertMsg = "메모리값은 1 ~ 256 사이의 값으로 설정해주세요.";
		rtfFlag = false;
	}


	if(rtfFlag && (parseFloat($('#minCpuCorQty').val()) > 128 || parseFloat($('#minCpuCorQty').val()) < 0.01)) {
		alertMsg = "제한 정보의 최소 CPU 값은 0.01 ~ 128 사이의 값으로 설정해주세요.";
		obj = $('#minCpuCorQty');
		rtfFlag = false;
	}

	if(rtfFlag && (parseFloat($('#minMemCapa').val()) > 256 || parseFloat($('#minMemCapa').val()) < 0.001)) {
		alertMsg = "제한 정보의 최소 메모리 값은 0.001 ~ 256 사이의 값으로 설정해주세요.";
		obj = $('#minMemCapa');
		rtfFlag = false;
	}


	if(rtfFlag && (parseFloat($('#minMemCapa').val()) < 1 && (parseFloat($('#minMemCapa').val())*1024)%1 !=0)) {
		alertMsg = "제한 정보의 최소 메모리 값을  다시 입력해 주세요. \n 예시1)512MB를 입력하고 싶을경우  = 0.5 \n 예시2)256MB를 입력하고 싶을경우 = 0.25";
		obj = $('#minMemCapa');
		rtfFlag = false;
	}


	if(rtfFlag && (!fn_checkFloat($('#minMemCapa').val(), 3))) {
		rtfFlag = false;
		alertMsg = "최소 메모리는 소숫점 3자리까지만 허용합니다.";
		obj = $('#minMemCapa');

	}

	if(rtfFlag && (!fn_checkFloat($('#minCpuCorQty').val(), 2))) {
		rtfFlag = false;
		alertMsg = "최소 CPU는  소숫점 2자리까지만 허용합니다.";
		obj = $('#minCpuCorQty');
	}


	if(rtfFlag && (parseInt($('#lmttCpuCorQty').val()) < parseInt($('#reqCpuCorQty').val()))){
		obj = $('#reqCpuCorQty');
		alertMsg = "요청 CPU 값은 제한 CPU 값 보다 클 수 없습니다.";
		rtfFlag = false;
	}


	if(rtfFlag && (parseFloat($('#intMaxCpuCorQty').val()) < parseFloat($('#minCpuCorQty').val()))){
		obj = $('#minCpuCorQty');
		alertMsg = "최소 CPU 값은 최대 CPU 값 보다 클 수 없습니다.";
		rtfFlag = false;
	}


	if(rtfFlag && (parseInt($('#lmttMemCapa').val()) < parseInt($('#reqMemCapa').val()))){
		obj = $('#reqMemCapa');
		alertMsg = "요청 메모리 값은 제한 메모리 값 보다 클 수 없습니다.";
		rtfFlag = false;
	}

	if(rtfFlag && (parseFloat($('#intMaxMemCapa').val()) < parseFloat($('#minMemCapa').val()))){
		alertMsg = "최소 메모리 값은 최대 메모리 값 보다 클 수 없습니다.";
		obj = $('#minMemCapa');
		rtfFlag = false;
	}

	if(rtfFlag && (parseFloat($('#lmttMemCapa').val()) < parseFloat($('#minMemCapa').val()))){
		alertMsg = "최소 메모리 값은 제한 메모리 값 보다 클 수 없습니다.";
		obj = $('#minMemCapa');
		rtfFlag = false;

	}

	if(rtfFlag && (parseInt($('#lmttMemCapa').val()) < parseInt($('#intMaxMemCapa').val()))){
		alertMsg = "최대 메모리 값은 제한 메모리 값 보다 클 수 없습니다.";
		obj = $('#intMaxMemCapa');
		rtfFlag = false;
	}

	if(rtfFlag && (parseInt($('#lmttCpuCorQty').val()) < parseInt($('#intMaxCpuCorQty').val()))){
		alertMsg = "최대 CPU 값은 제한 CPU 값 보다 클 수 없습니다.";
		obj = $('#intMaxCpuCorQty');
		rtfFlag = false;
	}

	if(rtfFlag && (parseInt($('#lmttCpuCorQty').val()) < parseInt($('#minCpuCorQty').val()))){
		alertMsg = "최소 CPU 값은 제한 CPU 값 보다 클 수 없습니다.";
		obj = $('#minCpuCorQty');
		rtfFlag = false;
	}

	if(!rtfFlag) {
		jAlert(alertMsg, function(){
			if(obj != null) {
				obj.focus();
			}
		});
	}

	return rtfFlag;
}



//업무에 대한 단일 선택
$(document).bind('selectJob',setJob);
//업무에 대한 단일 선택 이벤터 함수
function setJob(evt) {
	var job = evt.datas;
	$('#servcAreaVo input[name="jobNm"]').val(job.jobNm);
	$('#servcAreaVo input[name="institutionNm"]').val(job.institutionNm);
  	$('#servcAreaVo input:hidden[name="institutionId"]').val(job.institutionId);
  	$('#servcAreaVo input:hidden[name="jobId"]').val(job.jobId);
}

//쿼터설정 직접입력 선택 시
function fn_quotaToggle(){

  if($('#quotaCheck').prop("checked")==true){
      //$("#reqCpuCorQty").val("");
      $("#reqCpuCorQty").attr('readonly',false);
      //$("#lmttCpuCorQty").val("");
      $("#lmttCpuCorQty").attr('readonly',false);
      //$("#reqMemCapa").val("");
      $("#reqMemCapa").attr('readonly',false);
      //$("#lmttMemCapa").val("");
      $("#lmttMemCapa").attr('readonly',false);
      //$("#maxPodQty").val("");
      $("#maxPodQty").attr('readonly',false);
      $("#specNm").val("");
  }else{
     // $("#reqCpuCorQty").val("");
      $('#reqCpuCorQty').val('${servcAreaVo.reqCpuCorQty}');
      $("#reqCpuCorQty").attr('readonly',true);
      //$("#lmttCpuCorQty").val("");
      $('#lmttCpuCorQty').val('${servcAreaVo.lmttCpuCorQty}');
      $("#lmttCpuCorQty").attr('readonly',true);
      //$("#reqMemCapa").val("");
      $('#reqMemCapa').val('${servcAreaVo.reqMemCapa}');
      $("#reqMemCapa").attr('readonly',true);
      //$("#lmttMemCapa").val("");
      $('#lmttMemCapa').val('${servcAreaVo.lmttMemCapa}');
      $("#lmttMemCapa").attr('readonly',true);
      //$("#maxPodQty").val("");
      $('#maxPodQty').val('${servcAreaVo.maxPodQty}');
      $("#maxPodQty").attr('readonly',true);
      $("#specNm").val("");
  }
}




$("#strgTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
		{sWidth : "84px" },
		{sWidth : "150px" },
		{sWidth : "70px" },
		{sWidth : "70px" },
		{sWidth : "50px" },
   	],
   	order : [],
});



$("#servcTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,

	aoColumns : [
		{sWidth : "28px" }, // No.
		{sWidth : "272px" }, // 서비스명
		{sWidth : "80px" }, // Pod수
		{sWidth : "130px" },
		{sWidth : "130px" },
		{sWidth : "130px" },
		{sWidth : "130px" },
		{sWidth : "130px" },
		{sWidth : "130px" },
   	],
   	order : [],
});



</script>
