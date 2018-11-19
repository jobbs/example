<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 정승용
 * @lastmodifier 정승용
 * @created 2016. 10. 28.
 * @lastmodified 2016. 10. 28.
 *
 * @history
 * -----------------------------------------------------------
 * Date         	author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 28.     정승용         	  v1.0             	최초생성
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
<style>
.input-group-box{margin-right: auto; margin-left: auto;}
/* .batch-part{border-left: hidden; border-top: hidden; border-top-style: none; border-top-color: white;} class="batch-part"*/
</style>
<div class="col-box-100 detail-col">
	<form name="btchVo" id="btchVo" method="post">
		<!-- box : 컨텐츠의 내용을 분류해주는 요소입니다. header(타이틀)와 body, footer로 나누어집니다. -->
		<!-- box(목록조회 테이블) -->
		<div class="box">

			<div class="box-header">
				<h3 class="box-title">수집 주기</h3>
			</div>
			<!-- /box-header -->

			<div class="box-body no-padding">
				<table class="table table-horizon">
				<caption>배치 관리</caption>
					<colgroup>
						<col class="col5">
						<col class="col15">
						<col class="col20">
						<col class="col20">
						<col class="col20">
						<col class="col20">
					</colgroup>
					<tbody>
						<tr>
							<td colspan="2"></td>
							<th>월(주기)</th>
							<th>일(주기)</th>
							<th>시(주기)</th>
							<th>분(주기)</th>
						</tr>
						<c:forEach var="btchList" items="${btchList}" varStatus="i">
						<tr>
							<c:choose>
								<c:when test="${(i.count-1) == 0}">
									<th colspan="2">성능</th>
								</c:when>
								<c:when test="${(i.count-1) == 1}">
									<th colspan="2">구성</th>
								</c:when>
								<c:when test="${(i.count-1) == 2}">
									<th rowspan="3" nowrap>&nbsp; &nbsp;운영자동화&nbsp; &nbsp;</th>
									<th class="alignL" nowrap>&nbsp; &nbsp;Repository 정보&nbsp; &nbsp;</th>
								</c:when>
								<c:when test="${(i.count-1) == 3}">
									<th class="alignL" nowrap>&nbsp; &nbsp;Repository 별 Package 정보&nbsp; &nbsp;</th>
								</c:when>
								<c:when test="${(i.count-1) == 4}">
									<th class="alignL" nowrap>&nbsp; &nbsp;VM 별 Package 정보&nbsp; &nbsp;</th>
								</c:when>
								<c:when test="${(i.count-1) == 5}">
									<th rowspan="2" nowrap>&nbsp; &nbsp;오토스케일&nbsp; &nbsp;</th>
									<th class="alignL" nowrap>&nbsp; &nbsp;성능&nbsp; &nbsp;</th>
								</c:when>
								<c:when test="${(i.count-1) == 6}">
									<th class="alignL" nowrap>&nbsp; &nbsp;이벤트&nbsp; &nbsp;</th>
								</c:when>
								<c:otherwise>
									<th colspan="2"><c:out value="${btchList.batchName}" /></th>
								</c:otherwise>
							</c:choose>
 							<td nowrap>
								<div class="input-group-box">
									<input type="hidden" name="batchId" value="${btchList._id}"/>
									<input type="hidden" name="rev" value="${btchList._rev}"/>
									<input type="hidden" name="seqArr" value="${btchList.seq}"/>
									<div class="input-group-cell pad-right-5">
										<select name="timeMonth" id="timeMonth${i.count-1}" class="form-control input-sm" title="주기" onchange="fn_onchange('timeMonth','${i.count-1}');">
											<option value="*" <c:if test="${btchList.exeTimeMonth eq '*'}">selected="selected"</c:if>>선택</option>
											<c:forEach begin="1" end="12" var="monVar">
												<option value="${monVar}"
												<c:if test="${btchList.exeTimeMonth ne '*' and btchList.exeTimeMonth eq monVar}">
													selected="selected"
												</c:if>>
												<fmt:formatNumber value="${monVar}" pattern="0" />개월</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</td>
							<td nowrap>
								<div class="input-group-box">
									<div class="input-group-cell pad-right-5">
										<select name="timeDay" id="timeDay${i.count-1}" class="form-control input-sm" title="주기" onchange="fn_onchange('timeDay','${i.count-1}');">
											<option value="*" <c:if test="${btchList.exeTimeDay eq '*'}">selected="selected"</c:if>>선택</option>
											<c:forEach begin="1" end="31" var="dayVar">
												<option value="${dayVar}"
												<c:if test="${btchList.exeTimeDay ne '*' and btchList.exeTimeDay eq dayVar}">
													selected="selected"
												</c:if>>
												<fmt:formatNumber value="${dayVar}" pattern="0"/>일</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</td>
							<td nowrap>
								<div class="input-group-box">
									<div class="input-group-cell pad-right-5">
										<select name="timeHour" id="timeHour${i.count-1}" class="form-control input-sm" title="주기" onchange="fn_onchange('timeHour','${i.count-1 }');">
											<option value="*" <c:if test="${btchList.exeTimeHour eq '*'}">selected="selected"</c:if>>선택</option>
											<c:forEach begin="1" end="23" var="hourVar">
												<option value="${hourVar}"
												<c:if test="${btchList.exeTimeHour ne '*' and btchList.exeTimeHour eq hourVar}">
													selected="selected"
												</c:if>>
												<fmt:formatNumber value="${hourVar}" pattern="0" />시간</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</td>
							<td nowrap>
								<div class="input-group-box">
									<div class="input-group-cell pad-right-5">
										<select name="timeMinute" id="timeMinute${i.count-1}" class="form-control input-sm" title="주기" onchange="fn_onchange('timeMinute','${i.count-1}');">
											<option value="*" <c:if test="${btchList.exeTimeMinute eq '*'}">selected="selected"</c:if>>선택</option>
											<c:forEach begin="1" end="59" var="minuteVar">
												<option value="${minuteVar}"
												<c:if test="${btchList.exeTimeMinute ne '*' and btchList.exeTimeMinute eq minuteVar}">
													selected="selected"
												</c:if>>
												<fmt:formatNumber value="${minuteVar}" pattern="0"/>분</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- /box-body -->
			<div class="box-footer clearfix">
				<div class="pull-left">
					<br/>
					<p>&nbsp;* 배치 스케줄에 대한 수집 주기를 설정합니다.</p>
					<p>&nbsp;* 해당 시스템에 대한 주기값이 모두 선택일 경우 <span class="text-red">매분 주기</span>로 수집 주기가 설정됩니다.</p>
				</div>
			</div>
			<!-- /box-footer -->
		</div>
		<!-- /box -->
	</form>
