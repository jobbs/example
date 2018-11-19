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

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<form:form commandName="searchVo" method="get">
	<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />

	<div class="col-box-100 search-col">
		<div class="box box-search">
			<div class="box-header">
				<h3 class="box-title">검색조건</h3>
				<div class="box-tools pull-right">
					<!-- 접기 버튼 -->
					<button class="btn btn-sm" data-toggle="collapse" data-target=".search-collapse" onclick="return false;">
						<i class="fa fa-chevron-up" data-toggle="tooltip" title="" data-original-title="접어두기"></i>
					</button>
				</div>
			</div>
			<!-- /box-header -->
			<div class="box-body collapse in search-collapse">
				<div class="form-group">
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label>프로파일명</label>
						</div>
						<div class="cell-body">
							<form:input path="profNm" cssClass="form-control input-sm pull-right" title="프로파일명" />
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label>설명</label>
						</div>
						<div class="cell-body">
							<form:input path="dc" cssClass="form-control input-sm pull-right" title="설명" />
						</div>
					</div>

				</div>
			</div>
			<!-- /box-body -->
			<div class="box-footer collapse in search-collapse">
				<div class="pull-left">
					<button type="reset" class="btn">초기화</button>
				</div>
				<div class="pull-right">
					<button type="submit" class="btn btn-red ">조회</button>
				</div>
			</div>
			<!-- /box-footer -->
		</div>
		<!-- /box(검색조건) -->
	</div>
	<!-- /col -->
