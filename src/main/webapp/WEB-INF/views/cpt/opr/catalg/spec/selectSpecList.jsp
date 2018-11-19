<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 09. 29.
 * @lastmodified 2016. 09. 29.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 09. 29.     송승규         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<div class="col-box-100 search-col">
	<form:form id="searchVo" commandName="searchVo" method="GET">
		<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage"/>
		<div class="box box-search">
			<div class="box-header">
				<h3 class="box-title">검색조건</h3>
				<div class="box-tools pull-right">
					<button type="button" class="btn btn-sm" data-toggle="collapse" data-target=".search-collapse">
						<i class="fa fa-chevron-up" data-toggle="tooltip" title="" data-original-title="접어두기"></i>
					</button>
				</div>
			</div>
			<div class="box-body collapse in search-collapse">
				<div class="form-group">


					<div class="form-cell form-cell-50 col-lay-25">
			            <div class="cell-title">
			                <label title="구분" for="clCd">구분</label>
			            </div>
			            <div class="cell-body">
			                <nform:selectCode
			                            parentCd="151"
			                            parentGrpCd="098"
			                            name="clCd"
			                            id="clCd"
			                            whole="true"
			                            cssClass="form-control input-sm"
			                            value="${searchVo.clCd}"
			                            onchange="selectSpecClCd(this, 'specClCd')"  />
			            </div>
			        </div>

			        <div class="form-cell form-cell-50 col-lay-33">
			            <div class="cell-title">
			                <label title="분류" for="clCd">분류</label>
			            </div>
			            <div class="cell-body">
			                <nform:selectCode
			                            parentCd="120"
			                            parentGrpCd="021"
			                            name="specClCd"
			                            id="specClCd"
			                            extra1="${searchVo.clCd}"
			                            whole="true"
			                            cssClass="form-control input-sm"
			                            value="${searchVo.specClCd}" />
			            </div>
			        </div>

					<div class="form-cell form-cell-50 col-lay-33">
						<div class="cell-title">
							<label for="specNm">스펙명</label>
						</div>
						<div class="cell-body">
							<div class="input-group">
								<form:input path="specNm" type="text" class="form-control input-sm pull-right" maxlength="60" title="스펙명" />
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="box-footer collapse in search-collapse">
				<div class="pull-left">
					<button type="button" class="btn" onClick="fn_reset();" title="검색조건 초기화">초기화</button>
				</div>
				<div class="pull-right">
					<button type="button" class="btn btn-red" onClick="fn_selectSpecList();" title="조회">조회</button>
				</div>
			</div>
		</div>
	</form:form>
