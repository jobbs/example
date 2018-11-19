﻿<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>가상서버 정보 화면</pre>
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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>

<c:set var="hasAuthWrite" value="${menu:hasAuthWrite(requestScope['javax.servlet.forward.request_uri'],pageContext.request.contextPath) }" />
<c:set var="hasMigrProcss" value="${false}"/>
<c:if test="${vmVo.vmProcssMsgVoList ne null and !empty vmVo.vmProcssMsgVoList }">
	<div class="col-box-100" id="vmProcssMsgList">
		<div class="col-info">
			<h3 class="col-info-header">처리중인 작업</h3>
			<div class="col-info-body">
				<div class="col-info-box alignL">
					<c:forEach var="vmProcssMsgVo" items="${vmVo.vmProcssMsgVoList }" varStatus="i"><c:choose><c:when test="${null ne vmProcssMsgVo.rsrcReqSeq and null ne vmProcssMsgVo.rsrcReqNo}"><c:url var="selectProcssPUrl" value="/cpt/opr/req/rsrcreq/selectRsrcReqExeListP.do"><c:param name="rsrcReqNo" value="${vmProcssMsgVo.rsrcReqNo}"/><c:param name="rsrcReqSeq" value="${vmProcssMsgVo.rsrcReqSeq}"/></c:url><span class="status status-gray mg-right-5" style="font-size:14px;cursor:pointer;" onclick="fn_procssStatOpen('<c:url value="${selectProcssPUrl}"/>');"><c:out value="${vmProcssMsgVo.procssClCdNm }"/></span></c:when><c:when test="${null ne vmProcssMsgVo.procssInstSeq }"><c:if test='${false eq hasMigrProcss and "05" eq vmProcssMsgVo.procssClCd }'><c:set var="hasMigrProcss" value="${true}"/></c:if><c:url var="selectProcssPUrl" value="/cpt/opr/req/rsrcreq/selectRsrcReqExeListMigrP.do"><c:param name="procssInstSeq" value="${vmProcssMsgVo.procssInstSeq}"/></c:url><span class="status status-gray mg-right-5" style="font-size:14px;cursor:pointer;" onclick="fn_procssStatOpen('<c:url value="${selectProcssPUrl}"/>');"><c:out value="${vmProcssMsgVo.procssClCdNm }"/></span></c:when><c:otherwise></c:otherwise></c:choose></c:forEach>
				</div>
			</div>
		</div>
	</div>
</c:if>

