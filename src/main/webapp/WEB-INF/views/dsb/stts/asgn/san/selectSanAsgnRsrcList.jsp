<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 12. 29.
 * @lastmodified 2016. 12. 29.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 29.     양정순         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript" src="<c:url value="/resources/js/common/ncms_common.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.dataTables.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colResize.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colVis.js" />"></script>

<div class="col-box-100 detail-col">
	<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">자원 보유 및 할당 현황 - SAN 스토리지 상세 현황</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<div class="input-group-cell pad-right">
						<button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_excelDown()">
							<i class="fa fa-download"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
		<div class="box-body no-padding list-body">
			<table class="table table-vertical table-hover" id="tableCludReqPrcss">
				<caption>자원 보유 및 할당 현황 - SAN 스토리지 상세 현황</caption>
				<colgroup>
					<col class="col10">
					<col class="col30">
					<col class="col10">
					<col class="col10">
					<col class="col10">
					<col class="col10">
					<col class="col10">
					<col class="col10">
				</colgroup>
				<thead>
					<tr>
						<th>번호</th>
						<th>자원풀 코드</th>
						<th>물리용량(GB)</th>
						<th>보유량(GB)</th>
						<th>총할당량(GB)</th>
						<th>가상서버 할당량(GB)</th>
						<th>미사용<br>LUN용량(GB)
						</th>
						<th>미사용<br>LUN수
						</th>

					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${ list eq null or empty list }">
							<c:choose>
								<c:when test="${searchVo.search eq null or empty searchVo.search }">
									<tr>
										<td colspan="8">조회 버튼을 클릭해 주시기 바랍니다.</td>
									</tr>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="8">검색된 데이터가 없습니다.</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise>
							<c:forEach var="vo" items="${list}" varStatus="i">
								<tr>
									<td class="alignC"><c:out value="${vo.rn }" /></td>
									<c:choose>
										<c:when test='${searchVo.trm eq "mm" }'>
											<td class="alignL"><a href="" onclick="fn_gotoUpdate('<c:out value="${vo.rsrcPoolId }" />');return false;"><c:out value="${vo.rsrcPoolNm }" /></a></td>
										</c:when>
										<c:otherwise>
											<td class="alignL"><c:out value="${vo.rsrcPoolNm }" /></td>
										</c:otherwise>
									</c:choose>
									<td class="alignR"><c:out value="${vo.phyCapaS }" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.keepCapa}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.totAsgnCapa}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.vmAsgnCapa}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.unusedLunCapa}" pattern="#,###.##" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.unusedLunQty}" pattern="#,###" /></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>

				</tbody>
			</table>
		</div>
		<!-- /box-body -->

	</div>
	<!-- /box -->
</div>
<!-- /col -->
<div class="col-box-100">
	<div class="edit-btn-group">
		<div class="pull-left btns">
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="f_goToListPage()">
				<i class="fa fa-arrow-left"></i>
			</button>
		</div>
		<div class="pull-right btns"></div>
	</div>
</div>

<form:form commandName="searchVo" method="get">
	<c:forEach var="region" items="${searchVo.region }">
		<input type="hidden" name="region" value="${region }" />
	</c:forEach>
	<form:hidden path="mm" />
	<form:hidden path="year" />
	<form:hidden path="trm" />
	<input type="hidden" name="rsrcPoolId" id="rsrcPoolId" value="" />
</form:form>

<script type="text/javascript">
	function fn_excelDown() {
		searchVo.action = '<c:url value="selectSanAsgnRsrcXlsDown.do" />';
		searchVo.submit();
	}
	//목록조회 페이지로 이동
	function f_goToListPage() {
		location.href = '<c:url value="selectSanAsgnYmList.do" />';
	}

	function fn_gotoUpdate(rsrcPoolId) {
		$('#rsrcPoolId').val(rsrcPoolId);

		searchVo.action = '<c:url value="insertSanAsgnView.do" />';
		searchVo.submit();
	}
</script>
