<!--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 정승용
 * @lastmodifier 정승용
 * @created 2016. 10. 18.
 * @lastmodified 2016. 10. 18.
 *
 * @history
 * -----------------------------------------------------------
 * 		Date         author      ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 18.      정승용          v1.0              기능개발
 *
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<div class="col-box-100 search-col">
	<form:form commandName="searchVo" method="GET" onsubmit="return fn_selectMngr();">
		<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage"/>
		<div class="box box-search">
			<div class="box-header">
				<h3 class="box-title">검색조건</h3>
				<div class="box-tools pull-right">
					<button type="button" class="btn btn-sm" data-toggle="collapse" data-target=".search-collapse"><i class="fa fa-chevron-up" data-toggle="tooltip" title="접어두기"></i>
					</button>
				</div>
			</div>
			<!-- /box-header -->

			<!-- box-body -->
			<div class="box-body collapse in search-collapse">
				<div class="form-group">
					<!-- form-cell : 검색조건박스에서 사용되는 검색요소 컴포넌트 단위입니다. -->
					<!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchRegionId">센터</label>
						</div>
						<div class="cell-body">
							<nform:selectRegion
								name="searchRegionId"
								id="searchRegionId"
								title="센터"
								cssClass="form-control input-sm"
								value="${searchVo.searchRegionId}"
								whole="true"
								byRole="false"
								onchange="selectZoneDy(this, 'searchZoneId' , {'byRole' : false} )" />
						</div>
					</div>

					<!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchZoneId">존</label>
						</div>
						<div class="cell-body">
							<nform:selectZone
								name="searchZoneId"
								id="searchZoneId"
								title="Zone"
								cssClass="form-control input-sm"
								whole="true"
								byRole="false"
								regionId="${searchVo.searchRegionId}"
								value="${searchVo.searchZoneId}"
								onchange="selectNetDy(this, 'searchNetId', {'byRole' : false} )" />
						</div>
					</div>

					<!-- form-cell : 검색조건박스에서 사용되는 검색요소 컴포넌트 단위입니다. -->
					<!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchNetId">망</label>
						</div>
						<div class="cell-body">
							<nform:selectNet
								name="searchNetId"
								id="searchNetId"
								title="망"
								cssClass="form-control input-sm"
								whole="true"
								byRole="false"
								zoneId="${searchVo.searchZoneId}"
								value="${searchVo.searchNetId}"/>
						</div>
					</div>

					<!-- form-cell : 검색조건박스에서 사용되는 검색요소 컴포넌트 단위입니다. -->
					<!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchStackClCd">스택 분류</label>
						</div>
						<div class="cell-body">
							<nform:selectCode parentCd="201" parentGrpCd="039"
								name="searchStackClCd" id="searchStackClCd" whole="true"
								value="${searchVo.searchStackClCd}"
								cssClass="form-control input-sm"
								onchange="selectboxDy('039', this,'searchMngrClCd',true)" />
						</div>
					</div>

					<!-- form-cell : 검색조건박스에서 사용되는 검색요소 컴포넌트 단위입니다. -->
					<!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchMngrClCd">매니저 분류</label>
						</div>
						<div class="cell-body">
							<nform:selectCode parentCd="${searchVo.searchStackClCd}"
								parentGrpCd="039" name="searchMngrClCd" id="searchMngrClCd"
								whole="true" title="매니저 분류" value="${searchVo.searchMngrClCd}"
								cssClass="form-control input-sm"
								onchange="selectboxDy('039', this,'searchNowVerCd',true)" />
						</div>
					</div>

					<!-- form-cell : 검색조건박스에서 사용되는 검색요소 컴포넌트 단위입니다. -->
					<!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchNowVerCd">매니저 버전</label>
						</div>
						<div class="cell-body">
							<nform:selectCode parentCd="${searchVo.searchMngrClCd}"
								parentGrpCd="039" name="searchNowVerCd" id="searchNowVerCd"
								whole="true" title="매니저 버전" value="${searchVo.searchNowVerCd}"
								cssClass="form-control input-sm" />
						</div>
					</div>

					<!-- form-cell : 검색조건박스에서 사용되는 검색요소 컴포넌트 단위입니다. -->
					<!-- col-lay : 브라우저 사이즈가 1200px 이상시에만 해당 가로사이즈(%)를 유지합니다. -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchMngrNm">매니저 명</label>
						</div>
						<div class="cell-body">
							<form:input path="searchMngrNm" type="text" class="form-control input-sm" placeholder="검색어 입력"/>
						</div>
					</div>
				</div>
			</div>

			<div class="box-footer collapse in search-collapse">
				<div class="pull-left">
					<button type="button" class="btn" onclick="fn_reset();">초기화</button>
				</div>
				<div class="pull-right">
					<button  class="btn btn-red pull-right" >조회</button>
				</div>
			</div><!-- /box-footer -->
		</div><!-- /box(검색조건) -->
	</form:form>
