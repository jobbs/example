<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     최진호         v1.0             최초생성
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

<div class="col-box-100">
	<form:form commandName="searchVo" method="get">
	<form:hidden path="searchType"/>
	<form:hidden path="poolListStr"/>
	<div class="box-search">
		<div class="box-body">
			<div class="form-group">
				<div class="form-cell form-cell-50 col-lay-50">
					<div class="cell-title">
						<label title="분석기준" for="searchTrmCd">분석기준</label>
					</div>
					<div class="cell-body">
						<div class="input-group-box">
							<div class="input-group-cell pad-right-5">
								<div class="input-group">
									<form:select path="searchTrmCd" cssClass="form-control input-sm" title="통보상태" onchange="f_changeSearchTrmCd(this.value)">
										<form:option value="DD">일</form:option>
										<form:option value="MM">월</form:option>
										<form:option value="QQ">분기</form:option>
										<form:option value="HH">반기</form:option>
										<form:option value="YY">년</form:option>
										<form:option value="DI">직접입력</form:option>
									</form:select>
								</div>
							</div>
							<div class="input-group-cell pad-right-5" id="divDD">
								<div class="input-group period">
									<form:input
										path="date"
										cssClass="form-control input-sm datepicker onlyDate"
										title="날짜" />
								</div>
							</div>
							<div class="input-group-cell pad-right-5" id="divDI">
								<div class="input-group period period-start">
									<form:input
										path="strtDt"
										cssClass="form-control input-sm datepicker onlyDate"
										maxlength=""
										title="시작일자"
										onchange="initDate(this, 'endDt', 'S')" />
								</div>
								<div class="input-group period period-end">
									<form:input
										path="endDt"
										cssClass="form-control input-sm datepicker onlyDate"
										title="종료일자"
										onchange="initDate(this, 'strtDt', 'E')" />
								</div>
							</div>
							<div class="input-group-cell pad-right-5" id="divYY">
								<form:select path="year" cssClass="form-control input-sm"
									title="날짜">
									<c:forEach var="yearVo" items="${yearCdList }">
										<form:option value="${yearVo.cd}">
											<c:out value="${yearVo.cdNm }" />
										</form:option>
									</c:forEach>
								</form:select>
							</div>
							<div class="input-group-cell pad-right-5" id="divMM">
								<form:select path="searchMmCd" cssClass="form-control input-sm" title="월">
									<form:option value="01">1월</form:option>
									<form:option value="02">2월</form:option>
									<form:option value="03">3월</form:option>
									<form:option value="04">4월</form:option>
									<form:option value="05">5월</form:option>
									<form:option value="06">6월</form:option>
									<form:option value="07">7월</form:option>
									<form:option value="08">8월</form:option>
									<form:option value="09">9월</form:option>
									<form:option value="10">10월</form:option>
									<form:option value="11">11월</form:option>
									<form:option value="12">12월</form:option>
								</form:select>
							</div>
							<div class="input-group-cell pad-right-5" id="divQQ">
								<form:select path="searchQqCd" cssClass="form-control input-sm" title="분기">
									<form:option value="01">1분기</form:option>
									<form:option value="02">2분기</form:option>
									<form:option value="03">3분기</form:option>
									<form:option value="04">4분기</form:option>
								</form:select>
							</div>
							<div class="input-group-cell pad-right-5" id="divHH">
								<div class="">
									<form:select path="searchHhCd" cssClass="form-control input-sm" title="반기">
										<form:option value="01">상반기</form:option>
										<form:option value="02">하반기</form:option>
									</form:select>
								</div>
							</div>
						</div>
						<!-- /input-group-box -->
					</div>
				</div>

				<div class="form-cell form-cell-50 col-lay-50"></div>

				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchRegionId">센터</label>
					</div>
					<div class="cell-body">
						<nform:selectRegion
						        name="searchRegionId"
						        id="searchRegionId"
						        byRole="false"
						        cssClass="form-control input-sm"
						        value="${searchVo.searchRegionId }"
						        onchange="selectZoneDy(this, 'searchZoneId', {'byRole' : false} )"
						        title="센터"/>
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchZoneId">존</label>
					</div>
					<div class="cell-body">
						<nform:selectZone
						        name="searchZoneId"
						        id="searchZoneId"
						        byRole="false"
						        regionId="${searchVo.searchRegionId }"
						        value="${searchVo.searchZoneId }"
						        cssClass="form-control input-sm"
						        onchange="selectNetDy(this, 'searchNetId', {'byRole' : false} )"
						        title="존"/>
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="searchNetId">망</label>
					</div>
					<div class="cell-body">
						<nform:selectNet
						        name="searchNetId"
						        id="searchNetId"
						        byRole="false"
						        value="${searchVo.searchNetId }"
						        zoneId="${searchVo.searchZoneId }"
						        cssClass="form-control input-sm"
						        title="망" />
					</div>
				</div>

				<div class="form-cell form-cell-100 alignR pad-top-5">
					<button type="submit" class="btn btn-red" onclick="fn_search();return false;">조회</button>
				</div>
			</div>
		</div>
	</div>
	</form:form>

	<div class="box">
		<!-- box-body -->
		<div class="box-body no-padding">
			<form action="poolFrm" id="poolFrm">
			<table class="table table-hover table-vertical">
				<caption>자원풀 목록 테이블</caption>
				<colgroup>
					<col class="col10">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
				</colgroup>
				<thead>
				<tr>
					<th>
						<input type="checkbox" id="chkPoolAll" title="자원풀 전체 선택" onclick="doCheckAll(this, 'rsrcPoolId')" />
					</th>
					<th>센터</th>
					<th>존</th>
					<th>망</th>
					<th>자원풀명</th>
				</tr>
				</thead>
				<tbody>
				<tr>
					<c:choose>
						<c:when test="${list eq null or empty list }">
							<tr>
								<td colspan="5">검색된 데이터가 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="vo" items="${list }" varStatus="i">
								<tr>
									<td>
										<input type="checkbox" name="rsrcPoolId" class="rsrcPoolId" value="${vo.rsrcPoolId }" title="자원풀ID ${vo.rsrcPoolId }"/>
										<input type="hidden" name="regionId" value="${vo.regionId }" style="display: none;" />
										<input type="hidden" name="rsrcPoolNm" value="${vo.rsrcPoolNm }" style="display: none;" />
										<input type="hidden" name="regionNm" value="${vo.regionNm }" style="display: none;" />
										<input type="hidden" name="zoneNm" value="${vo.zoneNm }" style="display: none;" />
										<input type="hidden" name="netNm" value="${vo.netNm }" style="display: none;" />
									</td>
									<td><c:out value="${vo.regionNm }" /></td>
									<td><c:out value="${vo.zoneNm }" /></td>
									<td><c:out value="${vo.netNm }" /></td>
									<td class="alignL"><c:out value="${vo.rsrcPoolNm }" /></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tr>
				</tbody>
			</table>
			</form>
		</div>
		<!-- /box-body -->
	</div>
