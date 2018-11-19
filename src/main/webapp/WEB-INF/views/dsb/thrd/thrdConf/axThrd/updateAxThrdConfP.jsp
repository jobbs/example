<%--
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 9. 22.
 * @lastmodified 2017. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 9. 22.     양정순         v1.0             최초생성
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
<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<c:set var='rowSpan' value="2" />

<form:form commandName="pmThrdConfVo" method="post">

	<form:hidden path="trgtSrvrClCd" />
	<form:hidden path="thresTrgtSrvrSeq" />

	<form:hidden path="gubun" />
	<form:hidden path="regionId" />
	<form:hidden path="netId" />
	<form:hidden path="zoneId" />
	<form:hidden path="rsrcPoolId" />
	<form:hidden path="clstrSeq" />
	<form:hidden path="pmSeq" />
	<form:hidden path="vmSeq" />
	<form:hidden path="servcSeq" />
	<form:hidden path="institutionId" />
	<form:hidden path="jobId" />
	<div class="col-box-100">

		<!-- nav-tabs-custom : 탭 레이아웃 요소입니다. .nav-tabs(탭메뉴)와 .tab-content(탭내용)로 나누어집니다. -->
		<div class="nav-tabs-custom">

			<!-- /nav-tabs -->
			<div class="tab-content">

					<!-- box : 컨텐츠의 내용을 분류해주는 요소입니다. header(타이틀)와 body, footer로 나누어집니다. -->
					<!-- box -->
					<div class="box">
						<div class="box-header">
							<h3 class="box-title">자동확장 임계치 설정</h3>
							<!--<div class="box-tools">
			                <div class="pull-right">
			                  <button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드"><i class="fa fa-download"></i></button>
			                </div>
			              </div>-->
						</div>
						<!-- /box-header -->
						<div class="box-body no-padding">
							<table id="table2" class="table table-bordered table-vertical">
								<caption>직접입력</caption>
								<colgroup>
									<col class="colAuto">
									<col class="col15">
									<col class="col15">
									<col class="col15">
									<col class="col15">
									<col class="col15">
									<col>
								</colgroup>
								<thead>
									<tr>
										<th>지표</th>
										<th>구분</th>
										<th>등급</th>
										<th>비교기준</th>
										<th>값</th>
										<th>연속횟수</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>Scale In/Out</td>
										<td></td>
										<td></td>
										<td><form:select path="serverStatCmprStdr" cssClass="form-control input-sm" title="비교기준">
												<form:option value="">설정안함</form:option>
												<form:option value="=">설정</form:option>
											</form:select>
										</td>
										<td></td>
										<td><form:select path="serverStatContCnt" cssClass="form-control input-sm" title="연속횟수">
												<form:option value="1">1</form:option>
												<form:option value="2">2</form:option>
												<form:option value="3">3</form:option>
												<form:option value="4">4</form:option>
											</form:select>
										</td>
									</tr>
									<tr>
										<td>Warning 이벤트</td>
										<td></td>
										<td></td>
										<td><form:select path="warningStatCmprStdr" cssClass="form-control input-sm" title="비교기준">
												<form:option value="">설정안함</form:option>
												<form:option value="=">설정</form:option>
											</form:select>
										</td>
										<td></td>
										<td><form:select path="warningStatContCnt" cssClass="form-control input-sm" title="연속횟수">
												<form:option value="1">1</form:option>
												<form:option value="2">2</form:option>
												<form:option value="3">3</form:option>
												<form:option value="4">4</form:option>
											</form:select>
										</td>
									</tr>
									<tr>
										<td rowspan="${rowSpan }">CPU</td>
										<td rowspan="2">사용률</td>
										<td>Critical</td>
										<td><form:select path="criticalCpuUseRtCmprStdr" cssClass="form-control input-sm" onchange="f_changeSelect(this)" title="비교기준">
												<form:option value="">설정안함</form:option>
												<form:option value="=">=</form:option>
												<form:option value="<>">&lt;></form:option>
												<form:option value=">">></form:option>
												<form:option value="≥">≥</form:option>
												<form:option value="<">&lt;</form:option>
												<form:option value="≤">≤</form:option>
											</form:select>
										</td>
										<td><form:input path="criticalCpuUseRtVl" cssClass="form-control onlyNumber" type="number" maxlength="3" title="CPU사용률(Critical)" /></td>
										<td><form:select path="criticalCpuUseRtContCnt" cssClass="form-control input-sm" title="연속횟수">
												<form:option value="1">1</form:option>
												<form:option value="2">2</form:option>
												<form:option value="3">3</form:option>
												<form:option value="4">4</form:option>
											</form:select>
										</td>
									</tr>
									<tr>
										<td>Major</td>
										<td><form:select path="majorCpuUseRtCmprStdr" cssClass="form-control input-sm" onchange="f_changeSelect(this)" title="비교기준">
												<form:option value="">설정안함</form:option>
												<form:option value="=">=</form:option>
												<form:option value="<>">&lt;></form:option>
												<form:option value=">">></form:option>
												<form:option value="≥">≥</form:option>
												<form:option value="<">&lt;</form:option>
												<form:option value="≤">≤</form:option>
											</form:select></td>
										<td><form:input path="majorCpuUseRtVl" cssClass="form-control onlyNumber" type="number" maxlength="3" title="CPU사용률(Major)" /></td>
										<td><form:select path="majorCpuUseRtContCnt" cssClass="form-control input-sm" title="연속횟수">
												<form:option value="1">1</form:option>
												<form:option value="2">2</form:option>
												<form:option value="3">3</form:option>
												<form:option value="4">4</form:option>
											</form:select>
										</td>
									</tr>
									<tr>
										<td rowspan="${rowSpan }">메모리</td>
										<td rowspan="2">사용률</td>
										<td>Critical</td>
										<td><form:select path="criticalMemUseRtCmprStdr" cssClass="form-control input-sm" onchange="f_changeSelect(this)" title="비교기준">
												<form:option value="">설정안함</form:option>
												<form:option value="=">=</form:option>
												<form:option value="<>">&lt;></form:option>
												<form:option value=">">></form:option>
												<form:option value="≥">≥</form:option>
												<form:option value="<">&lt;</form:option>
												<form:option value="≤">≤</form:option>
											</form:select>
										</td>
										<td><form:input path="criticalMemUseRtVl" cssClass="form-control onlyNumber" type="number" maxlength="3" title="메모리사용률(Critical)" /></td>
										<td><form:select path="criticalMemUseRtContCnt" cssClass="form-control input-sm" title="연속횟수">
												<form:option value="1">1</form:option>
												<form:option value="2">2</form:option>
												<form:option value="3">3</form:option>
												<form:option value="4">4</form:option>
											</form:select>
										</td>
									</tr>
									<tr>
										<td>Major</td>
										<td><form:select path="majorMemUseRtCmprStdr" cssClass="form-control input-sm" onchange="f_changeSelect(this)" title="비교기준">
												<form:option value="">설정안함</form:option>
												<form:option value="=">=</form:option>
												<form:option value="<>">&lt;></form:option>
												<form:option value=">">></form:option>
												<form:option value="≥">≥</form:option>
												<form:option value="<">&lt;</form:option>
												<form:option value="≤">≤</form:option>
											</form:select>
										</td>
										<td><form:input path="majorMemUseRtVl" cssClass="form-control onlyNumber" type="number" maxlength="3" title="메모리사용률(Major)" /></td>
										<td><form:select path="majorMemUseRtContCnt" cssClass="form-control input-sm" title="연속횟수">
												<form:option value="1">1</form:option>
												<form:option value="2">2</form:option>
												<form:option value="3">3</form:option>
												<form:option value="4">4</form:option>
											</form:select>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<!-- /box -->
				</div>
				<!-- /tab-pane -->
		</div>
		<!-- /nav-tabs-custom -->
	</div>
	<!-- /col -->