</form:form>
<div class="col-box-100 search-col">

	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">
				임계치 표준 지표 목록 <small> ${searchVo.paginationInfo.currentPageNo }
					/ ${searchVo.paginationInfo.totalPageCount }, 총
					${searchVo.paginationInfo.totalRecordCount }건 </small>
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo }" />
					<div class="input-group-cell pad-right"></div>
				</div>

			</div>
		</div>
		<div class="box-body no-padding list-body">
			<table class="table table-bordered table-hover table-vertical" id="tableList">
				<caption>임계치 표준지표 목록</caption>
				<colgroup>
					<col class="col11">
					<col class="col21">
					<col class="col11">
					<col class="col11">
					<col class="col10">
					<col class="col10">
					<col class="col10">
					<col class="col10">
					<col class="colAuto">
					<col class="colAuto">
				</colgroup>
				<thead>
					<tr>
						<th rowspan="2">프로파일명</th>
						<th rowspan="2">설명</th>
						<th rowspan="2">상태</th>
						<th rowspan="2">등급</th>
						<th colspan="2">CPU</th>
						<th colspan="2">메모리</th>
						<th rowspan="2">수정</th>
						<th rowspan="2">삭제</th>
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
									<td rowspan="2" class="alignL" title='<c:out value="${vo.profNm}"/>'><c:out value="${cf:ellipsis(vo.profNm, 30) }" /></td>
									<td rowspan="2" class="alignL" title='<c:out value="${vo.dc}"/>'><c:out value="${cf:ellipsis(vo.dc, 60) }" /></td>
									<td rowspan="2"><c:if test="${vo.serverStatCmprStdr ne ''}"> Down(${vo.serverStatContCnt }) </c:if></td>
									<td>critical</td>
									<td>
										<c:if test="${vo.criticalCpuUseRtCmprStdr ne ''}">
											${vo.criticalCpuUseRtCmprStdr } ${vo.criticalCpuUseRtVl}
			                    			<c:if test="${vo.criticalCpuUseRtContCnt >1}">
												(${vo.criticalCpuUseRtContCnt })
			                    			</c:if>
										</c:if>
									</td>
									<td><c:if test="${vo.criticalCpuVrlzRtCmprStdr ne ''}">
			                    			${vo.criticalCpuVrlzRtCmprStdr } ${vo.criticalCpuVrlzRtVl}
			                    			<c:if test="${vo.criticalCpuVrlzRtContCnt >1}">
												(${vo.criticalCpuVrlzRtContCnt })
			                    			</c:if>
										</c:if>
									</td>
									<td><c:if test="${vo.criticalMemUseRtCmprStdr ne ''}">
			                    			${vo.criticalMemUseRtCmprStdr } ${vo.criticalMemUseRtVl}
			                    			<c:if test="${vo.criticalMemUseRtContCnt >1}">
												(${vo.criticalMemUseRtContCnt })
			                    			</c:if>
										</c:if>
									</td>
									<td><c:if test="${vo.criticalMemVrlzRtCmprStdr ne ''}">
			                    			${vo.criticalMemVrlzRtCmprStdr } ${vo.criticalMemVrlzRtVl}
			                    			<c:if test="${vo.criticalMemVrlzRtContCnt >1}">
												(${vo.criticalMemVrlzRtContCnt })
			                    			</c:if>
										</c:if>
									</td>
									<td rowspan="2">
										<menu:authorize>
											<c:url var="updateUrl" value="updateThrdStndIdxView.do">
												<c:param name="profId" value="${vo.profId}"></c:param>
											</c:url>
											<button class="btn" onClick="f_goToUrl('${updateUrl}')">수정</button>
										</menu:authorize>
									</td>
									<td rowspan="2">
										<menu:authorize>
											<button class="btn btn-red" onClick="f_doDelete('${vo.profId}')">삭제</button>
										</menu:authorize>
									</td>
								</tr>
								<tr>
									<td>major</td>
									<td><c:if test="${vo.majorCpuUseRtCmprStdr ne ''}">
			                    			${vo.majorCpuUseRtCmprStdr } ${vo.majorCpuUseRtVl}
			                    			<c:if test="${vo.majorCpuUseRtContCnt >1}">
												(${vo.majorCpuUseRtContCnt })
			                    			</c:if>
										</c:if>
									</td>
									<td><c:if test="${vo.majorCpuVrlzRtCmprStdr ne ''}">
		                    				${vo.majorCpuVrlzRtCmprStdr} ${vo.majorCpuVrlzRtVl}
			                    			<c:if test="${vo.majorCpuVrlzRtContCnt >1}">
												(${vo.majorCpuVrlzRtContCnt })
			                    			</c:if>
										</c:if>
									</td>
									<td><c:if test="${vo.majorMemUseRtCmprStdr ne ''}">
		                    				${vo.majorMemUseRtCmprStdr } ${vo.majorMemUseRtVl}
			                    			<c:if test="${vo.majorMemUseRtContCnt >1}">
												(${vo.majorMemUseRtContCnt })
			                    			</c:if>
										</c:if>
									</td>
									<td><c:if test="${vo.majorMemVrlzRtCmprStdr ne ''}">
		                    				${vo.majorMemVrlzRtCmprStdr} ${vo.majorMemVrlzRtVl}
			                    			<c:if test="${vo.majorMemVrlzRtContCnt >1}">
												(${vo.majorMemVrlzRtContCnt })
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
		<!-- box-footer -->
		<div class="box-footer edit-btn-group">

			<div class="pull-left btns"></div>
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="goPage" />
			</ul>
			<div class="pull-right btns">
				<menu:authorize>
					<c:url var="updateUrl" value="updateThrdStndIdxView.do">
					</c:url>
					<button class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="추가" onclick="f_goToUrl('${updateUrl}')">
						<i class="fa fa-plus"></i>
					</button>
				</menu:authorize>
			</div>

		</div>
	</div>
	<!-- /box(목록조회 테이블) -->
</div>
<!-- /col -->

<script type="text/javascript">
	$(document).ready(function() {

		function pageInit() {
			//fn_dataTable("tableList")//테이블 정렬및 resize
		}
		pageInit();

	});
	function goPage(page) {
		location.href = "selectThrdStndIdxList.do?paginationInfo.currentPageNo="
				+ page + "&${listParam}";
	}
	function f_goToUrl(url) {
		location.href = url;
	}
	function f_doDelete(profId) {
		jConfirm("임계치를 삭제하시겠습니까?", function() {
			var url = '<c:url value="deleteThrdStndIdx.do" />';
			$.post(url, {
				"profId" : profId
			}, function(result) {
				if (result.success) {
					f_goToUrl('<c:url value="selectThrdStndIdxList.do" />');
				}
			}, "json").always(function() {
				$.ncmsLoding.remove();
			});
		});
	}
</script>