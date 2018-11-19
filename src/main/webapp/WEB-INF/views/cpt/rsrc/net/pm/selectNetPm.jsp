<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 최경철
 * @lastmodifier 최경철
 * @created 2016. 10. 24.
 * @lastmodified 2016. 10. 24.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 24.     최경철         v1.0             최초생성
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

<div class="col-box-100">
	<div class="col-info server <c:choose>
									<c:when test='${"02" eq netPmVo.statCd}'><c:out value="server-up"/></c:when>
									<c:when test='${"01" eq netPmVo.statCd}'><c:out value="server-down"/></c:when>
									<c:when test='${"03" eq netPmVo.statCd}'><c:out value="server-maintain"/></c:when>
									<c:when test='${"04" eq netPmVo.statCd}'><c:out value="server-inprogress"/></c:when>
									<c:when test='${"05" eq netPmVo.statCd}'><c:out value="server-exception"/></c:when>
									<c:otherwise></c:otherwise></c:choose>">
		<div class="col-info-body alignL">
			<div class="col-info-box alignL">
				<span class="label"></span>
				<h4 class="stat"><c:out value="${netPmVo.statCdNm}"/></h4>
			</div>
		</div>
	</div>
</div>

<!-- 등록/상세 영역 -->
<div class="col-box-25">
	<div class="col-info">
		<h3 class="col-info-header">CPU 사용률</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num"><fmt:formatNumber value="${netPmVo.cpuUseRt }" pattern="0"/><small>%</small></h4>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25">
	<div class="col-info">
		<h3 class="col-info-header">CPU 가상화율</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num"><fmt:formatNumber value="${netPmVo.cpuVrlzRt }" pattern="0"/><small>%</small></h4>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25">
	<div class="col-info">
		<h3 class="col-info-header">메모리 사용률</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num"><fmt:formatNumber value="${netPmVo.memUseRt }" pattern="0"/><small>%</small></h4>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25">
	<div class="col-info">
		<h3 class="col-info-header">메모리 가상화율</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num"><fmt:formatNumber value="${netPmVo.memVrlzRt }" pattern="0"/><small>%</small></h4>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25">
	<div class="col-info">
		<h3 class="col-info-header">네트워크 In</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num"><fmt:formatNumber value="${netPmVo.netwkIn }" pattern="0.0"/><small>KB/Sec</small></h4>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25">
	<div class="col-info">
		<h3 class="col-info-header">네트워크 Out</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num"><fmt:formatNumber value="${netPmVo.netwkOut }" pattern="0.0"/><small>KB/Sec</small></h4>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25">
	<div class="col-info">
		<h3 class="col-info-header">스토리지 할당량</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num"><c:out value="${netPmVo.totStrgAsgnCapa }" /><small>GB</small></h4>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25">
	<div class="col-info">
		<h3 class="col-info-header">가상서버 수</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num"><c:out value="${netPmVo.vmCnt }" /></h4>
			</div>
		</div>
	</div>
</div>

