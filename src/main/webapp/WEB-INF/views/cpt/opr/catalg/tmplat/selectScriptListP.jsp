<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 09. 30.
 * @lastmodified 2016. 09. 30.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 09. 30.     이화영         v1.0             최초생성
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
	<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage"/>
	<div class="box-search">
		<div class="box-body">
			<div class="form-group">
				<div class="form-cell form-cell-50">
					<div class="cell-title"><label for="searchOSVer" title="OS버전">OS버전</label></div>
                    <div class="cell-body">
                    	<form:input type="text" path="searchOSVer" class="form-control input-sm pull-right" maxlength="16" title="OS버전" />
                    	<form:hidden path="searchOSType" />
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
	  		</div><!-- /box-header -->
		</div><!-- /box-header -->

		<!-- box-body -->
		<div class="box-body no-padding">
			<form action="scriptFrm" id="scriptFrm">
			<table class="table table-hover table-vertical table-layout-fixed"  id="noticeTable">
			<caption>스태틱라우팅스크립트 목록</caption>
				  <col class="col5">
				  <col class="col8">
                  <col class="col10">
                  <col class="col10">
                  <col class="colAuto">
                  <col class="col10">
				<thead>
				<tr>
					<th></th>
					<th>사용여부</th>
					<th>OS유형</th>
					<th>OS버전</th>
					<th>스크립트</th>
					<th>등록일자</th>
				</tr>
				</thead>

				<tbody>
					<c:choose>
						<c:when test="${list eq null or empty list }">
							<tr><td colspan="6">검색된 데이터가 없습니다.</td></tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="vo" items="${list }" varStatus="i">
								<tr>
									<td>
										<input type="radio" name="scriptSeq" value="${vo.sRoutingScriptSeq }" />
										<input type="hidden" name="osTyCd" value="<c:out value="${vo.osTyCd}" />" />
										<input type="hidden" name="osVer" value="<c:out value="${vo.osVer}" />" />
										<input type="hidden" name="script" value="<c:out value="${vo.script}" />" />
									</td>
									<td>
										<c:choose>
											<c:when test = "${ vo.useYn eq 'Y' }">
												<span class="status status-green">사용</span>
											</c:when>
											<c:otherwise>
												<span class="status status-gray">미사용</span>
											</c:otherwise>
										</c:choose>
									</td>
									<td><c:out value="${vo.osTyNm}"/></td>
									<td class="alignL"><c:out value="${vo.osVer}" /></td>
									<td class="alignL"><c:out value="${vo.script}" /></td>
									<td><fmt:formatDate value="${vo.regDttm }" pattern="yyyy-MM-dd" /></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
			</form>
		</div>
		<!-- /box-body -->

		<!-- box-footer -->
		<div class="box-footer">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="goPage" />
			</ul>
		</div>
		<!-- /box-footer -->
	</div>
</div>
<div class="col-box-100">
	<div class="button">
		<button type="button" class="btn btn-dark" onclick="fn_selectScript()">선택</button>
		<button type="button" class="btn close-window" onclick="fn_close()">닫기</button>
	</div>
</div>

<script type="text/javascript" src="<c:url value="/resources/js/common/component/entity.js" />"></script>
<script type="text/javascript">
function goPage(page){
	location.href = "selectScriptListP.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}

function fn_selectScript(){

	if( $("input:radio[name='scriptSeq']:checked").size() == 0 ) {
		jAlert("적용할 스크립트를 선택하여 주시기 바랍니다.");
		return;
	}

	var data = null;
	$("input:radio[name='scriptSeq']").each(function(index) {
		if( $(this).prop("checked") ) {
			data = new EntityRoutingScript();
			data.sRoutingScriptSeq = $(this).val();
			data.osTyCd = $("input:hidden[name='osTyCd']:eq(" + index + ")").val();
			data.osVer = $("input:hidden[name='osVer']:eq(" + index + ")").val();
			data.script = $("input:hidden[name='script']:eq(" + index + ")").val();
		}
	});

	console.log( data );
	var evt = jQuery.Event('selectRoutingScript', {
		"datas" : data
    });

    var _parent = window.opener;
    _parent.jQuery(_parent.document).trigger(evt);
    window.close();
}

$("#scriptFrm input[name='scriptSeq']").parent().parent().click(function() {
	var $target = $(this).find("input[name='scriptSeq']");
	$target.prop("checked", true);
});
</script>