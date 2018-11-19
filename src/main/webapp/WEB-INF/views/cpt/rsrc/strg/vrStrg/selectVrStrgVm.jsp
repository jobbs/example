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
	<form:form commandName="vmSearchVo" method="get">
		<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />
		<input type="hidden" name="searchStrgDmnSeq" id="searchStrgDmnSeq" value="${searchVo.searchStrgDmnSeq }" />
		<input type="hidden" name="searchType" id="searchType" value="${searchVo.searchType }" />
		<div class="box-body">
			<div class="form-group">
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="containsClstrNm" title="클러스터명">클러스터명</label>
					</div>
					<div class="cell-body">
						<form:input path="containsClstrNm" title="클러스터명" cssClass="form-control input-sm" value="" />
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="containsPmNm" title="물리서버명">물리서버명</label>
					</div>
					<div class="cell-body">
						<form:input path="containsPmNm" title="물리서버명" cssClass="form-control input-sm" value="" />
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="containsPmCompId" title="물리서버구성ID" >물리서버구성ID</label>
					</div>
					<div class="cell-body">
						<form:input path="containsPmCompId" title="물리서버구성ID" cssClass="form-control input-sm" value="" />
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="containsVmNm" title="가상서버명">가상서버명</label>
					</div>
					<div class="cell-body">
						<form:input path="containsVmNm" title="가상서버명" cssClass="form-control input-sm" value="" />
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="containsVmId" title="가상서버ID" >가상서버ID</label>
					</div>
					<div class="cell-body">
						<form:input path="containsVmId" title="가상서버ID" cssClass="form-control input-sm" value="" />
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="containsVmCompId" title="가상서버구성ID">가상서버구성ID</label>
					</div>
					<div class="cell-body">
						<form:input path="containsVmCompId" title="가상서버구성ID" cssClass="form-control input-sm" value="" />
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="containsInstitutionNm" title="부처명" >부처명</label>
					</div>
					<div class="cell-body">
						<form:input path="containsInstitutionNm" title="부처명" cssClass="form-control input-sm" value="" />
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="existsContainsJobNm" title="업무명">업무명</label>
					</div>
					<div class="cell-body">
						<form:input path="existsContainsJobNm" title="업무명" cssClass="form-control input-sm" value="" />
					</div>
				</div>
				<div class="form-cell form-cell-100 col-lay-100">
					<div class="cell-title">
						<label for="existsVrlzSwTyCdList" title="가상화SW">가상화SW</label>
					</div>
					<div class="cell-body">
						<div class="input-group input-group-check">
							<c:choose>
								<c:when test="${vmSearchVo eq null or vmSearchVo.existsVrlzSwTyCdList eq null}">
									<c:forEach var="vrlzSwTyCd" items="${vrlzSwTyCdList }" varStatus="i">
										<c:if test='${"COM" eq vrlzSwTyCd.varVl1}'>
											<form:checkbox path="existsVrlzSwTyCdList[${i.index }]" title="가상화SW" value="${vrlzSwTyCd.cd}" id="${vrlzSwTyCd.cd}" data-name="existsVrlzSwTyCdList" checked="checked"/>
											<label for="${vrlzSwTyCd.cd}"><c:out value="${vrlzSwTyCd.cdNm}"/></label>
										</c:if>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<c:forEach var="vrlzSwTyCd" items="${vrlzSwTyCdList }" varStatus="i">
										<c:if test='${"COM" eq vrlzSwTyCd.varVl1}'>
											<form:checkbox path="existsVrlzSwTyCdList[${i.index }]" title="가상화SW" value="${vrlzSwTyCd.cd}" id="${vrlzSwTyCd.cd}" data-name="existsVrlzSwTyCdList"/>
											<label for="${vrlzSwTyCd.cd}"><c:out value="${vrlzSwTyCd.cdNm}"/></label>
										</c:if>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form:form>
	<div class="box-footer">
		<div class="pull-left">
			<button type="reset" class="btn" onclick="fn_initVmComponent('vmSearchVo')" title="초기화">초기화</button>
		</div>
		<div class="pull-right">
			<button type="button" class="btn btn-red pull-right" onclick="fn_searchVrStrgVmList()" title="조회">조회</button>
		</div>
	</div>
	<!-- /box-footer -->