</div>
<div class="col-box-100">
	<div class="button">
		<button type="button" class="btn btn-default" onclick="oprStatExcel('1')">월간통계 다운로드</button>
		<button type="button" class="btn btn-default" onclick="oprStatExcel('2')">물리서버 최소 다운로드</button>
		<button type="button" class="btn close-window" onclick="fn_close()">닫기</button>
	</div>
</div>


<script type="text/javascript" src="<c:url value="/resources/js/common/component/entity.js" />"></script>
<script type="text/javascript">
$(document).ready(function() {

	function pageInit() {
		$('#searchTrmCd').trigger('change');
	}
	pageInit();

});

function fn_search()
{
	if (!fn_form_validation("searchVo")) {
		return;
	}
	var val = $('#searchTrmCd').val();

	searchVo.action = '<c:url value="selectOprStatListP.do" />';
	searchVo.submit();
}

function oprStatExcel(statType)
{
	if( $("input:checkbox[name='rsrcPoolId']:checked").size() == 0 ) {
		jAlert("자원풀을 한항목 이상 선택하여 주시기 바랍니다.");
		return;
	}

	var val = $('#searchTrmCd').val();

	if (val == 'DD') {//일
		if ($('#date').val() == '') {
			jAlert('검색일자를 입력하시기 바랍니다.', function() {
				$('#date').focus();
			})
			return false;
		}
	} else if (val == 'DI') {//일
		if ($('#strtDt').val() == '') {
			jAlert('검색시작일자를 입력하시기 바랍니다.', function() {
				$('#strtDt').focus();
			})
			return false;
		}
		if ($('#endDt').val() == '') {
			jAlert('검색종료일자를 입력하시기 바랍니다.', function() {
				$('#endDt').focus();
			})
			return false;
		}
	}

	var datas = new Array();
	$("input:checkbox[name='rsrcPoolId']").each(function(index) {
		if( $(this).prop("checked") ) {
			datas.push( $(this).val());
		}
	});
	searchVo.poolListStr.value = datas;

	if (!fn_form_validation("searchVo")) {
		return;
	}

	if( statType == '1' )
	{
		searchVo.action = '<c:url value="selectOprStatXlsDown.do" />';
	}
	else
	{
		searchVo.action = '<c:url value="selectOprStatHvMinXlsDown.do" />';
	}

	searchVo.submit();
}


