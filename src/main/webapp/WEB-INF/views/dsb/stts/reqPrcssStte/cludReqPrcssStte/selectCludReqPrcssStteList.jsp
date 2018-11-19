<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 09. 29.
 * @lastmodified 2016. 09. 29.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 09. 29.     양정순         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript" src="<c:url value="/resources/js/common/ncms_common.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.dataTables.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colResize.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/dataTables.colVis.js" />"></script>

<div class="col-box-100 search-col">
	<form:form commandName="searchVo" method="get" onsubmit="fn_search(); return false;">
		<input type="hidden" name="ym" id="ym" />
		<input type="hidden" name="search" value="T">
		<div class="box box-search">
			<div class="box-header">
				<h3 class="box-title">검색조건</h3>
				<div class="box-tools pull-right">
					<!-- 접기 버튼 -->
					<button type="button" class="btn btn-sm" data-toggle="collapse" data-target=".search-collapse">
						<i class="fa fa-chevron-up" data-toggle="tooltip" title="" data-original-title="접어두기"></i>
					</button>
				</div>
			</div>
			<!-- /box-header -->

			<div class="box-body collapse in search-collapse">
				<div class="form-group">
					<div class="form-cell form-cell-50 col-lay-50">
						<div class="cell-title">
							<label title="센터" for="region">센터</label>
						</div>
						<div class="cell-body">
							<div class="input-group input-group-check">
								<form:checkbox path="region" label="전체" value="regionAll" title="센터선택" id="regionAll" cssClass="essentialBy" essentialBy="region" />
								<c:forEach var="regionVo" items="${regionVoList }">
									<form:checkbox cssClass="region essentialBy" path="region" label="${regionVo.regionNm }" value="${regionVo.regionId}" essentialBy="region" />
								</c:forEach>
							</div>
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-50">
						<div class="cell-title">
							<label title="기간" for="trm">기간</label>
						</div>
						<div class="cell-body">
							<div class="input-group-box">
								<div class="input-group-cell pad-right-5">
									<div class="input-group input-group-radio">
										<form:radiobutton path="trm" label="월" value="mm" id="radio-option-a" checked="checked" />
										<form:radiobutton path="trm" label="분기" value="quarter" id="radio-option-b" />
									</div>
								</div>
								<div class="input-group-cell">
									<div class="input-group">
										<form:select path="year" cssClass="form-control input-sm" title="년도">

											<c:forEach var="yearVo" items="${yearCdList }">
												<form:option value="${yearVo.cd}">
													<c:out value="${yearVo.cdNm }" />
												</form:option>
											</c:forEach>
										</form:select>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
			<!-- /box-body -->
			<div class="box-footer collapse in search-collapse">
				<div class="pull-left">
					<button type="reset" class="btn">초기화</button>
				</div>
				<div class="pull-right">
					<button type="submit" class="btn btn-red ">조회</button>
				</div>
			</div>
			<!-- /box-footer -->
		</div>
		<!-- /box(검색조건) -->
	</form:form>
</div>
<!-- /col -->