</div>

<div class="col-box-100">
	<!-- page-btn-group -->
	<div class="edit-btn-group">
		<div class="pull-right btns">
			<menu:authorize>
			<button type="button" class="btn btn-hover-green" data-toggle="tooltip" data-original-title="저장" onclick="fn_updateBtch();"><i class="fa fa-check"></i></button>
			</menu:authorize>
		</div>
	</div>
	<!-- /page-btn-group -->
</div>

<div class="col-box-100 detail-col">
	<form name="delBtchVo" id="delBtchVo" method="post">
		<div class="box">

			<div class="box-header">
				<h3 class="box-title">삭제 주기</h3>
			</div>
			<!-- /box-header -->

			<div class="box-body no-padding">
				<table class="table table-horizon">
				<caption>삭제주기 관리</caption>
					<colgroup>
						<col class="col5">
						<col class="col15">
						<col class="col20">
						<col class="col20">
						<col class="col20">
						<col class="col20">
					</colgroup>
					<tbody>
						<tr>
							<td colspan="2"></td>
							<th>월(주기)</th>
							<th>일(주기)</th>
							<th>시(주기)</th>
							<th>분(주기)</th>
						</tr>
						<c:forEach var="btchDelList" items="${btchDelList}" varStatus="i">
						<tr>
							<c:choose>
								<c:when test="${(i.count-1) == 0}">
									<th colspan="2">성능</th>
								</c:when>
								<c:when test="${(i.count-1) == 1}">
									<th colspan="2">구성</th>
								</c:when>
							</c:choose>
 							<td nowrap>
								<div class="input-group-box">
									<input type="hidden" name="batchId" value="${btchDelList._id}"/>
									<input type="hidden" name="rev" value="${btchDelList._rev}"/>
									<input type="hidden" name="seqArr" value="${btchDelList.delSeq}"/>
									<div class="input-group-cell pad-right-5">
										<select name="delTimeMonth" id="delTimeMonth${i.count-1}" class="form-control input-sm" title="주기" onchange="fn_onchange('delTimeMonth','${i.count-1}');">
											<option value="*" <c:if test="${btchDelList.exeTimeMonth eq '*'}">selected="selected"</c:if>>선택</option>
											<c:forEach begin="1" end="12" var="monVar">
												<option value="${monVar}"
												<c:if test="${btchDelList.exeTimeMonth ne '*' and btchDelList.exeTimeMonth eq monVar}">
													selected="selected"
												</c:if>>
												<fmt:formatNumber value="${monVar}" pattern="0" />개월</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</td>
							<td nowrap>
								<div class="input-group-box">
									<div class="input-group-cell pad-right-5">
										<select name="delTimeDay" id="delTimeDay${i.count-1}" class="form-control input-sm" title="주기" onchange="fn_onchange('delTimeDay','${i.count-1}');">
											<option value="*" <c:if test="${btchDelList.exeTimeDay eq '*'}">selected="selected"</c:if>>선택</option>
											<c:forEach begin="1" end="31" var="dayVar">
												<option value="${dayVar}"
												<c:if test="${btchDelList.exeTimeDay ne '*' and btchDelList.exeTimeDay eq dayVar}">
													selected="selected"
												</c:if>>
												<fmt:formatNumber value="${dayVar}" pattern="0"/>일</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</td>
							<td nowrap>
								<div class="input-group-box">
									<div class="input-group-cell pad-right-5">
										<select name="delTimeHour" id="delTimeHour${i.count-1}" class="form-control input-sm" title="주기" onchange="fn_onchange('delTimeHour','${i.count-1 }');">
											<option value="*" <c:if test="${btchDelList.exeTimeHour eq '*'}">selected="selected"</c:if>>선택</option>
											<c:forEach begin="1" end="23" var="hourVar">
												<option value="${hourVar}"
												<c:if test="${btchDelList.exeTimeHour ne '*' and btchDelList.exeTimeHour eq hourVar}">
													selected="selected"
												</c:if>>
												<fmt:formatNumber value="${hourVar}" pattern="0" />시간</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</td>
							<td nowrap>
								<div class="input-group-box">
									<div class="input-group-cell pad-right-5">
										<select name="delTimeMinute" id="delTimeMinute${i.count-1}" class="form-control input-sm" title="주기" onchange="fn_onchange('delTimeMinute','${i.count-1}');">
											<option value="*" <c:if test="${btchDelList.exeTimeMinute eq '*'}">selected="selected"</c:if>>선택</option>
											<c:forEach begin="1" end="59" var="minuteVar">
												<option value="${minuteVar}"
												<c:if test="${btchDelList.exeTimeMinute ne '*' and btchDelList.exeTimeMinute eq minuteVar}">
													selected="selected"
												</c:if>>
												<fmt:formatNumber value="${minuteVar}" pattern="0"/>분</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- /box-body -->
			<div class="box-footer clearfix">
				<div class="pull-left">
					<br/>
					<p>&nbsp;* 실행된 배치의 수집정보 삭제 주기를 설정합니다.</p>
					<p>&nbsp;* 해당 시스템에 대한 주기값이 모두 선택일 경우 <span class="text-red">매분 주기</span>로 삭제 주기가 설정됩니다.</p>
					<p>&nbsp;* 수집 주기 항목 중 <span class="text-red">운영자동화(3가지 항목)</span>에 대한 배치 수집 정보는 구성 항목에 포함되므로 구성에 대한 삭제주기만 설정하시면 됩니다.</p>
				</div>
			</div>
			<!-- /box-footer -->
		</div>
		<!-- /box -->
	</form>