</div><!-- /col -->

<div class="col-box-100 search-col">
	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">검색결과
				<small>
					${searchVo.paginationInfo.currentPageNo } /
					${searchVo.paginationInfo.totalPageCount },
					총 ${searchVo.paginationInfo.totalRecordCount }건
				</small>
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
     				<nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo}"/>
     				<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_downloadExcel();"><i class="fa fa-download"></i></button>
					</div>
				</div>
  			</div><!-- /box-header -->
  		</div>
		<div class="box-body no-padding list-body">
			<form:form commandName="mngrVo" method="get">
			<table class="table table-hover table-vertical table-layout-fixed" id="mngrListTable">
			<caption>매니저관리목록</caption>
				<thead>
					<tr>
						<th><input type="checkbox" id="selectAll" title="전체선택"></th>
						<th>No.</th>
						<th>센터</th>
						<th>존</th>
						<th>망</th>
						<th>스택 분류</th>
						<th>매니저 분류</th>
						<th>현재버전</th>
						<th>매니저 명</th>
						<th>등록자</th>
						<th>등록일자</th>
						<th>접속상태</th>
						<th>수집여부</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="mngrVo" items="${list}" varStatus="i">
						<c:url var="detailUrl" value="selectMngr.do">
							<c:forEach var="curParam" items="${param}">
								<c:param name="${curParam.key}" value="${curParam.value}"></c:param>
							</c:forEach>
							<c:param name="stackMngrId" value="${mngrVo._id}" />
						</c:url>
						<tr>
							<td>
								<input type="checkbox" name="delKey" class="delKey" value="${mngrVo._id}" onclick="fn_deleteCheck(this)" title="항목선택"/>
							    <input type="checkbox" name="delRev" class="delRev"	value="${mngrVo._rev}" style="display: none" title="항목선택"/></td>
							<td>
								<c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" />
							</td>
							<td><c:out value="${mngrVo.regionNm}" /></td>
							<td><c:out value="${mngrVo.zoneNm}" /></td>
							<td><c:out value="${mngrVo.netNm}" /></td>
							<td><c:out value="${mngrVo.stackClNm}" /></td>
							<td><c:out value="${mngrVo.mngrClNm}" /></td>
							<td><c:out value="${mngrVo.nowVerNm}" /></td>
							<td class="alignL">
								<a href="<c:url value="${detailUrl}" />" title="<c:out value="${mngrVo.dc}"/>"><c:out value="${mngrVo.mngrNm}" /></a>
							</td>
							<td><c:out value="${mngrVo.regUserNm}" /></td>
							<td><c:out value="${mngrVo.regDt}" /></td>
							<td>
								<input type="hidden" name="rowId" value="${i.count}" />
								<input type="hidden" name="regionId_${i.count}" value="${mngrVo.regionId}" />
								<input type="hidden" name="zoneId_${i.count}" value="${mngrVo.zoneId}" />
								<input type="hidden" name="netId_${i.count}" value="${mngrVo.netId}" />
								<input type="hidden" name="mngrId_${i.count}" value="${mngrVo._id}" />
								<span class="status status-blue" id="span_${i.count}">확인중(Check)</span>
							</td>
							<td><c:out value="${mngrVo.monitoringYN}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</form:form>
		</div>
		<!-- /box-body -->

		<!-- box-footer -->
		<div class="box-footer edit-btn-group">
            <ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo}" type="common" jsFunction="fn_goPage" />
			</ul>
			<div class="pull-right btns">
				<menu:authorize>
					<c:url var="insertUrl" value="insertMngr.do">
						<c:forEach var="curParam" items="${param}">
							<c:param name="${curParam.key}" value="${curParam.value}"></c:param>
						</c:forEach>
					</c:url>
					<button type="button" class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="추가" onclick="goToUrl('${insertUrl}')"><i class="fa fa-plus"></i></button>
					<button type="button" class="btn btn-hover-red" data-toggle="tooltip" data-original-title="삭제" onclick="jConfirm('매니저정보를 삭제하시겠습니까?', fn_deleteMngr)"><i class="fa fa-minus"></i></button>
				</menu:authorize>
			</div>
		</div>
		<!-- /box-footer -->
	</div>