<div class="col-box-100">
	<div class="col-info server <c:choose><c:when test='${"02" eq vmVo.statGrpCd}'><c:out value="server-up"/></c:when><c:when test='${"01" eq vmVo.statGrpCd}'><c:out value="server-down"/></c:when><c:when test='${"03" eq vmVo.statGrpCd}'><c:out value="server-inprogress"/></c:when><c:when test='${"04" eq vmVo.statGrpCd}'><c:out value="server-exception"/></c:when><c:otherwise></c:otherwise></c:choose>">
		<div class="col-info-body alignL">
			<div class="col-info-box alignL">
				<c:if test='${null ne vmVo.statGrpCd and "" ne vmVo.statGrpCd}'><span class="label"></span></c:if><h4 class="stat"><c:out value="${vmVo.statGrpCdNm}"/><c:if test='${"03" eq vmVo.statGrpCd}'>(<c:out value="${vmVo.statCdNm}"/>)</c:if></h4>
				<menu:authorize authType="act">
					<button type="button" class="btn btn-sm btn-refresh vm-sync" title="새로고침" onclick="fn_executeVmStatSync('1');">새로고침</button>
					<button type="button" class="btn btn-sm btn-refresh vm-sync" title="모니터링" onclick="fn_openVmMon('${vmVo.vmSeq}');">모니터링</button>
				</menu:authorize>
			</div>
			<div class="col-info-box alignR">
				<div class="col-info-btn">
					<c:if test='${"Y" eq vmVo.ctlTrgtYn }'>
						<menu:authorize authType="act">
							<button type="button" class="btn vm-start" title="시작" onclick="fn_executeVmStart();" <c:if test='${"01" ne vmVo.statGrpCd}'><c:out value="disabled"/></c:if>><i class="fa fa-play-circle"></i><span>시작</span></button>
							<c:if test='${"03" ne vmVo.vrlzSwTyCd}'>
								<button type="button" class="btn vm-shutdown" title="중지" onclick="fn_executeVmShutdown();" <c:if test='${"02" ne vmVo.statGrpCd}'><c:out value="disabled"/></c:if>><i class="fa fa-ban"></i><span>중지</span></button>
							</c:if>
							<button type="button" class="btn vm-restart" title="재시작" onclick="fn_executeVmRestart();" <c:if test='${"02" ne vmVo.statGrpCd}'><c:out value="disabled"/></c:if>><i class="fa fa-spinner"></i><span>재시작</span></button>
							<c:if test='${"04" ne vmVo.vrlzSwTyCd}'>
								<button type="button" class="btn vm-stop" title="강제종료" onclick="fn_executeVmStop();" <c:if test='${"02" ne vmVo.statGrpCd}'><c:out value="disabled"/></c:if>><i class="fa fa-power-off"></i><span>강제종료</span></button>
							</c:if>
						</menu:authorize>
						<menu:authorize authType="act" onlyOprAdm="true">
							<button type="button" class="btn btn-green vm-migr" title="마이그레이션" style="width:90px;" onclick="fn_executeVmMigr();"
								<c:if test='${(vmVo.vmProcssMsgVoList eq null or empty vmVo.vmProcssMsgVoList) and (("02" ne vmVo.statGrpCd and ("01" eq vmVo.vrlzSwTyCd or "03" eq vmVo.vrlzSwTyCd or "04" eq vmVo.vrlzSwTyCd)) or ("01" ne vmVo.statGrpCd and ("02" eq vmVo.vrlzSwTyCd )))}'>
									<c:out value="disabled"/>
								</c:if>
							><i class="fa fa-cloud-download"></i><span>마이그레이션</span></button>
						</menu:authorize>
						<menu:authorize authType="act">
							<c:if test='${"01" eq vmVo.vrlzSwTyCd and (not fn:contains(vmVo.rsrcPoolId, "3.4") or fn:contains(vmVo.rsrcPoolVersion, "4."))}'>
								<button type="button" class="btn btn-blue dropdown shortcut-menu vm-rc" title="원격콘솔" style="width:90px;" onclick="fn_executeVmRc();" <c:if test='${"01" eq vmVo.statGrpCd}'><c:out value="disabled"/></c:if>><i class="fa fa-desktop"></i><span>원격콘솔</span></button>
							</c:if>
						</menu:authorize>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- 등록/상세 영역 -->
<div class="col-box-25 no-padding-right">
	<div class="col-info">
		<h3 class="col-info-header">CPU 사용률</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num" id="cpuUseRt">
				<c:out value="${vmVo.cpuUseRt }" /><small>%</small></h4>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25 no-padding-right">
	<div class="col-info">
		<h3 class="col-info-header">메모리 사용률</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num" id="memUseRt"><c:out value="${vmVo.memUseRt }" /><small>%</small></h4>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25 no-padding-right">
	<div class="col-info">
		<h3 class="col-info-header">네트워크 In</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num" id="netwkIn"><fmt:formatNumber value="${vmVo.netwkIn }" pattern="0.0"/><small>KB/Sec</small></h4>
			</div>
		</div>
	</div>
</div>

<div class="col-box-25">
	<div class="col-info">
		<h3 class="col-info-header">네트워크 Out</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num" id="netwkOut"><fmt:formatNumber value="${vmVo.netwkOut }" pattern="0.0"/><small>KB/Sec</small></h4>
			</div>
		</div>
	</div>
</div>


