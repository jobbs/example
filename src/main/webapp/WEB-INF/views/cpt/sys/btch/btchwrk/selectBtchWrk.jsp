<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 12.
 * @lastmodified 2016. 10. 12.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 12.     박봉춘         v1.0             최초생성
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
				<caption>배치조회 테이블</caption>
				<colgroup>
					<col class="col20">
					<col class="col30">
					<col class="col20">
					<col class="col30">
				</colgroup>
				<tbody>
					<tr>
						<th>배치 작업 명</th>
						<td colspan="3"><c:out value="${vo.btchWrkNm }"/></td>
					</tr>
					<tr>
						<th>배치 JOB ID</th>
						<td colspan="3"><c:out value="${vo.btchWrkId }"/></td>
					</tr>
					<tr>
						<th>실행 예약</th>
						<td><fmt:formatDate value="${vo.exeRsrvDttm }" pattern="yyyy-MM-dd HH:mm" /></td>
						<th>정지 예약</th>
						<td><fmt:formatDate value="${vo.stopRsrvDttm }" pattern="yyyy-MM-dd HH:mm" /></td>
					</tr>
					<tr>
						<th>주기/시점</th>
						<td colspan="3">
							<c:choose>
								<c:when test="${vo.timeType eq 'C' and vo.cycle eq 'write'}">
									(주기) <c:out value="${vo.cycleDirectWrite}" />
								</c:when>
								<c:when test="${vo.timeType eq 'C' and vo.cycle ne 'write' and vo.cycle ne null}">
									(주기) <c:out value="${vo.cycleNm}" />
								</c:when>
								<c:when test="${vo.timeType eq 'E'}">
									(시점)
									<c:if test="${vo.exeTimeMonth ne ''}">
										<fmt:formatNumber value="${vo.exeTimeMonth}" pattern="00"/>월
									</c:if>
									<c:if test="${vo.exeTimeDay ne '' }">
										<fmt:formatNumber value="${vo.exeTimeDay}" pattern="00"/>일
									</c:if>
									<c:if test="${vo.exeTimeHour ne ''}">
										<fmt:formatNumber value="${vo.exeTimeHour}" pattern="00"/>시
									</c:if>

									<fmt:formatNumber value="${vo.exeTimeMinute}" pattern="00"/>분
								</c:when>
								<c:otherwise>
									(주기) 주기 미설정
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<%-- <tr>
						<th>배치 작업 파일</th>
						<td colspan="3"><c:out value="${vo.btchWrkFileNm }" /></td>
					</tr>

					<tr>
						<th>실행 옵션<br>(파라미터/실행명령)
						</th>
						<td colspan="3"><c:out value="${vo.exeOptn }"/></td>
					</tr>
					<tr>
						<th>설명</th>
						<td colspan="3"><c:out value="${vo.dc }"/></td>
					</tr> --%>
					<tr>
						<th>최종작업일시</th>
						<td><fmt:formatDate value="${vo.strtDttm }" pattern="yyyy-MM-dd HH:mm:ss"/> ~ 
							<fmt:formatDate value="${vo.endDttm }" pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
						<th>최종작업상태</th>
						<td>
							<c:choose>
									<c:when test="${ vo.lastStat eq null }">
									-
									</c:when>
									<c:when test = "${ vo.lastStat eq 'ABANDONED' or vo.lastStat eq 'FAILED' or vo.lastStat eq 'UNKNOWN' }">
										<span class="status status-red"><c:out value="${vo.lastStat }"/></span>
									</c:when>
									<c:otherwise>
										<span class="status status-green"><c:out value="${vo.lastStat }"/></span>
									</c:otherwise>
								</c:choose>
						</td>
					</tr>
					<tr>
						<th>상태</th>
						<td>
							<c:choose>
									<c:when test = "${ vo.lastStat eq 'STARTING' or vo.lastStat eq 'STARTED' }">
										<span class="status status-red">작업중</span>
									</c:when>
									<c:otherwise>
										<span class="status status-green">대기상태</span>
									</c:otherwise>
								</c:choose>
						</td>
						<th>사용여부</th>
						<td>
							<c:choose>
								<c:when test = "${vo.stat eq 'Y' }">
									<span class="status status-green">사용</span>
								</c:when>
								<c:otherwise>
									<span class="status status-gray">미사용</span>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><c:out value="${vo.regUserNm }"/></td>
						<th>작성일시</th>
						<td><fmt:formatDate value="${vo.regDt }" pattern="yyyy-MM-dd"/></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>



