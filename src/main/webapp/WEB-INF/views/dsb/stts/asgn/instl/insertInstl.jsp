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
	<div class="col-box-100 detail-col">
		<div class="box detail-list-box">
			<div class="box-header">
				<h3 class="box-title">자원풀 구축 현황</h3>
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
				<table class="table table-hover table-vertical" id="tableInst">
					<caption>자원풀 구축 현황</caption>
					<colgroup>
						<col class="col3">
						<col class="col6">
						<col class="col6">
						<col class="col6">


					</colgroup>
					<thead>
						<tr>
							<th></th>
							<th>자원풀명</th>
							<th>최초 구축</th>
							<th>HW 종류</th>
						</tr>

					</thead>
					<tbody>
						<c:choose>
							<c:when test="${not empty list}">
								<c:forEach var="vo" items="${list }" varStatus="i">
									<tr>
										<td><input type="checkbox" name="delCheck" title="선택" /></td>
										<td>
											<div class="input-group">
												<input type="text" name="rsrcPoolNm" id="rsrcPoolNm" class="form-control essential" value="${vo.rsrcPoolNm}" readonly title="자원풀" />
												<input type="hidden" name="rsrcPoolId" id="rsrcPoolId" value="${vo.rsrcPoolId}" title="자원ID" />
												<input type="hidden" name="regionId" id="regionId" value="${vo.regionId}" title="리전ID" />
												<!-- <div class="input-group-btn"><button type="button" class="btn btn" title="자원풀검색" onclick="openPoolSearch();fn_setClickRow(this);"><i class="fa fa-search"></i></button></div> -->
											</div>
										</td>
										<td class="alignC"><input type="text" name="instlYear" id="instlYear" class=" col55 alignL essential onlyNumber" maxlength="4" title="최초 구축" value="${vo.instlYear }">년</td>
										<td class="alignL"><input type="text" name="hwKnd" id="hwKnd" class="form-control alignL essential " maxlength="100" title="HW 종류" value="${vo.hwKnd }"></td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td><input type="checkbox" name="delCheck" title="선택" /></td>
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
									<td class="alignC"><input type="text" name="instlYear" id="instlYear" class=" col55 alignL essential onlyNumber" maxlength="4" title="최초 구축">년</td>
									<td class="alignL"><input type="text" name="hwKnd" id="hwKnd" class="form-control alignL essential " maxlength="100" title="HW 종류"></td>

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
				<c:if test='${searchVo.cmd eq "I"}'>
					<button class="btn btn-hover-green" data-toggle="tooltip" data-original-title="저장" onclick="fn_doInsert()">
						<i class="fa fa-check"></i>
					</button>
				</c:if>
			</menu:authorize>

			<menu:authorize>
				<c:if test='${searchVo.cmd eq "U"}'>
					<button class="btn btn-hover-yellow" data-toggle="tooltip" data-original-title="수정" onclick="fn_doInsert()">
						<i class="fa fa-eraser"></i>
					</button>
				</c:if>
			</menu:authorize>

		</div>
	</div>
</div>
<table id="tmplTable" style="display: none">
	<tr>
		<td><input type="checkbox" name="delCheck" title="선택" /></td>
		<td>
			<div class="input-group">
				<input type="text" name="rsrcPoolNm" id="rsrcPoolNm" class="form-control essential" title="자원풀" readonly />
				<input type="hidden" name="rsrcPoolId" id="rsrcPoolId" title="자원풀" />
				<input type="hidden" name="regionId" id="regionId" title="리전ID" />
				<div class="input-group-btn">
					<button type="button" class="btn btn" title="자원풀검색" onclick="openPoolSearch();fn_setClickRow(this);">
						<i class="fa fa-search"></i>
					</button>
				</div>
			</div>
		</td>
		<td class="alignC"><input type="text" name="instlYear" id="instlYear" class=" col55 alignL essential onlyNumber" maxlength="4" title="최초 구축">년</td>
		<td class="alignL"><input type="text" name="hwKnd" id="hwKnd" class="form-control alignL essential " maxlength="100" title="HW 종류"></td>
	</tr>

</table>

<form:form commandName="searchVo" method="get">
	<input type="hidden" name="rsrcPoolId" />
</form:form>

<script type="text/javascript">
	$(document).bind('selectPool', fn_setRsrcPoolId);//부처팝업 function설정
	//목록조회 페이지로 이동
	function fn_goToListPage() {

		location.href = "selectInstlList.do";
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

		$('#tableInst').append(tmplTr);
		$('[name=rsrcPoolNm]', '#tableInst tr:last').val("");//추가한 행의 기관명 삭제
		$('[name=rsrcPoolId]', '#tableInst tr:last').val("");//추가한 행의 기관ID 삭제
		$('[name=instlYear]', '#tableInst tr:last').val("");//추가한 행의 기관ID 삭제
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
		var rsrcPoolId = "${searchVo.rsrcPoolId}";
		$('[name=rsrcPoolId]', '#searchVo').val(rsrcPoolId);
		console.log("val" + $('[name=rsrcPoolId]').val());
		jConfirm("자원풀 구축 현황을 삭제하시겠습니까?", function() {
			var options = {
				url : '<c:url value="deleteInstl.do" />',
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
	}

	function fn_doInsert() {
		<c:if test='${searchVo.cmd eq "U"}'>
		if ($('#tableInst tbody tr').length == 0) {
			fn_doDelete();
			return;

		}
		</c:if>

		var submitData = [];
		var rowNum = 1;
		var isOK = false;
		if ($('#tableInst tbody tr').length == 0) {
			jAlert("자원풀 구축 현황을 입력하시기 바랍니다.");
			return;
		}

		if (!fn_form_validation('insertForm')) {
			return false;
		}
		$('#tableInst tbody tr').each(function() {
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
		jConfirm("자원풀 구축 현황을 저장하시겠습니까?", function() {
			var options = {
				url : '<c:url value="insertInstl.do" />',
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
			jAlert(rowNum + "행의 자원풀명을 입력하시기 바랍니다.");
			return false;
		}
		if (data.instlYear == "") {
			jAlert(rowNum + "행의 최초 구축년도를 입력하시기 바랍니다.");
			return false;
		}
		if (data.hwKnd == "") {
			jAlert(rowNum + "행의 HW종류를 입력하시기 바랍니다.");
			return false;
		}

		return true;
	}
	function fn_checkDup() {
		var isOK = true;
		var arrRsrcPoolId = [];

		$('#tableInst tbody tr').each(function() {
			arrRsrcPoolId.push($('#rsrcPoolId', this).val());

		});
		for (var i = 0; i < arrRsrcPoolId.length; i++) {
			for (var j = i + 1; j < arrRsrcPoolId.length; j++) {
				if (arrRsrcPoolId[i] == arrRsrcPoolId[j]) {
					jAlert((i + 1) + "행과 " + (j + 1) + "행의 데이터가 중복되었습니다.");
					isOK = false;
					return false;
				}
			}
		}
		return isOK;
	}
</script>