<div class="col-box-100 detail-col">
	<c:set var="vmVoClass" value="ncis.cpt.rsrc.com.vo.VmVo"/>
	<c:set var="groupClass" value="ncis.cmn.validation.groups.UpdateProc"/>

	<form:form id="vmVo" commandName="vmVo" enctype="multipart/form-data">
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
				<form:hidden path="vmSeq"/>
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
							<td><c:out value="${vmVo.regionNm }" /></td>
							<th>존</th>
							<td><c:out value="${vmVo.zoneNm }" /></td>
							<th>망구분(망)</th>
							<td><c:out value="${vmVo.netClCdNm }" />(<c:out value="${vmVo.netNm }" />)</td>
							<th>자원풀</th>
							<td><c:out value="${vmVo.rsrcPoolNm }" /></td>
						</tr>
						<tr>
							<th>클러스터명</th>
							<td><c:out value="${vmVo.clstrNm }" /></td>
							<th>물리서버명</th>
							<td><c:out value="${vmVo.pmNm }" /></td>
							<th>부처</th>
							<td><c:out value="${vmVo.institutionNm }" /></td>
							<th>업무</th>
							<td><c:out value="${vmVo.jobsNm }" /></td>
						</tr>
						<tr>
							<th>가상화SW</th>
							<td><c:out value="${vmVo.vrlzSwTyCdNm }" /></td>
							<th>가상서버명</th>
							<td><c:out value="${vmVo.vmNm }" /></td>
							<th>가상서버ID</th>
							<td><c:out value="${vmVo.vmId }" /></td>
							<th>호스트명</th>
							<td><c:out value="${vmVo.hstNm }" /></td>

						</tr>
						<tr>
							<th>IP주소</th>
							<td><c:out value="${vmVo.rprsntIpAddr }" /></td>
							<th>OS유형</th>
							<td><c:out value="${vmVo.osTyCdNm }" /></td>
							<th>운영체제</th>
							<td colspan="3"><c:out value="${vmVo.osNm }" /></td>
						</tr>
						<tr>
							<th>CPU (vCore)</th>
							<td><c:out value="${vmVo.cpuVcoreQty }" /></td>
							<th>CPU (Ent)</th>
							<td><c:out value="${vmVo.cpuEnt }" /></td>
							<th>메모리 (GB)</th>
							<td><c:out value="${vmVo.memAsgnCapa }" /></td>
							<th>스토리지 (GB)</th>
							<td><c:out value="${vmVo.strgAsgnCapa}" /></td>
						</tr>
						<tr>
							<th>서비스기간</th>
							<td colspan="3">
								<c:choose>
									<c:when test="${vmVo.servcStrtDt ne null }">
										<fmt:formatDate value="${vmVo.servcStrtDt }" pattern="YYYY-MM-dd"/> ~ <fmt:formatDate value="${vmVo.servcEndDt }" pattern="YYYY-MM-dd"/>
									</c:when>
									<c:otherwise>
										영구
									</c:otherwise>
								</c:choose>
							</td>
							<th>생성일시</th>
							<td id="creDttm">
								<fmt:formatDate value="${vmVo.creDttm }" pattern="yyyy-MM-dd HH:mm:ss" />
							</td>
							<th>기동일시</th>
							<td id="strtupDttm">
								<fmt:formatDate value="${vmVo.strtupDttm }" pattern="yyyy-MM-dd HH:mm:ss" />
							</td>
						</tr>
						<tr>
							<th>가상서버구성ID</th>
							<td colspan="7">
								<%-- 변경전 구성ID --%>
								<c:choose>
									<c:when test="${hasAuthWrite}">
										<form:input path="vmCompId" name="vmCompId" title="가상서버구성ID" cssClass="form-control" value="${vmVo.vmCompId }" maxlength="${ivu.getMaxlength(vmVoClass, 'vmCompId', groupClass)}" cssStyle="width:160px;"/>
									</c:when>
									<c:otherwise>
										<form:input path="vmCompId" name="vmCompId" title="가상서버구성ID" cssClass="form-control" value="${vmVo.vmCompId }" maxlength="${ivu.getMaxlength(vmVoClass, 'vmCompId', groupClass)}" cssStyle="width:160px;" disabled="true"/>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<th>비고</th>
							<td colspan="7">
								<form:hidden path="rmk" name="rmk" title="비고" value="${vmVo.rmk }"/>
								<c:choose>
									<c:when test="${hasAuthWrite}">
										<textarea id="textareaRmk" title="비고" class="form-control" rows="3" maxlength="${ivu.getMaxlength(vmVoClass, 'rmk', groupClass)}" placeholder="내용을 입력해 주세요."><c:out value="${vmVo.rmk }"/></textarea>
									</c:when>
									<c:otherwise>
										<textarea id="textareaRmk" title="비고" class="form-control" rows="3" maxlength="${ivu.getMaxlength(vmVoClass, 'rmk', groupClass)}" placeholder="내용을 입력해 주세요." disabled><c:out value="${vmVo.rmk }"/></textarea>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</form:form>

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
				<caption>담당자 정보</caption>
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
						<c:when test="${vmVo.oprRelateChargerVoList eq null or empty vmVo.oprRelateChargerVoList }">
							<tr>
								<td colspan="6">검색된 데이터가 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="oprRelateChargerVo" items="${vmVo.oprRelateChargerVoList }" varStatus="i">
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
			<h3 class="box-title">네트워크 정보</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>
		<div class="box-body no-padding detail-list-body">
			<table class="table table-vertical table-layout-fixed" id="netwkIntfcTable">
				<caption>네트워크 정보</caption>
				<thead>
					<tr>
						<th>No.</th>
						<th>용도</th>
						<th>IP주소</th>
						<th>MAC주소</th>
						<th>네트워크명</th>
						<th>인터페이스명</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="netwkIntfcVo" items="${vmVo.netwkIntfcVoList }" varStatus="i">
						<tr>
							<td><c:out value="${i.count }" /></td>
							<td class="alignL"><c:out value="${netwkIntfcVo.nicPrposCdNm }"/></td>
							<td><c:out value="${netwkIntfcVo.ipAddr }"/></td>
							<td><c:out value="${netwkIntfcVo.macAddr }"/></td>
							<td class="alignL"><c:out value="${netwkIntfcVo.netwkNm }"/></td>
							<td class="alignL"><c:out value="${netwkIntfcVo.netwkIntfcNm }"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">스토리지 정보</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>
		<div class="box-body no-padding detail-list-body">
			<table class="table table-vertical table-layout-fixed" id="vrDskTable">
				<caption>스토리지 정보</caption>
				<thead>
					<tr>
						<th>No.</th>
						<th>디스크명</th>
						<th>용량 (GB)</th>
						<th>용도</th>
						<th>생성일자</th>
						<th>비고</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vrDskVo" items="${vmVo.vrDskVoList }" varStatus="i">
						<tr>
							<td><c:out value="${i.count }" /></td>
							<td class="alignL"><c:out value="${vrDskVo.vrDskNm }"/></td>
							<td class="alignR"><fmt:formatNumber value="${vrDskVo.dskAsgnCapa }" pattern="0"/></td>
							<td class="alignL"><c:out value="${vrDskVo.prpos }"/></td>
							<td><fmt:formatDate value="${vrDskVo.creDt }" pattern="YYYY-MM-dd"/></td>
							<td class="alignL"><c:out value="${vrDskVo.rmk }"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">소프트웨어 정보</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>
		<div class="box-body no-padding detail-list-body">
			<table class="table table-vertical table-layout-fixed" id="vmSwTable">
				<caption>소프트웨어 정보</caption>
				<thead>
					<tr>
						<th>No.</th>
						<th>소프트웨어구성ID</th>
						<th>소프트웨어명</th>
						<th>설치버전</th>
						<th>패치버전</th>
						<th>설치일자</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vmSwVo" items="${vmVo.vmSwVoList }" varStatus="i">
						<tr>
							<td><c:out value="${i.count }" /></td>
							<td><c:out value="${vmSwVo.swCompId}"/></td>
							<td class="alignL"><c:out value="${vmSwVo.swNm }"/></td>
							<td class="alignL"><c:out value="${vmSwVo.instlVer }"/></td>
							<td class="alignL"><c:out value="${vmSwVo.patchVer }"/></td>
							<td><fmt:formatDate value="${vmSwVo.instlDt }" pattern="YYYY-MM-dd"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>

