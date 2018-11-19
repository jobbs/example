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

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<div class="col-box-100 search-col">
		<div class="box list-box">
			<div class="box-header">
				<h3 class="box-title">자원 보유 및 할당 현황 - SAN 스토리지</h3>
				<div class="box-tools">
					<div class="input-group-box">
						<div class="input-group-cell pad-right">
							<!--  <button type="button" class="btn btn-sm btn-function" onclick="fn_addTr()" title="추가">추가</button>-->
							<button type="button" class="btn btn-sm btn-function" onclick="fn_doDelete()" title="삭제">삭제</button>
						</div>
					</div>
				</div>
			</div>
			<!-- /box-header -->

			<!-- box-body -->
			<div class="box-body no-padding list-body">
				<table class="table table-hover table-vertical" id="tableSanAsgn">
					<caption>자원 보유 및 할당 현황 - SAN 스토리지</caption>
					<colgroup>
						<col class="col3">
						<col class="col3">
						<col class="col3">
						<col class="col6">
						<col class="col6">
						<col class="col6">
					</colgroup>
					<thead>
						<tr>
							<th></th>
							<th>년도</th>
							<th>월</th>
							<th>자원풀명</th>
							<th>미사용 LUN용량(GB)</th>
							<th>미사용 LUN수</th>
						</tr>

					</thead>
					<tbody>
						<c:choose>
							<c:when test="${not empty list}">
								<c:forEach var="vo" items="${list }" varStatus="i">
									<tr>
										<td><input type="checkbox" name="delCheck" title="선택" /></td>
										<td><select name="yy" id="yy" class="form-control input-sm" title="년도" disabled>
												<c:forEach var="yearVo" items="${yearCdList }">
													<option value="${yearVo.cd}" <c:if test='${yearVo.cd eq vo.yy}'>selected</c:if>><c:out value="${yearVo.cdNm }" /></option>
												</c:forEach>
											</select>
										</td>
										<td><select id="mm" name="mm" class="form-control input-sm" disabled title="월">
												<c:forEach var="mmList" items="${mmList }">
													<option value="${mmList}" <c:if test='${mmList eq vo.mm}'>selected</c:if>>${mmList}월</option>
												</c:forEach>
											</select>
										</td>

										<td>
											<div class="input-group">
												<input type="text" name="rsrcPoolNm" id="rsrcPoolNm" class="form-control essential" value="${vo.rsrcPoolNm}" readonly title="자원풀" />
												<input type="hidden" name="rsrcPoolId" id="rsrcPoolId" value="${vo.rsrcPoolId}" title="자원ID" />
												<input type="hidden" name="regionId" id="regionId" value="${vo.regionId}" title="리전ID" />
												<!-- <div class="input-group-btn"><button type="button" class="btn btn" title="자원풀검색" onclick="openPoolSearch();fn_setClickRow(this);"><i class="fa fa-search"></i></button></div> -->
											</div>
										</td>

										<td class="alignR">
											<input type="text" name="unusedLunCapa" id="unusedLunCapa" class="col55 alignL essential onlyFloat" title="미사용 LUN용량" value="<fmt:formatNumber value="${vo.unusedLunCapa}" pattern="#,###.##" />">
										</td>
										<td class="alignR">
											<input type="text" name="unusedLunQty" id="unusedLunQty" class="col55 alignL essential onlyNumber" title="미사용 LUN수" value="<fmt:formatNumber value="${vo.unusedLunQty}" pattern="#,###" />">
										</td>

									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td><input type="checkbox" name="delCheck" title="선택" /></td>
									<td><select name="yy" id="yy" class="form-control input-sm essential" title="년도">
											<c:forEach var="yearVo" items="${yearCdList }">
												<option value="${yearVo.cd}" <c:if test='${yearVo.cd eq searchVo.year}'>selected</c:if>><c:out value="${yearVo.cdNm }" /></option>
											</c:forEach>
										</select>
									</td>
									<td><select id="mm" name="mm" class="form-control input-sm" title="월">
											<c:forEach var="mmList" items="${mmList }">
												<option value="${mmList}" <c:if test='${mmList eq searchVo.mm}'>selected</c:if>>${mmList}월</option>
											</c:forEach>
										</select>
									</td>

									<td>
										<div class="input-group">
											<input type="text" name="rsrcPoolNm" id="rsrcPoolNm" title="자원풀" class="form-control essential" readonly />
											<input type="hidden" name="rsrcPoolId" id="rsrcPoolId" title="자원풀" />
											<input type="hidden" name="regionId" id="regionId" title="리전ID" />
											<div class="input-group-btn">
												<button type="button" class="btn btn" title="자원풀검색" onclick="openPoolSearch();fn_setClickRow(this);">
													<i class="fa fa-search"></i>
												</button>
											</div>
										</div>
									</td>

									<td class="alignR"><input type="text" name="unusedLunCapa" id="unusedLunCapa" class="col55 alignR essential onlyFloat" title="미사용 LUN용량"></td>
									<td class="alignR"><input type="text" name="unusedLunQty" id="unusedLunQty" class="col55 alignR essential onlyNumber" title="미사용 LUN수"></td>
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
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip"
				title="" data-original-title="뒤로" onclick="fn_goToListPage()">
				<i class="fa fa-arrow-left"></i>
			</button>
		</div>
		<div class="pull-right btns">
			<menu:authorize>
				<button class="btn btn-hover-green" data-toggle="tooltip"
					data-original-title="저장" onclick="fn_doInsert()">
					<i class="fa fa-check"></i>
				</button>
			</menu:authorize>

		</div>
	</div>
