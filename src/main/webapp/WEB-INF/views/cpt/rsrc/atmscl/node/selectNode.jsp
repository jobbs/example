<%--
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre>노드 수정 화면</pre>
 *
 * @author x
 * @lastmodifier x
 * @created 2017. 05. 24.
 * @lastmodified 2017. 05. 24.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 05. 24.     x         v1.0             최초생성
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

<div class="col-box-100">
	<div class="col-info server
		<c:choose>
			<c:when test='${"01" eq nodeVo.statCd}'><c:out value="server-up"/></c:when>
			<c:when test='${"02" eq nodeVo.statCd}'><c:out value="server-down"/></c:when>
			<c:when test='${"03" eq nodeVo.statCd}'><c:out value="server-inprogress"/></c:when>
			<c:when test='${"04" eq nodeVo.statCd}'><c:out value="server-exception"/></c:when>
			<c:otherwise></c:otherwise>
		</c:choose>">
		<div class="col-info-body alignL">
			<div class="col-info-box alignL">
				<c:if test='${null ne nodeVo.statCd and "" ne nodeVo.statCd}'><span class="label"></span></c:if><h4 class="stat"><c:out value="${nodeVo.statCdNm}"/><c:if test='${"03" eq nodeVo.statCd}'>(<c:out value="${nodeVo.statCdNm}"/>)</c:if></h4>

				<!--
				<menu:authorize authType="act">
					<button type="button" class="btn btn-sm btn-refresh vm-sync" title="새로고침" onclick="fn_executeNodeSync();">새로고침</button>
				</menu:authorize>
				-->
			</div>
		</div>
	</div>
</div>

<div class="col-box-25 no-padding-right">
	<div class="col-info">
		<h3 class="col-info-header">CPU 보유 Core 수</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num" id="sumCpuCorQty"><fmt:formatNumber value="${nodeVo.cpuCorQty }" pattern="0"/></h4>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25 no-padding-right">
	<div class="col-info">
		<h3 class="col-info-header">CPU 할당 Core 수</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num" id="sumCpuCorQty"><fmt:formatNumber value="${nodeVo.sumCpuCorQty }" pattern="0"/></h4>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25 no-padding-right">
	<div class="col-info">
		<h3 class="col-info-header">CPU 사용률</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num" id="avgCpuUseRt"><c:out value="${nodeVo.avgCpuUseRt }" /><small>%</small></h4>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25">
	<div class="col-info">
		<h3 class="col-info-header">메모리 보유량</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num" id="sumMemAsgnCapa"><c:out value="${nodeVo.memAsgnCapa }" /><small>GB</small></h4>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25 no-padding-right">
	<div class="col-info">
		<h3 class="col-info-header">메모리 할당량</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num" id="sumMemAsgnCapa"><c:out value="${nodeVo.sumMemAsgnCapa }" /><small>GB</small></h4>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25 no-padding-right">
	<div class="col-info ">
		<h3 class="col-info-header">메모리 사용률</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num" id="avgMemUseRt"><c:out value="${nodeVo.avgMemUseRt }" /><small>%</small></h4>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25 no-padding-right">
	<div class="col-info">
		<h3 class="col-info-header">네트워크 In</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num" id="netwkIn"><fmt:formatNumber value="${nodeVo.netwkIn }" pattern="0.0"/><small>KB/Sec</small></h4>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25">
	<div class="col-info">
		<h3 class="col-info-header">네트워크 Out</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num" id="netwkOut"><fmt:formatNumber value="${nodeVo.netwkOut }" pattern="0.0"/><small>KB/Sec</small></h4>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25"> 
	<div class="col-info">
		<h3 class="col-info-header">Pod 수</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num" id="podQty"><fmt:formatNumber value="${nodeVo.podQty }" pattern="0"/></h4>
			</div>
		</div>
	</div>
</div>

<form:form id="nodeVo" commandName="nodeVo" action="updateNode.do">
<form:hidden path="regionId" title="리전ID"  />
<form:hidden path="zoneId" title="존ID"  />
<form:hidden path="netClCd" title="망구분코드"  />
<form:hidden path="rsrcPoolId" title="자원풀ID"  />
<form:hidden path="atmsclNodeId" title="노드ID"  />


<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">기본 정보</h3>
		</div>
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>노드 기본정보</caption>
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
						<td><c:out value="${nodeVo.regionNm }"/></td>
						<th>존</th>
						<td><c:out value="${nodeVo.zoneNm }"/></td>
						<th>망구분(망)</th>
						<td><c:out value="${nodeVo.netNm }"/></td>
						<th>자원풀</th>
						<td><c:out value="${nodeVo.rsrcPoolNm }"/></td>
					</tr>
					<tr>
						<th><label for="atmsclNodeNm"><span class="text-red">*</span>노드명</label></th>
						<td>
							<form:input path="atmsclNodeNm" type="text" class="form-control essential"  title="노드명" maxlength="50" />
						</td>
						<th>노드유형</th>
						<td>
							<c:out value="${nodeVo.atmsclNodeTyCdNm }"/>
						</td>
						<th>IP주소</th>
						<td colspan="3"><c:out value="${nodeVo.atmsclNodeIpAddr }"/></td>
					</tr>
					<tr>
						<th>비고</th>
						<td colspan="7">
					    	<form:textarea path="rmk" cssClass="form-control" title="비고" rows="3" maxlength="1000" />
						</td>
					</tr>
					<tr>
						<th>생성자</th>
						<td><c:out value="${nodeVo.creUserNm }"/></td>
						<th>생성일자</th>
						<td><c:out value="${nodeVo.creDttm }"/></td>
						<th>수정자</th>
						<td><c:out value="${nodeVo.updtUserNm }"/></td>
						<th>수정일자</th>
						<td><c:out value="${nodeVo.updtDttm }"/></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