</form:form>
<!-- popup 버튼 -->
<div class="col-box-100">
	<div class="button">
		<menu:authorize>
			<button class="btn btn-dark " onclick="fn_save();return false;">저장</button>
		</menu:authorize>
		<button type="button" class="btn" onclick="fn_reset();" title="초기화">초기화</button>
		<button class="btn close-window">닫기</button>

	</div>
</div>
<!-- /popup 버튼 -->
<script>
	var profList = [];
	var profData = {};
	<c:forEach var="vo" items="${list }" varStatus="i">
	profData = {
		"profId" : "${vo.profId}"
		/* ,"profNm":"${vo.profNm}"
		, "dc":"${vo.dc}" */
		,
		"serverStatContCnt" : "${vo.serverStatContCnt}",
		"serverStatCmprStdr" : "${vo.serverStatCmprStdr}",
		"criticalCpuUseRtVl" : "${vo.criticalCpuUseRtVl}",
		"criticalCpuUseRtCmprStdr" : "${vo.criticalCpuUseRtCmprStdr   }",
		"criticalCpuUseRtContCnt" : "${vo.criticalCpuUseRtContCnt    }",
		"majorCpuUseRtVl" : "${vo.majorCpuUseRtVl            }",
		"majorCpuUseRtCmprStdr" : "${vo.majorCpuUseRtCmprStdr      }",
		"majorCpuUseRtContCnt" : "${vo.majorCpuUseRtContCnt       }",
		"criticalCpuVrlzRtVl" : "${vo.criticalCpuVrlzRtVl        }",
		"criticalCpuVrlzRtCmprStdr" : "${vo.criticalCpuVrlzRtCmprStdr  }",
		"criticalCpuVrlzRtContCnt" : "${vo.criticalCpuVrlzRtContCnt   }",
		"majorCpuVrlzRtVl" : "${vo.majorCpuVrlzRtVl           }",
		"majorCpuVrlzRtCmprStdr" : "${vo.majorCpuVrlzRtCmprStdr     }",
		"majorCpuVrlzRtContCnt" : "${vo.majorCpuVrlzRtContCnt      }",
		"criticalMemUseRtVl" : "${vo.criticalMemUseRtVl         }",
		"criticalMemUseRtCmprStdr" : "${vo.criticalMemUseRtCmprStdr   }",
		"criticalMemUseRtContCnt" : "${vo.criticalMemUseRtContCnt    }",
		"majorMemUseRtVl" : "${vo.majorMemUseRtVl            }",
		"majorMemUseRtCmprStdr" : "${vo.majorMemUseRtCmprStdr      }",
		"majorMemUseRtContCnt" : "${vo.majorMemUseRtContCnt       }",
		"criticalMemVrlzRtVl" : "${vo.criticalMemVrlzRtVl        }",
		"criticalMemVrlzRtCmprStdr" : "${vo.criticalMemVrlzRtCmprStdr  }",
		"criticalMemVrlzRtContCnt" : "${vo.criticalMemVrlzRtContCnt   }",
		"majorMemVrlzRtVl" : "${vo.majorMemVrlzRtVl           }",
		"majorMemVrlzRtCmprStdr" : "${vo.majorMemVrlzRtCmprStdr     }",
		"majorMemVrlzRtContCnt" : "${vo.majorMemVrlzRtContCnt      }"
	};
	profList.push(profData);
	</c:forEach>

	//직접입력 탭 선택시 프로파일이 선택되어 있으면 프로파일값을 직접입력에 셋팅
	var tab = 'b';//저장시 현재 탭을 알기 위함
	function fn_clickTab(val) {
		tab = val;
		if (val == 'b') {
			var len = $('input[type=radio]:checked').length;
			if (len == 1) {
				var profId = $('input[type=radio]:checked').val();
				for (var i = 0; i < profList.length; i++) {
					if (profId == profList[i].profId) {
						$('#serverStatContCnt').val(
								profList[i].serverStatContCnt);
						$('#serverStatCmprStdr').val(
								profList[i].serverStatCmprStdr);
						$("#criticalCpuUseRtVl").val(
								profList[i].criticalCpuUseRtVl);
						$("#criticalCpuUseRtCmprStdr").val(
								profList[i].criticalCpuUseRtCmprStdr);
						$("#criticalCpuUseRtContCnt").val(
								profList[i].criticalCpuUseRtContCnt);
						$("#majorCpuUseRtVl").val(profList[i].majorCpuUseRtVl);
						$("#majorCpuUseRtCmprStdr").val(
								profList[i].majorCpuUseRtCmprStdr);
						$("#majorCpuUseRtContCnt").val(
								profList[i].majorCpuUseRtContCnt);
						$("#criticalCpuVrlzRtVl").val(
								profList[i].criticalCpuVrlzRtVl);
						$("#criticalCpuVrlzRtCmprStdr").val(
								profList[i].criticalCpuVrlzRtCmprStdr);
						$("#criticalCpuVrlzRtContCnt").val(
								profList[i].criticalCpuVrlzRtContCnt);
						$("#majorCpuVrlzRtVl")
								.val(profList[i].majorCpuVrlzRtVl);
						$("#majorCpuVrlzRtCmprStdr").val(
								profList[i].majorCpuVrlzRtCmprStdr);
						$("#majorCpuVrlzRtContCnt").val(
								profList[i].majorCpuVrlzRtContCnt);
						$("#criticalMemUseRtVl").val(
								profList[i].criticalMemUseRtVl);
						$("#criticalMemUseRtCmprStdr").val(
								profList[i].criticalMemUseRtCmprStdr);
						$("#criticalMemUseRtContCnt").val(
								profList[i].criticalMemUseRtContCnt);
						$("#majorMemUseRtVl").val(profList[i].majorMemUseRtVl);
						$("#majorMemUseRtCmprStdr").val(
								profList[i].majorMemUseRtCmprStdr);
						$("#majorMemUseRtContCnt").val(
								profList[i].majorMemUseRtContCnt);
						$("#criticalMemVrlzRtVl").val(
								profList[i].criticalMemVrlzRtVl);
						$("#criticalMemVrlzRtCmprStdr").val(
								profList[i].criticalMemVrlzRtCmprStdr);
						$("#criticalMemVrlzRtContCnt").val(
								profList[i].criticalMemVrlzRtContCnt);
						$("#majorMemVrlzRtVl")
								.val(profList[i].majorMemVrlzRtVl);
						$("#majorMemVrlzRtCmprStdr").val(
								profList[i].majorMemVrlzRtCmprStdr);
						$("#majorMemVrlzRtContCnt").val(
								profList[i].majorMemVrlzRtContCnt);

					}
				}
			}
		}
		fn_selectInit();
	}
	//검색조건 초기화
	function fn_reset() {
		jConfirm("임계치설정을 초기화하시겠습니까?", function() {
			var url = '<c:url value="deleteThrdConf.do" />';
			$.post(url, {
				"servcSeq" : $('#thresTrgtSrvrSeq').val(),
				"institutionId" : $('#institutionId').val(),
				"jobId" : $('#jobId').val()
			}, function(result) {
				if (result.success) {
					opener.location.reload(true);
					self.close();
				}
			}, "json").always(function() {
				$.ncmsLoding.remove();
			});
		});



	}

	function fn_save() {
		var submitData = getContainerData($('#pmThrdConfVo'));
		if (tab == 'a') {
			if ($('input[type=radio]:checked').length == 0) {
				jAlert('프로파일을 선택하시기 바랍니다.');
				return;
			}

		} else {
			if (!fn_form_validation("pmThrdConfVo")) {
				return;
			}
			if (!fn_formCheck()) {
				return;
			}
			delete submitData.profId;
		}

		var options = {
			url : '<c:url value="updateThrdConf.do" />',
			data : JSON.stringify(submitData),
			type : 'POST',
			dataType : 'json',
			contentType : "application/json;charset=UTF-8",
			success : function(result) {
				if (result.success) {
					jInfo('저장 되었습니다.', function() {
						opener.location.reload(true);
						self.close();
					});
				} else {
					jAlert('저장 중 오류가 발생하였습니다.');
				}
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
		jConfirm('저장하시겠습니까?', function() {
			$.ajax(options);
		});
	}
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

								if (this.id != 'serverStatCmprStdr' && this.id != 'warningStatCmprStdr') {
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

		if (checkVal($('#criticalMemUseRtVl').val(), $('#majorMemUseRtVl')
				.val())) {
			jAlert('메모리 사용률(Major) 은 메모리 사용률(Critical) 보다 클수 없습니다. ',
					function() {
						$('#majorMemUseRtVl').focus();

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
	function fn_selectInit() {
		$('select').each(function() {
			if (this.value == '') {

				try {
					var inputVl = $(this).parent().next().children();

					$(inputVl).val('');
					$(inputVl).attr('disabled', 'disabled');
				} catch (e) {
				}
			} else {
				var inputVl = $(this).parent().next().children();
				$(inputVl).removeAttr('disabled');
			}
		});
	}
	function fn_checkRadio(tdProfileNm) {
		$(':radio', $(tdProfileNm).parent()).trigger('click');
	}
</script>