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
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform"%>

<script type="text/javascript" src="<c:url value="/resources/js/common/ncms_common.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.dataTables.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colResize.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colVis.js" />"></script>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>
<form:form commandName="searchVo" method="get">
	<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />
	<!-- col-box : 기본적으로 해당 가로사이즈(%)를 유지합니다. -->
	<div class="col-box-100 search-col">

		<!-- box : 컨텐츠의 내용을 분류해주는 요소입니다. header(타이틀)와 body, footer로 나누어집니다. -->
		<!-- box(검색조건) -->
		<div class="box box-search">

			<div class="box-header">
				<h3 class="box-title">검색조건</h3>
				<div class="box-tools pull-right">
					<button type="button" class="btn btn-sm" data-toggle="collapse" data-target=".search-collapse" onclick="return false;">
						<i class="fa fa-chevron-up" data-toggle="tooltip" title="접어두기"></i>
					</button>
				</div>
			</div>
			<!-- /box-header -->

			<!-- box-body -->
			<div class="box-body collapse in search-collapse">
				<div class="form-group">

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label>검색기간</label>
						</div>
						<div class="cell-body">
							<div class="input-group-box">
								<div class="input-group-cell pad-right-5">
									<div class="input-group">
										<form:select path="searchTrmCd" cssClass="form-control input-sm" title="검색기간" onchange="f_changeSearchTrmCd(this.value)">
											<form:option value="">전체</form:option>
											<form:option value="01">최근 1시간</form:option>
											<form:option value="02">최근 24시간</form:option>
											<form:option value="03">최근 1주일</form:option>
											<form:option value="04">최근 1개월</form:option>
											<form:option value="05">직접입력</form:option>
										</form:select>
									</div>
								</div>
								<div class="input-group-cell" id="divDate">
									<div class="input-group period period-start">
										<form:input path="strtDt" cssClass="form-control input-sm datepicker onlyDate" maxlength="" title="시작일자" onchange="initDate(this, 'endDt', 'S')" />
									</div>
									<div class="input-group period period-end">
										<form:input path="endDt" cssClass="form-control input-sm datepicker onlyDate" title="종료일자" onchange="initDate(this, 'strtDt', 'E')" />
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label>발생유형</label>
						</div>
						<div class="cell-body">
							<form:input path="evntOccrReasn" cssClass="form-control input-sm" maxlength="" title="발생유형" />
						</div>
					</div>
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label>발생대상</label>
						</div>
						<div class="cell-body">
							<form:input path="occrObjectId" cssClass="form-control input-sm" maxlength="" title="발생대상" />
						</div>
					</div>
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label>내용</label>
						</div>
						<div class="cell-body">
							<form:input path="cn" cssClass="form-control input-sm" maxlength="" title="내용" />
						</div>
					</div>
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label>센터</label>
						</div>
						<div class="cell-body">
							<nform:selectRegion
								name="regionId"
								id="regionId"
								whole="true"
								value="${searchVo.regionId}"
								wholeText="전체"
								cssClass="form-control col-lay-100  input-sm"
								byRole="false"
								onchange="selectZoneByNetClCd('regionId', 'zoneId', 'netId', 'rsrcPoolId')"
								title="센터" />
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label>존</label>
						</div>
						<div class="cell-body">
							<nform:selectZone
								name="zoneId"
								id="zoneId"
								whole="true"
								value="${searchVo.zoneId}"
								regionId="${searchVo.regionId}"
								wholeText="전체"
								cssClass="form-control col-lay-100 input-sm"
								onchange="selectPoolByNetClCd('regionId', 'zoneId', 'netId', 'rsrcPoolId', {searchPoolTypeCd : '05','searchCtlTrgtYn' : 'N'})"
								title="존" />
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label>망구분</label>
						</div>
						<div class="cell-body">
							<nform:selectCode
								parentCd="NETCD"
								parentGrpCd="067"
								name="netId"
								id="netId"
								whole="true"
								title="망구분"
								wholeText="전체"
								value="${searchVo.netId}"
								onchange="selectPoolByNetClCd('regionId', 'zoneId', 'netId', 'rsrcPoolId', {searchPoolTypeCd : '05','searchCtlTrgtYn' : 'N'})"
								cssClass="form-control" />
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label>자원풀</label>
						</div>
						<div class="cell-body">
							<nform:selectPool
								name="rsrcPoolId"
								id="rsrcPoolId"
								wholeText="전체"
								value="${searchVo.rsrcPoolId}"
								poolTypeCd="05"
								regionId="${searchVo.regionId}"
								zoneId="${searchVo.zoneId}"
								netClCd="${searchVo.netId}"
								cssClass="form-control col-lay-100  input-sm"
								title="자원풀" />
						</div>
					</div>
					<!-- form-cell : 검색조건박스에서 사용되는 검색요소 컴포넌트 단위입니다. -->
					<!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
					<div class="form-cell form-cell-50 col-lay-25">

						<div class="cell-title">
							<label></label>
						</div>
						<div class="cell-body">
							<div class="input-group input-group-check">
								<%-- <input type="checkbox" class="input-sm"> --%>
								<label></label>
							</div>
						</div>
					</div>

				</div>
			</div>
			<!-- box-body -->

			<div class="box-footer collapse in search-collapse">
				<div class="pull-left">
					<button type="button" class="btn" onclick="fn_reset();" title="검색조건 초기화">초기화</button>
				</div>
				<div class="pull-right">
					<button type="submit" class="btn btn-red pull-right" onclick="fn_search();return false;">조회</button>
				</div>
			</div>
			<!-- /box-footer -->

		</div>
		<!-- /box(검색조건) -->
	</div>
	<!-- /col -->