</div>
<div class="col-box-100 search-col">
	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">검색결과<small>
				${searchVo.paginationInfo.currentPageNo } /
				${searchVo.paginationInfo.totalPageCount },
				총 ${searchVo.paginationInfo.totalRecordCount }건
			</small></h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo }"/>
					<div class="input-group-cell pad-right">
						<button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_downloadExcel();"><i class="fa fa-download"></i></button>
					</div>
				</div>
			</div>
		</div>
		<div class="box-body no-padding list-body">
			<form id=specView name="specView" method="post" action="deleteSpec.do">
				<table class="table table-hover table-vertical table-layout-fixed" id="specTable">
					<caption>스펙 목록 테이블</caption>
					<thead>
						<tr>
							<th><input type="checkbox" id="selectAll" title="전체선택"></th>
							<th>구분</th>
							<th>분류</th>
							<th>스펙명</th>
							<th>vCore</th>
							<th>메모리<br>(GB)</th>
							<!--
							<th>최소 CPU(Core)</th>
							<th>최대 CPU(Core)</th>
							<th>최소 메모리(GB)</th>
							<th>최대 메모리(GB)</th>
							-->
							<!--
							<th>vCore</th>
							<th>Entitlement</th>
							<th>메모리<br>(GB)</th>
							<th>스토리지<br>(GB)</th>
							<th>생성자</th>
							<th>생성일자</th>
							-->
							<th>등록자</th>
							<th>등록일자</th>
							<th>수정자</th>
							<th>수정일자</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${specList eq null or empty specList }">
							</c:when>
							<c:otherwise>
								<c:forEach var="specVo" items="${specList }" varStatus="i">
									<c:url var="detailUrl" value="selectSpec.do">
										<c:forEach var="curParam" items="${param }">
											<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
										</c:forEach>
										<c:param name="specSeq" value="${specVo.specSeq }" />
									</c:url>
									<tr>
										<td><input type="checkbox" name="delCheck" class="delCheck" value="${specVo.specSeq }" title="항목선택"></td>
										<td class="alignL"><c:out value="${specVo.clCdNm }" /></td>
										<td class="alignL"><c:out value="${specVo.specClCdNm }" /></td>
										<td class="alignL"><a href="<c:url value="${detailUrl }" />" title="<c:out value="${specVo.specNm}"/> 상세 화면이동"><c:out value="${specVo.specNm}" /></a></td>
										<td class="alignR"><c:out value="${specVo.cpuVcore}" /></td>
										<td class="alignR"><c:out value="${specVo.mem }" /></td>
										<!--
										<td class="alignR"><c:out value="${specVo.vcoreMinVl}" /></td>
										<td class="alignR"><c:out value="${specVo.vcoreMaxVl}" /></td>
										<td class="alignR"><c:out value="${specVo.memMinVl}" /></td>
										<td class="alignR"><c:out value="${specVo.memMaxVl}" /></td>
										-->
										<!--
										<td class="alignR"><c:out value="${specVo.cpuVcore}" /></td>
										<td class="alignR"><c:out value="${specVo.ent }" /></td>
										<td class="alignR"><c:out value="${specVo.mem }" /></td>
										<td class="alignR"><c:out value="${specVo.strgDfltVl }" /></td>
										-->
										<td><c:out value="${specVo.creUserNm }" /></td>
										<td><fmt:formatDate value="${specVo.creDt }" pattern="yyyy-MM-dd" /></td>
										<td><c:out value="${specVo.updtUserNm }" /></td>
										<td><fmt:formatDate value="${specVo.updtDt }" pattern="yyyy-MM-dd" /></td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</form>
		</div>
		<div class="box-footer edit-btn-group">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="fn_goPage" />
			</ul>
			<div class="pull-right btns">
				<menu:authorize onlyOprAdm="true">
					<c:url var="insertUrl" value="insertSpecAix.do">
						<c:forEach var="curParam" items="${param }">
							<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
						</c:forEach>
					</c:url>
					<button type="button" class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="스펙 생성" onclick="goToUrl('${insertUrl}')"><i class="fa fa-plus"></i></button>
					<button type="button" class="btn btn-hover-red" data-toggle="tooltip" data-original-title="삭제" onclick="deleteCheck();"><i class="fa fa-minus"></i></button>
				</menu:authorize>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">

	$(document).ready(function(){
		$('#selectAll').click(function(){
			$('.delCheck').prop('checked', $(this).is(":checked"));
		});

		$('.delCheck').click(function(){
			if($('.delCheck:checked').length == $('.delCheck').length){
				$('#selectAll').prop('checked', true);
			}
			else {
				$('#selectAll').prop('checked', false);
			}
		});

		 $("#clCd").change();

	});

	// 페이징 이동
	function fn_goPage(page){
		location.href = "<c:url value='selectSpecList.do?paginationInfo.currentPageNo=" + page + "&${listParam}'/>";
	}

	// 검색조건 초기화
	function fn_reset() {
		$("#searchVo input[type='text']").val("");
		$("#searchVo select").val("").attr("selected","selected");
	}

	function fn_selectSpecList(){

		$("#searchVo").attr("action", "selectSpecList.do");
		$("#searchVo").submit();
	}

	// 삭제 선택 row 체크
	function deleteCheck(){
		var checked = 0;
		$("input[name='delCheck']").each(function() {
			if( $(this).prop("checked") ) {
				checked++;
			}
		});

		if( checked == 0 ) {
			jAlert("삭제대상을 선택하시기 바랍니다.");
			return;
		}
		jConfirm('스펙을 삭제하시겠습니까?<br/>삭제된 데이터는 되돌릴 수 없습니다.',fn_deleteSpec)
	}

	function selectSpecClCd(obj, target) {

	    var url = "<c:url value='/cpt/opr/catalg/spec/selectSpecClCdList.do'/>";
	    var val = $(obj).val();
	    var targetVal = $('#specClCd').val();
	    var searchParams = { "clCd" : val };

	    $.get(url, searchParams, function(result) {
	        if( result.success) {
	            var datas = result.data;
	            $("#" + target + " > option").remove();
	            if( datas != null ) {
	                //create Option
	                for(var i = 0; i < datas.length; i++ ) {
	                	if(targetVal == datas[i].cd ) {
	                		$("#" + target).append("<option value='" + datas[i].cd + "' selected='selected'>" + datas[i].cdNm + "</option>");
	                	}else {
	                		$("#" + target).append("<option value='" + datas[i].cd + "'>" + datas[i].cdNm + "</option>");
	                	}
	                }
	            }

	            $("#" + target).change();
	        }
	    }, "json");
	}

	// 선택스펙 삭제
	function fn_deleteSpec(){
		var options = {
			type: 'post',
			dataType: 'json',
			success: fn_deleteSpecCallBack,
			beforeSend : function() {
				$.ncmsLoding.startFullScreen();
			},
			complete : function() {
				$.ncmsLoding.remove();
			},
			error: function(xhr, textStatus, errorThrown){
				alert('오류 발생');
			}
		};
		$('#specView').ajaxSubmit(options);
	}

	// 스펙삭제 콜백
	function fn_deleteSpecCallBack(result){

		if(result.success){
			jInfo("삭제되었습니다.", function (){
				if(result.procType == "delete") {
					location.reload();
				}
			});
		}else{
			jAlert(result.messageList);
		}
	}

	// 엑셀 다운로드
	function fn_downloadExcel() {
		if("${searchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("다운로드할 데이터가 없습니다");
			return;
		}

		$("#searchVo").attr("action", "selectSpecListXlsDwnl.do");
		$("#searchVo").submit();
	}

	// 리스트 테이블 정렬
	$("#specTable").DataTable( {
		dom: 'Zlfrtip' ,
		paging : false,
		searching : false,
		info : false,
		bAutoWidth : false,
		aoColumns : [
					{sWidth : "30px" },
					{sWidth : "45px" },
					{sWidth : "65px" },
					{sWidth : "230px" },
					{sWidth : "50px" },
					{sWidth : "50px" },
					{sWidth : "50px" },
					{sWidth : "50px" },
					{sWidth : "50px" },
					{sWidth : "50px" }
					],
		order : [[1, "asc"], [2, "asc"]]
	} );
</script>
