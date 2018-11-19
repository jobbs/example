<%--
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 9. 22.
 * @lastmodified 2017. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 9. 22.     양정순         v1.0             최초생성
 *
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>

<script type="text/javascript" src="<c:url value="/resources/js/common/ncms_common.js" />"></script>

<script>
	$('[data-toggle="tooltip"]').tooltip();//버튼 툴팁 적용

	var id = '<c:out value="${searchVo.id }" />';
	var gubun = '<c:out value="${searchVo.gubun }" />';
	var institutionId = '<c:out value="${searchVo.institutionId }" />';
	var jobId = '<c:out value="${searchVo.jobId }" />';
	var servcSeq = '<c:out value="${searchVo.servcSeq }" />';
	var param = "gubun=" + gubun + "&institutionId=" + institutionId
				+ "&jobId=" + jobId + "&servcSeq=" + servcSeq + "&trgtSrvrClCd=03";

	//물리서버 한대당 통보설정 팝업
	function fn_openVmNtceConfPop(id) {
		popup(
				'<c:url value="/dsb/thrd/thrdConf/axThrd/selectNtceConfP.do"/>'
						+ "?gubun=" + gubun
						+ "&trgtSrvrClCd=03&thresTrgtSrvrSeq=" + id,
				'NtceConfPop', 800);
		//$.post('selectNtceConf.do', '', handler_openerreload, 'json');
	}
	function fn_openVmAllNtceConfPop() {
		popup('<c:url value="/dsb/thrd/thrdConf/axThrd/selectNtceConfP.do"/>'
				+ "?" + param, 'NtceConfPop', 800);
		//$.post('selectNtceConf.do', '', handler_openerreload, 'json');
	}
	function f_openVmThresConfPop(id) {
		//window.open('cri/임계치 설정 수정(UI-PTL-DS-027).html','','width=1020,height=500');
		popup(
				'<c:url value="/dsb/thrd/thrdConf/axThrd/selectThrdConfP.do" />'
						+ "?gubun=" + gubun
						+ "&trgtSrvrClCd=03&thresTrgtSrvrSeq=" + id, 'Pop',
				1020);
	}
	function f_openVmAllThresConfPop(id) {
		//window.open('cri/임계치 설정 수정(UI-PTL-DS-027).html','','width=1020,height=500');
		popup('<c:url value="/dsb/thrd/thrdConf/axThrd/selectThrdConfP.do" />'
				+ "?" + param, 'Pop', 1020);
	}
</script>


