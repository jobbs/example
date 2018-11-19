<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 27.
 * @lastmodified 2016. 10. 27.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 27.     신재훈         v1.0             최초생성
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

<div class="box box-search">
	<form:form commandName="tmplatSearchVo" method="get">
	<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage"/>
	<input type="hidden" name="searchStrgDmnSeq" id="searchStrgDmnSeq" value="${searchVo.searchStrgDmnSeq }" />
	<input type="hidden" name="searchType" id="searchType" value="${searchVo.searchType }" />
	<div class="box-body">
		<div class="form-group">
			<div class="form-cell form-cell-50 col-lay-25">
				<div class="cell-title">
					<label for="useYn" title="사용여부">사용여부</label>
				</div>
				<div class="cell-body">
					<div class="input-group">
						<form:select path="useYn" cssClass="form-control input-sm" title="사용여부">
			              	<c:forEach var="useYnCode" items="${useYnCode}" varStatus="i">
			              		<form:option value="${useYnCode.cd}">${useYnCode.cdNm}</form:option>
			              	</c:forEach>
						</form:select>
					</div>
				</div>
			</div>
			<div class="form-cell form-cell-50 col-lay-25">
				<div class="cell-title">
					<label for="osBit" title="OSBit">OS Bit</label>
				</div>
				<div class="cell-body">
					<form:select path="osBit" cssClass="form-control input-sm" title="OSBit">
						<c:forEach var="osBitCode" items="${osBitCode}" varStatus="i">
							<form:option value="${osBitCode.cd}">${osBitCode.cdNm}</form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>
			<div class="form-cell form-cell-50 col-lay-25">
				<div class="cell-title">
					<label for="tmplatClCd" title="템플릿구분">템플릿구분</label>
				</div>
				<div class="cell-body">
					<form:select path="tmplatClCd" cssClass="form-control input-sm" title="템플릿구분">
						<c:forEach var="tmplatClCdCode" items="${tmplatClCdCode}" varStatus="i">
							<form:option value="${tmplatClCdCode.cd}">${tmplatClCdCode.cdNm}</form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>
			<div class="form-cell form-cell-50 col-lay-25">
				<div class="cell-title">
					<label for="tmplatNm" title="템플릿명">템플릿명</label>
				</div>
				<div class="cell-body">
					<form:input type="text" path="tmplatNm" class="form-control input-sm pull-right" title="템플릿명" />
				</div>
			</div>
			<div class="form-cell form-cell-50 col-lay-25">
				<div class="cell-title">
					<label for="osTyCd" title="OS타입">OS타입</label>
				</div>
				<div class="cell-body">
					<form:select path="osTyCd" cssClass="form-control input-sm" title="OS타입">
						<c:forEach var="osTyCdCode" items="${osTyCdCode}" varStatus="i">
							<form:option value="${osTyCdCode.cd}">${osTyCdCode.cdNm}</form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>
			<div class="form-cell form-cell-50 col-lay-25">
				<div class="cell-title">
					<label for="osNm" title="운영체제">운영체제</label>
				</div>
				<div class="cell-body">
					<form:input type="text" path="osNm" class="form-control input-sm pull-right" title="운영체제"/>
				</div>
			</div>
			<div class="form-cell form-cell-100 col-lay-100">
				<div class="cell-title">
					<label for="vrlzSwTyCdList" title="가상화SW">가상화SW</label>
				</div>
				<div class="cell-body">
					<div class="input-group input-group-check">
						<c:choose>
							<c:when test="${tmplatSearchVo eq null or tmplatSearchVo.vrlzSwTyCdList eq null }">
								<c:forEach var="vrlzSwTyCd" items="${vrlzSwTyCdList }" varStatus="i">
									<form:checkbox path="vrlzSwTyCdList[${i.index }]" title="가상화SW" value="${vrlzSwTyCd.cd}" id="${vrlzSwTyCd.cd}" checked="checked"/>
									<label for="${vrlzSwTyCd.cd}"><c:out value="${vrlzSwTyCd.cdNm}"/></label>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<c:forEach var="vrlzSwTyCd" items="${vrlzSwTyCdList }" varStatus="i">
									<form:checkbox path="vrlzSwTyCdList[${i.index }]" title="가상화SW" value="${vrlzSwTyCd.cd}" id="${vrlzSwTyCd.cd}"/>
									<label for="${vrlzSwTyCd.cd}"><c:out value="${vrlzSwTyCd.cdNm}"/></label>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="box-footer">
		<div class="pull-left">
			<button type="reset" class="btn" onclick="fn_initTmplatComponent('tmplatSearchVo')" title="초기화">초기화</button>
		</div>
		<div class="pull-right">
			<button type="button" class="btn btn-red pull-right" onclick="fn_searchVrStrgTmplatList()" title="조회">조회</button>
		</div>
	</div><!-- /box-footer -->
	</form:form>