</div>

<div class="col-box-100">
	<!-- page-btn-group -->
	<div class="edit-btn-group">
		<div class="pull-right btns">
			<menu:authorize>
			<button type="button" class="btn btn-hover-green" data-toggle="tooltip" data-original-title="저장" onclick="fn_updateBtchInfoDel();"><i class="fa fa-check"></i></button>
			</menu:authorize>
		</div>
	</div>
	<!-- /page-btn-group -->
</div>

<script type="text/javascript">
function fn_onchange(name, idx) {
	var obj = $("#" + name + idx);
	var val = obj.val();
	var delChck = name.substr(0, 3);

	if (delChck == "del"){
		// 변경이 일어나면 모든 값은 초기화 처리
		$("#delTimeMonth" + idx).val("*").attr("selected", "selected");
		$("#delTimeDay" + idx).val("*").attr("selected", "selected");
		$("#delTimeHour" + idx).val("*").attr("selected", "selected");
		$("#delTimeMinute" + idx).val("*").attr("selected", "selected");

		// 자신을 제외한 나머지는 disabled
		if (val != "*") {
			$("#delTimeMonth" + idx).attr("disabled", "disabled");
			$("#delTimeDay" + idx).attr("disabled", "disabled");
			$("#delTimeHour" + idx).attr("disabled", "disabled");
			$("#delTimeMinute" + idx).attr("disabled", "disabled");
			obj.removeAttr("disabled");
			obj.val(val).attr("selected", "selected");
		} else {
			$("#delTimeMonth" + idx).removeAttr("disabled");
			$("#delTimeDay" + idx).removeAttr("disabled");
			$("#delTimeHour" + idx).removeAttr("disabled");
			$("#delTimeMinute" + idx).removeAttr("disabled");
		}

		// 자신보다 상위는 !disabled
		if (name == "delTimeMinute") {
			$("#delTimeMonth" + idx).removeAttr("disabled");
			$("#delTimeDay" + idx).removeAttr("disabled");
			$("#delTimeHour" + idx).removeAttr("disabled");
		} else if (name == "delTimeHour") {
			$("#delTimeMonth" + idx).removeAttr("disabled");
			$("#delTimeDay" + idx).removeAttr("disabled");
		} else if (name == "delTimeDay") {
			$("#delTimeMonth" + idx).removeAttr("disabled");
		}
	} else {
		// 변경이 일어나면 모든 값은 초기화 처리
		$("#timeMonth" + idx).val("*").attr("selected", "selected");
		$("#timeDay" + idx).val("*").attr("selected", "selected");
		$("#timeHour" + idx).val("*").attr("selected", "selected");
		$("#timeMinute" + idx).val("*").attr("selected", "selected");

		// 자신을 제외한 나머지는 disabled
		if (val != "*") {
			$("#timeMonth" + idx).attr("disabled", "disabled");
			$("#timeDay" + idx).attr("disabled", "disabled");
			$("#timeHour" + idx).attr("disabled", "disabled");
			$("#timeMinute" + idx).attr("disabled", "disabled");
			obj.removeAttr("disabled");
			obj.val(val).attr("selected", "selected");
		} else {
			$("#timeMonth" + idx).removeAttr("disabled");
			$("#timeDay" + idx).removeAttr("disabled");
			$("#timeHour" + idx).removeAttr("disabled");
			$("#timeMinute" + idx).removeAttr("disabled");
		}

		// 자신보다 상위는 !disabled
		if (name == "timeMinute") {
			$("#timeMonth" + idx).removeAttr("disabled");
			$("#timeDay" + idx).removeAttr("disabled");
			$("#timeHour" + idx).removeAttr("disabled");
		} else if (name == "timeHour") {
			$("#timeMonth" + idx).removeAttr("disabled");
			$("#timeDay" + idx).removeAttr("disabled");
		} else if (name == "timeDay") {
			$("#timeMonth" + idx).removeAttr("disabled");
		}
	}
}

