<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 17.
 * @lastmodified 2016. 10. 17.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 17.     신재훈         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform"%>

<c:set var="listParam"	value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<!-- 검색조건 영역 -->
<div class="col-box-100 search-col">
	<form:form commandName="searchVo" method="get" onsubmit="return checkIpStteList()">
	<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />
	<div class="box box-search">
		<!-- box-header -->
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
		<!-- box-body -->
		<div class="box-body collapse in search-collapse">
		<div class="form-group">
			<!-- 검색조건 : select -->
			<div class="form-cell form-cell-50 col-lay-25">
				<div class="cell-title">
					<label for="ipStatCd" title="상태">상태</label>
				</div>
				<div class="cell-body">
					<form:select path="ipStatCd" cssClass="form-control input-sm" title="상태">
						<c:forEach var="cd" items="${ipStatCdList }">
							<form:option value="${cd.cd }"><c:out value="${cd.cdNm}"/></form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>
			<!-- 검색조건 : select -->
			<div class="form-cell form-cell-50 col-lay-25">
				<div class="cell-title">
					<label for="searchRegion" title="센터">센터</label>
				</div>
				<div class="cell-body">
					<nform:selectRegion name="searchRegion" id="searchRegion" cssClass="form-control input-sm" title="센터" value="${searchVo.searchRegion}" whole="true" />
				</div>
			</div>
			<div class="form-cell form-cell-50 col-lay-25">
				<div class="cell-title">
					<label for="searchNet" title="망구분">망구분</label>
				</div>
				<div class="cell-body">
					<nform:selectCode
						parentCd="NETCD"
						parentGrpCd="067"
						name="searchNet"
						id="searchNet"
						whole="true"
						wholeText="전체"
						extra1=""
						extra2=""
						extra3=""
						extra4=""
						extra5=""
						title="망구분"
						value="${searchVo.searchNet }"
						cssClass="form-control essential" />
				</div>
			</div>
			<div class="form-cell form-cell-50 col-lay-25">
				<div class="cell-title">
					<label for="searchIpBndNm" title="IP대역명">IP 대역명</label>
				</div>
				<div class="cell-body">
					<form:input path="searchIpBndNm" class="form-control input-sm" title="IP대역명"/>
				</div>
			</div>
			<div class="form-cell form-cell-50 col-lay-25">
				<div class="cell-title">
					<label for="searchIpAddr" title="IP주소">IP주소</label>
				</div>
				<div class="cell-body">
					<form:input path="searchIpAddr" class="form-control input-sm onlyIp" title="IP주소"/>
				</div>
			</div>
			<div class="form-cell form-cell-50 col-lay-25">
				<div class="cell-title">
					<label for="searchMacAddr" title="MAC주소">MAC 주소</label>
				</div>
				<div class="cell-body">
					<form:input path="searchMacAddr" class="form-control input-sm" title="MAC주소"/>
				</div>
			</div>
			<div class="form-cell form-cell-50 col-lay-25">
				<div class="cell-title">
					<label for="searchInstitutionNm" title="사용부처">사용부처</label>
				</div>
				<div class="cell-body">
					<form:input path="searchInstitutionNm" class="form-control input-sm" title="사용부처"/>
				</div>
			</div>
			<div class="form-cell form-cell-50 col-lay-25">
				<div class="cell-title">
					<label for="searchVmNm" title="가상서버명">가상서버명</label>
				</div>
				<div class="cell-body">
					<form:input path="searchVmNm" class="form-control input-sm" title="가상서버명"/>
				</div>
			</div>
			<div class="form-cell form-cell-50 col-lay-25">
				<div class="cell-title">
					<label for="searchVmCompId" title="가상서버구성ID">가상서버구성ID</label>
				</div>
				<div class="cell-body">
					<form:input path="searchVmCompId" class="form-control input-sm" title="가상서버구성ID"/>
				</div>
			</div>
			<div class="form-cell form-cell-100 col-lay-50">
				<div class="cell-title">
					<label for="searchStartAsgnDt" title="할당일자">할당일자</label>
				</div>
				<div class="cell-body">
					<div class="input-group period period-start">
						<form:input path="searchStartAsgnDt" cssClass="form-control input-sm datepicker onlyDate"  title="할당 시작일자" onchange="initDate(this, 'searchEndAsgnDt', 'S')" />
					</div>
					<div class="input-group period period-end">
						<form:input path="searchEndAsgnDt" cssClass="form-control input-sm datepicker onlyDate" title="할당 종료일자" onchange="initDate(this, 'searchStartAsgnDt', 'E')" />
					</div>
				</div>
			</div>
			<div class="form-cell form-cell-100 col-lay-50">
				<div class="cell-title">
					<label for="searchStartWithdrawDt" title="회수일자">회수일자</label>
				</div>
				<div class="cell-body">
					<div class="input-group period period-start">
						<form:input path="searchStartWithdrawDt" cssClass="form-control input-sm datepicker onlyDate" title="할당 시작일자" onchange="initDate(this, 'searchEndWithdrawDt', 'S')" />
					</div>
					<div class="input-group period period-end">
						<form:input path="searchEndWithdrawDt" cssClass="form-control input-sm datepicker onlyDate" title="할당 종료일자" onchange="initDate(this, 'searchStartWithdrawDt', 'E')" />
					</div>
				</div>
			</div>
		</div>
		<!-- /box-body -->
		<!-- box-footer -->
		<div class="box-footer collapse in search-collapse">
			<div class="pull-left">
				<button type="button" class="btn" onclick="searchInit()" title="초기화">초기화</button>
			</div>
			<div class="pull-right">
				<button type="button" class="btn btn-red pull-right"  onclick="searchIpStteList()" title="조회">조회</button>
			</div>
		</div>
		<!-- /box-footer -->
		</div>
	</div>
	</form:form>
