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

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<div class="col-box-100">
	<form:form commandName="searchVo" method="get">
	<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />
	<form:hidden path="searchType"/>
	<div class="box-search">
		<div class="box-body">
			<div class="form-group">
				<div class="form-cell form-cell-50">
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
				<div class="form-cell form-cell-50">
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
				<div class="form-cell form-cell-50">
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
				<div class="form-cell form-cell-50">
					<div class="cell-title">
						<label for="searchPoolNm">자원풀</label>
					</div>
					<div class="cell-body">
						<form:input path="searchPoolNm" cssClass="form-control input-sm" title="자원풀"/>
					</div>
				</div>
				<div class="form-cell form-cell-100 alignR pad-top-5">
					<button class="btn btn-red btn-sm" type="submit">조회</button>
				</div>
			</div>
		</div>
	</div>
	</form:form>

	<div class="box">
		<!-- box-header -->
		<div class="box-header">
			<h3 class="box-title">
				검색결과<small> ${searchVo.paginationInfo.currentPageNo }
					/ ${searchVo.paginationInfo.totalPageCount }, 총
					${searchVo.paginationInfo.totalRecordCount }건 </small>
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo }" />
				</div>
			</div>
		</div>
		<!-- /box-header -->
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
						<c:if test="${searchVo.searchType eq 'M' }">
							<input type="checkbox" id="chkPoolAll" title="자원풀 전체 선택" onclick="doCheckAll(this, 'rsrcPoolId')" />
						</c:if>
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
										<c:choose>
											<c:when test="${searchVo.searchType eq 'M' }">
												<input type="checkbox" name="rsrcPoolId" class="rsrcPoolId" value="${vo.rsrcPoolId }" title="자원풀ID ${vo.rsrcPoolId }"/>
											</c:when>
											<c:otherwise>
												<input type="radio" name="rsrcPoolId" value="${vo.rsrcPoolId }" title="자원풀ID ${vo.rsrcPoolId }"/>
											</c:otherwise>
										</c:choose>
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

		<!-- box-footer -->
		<div class="box-footer">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="goPage" />
			</ul> <!--
			<div class="btns pull-right">
				<c:choose>
					<c:when test="${searchVo.searchType eq 'M' }">
						<button type="button" class="btn btn-default" onclick="selectPoolM()">선택</button>
					</c:when>
					<c:otherwise>
						<button type="button" class="btn btn-default" onclick="selectPoolS()">선택</button>
					</c:otherwise>
				</c:choose>
			</div> -->
		<!-- /box-footer -->
		</div>
	</div>
</div>
<div class="col-box-100">
	<div class="button">
		<c:choose>
			<c:when test="${searchVo.searchType eq 'M' }">
				<button type="button" class="btn btn-default" onclick="selectPoolM()">선택</button>
			</c:when>
			<c:otherwise>
				<button type="button" class="btn btn-default" onclick="selectPoolS()">선택</button>
			</c:otherwise>
		</c:choose>
		<button type="button" class="btn close-window" onclick="fn_close()">닫기</button>
	</div>
</div>
<script type="text/javascript" src="<c:url value="/resources/js/common/component/entity.js" />"></script>
<script type="text/javascript">

function doCheckAll(obj, clazz) {
	$("." + clazz).prop("checked", $(obj).prop("checked"));
}

function goPage(page){
	location.href = "selectPoolListP.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
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

function selectPoolS(){

	if( $("input:radio[name='rsrcPoolId']:checked").size() == 0 ) {
		jAlert("자원풀을 선택하여 주시기 바랍니다.");
		return;
	}

	var data = null;
	$("input:radio[name='rsrcPoolId']").each(function(index) {
		if( $(this).prop("checked") ) {
			data = new EntityPool();
			data.rsrcPoolId = $(this).val();
			data.rsrcPoolNm = $("input:hidden[name='rsrcPoolNm']:eq(" + index + ")").val();
			data.regionId = $("input:hidden[name='regionId']:eq(" + index + ")").val();
			data.regionNm = $("input:hidden[name='regionNm']:eq(" + index + ")").val();
			data.zoneNm = $("input:hidden[name='zoneNm']:eq(" + index + ")").val();
			data.netNm = $("input:hidden[name='netNm']:eq(" + index + ")").val();
		}
	});

	var evt = jQuery.Event('selectPool', {
		"procType" : "<c:out value="${searchVo.searchType}" />",
		"datas" : data
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
</script>