<!-- 페이지 버튼 영역 -->
<div class="col-box-100">
	<div class="box-footer edit-btn-group">
		<div class="pull-left btns">
			<button type="button" class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="뒤로" data-original-title="뒤로" onclick="fn_selectVmList();"><i class="fa fa-arrow-left"></i></button>
		</div>
		<div class="pull-right btns">
			<menu:authorize>
				<button type="button" class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="저장" data-original-title="저장" onclick="fn_updateVm();"><i class="fa fa-check"></i></button>
			</menu:authorize>
		</div>
	</div>
</div>



<script type="text/javascript">


var xhr = null;

//뒤로
function fn_selectVmList(){
	location.href = '<c:url value="selectVmList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'vmSeq' and pageParam.key ne 'searchType' and pageParam.key ne 'equalsVmClCd' and pageParam.key ne 'existsVrlzSwTyCdList' and pageParam.key ne 'equalsRsrcPoolClCd'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
}

function fn_executeVmStatSync(type){
	if(null != xhr){
		xhr.abort();
	}
	var options = {
		type: 'post',
		dataType: 'json',
		success: function (result){
			if(result.success){
				fn_selectVmStatSync();
			}
			else{
				if(type == "1") {
					jAlert(result.messageList);
				}
			}
		},
		beforeSend: function() {
			if(type == "1") {
				$.ncmsLoding.startFullScreen();
			}
		},
		complete : function() {
			if(type == "1") {
				$.ncmsLoding.remove();
			}
			//type = "0";
		},
		error: function(xhr, textStatus, errorThrown){
			if(xhr.status === 0 || xhr.readyState === 0){
				return;
			}
			if(type == "1") {
				jAlert('오류가 발생하였습니다.');
			}
		}
	};

	$('#vmVo').attr('action', '<c:url value="selectExecVmStatSync.do"/>');
	var form = $('#vmVo').ajaxSubmit(options);
	xhr = form.data('jqxhr');

}