</div>

<!-- 그리드 영역 -->
<div class="col-box-100 search-col">
	<div class="box list-box">
		<!-- box-header -->
		<div class="box-header">
			<h3 class="box-title">
				검색결과<small> ${searchVo.paginationInfo.currentPageNo }
					/ ${searchVo.paginationInfo.totalPageCount }, 총
					${searchVo.paginationInfo.totalRecordCount }건 </small>
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo}" />
					<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-function" onclick="fn_selctIpStteListXlsDwnl();" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" data-placement="left">
							<i class="fa fa-download"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
		<!-- /box-header -->
		<!-- box-body -->
		<form id="ipStteListFrm" name="ipStteListFrm" method="post">
			<div class="box-body no-padding list-body">
				<table class="table table-hover table-vertical  table-layout-fixed" id="ipStteTable">
				<caption>IP현황목록 (상태, IP주소, 가상서버구성ID, 센터, 망구분, 사용부처, IP대역명, MAC주소, 가상서버명, 할당일자, 회수일자)</caption>
					<thead>
						<tr>
							<th>No</th>
							<th>상태</th>
							<th>IP주소</th>
							<th>가상서버구성ID</th>
							<th>센터</th>
							<th>망구분</th>
							<th>사용부처</th>
							<th>IP대역명</th>
							<th>MAC주소</th>
							<th>가상서버명</th>
							<th>할당일자</th>
							<th>회수일자</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="ipVo" items="${list }" varStatus="i">
						<tr>
							<td><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td>
							<td>
								<nobr>
									<c:choose>
										<c:when test="${ipVo.ipStatCd eq '01'}">
											<span title="할당" class="status status-green">할당</span>
										</c:when>
										<c:when test="${ipVo.ipStatCd eq '02'}">
											<span title="미할당" class="status status-gray">미할당</span>
										</c:when>
										<c:when test="${ipVo.ipStatCd eq '03'}">
											<span title="Block" class="status status-red">Block</span>
										</c:when>
									</c:choose>
								</nobr>
							</td>
							<td class="alignL"><c:out value="${ipVo.ipAddr }" /></td>
							<td class="alignL"><c:out value="${ipVo.vmCompId }" /></td>
							<td class="alignL"><c:out value="${ipVo.regionNm }" /></td>
							<td class="alignL"><c:out value="${ipVo.netNm }" /></td>
							<td class="alignL"><c:out value="${ipVo.institutionNm }" /></td>
							<td class="alignL"><c:out value="${ipVo.ipBndNm }" /></td>
							<td class="alignL"><c:out value="${ipVo.macAddr }" /></td>
							<td class="alignL"><c:out value="${ipVo.vmNm }" /></td>
							<td><fmt:formatDate value="${ipVo.asgnDt }" pattern="yyyy-MM-dd" /></td>
							<td><fmt:formatDate value="${ipVo.withdrawDt }" pattern="yyyy-MM-dd" /></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</form>
		<!-- /box-body -->
		<!-- box-footer -->
		<div class="box-footer edit-btn-group">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }"	type="common" jsFunction="fn_goPage" />
			</ul>
			<c:url var="listUrl" value="selectIpStteList.do">
				<c:forEach var="curParam" items="${param }">
					<c:if test="${curParam.key ne 'ipAddr'}">
						<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
					</c:if>
				</c:forEach>
			</c:url>
		</div>
		<!-- /box-footer -->
	</div>
