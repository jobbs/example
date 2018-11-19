<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 25.
 * @lastmodified 2016. 10. 25.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 25.     송승규         v1.0             최초생성
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
	<div class="col-info server <c:choose><c:when test='${"01" eq vo.statCd}'><c:out value="server-down"/></c:when><c:when test='${"02" eq vo.statCd}'><c:out value="server-up"/></c:when><c:when test='${"03" eq vo.statCd}'><c:out value="server-inprogress"/></c:when><c:when test='${"04" eq vo.statCd}'><c:out value="server-exception"/></c:when></c:choose>">
		<div class="col-info-body alignL">
			<div class="col-info-box alignL">
				<span class="label"></span><h4 class="stat"><c:out value="${vo.statCdNm}"/></h4>
			</div>
		</div>
	</div>
</div>
<div class="col-box-25">
	<div class="col-info">
		<h3 class="col-info-header">CPU 사용률
		</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num"><c:out value="${vo.cpuUseRt }" /><small>%</small></h4>
			</div>
		</div>
	</div>
</div>
<div class="col-box-25">
	<div class="col-info">
		<h3 class="col-info-header">메모리 사용률</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num"><c:out value="${vo.memUseRt }" /><small>%</small></h4>
			</div>
		</div>
	</div>
</div>
<div class="col-box-25">
	<div class="col-info">
		<h3 class="col-info-header">네트워크 In</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num"><fmt:formatNumber value="${vo.netwkIn }" pattern="0.0"/><small>KB/Sec</small></h4>
			</div>
		</div>
	</div>
</div>
<div class="col-box-25">
	<div class="col-info">
		<h3 class="col-info-header">네트워크 Out</h3>
		<div class="col-info-body">
			<div class="col-info-box">
				<h4 class="num"><fmt:formatNumber value="${vo.netwkOut }" pattern="0.0"/><small>KB/Sec</small></h4>
			</div>
		</div>
	</div>