<div class="col-box-100 detail-col">
	<form:form id="netPmVo" commandName="netPmVo" enctype="multipart/form-data">
	<c:set var="netPmVoClass" value="ncis.cpt.rsrc.net.vo.NetPmVo"/>
	<c:set var="groupClass" value="ncis.cmn.validation.groups.UpdateProc"/>
	<!-- 수평형 테이블 -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">기본정보</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>
		<div class="box-body no-padding">
			<form:hidden path="pmSeq" value="${netPmVo.pmSeq}"/>
	  		<table class="table table-horizon">
	  		<caption>네트워크 물리서버 기본정보 테이블</caption>
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
						<th>센터</th>
						<td><c:out value="${netPmVo.regionNm }" /></td>
						<th>존</th>
						<td><c:out value="${netPmVo.zoneNm }" /></td>
						<th>망구분(망)</th>
						<td><c:out value="${netPmVo.netClCdNm }" />(<c:out value="${netPmVo.netNm }" />)</td>
						<th>자원풀</th>
						<td><c:out value="${netPmVo.rsrcPoolNm }" /></td>
					</tr>
					<tr>
						<th>클러스터명</th>
						<td><c:out value="${netPmVo.clstrNm }" /></td>
						<th>물리서버명</th>
						<td><c:out value="${netPmVo.pmNm }" /></td>
						<th>물리서버ID</th>
						<td><c:out value="${netPmVo.pmId }" /></td>
						<th>가상화SW</th>
						<td><c:out value="${netPmVo.vrlzSwTyCdNm }" /></td>
					</tr>
					<tr>
						<th>CPU Core</th>
						<td><c:out value="${netPmVo.cpuCoreQty }" /></td>
						<th>CPU vCore</th>
						<td><c:out value="${netPmVo.totCpuVcoreQty }" /></td>
						<th>메모리 전체량 (GB)</th>
						<td><c:out value="${netPmVo.memCapa }" /></td>
						<th>메모리 할당량 (GB)</th>
						<td><c:out value="${netPmVo.totMemAsgnCapa }" /></td>

					</tr>
					<tr>
						<th>IP주소</th>
						<td colspan="7"><c:out value="${netPmVo.rprsntIpAddr }" /></td>
					</tr>
					<tr>
						<th>물리서버 구성ID</th>
						<td>
							<form:input path="pmCompId" name="pmCompId" title="뮬리서버구성ID" cssClass="form-control input-sm " value="${netPmVo.pmCompId }" maxlength="${ivu.getMaxlength(netPmVoClass, 'pmCompId', groupClass)}"/>
						</td>
						<td colspan="6"></td>
					</tr>
					<tr>
			            <th>비고</th>
			            <td colspan="7">
			            	<form:hidden path="rmk" name="rmk" title="비고" value="${pmVo.rmk }"/>
			             	<textarea id="textareaRmk" title="비고" Class="form-control" rows="3" maxlength="${ivu.getMaxlength(netPmVoClass, 'rmk', groupClass)}" placeholder="내용을 입력해 주세요."><c:out value="${netPmVo.rmk }"/></textarea>
			            </td>
		         	</tr>
				</tbody>
			</table>
		</div>
	</div>

	<div class="box">

		<div class="box-header">
			<h3 class="box-title">담당자 정보</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>
		<div class="box-body no-padding">
			<table class="table table-horizon">
			<caption>네트워크 물리서버 담당자 정보 테이블</caption>
				<colgroup>
					<col class="col13">
					<col class="col20">
					<col class="col13">
					<col class="col20">
					<col class="col14">
					<col class="col20">
				</colgroup>
				<tbody>
					<c:choose>
						<c:when test="${pmVo.oprRelateChargerVoList eq null or empty pmVo.oprRelateChargerVoList }">
							<tr>
								<td colspan="6">검색된 데이터가 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="oprRelateChargerVo" items="${pmVo.oprRelateChargerVoList }" varStatus="i">
								<tr>
									<c:choose>
										<c:when test="${oprRelateChargerVo.relaterClCd eq '01'}">
											<th>정운영담당자명</th>
										</c:when>
										<c:otherwise>
											<th>위탁운영사업자명</th>
										</c:otherwise>
									</c:choose>
									<td><c:out value="${oprRelateChargerVo.userNm}"/></td>
									<th>연락처</th>
									<td><c:out value="${oprRelateChargerVo.telno}"/></td>
									<th>이메일</th>
									<td><c:out value="${oprRelateChargerVo.email}"/></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>

				</tbody>
			</table>
		</div>

	</div>

	<div class="box detail-list-box">

		<div class="box-header">
			<h3 class="box-title">가상서버 정보</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>
		<!-- box-body -->
		<div class="box-body no-padding detail-list-body" >
			<table class="table table-hover table-vertical table-layout-fixed" id="vmTable">
			<caption>네트워크 물리서버 가상서버 정보 테이블</caption>
				<thead>
					<tr>
						<th><nobr>No.</nobr></th>
						<th><nobr>상태</nobr></th>
						<th><nobr>부처</nobr></th>
						<th><nobr>업무</nobr></th>
						<th><nobr>가상서버명</nobr></th>
						<th><nobr>가상서버ID</nobr></th>
						<th><nobr>가상서버 구성ID</nobr></th>
						<th><nobr>호스트명</nobr></th>
						<th><nobr>IP주소</nobr></th>
						<th><nobr>OS타입</nobr></th>
						<th><nobr>CPU<br>사용률<br>(%)</nobr></th>
						<th><nobr>CPU<br>vCore</nobr></th>
						<th><nobr>메모리<br>사용률<br>(%)</nobr></th>
						<th><nobr>메모리<br>(GB)</nobr></th>
						<th><nobr>스토리지<br>(GB)</nobr></th>
						<th><nobr>네트워크<br>In<br>(KB/S)</nobr></th>
						<th><nobr>네트워크<br>Out<br>(KB/S)</nobr></th>
						<th><nobr>기동일시</nobr></th>