</form:form>

<!-- col-box : 기본적으로 해당 가로사이즈(%)를 유지합니다. -->
<div class="col-box-100 search-col">
	<!-- box : 컨텐츠의 내용을 분류해주는 요소입니다. header(타이틀)와 body, footer로 나누어집니다. -->
	<!-- box(목록조회 테이블) -->
	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">
				이벤트 목록 <small>${searchVo.paginationInfo.currentPageNo } /
					${searchVo.paginationInfo.totalPageCount }, 총
					${searchVo.paginationInfo.totalRecordCount }건 </small>
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo }" />
					<div class="input-group-cell pad-right">
						<button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="excelDown()">
							<i class="fa fa-download"></i>
						</button>
					</div>
				</div>

			</div>
		</div>
		<!-- /box-header -->

		<div class="box-body no-padding list-body">
			<table class="table table-hover table-vertical table-layout-fixed" id="tableEvntStteList">
				<caption>자동확장 이벤트 현황 목록</caption>

				<thead>
					<tr>
						<th><nobr>No.</nobr></th>
						<th><nobr>발생일시</nobr></th>
						<th><nobr>발생유형</nobr></th>
						<th><nobr>발생대상</nobr></th>
						<th>센터</th>
						<th><nobr>존</nobr></th>
						<th><nobr>망구분</nobr></th>
						<th><nobr>자원풀</nobr></th>
						<th><nobr>내용</nobr></th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${list eq null or empty list }">
							<!-- 	<tr>
								<td colspan="11">검색된 데이터가 없습니다.</td>
							</tr> -->
						</c:when>
						<c:otherwise>
							<c:forEach var="vo" items="${list }" varStatus="i">

								<tr>
									<td><nobr><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></nobr></td>
									<td><nobr>${vo.occrDttm }</nobr></td>
									<td class="alignL ellipsis"><nobr>${vo.evntOccrReasn }</nobr></td>
									<td class="alignL ellipsis"><nobr>${vo.occrObjectId}</nobr></td>
									<td class=""><nobr>${vo.regionNm }</nobr></td>
									<td class=""><nobr>${vo.zoneNm }</nobr></td>
									<td class="alignL"><nobr>${vo.netNm }</nobr></td>
									<td class="alignL"><nobr>${vo.rsrcPoolNm }</nobr></td>
									<td class="alignL ellipsis"><nobr title='${vo.msgCn }'>${vo.msgCn }</nobr></td>

								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		<!-- /box-body -->

		<div class="box-footer edit-btn-group">
			<div class="pull-left btns">
				<!-- <button class="btn btn-sm btn-hover-red" data-toggle="tooltip" title="" data-original-title="삭제하기"><i class="fa fa-times"></i></button> -->
			</div>
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="goPage" />
			</ul>
			<div class="pull-right btns">
				<!-- <button class="btn btn-sm btn-hover-blue" data-toggle="tooltip" title="" data-original-title="추가하기"><i class="fa fa-plus"></i></button> -->
				<!-- <button class="btn btn-sm btn-hover-yellow" data-toggle="tooltip" title="" data-original-title="수정하기"><i class="fa fa-font"></i></button> -->
				<!-- <button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="기타 버튼"><i class="fa fa-check"></i></button> -->
				<!-- <button class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" data-placement="left" onclick="excelDown()"><i class="fa fa-arrow-down"></i></button> -->
			</div>
		</div>
		<!-- /box-footer -->
	</div>
	<!-- /box(목록조회 테이블) -->