</div><!-- /box(검색조건) -->
<div class="box detail-list-box">
	<!-- box-header -->
	<div class="box-header">
		<h3 class="box-title">
			검색결과<small> ${tmplatSearchVo.paginationInfo.currentPageNo }
				/ ${tmplatSearchVo.paginationInfo.totalPageCount }, 총
				${tmplatSearchVo.paginationInfo.totalRecordCount }건 </small>
		</h3>
		<div class="box-tools">
			<div class="input-group-box">
				<nform:selectRecodeCntPerPage formId="tmplatSearchVo" value="${tmplatSearchVo}" />
			</div>
		</div>
	</div>
	<!-- box-body -->
	<div class="box-body no-padding detail-list-body">
		<table class="table table-vertical table-layout-fixed" id="vrStrgTmplatTable">
		<caption>템플릿 결과목록 (사용여부, 템플릿명, 가상화SW, 운영체제, OS타입, OS Bits, OS버전, 용도, Platform, 할당량(GB), S/W)</caption>
			<thead>
				<tr>
					<th>No</th>
					<th>사용여부</th>
					<th>템플릿명</th>
					<th>템플릿구분</th>
					<th>가상화SW</th>
					<th>운영체제</th>
					<th>OS타입</th>
					<th>OS Bits</th>
					<th>OS버전</th>
					<th>용도</th>
					<th>Platform</th>
					<th>할당량(GB)</th>
					<th>S/W</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vrStrgVo" items="${vrStrgTmplatList }" varStatus="i">
					<tr>
						<td><c:out value="${(tmplatSearchVo.paginationInfo.totalRecordCount-tmplatSearchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td>
						<td>
							<nobr>
								<c:choose>
									<c:when test="${ vrStrgVo.useYnNm eq 'Y' }">
										<span title="사용" class="status status-green">사용</span>
									</c:when>
									<c:otherwise>
										<span title="미사용" class="status status-gray">미사용</span>
									</c:otherwise>
								</c:choose>
							</nobr>
						</td>
						<td class="alignL">
							<c:out value="${vrStrgVo.tmplatNm }" />
						</td>
						<td class="alignL">
							<c:out value="${vrStrgVo.tmplatClNm }" />
						</td>
						<td class="alignL">
							<c:out value="${vrStrgVo.vrlzSwTyCdNm }" />
						</td>
						<td class="alignL">
							<c:out value="${vrStrgVo.osNm }" />
						</td>
						<td class="alignL">
							<c:out value="${vrStrgVo.osTyCdNm }" />
						</td>
						<td>
							<c:out value="${vrStrgVo.osBitNm }" />
						</td>
						<td class="alignL">
							<c:out value="${vrStrgVo.osVer }" />
						</td>
						<td class="alignL">
							<c:out value="${vrStrgVo.prposNm }" />
						</td>
						<td class="alignL">
							<c:out value="${vrStrgVo.pltfrm }" />
						</td>
						<td class="alignR">
							<c:out value="${vrStrgVo.strgAsgnCapa_tmplat }" />
						</td>
						<td class="alignL">
							<c:out value="${vrStrgVo.swNm }" />
						</td>
					</tr>
					</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="box-footer edit-btn-group">
		<c:url var="listUrl" value="selectVrStrgRsrcPoolList.do">
			<c:forEach var="curParam" items="${param }">
				<c:if test="${(curParam.key ne 'rsrcPoolId') and (curParam.key ne 'searchType')  and (curParam.key ne 'searchStrgDmnSeq')}">
					<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
				</c:if>
			</c:forEach>
		</c:url>
		<div class="pull-left btns">
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="뒤로" data-original-title="뒤로" onclick="goToUrl('${listUrl}')"><i class="fa fa-arrow-left"></i></button>
		</div>
		<ul class="pagination">
			<ui:pagination paginationInfo="${tmplatSearchVo.paginationInfo }" type="common" jsFunction="fn_goPage_tmplat" />
		</ul>
	</div>
</div>
<script type="text/javascript">
function fn_goPage_tmplat(){
	location.href = "selectVrStrg.do?paginationInfo.currentPageNo="+ page + "&${listParam}";
}

function fn_initTmplatComponent(){
	$('#tmplatSearchVo input[type="text"]').val('');
	$('#tmplatSearchVo select').val('').attr('selected', 'selected');
	$('#tmplatSearchVo input[type="checkbox"][name="vrlzSwTyCdList"]').prop('checked', 'checked');
}

function fn_searchVrStrgTmplatList(){
	$('#tmplatSearchVo').attr('action', '<c:url var="select" value="selectVrStrg.do"/>');
	$('#tmplatSearchVo').submit();
}

$("#vrStrgTmplatTable").DataTable({
	dom : 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
				   {sWidth : "25px" },
	               {sWidth : "40px" },
	               {sWidth : "81px" },
	               {sWidth : "55px" },
	               {sWidth : "107px" },
	               {sWidth : "82px" },
	               {sWidth : "76px" },
	               {sWidth : "45px" },
	               {sWidth : "61px" },
	               {sWidth : "112px" },
	               {sWidth : "137px" },
	               {sWidth : "69px" },
	               {sWidth : "134px" }
	],
	order : [ [ 0, "desc" ] ]
});

</script>