<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">최종 배치실행결과</h3>
		</div><!-- /box-header -->

		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>배치수행이력조회 테이블</caption>
				<colgroup>
					<col class="col20">
					<col class="col80">
				</colgroup>
				<tbody>
					<tr>
						<th>배치 시작시간</th>
						<td><fmt:formatDate value="${histVo.startTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					</tr>
					<tr>
						<th>배치 종료시간</th>
						<td><fmt:formatDate value="${histVo.endTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					</tr>

					<tr>
						<th>배치 상태</th>
						<td>
							<c:choose>
								<c:when test="${ histVo.status eq null }">
								-
								</c:when>
								<c:when test = "${ histVo.status eq 'ABANDONED' or histVo.status eq 'FAILED' or histVo.status eq 'UNKNOWN' }">
									<span class="status status-red"><c:out value="${histVo.status }"/></span>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${histVo.exitMessage eq '' or histVo.exitMessage eq null}">
											<span class="status status-green"><c:out value="${histVo.status }"/></span>
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
								<c:when test="${histVo.exitMessage eq '' or histVo.exitMessage eq null }">
									-
								</c:when>
								<c:otherwise>
									<c:out value="${histVo.exitMessage }" />
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
					<c:forEach var="listvo" items="${histStepListVo}" varStatus="i">
						<tr>
							<td class="alignL ellipsis"><c:out value="${listvo.stepNm }" /></td>
							<td class="ellipsis"><fmt:formatDate value="${listvo.stepStartTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td class="ellipsis"><fmt:formatDate value="${listvo.stepEndTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
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
							<td class="ellipsis">
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
		<c:url var="updateUrl" value="updateBtchWrk.do">
			<c:forEach var="curParam" items="${param }">
				<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
			</c:forEach>
		</c:url>
		<c:url var="listUrl" value="selectBtchWrkList.do">
			<c:forEach var="curParam" items="${param }">
				<c:if test="${curParam.key ne 'btchWrkSeq' }">
					<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
				</c:if>
			</c:forEach>
		</c:url>
		<div class="pull-left btns">
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="goToUrl('${listUrl}')"><i class="fa fa-arrow-left"></i></button>
		</div>

		<div class="pull-right">
			<menu:authorize authType="act">
			<button class="btn btn-hover-green" data-toggle="tooltip" data-original-title="실행" onclick="doExecuteBtch()"><i class="fa fa-play-circle"></i></button>
			</menu:authorize>
			<menu:authorize>
			<button class="btn btn-hover-yellow" data-toggle="tooltip" data-original-title="수정" onclick="goToUrl('${updateUrl}')"><i class="fa fa-eraser"></i></button>
			<button class="btn btn-hover-red" data-toggle="tooltip" data-original-title="삭제" onclick="doDelete()"><i class="fa fa-times"></i></button>
			</menu:authorize>
		</div>

	</div>
</div>
<script type="text/javascript">
function openExitMessage(id) {
	var url="<c:out value="/cpt/sys/btch/btchhist/selectExitMessageP.do" />?stepExecutionId=" + id;
	popup(url,"selectExitMessagePopup", 800, 600);

}

function doExecuteBtch() {
	jConfirm("배치를 실행하시겠습니까?", function() {

		//로딩바 시작
		$.ncmsLoding.startFullScreen();

		$.post("executeBtchWrk.do", {"btchWrkSeq": ${vo.btchWrkSeq} }, function(result) {
			alert_message(result.messageList, function(){
				$.ncmsLoding.startFullScreen();
				params = location.search.substr(1).split("&");
				var param = {};
				for(var i=0; i<params.length;i++) {
					row = params[i].split("=");
					param[row[0]] = decodeURI(row[1]);
				}
				param["__"] = new Date().getTime();
				$.get("selectBtchWrk.do", param, function(result) {
					//console.log($(result).find('section#content').html());
					$('section#content').html($(result).find('section#content').html());
				}).always(function() {
					//로딩바 종료
					$.ncmsLoding.remove();
				});
			}, 'info');
		}).always(function() {
			//로딩바 종료
			$.ncmsLoding.remove();
		});
	});
}


function doDelete(){

	jConfirm("배치 정보를 삭제하시겠습니까?", function() {
		$.post("deleteBtchWrk.do", {"btchWrkSeq": ${vo.btchWrkSeq} }, function(result) {
			alert_message(result.messageList, function() {
				if( result.success) {
					goToUrl('${listUrl}');
				}
			});

		}, "json");
	});

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
