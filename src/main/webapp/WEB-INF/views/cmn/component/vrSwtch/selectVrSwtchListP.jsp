<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 8.
 * @lastmodified 2016. 10. 8.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 8.     신재훈         v1.0             최초생성
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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>
<script type="text/javascript" src="<c:url value="/resources/js/common/component/entity.js" />"></script>

<div class="col-box-100">
	<!-- 검색조건 영역 -->
	<div class="box-search">
		<form:form commandName="searchVo" method="get">
		<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />
		<form:hidden path="netClCd" value="${ipBndVo.netClCd }" />
		<form:hidden path="regionId" value="${ipBndVo.regionId }" />
			<!-- box-header -->
			<div class="box-body">
				<div class="form-group">
					<!-- 검색조건 : select -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchRegionId">센터</label>
						</div>
						<div class="cell-body">
							<nform:selectRegion	name="searchRegionId" id="searchRegionId" cssClass="form-control input-sm" title="센터" value="${searchVo.searchRegionId}" />
						</div>
					</div>

					<!-- 검색조건 : select -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="searchNetClCd">망구분</label>
						</div>
						<div class="cell-body">
							<form:select path="searchNetClCd" cssClass="form-control input-sm" title="망">
							<c:forEach var="netCd" items="${netList}">
								<c:choose>
									<c:when test="${netCd.cd eq searchVo.searchNetClCd}">
										<form:option value="${netCd.cd}" selected="selected"><c:out value="${netCd.cdNm}"></c:out></form:option>
									</c:when>
									<c:otherwise>
										<form:option value="${netCd.cd}"><c:out value="${netCd.cdNm}"></c:out></form:option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							</form:select>
						</div>
					</div>

					<!-- 검색조건 : select -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label title="자원풀" for="rsrcPoolId">자원풀</label>
						</div>
						<div class="cell-body">
							<nform:selectPool
						          name="rsrcPoolId"
						          id="rsrcPoolId"
						          title="자원풀"
						          wholeText="전체"
						          poolTypeCd="01"
						          cssClass="form-control input-sm"
						          swTypeCd="COM"
						          regionId="${searchVo.searchRegionId }"
						          zoneId="%"
						          netClCd="${searchVo.searchNetClCd }"
						          value="${searchVo.rsrcPoolId}"
						          ctlTrgtYn=""/>
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label title="네트워크명" for="netwkNm">네트워크명</label>
						</div>
						<div class="cell-body">
							<form:input path="netwkNm" title="네트워크명" />
						</div>
					</div>

					<div class="form-cell form-cell-100 col-lay-100">
						<div class="cell-title">
							<label for="searchVrlzSwTyCdList">가상화SW</label>
						</div>
						<div class="cell-body">
							<div class="input-group input-group-check">
							<c:choose>
								<c:when test="${searchVo eq null or searchVo.searchVrlzSwTyCdList eq null }">
									<c:forEach var="vrlzSwTyCd" items="${vrlzSwTyCdList }" varStatus="i">
										<form:checkbox path="searchVrlzSwTyCdList[${i.index }]" title="가상화SW" value="${vrlzSwTyCd.cd}" id="${vrlzSwTyCd.cd}" checked="checked"/>
										<label for="${vrlzSwTyCd.cd}"><c:out value="${vrlzSwTyCd.cdNm}"/></label>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<c:forEach var="vrlzSwTyCd" items="${vrlzSwTyCdList }" varStatus="i">
										<form:checkbox path="searchVrlzSwTyCdList[${i.index }]" title="가상화SW" value="${vrlzSwTyCd.cd}" id="${vrlzSwTyCd.cd}"/>
										<label for="${vrlzSwTyCd.cd}"><c:out value="${vrlzSwTyCd.cdNm}"/></label>
									</c:forEach>
								</c:otherwise>
							</c:choose>
							</div>
						</div>
					</div>
					<!--  검색조건 완료 -->
					<div class="form-cell form-cell-100 alignR pad-top-5">
						<button class="btn btn-red btn-sm" type="button" onclick="fn_selectVrSwtchListP()">조회</button>
					</div>
				</div>
			</div>
		</form:form>
	</div>
	<!-- 테이블 영역 -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">검색결과<small>
				${searchVo.paginationInfo.currentPageNo } /
				${searchVo.paginationInfo.totalPageCount },
				총 ${searchVo.paginationInfo.totalRecordCount }건
			</small></h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo }"/>
				</div>
			</div>
		</div>
		<!-- /box-header -->
		<!-- box-body -->
		<form id="vrSwtchFrm" name="vrSwtchFrm">
		<div class="box-body no-padding">
			<table class="table table-vertical table-hover table-layout-fixed" id="vrSwtchListTable" title="가상스위치목록">
				<caption>가상스위치 목록 테이블(센터, 망구분, 가상화SW, 자원풀, 네트워크명)</caption>
				<thead>
					<tr>
						<th><input type="checkbox" id="vrSwtchAll" title="전체선택"></th>
						<th>센터</th>
						<th>망구분</th>
						<th>가상화SW</th>
						<th>자원풀</th>
						<th>데이터센터</th>
						<th>네트워크명</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vrSwtchVo" items="${vrList }" varStatus="i">
					<tr>
						<td>
							<input type="checkbox" class="checkVrSwtchLists" name="checkVrSwtchLists" value="${vrSwtchVo.vrSwtchSeq }" title="항목선택">
							<input type="hidden" name="regionNm" value="${vrSwtchVo.regionNm }" />
							<input type="hidden" name="netNm" value="${vrSwtchVo.netNm }" />
							<input type="hidden" name="rsrcPoolNm" value="${vrSwtchVo.rsrcPoolNm }"  />
							<input type="hidden" name="dataCntrNm" value="${vrSwtchVo.dataCntrNm }"  />
							<input type="hidden" name="vrlzSwTyCdNm" value="${vrSwtchVo.vrlzSwTyCdNm }" />
							<input type="hidden" name="netwkNm" value="${vrSwtchVo.netwkNm }" />
							<input type="hidden" name="vrSwtchSeq" value="${vrSwtchVo.vrSwtchSeq }" />
						</td>
						<td class="alignC">
							<c:out value="${vrSwtchVo.regionNm }" />
						</td>
						<td class="alignC">
							<c:out value="${vrSwtchVo.netNm }" />
						</td>
						<td class="alignL">
							<c:out value="${vrSwtchVo.vrlzSwTyCdNm }" />
						</td>
						<td class="alignL">
							<c:out value="${vrSwtchVo.rsrcPoolNm }" />
						</td>
						<td class="alignL">
							<c:out value="${vrSwtchVo.dataCntrNm }" />
						</td>
						<td class="alignL">
							<c:out value="${vrSwtchVo.netwkNm }" />
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		</form>
		<!-- /box-body -->
		<!-- box-footer -->
		<div class="box-footer">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="fn_goPage" />
			</ul>
		</div>
		<!-- /box-footer -->
	</div>