// 배치주기 수정
function fn_updateBtch() {
	if (!fn_form_validation("btchVo")) {
		return;
	}

	jConfirm('수집주기를 수정하시겠습니까?', function(){
		for (var i = 0; i < 6; i++) {
			$("#timeMonth" + i).removeAttr("disabled");
			$("#timeDay" + i).removeAttr("disabled");
			$("#timeHour" + i).removeAttr("disabled");
			$("#timeMinute" + i).removeAttr("disabled");
		}

		$.ncmsLoding.startFullScreen();
		$.post('updateBtch.do', $('#btchVo').serialize(), fn_pageMove, 'json').always(function() { $.ncmsLoding.remove(); });
	});
}

// 삭제주기 수정
function fn_updateBtchInfoDel() {
	if (!fn_form_validation("delBtchVo")) {
		return;
	}

	jConfirm('삭제주기를 수정하시겠습니까?', function(){
		for (var i = 0; i < 6; i++) {
			$("#delTimeMonth" + i).removeAttr("disabled");
			$("#delTimeDay" + i).removeAttr("disabled");
			$("#delTimeHour" + i).removeAttr("disabled");
			$("#delTimeMinute" + i).removeAttr("disabled");
		}

		$.ncmsLoding.startFullScreen();
		$.post('updateBtchInfoDel.do', $('#delBtchVo').serialize(), fn_pageMove, 'json').always(function() { $.ncmsLoding.remove(); });
	});
}

// 콜백 - 화면이동
function fn_pageMove(result) {
	alert_message(result.messageList, function() {
		if (result.success) {
			if (result.procType == "update") {
				location.href = "selectBtch.do";
			}
		}
	}, (result.success ? "INFO" : ""));
}
</script>