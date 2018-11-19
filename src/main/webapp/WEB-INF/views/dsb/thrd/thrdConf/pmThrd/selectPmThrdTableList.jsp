<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 김동훈
 * @lastmodifier 김동훈
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     김동훈         v1.0             최초생성
 *
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform"%>

<script type="text/javascript" src="<c:url value="/resources/js/common/ncms_common.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.dataTables.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colResize.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colVis.js" />"></script>

<script>
	$('[data-toggle="tooltip"]').tooltip();//버튼 툴팁 적용

	var id = '<c:out value="${searchVo.id }" />';
	var gubun = '<c:out value="${searchVo.gubun }" />';
	var regionId = '<c:out value="${searchVo.regionId }" />';
	var netId = '<c:out value="${searchVo.netId }" />';
	var zoneId = '<c:out value="${searchVo.zoneId }" />';
	var rsrcPoolId = '<c:out value="${searchVo.rsrcPoolId }" />';
	var clstrSeq = '<c:out value="${searchVo.clstrSeq }" />';
	var pmSeq = '<c:out value="${searchVo.pmSeq }" />';
	var param = "gubun=" + gubun + "&regionId=" + regionId + "&netId=" + netId
			+ "&zoneId=" + zoneId + "&rsrcPoolId=" + rsrcPoolId + "&clstrSeq="
			+ clstrSeq + "&pmSeq=" + pmSeq + "&trgtSrvrClCd=02";

	//물리서버 한대당 통보설정 팝업
	function fn_openPmNtceConfPop(id) {
		popup(
				'<c:url value="/dsb/thrd/thrdConf/pmThrd/selectNtceConfP.do"/>'
						+ "?gubun=" + gubun
						+ "&trgtSrvrClCd=02&thresTrgtSrvrSeq=" + id,
				'NtceConfPop', 800);
		//$.post('selectNtceConf.do', '', handler_openerreload, 'json');
	}
	function fn_openPmAllNtceConfPop() {
		popup('<c:url value="/dsb/thrd/thrdConf/pmThrd/selectNtceConfP.do"/>'
				+ "?" + param, 'NtceConfPop', 800);
		//$.post('selectNtceConf.do', '', handler_openerreload, 'json');
	}
	function f_openPmThresConfPop(id) {
		//window.open('cri/임계치 설정 수정(UI-PTL-DS-027).html','','width=1020,height=500');
		popup(
				'<c:url value="/dsb/thrd/thrdConf/pmThrd/selectThrdConfP.do" />'
						+ "?gubun=" + gubun
						+ "&trgtSrvrClCd=02&thresTrgtSrvrSeq=" + id, 'Pop',
				1020);
	}
	function f_openPmAllThresConfPop(id) {
		//window.open('cri/임계치 설정 수정(UI-PTL-DS-027).html','','width=1020,height=500');
		popup('<c:url value="/dsb/thrd/thrdConf/pmThrd/selectThrdConfP.do" />'
				+ "?" + param, 'Pop', 1020);
	}
</script>