</div>
<table id="tmplTable" style="display: none">
	<tr>
		<td><input type="checkbox" name="delCheck" title="선택" /></td>
		<td><select name="yy" id="yy" class="form-control input-sm"
			title="년도">
				<c:forEach var="yearVo" items="${yearCdList }">
					<option value="${yearVo.cd}"><c:out
							value="${yearVo.cdNm }" /></option>
				</c:forEach>
		</select></td>
		<td><select id="mm" name="mm" class="form-control input-sm"
			title="월">
				<c:forEach var="mmList" items="${mmList }">
					<option value="${mmList}">${mmList}월</option>
				</c:forEach>
		</select></td>

		<td>
			<div class="input-group">
				<input type="text" name="rsrcPoolNm" id="rsrcPoolNm"
					class="form-control essential" title="자원풀" readonly /> <input
					type="hidden" name="rsrcPoolId" id="rsrcPoolId" title="자원풀" /> <input
					type="hidden" name="regionId" id="regionId" title="리전ID" />
				<div class="input-group-btn">
					<button type="button" class="btn btn" title="자원풀검색"
						onclick="openPoolSearch();fn_setClickRow(this);">
						<i class="fa fa-search"></i>
					</button>
				</div>
			</div>
		</td>

		<td class="alignR"><input type="text" name="unusedLunCapa"
			id="unusedLunCapa" class="col55 alignR essential onlyFloat"
			title="미사용 LUN용량"></td>
		<td class="alignR"><input type="text" name="unusedLunQty"
			id="unusedLunQty" class="col55 alignR essential onlyNumber"
			title="미사용 LUN수"></td>

	</tr>

</table>

<form:form commandName="searchVo" method="get">

	<form:hidden path="trm" />
	<input type="hidden" name="yy" />
	<input type="hidden" name="mm" />
	<form:hidden path="year" />
	<form:hidden path="rsrcPoolId" />

</form:form>