function fn_executeVmStart(){
	jConfirm(fn_existsJob() + '가상서버를 시작 하시겠습니까?', function(){
		if(null != xhr){
			xhr.abort();
		}
		var options = {
			type: 'post',
			dataType: 'json',
			success: executeVmStartResultHandler,
			beforeSend: function() {
				$.ncmsLoding.startFullScreen();
			},
			complete : function() {
				$.ncmsLoding.remove();
			},
			error: function(xhr, textStatus, errorThrown){
				if(xhr.status === 0 || xhr.readyState === 0){
					return;
				}
				jAlert('오류가 발생하였습니다.');
			}
		};

		$('#vmVo').attr('action', '<c:url value="executeVmStart.do"/>');
		var form = $('#vmVo').ajaxSubmit(options);
		xhr = form.data('jqxhr');

	});
}

function fn_executeVmShutdown(){
	jConfirm(fn_existsJob() + '가상서버를 중지 하시겠습니까?', function(){
		if(null != xhr){
			xhr.abort();
		}
		var options = {
			type: 'post',
			dataType: 'json',
			success: executeVmShutdownResultHandler,
			beforeSend: function() {
				$.ncmsLoding.startFullScreen();
			},
			complete : function() {
				$.ncmsLoding.remove();
			},
			error: function(xhr, textStatus, errorThrown){
				if(xhr.status === 0 || xhr.readyState === 0){
					return;
				}
				jAlert('오류가 발생하였습니다.');

			}
		};

		$('#vmVo').attr('action', '<c:url value="executeVmShutdown.do"/>');
		var form = $('#vmVo').ajaxSubmit(options);
		xhr = form.data('jqxhr');

	});
}

function fn_executeVmRestart(){
	jConfirm(fn_existsJob() + '가상서버를 재시작 하시겠습니까?', function(){
		if(null != xhr){
			xhr.abort();
		}
		var options = {
			type: 'post',
			dataType: 'json',
			success: executeVmRestartResultHandler,
			beforeSend: function() {
				$.ncmsLoding.startFullScreen();
			},
			complete : function() {
				$.ncmsLoding.remove();
			},
			error: function(xhr, textStatus, errorThrown){
				if(xhr.status === 0 || xhr.readyState === 0){
					return;
				}
				jAlert('오류가 발생하였습니다.');
			}
		};

		$('#vmVo').attr('action', '<c:url value="executeVmRestart.do"/>');
		var form = $('#vmVo').ajaxSubmit(options);
		xhr = form.data('jqxhr');

	});
}