<!-- box : 컨텐츠의 내용을 분류해주는 요소입니다. header(타이틀)와 body, footer로 나누어집니다. -->
<!-- box(목록조회 테이블) -->
<div class="box list-box">
	<div class="box-header">
		<h3 class="box-title">
			물리서버 목록<small> <c:out value="${searchVo.paginationInfo.currentPageNo }" /> /
								 <c:out value="${searchVo.paginationInfo.totalPageCount }" />, 총
								 <c:out	value="${searchVo.paginationInfo.totalRecordCount }" />건
			</small>
		</h3>
		<div class="box-tools">
			<%-- <div class="input-group-box">
				     <nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo }"/>
				     <div class="input-group-cell pad-right">
				     	<!-- <button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="excelDown()"><i class="fa fa-download"></i></button> -->
				     </div>
				    </div> --%>
		</div>
	</div>
	<!-- /box-header -->

	<div class="box-body no-padding list-body">
		<table class="table table-bordered table-hover table-vertical">
			<caption>물리서버 목록</caption>
			<colgroup>
				<col class="colAuto">
				<col class="col20">
				<col class="col7">
				<col class="col7">
				<col class="col7">
				<col class="col7">
				<col class="col7">
				<col class="col7">
				<col class="col7">
				<col class="col10">
				<col class="col10">
			</colgroup>
			<thead>
				<tr>
					<th rowspan="2">존/자원풀</th>
					<th rowspan="2">구성ID</th>
					<th rowspan="2">물리서버명</th>
					<th rowspan="2">상태</th>
					<th rowspan="2">등급</th>
					<th colspan="2">CPU</th>
					<th colspan="2">메모리</th>
					<th rowspan="2">통보설정</th>
					<th rowspan="2">임계치설정</th>
				</tr>
				<tr>
					<th>사용률</th>
					<th>가상화율</th>
					<th>사용률</th>
					<th>가상화율</th>
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
								<td rowspan="2" class="alignL"><nobr><c:out value="${vo.path }" /> </nobr></td>
								<td rowspan="2" class="alignL"><nobr><c:out value="${vo.pmCompId }" /></nobr></td>
								<td rowspan="2" class="alignL"><nobr><c:out value="${vo.pmNm }" /></nobr></td>
								<td rowspan="2">
									<c:if test="${not empty vo.serverStatCmprStdr and vo.serverStatCmprStdr ne ''}">
			                    		Down(<c:out value="${vo.serverStatContCnt }" />)
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
								<td><c:if test="${vo.criticalCpuVrlzRtCmprStdr ne ''}">
										<c:out value="${vo.criticalCpuVrlzRtCmprStdr }" />
										<c:out value="${vo.criticalCpuVrlzRtVl }" />
										<c:if test="${vo.criticalCpuVrlzRtContCnt >1}">
											(<c:out value="${vo.criticalCpuVrlzRtContCnt }" />)
			                    		</c:if>
									</c:if>
								</td>
								<td><c:if test="${vo.criticalMemUseRtCmprStdr ne ''}">
										<c:out value="${vo.criticalMemUseRtCmprStdr }" />
										<c:out value="${vo.criticalMemUseRtVl }" />
										<c:if test="${vo.criticalMemUseRtContCnt >1}">
											(<c:out value="${vo.criticalMemUseRtContCnt }" />)
			                    		</c:if>
									</c:if>
								</td>
								<td><c:if test="${vo.criticalMemVrlzRtCmprStdr ne ''}">
										<c:out value="${vo.criticalMemVrlzRtCmprStdr }" />
										<c:out value="${vo.criticalMemVrlzRtVl }" />
										<c:if test="${vo.criticalMemVrlzRtContCnt >1}">
											(<c:out value="${vo.criticalMemVrlzRtContCnt }" />)
			                    		</c:if>
									</c:if>
								</td>
								<td rowspan="2">
									<menu:authorize>
										<c:choose>
											<c:when test="${empty vo.userNm and empty vo.grdNm }">
												<button class="btn" onClick="fn_openPmNtceConfPop('${vo.pmSeq}')">통보설정</button>
											</c:when>
											<c:otherwise>
												<a href="#" onClick="fn_openPmNtceConfPop('<c:out value="${vo.pmSeq}"/>')"><c:out value="${vo.grdNm }" /><br /><c:out value="${vo.userNm }" />
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
										<button class="btn btn-red" onClick="f_openPmThresConfPop('${vo.pmSeq}')">임계치수정</button>
									</menu:authorize>
								</td>
								<!-- <td rowspan="2"><a href="#">Down,Critical<br/>홍길동외 1명</a></td>
                   				<td rowspan="2"><button class="btn btn-blue">임계치수정</button></td> -->
							</tr>
							<tr>
								<td>major</td>
								<td>
									<c:if test="${vo.majorCpuUseRtCmprStdr ne ''}">
										<c:out value="${vo.majorCpuUseRtCmprStdr }" />
										<c:out value="${vo.majorCpuUseRtVl }" />
										<c:if test="${vo.majorCpuUseRtContCnt >1}">
											(<c:out value="${vo.majorCpuUseRtContCnt }" />)
			                    		</c:if>
									</c:if>
								</td>
								<td>
									<c:if test="${vo.majorCpuVrlzRtCmprStdr ne ''}">
										<c:out value="${vo.majorCpuVrlzRtCmprStdr }" />
										<c:out value="${vo.majorCpuVrlzRtVl }" />
										<c:if test="${vo.majorCpuVrlzRtContCnt >1}">
											(<c:out value="${vo.majorCpuVrlzRtContCnt }" />)
			                    		</c:if>
									</c:if>
								</td>
								<td>
									<c:if test="${vo.majorMemUseRtCmprStdr ne ''}">
										<c:out value="${vo.majorMemUseRtCmprStdr }" />
										<c:out value="${vo.majorMemUseRtVl }" />
										<c:if test="${vo.majorMemUseRtContCnt >1}">
											(<c:out value="${vo.majorMemUseRtContCnt }" />)
			                    		</c:if>
									</c:if>
								</td>
								<td>
									<c:if test="${vo.majorMemVrlzRtCmprStdr ne ''}">
										<c:out value="${vo.majorMemVrlzRtCmprStdr }" />
										<c:out value="${vo.majorMemVrlzRtVl }" />
										<c:if test="${vo.majorMemVrlzRtContCnt >1}">
											(<c:out value="${vo.majorMemVrlzRtContCnt }" />)
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
				<button class="btn btn-sm btn-hover-red" data-toggle="tooltip" data-original-title="통보설정 전체적용" data-placement="left" onclick="fn_openPmAllNtceConfPop()">
					<i class="fa fa-bell"></i>
				</button>
				<button class="btn btn-sm btn-hover-red" data-toggle="tooltip" data-original-title="임계치 전체 적용" onclick="f_openPmAllThresConfPop()">
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