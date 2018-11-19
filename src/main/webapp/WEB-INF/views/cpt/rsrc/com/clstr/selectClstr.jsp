<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>클러스터 상세 화면</pre>
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

<c:set var="hasAuthWrite" value="${menu:hasAuthWrite(requestScope['javax.servlet.forward.request_uri'],pageContext.request.contextPath) }" />

<!-- 등록/상세 영역 -->
<div class="col-box-25 no-padding-right">
	<div class="col-info">
		<h3 class="col-info-header">물리서버수</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num"><c:out value="${clstrVo.pmCnt }" /><small>대</small></h4>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25 no-padding-right">
	<div class="col-info">
		<h3 class="col-info-header">가상서버수</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num"><c:out value="${clstrVo.vmCnt }" /><small>대</small></h4>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25 no-padding-right">
	<div class="col-info">
		<h3 class="col-info-header">CPU 사용률</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num"><fmt:formatNumber value="${clstrVo.avgCpuUseRt}" pattern="0"/><small>%</small></h4>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25">
	<div class="col-info">
		<h3 class="col-info-header">CPU 가상화율</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num"><fmt:formatNumber value="${clstrVo.cpuVrlzRt}" pattern="0"/><small>% (<c:out value="${clstrVo.totCpuVcoreQty }"/>/<c:out value="${clstrVo.totCpuCoreQty }"/>)</small></h4>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25 no-padding-right">
	<div class="col-info">
		<h3 class="col-info-header">메모리 사용률</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num"><fmt:formatNumber value="${clstrVo.avgMemUseRt}" pattern="0"/><small>%</small></h4>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25 no-padding-right">
	<div class="col-info">
		<h3 class="col-info-header">메모리 가상화율</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num"><fmt:formatNumber value="${clstrVo.memVrlzRt}" pattern="0"/><small>% (<fmt:formatNumber value="${clstrVo.totMemAsgnCapa}" pattern="0"/>/<fmt:formatNumber value="${clstrVo.totMemCapa}" pattern="0"/>)</small></h4>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25 no-padding-right">
	<div class="col-info">
		<h3 class="col-info-header">네트워크 In</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num"><fmt:formatNumber value="${clstrVo.totNetwkIn }" pattern="0.0"/><small>KB/Sec</small></h4>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25">
	<div class="col-info">
		<h3 class="col-info-header">네트워크 Out</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num"><fmt:formatNumber value="${clstrVo.totNetwkOut }" pattern="0.0"/><small>KB/Sec</small></h4>
			</div>
		</div>
	</div>
</div>