<div class="col-box-100 search-col">
	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">
				클라우드 요청 처리 현황 목록
				<!-- <small>1 / 1, 총 1건</small>-->
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<div class="input-group-cell pad-right">
						<button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_excelDown()">
							<i class="fa fa-download"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
		<div class="box-body no-padding list-body">
			<table class="table table-vertical table-hover" id="tableCludReqPrcss">
				<caption>클라우드 요청 처리 현황</caption>
				<thead>
					<tr>
						<th>구분</th>
						<th>계</th>
						<th>가상서버 생성</th>
						<th>가상서버 삭제</th>
						<th>스펙변경</th>
						<th>SAN 추가</th>
						<th>SAN 회수</th>
					</tr>

				</thead>
				<tbody>
					<c:choose>
						<c:when test="${ list eq null or empty list }">
							<c:choose>
								<c:when test="${searchVo.search eq null or empty searchVo.search }">
									<tr>
										<td colspan="7">조회 버튼을 클릭해 주시기 바랍니다.</td>
									</tr>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="7">검색된 데이터가 없습니다.</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise>
							<c:forEach var="vo" items="${list}" varStatus="ri">
								<tr>
									<td class="alignL"><a href="" onclick="fn_dtlView('<c:out value="${vo.ym }" />');return false;"><c:out value="${vo.ymNm }" /></a></td>
									<td class="alignR"><fmt:formatNumber value="${vo.tot}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.vmCreateQty}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.vmRemoveQty}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.specUpdateQty}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.sanAddQty}" pattern="#,###" /></td>
									<td class="alignR"><fmt:formatNumber value="${vo.withdrawQty}" pattern="#,###" /></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>

				</tbody>
			</table>
		</div>
		<!-- /box-body -->
		<div class="box-footer edit-btn-group">

			<div class="pull-left btns"></div>
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="goPage" />
			</ul>
			<div class="pull-right btns">
				<menu:authorize>
					<c:url var="insertUrl" value="insertCludReqPrcssStteView.do">
					</c:url>
					<button class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="추가" onclick="fn_goToUrl('${insertUrl}')">
						<i class="fa fa-plus"></i>
					</button>
				</menu:authorize>
			</div>
		</div>
	</div>
	<!-- /box -->
</div>
<!-- /col -->

<script type="text/javascript">
	$(document).ready(function() {

		$('#regionAll').click(function() {

			$('.region').prop('checked', $(this).is(":checked"));
		});
		<c:if test="${searchVo.search eq null or empty searchVo.search }">
		$('#regionAll').trigger('click');
		</c:if>
		$('.region').click(function() {
			if ($('.region:checked').length == $('.region').length) {
				$('#regionAll').prop('checked', true);
			} else {
				$('#regionAll').prop('checked', false);
			}
		});

		var autoColumns = [ {
			sWidth : "50px"
		}, {
			sWidth : "80px"
		}, {
			sWidth : "100px"
		}, {
			sWidth : "130px"
		}, {
			sWidth : "160px"
		}, {
			sWidth : "60px"
		}, {
			sWidth : "60px"
		}, ];
		<c:choose>
		<c:when test="${not empty searchVo.search }">

		//fn_dataTable("",0,autoColumns)//테이블 정렬및 resize

		$("#tableCludReqPrcss").DataTable({
			dom : 'Zlfrtip',
			paging : false,
			searching : false,
			info : false,
			bAutoWidth : false,
			aoColumns : autoColumns,
			order : [ [ 0, "asc" ] ]
		});

		</c:when>
		</c:choose>

	});

	function fn_search() {
		if (!fn_form_validation("searchVo")) {
			return;
		}

		searchVo.action = '<c:url value="selectCludReqPrcssStteList.do" />';
		searchVo.submit();
	}

	function fn_excelDown() {
		<c:if test='${empty list}'>
		jAlert("엑셀로 다운로드할 데이터가 없습니다.");
		return;
		</c:if>
		searchVo.action = '<c:url value="selectCludReqPrcssStteListXlsDown.do" />';
		searchVo.submit();
	}
	function fn_dtlView(ym) {
		var trm = "${searchVo.trm}";
		var year = "${searchVo.year}";
		$('#year').val(year);
		$('#ym').val(ym);
		$('[name=trm').each(function() {
			if (this.value == trm) {
				this.checked = true;
			}
		});

		var regions = [];
		<c:forEach var="region" items="${searchVo.region }">
		regions.push('${region}')
		</c:forEach>
		$('[name=region').each(function() {
			for (var i = 0; i <= regions.length; i++) {
				if (this.value == regions[i]) {
					this.checked = true;
				}
			}
		});

		searchVo.action = '<c:url value="selectCludReqPrcssStteDtl.do" />';
		searchVo.submit();
	}
	function fn_goToUrl(url) {
		searchVo.action = url;
		searchVo.submit();
	}
</script>