</div>

<script type="text/javascript">

function fn_goPage(page) {
	location.href = "selectIpStteList.do?paginationInfo.currentPageNo="+ page + "&${listParam}";
}

// 초기화
function searchInit(){
	$('#searchVo input[type="text"]').val('');
	$('#searchVo select').val('').attr('selected', 'selected');
}

//formValidate Check
function checkIpStteList(){
	// IP 형식 체크
	// 마지막 문자가 숫자가 아닐 경우 오류 체크
	var searchIpAddr = $('#searchVo input[name="searchIpAddr"]').val();
	var searchIpAddrLength = $('#searchVo input[name="searchIpAddr"]').val().length;
	var searchMacAddr = $('#searchVo input[name="searchMacAddr"]').val();
	var searchStartAsgnDt = $('#searchVo input[name="searchStartAsgnDt"]').val();
	var searchEndAsgnDt = $('#searchVo input[name="searchEndAsgnDt"]').val();
	var searchStartWithdrawDt = $('#searchVo input[name="searchStartWithdrawDt"]').val();
	var searchEndWithdrawDt = $('#searchVo input[name="searchEndWithdrawDt"]').val();

	var pattern = /[\u3131-\u314e|\u314f-\u3163|\uac00-\ud7a3]/g; // 한글체크
	var date_pattern = /^\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/;

	if(pattern.test(searchIpAddr) || pattern.test(searchMacAddr) || pattern.test(searchStartAsgnDt) || pattern.test(searchEndAsgnDt) || pattern.test(searchStartWithdrawDt) || pattern.test(searchEndWithdrawDt) ){
		jAlert("검색조건중 IP주소, MAC주소, 할당일자, 회수일자에는 한글이 입력될 수 없습니다.");
		return false;
	}
	else if( (searchStartAsgnDt != "" && !date_pattern.test(searchStartAsgnDt)) || (searchEndAsgnDt != "" && !date_pattern.test(searchEndAsgnDt)) || (searchStartWithdrawDt != "" && !date_pattern.test(searchStartWithdrawDt)) || (searchEndWithdrawDt != "" && !date_pattern.test(searchEndWithdrawDt))  ){
		jAlert("날짜 형식을 YYYY-MM-DD 형식으로 입력하세요.");
		return false;
	}
	else {
		var parts = searchIpAddr.split(".");
		if(parts.length != 4){
			if(parts.length > 4){
				jAlert("입력하신 IP주소의 형식이 올바르지 않습니다.", function() {
					$('#searchVo input[name="searchIpAddr"]').focus();
				});
				return false;
			}

			if(searchIpAddr.charAt(searchIpAddrLength-1) == "."){
				jAlert("입력하신 IP주소의 형식이 올바르지 않습니다.", function() {
					$('#searchVo input[name="searchIpAddr"]').focus();
				});
				return false;
			}
			else {
				return true;
			}
		}
		else {
			// 192.168.1.0 일 경우에 searchIpAddr을 192.168.1로 전달하도록 할 것
			var convertIp = "";
			if(parseInt(parseFloat(parts[3])) == 0){
				convertIp = parts[0] + "." + parts[1] + "." + parts[2];
				$('#searchVo input[name="searchIpAddr"]').val(convertIp);
			}
		}
	}
}

// 조회
function searchIpStteList(){
	$('#searchVo').attr('action', '<c:url var="select" value="selectIpStteList.do"/>');
	$('#searchVo').submit();
}

// 엑셀다운로드
function fn_selctIpStteListXlsDwnl(){
	if ("${searchVo.paginationInfo.totalRecordCount}" == '0') {
		jAlert("다운로드 할 데이터가 없습니다");
		return;
	}

	$("#searchVo").attr("action", "selectIPListXlsDwnl.do");
	$("#searchVo").submit();
}

$("#ipStteTable").DataTable({
	dom : 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
				   {sWidth : "35px" },
	               {sWidth : "49px" },
	               {sWidth : "84px" },
	               {sWidth : "101px" },
	               {sWidth : "35px" },
	               {sWidth : "57px" },
	               {sWidth : "100px" },
	               {sWidth : "125px" },
	               {sWidth : "105px" },
	               {sWidth : "115px" },
	               {sWidth : "84px" },
	               {sWidth : "84px" }
	],
	order : [ [ 0, "desc" ] ],
	columnDefs:[{type:'ip-address', targets:[2]}]
});
</script>