</div>

<script type="text/javascript">
function checkHealth() {
	$("input:hidden[name='rowId']").each(function() {
		var rowId = $(this).val();
		var regionId = $("input:hidden[name='regionId_"+rowId+"']").val();
		var zoneId = $("input:hidden[name='zoneId_"+rowId+"']").val();
		var netId = $("input:hidden[name='netId_"+rowId+"']").val();
		var mngrId = $("input:hidden[name='mngrId_"+rowId+"']").val();

		$.get("selectMngrHealthCheck.do", {"rowId" : rowId, "regionId" : regionId, "zoneId" : zoneId, "netId" : netId, "mngrId" : mngrId}, function(result) {
			var data = result.data;
			var $spanObj = $("#span_" + data._id);
			$spanObj.removeClass("status-gray status-green status-red status-blue");
			if (null == data.status) {
				$spanObj.addClass("status-red");
				$spanObj.html("오류(ERROR)");
			} else {
				if ("up" == data.status) {
					$spanObj.addClass("status-green");
					$spanObj.html("업(ON)");
				} else if ("down" == data.status) {
					$spanObj.addClass("status-gray");
					$spanObj.html("다운(OFF)");
				} else {
					$spanObj.addClass("status-red");
					$spanObj.html("오류(ERROR)");
				}
			}
		});
	});
}
checkHealth();

//체크박스 설정
$(document).ready(function(){
	$('#selectAll').click(function(){
		$('.delKey').prop('checked', $(this).is(":checked"));
		fn_deleteCheck($('.delKey'));
	});

	$('.delKey').click(function(){
		if($('.delKey:checked').length == $('.delKey').length){
			$('#selectAll').prop('checked', true);
		}
		else {
			$('#selectAll').prop('checked', false);
		}
	});
});

//조회버튼 클릭시.
function fn_selectMngr() {
	$.ncmsLoding.startFullScreen();
}

//페이징 이동
function fn_goPage(page){
	location.href = "selectMngrList.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}

//key 체크박스가 클릭되면 rev 체크박스도 같이 선택되게 함
function fn_deleteCheck(obj) {
	$("input:checkbox[name='delKey']").each(function(idx) {
		if( $(this).prop("checked") ) {
			$("input:checkbox[name='delRev']:eq(" + idx + ")").prop("checked",true);
		} else {
			$("input:checkbox[name='delRev']:eq(" + idx + ")").prop("checked",false);
		}
	});
}

//초기화 버튼 클릭 시
function fn_reset() {
	$("#searchVo input[type='text']").val("");
	$("#searchVo select").val("").attr("selected","selected");
}

//선택openApi 삭제
function fn_deleteMngr(){
	var checked = 0;
	$("input[name='delKey']").each(function() {
		if( $(this).prop("checked") ) {
			checked++;
		}
	});

	if( checked == 0 ) {
		parent.jAlert("삭제대상을 선택하시기 바랍니다.");
		return;
	}

	$.ncmsLoding.startFullScreen();
	$.post('deleteChkMngr.do', $('#mngrVo').serialize(),
		fn_deleteMngrCallBakc, 'json').always(
			function() { $.ncmsLoding.remove();
		});
}

// 스펙삭제 콜백
function fn_deleteMngrCallBakc(result){
	alert_message(result.messageList, function() {
		if(result.success){
			if(result.procType == "delete") {
				location.href = "selectMngrList.do";
			}
		}
	}, (result.success?"INFO":""));
}

//엑셀 다운로드
function fn_downloadExcel() {
	if("${searchVo.paginationInfo.totalRecordCount}" == '0') {
		jAlert("다운로드할 데이터가 없습니다");
		return;
	}

	$("#searchVo").attr("action", "selectMngrListXlsDwnl.do");
	$("#searchVo").submit();
	$.ncmsLoding.remove();
}

//테이블 정렬
$("#mngrListTable").DataTable({
	dom : 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,

	//colgroup 대신 여기에 입력
	aoColumns : [
	   { sWidth : "30px" },
	   { sWidth : "30px" },
	   { sWidth : "30px" },
	   { sWidth : "50px" },
	   { sWidth : "50px" },
	   { sWidth : "70px" },
	   { sWidth : "90px"},
	   { sWidth : "40px" },
	   { sWidth : "150px" },
	   { sWidth : "70px" },
	   { sWidth : "70px" },
	   { sWidth : "100px"},
	   { sWidth : "50px"}
	],
	order : [ [ 0, "desc" ] ]
});
</script>