<form:form id="clstrVo" commandName="clstrVo" enctype="multipart/form-data">
<div class="col-box-100 detail-col">
	<c:set var="clstrVoClass" value="ncis.cpt.rsrc.com.vo.ClstrVo"/>
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
			<form:hidden path="clstrSeq" value="${clstrVo.clstrSeq}"/>
	  		<table class="table table-horizon table-layout_fixed">
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
						<th>센터</th>
						<td><c:out value="${clstrVo.regionNm }" /></td>
						<th>존</th>
						<td><c:out value="${clstrVo.zoneNm }" /></td>
						<th>망구분(망)</th>
						<td><c:out value="${clstrVo.netNm }" />(<c:out value="${clstrVo.netClCdNm }" />)</td>
						<th>자원풀</th>
						<td><c:out value="${clstrVo.rsrcPoolNm }" /></td>
					</tr>
					<tr>
						<th>클러스터명</th>
						<td>
							<c:choose>
								<c:when test="${hasAuthWrite}">
									<form:input path="clstrNm" name="clstrNm" title="클러스터 명" cssClass="form-control" value="${clstrVo.clstrNm }" maxlength="${ivu.getMaxlength(clstrVoClass, 'clstrNm', groupClass)}" cssStyle="width:160px;"/>
								</c:when>
								<c:otherwise>
									<form:input path="clstrNm" name="clstrNm" title="클러스터 명" cssClass="form-control" value="${clstrVo.clstrNm }" maxlength="${ivu.getMaxlength(clstrVoClass, 'clstrNm', groupClass)}" cssStyle="width:160px;" disabled="true"/>
								</c:otherwise>
							</c:choose>
						</td>
						<th>클러스터ID</th>
						<td><c:out value="${clstrVo.clstrId }" /></td>
						<th>가상화SW</th>
						<td><c:out value="${clstrVo.vrlzSwTyCdNm }" /></td>
						<th>스토리지 할당량 (TB)</th>
						<td><fmt:formatNumber value="${clstrVo.totStrgAsgnCapa / 1024 }" pattern="0.0"/></td>
					</tr>
					<tr>
						<th><span class="text-red">*</span>용도</th>
						<td colspan="7">
							<div class="input-group input-group-check">
								<c:forEach var="prposClCd" items="${prposClCdList }">
									<c:set var="contains" value="false"/>
									<c:forEach var="clstrPrposVo" items="${clstrVo.clstrPrposVoList }">
										<c:if test="${clstrPrposVo.prposClCd eq prposClCd.cd}">
											<c:set var="contains" value="true"/>
										</c:if>
									</c:forEach>
									<c:choose>
										<c:when test="${contains}">
											<c:choose>
												<c:when test="${hasAuthWrite}">
													<form:checkbox path="prposClCdList" name="prposClCdList" title="용도" cssClass="essentialBy" essentialBy="prposClCdList" value="${prposClCd.cd}" id="${prposClCd.cd}" checked="true"/>
												</c:when>
												<c:otherwise>
													<form:checkbox path="prposClCdList" name="prposClCdList" title="용도" cssClass="essentialBy" essentialBy="prposClCdList" value="${prposClCd.cd}" id="${prposClCd.cd}" checked="true" disabled="true"/>
												</c:otherwise>
											</c:choose>
										</c:when>
										<c:otherwise>
											<c:choose>
												<c:when test="${hasAuthWrite}">
													<form:checkbox path="prposClCdList" name="prposClCdList" title="용도" cssClass="essentialBy" essentialBy="prposClCdList" value="${prposClCd.cd}" id="${prposClCd.cd}"/>
												</c:when>
												<c:otherwise>
													<form:checkbox path="prposClCdList" name="prposClCdList" title="용도" cssClass="essentialBy" essentialBy="prposClCdList" value="${prposClCd.cd}" id="${prposClCd.cd}" disabled="true"/>
												</c:otherwise>
											</c:choose>
										</c:otherwise>
									</c:choose>
									<label for="${prposClCd.cd}"><c:out value="${prposClCd.cdNm}"/></label>
								</c:forEach>
							</div>
						</td>
					</tr>
					<tr>
						<th><span class="text-red">*</span>사용여부</th>
						<td colspan="7">
							<div class="input-group input-group-radio">
								<c:choose>
									<c:when test="${hasAuthWrite}">
										<form:radiobutton path="useYn" name="useYn" cssClass="essential" title="사용여부" label="사용" value="Y"/>
										<form:radiobutton path="useYn" name="useYn" cssClass="essential" title="사용여부" label="미사용" value="N"/>
									</c:when>
									<c:otherwise>
										<form:radiobutton path="useYn" name="useYn" cssClass="essential" title="사용여부" label="사용" value="Y" disabled="true"/>
										<form:radiobutton path="useYn" name="useYn" cssClass="essential" title="사용여부" label="미사용" value="N" disabled="true"/>
									</c:otherwise>
								</c:choose>
							</div>
						</td>
					</tr>
					<tr>
						<th>클러스터구성ID</th>
						<td colspan="7">
							<c:choose>
								<c:when test="${hasAuthWrite}">
									<form:input path="clstrCompId" name="clstrCompId" title="클러스터구성ID" cssClass="form-control" value="${clstrVo.clstrCompId }" maxlength="${ivu.getMaxlength(clstrVoClass, 'clstrCompId', groupClass)}" cssStyle="width:160px;"/>
								</c:when>
								<c:otherwise>
									<form:input path="clstrCompId" name="clstrCompId" title="클러스터구성ID" cssClass="form-control" value="${clstrVo.clstrCompId }" maxlength="${ivu.getMaxlength(clstrVoClass, 'clstrCompId', groupClass)}" cssStyle="width:160px;" disabled="true"/>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th>비고</th>
						<td colspan="7">
							<form:hidden path="rmk" name="rmk" title="비고" value="${clstrVo.rmk }"/>
							<c:choose>
								<c:when test="${hasAuthWrite}">
									<textarea id="textareaRmk" title="비고" class="form-control" rows="3" maxlength="${ivu.getMaxlength(clstrVoClass, 'rmk', groupClass)}" placeholder="내용을 입력해 주세요."><c:out value="${clstrVo.rmk }"/></textarea>
								</c:when>
								<c:otherwise>
									<textarea id="textareaRmk" title="비고" class="form-control" rows="3" maxlength="${ivu.getMaxlength(clstrVoClass, 'rmk', groupClass)}" placeholder="내용을 입력해 주세요." disabled><c:out value="${clstrVo.rmk }"/></textarea>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<!-- 수평형 테이블 -->
	<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">물리서버 정보</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>
		<!-- box-body -->
		<div class="box-body no-padding detail-list-body" >
			<table id="pmTable" class="table table-hover table-vertical table-layout-fixed">
				<caption>물리서버 정보</caption>
				<thead>
					<tr>
						<th><nobr title="No.">No.</nobr></th>
						<th><nobr title="상태">상태</nobr></th>
						<th><nobr title="물리서버명">물리서버명</nobr></th>
						<th><nobr title="물리서버구성ID">물리서버구성ID</nobr></th>
						<th><nobr title="IP주소">IP주소</nobr></th>
						<th><nobr title="가상화SW">가상화SW</nobr></th>
						<th><nobr title="가상서버수">가상서버수</nobr></th>
						<th><nobr title="CPU 사용률 (%)">CPU<br>사용률<br>(%)</nobr></th>
						<th><nobr title="CPU 사용률 (%)">CPU<br>가상화율<br>(%)</nobr></th>
						<th><nobr title="CPU vCore">CPU<br>vCore</nobr></th>
						<th><nobr title="CPU Core">CPU<br>Core</nobr></th>
						<th><nobr title="메모리 사용률 (%)">메모리<br>사용률<br>(%)</nobr></th>
						<th><nobr title="메모리 가상화율 (%)">메모리<br>가상화율<br>(%)</nobr></th>
						<th><nobr title="메모리 할당량 (GB)">메모리<br>할당량<br>(GB)</nobr></th>
						<th><nobr title="메모리 전체량 (GB)">메모리<br>전체량<br>(GB)</nobr></th>
						<th><nobr title="스토리지 (GB)">스토리지<br>할당량<br>(GB)</nobr></th>
						<th><nobr title="네트워크 In (KB/S)">네트워크<br>In<br>(KB/S)</nobr></th>
						<th><nobr title="네트워크 Out (KB/S)">네트워크<br>Out<br>(KB/S)</nobr></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="pmVo" items="${pmVoList }" varStatus="i">
						<c:url var="selectPmUrl" value="/cpt/rsrc/com/pm/selectPm.do">
							<c:param name="pmSeq" value="${pmVo.pmSeq }" />
							<c:forEach var="pageParam" items="${param}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:forEach>
						</c:url>
						<tr>
							<td><nobr title="<c:out value="${i.count }" />"><c:out value="${i.count }" /></nobr></td>
							<td class="alginL">
								<nobr>
									<c:if test="${null ne pmVo.statCd}">
										<div class="server-info server
											<c:choose>
												<c:when test='${"01" eq pmVo.statCd}'><c:out value="server-down"/></c:when>
												<c:when test='${"02" eq pmVo.statCd}'><c:out value="server-up"/></c:when>
												<c:when test='${"03" eq pmVo.statCd}'><c:out value="server-maintain"/></c:when>
												<c:when test='${"04" eq pmVo.statCd}'><c:out value="server-inprogress"/></c:when>
												<c:when test='${"05" eq pmVo.statCd}'><c:out value="server-exception"/></c:when>
									   			<c:otherwise></c:otherwise>
											</c:choose>
										">
											<div class="server-info-body alignL">
												<div class="server-info-box alignL">
													<span title="<c:out value="${pmVo.statCdNm }" />" class="label"></span><h4 title="<c:out value="${pmVo.statCdNm }" />" class="stat"><c:out value="${pmVo.statCdNm }" /></h4>
												</div>
											</div>
										</div>
									</c:if>

 									<%--<c:choose>
										<c:when test='${"01" eq pmVo.statCd}'>
											<span class="status status-gray"><c:out value="${pmVo.statCdNm }" /></span>
										</c:when>
										<c:when test='${"02" eq pmVo.statCd}'>
											<span class="status status-green"><c:out value="${pmVo.statCdNm }" /></span>
										</c:when>
										<c:when test='${"03" eq pmVo.statCd}'>
											<span class="status status-yellow"><c:out value="${pmVo.statCdNm }" /></span>
										</c:when>
										<c:when test='${"04" eq pmVo.statCd}'>
											<span class="status status-blue"><c:out value="${pmVo.statCdNm }" /></span>
										</c:when>
										<c:when test='${"05" eq pmVo.statCd}'>
											<span class="status status-red"><c:out value="${pmVo.statCdNm }" /></span>
										</c:when>
										<c:otherwise>
										</c:otherwise>
									</c:choose>--%>
 								</nobr>
							</td>
							<td class="alignL"><nobr>
								<c:if test="${pmVo.pmNm ne null}">
									<a href="<c:url value="${selectPmUrl }" />" title="<c:out value="${pmVo.pmNm }"/>"><c:out value="${pmVo.pmNm }" /></a>
								</c:if>
							</nobr></td>
							<td><nobr>
								<c:if test="${pmVo.pmCompId ne null}">
									<a href="<c:url value="${selectPmUrl }" />" title="<c:out value="${pmVo.pmCompId }"/>"><c:out value="${pmVo.pmCompId }" /></a>
								</c:if>
							</nobr></td>
							<td class="alignL"><nobr title="<c:out value="${pmVo.rprsntIpAddr }" />"><c:out value="${pmVo.rprsntIpAddr }" /></nobr></td>
							<td class="alignL"><nobr title="<c:out value="${pmVo.vrlzSwTyCdNm }" />"><c:out value="${pmVo.vrlzSwTyCdNm }" /></nobr></td>
							<td class="alignR"><nobr title="<c:out value="${pmVo.vmCnt }" />"><c:out value="${pmVo.vmCnt }" /></nobr></td>
							<td class="notellipsis">
								<span title="<fmt:formatNumber value="${pmVo.cpuUseRt}" pattern="0"/>" class="label label-green"><fmt:formatNumber value="${pmVo.cpuUseRt}" pattern="0"/></span>
								<div title="<fmt:formatNumber value="${pmVo.cpuUseRt}" pattern="0"/>" class="progress">
									<div class="progress-bar progress-bar-green" style="width: <fmt:formatNumber value="${pmVo.cpuUseRt}" pattern="0"/>%"></div>
								</div>
							</td>
							<td class="alignR"><nobr title="<fmt:formatNumber value="${pmVo.cpuVrlzRt}" pattern="0"/>"><fmt:formatNumber value="${pmVo.cpuVrlzRt}" pattern="0"/></nobr></td>
							<td class="alignR"><nobr title="<c:out value="${pmVo.totCpuVcoreQty }" />"><c:out value="${pmVo.totCpuVcoreQty }"/></nobr></td>
							<td class="alignR"><nobr title="<c:out value="${pmVo.cpuCoreQty }" />"><c:out value="${pmVo.cpuCoreQty }"/></nobr></td>
							<td class="notellipsis">
								<span title="<fmt:formatNumber value="${pmVo.memUseRt}" pattern="0"/>" class="label label-green"><fmt:formatNumber value="${pmVo.memUseRt}" pattern="0"/></span>
								<div title="<fmt:formatNumber value="${pmVo.memUseRt}" pattern="0"/>" class="progress">
									<div class="progress-bar progress-bar-green" style="width: <fmt:formatNumber value="${pmVo.memUseRt}" pattern="0"/>%"></div>
								</div>
							</td>
							<td class="alignR"><nobr title="<fmt:formatNumber value="${pmVo.memVrlzRt}" pattern="0"/>"><fmt:formatNumber value="${pmVo.memVrlzRt}" pattern="0"/></nobr></td>
							<td class="alignR"><nobr title="<fmt:formatNumber value="${pmVo.totMemAsgnCapa}" pattern="0"/>"><fmt:formatNumber value="${pmVo.totMemAsgnCapa}" pattern="0"/></nobr></td>
							<td class="alignR"><nobr title="<fmt:formatNumber value="${pmVo.memCapa}" pattern="0"/>"><fmt:formatNumber value="${pmVo.memCapa}" pattern="0"/></nobr></td>
							<td class="alignR"><nobr title="<fmt:formatNumber value="${pmVo.totStrgAsgnCapa}" pattern="0"/>"><fmt:formatNumber value="${pmVo.totStrgAsgnCapa}" pattern="0"/></nobr></td>
							<td class="alignR"><nobr title="<fmt:formatNumber value="${pmVo.netwkIn}" pattern="0.0"/>"><fmt:formatNumber value="${pmVo.netwkIn }" pattern="0.0"/></nobr></td>
							<td class="alignR"><nobr title="<fmt:formatNumber value="${pmVo.netwkOut}" pattern="0.0"/>"><fmt:formatNumber value="${pmVo.netwkOut }" pattern="0.0"/></nobr></td>
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
			<button type="button" class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="뒤로" data-original-title="뒤로" onclick="fn_selectClstrList();"><i class="fa fa-arrow-left"></i></button>
		</div>
		<div class="pull-right btns">
			<menu:authorize>
				<button type="button" class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="저장" data-original-title="저장" onclick="fn_updateClstr();"><i class="fa fa-check"></i></button>
			</menu:authorize>
		</div>
	</div>
