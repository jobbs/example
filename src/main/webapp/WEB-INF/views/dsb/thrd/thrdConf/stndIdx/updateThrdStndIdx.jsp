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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<form:form commandName="thrdStndIdxVo" method="post">
	<form:hidden path="profId" />
	<div class="col-box-100 detail-col">
		<div class="detail-list-box box">
			<div class="box-header">
				<h3 class="box-title">설정정보</h3>
			</div>
			<div class="box-body no-padding">
				<form role="form">
					<table class="table table-vertical table-bordered">
						<caption>프로파일 정보</caption>
						<colgroup>
							<col class="colAuto">
							<col class="col10">
							<col class="col10">
							<col class="col10">
							<col class="col10">
							<col class="col15">
							<col class="col10">
							<col class="col15">
						</colgroup>
						<thead>
							<tr>
								<th>프로파일명</th>
								<th>설명</th>
								<th>지표명</th>
								<th>구분</th>
								<th>등급</th>
								<th>비교기준</th>
								<th>기준값</th>
								<th>연속횟수</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td rowspan="9"><form:input path="profNm" cssClass="form-control essential" title="프로파일명" maxlength="60" /></td>
								<td rowspan="9"><form:textarea path="dc" cssClass="form-control" rows="5" maxlength="6000" title="설명"></form:textarea></td>
								<td>서버상태</td>
								<td></td>
								<td>Down</td>
								<td><form:select path="serverStatCmprStdr" cssClass="form-control" title="비교기준">
										<form:option value="">설정안함</form:option>
										<form:option value="=">=</form:option>
									</form:select>
								</td>
								<td></td>
								<td><form:select path="serverStatContCnt" cssClass="form-control" title="연속횟수">
										<form:option value="1">1</form:option>
										<form:option value="2">2</form:option>
										<form:option value="3">3</form:option>
										<form:option value="4">4</form:option>
									</form:select>
								</td>
							</tr>
							<tr>
								<td rowspan="4">CPU</td>
								<td rowspan="2">사용률</td>
								<td>Critical</td>
								<td><form:select path="criticalCpuUseRtCmprStdr" cssClass="form-control" onchange="f_changeSelect(this)" title="비교기준">
										<form:option value="">설정안함</form:option>
										<form:option value="=">=</form:option>
										<form:option value="<>"><></form:option>
										<form:option value=">">></form:option>
										<form:option value="≥">≥</form:option>
										<form:option value="<"><</form:option>
										<form:option value="≤">≤</form:option>
									</form:select>
								</td>
								<td><form:input path="criticalCpuUseRtVl" cssClass="form-control onlyNumber" maxlength="3" title="CPU사용률(Critical)" /></td>
								<td><form:select path="criticalCpuUseRtContCnt" cssClass="form-control" title="연속횟수">
										<form:option value="1">1</form:option>
										<form:option value="2">2</form:option>
										<form:option value="3">3</form:option>
										<form:option value="4">4</form:option>
									</form:select>
								</td>
							</tr>
							<tr>
								<td>Major</td>
								<td><form:select path="majorCpuUseRtCmprStdr" cssClass="form-control" onchange="f_changeSelect(this)" title="비교기준">
										<form:option value="">설정안함</form:option>
										<form:option value="=">=</form:option>
										<form:option value="<>"><></form:option>
										<form:option value=">">></form:option>
										<form:option value="≥">≥</form:option>
										<form:option value="<"><</form:option>
										<form:option value="≤">≤</form:option>
									</form:select>
								</td>
								<td><form:input path="majorCpuUseRtVl" cssClass="form-control onlyNumber" maxlength="3" title="CPU사용률(Major)" /></td>
								<td><form:select path="majorCpuUseRtContCnt" cssClass="form-control" title="연속횟수">
										<form:option value="1">1</form:option>
										<form:option value="2">2</form:option>
										<form:option value="3">3</form:option>
										<form:option value="4">4</form:option>
									</form:select>
								</td>
							</tr>
							<tr>
								<td rowspan="2">가상화율</td>
								<td>Critical</td>
								<td><form:select path="criticalCpuVrlzRtCmprStdr" cssClass="form-control" onchange="f_changeSelect(this)" title="비교기준">
										<form:option value="">설정안함</form:option>
										<form:option value="=">=</form:option>
										<form:option value="<>"><></form:option>
										<form:option value=">">></form:option>
										<form:option value="≥">≥</form:option>
										<form:option value="<"><</form:option>
										<form:option value="≤">≤</form:option>
									</form:select>
								</td>
								<td><form:input path="criticalCpuVrlzRtVl" cssClass="form-control onlyNumber" maxlength="3" title="CPU가상화율(Critical)" /></td>
								<td><form:select path="criticalCpuVrlzRtContCnt" cssClass="form-control" title="연속횟수">
										<form:option value="1">1</form:option>
										<form:option value="2">2</form:option>
										<form:option value="3">3</form:option>
										<form:option value="4">4</form:option>
									</form:select>
								</td>
							</tr>
							<tr>
								<td>Major</td>
								<td><form:select path="majorCpuVrlzRtCmprStdr" cssClass="form-control" onchange="f_changeSelect(this)" title="비교기준">
										<form:option value="">설정안함</form:option>
										<form:option value="=">=</form:option>
										<form:option value="<>"><></form:option>
										<form:option value=">">></form:option>
										<form:option value="≥">≥</form:option>
										<form:option value="<"><</form:option>
										<form:option value="≤">≤</form:option>
									</form:select>
								</td>
								<td><form:input path="majorCpuVrlzRtVl" cssClass="form-control onlyNumber" maxlength="3" title="CPU가상화율(Major)" /></td>
								<td><form:select path="majorCpuVrlzRtContCnt" cssClass="form-control" title="연속횟수">
										<form:option value="1">1</form:option>
										<form:option value="2">2</form:option>
										<form:option value="3">3</form:option>
										<form:option value="4">4</form:option>
									</form:select>
								</td>
							</tr>


							<tr>
								<td rowspan="4">메모리</td>
								<td rowspan="2">사용률</td>
								<td>Critical</td>
								<td><form:select path="criticalMemUseRtCmprStdr" cssClass="form-control" onchange="f_changeSelect(this)" title="비교기준">
										<form:option value="">설정안함</form:option>
										<form:option value="=">=</form:option>
										<form:option value="<>"><></form:option>
										<form:option value=">">></form:option>
										<form:option value="≥">≥</form:option>
										<form:option value="<"><</form:option>
										<form:option value="≤">≤</form:option>
									</form:select>
								</td>
								<td><form:input path="criticalMemUseRtVl" cssClass="form-control onlyNumber" maxlength="3" title="메모리사용률(Critical)" /></td>
								<td><form:select path="criticalMemUseRtContCnt" cssClass="form-control" title="연속횟수">
										<form:option value="1">1</form:option>
										<form:option value="2">2</form:option>
										<form:option value="3">3</form:option>
										<form:option value="4">4</form:option>
									</form:select>
								</td>
							</tr>
							<tr>
								<td>Major</td>
								<td><form:select path="majorMemUseRtCmprStdr" cssClass="form-control" onchange="f_changeSelect(this)" title="비교기준">
										<form:option value="">설정안함</form:option>
										<form:option value="=">=</form:option>
										<form:option value="<>"><></form:option>
										<form:option value=">">></form:option>
										<form:option value="≥">≥</form:option>
										<form:option value="<"><</form:option>
										<form:option value="≤">≤</form:option>
									</form:select>
								</td>
								<td><form:input path="majorMemUseRtVl" cssClass="form-control onlyNumber" maxlength="3" title="메모리사용률(Major)" /></td>
								<td><form:select path="majorMemUseRtContCnt" cssClass="form-control" title="연속횟수">
										<form:option value="1">1</form:option>
										<form:option value="2">2</form:option>
										<form:option value="3">3</form:option>
										<form:option value="4">4</form:option>
									</form:select>
								</td>
							</tr>
							<tr>
								<td rowspan="2">가상화율</td>
								<td>Critical</td>
								<td><form:select path="criticalMemVrlzRtCmprStdr" cssClass="form-control" onchange="f_changeSelect(this)" title="비교기준">
										<form:option value="">설정안함</form:option>
										<form:option value="=">=</form:option>
										<form:option value="<>"><></form:option>
										<form:option value=">">></form:option>
										<form:option value="≥">≥</form:option>
										<form:option value="<"><</form:option>
										<form:option value="≤">≤</form:option>
									</form:select>
								</td>
								<td><form:input path="criticalMemVrlzRtVl" cssClass="form-control onlyNumber" maxlength="3" title="메모리가상화율(Critical)" /></td>
								<td><form:select path="criticalMemVrlzRtContCnt" cssClass="form-control" title="연속횟수">
										<form:option value="1">1</form:option>
										<form:option value="2">2</form:option>
										<form:option value="3">3</form:option>
										<form:option value="4">4</form:option>
									</form:select>
								</td>
							</tr>
							<tr>
								<td>Major</td>
								<td><form:select path="majorMemVrlzRtCmprStdr" cssClass="form-control" onchange="f_changeSelect(this)" title="비교기준">
										<form:option value="">설정안함</form:option>
										<form:option value="=">=</form:option>
										<form:option value="<>"><></form:option>
										<form:option value=">">></form:option>
										<form:option value="≥">≥</form:option>
										<form:option value="<"><</form:option>
										<form:option value="≤">≤</form:option>
									</form:select>
								</td>
								<td><form:input path="majorMemVrlzRtVl" cssClass="form-control onlyNumber" maxlength="3" title="메모리가상화율(Major)" /></td>
								<td><form:select path="majorMemVrlzRtContCnt" cssClass="form-control" title="연속횟수">
										<form:option value="1">1</form:option>
										<form:option value="2">2</form:option>
										<form:option value="3">3</form:option>
										<form:option value="4">4</form:option>
									</form:select>
								</td>
							</tr>

						</tbody>
					</table>
				</form>
			</div>
			<!-- /box-body -->
			<!-- 					<div class="box-footer"></div> -->
		</div>
		<!-- /box -->
	</div>
	<!-- /col -->

	<!-- 페이지 버튼 영역 -->
	<div class="col-box-100">
		<div class="edit-btn-group">
			<div class="pull-left btns">
				<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="f_goToListPage()">
					<i class="fa fa-arrow-left"></i>
				</button>
			</div>
			<div class="pull-right btns">
				<c:if test='${empty thrdStndIdxVo.profId  }'>
					<button class="btn btn-hover-green" data-toggle="tooltip" data-original-title="등록" onclick="f_doUpdate()">
						<i class="fa fa-check"></i>
					</button>
				</c:if>
				<c:if test='${not empty thrdStndIdxVo.profId  }'>
					<button class="btn btn-hover-yellow" data-toggle="tooltip" data-original-title="수정" onclick="f_doUpdate()">
						<i class="fa fa-eraser"></i>
					</button>
					<button class="btn btn-hover-red" data-toggle="tooltip" data-original-title="삭제" onclick="f_doDelete()">
						<i class="fa fa-times"></i>
					</button>
				</c:if>


			</div>
		</div>
	</div>
