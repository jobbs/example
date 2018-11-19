<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 28.
 * @lastmodified 2016. 10. 28.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 28.     송승규         v1.0             최초생성
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
						<label for="netwkTyClCd">네트워크유형</label>
					</div>
					<div class="cell-body">
						<div class="input-group">
							<form:select path="netwkTyClCd" cssClass="form-control input-sm" title="네트워크유형">
				              	<c:forEach var="netwkTyClCdCode" items="${netwkTyClCdCode}" varStatus="i">
				              		<form:option value="${netwkTyClCdCode.cd}">${netwkTyClCdCode.cdNm}</form:option>
				              	</c:forEach>
							</form:select>
						</div>
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="vmId">가상서버ID</label>
					</div>
					<div class="cell-body">
						<form:input type="text" path="vmId" class="form-control input-sm pull-right" title="가상서버ID" maxlength="100" />
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="vmNm">가상서버명</label>
					</div>
					<div class="cell-body">
						<form:input type="text" path="vmNm" class="form-control input-sm pull-right" title="가상서버명" maxlength="100" />
					</div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="institutionNm">부처명</label>
					</div>
					<div class="cell-body">
						<form:input type="text" path="institutionNm" class="form-control input-sm pull-right" title="부처명" maxlength="30" />
					</div>
				</div>
			</div>
		</div>
		<div class="box-footer collapse in search-collapse">
			<div class="pull-left">
				<button type="button" class="btn" onclick="fn_reset();" title="검색조건 초기화">초기화</button>
			</div>
			<div class="pull-right">
				<button type="button" class="btn btn-red" onclick="fn_selectNetSwtchList();" title="조회">조회</button>
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
				</div>
			</div>
		</div>
		<div class="box-body no-padding list-body">
		<form id="vo" method="post">
			<table class="table table-hover table-vertical table-layout-fixed" id="netSwtchTable">
				<caption>부처별 L3/L4 목록 테이블</caption>
				<thead>
					<tr>
						<th><nobr>No.</nobr></th>
						<th><nobr>네트워크유형</nobr></th>
						<th><nobr>가상서버ID</nobr></th>
						<th><nobr>가상서버명</nobr></th>
						<th><nobr>부처명</nobr></th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${list eq null or empty list }">
						</c:when>
						<c:otherwise>
							<c:forEach var="netSwtchVo" items="${list }" varStatus="i">
								<tr>
									<td><nobr><c:out value="${list.size() - i.index}" /></nobr></td>
									<td><nobr><c:out value="${netSwtchVo.netwkTyClCdNm}" /></nobr></td>
									<td class="alignL"><nobr><c:out value="${netSwtchVo.vmId}" /></nobr></td>
									<td class="alignL"><nobr><c:out value="${netSwtchVo.vmNm}" /></nobr></td>
									<td>
										<nobr><div class="input-group">
											<input name='netSwtchList[${i.index }].vmSeq' data-name="netSwtchListVmSeq" value="${netSwtchVo.vmSeq}" type="hidden" >
											<input name='netSwtchList[${i.index }].institutionId' data-name="netSwtchListInstitutionId" value="${netSwtchVo.institutionId}" type="hidden" >
											<input name="institutionNm${i.index }" class="form-control input-sm essential" title="부처명" value="<c:out value="${netSwtchVo.institutionNm}" />" type="text" readonly="readonly" >
											<div class="input-group-btn">
												<button type="button" class="btn btn-sm" onclick="javascript:test(${i.index });" title="부처검색 팝업" ><i class="fa fa-search"></i></button>
											</div>
										</div></nobr>
									</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</form>
		</div>
		<div class="box-footer edit-btn-group ">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="fn_goPage" />
			</ul>
			<div class="pull-right btns">
				<menu:authorize onlyOprAdm="true">
					<button type="button" class="btn btn-sm btn-hover-blue" data-toggle="tooltip" title="" data-original-title="저장" onclick="fn_updateNetSwtch();"><i class="fa fa-check"></i></button>
				</menu:authorize>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		$('#netSwtchTable > tbody > tr ').each(function(){
			vmInst.push([$(this).find('input[data-name="netSwtchListVmSeq"]').val(), $(this).find('input[data-name="netSwtchListInstitutionId"]').val()]);
		});
	});

	var vmInst = [];
	var compVmInst = [];

	var row = 0;
	// 페이징 이동
	function fn_goPage(page){
		location.href = "<c:url value='selectNetSwtchList.do?paginationInfo.currentPageNo=" + page + "&${listParam}'/>";
	}

	// 검색조건 초기화
	function fn_reset() {

		$("#searchVo input[type='text']").val("");
		$("#searchVo select").val("").attr("selected", "selected");
	}

	// 부처별 L3/L4 목록조회
	function fn_selectNetSwtchList(){
		vmInst = [];

		$("#searchVo").attr("action", "selectNetSwtchList.do");
		$("#searchVo").submit();
	}

	function test(index){
		row = index;
		openInsttSearch();
	}

	$(document).bind('selectInstitution',setInstitution);
	function setInstitution(evt) {
		var val = evt.datas;

		$('#netSwtchTable input[name="institutionNm'+row+'"]').val(val.institutionNm);
		$('#netSwtchTable input[name="netSwtchList['+row+'].institutionId"]').val(val.institutionId);
	}

	// 부처수정 처리
	function fn_updateNetSwtch() {

		var bool = false;

		$('#netSwtchTable > tbody > tr ').each(function(){
			compVmInst.push([$(this).find('input[data-name="netSwtchListVmSeq"]').val(), $(this).find('input[data-name="netSwtchListInstitutionId"]').val()]);
		});

		$.each(vmInst, function(index, item){
			$.each(compVmInst, function(compIndex, compItem){
				if(item[0] == compItem[0]){
					if(item[1] != compItem[1]){
						bool = true;
					}
				}
			});
		});

		var options = {
			type: 'post',
			dataType: 'json',
			success: fn_updateNetSwtchCallBack,
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

		if(bool){
			jConfirm("부처별 L3/L4 정보를 저장하시겠습니까?", function(){
				$('#vo').attr("action", "updateNetSwtch.do");
				$('#vo').ajaxSubmit(options);
			});
		}else{
			jAlert("수정된 내역이 없습니다.");
		}
	}

	// 사용/미사용 콜백
	function fn_updateNetSwtchCallBack(result){

		if(result.success){
			jAlert("적용되었습니다.", function(){
				if(result.procType == "update") {
					location.reload();
				}
			});
		}else{
			jAlert(result.messageList);
			vmInst = [];
			compVmInst = [];
		}
	}

	// 리스트 테이블 정렬
	$("#netSwtchTable").DataTable( {
		dom: 'Zlfrtip' ,
		paging : false,
		searching : false,
		info : false,
		bAutoWidth : false,
		aoColumns : [
					{sWidth : "30px" },
					{sWidth : "70px" },
					{sWidth : "210px" },
					{sWidth : "211px" },
					{sWidth : "200px" }
					],
		order : [[0, "desc"]]
	} );
</script>