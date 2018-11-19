<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author x
 * @lastmodifier x
 * @created 2017. 6. 07.
 * @lastmodified 2017. 6. 07.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 6. 07.     x         v1.0             최초생성
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
				<div class="form-cell form-cell-70 col-lay-50">
					<div class="cell-title">
						<label for="searchRegionId">스토리지 구분</label>
					</div>
					<div class="cell-body">
	              		<nform:selectCode
	                          parentCd="305"
	                          parentGrpCd="104"
	                          name="strgClCd"
	                          id="strgClCd"
	                          whole="true"
	                          wholeText="전체"
	                          cssClass="form-control input-sm"
	                          title="스토리지 구분"
	                          value="${searchVo.strgClCd}" />
	          		</div>
				</div>
				<div class="form-cell form-cell-70 col-lay-50">
					<div class="cell-title">
						<label for="searchZoneId">접근 모드</label>
					</div>
					<div class="cell-body">
	               		<nform:selectCode
	                           parentCd="306"
	                           parentGrpCd="105"
	                           name="accssModeClCd"
	                           id="accssModeClCd"
	                           whole="true"
	                           wholeText="전체"
	                           cssClass="form-control input-sm"
	                           title="접근 모드"
	                           value="${searchVo.accssModeClCd}" />
	                 </div>
				</div>

				<div class="form-cell form-cell-70 col-lay-50">
					<div class="cell-title">
						<label for="pvNm">스토리지명</label>
					</div>
					<div class="cell-body">
						<div class="input-group">
							<form:input path="pvNm" type="text" class="form-control input-sm pull-right" maxlength="60" title="스토리지명" />
						</div>
					</div>
				</div>

				<div class="form-cell form-cell-100 alignR pad-top-5">
					<div class="pull-left">
				    	<button type="button" class="btn btn-sm" onclick="fn_initialize();">초기화</button>
				  	</div>
				  	<div class="pull-right">
						<button class="btn btn-red btn-sm" type="submit">조회</button>
					</div>
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
			<form action="pvFrm" id="pvFrm">
			<table class="table table-hover table-vertical">
				<caption>스토리지 목록 테이블</caption>
				<colgroup>
					<col class="col10">
					<col class="col20">
					<col class="col40">
					<col class="col10">
					<col class="col20">
				</colgroup>
				<thead>
				<tr>
					<th>
						<input type="checkbox" id="chkPvAll" title="스토리지 전체 선택" onclick="doCheckAll(this, 'pvId')" />
					</th>
					<th>스토리지구분</th>
					<th>스토리지명</th>
					<th>용량(GB)</th>
					<th>접근모드</th>
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
										<input type="checkbox" name="pvId" class="pvId" value="${vo.pvId }" title="스토리지ID ${vo.pvId }"/>
										<input type="hidden" name="listPvNm" value="${vo.pvNm }" />
									</td>
									<td class="alignL"><c:out value="${vo.strgClCdNm }" /></td>
									<td class="alignL"><c:out value="${vo.pvNm }" /></td>
									<td class="alignR"><c:out value="${vo.strgAsgnCapa }" /></td>
									<td class="alignL"><c:out value="${vo.accssModeClCdNm }" /></td>
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
			</ul>
		<!-- /box-footer -->
		</div>
	</div>
</div>
<div class="col-box-100">
	<div class="button">
		<button type="button" class="btn btn-blue" onclick="selectPv();return false;">추가</button>
		<button type="button" class="btn close-window" onclick="fn_close();return false;">닫기</button>
	</div>
</div>
<script type="text/javascript" src="<c:url value="/resources/js/common/component/entity.js" />"></script>
<script type="text/javascript">

//검색조건 초기화
function fn_initialize(){
	$('#searchVo input[type="text"]').val('');
	$('#searchVo select').val('').attr('selected', 'selected');
}

function doCheckAll(obj, clazz) {
	$("." + clazz).prop("checked", $(obj).prop("checked"));
}

function goPage(page){
	location.href = "selectPvListP.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}

function selectPv(){

	if( $("input:checkbox[name='pvId']:checked").size() == 0 ) {
		jAlert("스토리지를 선택해 주세요.");
		return;
	}

	var datas = new Array();
	var data = null;

	jConfirm('서비스영역관리 화면에서 입력중인 데이터가 있을경우 반영되지 않습니다. \n스토리지를 추가 하시겠습니까?', function(){
		$("input:checkbox[name='pvId']").each(function(index) {
			if( $(this).prop("checked") ) {
				data = new EntityPv();
				data.pvId = $(this).val();
				data.strgClCd = $("input[name='strgClCd']:eq(" + index + ")").val();
				data.strgClCdNm = $("input[name='strgClCdNm']:eq(" + index + ")").val();
				data.pvNm = $("input:hidden[name='listPvNm']:eq(" + index + ")").val();
				data.accssModeClCd = $("input[name='accssModeClCd']:eq(" + index + ")").val();
				data.accssModeClCdNm = $("input[name='accssModeClCdNm']:eq(" + index + ")").val();
				data.strgAsgnCapa = $("input[name='strgAsgnCapa']:eq(" + index + ")").val();
				datas.push(data);
			}
		});

		var evt = jQuery.Event('selectPv', {
			"datas" : datas,
	    });

	    var _parent = window.opener;
	    _parent.jQuery(_parent.document).trigger(evt);
		window.close();
	});

}


function EntityPv() {
	this.pvId;
	this.strgClCd;
	this.strgClCdNm;
	this.pvNm;
	this.accssModeClCd;
	this.accssModeClCdNm;
	this.strgAsgnCapa;
};


$("#pvFrm input[name='pvId']").click(function(event) {
	event.stopPropagation();
});

$("#pvFrm input[name='pvId']").parent().parent().click(function() {
	var $target = $(this).find("input[name='pvId']");

	var checked = $target.prop("checked");
	$target.prop("checked", !checked);
});
</script>