<%--
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre>자동확장 스펙 선택 화면</pre>
 *
 * @author x
 * @lastmodifier x
 * @created 2017. 04. 28.
 * @lastmodified 2017. 04. 28.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 05. 13.     x         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<div class="col-box-100">
	<!-- 검색조건 영역 -->
	<div class="box-search">
		<!-- box-header -->
		<form:form id="searchVo" commandName="searchVo" method="GET">
			<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />
			<div class="box-body">
				<div class="form-group">
					<div class="form-cell form-cell-100 col-lay-100">
						<div class="cell-title">
							<label for="specNm">스펙명</label>
						</div>
						<div class="cell-body">
							<div class="input-group">
								<form:input path="specNm" type="text" class="form-control input-sm pull-right" maxlength="60" title="스펙명" />
							</div>
						</div>
					</div>

					<div class="form-cell form-cell-100 alignR pad-top-5">
						<div class="pull-left">
					    	<button type="button" class="btn btn-sm" onclick="fn_initialize();">초기화</button>
					  	</div>
					  	<div class="pull-right">
							<button class="btn btn-red btn-sm" type="button" onclick="fn_selectVmSearchList()">조회</button>
						</div>
					</div>
				</div>
			</div>
		</form:form>
	</div>
	<!-- 스펙 테이블 영역 -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">
				검색결과<small> ${searchVo.paginationInfo.currentPageNo }
					/ ${searchVo.paginationInfo.totalPageCount }, 총
					${searchVo.paginationInfo.totalRecordCount }건 </small>
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo }"/>
				</div>
			</div>
		</div>
		<!-- /box-header -->
		<!-- box-body -->
		<form:form commandName="specVo" id="specFrm" method="get">
			<div class="box-body no-padding" style="overflow-x:auto;">
				<table class="table table-vertical table-hover table-layout-fixed" id="specTable">
					<caption>스펙 목록 테이블</caption>
					<thead>
						<tr>
							<th>선택</th>
							<th>스펙명</th>
							<th>요청 CPU(Core)</th>
							<th>제한 CPU(Core)</th>
							<th>요청 메모리(GB)</th>
							<th>제한 메모리(GB)</th>
							<c:if test="${searchVo.specClCd eq '06' }">
							<th>최대 Pod 수</th>
							</c:if>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${specList eq null or empty specList }">
							</c:when>
							<c:otherwise>
								<c:forEach var="specVo" items="${specList }" varStatus="i">

									<tr>
										<td>
											<input type="radio" id="specSeq" name ="specSeq" value="${specVo.specSeq }"  title="${specVo.specNm} 선택"/>
											<input type="hidden" id="specVo_${specVo.specSeq}_specNm"  value="${specVo.specNm }"/>
											<input type="hidden" id="specVo_${specVo.specSeq}_vcoreMinVl"  value="${specVo.vcoreMinVl }"/>
											<input type="hidden" id="specVo_${specVo.specSeq}_vcoreMaxVl"  value="${specVo.vcoreMaxVl }"/>
											<input type="hidden" id="specVo_${specVo.specSeq}_memMinVl"  value="${specVo.memMinVl }"/>
											<input type="hidden" id="specVo_${specVo.specSeq}_memMaxVl"  value="${specVo.memMaxVl }"/>
											<input type="hidden" id="specVo_${specVo.specSeq}_maxPodQty"  value="${specVo.maxPodQty }"/>
										</td>
										<td class="alignL"><c:out value="${specVo.specNm}" /></td>
										<td class="alignR"><c:out value="${specVo.vcoreMinVl}" /></td>
										<td class="alignR"><c:out value="${specVo.vcoreMaxVl}" /></td>
										<td class="alignR"><c:out value="${specVo.memMinVl}" /></td>
										<td class="alignR"><c:out value="${specVo.memMaxVl}" /></td>
										<c:if test="${searchVo.specClCd eq '06' }">
										<td class="alignR"><c:out value="${specVo.maxPodQty}" /></td>
										</c:if>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>

			</div>
				<div class="box-footer">
					<ul class="pagination">
						<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="fn_goPage" />
					</ul>
				</div>
			</form:form>
		<!-- /box-body -->
	</div>
</div>
<!-- popup 버튼 -->
<div class="col-box-100">
  <div class="button">
  	<button type="button" class="btn btn-dark" onclick="fn_selectSpec()">선택</button>
  	<button type="button" class="btn close-window" >닫기</button>
   </div>
</div>
<!-- /popup 버튼 -->

<script type="text/javascript">

//검색조건 초기화
function fn_initialize(){
	$('#searchVo input[type="text"]').val('');
}


//페이지 이동
function fn_goPage(page){
	location.href = "selectAtmSclSpecListPView.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}


// 조회
function fn_selectVmSearchList(){

	$('#searchVo').attr('target', '_self');
	$('#searchVo').attr('action', '<c:url var="select" value="selectAtmSclSpecListPView.do"/>');
	$('#searchVo').submit();
}


//스펙선택
function fn_selectSpec(){

	var specSeq = $("input:radio[name='specSeq']:checked").val();

	if(specSeq=='' || specSeq== undefined){
		jAlert("스펙을 선택해 주세요.");
	}else{
		var specVo = {
				vcoreMinVl : $("#specVo_"+specSeq+"_vcoreMinVl" ).val()
				, vcoreMaxVl : $("#specVo_"+specSeq+"_vcoreMaxVl" ).val()
				, memMinVl : $("#specVo_"+specSeq+"_memMinVl" ).val()
				, memMaxVl: $("#specVo_"+specSeq+"_memMaxVl" ).val()
				, maxPodQty: $("#specVo_"+specSeq+"_maxPodQty" ).val()
				, specNm: $("#specVo_"+specSeq+"_specNm" ).val()
		};

		window.opener.fn_selectedSpec(specVo);
		self.close();
	}
}

$("#specFrm input[name='specSeq']").parent().parent().click(function() {
	var $target = $(this).find("input[name='specSeq']");
	$target.prop("checked", true);
});


$("#specTable").DataTable({
	dom : 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	<c:if test="${searchVo.specClCd eq '06' }">
	aoColumns : [
					{sWidth : "30px" },
					{sWidth : "230px" },
					{sWidth : "120px" },
					{sWidth : "120px" },
					{sWidth : "120px" },
					{sWidth : "120px" },
					{sWidth : "120px" }
		 ],
	</c:if>
	<c:if test="${searchVo.specClCd eq '07' }">
	aoColumns : [
					{sWidth : "30px" },
					{sWidth : "350px" },
					{sWidth : "120px" },
					{sWidth : "120px" },
					{sWidth : "120px" },
					{sWidth : "120px" }
		 ],
	</c:if>

	order : [ [ 0, "desc" ] ]
});

</script>