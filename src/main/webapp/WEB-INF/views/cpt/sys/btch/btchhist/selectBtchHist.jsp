<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 12. 14.
 * @lastmodified 2016. 12. 14.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 14.     박봉춘         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>배치수행이력조회 테이블</caption>
				<colgroup>
					<col class="col20">
					<col class="col80">
				</colgroup>
				<tbody>
					<tr>
						<th>배치 작업 명</th>
						<td><c:out value="${vo.btchWrkNm }"/></td>
					</tr>
					<tr>
						<th>배치 작업 ID</th>
						<td><c:out value="${vo.jobName }"/></td>
					</tr>
					<tr>
						<th>배치 시작시간</th>
						<td><fmt:formatDate value="${vo.startTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					</tr>
					<tr>
						<th>배치 종료시간</th>
						<td><fmt:formatDate value="${vo.endTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					</tr>

					<tr>
						<th>배치 상태</th>
						<td>
							<c:choose>
								<c:when test="${ vo.status eq null }">
								-
								</c:when>
								<c:when test = "${ vo.status eq 'ABANDONED' or vo.status eq 'FAILED' or vo.status eq 'UNKNOWN' }">
									<span class="status status-red"><c:out value="${vo.status }"/></span>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${vo.exitMessage eq '' or vo.exitMessage eq null}">
											<span class="status status-green"><c:out value="${vo.status }"/></span>
										</c:when>
										<c:otherwise>
											<span class="status status-red">비정상종료배치</span>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th>배치 종료 메세지</th>
						<td>
							<c:choose>
								<c:when test="${vo.exitMessage eq '' or vo.exitMessage eq null }">
									-
								</c:when>
								<c:otherwise>
									<c:out value="${vo.exitMessage }" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">배치 단계정보</h3>
		</div>
		<!-- /box-header -->
		<!-- box-body -->
		<div class="box-body no-padding detail-list-body">
			<table class="table table-hover table-vertical table-layout-fixed" id="BtchHistTable">
				<caption>배치 이력 목록 조회 테이블</caption>
				<thead>
					<tr>
						<th>배치 단계명</th>
						<th>배치 단계시작시간</th>
						<th>배치 단계종료시간</th>
						<th>배치 상태</th>
						<th>Commit</th>
						<th>Read</th>
						<th>Filter</th>
						<th>Write</th>
						<th>ReadSkip</th>
						<th>ProcessSkip</th>
						<th>Rollback</th>
						<th>ExitMessage</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="listvo" items="${list}" varStatus="i">
						<tr>
							<td class="alignL"><c:out value="${listvo.stepNm }" /></td>
							<td><fmt:formatDate value="${listvo.stepStartTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td><fmt:formatDate value="${listvo.stepEndTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td>
								<c:choose>
									<c:when test="${ listvo.stepStatus eq null }">
									-
									</c:when>
									<c:when test = "${ listvo.stepStatus eq 'ABANDONED' or listvo.stepStatus eq 'FAILED' or listvo.stepStatus eq 'UNKNOWN' }">
										<span class="status status-red"><c:out value="${listvo.stepStatus }"/></span>
									</c:when>
									<c:otherwise>
										<span class="status status-green"><c:out value="${listvo.stepStatus }"/></span>
									</c:otherwise>
								</c:choose>
							</td>
							<td><c:out value="${listvo.commitCnt }" /></td>
							<td><c:out value="${listvo.readCnt }" /></td>
							<td><c:out value="${listvo.filterCnt }" /></td>
							<td><c:out value="${listvo.writeCnt }" /></td>
							<td><c:out value="${listvo.readSkipCnt }" /></td>
							<td><c:out value="${listvo.processSkipCnt }" /></td>
							<td><c:out value="${listvo.rollbackCnt }" /></td>
							<td>
								<c:if test="${listvo.jobExitMessage ne null and !listvo.jobExitMessage.equals('') }">
									<a href="javascript:void(0)" onclick="openExitMessage(${listvo.stepExecutionId })"><c:out value="${listvo.jobExitMessage }" /></a>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- /box-body -->
	</div>
</div>
<!-- 페이지 버튼 -->
<div class="col-box-100">
	<div class="edit-btn-group">
		<c:url var="listUrl" value="selectBtchHistList.do">
			<c:forEach var="curParam" items="${param }">
				<c:if test="${curParam.key ne 'jobExecutionId' }">
					<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
				</c:if>
			</c:forEach>
		</c:url>
		<div class="pull-left btns">
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="goToUrl('${listUrl}')"><i class="fa fa-arrow-left"></i></button>
		</div>
	</div>
</div>

<script type="text/javascript">

function openExitMessage(id) {
	var url="<c:out value="/cpt/sys/btch/btchhist/selectExitMessageP.do" />?stepExecutionId=" + id;
	popup(url,"selectExitMessagePopup", 800, 600);

}

$("#BtchHistTable").DataTable({
	dom : 'Zlfrtip',
	aoColumns : [
	               {sWidth : "130px" },
	               {sWidth : "115px" },
	               {sWidth : "115px" },
	               {sWidth : "84px" },
	               {sWidth : "50px" },
	               {sWidth : "50px" },
	               {sWidth : "50px" },
	               {sWidth : "50px" },
	               {sWidth : "50px" },
	               {sWidth : "50px" },
	               {sWidth : "50px" },
	               {sWidth : "120px" }
	],
	order : [ [ 1, "asc" ] ]
});
</script>