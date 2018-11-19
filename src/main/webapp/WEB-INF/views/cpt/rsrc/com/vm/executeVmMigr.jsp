<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>가상서버 마이그레이션 실행 화면</pre>
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
	<!-- 수평형 테이블 -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">원본 가상서버</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>원본 가상서버</caption>
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
							<c:out value="${vmVo.vmNm}"/>
						</td>
						<th>호스트명</th>
						<td><c:out value="${vmVo.hstNm}"/></td>
					</tr>
					<tr>
						<th>IP주소</th>
						<td><c:out value="${vmVo.rprsntIpAddr}"/></td>
						<th>운영체제</th>
						<td><c:out value="${vmVo.osTyCdNm}"/></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<!-- pmVoList -->

	<c:if test="${null eq targetPmVo}">

		<div class="box detail-list-box">
			<div class="box-header">
				<h3 class="box-title"><span class="text-red">*</span> 대상 물리서버</h3>
				<div class="box-tools">
					<div class="pull-right">
					</div>
				</div>
			</div>
			<div class="box-body no-padding detail-list-body" style="overflow-x:auto;">
				<table class="table table-hover table-vertical table-layout-fixed" id="targetPmTable">
					<caption>대상 물리서버</caption>
					<thead>
						<tr>
							<th><nobr title="선택">선택</nobr></th>
							<th><nobr title="물리서버ID">물리서버ID</nobr></th>
							<th><nobr title="IP주소">IP주소</nobr></th>
							<th><nobr title="가상서버수">가상서버수</nobr></th>
							<th><nobr title="CPU 사용률 (%)">CPU<br>사용률<br>(%)</nobr></th>
							<th><nobr title="CPU vCore">CPU<br>vCore</nobr></th>
							<th><nobr title="CPU 가상화율 (%)">CPU<br>가상화율<br>(%)</nobr></th>
							<th>메모리<br/>전체량<br/>(GB)</th>
							<th><nobr title="메모리 사용률 (%)">메모리<br>사용률<br>(%)</nobr></th>
							<th><nobr title="메모리 가상화율 (%)">메모리<br>가상화율<br>(%)</nobr></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="targetPmVo" items="${pmVoList}" varStatus="i">
							<tr>
								<td>
									<nobr><input type="radio" title="선택여부" name="targetPm" value="${targetPmVo.pmSeq }" onclick="fn_selectTargetPm(this);"/></nobr>
								</td>
								<td class="alignL"><nobr title="<c:out value="${targetPmVo.pmId }" />"><c:out value="${targetPmVo.pmId }" />
									<input type="hidden" name="regionId" value="${targetPmVo.regionId }"/>
									<input type="hidden" name="zoneId" value="${targetPmVo.zoneId }"/>
									<input type="hidden" name="netClCd" value="${targetPmVo.netClCd }"/>
									<input type="hidden" name="rsrcPoolId" value="${targetPmVo.rsrcPoolId }"/>
									<input type="hidden" name="pmUuid" value="${targetPmVo.uuid }"/>
									<input type="hidden" name="pmSeq" value="${targetPmVo.pmSeq }"/>
									<input type="hidden" name="vmSeq" value="${vmVo.vmSeq }"/></nobr></td>
									<input type="hidden" name="vrlzSwTyCdTmp" value="${vmVo.vrlzSwTyCd}"/>
								<td class="alignL"><nobr title="<c:out value="${targetPmVo.rprsntIpAddr }" />"><c:out value="${targetPmVo.rprsntIpAddr }" /></nobr></td>
								<td class="alignR"><nobr title="<c:out value="${targetPmVo.vmCnt }" />"><c:out value="${targetPmVo.vmCnt }" /></nobr></td>
								<td class="notellipsis">
									<span title="<fmt:formatNumber value="${targetPmVo.cpuUseRt}" pattern="0"/>" class="label label-green"><fmt:formatNumber value="${targetPmVo.cpuUseRt}" pattern="0"/></span>
									<div title="<fmt:formatNumber value="${targetPmVo.cpuUseRt}" pattern="0"/>" class="progress">
										<div class="progress-bar progress-bar-green" style="width: <fmt:formatNumber value="${targetPmVo.cpuUseRt}" pattern="0"/>%"></div>
									</div>
								</td>
								<td class="alignR"><nobr title="<c:out value="${targetPmVo.totCpuVcoreQty }"/>"><c:out value="${targetPmVo.totCpuVcoreQty }"/></nobr></td>
								<td class="alignR"><nobr title="<fmt:formatNumber value="${targetPmVo.cpuVrlzRt}" pattern="0"/>"><fmt:formatNumber value="${targetPmVo.cpuVrlzRt}" pattern="0"/></nobr></td>
								<td class="notellipsis">
									<span title="<fmt:formatNumber value="${targetPmVo.memUseRt}" pattern="0"/>" class="label label-green"><fmt:formatNumber value="${targetPmVo.memUseRt}" pattern="0"/></span>
									<div title="<fmt:formatNumber value="${targetPmVo.memUseRt}" pattern="0"/>" class="progress">
										<div class="progress-bar progress-bar-green" style="width: <fmt:formatNumber value="${targetPmVo.memUseRt}" pattern="0"/>%"></div>
									</div>
								</td>
								<td class="alignR"><fmt:formatNumber value="${targetPmVo.memCapa}" pattern="0"/></td>
								<td class="alignR"><nobr title="<fmt:formatNumber value="${targetPmVo.memVrlzRt}" pattern="0"/>"><fmt:formatNumber value="${targetPmVo.memVrlzRt}" pattern="0"/></nobr></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

	</c:if>

	<div class="box">
		<form:form commandName="vmMigrVo">
			<div class="box-header">
				<h3 class="box-title">마이그레이션 정보</h3>
				<div class="box-tools">
					<div class="pull-right">
						<input type="hidden" name="vmUuid" value="${vmVo.uuid}"/>
						<input type="hidden" name="vmNm" value="${vmVo.vmNm}"/>
						<c:if test="${null ne targetPmVo}">
							<button type="button" id="procssStatBtn" title="진행상태조회" class="btn btn-sm btn-function" onclick="fn_procssStatOpen(<c:out value="${vmProcssMsgVo.procssInstSeq }"/>);"><i class="fa fa-file-o"></i>진행상태조회</button>
						</c:if>
					</div>
				</div>
			</div>

			<div class="col-cell-group clearfix">
				<div class="col-cell-100 col-lay-50 col-lay-no-padding-right opstSwt1">
					<div class="box">
						<div class="box-header">
							<h3 class="box-title">원본 물리서버</h3>
						</div><!-- /box-header -->
						<div class="box-body no-padding" style="overflow-x:auto;">
							<table class="table table-vertical">
								<caption>원본 물리서버</caption>
								<thead>
									<tr>
										<th rowspan="2"><nobr>물리서버ID</nobr></th>
										<th rowspan="2"><nobr>IP주소</nobr></th>
										<th rowspan="2"><nobr>가상서버수</nobr></th>
										<th colspan="3"><nobr>CPU</nobr></th>
										<th colspan="3"><nobr>메모리</nobr></th>
									</tr>
									<tr>
										<th><nobr>사용률 (%)</nobr></th>
										<th><nobr>vCore</nobr></th>
										<th><nobr>가상화율 (%)</nobr></th>
										<th><nobr>사용률 (%)</nobr></th>
										<th>메모리(GB)</th>
										<th><nobr>가상화율 (%)</nobr></th>
									</tr>
								</thead>
								<tbody>
									<c:choose>
										<c:when test="${pmVo eq null or empty pmVo }">
										<tr>
											<td colspan="9" style="height: 47px;">원본 물리서버가 없습니다.</td>
										</tr>
										</c:when>
										<c:otherwise>
											<tr>
												<td class="alignL"><nobr><c:out value="${pmVo.pmId }" /></nobr></td>
												<td class="alignL"><nobr><c:out value="${pmVo.rprsntIpAddr }" /></nobr></td>
												<td class="alignR"><nobr><c:out value="${pmVo.vmCnt }" /></nobr></td>
												<td>
													<span class="label label-green"><fmt:formatNumber value="${pmVo.cpuUseRt}" pattern="0"/></span>
													<div class="progress">
														<div class="progress-bar progress-bar-green" style="width: <fmt:formatNumber value="${pmVo.cpuUseRt}" pattern="0"/>%"></div>
													</div>
												</td>
												<td class="alignR"><nobr><c:out value="${pmVo.totCpuVcoreQty }"/></nobr></td>
												<td class="alignR"><nobr><fmt:formatNumber value="${pmVo.cpuVrlzRt}" pattern="0"/></nobr></td>
												<td>
													<span class="label label-green"><fmt:formatNumber value="${pmVo.memUseRt}" pattern="0"/></span>
													<div class="progress">
														<div class="progress-bar progress-bar-green" style="width: <fmt:formatNumber value="${pmVo.memUseRt}" pattern="0"/>%"></div>
													</div>
												</td>
												<td class="alignR"><fmt:formatNumber value="${pmVo.memCapa}" pattern="0"/></td>
												<td class="alignR"><nobr><fmt:formatNumber value="${pmVo.memVrlzRt}" pattern="0"/></nobr></td>
											</tr>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="col-cell-100 col-lay-50 opstSwt2">
					<div class="box">
						<div class="box-header">
							<h3 class="box-title">대상 물리서버</h3>
						</div><!-- /box-header -->
						<div class="box-body no-padding" style="overflow-x:auto;">
							<table id="targetPm" class="table table-vertical">
								<caption>대상 물리서버</caption>
								<thead>
									<tr>
										<th rowspan="2"><nobr>물리서버ID</nobr></th>
										<th rowspan="2"><nobr>IP주소</nobr></th>
										<th rowspan="2"><nobr>가상서버수</nobr></th>
										<th colspan="3"><nobr>CPU</nobr></th>
										<th colspan="3"><nobr>메모리</nobr></th>
									</tr>
									<tr>
										<th><nobr>사용률 (%)</nobr></th>
										<th><nobr>vCore</nobr></th>
										<th><nobr>가상화율 (%)</nobr></th>
										<th><nobr>사용률 (%)</nobr></th>
										<th>메모리(GB)</th>
										<th><nobr>가상화율 (%)</nobr></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<c:choose>
											<c:when test="${null ne targetPmVo}">
												<td class="alignL"><nobr><c:out value="${targetPmVo.pmId }" /></nobr></td>
												<td class="alignL"><nobr><c:out value="${targetPmVo.rprsntIpAddr }" /></nobr></td>
												<td class="alignR"><nobr><c:out value="${targetPmVo.vmCnt }" /></nobr></td>
												<td>
													<span class="label label-green"><fmt:formatNumber value="${targetPmVo.cpuUseRt}" pattern="0"/></span>
													<div class="progress">
														<div class="progress-bar progress-bar-green" style="width: <fmt:formatNumber value="${targetPmVo.cpuUseRt}" pattern="0"/>%"></div>
													</div>
												</td>
												<td class="alignR"><nobr><c:out value="${targetPmVo.totCpuVcoreQty }"/></nobr></td>
												<td class="alignR"><nobr><fmt:formatNumber value="${targetPmVo.cpuVrlzRt}" pattern="0"/></nobr></td>
												<td>
													<span class="label label-green"><fmt:formatNumber value="${targetPmVo.memUseRt}" pattern="0"/></span>
													<div class="progress">
														<div class="progress-bar progress-bar-green" style="width: <fmt:formatNumber value="${targetPmVo.memUseRt}" pattern="0"/>%"></div>
													</div>
												</td>
												<td class="alignR"><fmt:formatNumber value="${targetPmVo.memCapa}" pattern="0"/></td>
												<td class="alignR"><nobr><fmt:formatNumber value="${targetPmVo.memVrlzRt}" pattern="0"/></nobr></td>
											</c:when>
											<c:otherwise>
												<td colspan="9" style="height: 47px;"><input type="hidden" title="대상 물리서버 선택" class="essential">대상 물리서버가 선택되지 않았습니다.</td>
											</c:otherwise>
										</c:choose>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</form:form>
	</div>


