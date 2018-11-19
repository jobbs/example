<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 12. 4.
 * @lastmodified 2016. 12. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 4.     양정순         v1.0             최초생성
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
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.dataTables.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colResize.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colVis.js" />"></script>

<form id="insertForm">
	<div class="col-box-100 detail-col">
		<div class="detail-list-box box">
			<div class="box-header">
				<h3 class="box-title">기관별 자원 회수 현황</h3>
				<div class="box-tools">
					<div class="input-group-box">
						<div class="input-group-cell pad-right">
							<button type="button" class="btn btn-sm btn-function" onclick="fn_addTr()" title="추가">추가</button>
							<button type="button" class="btn btn-sm btn-function" onclick="fn_delTr()" title="삭제">삭제</button>
						</div>
					</div>
				</div>
			</div>
			<!-- /box-header -->

			<!-- box-body -->
			<div class="box-body no-padding list-body">
				<table class="table table-hover table-vertical" id="tableWthdrw">
					<caption>기관별 자원 회수 현황</caption>
					<colgroup>
						<col class="col3">
						<col class="col3">
						<col class="col3">
						<col class="col6">
						<col class="col6">
						<col class="col6">
						<col class="col6">
						<col class="col6">
						<col class="col6">
						<col class="col6">
						<col class="col6">
						<col class="col6">
						<col class="col6">

					</colgroup>
					<thead>
						<tr>
							<th rowspan="2"></th>
							<th rowspan="2">년도</th>
							<th rowspan="2">분기</th>
							<th rowspan="2">센터</th>
							<th rowspan="2">기관명</th>
							<th colspan="4">반납요구량</th>
							<th colspan="4">반납량</th>

						</tr>
						<tr>
							<th>가상서버</th>
							<th>vCore</th>
							<th>MEM</th>
							<th>SAN</th>
							<th>가상서버</th>
							<th>vCore</th>
							<th>MEM</th>
							<th>SAN</th>

						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${not empty list}">
								<c:forEach var="vo" items="${list }" varStatus="i">
									<tr>
										<td><input type="checkbox" name="delCheck" title="선택" /></td>
										<td><select name="stdrYr" id="stdrYr" class="form-control input-sm" title="년도" disabled>
												<c:forEach var="yearVo" items="${yearCdList }">
													<option value="${yearVo.cd}"
														<c:if test='${yearVo.cd eq vo.stdrYr}'>selected</c:if>><c:out value="${yearVo.cdNm }" /></option>
												</c:forEach>
											</select>
										</td>
										<td><select id="quarter" name="quarter" class="form-control input-sm" disabled title="분기">
												<option value="1" <c:if test='${"1" eq vo.quarter}'>selected</c:if>>1분기</option>
												<option value="2" <c:if test='${"2" eq vo.quarter}'>selected</c:if>>2분기</option>
												<option value="3" <c:if test='${"3" eq vo.quarter}'>selected</c:if>>3분기</option>
												<option value="4" <c:if test='${"4" eq vo.quarter}'>selected</c:if>>4분기</option>
											</select>
										</td>
										<td><select name="regionId" id="regionId" class="form-control input-sm" title="센터" disabled>
												<c:forEach var="regionVo" items="${regionVoList }">
													<option value="${regionVo.regionId}"
														<c:if test='${regionVo.regionId eq vo.regionId}'>selected</c:if>><c:out value="${regionVo.regionNm }" /></option>
												</c:forEach>
											</select>
										</td>
										<td>
											<div class="input-group">
												<input type="text" name="institutionNm" id="institutionNm" class="form-control essential" value="${vo.institutionNm}" title="기관명" readonly />
												<input type="hidden" name="institutionId" id="institutionId" value="${vo.institutionId}" title="기관ID" />
											</div>
										</td>

										<td class="alignR">
											<input type="text" name="returnReqQtyVm" id="returnReqQtyVm" title="반납요구량가상서버" class="col55 essential onlyNumber alignR" maxlength="5" value="${vo.returnReqQtyVm }">
										</td>
										<td class="alignR">
											<input type="text" name="returnReqQtyVcore" id="returnReqQtyVcore" class="col55 alignR essential onlyNumber" title="반납요구량vCore" maxlength="5" value="${vo.returnReqQtyVcore }">
										</td>
										<td class="alignR">
											<input type="text" name="returnReqQtyMem" id="returnReqQtyMem" class="col55 alignR essential onlyNumber" title="반납요구량MEM" maxlength="5" value="${vo.returnReqQtyMem }">
										</td>
										<td class="alignR">
											<input type="text" name="returnReqQtySan" id="returnReqQtySan" class="col55 alignR essential onlyNumber" title="반납요구량SAN" maxlength="5" value="${vo.returnReqQtySan }">
										</td>
										<td class="alignR">
											<input type="text" name="returnQtyVm" id="returnQtyVm" class="col55 alignR essential onlyNumber" title="반납량가상서버" maxlength="5" value="${vo.returnQtyVm }">
										</td>
										<td class="alignR">
											<input type="text" name="returnQtyVcore" id="returnQtyVcore" class="col55 alignR essential onlyNumber" title="반납량vCore" maxlength="5" value="${vo.returnQtyVcore }">
										</td>
										<td class="alignR">
											<input type="text" name="returnQtyMem" id="returnQtyMem" class="col55 alignR essential onlyNumber" title="반납량MEM" maxlength="5" value="${vo.returnQtyMem }">
										</td>
										<td class="alignR">
											<input type="text" name="returnQtySan" id="returnQtySan" class="col55 alignR essential onlyNumber" title="반납량SAN" maxlength="5" value="${vo.returnQtySan }">
										</td>

									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td><input type="checkbox" name="delCheck" title="선택" /></td>
									<td><select name="stdrYr" id="stdrYr" class="form-control input-sm essential" title="년도">
											<c:forEach var="yearVo" items="${yearCdList }">
												<option value="${yearVo.cd}"><c:out value="${yearVo.cdNm }" /></option>
											</c:forEach>
										</select>
									</td>
									<td><select id="quarter" name="quarter" class="form-control input-sm essential" title="분기">
											<option value="1">1분기</option>
											<option value="2">2분기</option>
											<option value="3">3분기</option>
											<option value="4">4분기</option>
										</select>
									</td>
									<td><select name="regionId" id="regionId" class="form-control input-sm essential" title="센터">
											<c:forEach var="regionVo" items="${regionVoList }">
												<option value="${regionVo.regionId}"><c:out value="${regionVo.regionNm }" /></option>
											</c:forEach>
										</select>
									</td>
									<td>
										<div class="input-group">
											<input type="text" name="institutionNm" id="institutionNm" class="form-control essential" title="기관명" readonly />
											<input type="hidden" name="institutionId" id="institutionId" title="기관ID" />
											<div class="input-group-btn">
												<button type="button" class="btn btn" title="부처검색" onclick="openInsttSearch();fn_setClickRow(this);">
													<i class="fa fa-search"></i>
												</button>
											</div>
										</div>
									</td>

									<td class="alignR">
										<input type="text" name="returnReqQtyVm" id="returnReqQtyVm" title="반납요구량가상서버" maxlength="5" class="col55 essential onlyNumber alignR">
									</td>
									<td class="alignR">
										<input type="text" name="returnReqQtyVcore" id="returnReqQtyVcore" class="col55 alignR essential onlyNumber" maxlength="5" title="반납요구량vCore">
									</td>
									<td class="alignR">
										<input type="text" name="returnReqQtyMem" id="returnReqQtyMem" class="col55 alignR essential onlyNumber" maxlength="5" title="반납요구량MEM">
									</td>
									<td class="alignR">
										<input type="text" name="returnReqQtySan" id="returnReqQtySan" class="col55 alignR essential onlyNumber" maxlength="5" title="반납요구량SAN">
									</td>
									<td class="alignR">
										<input type="text" name="returnQtyVm" id="returnQtyVm" class="col55 alignR essential onlyNumber" maxlength="5" title="반납량가상서버">
									</td>
									<td class="alignR">
										<input type="text" name="returnQtyVcore" id="returnQtyVcore" class="col55 alignR essential onlyNumber" maxlength="5" title="반납량vCore">
									</td>
									<td class="alignR">
										<input type="text" name="returnQtyMem" id="returnQtyMem" class="col55 alignR essential onlyNumber" maxlength="5" title="반납량MEM">
									</td>
									<td class="alignR">
										<input type="text" name="returnQtySan" id="returnQtySan" class="col55 alignR essential onlyNumber" maxlength="5" title="반납량SAN">
									</td>

								</tr>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
			<!-- /box-body -->

			<!-- /box-footer -->
		</div>
		<!-- /box(목록조회 테이블) -->
	</div>
	<!-- /col -->