<!-- box : 컨텐츠의 내용을 분류해주는 요소입니다. header(타이틀)와 body, footer로 나누어집니다. -->
<!-- box(목록조회 테이블) -->
<div class="box list-box">
	<div class="box-header">
		<h3 class="box-title">
			서비스 목록<small> <c:out value="${searchVo.paginationInfo.currentPageNo }" /> /
								 <c:out value="${searchVo.paginationInfo.totalPageCount }" />, 총
								 <c:out value="${searchVo.paginationInfo.totalRecordCount }" />건
			</small>
		</h3>
		<div class="box-tools"></div>
	</div>
	<!-- /box-header -->

	<div class="box-body no-padding list-body">
		<table class="table table-bordered table-hover table-vertical">
			<caption>서비스 목록</caption>
			<colgroup>
				<col class="col20">
				<col class="colAuto">
				<col class="col10">
				<col class="col13">
				<col class="col10">
				<col class="col10">
				<col class="col10">
				<col class="col10">
			</colgroup>
			<thead>
				<tr>
					<th><nobr>부처</nobr></th>
					<th>서비스명</th>
					<th>Scale In/Out</th>
					<th>Warning 이벤트</th>
					<th>등급</th>
					<th>CPU 사용률</th>
					<th>메모리 사용률</th>
					<th>통보설정</th>
					<th>수정</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${list eq null or empty list }">
						<tr>
							<td colspan="10">검색된 데이터가 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="vo" items="${list }" varStatus="i">
							<tr>
								<td rowspan="2" class="alignL"><nobr>${vo.path }</nobr></td>

								<td rowspan="2" class="alignL" title="<c:out value="${vo.servcNm }"/>"><nobr> <c:out value="${cf:ellipsis(vo.servcNm, 30) }" /></nobr></td>
								<td rowspan="2">
									<c:if test="${not empty vo.serverStatCmprStdr and vo.serverStatCmprStdr ne ''}">
			                    		Scaled(<c:out value="${vo.serverStatContCnt }" />)
			                    	</c:if>
			                    </td>
			                    <td rowspan="2">
									<c:if test="${not empty vo.warningStatCmprStdr and vo.warningStatCmprStdr ne ''}">
			                    		Warning 이벤트(<c:out value="${vo.warningStatContCnt }" />)
			                    	</c:if>
			                    </td>
								<td>critical</td>
								<td><c:if test="${vo.criticalCpuUseRtCmprStdr ne ''}">
										<c:out value="${vo.criticalCpuUseRtCmprStdr }" />
										<c:out value="${vo.criticalCpuUseRtVl}" />
										<c:if test="${vo.criticalCpuUseRtContCnt >1}">
											(<c:out value="${vo.criticalCpuUseRtContCnt }" />)
			                    		</c:if>
									</c:if>
								</td>
								<td><c:if test="${vo.criticalMemUseRtCmprStdr ne ''}">
										<c:out value="${vo.criticalMemUseRtCmprStdr }" />
										<c:out value="${vo.criticalMemUseRtVl}" />
										<c:if test="${vo.criticalMemUseRtContCnt >1}">
											(<c:out value="${vo.criticalMemUseRtContCnt }" />)
			                    		</c:if>
									</c:if>
								</td>
								<td rowspan="2">
									<menu:authorize>
										<c:choose>
											<c:when test="${empty vo.userNm and empty vo.grdNm }">
												<button class="btn" onClick="fn_openVmNtceConfPop('${vo.servcSeq}')">통보설정</button>
											</c:when>
											<c:otherwise>
												<a href="#" onClick="fn_openVmNtceConfPop('${vo.servcSeq}')"><c:out value="${vo.grdNm }" /><br />
												<c:out value="${vo.userNm}" />
													<c:if test="${vo.userCnt>1 }">외 <c:out value="${vo.userCnt-1 }" />명
													</c:if>
												</a>
											</c:otherwise>
										</c:choose>

										<c:if test="">

										</c:if>

									</menu:authorize>
								</td>
								<td rowspan="2">
									<menu:authorize>
										<button class="btn btn-red" onClick="f_openVmThresConfPop('${vo.servcSeq}')">임계치수정</button>
									</menu:authorize>
								</td>
								<!-- <td rowspan="2"><a href="#">Down,Critical<br/>홍길동외 1명</a></td>
                   				<td rowspan="2"><button class="btn btn-blue">임계치수정</button></td> -->
							</tr>
							<tr>
								<td>major</td>
								<td><c:if test="${vo.majorCpuUseRtCmprStdr ne ''}">
										<c:out value="${vo.majorCpuUseRtCmprStdr }" />
										<c:out value="${vo.majorCpuUseRtVl}" />
										<c:if test="${vo.majorCpuUseRtContCnt >1}">
											(<c:out value="${vo.majorCpuUseRtContCnt }" />)
			                    		</c:if>
									</c:if>
								</td>

								<td><c:if test="${vo.majorMemUseRtCmprStdr ne ''}">
										<c:out value="${vo.majorMemUseRtCmprStdr }" />
										<c:out value="${vo.majorMemUseRtVl}" />
										<c:if test="${vo.majorMemUseRtContCnt >1}">
											(<c:out value="${vo.majorMemUseRtContCnt }" />)
			                    		</c:if>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
	<!-- /box-body -->

	<div class="box-footer edit-btn-group">
		<div class="pull-left btns">
			<!-- <button class="btn btn-sm btn-hover-red" data-toggle="tooltip" title="" data-original-title="삭제하기"><i class="fa fa-times"></i></button> -->
		</div>
		<ul class="pagination">
			<%-- <ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="goPage" /> --%>
		</ul>
		<div class="pull-right btns">
			<menu:authorize>
				<button class="btn btn-sm btn-hover-red" data-toggle="tooltip" data-original-title="통보설정 전체적용" data-placement="left" onclick="fn_openVmAllNtceConfPop()">
					<i class="fa fa-bell"></i>
				</button>
				<button class="btn btn-sm btn-hover-red" data-toggle="tooltip" data-original-title="임계치 전체 적용" onclick="f_openVmAllThresConfPop()">
					<i class="fa fa-flag"></i>
				</button>
			</menu:authorize>
		</div>
	</div>
	<!-- /box-footer -->
</div>
<!-- /box -->



<script type="text/javascript">

</script>