<script type="text/javascript">
	$(document).bind('selectPool', fn_setRsrcPoolId);//부처팝업 function설정
	//목록조회 페이지로 이동
	function fn_goToListPage() {

		location.href = "selectSanAsgnYmList.do";
	}

	function fn_setRsrcPoolId(obj) {
		$('[name=rsrcPoolId]', clickBtnTr).val(obj.datas.rsrcPoolId);
		$('[name=rsrcPoolNm]', clickBtnTr).val(obj.datas.rsrcPoolNm);
		$('[name=regionId]', clickBtnTr).val(obj.datas.regionId);
	}
	//var initTr = $('#tableInsttReqPrcss tbody tr:first').clone().html();
	var initTr = $('#tmplTable tbody tr:first').clone().html();

	function fn_addTr() {
		var tmplTr = '<tr>' + initTr + '</tr>';

		$('#tableSanAsgn').append(tmplTr);
		$('[name=rsrcPoolNm]', '#tableSanAsgn tr:last').val("");//추가한 행의 기관명 삭제
		$('[name=rsrcPoolId]', '#tableSanAsgn tr:last').val("");//추가한 행의 기관ID 삭제
		$('[name=unusedLunQty]', '#tableSanAsgn tr:last').val("");//추가한 행의 기관ID 삭제
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

		//$('[name=delCheck]:checked').parents('tr').remove();
	}
	var clickBtnTr = null;
	function fn_setClickRow(obj) {
		clickBtnTr = $(obj).parents('tr');
	}

	function fn_doDelete() {
		if ($('[name=delCheck]:checked').parents('tr').length == 0) {
			jAlert('삭제할 행을 선택하시기 바랍니다.');
			return;
		}

		var submitData = [];
		var isOK = true;

		$('#tableSanAsgn tbody tr').each(
				function(index) {
					var data = {};
					//console.log($(this).prop("checked") );
					if ($("input:checkbox[name=delCheck]").eq(index).prop(
							'checked')) {

						//console.log($("input:checkbox[name=delCheck]").eq(index).prop("checked") );
						console.log($("#rsrcPoolId").attr("name"));
						//console.log($("select[name=quarter]").eq(index).val() );
						//sconsole.log("rsrcPoolId"+$("input[name=rsrcPoolId]").eq(index).val() );
						if ($("input[name=rsrcPoolId]").eq(index).val() == "") {
							jAlert(index + 1 + "행의 자원풀을 입력하시기 바랍니다.");
							isOK = false;
							return false;
						}

						data["yy"] = $("select[name=yy]").eq(index).val();
						data["mm"] = $("select[name=mm]").eq(index).val();
						data["rsrcPoolId"] = $("input[name=rsrcPoolId]").eq(
								index).val();

						submitData.push(data);
					}
				});

		console.log(JSON.stringify(submitData));
		if (!isOK) {
			return false;
		}
		//$('[name=year]','#searchVo').val($('#stdrYr').val());
		//$('[name=quarter]','#searchVo').val($('#quarter').val());
		jConfirm("자원 회수 현황을 삭제하시겠습니까?", function() {
			var options = {
				url : '<c:url value="deleteSanAsgn.do" />',
				data : JSON.stringify(submitData),
				type : 'POST',
				dataType : 'json',
				contentType : "application/json;charset=UTF-8",
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
			$.ajax(options);

		});
	}

	function fn_doInsert() {

		var submitData = [];
		var rowNum = 1;
		var isOK = false;
		if ($('#tableSanAsgn tbody tr').length == 0) {
			jAlert("SAN 스토리지를 입력하시기 바랍니다.");
			return;
		}

		if (!fn_form_validation('insertForm')) {
			return false;
		}
		$('#tableSanAsgn tbody tr').each(function() {
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
		jConfirm("SAN 스토리지 현황을 저장하시겠습니까?", function() {
			var options = {
				url : '<c:url value="insertSanAsgn.do" />',
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

		if (data.rsrcPoolId == "") {
			jAlert(rowNum + "행의 자원풀을 입력하시기 바랍니다.");
			return false;
		}
		if (data.unusedLunCapa == "") {
			jAlert(rowNum + "행의 미사용LUN용량을 입력하시기 바랍니다.");
			return false;
		}
		if (data.unusedLunQty == "") {
			jAlert(rowNum + "행의 미사용LUN수를 입력하시기 바랍니다.");
			return false;
		}

		return true;
	}
	function fn_checkDup() {
		var isOK = true;
		var arrYy = [];
		var arrMm = [];
		var arrRsrcPoolId = [];

		$('#tableSanAsgn tbody tr').each(function() {
			arrYy.push($('#yy', this).val());
			arrMm.push($('#mm', this).val());
			arrRsrcPoolId.push($('#rsrcPoolId', this).val());
		});
		for (var i = 0; i < arrYy.length; i++) {
			for (var j = i + 1; j < arrYy.length; j++) {
				if (arrYy[i] == arrYy[j] && arrMm[i] == arrMm[j]
						&& arrRsrcPoolId[i] == arrRsrcPoolId[j]) {
					jAlert((i + 1) + "행과 " + (j + 1) + "행의 데이터가 중복되었습니다.");
					isOK = false;
					return false;
				}
			}
		}
		return isOK;
	}
</script>