</form>
<div class="col-box-100">
	<div class="edit-btn-group">
		<div class="pull-left btns">
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="fn_goToListPage()">
				<i class="fa fa-arrow-left"></i>
			</button>
		</div>
		<div class="pull-right btns">
			<menu:authorize>
				<button class="btn btn-hover-green" data-toggle="tooltip" data-original-title="저장" onclick="fn_doInsert()">
					<i class="fa fa-check"></i>
				</button>
			</menu:authorize>

		</div>
	</div>
</div>
<table id="tmplTable" style="display: none">
	<tr>
		<td><input type="checkbox" name="delCheck" title="선택" /></td>
		<td><select name="stdrYr" id="stdrYr" class="form-control input-sm" title="년도">
				<c:forEach var="yearVo" items="${yearCdList }">
					<option value="${yearVo.cd}"><c:out value="${yearVo.cdNm }" /></option>
				</c:forEach>
			</select>
		</td>
		<td><select id="quarter" name="quarter" class="form-control input-sm" title="분기">
				<option value="1">1분기</option>
				<option value="2">2분기</option>
				<option value="3">3분기</option>
				<option value="4">4분기</option>
			</select>
		</td>
		<td><select name="regionId" id="regionId" class="form-control input-sm" title="센터">
				<c:forEach var="regionVo" items="${regionVoList }">
					<option value="${regionVo.regionId}"><c:out value="${regionVo.regionNm }" /></option>
				</c:forEach>
			</select>
		</td>
		<td>
			<div class="input-group">
				<input type="text" name="institutionNm" id="institutionNm" class="form-control essential" title="기관명" readonly />
				<input type="hidden" name="institutionId" id="institutionId" title="기관ID" />
				<div class="input-group-btn">
					<button type="button" class="btn btn" title="부처검색" onclick="openInsttSearch();fn_setClickRow(this);">
						<i class="fa fa-search"></i>
					</button>
				</div>
			</div>
		</td>

		<td class="alignR">
			<input type="text" name="returnReqQtyVm" id="returnReqQtyVm" title="반납요구량가상서버" maxlength="5" class="col55 essential onlyNumber alignR">
		</td>
		<td class="alignR">
			<input type="text" name="returnReqQtyVcore" id="returnReqQtyVcore" class="col55 alignR essential onlyNumber" maxlength="5" title="반납요구량vCore">
		</td>
		<td class="alignR">
			<input type="text" name="returnReqQtyMem" id="returnReqQtyMem" class="col55 alignR essential onlyNumber" maxlength="5" title="반납요구량MEM">
		</td>
		<td class="alignR">
			<input type="text" name="returnReqQtySan" id="returnReqQtySan" class="col55 alignR essential onlyNumber" maxlength="5" title="반납요구량SAN">
		</td>
		<td class="alignR">
			<input type="text" name="returnQtyVm" id="returnQtyVm" class="col55 alignR essential onlyNumber" maxlength="5" title="반납량가상서버">
		</td>
		<td class="alignR">
			<input type="text" name="returnQtyVcore" id="returnQtyVcore" class="col55 alignR essential onlyNumber" maxlength="5" title="반납량vCore">
		</td>
		<td class="alignR">
			<input type="text" name="returnQtyMem" id="returnQtyMem" class="col55 alignR essential onlyNumber" maxlength="5" title="반납량MEM">
		</td>
		<td class="alignR">
			<input type="text" name="returnQtySan" id="returnQtySan" class="col55 alignR essential onlyNumber" maxlength="5" title="반납량SAN">
		</td>

	</tr>