</div>
<div class="col-box-100 detail-col">
	<form:form id="vo" commandName="vo" enctype="multipart/form-data">
	<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">기본정보</h3>
		</div>
		<div class="box-body no-padding detail-list-body">
			<form:hidden path="vmSeq" value="${vo.vmSeq}"/>
			<form:hidden path="netwkTyClCdNm" value="${vo.netwkTyClCdNm}"/>
	  		<table class="table table-horizon">
	  			<caption>네트워크 가상서버 기본정보</caption>
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
						<th>부처</th>
						<td class="alignL"><c:out value="${vo.institutionNm }" /></td>
						<th>네트워크유형</th>
						<td class="alignL"><c:out value="${vo.netwkTyClCdNm }" /></td>
						<th>센터</th>
						<td class="alignL"><c:out value="${vo.regionNm }" /></td>
						<th>존</th>
						<td class="alignL"><c:out value="${vo.zoneNm }" /></td>
					</tr>
					<tr>
						<th>망구분(망)</th>
						<td class="alignL"><c:out value="${vo.netClCdNm }" />(<c:out value="${vo.netNm }" />)</td>
						<th>자원풀</th>
						<td class="alignL"><c:out value="${vo.rsrcPoolNm }" /></td>
						<th>클러스터명</th>
						<td class="alignL"><c:out value="${vo.clstrNm }" /></td>
						<th>물리서버명</th>
						<td class="alignL"><c:out value="${vo.pmNm }" /></td>
					</tr>
					<tr>
						<th>물리서버구성ID</th>
						<td class="alignL"><c:out value="${vo.pmCompId }" /></td>
						<th>가상서버ID</th>
						<td class="alignL"><c:out value="${vo.vmId }" /></td>
						<th>가상서버명</th>
						<td class="alignL" colspan="3"><c:out value="${vo.vmNm }" /></td>
					</tr>
					<tr>
						<th>가상화SW</th>
						<td class="alignL"><c:out value="${vo.vrlzSwTyCdNm }" /></td>
						<th>호스트명</th>
						<td class="alignL"><c:out value="${vo.hstNm }" /></td>
						<th>OS유형</th>
						<td class="alignL"><c:out value="${vo.osTyCdNm }" /></td>
						<th>플랫폼</th>
						<td class="alignL"><c:out value="${vo.pltfrm }" /></td>
					</tr>
					<tr>
						<th>CPU (vCore)</th>
						<td class="alignL"><c:out value="${vo.cpuVcoreQty }" /></td>
						<th>CPU (Ent)</th>
						<td class="alignL"><c:out value="${vo.cpuEnt }" /></td>
						<th>메모리 (GB)</th>
						<td class="alignL"><c:out value="${vo.memAsgnCapa }" /></td>
						<th>스토리지 (GB)</th>
						<td class="alignL"><c:out value="${vo.strgAsgnCapa}" /></td>
					</tr>
					<tr>
						<th>IP주소</th>
						<td class="alignL"><c:out value="${vo.rprsntIpAddr }" /></td>
						<th>기동일시</th>
						<td class="alignL"><fmt:formatDate value="${vo.strtupDttm }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<th>가동시간</th>
						<td class="alignL"><c:out value="${vo.uptime }" /></td>
						<th>생성일시</th>
						<td class="alignL"><fmt:formatDate value="${vo.regDttm }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					</tr>
					<tr>
						<th>가상서버구성ID</th>

						<td colspan="7" class="alignL">
							<input type="hidden" name="tempVmCompId" value="${vo.vmCompId }"/>
							<form:input path="vmCompId" name="vmCompId" title="가상서버구성ID" cssClass="form-control" value="${vo.vmCompId }" maxlength="${ivu.getMaxlength(vmVoClass, 'vmCompId', groupClass)}" cssStyle="width:160px;"/>
						</td>
					</tr>
					<tr>
						<th>비고</th>
						<td colspan="7">
							<form:textarea path="rmk" title="비고" class="form-control" rows="3" maxlength="${ivu.getMaxlength(vmVoClass, 'rmk', groupClass)}" placeholder="내용을 입력해 주세요." />
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="box detail-list-box" id="l4Box" hidden="">
		<div class="box-header">
			<h3 class="box-title">L4가상서버</h3>
		</div>
		<div class="box-body no-padding detail-list-body">
			<table class="table table-hover table-vertical table-layout-fixed" id="l4Table">
				<caption>L4가상서버 가상서버 목록 테이블</caption>
				<thead>
					<tr>
						<th><nobr>상태</nobr></th>
						<th><nobr>부처명</nobr></th>
						<th><nobr>가상서버ID</nobr></th>
						<th><nobr>가상서버명</nobr></th>
						<th><nobr>가상서버구성ID</nobr></th>
						<th><nobr>호스트명</nobr></th>
						<th><nobr>IP주소</nobr></th>
						<th><nobr>OS타입</nobr></th>
						<th><nobr>가상서버생성일자</nobr></th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${vo.swtchList eq null or empty vo.swtchList }">
						</c:when>
						<c:otherwise>
							<c:forEach var="netL4VmVo" items="${vo.swtchList }" varStatus="i">
								<tr>
									<td class="alignL">
										<div class="server-info server <c:choose>
																			<c:when test='${"01" eq netL4VmVo.statCd}'><c:out value="server-down"/></c:when>
																			<c:when test='${"02" eq netL4VmVo.statCd}'><c:out value="server-up"/></c:when>
																			<c:when test='${"03" eq netL4VmVo.statCd}'><c:out value="server-inprogress"/></c:when>
																			<c:when test='${"04" eq netL4VmVo.statCd}'><c:out value="server-exception"/></c:when>
																			<c:otherwise></c:otherwise>
																		</c:choose>">
											<div class="server-info-body alignL">
												<div class="server-info-box alignL">
													<input type="hidden" name="seq" value="<c:out value="${netL4VmVo.vmSeq }" />">
													<span class="label"></span><h4 class="stat"><c:out value="${netL4VmVo.statCdNm }" /></h4>
												</div>
											</div>
										</div>
									</td>
									<td class="alignL" title="${netL4VmVo.institutionNm }"><nobr><c:out value="${netL4VmVo.institutionNm }"/></nobr></td>
									<td class="alignL"><nobr><a href="javascript:fn_setSlb(<c:out value="${netL4VmVo.vmSeq }"/>);" title="<c:out value="${netL4VmVo.vmId }"/> 상세 화면이동"><c:out value="${netL4VmVo.vmId }"/></a></nobr></td>
									<td class="alignL"><nobr><a href="javascript:fn_setSlb(<c:out value="${netL4VmVo.vmSeq }"/>);" title="<c:out value="${netL4VmVo.vmNm }"/> 상세 화면이동"><c:out value="${netL4VmVo.vmNm }"/></a></nobr></td>
									<td class="alignL"><nobr><c:out value="${netL4VmVo.vmCompId }"/></nobr></td>
									<td class="alignL" title="${netL4VmVo.hstNm }"><nobr><c:out value="${netL4VmVo.hstNm }"/></nobr></td>
									<td><nobr><c:out value="${netL4VmVo.rprsntIpAddr }"/></nobr></td>
									<td class="alignL"><nobr><c:out value="${netL4VmVo.osTyCdNm }"/></nobr></td>
									<td><nobr><c:out value="${netL4VmVo.regDttm }"/></nobr></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
	</div>
	<div class="box detail-list-box" id="slbBox" hidden="" >
		<div class="box-header" >
			<h3 class="box-title">SLB 설정정보</h3>
		</div>
		<div class="box-body no-padding detail-list-body">
			<table class="table table-hover table-vertical table-layout-fixed" id="slbTable">
				<caption>SLB 설정정보 목록 테이블</caption>
				<thead>
					<tr>
						<th><nobr>VIP</nobr></th>
						<th><nobr>리스너<br>프로토콜</nobr></th>
						<th><nobr>리스너<br>포트</nobr></th>
						<th><nobr>풀 유형</nobr></th>
						<th><nobr>풀 세션<br>유지유형</nobr></th>
						<th><nobr>풀 세션<br>유지값</nobr></th>
						<th><nobr>상태확인</nobr></th>
						<th><nobr>상태확인<br>주기<br>(초)</nobr></th>
						<th><nobr>상태확인<br>타임아웃<br>(초)</nobr></th>
						<th><nobr>최대<br>시도<br>횟수</nobr></th>
						<th><nobr>상태확인<br>HTTP URL</nobr></th>
					</tr>
				</thead>
				<tbody>
				<c:choose>
					<c:when test="${vo.slbList eq null or empty vo.slbList }" >
					</c:when>
					<c:otherwise>
						<c:forEach var="rnSlb" items="${vo.slbList }" varStatus="i" >
							<tr>
								<td><nobr><c:out value="${rnSlb.vipAddr }" /></nobr></td>
								<td><nobr><c:out value="${rnSlb.prtcl }" /></nobr></td>
								<td><nobr><c:out value="${rnSlb.port }" /></nobr></td>
								<td class="alignL" title="${rnSlb.slbTyCd }"><nobr><c:out value="${rnSlb.slbTyCd }" /></nobr></td>
								<td class="alignL" title="${rnSlb.sessMntncTyCd }"><nobr><c:out value="${rnSlb.sessMntncTyCd }" /></nobr></td>
								<td class="alignL" title="${rnSlb.sessMntncVl }"><nobr><c:out value="${rnSlb.sessMntncVl }" /></nobr></td>
								<td class="alignL" title="${rnSlb.statConfrm }"><nobr><c:out value="${rnSlb.statConfrm }" /></nobr></td>
								<td class="alignR"><nobr><c:out value="${rnSlb.statConfrmCycle }" /></nobr></td>
								<td class="alignR"><nobr><c:out value="${rnSlb.statConfrmTOut }" /></nobr></td>
								<td class="alignR"><nobr><c:out value="${rnSlb.maxTryCnt }" /></nobr></td>
								<td class="alignL" title="${rnSlb.statConfrmHttpUrl }"><nobr><c:out value="${rnSlb.statConfrmHttpUrl }" /></nobr><input type="hidden" name="${rnSlb.vmSeq }" value="${rnSlb.vmSeq }" /></td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				</tbody>
			</table>
		</div>
	</div>
	<div class="box detail-list-box" id="slbIpBox" hidden="" >
		<div class="box-header">
			<h3 class="box-title">SLB 적용대상 정보</h3>
		</div>
		<div class="box-body no-padding detail-list-body" id="slbIpDiv">
			<table class="table table-hover table-vertical table-layout-fixed" id="slbIpTable">
				<caption>SLB 적용대상 정보 목록 테이블</caption>
				<thead>
					<tr>
						<th>VIP</th>
						<th>IP</th>
						<th><nobr>가상서버구성ID</nobr></th>
						<th>포트</th>
						<th><nobr>가중치<br>(로드밸런싱)</nobr></th>
						<th>설명</th>
						<th><nobr>가상서버<br>상세정보</nobr></th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${vo.slbIpList eq null or empty vo.slbIpList }">
						</c:when>
						<c:otherwise>
							<c:forEach var="netVmSlbIpVo" items="${vo.slbIpList }" varStatus="i">
								<tr>
									<td><c:out value="${netVmSlbIpVo.vipAddr }"/></td>
									<td><c:out value="${netVmSlbIpVo.ipAddr }"/></td>
									<td><c:out value="${netVmSlbIpVo.trgtVmCompId }"/></td>
									<td><c:out value="${netVmSlbIpVo.port }"/></td>
									<td><c:out value="${netVmSlbIpVo.wvl }"/></td>
									<td class="alignL"><c:out value="${netVmSlbIpVo.dc }"/></td>
									<td>
										<!-- 권한이 없으면 보이지 않게 수정 -->
										<c:if test="${netVmSlbIpVo.linkAt eq 'Y'}">
										<a href="javascript:fn_selectVm(<c:out value="${netVmSlbIpVo.trgtVmSeq }"/>);" title="가상서버 상세 화면이동">상세보기</a>
										</c:if>
										<input type="hidden" name="${netVmSlbIpVo.vmSeq }" value="${netVmSlbIpVo.vmSeq }">
									</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
	</div>
	</form:form>