</div>
<!-- /box(검색조건) -->
<div class="box detail-list-box">
	<!-- box-header -->
	<div class="box-header">
		<h3 class="box-title">
			검색결과<small> ${vmSearchVo.paginationInfo.currentPageNo }
				/ ${vmSearchVo.paginationInfo.totalPageCount }, 총
				${vmSearchVo.paginationInfo.totalRecordCount }건 </small>
		</h3>
		<div class="box-tools">
			<div class="input-group-box">
				<nform:selectRecodeCntPerPage formId="vmSearchVo" value="${vmSearchVo}" />
			</div>
		</div>
	</div>
	<!-- box-body -->
	<div class="box-body no-padding detail-list-body">
		<table class="table table-vertical table-layout-fixed" id="vrStrgVmTable">
		<caption>가상서버 결과목록(클러스터명, 물리서버구성ID, 물리서버명,  가상서버구성ID, 가상서버명, 가상서버ID, 가상화SW, 부처명, 업무명, 스냅샷할당량(GB), 할당량(GB))</caption>
			<thead>
				<tr>
					<th>No</th>
					<th>클러스터명</th>
					<th>물리서버 구성ID</th>
					<th>물리서버명</th>
					<th>가상서버구성ID</th>
					<th>가상서버명</th>
					<th>가상서버ID</th>
					<th>가상화SW</th>
					<th>부처명</th>
					<th>업무명</th>
					<th>스냅샷할당량(GB)</th>
					<th>할당량(GB)</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vrStrgVo" items="${vrStrgVmList }" varStatus="i">
					<tr>
						<td><c:out value="${(vmSearchVo.paginationInfo.totalRecordCount-vmSearchVo.paginationInfo.firstRecordIndex-i.count)+1}" />
							<input type="hidden" name="strgDmnSeq" value="${vrStrgVo.strgDmnSeq }"/>
						</td>
						<td class="alignL"><c:out value="${vrStrgVo.clstrNm }" /></td>
						<td class="alignL"><c:out value="${vrStrgVo.pmCompId }" /></td>
						<td class="alignL"><c:out value="${vrStrgVo.pmNm }" /></td>
						<td class="alignL"><c:out value="${vrStrgVo.vmCompId }" /></td>
						<td class="alignL"><c:out value="${vrStrgVo.vmNm }" /></td>
						<td class="alignL"><c:out value="${vrStrgVo.vmId }" /></td>
						<td class="alignL"><c:out value="${vrStrgVo.vrlzSwTyCdNm }" /></td>
						<td class="alignL"><c:out value="${vrStrgVo.institutionNm }" /></td>
						<td class="alignL"><c:out value="${vrStrgVo.jobNm }" /></td>
						<td class="alignR"><c:out value="${vrStrgVo.vmSnapshtAsgnCapa_sum }" /></td>
						<td class="alignR"><c:out value="${vrStrgVo.strgAsgmCapa_vm_sum }" /></td>
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
			<ui:pagination paginationInfo="${vmSearchVo.paginationInfo }" type="common" jsFunction="fn_goPage_vm" />
		</ul>
	</div>
</div>
<script type="text/javascript">
function fn_goPage_vm(page) {
	location.href = "selectVrStrg.do?paginationInfo.currentPageNo="+ page + "&${listParam}";
}

function fn_initVmComponent(){
	$('#vmSearchVo input[type="text"]').val('');
	$('#vmSearchVo input[type="checkbox"][data-name="existsVrlzSwTyCdList"]').prop('checked', 'checked');
}


function fn_searchVrStrgVmList() {
	$('#vmSearchVo').attr('action', '<c:url var="select" value="selectVrStrg.do"/>');
	$('#vmSearchVo').submit();
}

$("#vrStrgVmTable").DataTable({
	dom : 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
				   {sWidth : "25px" },
	               {sWidth : "84px" },
	               {sWidth : "79px" },
	               {sWidth : "120px" },
	               {sWidth : "95px" },
	               {sWidth : "127px" },
	               {sWidth : "113px" },
	               {sWidth : "92px" },
	               {sWidth : "64px" },
	               {sWidth : "66px" },
	               {sWidth : "66px" },
	               {sWidth : "55px" }
	],
	order : [ [ 0, "desc" ] ]
});
</script>