</table>

<form:form commandName="searchVo" method="get">
	<form:hidden path="quarter" />
	<input type="hidden" name="stdrYr" />
	<form:hidden path="year" />
	<form:hidden path="institutionId" />

</form:form>

<script type="text/javascript">
	$(document).bind('selectInstitution', fn_setInstitution);//부처팝업 function설정
	//목록조회 페이지로 이동
	function fn_goToListPage() {

		location.href = "selectWthdrwStPerInstList.do";
	}

	function fn_setInstitution(obj) {

		$('[name=institutionId]', clickBtnTr).val(obj.datas.institutionId);
		$('[name=institutionNm]', clickBtnTr).val(obj.datas.institutionNm);
	}
	//var initTr = $('#tableInsttReqPrcss tbody tr:first').clone().html();
	var initTr = $('#tmplTable tbody tr:first').clone().html();

	function fn_addTr() {
		var tmplTr = '<tr>' + initTr + '</tr>';

		$('#tableWthdrw').append(tmplTr);
		$('[name=institutionNm]', '#tableWthdrw tr:last').val("");//추가한 행의 기관명 삭제
		$('[name=institutionId]', '#tableWthdrw tr:last').val("");//추가한 행의 기관ID 삭제
		$('[name=returnReqQtyVm]', '#tableWthdrw tr:last').val("");//추가한 행의 기관ID 삭제
		$('.onlyNumber').on({
			'focus' : function() {
				$(this).css("ime-mode", "disabled");
				$(this).numeric({
					message : $(this).attr("title") + " : 숫자만 입력하세요."
				});
			}
		});
	}
	function fn_delTr() {
		if ($('[name=delCheck]:checked').parents('tr').length == 0) {
			jAlert('삭제할 행을 선택하시기 바랍니다.');
			return;
		}

		$('[name=delCheck]:checked').parents('tr').remove();
	}
	var clickBtnTr = null;
	function fn_setClickRow(obj) {
		clickBtnTr = $(obj).parents('tr');
	}

	function fn_doDelete() {
		var stdrYr = "${searchVo.year}";
		$('[name="stdrYr"]', '#searchVo').val(stdrYr);

		console.log("val" + $('[name="stdrYr"]').val());
		jConfirm("기관별 자원 회수 현황을 삭제하시겠습니까?", function() {
			var options = {
				url : '<c:url value="deleteWthdrwStPerInst.do" />',
				type : 'POST',
				dataType : 'json',
				//contentType:"application/json;charset=UTF-8",
				success : function(result) {
					if (result.success) {
						jAlert('삭제 되었습니다.', fn_goToListPage);

					} else {
						jAlert(result.messageList[0]);
						return;
					}

				},
				beforeSend : function() {
				},
				error : function(xhr, textStatus, errorThrown) {
					//jAlert('오류가 발생하였습니다.');
				}
			};
			$("#searchVo").ajaxSubmit(options);
		});

		/*if($('[name=delCheck]:checked').parents('tr').length==0){
			jAlert('삭제할 행을 선택하시기 바랍니다.');
			return;
		}

		var submitData = [];
		var isOK=true;

		$('#tableWthdrw tbody tr').each(function(index){
		   var data={};
			//console.log($(this).prop("checked") );
			if($("input:checkbox[name=delCheck]").eq(index).prop('checked')){

				//console.log($("input:checkbox[name=delCheck]").eq(index).prop("checked") );
				//console.log($("select[name=stdrYr]").eq(index).val() );
				console.log($("select[name=quarter]").eq(index).val() );
				console.log($("input[name=institutionId]").eq(index).val() );
				if($("input[name=institutionId]").eq(index).val()==""){
					jAlert(index+1+"행의 기관을 입력하시기 바랍니다.");
					isOK=false;
					return false;

				}

				data["stdrYr"] = $("select[name=stdrYr]").eq(index).val();
				data["quarter"] = $("select[name=quarter]").eq(index).val();
				data["institutionId"] = $("input[name=institutionId]").eq(index).val();



				submitData.push(data);
			}
		});

		console.log(JSON.stringify(submitData));
		if(!isOK){
			return false;
		}
		//$('[name=year]','#searchVo').val($('#stdrYr').val());
		//$('[name=quarter]','#searchVo').val($('#quarter').val());
		jConfirm("기관별 자원 회수 현황을 삭제하시겠습니까?", function() {
		var options = {
				url: '<c:url value="deleteWthdrwStPerInst.do" />',
				data: JSON.stringify(submitData),
				type: 'POST',
				dataType: 'json',
				contentType:"application/json;charset=UTF-8",
				success: function(result){
					if(result.success){
						jAlert('삭제 되었습니다.',fn_goToListPage);

					}else{
						jAlert(result.messageList[0]);
						return;
					}

				},
				beforeSend: function() {},
				error: function(xhr, textStatus, errorThrown){
					//jAlert('오류가 발생하였습니다.');
				}
			};
		$.ajax(options);
		});
		 */
	}

	function fn_doInsert() {
		<c:if test='${searchVo.cmd eq "U"}'>
		if ($('#tableWthdrw tbody tr').length == 0) {
			fn_doDelete();
			return;
		}
		</c:if>
		var submitData = [];
		var rowNum = 1;
		var isOK = false;
		if ($('#tableWthdrw tbody tr').length == 0) {
			jAlert("기관별 자원 회수 현황을 입력하시기 바랍니다.");
			return;
		}

		if (!fn_form_validation('insertForm')) {
			return false;
		}
		$('#tableWthdrw tbody tr').each(function() {
			var data = getContainerData(this);
			isOK = fn_valdate(data, rowNum);
			if (!isOK) {
				return false;
			}

			submitData.push(data);
			rowNum++;
		});
		if (!isOK) {
			return;
		}
		isOK = fn_checkDup();
		if (!isOK) {
			return false;
		}
		console.log(JSON.stringify(submitData));
		jConfirm("기관별 자원 회수 현황을 저장하시겠습니까?", function() {
			var options = {
				url : '<c:url value="insertWthdrwStPerInst.do" />',
				data : JSON.stringify(submitData),
				type : 'POST',
				dataType : 'json',
				contentType : "application/json;charset=UTF-8",
				success : function(result) {
					if (result.success) {
						jAlert('저장 되었습니다.', fn_goToListPage);

					} else {
						jAlert(result.messageList[0]);
						return;
					}

				},
				beforeSend : function() {
				},
				error : function(xhr, textStatus, errorThrown) {
					//jAlert('오류가 발생하였습니다.');
				}
			};
			$.ajax(options);
		});
	}
	function fn_valdate(data, rowNum) {

		if (data.institutionId == "") {
			jAlert(rowNum + "행의 기관을 입력하시기 바랍니다.");
			return false;
		}
		if (data.returnReqQtyVm == "") {
			jAlert(rowNum + "행의 반납요구량 가상서버를 입력하시기 바랍니다.");
			return false;
		}

		if (data.returnReqQtyVcore == "") {
			jAlert(rowNum + "행의 반납요구량 vCore를 입력하시기 바랍니다.");
			return false;
		}
		if (data.returnReqQtyMem == "") {
			jAlert(rowNum + "행의 반납요구량 MEM를 입력하시기 바랍니다.");
			return false;
		}
		if (data.returnReqQtySan == "") {
			jAlert(rowNum + "행의 반납요구량 SAN을 입력하시기 바랍니다.");
			return false;
		}
		if (data.returnQtyVm == "") {
			jAlert(rowNum + "행의 반납량 가상서버를 입력하시기 바랍니다.");
			return false;
		}
		if (data.returnQtyVcore == "") {
			jAlert(rowNum + "행의 반납량 vCore를 입력하시기 바랍니다.");
			return false;
		}
		if (data.returnQtyMem == "") {
			jAlert(rowNum + "행의 반납량 MEM를 입력하시기 바랍니다.");
			return false;
		}
		if (data.returnQtySan == "") {
			jAlert(rowNum + "행의 반납량 SAN을 입력하시기 바랍니다.");
			return false;
		}

		return true;
	}
	function fn_checkDup() {
		var isOK = true;
		var arrStdrYr = [];
		var arrQuarter = [];
		var arrRegionId = [];
		var arrInstitutionId = [];

		$('#tableWthdrw tbody tr').each(function() {
			arrStdrYr.push($('#stdrYr', this).val());
			arrQuarter.push($('#quarter', this).val());
			arrRegionId.push($('#regionId', this).val());
			arrInstitutionId.push($('#institutionId', this).val());
		});
		for (var i = 0; i < arrStdrYr.length; i++) {
			for (var j = i + 1; j < arrStdrYr.length; j++) {
				if (arrStdrYr[i] == arrStdrYr[j]
						&& arrQuarter[i] == arrQuarter[j]
						&& arrRegionId[i] == arrRegionId[j]
						&& arrInstitutionId[i] == arrInstitutionId[j]) {
					jAlert((i + 1) + "행과 " + (j + 1) + "행의 데이터가 중복되었습니다.");
					isOK = false;
					return false;
				}
			}
		}
		return isOK;
	}
</script>