</div>
<!-- /col -->

<script>
	$(document).ready(function() {

		function pageInit() {
			$('#searchTrmCd').trigger('change');
			var autoColumns = [ {
				sWidth : "40px"
			}, {
				sWidth : "80px"
			}, {
				sWidth : "60px"
			}, {
				sWidth : "90px"
			}, {
				sWidth : "40px"
			}, {
				sWidth : "40px"
			}, {
				sWidth : "50px"
			}, {
				sWidth : "60px"
			}, {
				sWidth : "200px"
			}];
			fn_dataTable("tableEvntStteList", 0, autoColumns)//테이블 정렬및 resize
			//fn_setRegion2PoolCombo('regionId','zoneId','netId','rsrcPoolId');//리전/존/망/자원풀 select 셋팅
		}
		pageInit();

	});
	//검색조건 초기화
	function fn_reset() {
		//$("#searchVo input[type='text']").val("");
		$("#searchTrmCd option:eq(1)").attr("selected", "selected");
		f_changeSearchTrmCd("");
		$("#evntOccrReasn").val("");
		$("#regionId").val("").attr("selected", "selected");
		$("#zoneId").val("").attr("selected", "selected");
		$("#netId").val("").attr("selected", "selected");
		$("#rsrcPoolId").val("").attr("selected", "selected");
		$("#cn").val("");
	}
	function f_changeSearchTrmCd(val) {
		if (val == '05') {//직접입력
			$('#divDate').show();
		} else {
			$('#divDate').hide();
			$('#strtDt').val('');
			$('#endDt').val('');
		}
	}
	function f_confirm(evntSeq) {
		//jConfirm("임계치를 삭제하시겠습니까?", function() {
		var url = '<c:url value="updateAxEvntConfrm.do" />';
		$.post(url, {
			"evntSeq" : evntSeq
		}, function(result) {
			if (result.success) {
				jAlert('정상 처리 되었습니다.', f_goToListPage);
				//f_goToListPage();
			}
		}, "json").always(function() {
			$.ncmsLoding.remove();
		});
		//});
	}
	function f_cancel(evntSeq) {
		var url = '<c:url value="updateAxEvntConfrmCncl.do" />';
		$.post(url, {
			"evntSeq" : evntSeq
		}, function(result) {
			if (result.success) {
				jAlert('정상 처리 되었습니다.', f_goToListPage);

			}
		}, "json").always(function() {
			$.ncmsLoding.remove();
		});
	}
	function f_goToListPage() {
		goPage("${searchVo.paginationInfo.currentPageNo}");
	}
	var curPageNo = "${searchVo.paginationInfo.currentPageNo}";
	function goPage(page) {
		location.href = "selectAxEvntStteList.do?paginationInfo.currentPageNo="
				+ page + "&${listParam}";
	}
	function excelDown() {
		if ("${searchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("엑셀로 다운로드할 데이터가 없습니다.");
			return;
		}
		searchVo.action = '<c:url value="selectAxEvntStteXlsDown.do" />';
		searchVo.submit();
	}
	function fn_search() {
		if (!fn_form_validation("searchVo")) {
			return;
		}
		var val = $('#searchTrmCd').val();

		if (val == '05') {//일
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
		searchVo.action = '<c:url value="selectAxEvntStteList.do" />';
		searchVo.submit();
	}
</script>