function fn_executeVmStop(){
	jConfirm(fn_existsJob() + '가상서버를 강제종료 하시겠습니까?', function(){
		if(null != xhr){
			xhr.abort();
		}
		var options = {
			type: 'post',
			dataType: 'json',
			success: executeVmStopResultHandler,
			beforeSend: function() {
				$.ncmsLoding.startFullScreen();
			},
			complete : function() {
				$.ncmsLoding.remove();
			},
			error: function(xhr, textStatus, errorThrown){
				if(xhr.status === 0 || xhr.readyState === 0){
					return;
				}
				jAlert('오류가 발생하였습니다.');
			}
		};

		$('#vmVo').attr('action', '<c:url value="executeVmStop.do"/>');
		var form = $('#vmVo').ajaxSubmit(options);
		xhr = form.data('jqxhr');

	});
}

function fn_executeVmRc(){

	var ua = window.navigator.userAgent;
	if(ua.indexOf("MSIE ") > 0 || !!navigator.userAgent.match(/Trident.*rv\:11\./)){
		jAlert("인터넷 익스플로러는 지원하지 않습니다. 다른 브라우저를 이용해주시기 바랍니다.");
	}
	else{
		jConfirm(fn_existsJob() + '가상서버 원격콘솔에 접속하시겠습니까?', function(){
			if(null != xhr){
				xhr.abort();
			}
			var options = {
				type: 'post',
				dataType: 'json',
				success: executeVmRcResultHandler,
				beforeSend: function() {
					$.ncmsLoding.startFullScreen();
				},
				complete : function() {
					$.ncmsLoding.remove();
				},
				error: function(xhr, textStatus, errorThrown){
					if(xhr.status === 0 || xhr.readyState === 0){
						return;
					}
					jAlert('오류가 발생하였습니다.');
				}
			};

			$('#vmVo').attr('action', '<c:url value="executeVmRc.do"/>');
			var form = $('#vmVo').ajaxSubmit(options);
			xhr = form.data('jqxhr');

		});
	}
}
function fn_executeVmMigr(){
	var vrlzSwTyCd = "${vmVo.vrlzSwTyCd }"; //가상화SW유형코드

	if(vrlzSwTyCd == "03") {
		jAlert("HP Integrity VM 가상화SW는 마이그레이션 기능을 사용할 수 없습니다.");
		return;
	}


	location.href = '<c:url value="executeVmMigr.do"><c:forEach var="pageParam" items="${param}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:forEach></c:url>';
}

function fn_updateVm(){

	if(!fn_form_validation("vmVo")){
		return;
	}

	if(fn_form_is_same_default_value('vmVo')){
		return;
	}

	jConfirm('가상서버 정보를 변경 하시겠습니까?', function(){

		$('#rmk').val($('#textareaRmk').val());
		if(null != xhr){
			xhr.abort();
		}
		var options = {
			type: 'post',
			dataType: 'json',
			success: updateVmResultHandler,
			beforeSend: function() {
				$.ncmsLoding.startFullScreen();
			},
			complete : function() {
				$.ncmsLoding.remove();
			},
			error: function(xhr, textStatus, errorThrown){
				if(xhr.status === 0 || xhr.readyState === 0){
					return;
				}
				jAlert('오류가 발생하였습니다.');
			}
		};

		$('#vmVo').attr('action', '<c:url value="updateVm.do"/>');
		var form = $('#vmVo').ajaxSubmit(options);
		xhr = form.data('jqxhr');

	});
}

function fn_selectVmStatSync(){
	if(null != xhr){
		xhr.abort();
	}
	var options = {
		type: 'post',
		dataType: 'json',
		success: selectVmStatSyncResultHandler,
		beforeSend: function() {
		},
		complete : function() {
		},
		error: function(xhr, textStatus, errorThrown){
			if(xhr.status === 0 || xhr.readyState === 0){
				return;
			}
			jAlert('오류가 발생하였습니다.');
		}
	};

	$('#vmVo').attr('action', '<c:url value="selectVmStatSync.do"/>');
	var form = $('#vmVo').ajaxSubmit(options);
	xhr = form.data('jqxhr');
}