</div>
<div class="col-box-100">
	<div class="edit-btn-group">
		<div class="pull-left btns">
			<button type="button" class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="fn_selectNetVmList();"><i class="fa fa-arrow-left"></i></button>
		</div>
		<div class="pull-right btns">
			<%-- <menu:authorize> --%>
				<button type="button" class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="저장" data-original-title="저장" onclick="fn_updateVm();"><i class="fa fa-check"></i></button>
			<%-- </menu:authorize> --%>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		if($('#netwkTyClCdNm').val() == 'L3'){
			$('#l4Box').show();
		}else if($('#netwkTyClCdNm').val() == 'L4'){
			$('#slbBox').show();
			$('#slbIpBox').show();
		}

		fnLayoutConf200();
	});

	function fn_updateVm(){
		if(!fn_form_validation("vo")){
			return;
		}

		if(fn_form_is_same_default_value('vo')){
			return;
		}

		jConfirm('가상서버 정보를 변경 하시겠습니까?', function(){
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

			$('#vo').attr('action', '<c:url value="updateNetVm.do"/>');
			var form = $('#vo').ajaxSubmit(options);
			xhr = form.data('jqxhr');

		});
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

	//뒤로
	function fn_selectNetVmList(){
		<c:choose>
		<c:when test="${not empty param.netVmSltAt and param.netVmSltAt}">
		location.href = '<c:url value="/cpt/rsrc/com/vm/selectVmList.do"><c:forEach var="curParam" items="${param}"><c:if test="${curParam.key ne 'vmSeq'}"><c:param name="${curParam.key}" value="${curParam.value}" /></c:if></c:forEach></c:url>';
		</c:when>
		<c:otherwise>
		location.href = '<c:url value="selectNetVmList.do"><c:forEach var="curParam" items="${param}"><c:if test="${curParam.key ne 'vmSeq'}"><c:param name="${curParam.key}" value="${curParam.value}" /></c:if></c:forEach></c:url>';
		</c:otherwise>
		</c:choose>
	}

	function fn_selectVm(seq){
		jConfirm("자원관리 > 컴퓨팅관리 > 가상서버관리 > 가상서버상세 화면으로 이동합니다.<br/>이동하시겠습니까?", function(){
			goToUrl('<c:url value="/cpt/rsrc/com/vm/selectVm.do?vmSeq='+seq+'"/>');
		});
	}

	function fn_setSlb(seq){

		location.href = '<c:url value="selectNetVm.do?vmSeq='+seq+'"><c:forEach var="curParam" items="${param}"><c:if test="${curParam.key ne 'vmSeq'}"><c:param name="${curParam.key}" value="${curParam.value}" /></c:if></c:forEach></c:url>';
<%--
		// L4 서버 선택 시 slb설정정보, slb설정대상정보 테이블 show ; 페이지 이동으로 변경
		var slbCnt = 0;
		var slbIpCnt = 0;

		$.each($('#slbTable > tbody > tr > td > input'), function(index, item){
			if($(item).val() != seq){
				$(item).closest('tr').hide();
			}else{
				$(item).closest('tr').show();
				slbCnt++;
			}
		});

		$.each($('#slbIpTable > tbody > tr > td > input'), function(index, item){
			if($(item).val() != seq){
				$(item).closest('tr').hide();
			}else{
				$(item).closest('tr').show();
				slbIpCnt++;
			}
		});

		if(slbCnt != 0){
			$('#slbBox').show();
		}else{
			$('#slbBox').hide();
		}
		if(slbIpCnt != 0){
			$('#slbIpBox').show();
		}else{
			$('#slbIpBox').hide();
		}
--%>
	}

	$("#l4Table").DataTable( {
		dom: 'Zlfrtip' ,
		paging : false,
		searching : false,
		info : false,
		bAutoWidth : false,
		aoColumns : [
					{sWidth : "60px" },
					{sWidth : "80px" },
					{sWidth : "80px" },
					{sWidth : "80px" },
					{sWidth : "84px" },
					{sWidth : "80px" },
					{sWidth : "100px" },
					{sWidth : "65px" },
					{sWidth : "93px" }
					],
		order : [[3, "asc"]]
	} );

	$("#slbTable").DataTable( {
		dom: 'Zlfrtip' ,
		paging : false,
		searching : false,
		info : false,
		bAutoWidth : false,
		aoColumns : [
					{sWidth : "100px" },
					{sWidth : "50px" },
					{sWidth : "40px" },
					{sWidth : "80px" },
					{sWidth : "80px" },
					{sWidth : "73px" },
					{sWidth : "73px" },
					{sWidth : "50px" },
					{sWidth : "50px" },
					{sWidth : "30px" },
					{sWidth : "80px" }
					],
		order : [[0, "asc"]]
	} );

	$("#slbIpTable").DataTable( {
		dom: 'Zlfrtip' ,
		paging : false,
		searching : false,
		info : false,
		bAutoWidth : false,
		scrollY: "300px",
		scrollCollapse: true,
		scrollX: true,
		aoColumns : [
					{sWidth : "100px" },
					{sWidth : "100px" },
					{sWidth : "83px" },
					{sWidth : "40px" },
					{sWidth : "70px" },
					{sWidth : "255px" },
					{sWidth : "60px" }
					],
		order : [[0, "asc"], [1, "asc"]]
	} );

	/* -----------------------------------------------
	/* 창 사이즈 및 좌측메뉴, 우측 컨텐츠의 보이기 여부에
	/* 따른 DataTable 사이즈 변경 처리
	----------------------------------------------- */
	$(window).bind("resize", fnLayoutConf200);

	function fnLayoutConf200() {
		$("#slbIpTable").css("width", "100%");
		$("#slbIpTable").DataTable().columns.adjust().draw();
	}

	function fnLayoutConf201() {
		fnLayoutConf200();
	}

</script>