<div class="col-box-100 detail-col">
	<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">Pod 정보</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>
		<!-- box-body -->
		<div class="box-body no-padding detail-list-body" >
			<table class="table table-vertical table-layout-fixed" id="servcPodTable">
				<caption>Pod 목록</caption>
	    			<thead>
						<tr>
							<th>No.</th>
							<th>부처명</th>
							<th>업무명</th>
							<th>서비스명</th>
							<th>Pod명</th>
							<th>상태</th>
							<th>CPU<br>Core</th>
							<th>CPU<br>사용률(%)</th>
							<th>메모리<br>할당량(GB)</th>
							<th>메모리<br>사용률(%)</th>
							<th>네트워크<br>In(KB/Sec)</th>
							<th>네트워크<br>Out(KB/Sec)</th>
							<th>생성일시</th>
		       			</tr>
	      			</thead>
	      			<tbody>
	      			<c:forEach var="servcPodVo" items="${servcPodList }" varStatus="i">
	      				<tr>
							<td><c:out value="${(i.count)}" /></td>
							<td class="alignL"><c:out value="${servcPodVo.institutionNm }" /></td>
							<td class="alignL"><c:out value="${servcPodVo.jobNm }" /></td>
							<td class="alignL"><c:out value="${servcPodVo.servcNm }" /></td>
							<td class="alignL"><c:out value="${servcPodVo.podNm }" /></td>
							<td class="alignC">
								<!-- 진행중 01: 완료:02, 실패 03: New: 04 , Pending:05, 기타:06 -->
		                		<span class="status <c:choose>
		                								<c:when test="${'01' eq servcPodVo.statCd}"><c:out value="status-blue"/></c:when>
		                								<c:when test="${'02' eq servcPodVo.statCd}"><c:out value="status-green"/></c:when>
		                								<c:when test="${'03' eq servcPodVo.statCd}"><c:out value="status-red"/></c:when>
														<c:otherwise><c:out value="status-gray"/></c:otherwise>
		                							</c:choose>
		                			status-red "><c:out value="${servcPodVo.statCdNm}"/>
		                		</span>
							</td>
							<td class="alignR"><c:out value="${servcPodVo.cpuCorQty }" /></td>
							<td class="alignR"><c:out value="${servcPodVo.cpuUseRt }" /></td>
							<td class="alignR"><c:out value="${servcPodVo.memAsgnCapa }" /></td>
							<td class="alignR"><c:out value="${servcPodVo.memUseRt }" /></td>
							<td class="alignR"><c:out value="${servcPodVo.netwkIn }" /></td>
							<td class="alignR"><c:out value="${servcPodVo.netwkOut }" /></td>
							<td><c:out value="${servcPodVo.creDttm }" /></td>
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
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="뒤로" data-original-title="뒤로" onclick="fn_selectNodeList()"><i class="fa fa-arrow-left"></i></button>
		</div>
		<div class="pull-right btns">
			<menu:authorize onlyOprAdm="true">
				<button type="button" class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="저장" data-original-title="저장" onclick="fn_updateNode();"><i class="fa fa-check"></i></button>
			</menu:authorize>
		</div>
	</div>
</div>

<script type="text/javascript">

// 뒤로 버튼 클릭 시
function fn_selectNodeList(){
	location.href = '<c:url value="selectNodeList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'nodeRsrcPoolId' && pageParam.key ne 'atmsclNodeId' }"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
}

// 저장 버튼 클릭 시
function fn_updateNode(){

	if(!fn_form_validation("nodeVo")){
		return;
	}

	jConfirm('노드정보를 저장 하시겠습니까?', function(){

		var options = {
			type: 'post',
			dataType: 'json',
			success: updateNodeResultHandler,
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

		$('#nodeVo').attr('action', '<c:url value="updateNode.do"/>');
		$('#nodeVo').ajaxSubmit(options);

	});
}

// 저장 결과 콜백
function updateNodeResultHandler(result){

	if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

	if(result.success){
		jInfo("저장되었습니다.", function(){
			if(result.procType == "update") {
				location.href = '<c:url value="selectNodeList.do"/>';
			}
		});
	}else{
		jAlert(result.messageList);
	}
}

//새로고침
function fn_executeNodeSync() {
	alert("API 제공 흐 개발예정!");
}



$("#servcPodTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
		{sWidth : "28px" }, //No
		{sWidth : "150px" }, //부처
		{sWidth : "140px" }, //업무
		{sWidth : "140px" }, //서비스명
		{sWidth : "172px" }, //Pod명
		{sWidth : "70px" }, //상태
		{sWidth : "70px" }, //CPU 사용률
		{sWidth : "70px" }, //CPU vCore
		{sWidth : "80px" }, //메모리 사용률
		{sWidth : "80px" }, //메모리 할당량
		{sWidth : "80px" }, //네트워크In
		{sWidth : "80px" }, //네트워크Out
		{sWidth : "120px" },//생성일시
	]

});

</script>