function selectVmStatSyncResultHandler(result){
	if(result.success){

		if(result.data && result.data.statGrpCd){

			var statGrpCd = result.data.statGrpCd;
			var vrlzSwTyCd = result.data.vrlzSwTyCd;
			var $container = $('div.server');

			var hasProcss = (result.data.vmProcssMsgVoList && result.data.vmProcssMsgVoList.length > 0);
			var hasMigrProcss = false;
			$('#vmProcssMsgList').remove();
			if(hasProcss){
				var $inner = $('<div class="col-box-100" id="vmProcssMsgList">'
					+'<div class="col-info">'
					+	'<h3 class="col-info-header">처리중인 작업</h3>'
					+	'<div class="col-info-body">'
					+		'<div class="col-info-box alignL">'
					+		'</div>'
					+	'</div>'
					+'</div>'
				+'</div>');

				$container.parent().parent().prepend($inner);

				var procssUrlPRsrcReq = '<c:url value="/cpt/opr/req/rsrcreq/selectRsrcReqExeListP.do"/>';
				var procssUrlP = '<c:url value="/cpt/opr/req/rsrcreq/selectRsrcReqExeListMigrP.do"/>';
				$.each(result.data.vmProcssMsgVoList, function(index, item){
					if(null != item.rsrcReqNo && null != item.rsrcReqSeq){
						var url = procssUrlPRsrcReq + '?rsrcReqNo=' + item.rsrcReqNo + '&rsrcReqSeq' + item.rsrcReqSeq;
						$inner.find('.col-info-box').append('<span class="status status-gray mg-right-5" style="font-size:14px;cursor:pointer;" onclick="fn_procssStatOpen(\'' + url + '\');">' + item.procssClCdNm + '</span>');
					}
					else if(null != item.procssInstSeq){
						var url = procssUrlP + '?procssInstSeq=' + item.procssInstSeq;
						$inner.find('.col-info-box').append('<span class="status status-gray mg-right-5" style="font-size:14px;cursor:pointer;" onclick="fn_procssStatOpen(\'' + url + '\');">' + item.procssClCdNm + '</span>');
						if(false == hasMigrProcss && "05" == item.procssClCd){
							hasMigrProcss = true;
						}
					}
				});

			}
			$container.find('.col-info-box.alignL .label').remove();
			switch(statGrpCd){
			case '01' : // 다운(OFF)
				$container.removeClass('server-up').removeClass('server-inprogress').removeClass('server-exception').addClass('server-down');
				$container.find('.stat').before('<span class="label"></span>');
				$('#strtupDttm').html('');
				break;
			case '02' : // 업(ON)
				$container.removeClass('server-down').removeClass('server-inprogress').removeClass('server-exception').addClass('server-up');
				$container.find('.stat').before('<span class="label"></span>');
				break;
			case '03' : // 처리중
				$container.removeClass('server-up').removeClass('server-down').removeClass('server-exception').addClass('server-inprogress');
				$container.find('.stat').before('<span class="label"></span>');
				break;
			case '04' : // 예외
				$container.removeClass('server-up').removeClass('server-down').removeClass('server-inprogress').addClass('server-exception');
				$container.find('.stat').before('<span class="label"></span>');
				break;
			default : // 그외
				break;
			}


			if(statGrpCd === "03"){//처리중일때만 진행상태를 보여줌
				$container.find('.stat').html(result.data.statGrpCdNm + "(" + result.data.statCdNm+ ")");
			}else{
				$container.find('.stat').html(result.data.statGrpCdNm);
			}
			$container.find('.vm-start').prop('disabled', ("01" != statGrpCd));
			$container.find('.vm-shutdown').prop('disabled', ("02" != statGrpCd));
			$container.find('.vm-restart').prop('disabled', ("02" != statGrpCd));
			$container.find('.vm-stop').prop('disabled', ("02" != statGrpCd));
			$container.find('.vm-migr').prop('disabled', (!hasMigrProcss && (("02" != statGrpCd && ("01" == vrlzSwTyCd || "03" == vrlzSwTyCd  || "04" == vrlzSwTyCd)) || ("01" != statGrpCd && ("02" == vrlzSwTyCd)))));
			$container.find('.vm-rc').prop('disabled', ("01" == statGrpCd));

			$('#cpuUseRt').html(parseFloat(result.data.cpuUseRt).toFixed(1)+'<small>%</small>');
			$('#memUseRt').html(parseFloat(result.data.memUseRt).toFixed(1)+'<small>%</small>');
			$('#netwkIn').html(parseFloat(result.data.netwkIn).toFixed(1)+'<small>KB/Sec</small>');
			$('#netwkOut').html(parseFloat(result.data.netwkOut).toFixed(1)+'<small>KB/Sec</small>');
			if (result.data.strtupDttmToString!=null) {
				$('#strtupDttm').html(result.data.strtupDttmToString);
			}

		}

	}
	else{
		jAlert(result.messageList);
	}
}