<!-- 하위테이블 영역 종료 -->
</div>
<div class="col-box-100">
	<div class="button">
		<button type="button" class="btn btn-dark close-window" onclick="fn_selectVrswtch()">선택</button>
		<button type="button" class="btn close-window" onclick="fn_close()">닫기</button>
	</div>
</div>

<script type="text/javascript">
$(document).ready(function(){
	// 센터, 망 수정불가 상태로 변경
	$("#searchRegionId").attr('disabled', true);
	$("#searchNetClCd").attr('disabled', true);

	$('#vrSwtchAll').click(function(){
		$("input:checkbox[name='checkVrSwtchLists']").prop('checked', $(this).is(":checked"));
	});

	$("#vrSwtchFrm input[name='checkVrSwtchLists']").parent().parent().click(function() {
		if($("input:checkbox[name='checkVrSwtchLists']:checked").length == $("input:checkbox[name='checkVrSwtchLists']").length){
			$('#vrSwtchAll').prop('checked', true);
		}
		else {
			$('#vrSwtchAll').prop('checked', false);
		}
	});
});

function fn_goPage(page) {
	location.href = "selectVrSwtchListP.do?paginationInfo.currentPageNo="+ page + "&${listParam}";
}

// 조회
function fn_selectVrSwtchListP(){
	$('#searchVo').attr('target', '_self');
	$('#searchVo').attr('action', '<c:url var="select" value="selectVrSwtchListP.do"/>');
	$('#searchVo').submit();
}

// 가상스위치 선택 목록 부모에게 전달
function fn_selectVrswtch(){
	var datas = new Array();
	var data = null;
	$("input:checkbox[name='checkVrSwtchLists']").each(function(index) {
		if( $(this).prop("checked") ) {
			data = new EntityVrSwtch();
			data.vrSwtchSeq = $("input:hidden[name='vrSwtchSeq']:eq(" + index + ")").val();
			data.regionNm = $("input:hidden[name='regionNm']:eq(" + index + ")").val();
			data.netNm = $("input:hidden[name='netNm']:eq(" + index + ")").val();
			data.rsrcPoolNm = $("input:hidden[name='rsrcPoolNm']:eq(" + index + ")").val();
			data.dataCntrNm = $("input:hidden[name='dataCntrNm']:eq(" + index + ")").val();
			data.vrlzSwTyCdNm = $("input:hidden[name='vrlzSwTyCdNm']:eq(" + index + ")").val();
			data.netwkNm = $("input:hidden[name='netwkNm']:eq(" + index + ")").val();
			datas.push(data);
		}
	});

	window.opener.setVrSwtchLIst(datas);
	window.close();
}

// 창 닫기
function fn_close(){
	window.close();
}

// 선택한 가상스위치에서 목록 삭제
function fn_up(){
	$('input:checkbox:checked','#selectVrListTable').each(function(){
		$(this).parent().parent().remove();
	});
}

// 선택한 가상스위치로 목록 추가.
function fn_down(){
	if($("input:checkbox[name='vrLists']:checked").size() ==0 ) {
		jAlert("가상스위치를 선택하여 주시기바랍니다.");
		return;
	}

	var html = "";
	$("input:checkbox[name='vrLists']:checked").each(function() {
		html = ""
	});

	$('input:checkbox:checked','#vrListTable').each(function(){
		var id = this.value;
		var isOK=true;
		//debugger;
		$('input:checkbox','#selectVrListTable').each(function(){
			//debugger;
			if(this.value==id){
				isOK=false;
				return false;
			}
		});
		this.checked=false;
		if(isOK){
			$(this).parent().parent().clone().appendTo($('#selectVrListTable tbody'));
		}
	});
}

$("#vrSwtchFrm input[name='checkVrSwtchLists']").click(function(event) {
	event.stopPropagation();
});


$("#vrSwtchFrm input[name='checkVrSwtchLists']").parent().parent().click(function() {
	var $target = $(this).find("input[name='checkVrSwtchLists']");
	if( $target.attr("type") == "checkbox" && $target.prop("checked")) {
		$target.prop("checked", false);
	}
	else {
		$target.prop("checked", true);
	}
});

$("#vrSwtchListTable").DataTable({
	dom : 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
	               {sWidth : "80px" },
	               {sWidth : "100px" },
	               {sWidth : "120px" },
	               {sWidth : "140px" },
	               {sWidth : "240px" },
	               {sWidth : "120px" },
	               {sWidth : "240px" }
	],
	order : [ [ 0, "desc" ] ]
});
</script>