<%--						<th><nobr>가동시간</nobr></th> --%>
						<th><nobr>생성일자</nobr></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vmVo" items="${vmList }" varStatus="i">
						<c:url var="detailUrl" value="/cpt/rsrc/net/vm/selectNetVm.do">
							<c:param name="vmSeq" value="${vmVo.vmSeq }" />
						</c:url>
						<tr>
							<td><nobr><c:out value="${i.count }" /></nobr></td>
							<td>
							<nobr>
							<c:if test="${null ne vmVo.statCd}">
								<div class="server-info server
									<c:choose>
										<c:when test='${"01" eq vmVo.statCd}'><c:out value="server-down"/></c:when>
										<c:when test='${"02" eq vmVo.statCd}'><c:out value="server-up"/></c:when>
										<c:when test='${"03" eq vmVo.statCd}'><c:out value="server-inprogress"/></c:when>
										<c:when test='${"04" eq vmVo.statCd}'><c:out value="server-exception"/></c:when>
							   			<c:otherwise></c:otherwise>
									</c:choose>
								">
									<div class="server-info-body alignL">
										<div class="server-info-box alignL">
											<span class="label"></span><h4 class="stat"><c:out value="${vmVo.statCdNm }" /></h4>
										</div>
									</div>
								</div>
							</c:if>
							</nobr>
							</td>
							<td class="alignL"><nobr><c:out value="${vmVo.institutionNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${vmVo.vmJob }" /></nobr></td>
							<td class="alignL"><nobr><a href="<c:url value="${detailUrl }" />" title="<c:out value="${vmVo.vmNm }"/>"><c:out value="${vmVo.vmNm }" /></a></nobr></td>
							<td class="alignL"><nobr><a href="<c:url value="${detailUrl }" />" title="<c:out value="${vmVo.vmId }"/>"><c:out value="${vmVo.vmId }" /></a></nobr></td>
							<td class="alignL"><nobr><c:out value="${vmVo.vmCompId }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${vmVo.hstNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${vmVo.rprsntIpAddr }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${vmVo.osTyCdNm }" /></nobr></td>
							<td class="notellipsis">
								<span class="label label-green"><fmt:formatNumber value="${vmVo.cpuUseRt}" pattern="0"/></span>
								<div class="progress">
									<div class="progress-bar progress-bar-green" style="width: <fmt:formatNumber value="${vmVo.cpuUseRt}" pattern="0"/>%"></div>
								</div>
							</td>
							<td class="alignR"><nobr><c:out value="${vmVo.cpuVcoreQty }"/></nobr></td>
							<td class="notellipsis">
								<span class="label label-green"><fmt:formatNumber value="${vmVo.memUseRt}" pattern="0"/></span>
								<div class="progress">
									<div class="progress-bar progress-bar-green" style="width: <fmt:formatNumber value="${vmVo.memUseRt}" pattern="0"/>%"></div>
								</div>
							</td>
							<td class="alignR"><nobr><fmt:formatNumber value="${vmVo.memAsgnCapa}" pattern="0"/></nobr></td>
							<td class="alignR"><nobr><fmt:formatNumber value="${vmVo.strgAsgnCapa}" pattern="0"/></nobr></td>
							<td class="alignR"><nobr><fmt:formatNumber value="${vmVo.netwkIn }" pattern="0.0"/></nobr></td>
							<td class="alignR"><nobr><fmt:formatNumber value="${vmVo.netwkOut }" pattern="0.0"/></nobr></td>
							<td><nobr><fmt:formatDate value="${vmVo.strtupDttm }" pattern="yyyy-MM-dd HH:mm:ss" /></nobr></td>
<%--							<td class="alignL"><nobr><c:out value="${vmVo.uptime }" /></nobr></td> --%>
							<td><nobr><fmt:formatDate value="${vmVo.regDttm }" pattern="yyyy-MM-dd HH:mm:ss" /></nobr></td>
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
			<button type="button" class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="뒤로" data-original-title="뒤로" onclick="fn_selectNetPmList();"><i class="fa fa-arrow-left"></i></button>
		</div>
		<div class="pull-right btns">
			<menu:authorize>
				<button type="button" class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="" data-original-title="저장" onclick="fn_updateNetPm();"><i class="fa fa-check"></i></button>
			</menu:authorize>
		</div>
	</div>
</div>

<script type="text/javascript">

//뒤로
function fn_selectNetPmList(page){

	<c:choose>
		<c:when test="${not empty param.netPmSltAt and param.netPmSltAt}">
			location.href = '<c:url value="/cpt/rsrc/com/pm/selectPmList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'pmSeq'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
		</c:when>
		<c:otherwise>
			location.href = '<c:url value="selectNetPmList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'pmSeq'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
		</c:otherwise>
	</c:choose>
}

function fn_updateNetPm(){
	jConfirm('물리서버 정보를 변경 하시겠습니까?', function(){

		if(!fn_form_validation("netPmVo")){
			return;
		}

		$('#rmk').val($('#textareaRmk').val());

		var options = {
			type: 'post',
			dataType: 'json',
			success: updateNetPmResultHandler,
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

		$('#netPmVo').attr('action', 'updateNetPm.do');
		$('#netPmVo').ajaxSubmit(options);

	});
}

function updateNetPmResultHandler(result){
	if(result.success){
		jInfo(result.messageList, function(){
			location.reload();
		});
	}
	else{
		jAlert(result.messageList);
	}
}

$("#vmTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
		{sWidth : "28px" }, //No
		{sWidth : "94px" }, //상태
		{sWidth : "80px" }, //부처*
		{sWidth : "80px" }, //업무*
		{sWidth : "100px" }, //가상서버명
		{sWidth : "100px" }, //가상서버ID
		{sWidth : "85px" }, //가상서버구성ID
		{sWidth : "80px" }, //호스트명
		{sWidth : "100px" }, //IP주소
		{sWidth : "80px" }, //OS유형
		{sWidth : "40px" }, //CPU 사용률
		{sWidth : "40px" }, //CPU vCore
		{sWidth : "40px" }, //메모리 사용률
		{sWidth : "40px" }, //메모리 할당량
		{sWidth : "50px" }, //스토리지
		{sWidth : "50px" }, //네트워크In
		{sWidth : "50px" }, //네트워크Out
		{sWidth : "130px" },//기동일시
		//{sWidth : "130px" },//가동시간
		{sWidth : "130px" }//생성일자
	]

});


</script>