function executeVmStartResultHandler(result){
	if(result.success){
		jInfo(result.messageList, function(){
			fn_selectVmStatSync();
		});
	}
	else{
		jAlert(result.messageList, function(){
			fn_selectVmStatSync();
		});
	}
}

function executeVmShutdownResultHandler(result){
	if(result.success){
		jInfo(result.messageList, function(){
			fn_selectVmStatSync();
		});
	}
	else{
		jAlert(result.messageList, function(){
			fn_selectVmStatSync();
		});
	}
}

function executeVmRestartResultHandler(result){
	if(result.success){
		jInfo(result.messageList, function(){
			fn_selectVmStatSync();
		});
	}
	else{
		jAlert(result.messageList, function(){
			fn_selectVmStatSync();
		});
	}
}

function executeVmStopResultHandler(result){
	if(result.success){
		jInfo(result.messageList, function(){
			fn_selectVmStatSync();
		});
	}
	else{
		jAlert(result.messageList, function(){
			fn_selectVmStatSync();
		});
	}
}

function executeVmRcResultHandler(result){
	if(result.success){
		var url = 'selectVmRcSpiceP.do?vmSeq=<c:out value="${vmVo.vmSeq}"/>&vmId=<c:out value="${vmVo.vmId}"/>&vmCompId=<c:out value="${vmVo.vmCompId}"/>';

		var params = {host : result.data.host, port : result.data.port, password : result.data.password, path : result.data.path};
		var args = {width:1064,height:855};
		windowOpen(url, params, args);
		fn_selectVmStatSync();
	}
	else{
		jAlert(result.messageList, function(){
			fn_selectVmStatSync();
		});
	}
}

function updateVmResultHandler(result){
	if(result.success){
		jInfo(result.messageList, function(){
			location.reload();
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


$(function(){
	// 페이지 로딩과 동시에 동기화
	fn_executeVmStatSync();
	// 1분마다 상태동기화
	setInterval(fn_executeVmStatSync, 30*1000);
});

$("#netwkIntfcTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	columnDefs:[{type:'ip-address', targets:[2]}],
	aoColumns : [
		{sWidth : "28px" }, // No.
		{sWidth : "60px" }, // 용도
		{sWidth : "100px" }, // IP주소
		{sWidth : "112px" }, // MAAC주소
		{sWidth : "120px" }, // 네트워크명
		{sWidth : "120px" }, // 인터페이스명
	],
	order : [],
});

$("#vrDskTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
		{sWidth : "28px" }, // No.
		{sWidth : "120px" }, // 디스크명
		{sWidth : "80px" }, // 용량
		{sWidth : "60px" }, // 용도
		{sWidth : "100px" }, // 생성일자
		{sWidth : "100px" }, // 비고
   	],
   	order : [],
});

$("#vmSwTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
		{sWidth : "28px" }, // No.
		{sWidth : "84px" }, // 소프트웨어구성ID
		{sWidth : "120px" }, // 소프트웨어명
		{sWidth : "60px" }, // 설치버전
		{sWidth : "60px" }, // 패치버전
		{sWidth : "100px" }, // 설치일자
   	],
   	order : [],
});

function fn_procssStatOpen(url){
	if(null == url){
		return;
	}

	var args = {key:"selectRsrcReqExeListMigrP", width: 1280 , height: 720 };
	windowOpen(url, {}, args);

}

function fn_existsJob(){
	return ($('#vmProcssMsgList').length > 0 ? '처리중인 작업이 있습니다. 작업을 무시하고 ' : '');
}

function fn_openVmMon(objId) {
	var params = {
	    vmSeq : objId }
	popup('<c:url value="/cmn/component/monitor/selectVmMonitorP.do" />' + '?'
			+ $.param(params), 'VmMonitor', 1200, 1000);
}

</script>