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
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<c:url var="detailUrl" value="selectBtchWrk.do">
	<c:forEach var="curParam" items="${param }">
		<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
	</c:forEach>
</c:url>

<c:url var="listUrl" value="selectBtchWrkList.do">
	<c:forEach var="curParam" items="${param }">
		<c:if test="${curParam.key ne 'btchWrkSeq'}">
			<c:param name="${curParam.key }" value="${curParam.value}"></c:param>
		</c:if>
	</c:forEach>
</c:url>

<script type="text/javascript" src="<c:url value="/resources/js/common/validation.js" />" charset="UTF-8"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/FileUtils.js" />" charset="UTF-8"></script>

<script type="text/javascript" src="<c:url value="/resources/sedit2/js/HuskyEZCreator.js" />" charset="UTF-8"></script>


<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-body no-padding">
			<form:form commandName="vo">
				<table class="table table-horizon">
					<caption>배치등록 테이블</caption>
					<colgroup>
						<col class="col20">
						<col class="colAuto">
						<col class="col20">
						<col class="colAuto">
					</colgroup>
					<tbody>
						<tr>
							<th><span class="text-red">*</span>배치작업명</th>
							<td colspan="3">
								<div class="form-group no-margin-bottom">
									<form:input path="btchWrkNm" cssClass="form-control essential input-sm" title="배치 작업 명 " maxlength="60" />
								</div>
							</td>
						</tr>

						<tr>
							<th><span class="text-red">*</span>배치 JOB ID</th>
							<td colspan="3">
								<div class="form-group no-margin-bottom">
									<form:input path="btchWrkId" cssClass="form-control essential input-sm" title="배치 JOB ID" maxlength="50" />
								</div>
							</td>
						</tr>

						<tr>
							<th>실행 예약</th>
							<td>
								<form:hidden path="exeRsrvDttm" />
								<div class="input-group-box">
									<div class="input-group-cell pad-right-5">
										<div class="input-group period">
											<input type="text" name="tmpExeRsrvDttm" id="tmpExeRsrvDttm" class="form-control datepicker input-sm" title="실행 예약"
												value="<fmt:formatDate value="${vo.exeRsrvDttm }" pattern="yyyy-MM-dd" />"
												onchange="initDate(this, 'tmpStopRsrvDttm', 'S')"/>
										</div>
									</div>
									<div class="input-group-cell pad-right-5">
										<div class="input-group">
											<fmt:formatDate value="${vo.exeRsrvDttm }" pattern="HH" var="exeRsrvHour" />
											<select name="tmpExeRsrvHour" id="tmpExeRsrvHour"  class="form-control input-sm">
												<option value="">선택</option>
												<c:forEach begin="0" end="23" var="hourVar">
													<option value="<fmt:formatNumber value="${hourVar}" pattern="00"/>"
														<c:if test="${exeRsrvHour eq hourVar }">selected</c:if>
													><fmt:formatNumber value="${hourVar}" pattern="00"/></option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="input-group-cell pad-right-5">시</div>
									<div class="input-group-cell pad-right-5">
										<div class="input-group">
											<fmt:formatDate value="${vo.exeRsrvDttm }" pattern="mm" var="exeRsrvMin" />
											<select name="tmpExeRsrvMin" id="tmpExeRsrvMin"  class="form-control input-sm">
												<option value="">선택</option>
												<c:forEach begin="0" end="59" var="minVar">
													<option value="<fmt:formatNumber value="${minVar}" pattern="00"/>"
														<c:if test="${exeRsrvMin eq minVar }">selected</c:if>
													><fmt:formatNumber value="${minVar}" pattern="00"/></option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="input-group-cell fix-cell">분</div>
								</div>
							</td>
							<th>정지 예약</th>
							<td>
								<form:hidden path="stopRsrvDttm" />
								<div class="input-group-box">
									<div class="input-group-cell pad-right-5">
										<div class="input-group period">
											<input type="text" name="tmpStopRsrvDttm" id="tmpStopRsrvDttm" class="form-control datepicker input-sm" title="정지 예약"
												value="<fmt:formatDate value="${vo.stopRsrvDttm }" pattern="yyyy-MM-dd" />"
											 	onchange="initDate(this, 'tmpExeRsrvDttm', 'E')" />
										</div>
									</div>
									<div class="input-group-cell pad-right-5">
										<div class="input-group">
											<fmt:formatDate value="${vo.stopRsrvDttm }" pattern="HH" var="stopRsrvHour" />
											<select name="tmpStopRsrvMin" id="tmpStopRsrvHour"  class="form-control input-sm">
												<option value="">선택</option>
												<c:forEach begin="0" end="23" var="hourVar">
													<option value="<fmt:formatNumber value="${hourVar}" pattern="00"/>"
														<c:if test="${stopRsrvHour eq hourVar }">selected</c:if>
													><fmt:formatNumber value="${hourVar}" pattern="00"/></option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="input-group-cell pad-right-5">시</div>
									<div class="input-group-cell pad-right-5">
										<div class="input-group">
											<fmt:formatDate value="${vo.stopRsrvDttm }" pattern="mm" var="stopRsrvMin"/>
											<select name="tmpStopRsrvMin" id="tmpStopRsrvMin"  class="form-control input-sm">
												<option value="">선택</option>
												<c:forEach begin="0" end="59" var="minVar">
													<option value="<fmt:formatNumber value="${minVar}" pattern="00"/>"
														<c:if test="${stopRsrvMin eq minVar }">selected</c:if>
													><fmt:formatNumber value="${minVar}" pattern="00"/></option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="input-group-cell fix-cell">분</div>
								</div>
							</td>
						</tr>

						<tr>
							<th><span class="text-red">*</span>주기/시점</th>
							<td colspan="3">
								<div class="input-group-box">
									<div class="input-group-cell pad-right-5">
										<form:radiobutton path="timeType" value="C" onclick="fn_timeType()" title="주기선택" label="주기"/>
										<form:radiobutton path="timeType" value="E" onclick="fn_timeType()" title="시점선택" label="시점"/>
									</div>
									<div class="cycleDiv" >
										<div class="input-group-cell pad-right-5" title="주기">
											<nform:selectCode
										       parentCd="btchcycle"
										       parentGrpCd="060"
										       name="cycle"
										       id="cycle"
										       whole="true"
										       wholeText="선택하세요"
										       value="${vo.cycle}"
										       cssClass="form-control input-sm"
										       onclick="fn_selectCycle(this)"
										       title="주기"/>

										</div>
										<div class="input-group-cell" id ="cycleWriteDiv">
											<div class="input-group-cell">
												<form:input path="cycleDirectWrite" cssClass="form-control input-sm" title="주기직접입력" />
											</div>
											<div class="input-group-cell comment">(Crontab 주기 형식에 맞게 입력하여 주시기 바랍니다.)</div>
										</div>
									</div>
									<div class="exetimeDiv">
										<div class="input-group-cell pad-right-5">
											<form:select path="exeTimeMonth" value="${vo.exeTimeMonth }" class="form-control input-sm" id="month" title="매월">
												<form:option value="">선택</form:option>
												<c:forEach begin="1" end="12" var="monVar">
													<form:option value="${monVar}"><fmt:formatNumber value="${monVar}" pattern="00"/></form:option>
												</c:forEach>
											</form:select>
										</div>
										<div class="input-group-cell pad-right-5">
											월
										</div>
										<div class="input-group-cell pad-right-5">
											<form:select path="exeTimeDay" value="${vo.exeTimeDay }" class="form-control input-sm" id="day" title="매일">
												<form:option value="">선택</form:option>
												<c:forEach begin="1" end="31" var="dayVar">
													<form:option value="${dayVar}"><fmt:formatNumber value="${dayVar}" pattern="00"/></form:option>
												</c:forEach>
											</form:select>
										</div>
										<div class="input-group-cell pad-right-5">
											일
										</div>
										<div class="input-group-cell pad-right-5">

											<form:select path="exeTimeHour" value="${vo.exeTimeHour }" class="form-control input-sm" id="hour" title="시간">
												<form:option value="">선택</form:option>
												<c:forEach begin="0" end="23" var="hourVar">
													<form:option value="${hourVar}"><fmt:formatNumber value="${hourVar}" pattern="00"/></form:option>
												</c:forEach>
											</form:select>
										</div>
										<div class="input-group-cell pad-right-5">
											시
										</div>
										<div class="input-group-cell pad-right-5">
											<form:select path="exeTimeMinute" value="${vo.exeTimeMinute }"  class="form-control input-sm" id="minute" title="분">
												<form:option value="">선택</form:option>
												<c:forEach begin="0" end="59" var="minuteVar">
													<form:option value="${minuteVar}"><fmt:formatNumber value="${minuteVar}" pattern="00"/></form:option>
												</c:forEach>
											</form:select>
										</div>
										<div class="input-group-cell pad-right-5">
											분
										</div>
									</div>
								</div>
							</td>
						</tr>
						<!-- <tr>
							<th><span class="text-red">*</span>배치 작업 파일명</th>
							<td colspan="3">
								<div class="form-group no-margin-bottom">
									<form:input path="btchWrkFileNm" cssClass="form-control essential input-sm" title="배치 작업 파일명" maxlength="200"/>
								</div>
							</td>
						</tr>

						<tr>
							<th>실행 옵션<br>(파라미터/실행명령)
							</th>
							<td colspan="3">
								<form:input path="exeOptn" cssClass="form-control" title="실행옵션"/>
							</td>
						</tr>
						<tr>
							<th>설명</th>
							<td colspan="3">
								<form:textarea path="dc" cssClass="form-control" title="설명" rows="5" />
							</td>
						</tr> -->
						<tr>
							<th><span class="text-red">*</span>사용여부</th>
							<td class="alignL" colspan="3">
								<form:select path="stat" cssClass="form-control input-sm essential" title="사용여부">
									<form:option value="">선택하세요</form:option>
									<form:option value="Y">사용</form:option>
									<form:option value="N">미사용</form:option>
								</form:select>
							</td>
						</tr>
					</tbody>
				</table>
			</form:form>
		</div>
	</div>
