<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 12.
 * @lastmodified 2016. 10. 12.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 12.     송승규         v1.0             최초생성
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

<script type="text/javascript" src="<c:url value="/resources/js/common/FileUtils.js" />" charset="UTF-8"></script>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>


<div class="col-box-100">
	<form:form commandName="searchVo" method="get">
	<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />
	<div class="box-search">
		<div class="box-body">
			<div class="form-group">
<!--
					<div class="form-cell form-cell-50">
						<div class="cell-title">
							<label for="compId">소프트웨어 구성ID</label>
						</div>
						<div class="cell-body">
							<form:input path="compId" cssClass="form-control input-sm pull-right onlyInteger" />
						</div>
					</div>
-->
				<div class="form-cell form-cell-50">
					<div class="cell-title">
						<label for="swNm">소프트웨어명</label>
					</div>
					<div class="cell-body">
						<form:input path="swNm" cssClass="form-control input-sm pull-right" title="소프트웨어명" />
					</div>
				</div>
				<div class="form-cell form-cell-50">
					<div class="cell-title">
						<label for="swVer">소프트웨어 버전</label>
					</div>
					<div class="cell-body">
						<form:input path="swVer" cssClass="form-control input-sm pull-right" title="소프트웨어 버전" />
					</div>
				</div>
				<div class="form-cell form-cell-50">
					<div class="cell-title">
						<label for="swMnfctCo">소프트웨어 제조사</label>
					</div>
					<div class="cell-body">
						<form:input path="swMnfctCo" cssClass="form-control input-sm pull-right" title="소프트웨어 제조사" />
					</div>
				</div>
				<div class="form-cell form-cell-100 alignR pad-top-5">
					<button type="button" class="btn btn-red btn-sm" title="조회" onclick="fn_selectSwList();">조회</button>
				</div>
			</div>
		</div>
	</div>
	</form:form>

	<div class="box">
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
		<div class="box-body no-padding">
			<form id="swFrm" name="swFrm" action="deleteSwList.do">
				<table class="table table-hover table-vertical table-layout-fixed" id="swTable" >
					<caption>소프트웨어 목록 테이블</caption>
					<thead>
						<tr>
							<th>선택</th>
							<th>소프트웨어명</th>
							<th>소프트웨어 버전</th>
							<th>소프트웨어 제조사</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vo" items="${list }" varStatus="i">
							<tr>
								<td><input type="checkbox" name="updtCheck" class="updtCheck" value="${vo.swSeq }" title="항목선택"/>
									<input type="hidden" name=swNm value="${vo.swNm }" style="display: none;" />
									<input type="hidden" name=swVer value="${vo.swVer }" style="display: none;" />
									<input type="hidden" name="swMnfctCo" value="${vo.swMnfctCo }" style="display: none;" />
									<input type="hidden" name="rmk" value="${vo.rmk }" style="display: none;" />
								</td>
								<td class="alignL"><c:out value="${vo.swNm }" /></td>
								<td class="alignL"><c:out value="${vo.swVer }" /></td>
								<td class="alignL"><c:out value="${vo.swMnfctCo }" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
		</div>
		<div class="box-footer">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="fn_goPage" />
			</ul>
		</div>
	</div>
<!--
 	<div class="box">
		<div class="box-footer pull-left">
			<h4 class="box-title alignL">
				<span class="text-red">*</span> 소프트웨어 업로드를 위한 템플릿 다운로드 <a href="<c:url value='selectSwXlsDwnload.do'/>">[SW업로드샘플.xlsx]</a>
				<span class="text-red">*</span> 업로드 할 엑셀파일(*.xls,*.xlsx)을 선택한 후, [엑셀업로드] 버튼을 클릭하시기 바랍니다.
			</h4>
		</div>
	</div>
-->
</div>
<div class="col-box-100">
	<div class="button">
				<button type="button" class="btn btn-dark" onclick="selectSw()" title="선택">선택</button>
				<button type="button" class="btn close-window" onclick="fn_close()">닫기</button>
				</div>
			</div>
<script type="text/javascript">
	$("#swFrm input[name='updtCheck']").click(function(event) {
		event.stopPropagation();
	});

	$("#swFrm input[name='updtCheck']").parent().parent().click(function() {
		var $target = $(this).find("input[name='updtCheck']");
		var checked = $target.prop("checked");
		$target.prop("checked", !checked);
	});

	//페이지 이동
	function fn_goPage(page) {
		location.href = "<c:url value='selectSwListP.do?paginationInfo.currentPageNo=" + page + "&${listParam}'/>";
	}

	function fn_selectSwList(){

		$("#searchVo").attr("action", "selectSwListP.do");
		$("#searchVo").submit();
	}

	var EntitySw = function() {

		this.swSeq;
		this.compId;
		this.swNm;
		this.swVer;
		this.swMnfctCo;
		this.rmk;
	}

	function selectSw() {

		if( $("input:checkbox[name='updtCheck']:checked").size() == 0 ) {
			jConfirm("선택된 소프트웨어가 없습니다.<br/>창을 닫으시겠습니까?", function(){
				window.close();
			});
		}else{

			var datas = new Array();
			var data = null;
			$("input:checkbox[name='updtCheck']").each(function(index) {
				if( $(this).prop("checked") ) {
					data = new EntitySw();
					data.swSeq = $(this).val();
					data.swNm = $("input:hidden[name='swNm']:eq(" + index + ")").val();
					data.swVer = $("input:hidden[name='swVer']:eq(" + index + ")").val();
					data.swMnfctCo = $("input:hidden[name='swMnfctCo']:eq(" + index + ")").val();
					data.rmk = $("input:hidden[name='rmk']:eq(" + index + ")").val();
					datas.push(data);
				}
			});

			var evt = jQuery.Event('swTable', {
				"datas" : datas
			});

			var _parent = window.opener;
			_parent.jQuery(_parent.document).trigger(evt);
			window.close();
		}
	}

	$("#swTable").DataTable({
		dom: 'Zlfrtip' ,
		paging : false,
		searching : false,
		info : false,
		bAutoWidth : false,
		aoColumns : [
					{sWidth : "50px" },
					{sWidth : "348px" },
					{sWidth : "100px" },
					{sWidth : "200px" }
					],
		order : [ [ 1, "asc" ] ]
	});
</script>