function doCheckAll(obj, clazz) {
	$("." + clazz).prop("checked", $(obj).prop("checked"));
}


function selectPoolM(){

	if( $("input:checkbox[name='rsrcPoolId']:checked").size() == 0 ) {
		jAlert("자원풀을 한항목 이상 선택하여 주시기 바랍니다.");
		return;
	}

	var datas = new Array();
	var data = null;
	$("input:checkbox[name='rsrcPoolId']").each(function(index) {
		if( $(this).prop("checked") ) {
			data = new EntityPool();
			data.rsrcPoolId = $(this).val();
			data.rsrcPoolNm = $("input:hidden[name='rsrcPoolNm']:eq(" + index + ")").val();
			data.regionId = $("input:hidden[name='regionId']:eq(" + index + ")").val();
			data.regionNm = $("input:hidden[name='regionNm']:eq(" + index + ")").val();
			data.zoneNm = $("input:hidden[name='zoneNm']:eq(" + index + ")").val();
			data.netNm = $("input:hidden[name='netNm']:eq(" + index + ")").val();
			datas.push(data);
		}
	});

	var evt = jQuery.Event('selectPoolMulti', {
		"procType" :"<c:out value="${searchVo.searchType}" />",
		"datas" : datas,
    });

    var _parent = window.opener;
    _parent.jQuery(_parent.document).trigger(evt);
	window.close();
}

$("#poolFrm input[name='rsrcPoolId']").click(function(event) {
	event.stopPropagation();
});

$("#poolFrm input[name='rsrcPoolId']").parent().parent().click(function() {
	var $target = $(this).find("input[name='rsrcPoolId']");
	if( $target.attr("type") == "radio" ) {
		$target.prop("checked", true);
	} else {
		var checked = $target.prop("checked");
		$target.prop("checked", !checked);
	}
});



function f_changeSearchTrmCd(val) {
	if (val == 'DD') {//일
		$('#divDD').show();
		$('#divMM').hide();
		$('#divQQ').hide();
		$('#divHH').hide();
		$('#divYY').hide();
		$('#divDI').hide();
	} else if (val == 'MM') {//월
		$('#divDD').hide();
		$('#divMM').show();
		$('#divQQ').hide();
		$('#divHH').hide();
		$('#divYY').show();
		$('#divDI').hide();
	} else if (val == 'QQ') {//분기
		$('#divDD').hide();
		$('#divMM').hide();
		$('#divQQ').show();
		$('#divHH').hide();
		$('#divYY').show();
		$('#divDI').hide();
	} else if (val == 'HH') {//반기
		$('#divDD').hide();
		$('#divMM').hide();
		$('#divQQ').hide();
		$('#divHH').show();
		$('#divYY').show();
		$('#divDI').hide();
	} else if (val == 'YY') {//년
		$('#divDD').hide();
		$('#divMM').hide();
		$('#divQQ').hide();
		$('#divHH').hide();
		$('#divYY').show();
		$('#divDI').hide();
	} else if (val == 'DI') {//직접입력
		$('#divDD').hide();
		$('#divMM').hide();
		$('#divQQ').hide();
		$('#divHH').hide();
		$('#divYY').hide();
		$('#divDI').show();
		//$('#strtDt').val('');
		//$('#endDt').val('');
	}
}

</script>