</form:form>
<script>
	$(document).ready(function() {

		$('select').each(function() {
			if (this.value == '') {
				try {
					var inputVl = $(this).parent().next().children();

					$(inputVl).val('');
					$(inputVl).attr('disabled', 'disabled')
				} catch (e) {
				}

			}
		});
	});

	function f_doUpdate() {
		if (!fn_form_validation("thrdStndIdxVo")) {
			return;
		}
		if (!fn_formCheck()) {
			return;
		}
		jConfirm("임계치를 저장하시겠습니까?", function() {
			var options = {
				url : '<c:url value="updateThrdStndIdx.do" />',
				type : 'post',
				dataType : 'json',
				success : function() {
					jAlert('저장 되었습니다.', f_goToListPage);

				},
				beforeSend : function() {
					$.ncmsLoding.startFullScreen();
				},
				complete : function() {
					$.ncmsLoding.remove();
				},
				error : function(xhr, textStatus, errorThrown) {
					jAlert('오류가 발생하였습니다.');
				}
			};
			$('#thrdStndIdxVo').ajaxSubmit(options);
		});
	}
	//삭제
	function f_doDelete() {
		jConfirm("임계치를 삭제하시겠습니까?", function() {
			var url = '<c:url value="deleteThrdStndIdx.do" />';
			$.post(url, {
				"profId" : $('#profId').val()
			}, function(result) {
				if (result.success) {
					jAlert('삭제 되었습니다.', f_goToListPage);

				}
			}, "json").always(function() {
				$.ncmsLoding.remove();
			});
			;
		});
	}

	//목록조회 페이지로 이동
	function f_goToListPage() {
		location.href = "selectThrdStndIdxList.do";
	}
	//비교기준 change 시 기준값 disabled 처리
	function f_changeSelect(obj) {
		var val = obj.value;
		var inputVl = $(obj).parent().next().children();
		if (val == '') {
			$(inputVl).val('');
			$(inputVl).attr('disabled', 'disabled')
		} else {
			$(inputVl).removeAttr('disabled')
		}
	}
	//비교기준에 따른 기준값 필수 체크
	function fn_formCheck() {
		var isOK = true;
		$('select[id*=CmprStdr]')
				.each(
						function() {
							try {
								var inputStndVl = $(this).parent().next()
										.children();

								if (this.id != 'serverStatCmprStdr') {
									var inputId = $(inputStndVl).attr('id');

									if (this.value != ''
											&& $.trim($(inputStndVl).val()) == '') {
										jAlert('기준값을 입력하시기 바랍니다.', function() {
											$(inputStndVl).focus();
										});

										isOK = false;
										return false;
									} else {

										if (inputId.substring(
												inputId.length - 7,
												inputId.length) == 'UseRtVl'
												&& parseInt($.trim($(
														inputStndVl).val())) > 100) {//사용률
											jAlert('사용률의 기준값은 100을 초과할수 없습니다.',
													function() {
														$(inputStndVl).focus();
													});

											isOK = false;
											return false;
										}
									}
								}
							} catch (e) {
							}

						});
		if (checkVal($('#criticalCpuUseRtVl').val(), $('#majorCpuUseRtVl')
				.val())) {
			jAlert('CPU 사용률(Major) 은 CPU 사용률(Critical) 보다 클수 없습니다. ',
					function() {
						$('#majorCpuUseRtVl').focus();

						return false;
					});
			isOK = false;
		}
		if (checkVal($('#criticalCpuVrlzRtVl').val(), $('#majorCpuVrlzRtVl')
				.val())) {
			jAlert('CPU 가상화율(Major) 은 CPU 가상화율(Critical) 보다 클수 없습니다. ',
					function() {
						$('#majorCpuVrlzRtVl').focus();

						return false;
					});
			isOK = false;
		}
		if (checkVal($('#criticalMemUseRtVl').val(), $('#majorMemUseRtVl')
				.val())) {
			jAlert('메모리 사용률(Major) 은 메모리 사용률(Critical) 보다 클수 없습니다. ',
					function() {
						$('#majorMemUseRtVl').focus();

						return false;
					});
			isOK = false;
		}
		if (checkVal($('#criticalMemVrlzRtVl').val(), $('#majorMemVrlzRtVl')
				.val())) {
			jAlert('메모리 가상화율(Major) 은 메모리 가상화율(Critical) 보다 클수 없습니다. ',
					function() {
						$('#majorMemVrlzRtVl').focus();

						return false;
					});
			isOK = false;
		}

		return isOK;
	}
	function checkVal(num1, num2) {
		if (num1 == "") {
			return false;
		}
		if (num2 == "") {
			return false;
		}
		return eval(num1) <= eval(num2);
	}
</script>