</div>



<script type="text/javascript">

//뒤로
function fn_selectClstrList(){
	location.href = '<c:url value="selectClstrList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'clstrSeq'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
}


function fn_updateClstr(){

	if(!fn_form_validation("clstrVo")){
		return;
	}

	if(fn_form_is_same_default_value('clstrVo')){
		return;
	}


	jConfirm('클러스터 정보를 변경 하시겠습니까?', function(){

		$('#rmk').val($('#textareaRmk').val());

		var options = {
			type: 'post',
			dataType: 'json',
			success: updateClstrResultHandler,
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

		$('#clstrVo').attr('action', '<c:url value="updateClstr.do"/>');
		$('#clstrVo').ajaxSubmit(options);

	});
}

function updateClstrResultHandler(result){

	if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

	if(result.success){
		jInfo(result.messageList, function(){
			location.reload();
		});
	}
	else{
		alert_message(result.messageList, function(){
			if(result.data != null){
				var inputName = getDomName(result.data);
				setTimeout(function(){$(inputName).focus();},0);
			}
		});
	}

}

function getDomName(obj){
	return ((obj.child != null) ? ('[name*="' + obj.name + '"]' + getDomName(obj.child)) : ('[name*="' + obj.name + '"]'));
}

$("#pmTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
		{sWidth : "28px" }, //No.
		{sWidth : "94px" }, //상태
		{sWidth : "120px" }, //물리서버명*
		{sWidth : "84px" }, //물리서버구성ID*
		{sWidth : "100px" }, //IP주소
		{sWidth : "100px" }, //가상화SW
		{sWidth : "60px" }, //가상서버수
		{sWidth : "40px" }, //CPU 사용률
		{sWidth : "50px" }, //CPU 가상화율
		{sWidth : "40px" }, //CPU vCore
		{sWidth : "40px" }, //CPU Core
		{sWidth : "40px" }, //메모리 사용률
		{sWidth : "50px" }, //메모리 가상화율
		{sWidth : "40px" }, //메모리 할당량
		{sWidth : "40px" }, //메모리 전체량
		{sWidth : "50px" }, //스토리지
		{sWidth : "50px" }, //네트워크In
		{sWidth : "50px" }, //네트워크Out
	],
	order : [],
});

</script>