</div>

<!-- 페이지 버튼 -->
<div class="col-box-100">
	<div class="edit-btn-group">
		<div class="pull-left btns">
			<c:choose>
				<c:when test="${vo.btchWrkSeq > 0}">
					<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip"	title="" data-original-title="뒤로"	onclick="goToUrl('${detailUrl}')">
						<i class="fa fa-arrow-left"></i>
					</button>
				</c:when>
				<c:otherwise>
					<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip"	title="" data-original-title="뒤로" onclick="goToUrl('${listUrl}')">
						<i class="fa fa-arrow-left"></i>
					</button>
				</c:otherwise>
			</c:choose>
		</div>

		<div class="pull-right btns">
			<button class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="" data-original-title="저장"	onclick="doSubmit()">
				<i class="fa fa-check"></i>
			</button>
		</div>
	</div>
</div>

<script type="text/javascript">

	function doSubmit() {
		 var time = $(":input:radio[name='timeType']:checked").val();
		if(time == "C"){
			$("#month").val("");
			$("#day").val("");
			$("#hour").val("");
			$("#minute").val("");
			//직접입력시 validation 체크 확인
			if("write" == $("#cycle").val()){
				if($(":input:text[name='cycleDirectWrite']").val() == null || $(":input:text[name='cycleDirectWrite']").val() == ''){
					jAlert("주기를 입력하시기 바랍니다.");
					return;
				}
			}
			if($("#cycle").val() == null || $("#cycle").val() == ''){
				jAlert("주기를 입력하시기 바랍니다.");
				return;
			}
		}else if(time == "E"){
			$("#cycle").val("");
			$("#cycleDirectWrite").val("");
			//시점 관련 validation 체크
			if($("#minute").val() == null || $("#minute").val() == '' ){
				jAlert("시점을 입력하시기 바랍니다.");
				return;
			}
		}

		if (!fn_form_validation("vo")) {
			return;
		}

		var exeRsrvDttm = "";
		var stopRsrvDttm = "";

		if( $("#tmpExeRsrvDttm").val() ) {

			if( !$("#tmpExeRsrvHour").val() ) {
				jAlert("실행 예약 시를 선택하시기 바랍니다.");
				return;
			}

			if( !$("#tmpExeRsrvMin").val() ) {
				jAlert("실행 예약 분을 선택하시기 바랍니다.");
				return;
			}

			exeRsrvDttm = $("#tmpExeRsrvDttm").val() + " " + $("#tmpExeRsrvHour").val() + ":" + $("#tmpExeRsrvMin").val();
		}

		if( $("#tmpStopRsrvDttm").val() ) {

			if( !$("#tmpStopRsrvHour").val() ) {
				jAlert("정지 예약 시를 선택하시기 바랍니다.");
				return;
			}

			if( !$("#tmpStopRsrvMin").val() ) {
				jAlert("정지 예약 분을 선택하시기 바랍니다.");
				return;
			}

			stopRsrvDttm = $("#tmpStopRsrvDttm").val() + " " + $("#tmpStopRsrvHour").val() + ":" + $("#tmpStopRsrvMin").val();
		}

		if( $("#tmpStopRsrvDttm").val() && $("#tmpStopRsrvDttm").val() ) {
			if( exeRsrvDttm >= stopRsrvDttm ) {
				jAlert("실행 예약 일시가 정지 예약 일시 보다 빠를거나 같을 수 없습니다.");
				return;
			}
		}

		jConfirm('배치정보를 저장하시겠습니까?', function() {

			if( $("#tmpExeRsrvDttm").val() ) {
				$("#exeRsrvDttm").val(exeRsrvDttm);
			}

			if( $("#tmpStopRsrvDttm").val() ) {
				$("#stopRsrvDttm").val(stopRsrvDttm);
			}

			var options = {
					type : 'post',
					dataType : 'json',
					success : function(result) {

						alert_message(result.messageList, function() {
							if (result.success) {
								if (result.procType == "insert") {
									location.href = "selectBtchWrkList.do";
								} else {
									location.href = "${detailUrl}";
								}
							}
						},(result.success?"INFO":""));
					},
					beforeSend : function() {
						$.ncmsLoding.startFullScreen();
					},
					complete : function() {
						$.ncmsLoding.remove();
					},
					error : function(xhr, textStatus, errorThrown) {
						jAlert('오류 발생');
					}
			};

			$('#vo').ajaxSubmit(options);
		});
	}

 	function fn_selectCycle(obj) {
		if( $(obj).val() == "write" ) {
			$("#cycleWriteDiv").show();
		} else {
			$("#cyclewrite").val(null);
			$("#cycleWriteDiv").hide();
		}
 	}



 	function fn_timeType() {
		 var time = $(":input:radio[name='timeType']:checked").val();
		if(time == "C"){
			$(".cycleDiv").show();
			$(".exetimeDiv").hide();
		}else if(time == "E"){
			$(".cycleDiv").hide();
			$(".exetimeDiv").show();
		}
 	}

 	fn_timeType();
 	fn_selectCycle($("#cycle"));

</script>