</div>

<!-- 페이지 버튼 영역 -->
<div class="col-box-100">
	<div class="edit-btn-group">
		<div class="pull-left btns">
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="뒤로" data-original-title="뒤로" onclick="fn_selectVm();"><i class="fa fa-arrow-left"></i></button>
		</div>
		<div class="pull-right btns">
			<c:if test="${null eq targetPmVo}">
				<menu:authorize authType="act">
					<button class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="실행" data-original-title="실행" onclick="fn_executeVmMigr();"><i class="fa fa-check"></i></button>
				</menu:authorize>
			</c:if>
		</div>
	</div>
</div>

<script type="text/javascript">

function fn_selectTargetPm(obj){
	var $selectedTargetPm = $(obj).closest('tr').clone();
	var pmSeq = $selectedTargetPm.find('td:first input[type="radio"]').val();
	$('input[type="hidden"][name="pmSeq"]').val(pmSeq);
	$selectedTargetPm.children('td:first').remove();
	$('#targetPm tbody').html($selectedTargetPm);

}

//뒤로
function fn_selectVm(){
	location.href = '<c:url value="selectVm.do"><c:forEach var="pageParam" items="${param}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:forEach></c:url>';
}

function fn_executeVmMigr(){

	if(!fn_form_validation("vmMigrVo")){
		return;
	}

	jConfirm('가상서버 마이그레이션을 실행하시겠습니까?', function(){

		var options = {
			type: 'post',
			dataType: 'json',
			success: executeVmMigrResultHandler,
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

		$('#vmMigrVo').attr('action', '<c:url value="executeVmMigr.do"/>');
		$('#vmMigrVo').ajaxSubmit(options);

	});
}

function executeVmMigrResultHandler(result){

	if(result.success){
		jInfo(result.messageList, function(){
			fn_selectVm();
		});
	}
	else{
		jAlert(result.messageList);
	}

}
//17.07.18
// openstack은 마이그레이션시 host를 선택할수 있는게 아니라 랜덤으로 선택되기때문에 화면에서 host 선택부분 hide.
// process 진행을 위하 일단 임의의 값을 postgre에 넣은 후 진행.
$(document).ready(function(){
	var vrlzSwTyCdTmp = $('#targetPmTable input[name=vrlzSwTyCdTmp]').val();
	if (vrlzSwTyCdTmp == "05"){
		$('.detail-list-box').hide();
		fn_selectTargetPm($('#targetPmTable td:first input[type="radio"]').prop("checked", true));
		$('.opstSwt1').removeClass("col-lay-50").removeClass("col-lay-no-padding-right").addClass("col-lay-100");
		$('.opstSwt2').hide();
	}
});

$('#targetPmTable').on('click', 'tr', function(e){
	if($.contains(document.querySelector('#targetPmTable thead'), this) || $('#targetPmTable input[type="radio"]').length == 0){
		return;
	}
	$(this).find('input[type="radio"]').prop('checked', true);
	fn_selectTargetPm(this);
});

$('#targetPmTable input[type="radio"]').click(function(e) {
	e.stopPropagation();
});

$("#targetPmTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	columnDefs:[{type:'ip-address', targets:[2]}],
	aoColumns : [
		{sWidth : "28px" }, // 선택
		{sWidth : "100px" }, //물리서버ID
		{sWidth : "100px" }, //IP주소
		{sWidth : "60px" }, //가상서버수
		{sWidth : "40px" }, //CPU 사용률
		{sWidth : "40px" }, //CPU vCOre
		{sWidth : "50px" }, //CPU 가상화율
		{sWidth : "50px" }, //메모리 사용률
		{sWidth : "40px" }, //메모리 사용률
		{sWidth : "50px" }, //메모리 가상화율
	],
});



/**
 *  실행내역
 */
function fn_procssStatOpen(procssInstseq){
	if(null == procssInstseq){
		return ;
	}

	var params = { 'procssInstSeq' : procssInstseq };
	var url = "<c:url value='/cpt/opr/req/rsrcreq/selectRsrcReqExeListMigrP.do'/>";
	var args = {key:"selectRsrcReqExeListMigrP", width: 1280 , height: 720 };
	windowOpen(url, params, args);
}

</script>
